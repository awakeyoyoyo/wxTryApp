package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.*;

import com.awakeyoyoyo.dao.*;


import com.awakeyoyoyo.entity.*;


import com.awakeyoyoyo.service.IOrderService;
import com.awakeyoyoyo.utils.DateUtils;
import com.awakeyoyoyo.vo.OrderVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;



@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CreditMapper creditMapper;
    @Autowired
    private AdviceMapper adviceMapper;
    @Override
    public ServerResponse add(OrderVo orderVo) {
        if (orderVo.getOrderItemList().isEmpty()){
            return  ServerResponse.createByErrorMessage("没有商品");
        }
        if (orderVo.getUserId()==null){
            return  ServerResponse.createByErrorMessage("没传入用户id");
        }
        if (orderVo.getShippingId()==null){
            return  ServerResponse.createByErrorMessage("没传入收货地址");
        }
        //新建订单号
        Long orderNo=getOrderIdByTime(orderVo.getUserId());
        orderVo.setOrderNo(orderNo);

        //新建每一个产品
        int rowcount;
        for (OrderItem item:orderVo.getOrderItemList()) {
            //添加userId
            item.setOpenId(orderVo.getUserId());
            //添加订单号
            item.setOrderNo(orderNo);
            rowcount= orderItemMapper.insert(item);
            if (rowcount<=0){
                return  ServerResponse.createByErrorMessage("新建订单失败");
            }
        }
        //插入数据库
        Order order=new Order();
        order.setOrderNo(orderNo);
        order.setCreateTime(new Date());
        order.setOrderMxg(orderVo.getOrderMxg());
        order.setOrderType(orderVo.getOrderType());
        order.setShippingId(orderVo.getShippingId());
        order.setOverTime(DateUtils.StrToDate(orderVo.getOverTime()));
        order.setPrice(orderVo.getPrice());
        order.setTakeAddress(orderVo.getTakeAddress());
        order.setOpenId(orderVo.getUserId());
        order.setStatus(OrderStatusCode.UnAccept.getCode());
        rowcount=orderMapper.insert(order);
        if (rowcount<=0){
            return ServerResponse.createByErrorMessage("新建订单失败");
        }
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse acceptOrder(Long orderNo, String dopenId) {
        //检测用户是否存在以及是否含有权力
        int rowcount=userMapper.checkByPrimaryKey(dopenId);
        if (rowcount<=0){
            return  ServerResponse.createByErrorMessage("错误用户id");
        }
            Order order=orderMapper.selectByPrimaryKey(orderNo);
        if (order==null){
            return ServerResponse.createByErrorMessage("错误的订单号");
        }
        //判断订单的信息
        if (order.getStatus()!=OrderStatusCode.UnAccept.getCode()){
            return ServerResponse.createByErrorMessage("该订单不可接");
        }
       //判断是否超时
        if (order.getOverTime()!=null){
        if (order.getOverTime().getTime()<new Date().getTime()){
            //超过接单时间
            return ServerResponse.createByErrorMessage("该订单超过最后接单时间");
        }
        }
        order.setStatus(OrderStatusCode.IsAccept.getCode());
        order.setDuserId(dopenId);
        order.setAcceptTime(new Date());
        rowcount=orderMapper.updateByPrimaryKeySelective(order);
        if (rowcount<=0){
            return ServerResponse.createByErrorMessage("接单失败");
        }
        User user=userMapper.selectByPrimaryKey(dopenId);
        //通知订单被接单了
        Order order1 =orderMapper.selectByPrimaryKey(orderNo);
        Advice advice=new Advice();
        advice.setCreateTime(new Date());
        advice.setAdviceMxg("您的订单:"+order.getOrderNo()+"+被接单了");
        advice.setOpenId(order1.getOpenId());
        adviceMapper.insertSelective(advice);
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse cancelOrder(Long orderNo, String userId,Integer who) {
        if (who== UserTypeCode.USER.getCode()) {
            //用户取消自己发布的单
            int rowcount = orderMapper.checkOrderByOpenIdOrderNo(userId, orderNo);
            if (rowcount <= 0) {
                return ServerResponse.createByErrorMessage("传错误参数");
            }
            Order order = new Order();
            order.setStatus(OrderStatusCode.Canceled.getCode());
            order.setOrderNo(orderNo);
            rowcount = orderMapper.updateByPrimaryKeySelective(order);
            if (rowcount <= 0) {
                return ServerResponse.createByErrorMessage("取消订单失败");
            }
            /*用户的取消订单数+1 不管他是接单还是发布的那个且,用户信用分数-1*/
            //减信用分
            creditMapper.ReduceUserCrediByuserId(userId);
            //加强制取消订单次数
            creditMapper.addCancelByuserId(userId);
        }
        if (who==UserTypeCode.DUSER.getCode()){
            int rowcount = orderMapper.checkOrderByDOpenIdOrderNo(userId, orderNo);
            if (rowcount <= 0) {
                return ServerResponse.createByErrorMessage("传错误参数");
            }
            Order order = new Order();
            order.setStatus(OrderStatusCode.Canceled.getCode());
            order.setOrderNo(orderNo);
            rowcount = orderMapper.updateByPrimaryKeySelective(order);
            if (rowcount <= 0) {
                return ServerResponse.createByErrorMessage("取消订单失败");
            }
            //用户的取消订单数+1 不管他是接单还是发布的那个且
            creditMapper.ReduceUserCrediByuserId(userId);
            //加强制取消订单次数
            creditMapper.addCancelByuserId(userId);
            //通知订单被取消了
            Order order1 =orderMapper.selectByPrimaryKey(orderNo);
            Advice advice=new Advice();
            advice.setCreateTime(new Date());
            advice.setAdviceMxg("您的订单:"+order.getOrderNo()+"被强制取消了");
            advice.setOpenId(order1.getOpenId());
            adviceMapper.insertSelective(advice);
        }

        return ServerResponse.createByErrorMessage("传入错误参数");
    }

    @Override
    public ServerResponse<PageInfo> lists(int pageNum, int pageSize,String type,String str,String openId) {
        PageHelper.startPage(pageNum,pageSize);
      //获取全部订单list
        if (type==null){
        List<Order> orderList=orderMapper.selectByStatus(OrderStatusCode.UnAccept.getCode());
        PageInfo pageInfo=new PageInfo(orderList);
        return ServerResponse.createBySuccess(pageInfo);
        }
        //获取该用户的订单
        if (type.equals("user")){
            List<Order> orderList=orderMapper.selectByOpenId(openId);
            PageInfo pageInfo=new PageInfo(orderList);
            return ServerResponse.createBySuccess(pageInfo);
        }
        //获取该用户所接的单
        if (type.equals("duser")){
            List<Order> orderList=orderMapper.selectByDOpenId(openId);
            PageInfo pageInfo=new PageInfo(orderList);
            return ServerResponse.createBySuccess(pageInfo);
        }
        if (type.equals("type")){

            switch (Integer.parseInt(str)){
                case Const.OrderType.QUJIAN:
                    str=OrderTypeCode.QUJIAN.getDesc();
                    break;
                case Const.OrderType.YAOPING:
                    str=OrderTypeCode.YAOPING.getDesc();
                    break;
                case Const.OrderType.PAOTUI:
                    str=OrderTypeCode.PAOTUI.getDesc();
                    break;
                case Const.OrderType.CHAOSHI:
                    str=OrderTypeCode.CHAOSHI.getDesc();
                    break;
                case Const.OrderType.MEISHI:
                    str=OrderTypeCode.MEISHI.getDesc();
                    break;
                case Const.OrderType.YINPING:
                    str=OrderTypeCode.YINPING.getDesc();
                    break;
                case Const.OrderType.SHUIGUO:
                    str=OrderTypeCode.SHUIGUO.getDesc();
                    break;
                case Const.OrderType.GAODIAN:
                    str=OrderTypeCode.GAODIAN.getDesc();
                    break;
            }
            List<Order> orderList=orderMapper.selectByTypeStatus(str,OrderStatusCode.UnAccept.getCode());
            PageInfo pageInfo=new PageInfo(orderList);
            return ServerResponse.createBySuccess(pageInfo);
        }
        return ServerResponse.createByErrorMessage("获取订单信息失败");
    }

    @Override
    public ServerResponse orderItemlists(String openId,Long orderNo) {
       int rowcount= orderMapper.checkOrderByOpenIdOrderNo(openId,orderNo);
       if (rowcount<=0){
           return ServerResponse.createByErrorMessage("没有该订单");
       }
        List<OrderItem> orderItems=orderItemMapper.selectByOrderNo(orderNo);
       if (orderItems==null){
         return   ServerResponse.createByErrorMessage("该订单没有货物");
       }
     return   ServerResponse.createBySuccess(orderItems);
    }

    @Override
    public ServerResponse orderFinish(String openId, Long orderNo) {
        int rowcount= orderMapper.checkOrderByOpenIdOrderNo(openId,orderNo);
        if (rowcount<=0){
            return ServerResponse.createByErrorMessage("没有该订单");
        }
        Order order=new Order();
        order.setOpenId(openId);
        order.setOrderNo(orderNo);
        order.setStatus(OrderStatusCode.FINLISH.getCode());
        orderMapper.updateByPrimaryKeySelective(order);

        //完成订单数++++
        order =orderMapper.selectByPrimaryKey(orderNo);
        creditMapper.addOrderByuserId(order.getDuserId());
        creditMapper.addOrderByuserId(order.getOpenId());
        return  ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse orderAddTime(String openId, Long orderNo) {
        Order order=new Order();
        long currentTime = System.currentTimeMillis() + 30 * 60 * 1000;
        Date date = new Date(currentTime);
        order.setOverTime(date);
        order.setOrderNo(orderNo);
        order.setOpenId(openId);
        orderMapper.updateByPrimaryKeySelective(order);
        return ServerResponse.createBySuccess();
    }

    public Long getOrderIdByTime(String openId) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHH");
        String newDate=sdf.format(new Date());
        String result="";
         Random random=new Random();
            for(int i=0;i<3;i++){
            result+=random.nextInt(10);
            }
            return  Long.parseLong(newDate+openId+result);
    }

}
