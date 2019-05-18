package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.OrderStatusCode;
import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.dao.OrderItemMapper;

import com.awakeyoyoyo.dao.OrderMapper;
import com.awakeyoyoyo.dao.UserMapper;


import com.awakeyoyoyo.entity.Order;
import com.awakeyoyoyo.entity.OrderItem;


import com.awakeyoyoyo.service.IOrderService;
import com.awakeyoyoyo.utils.DateUtils;
import com.awakeyoyoyo.vo.OrderVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @Override
    public ServerResponse add(OrderVo orderVo) {
        if (orderVo.getOrderItemList().isEmpty()){
            return  ServerResponse.createByErrorMessage("没有商品");
        }
        if (orderVo.getUserId()==null){
            return  ServerResponse.createByErrorMessage("没传入用户id");
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
    public ServerResponse acceptOrder(Long orderNo, Integer dopenId) {
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
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse cancelOrder(Long orderNo, Integer openId) {

        int rowcount=orderMapper.checkOrderByOpenIdOrderNo(openId, orderNo);
        if (rowcount<=0){
            return ServerResponse.createByErrorMessage("传错误参数");
        }
        Order order=new Order();
        order.setStatus(OrderStatusCode.Canceled.getCode());
        order.setOrderNo(orderNo);
        rowcount=orderMapper.updateByPrimaryKeySelective(order);
        if (rowcount<=0){
            return ServerResponse.createByErrorMessage("取消订单失败");
        }
        /*用户的取消订单数+1 不管他是接单还是发布的那个且//todo*/
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse<PageInfo> lists(int pageNum, int pageSize,String type,String str) {
        PageHelper.startPage(pageNum,pageSize);
      //获取全部订单list
        if (type==null){
        List<Order> orderList=orderMapper.selectByStatus(OrderStatusCode.UnAccept.getCode());
        PageInfo pageInfo=new PageInfo(orderList);
        return ServerResponse.createBySuccess(pageInfo);
        }
        //获取该用户的订单
        if (type.equals("user")){
            List<Order> orderList=orderMapper.selectByUserId(Integer.parseInt(str));
            PageInfo pageInfo=new PageInfo(orderList);
            return ServerResponse.createBySuccess(pageInfo);
        }
        //获取该用户所接的单
        if (type.equals("duser")){
            List<Order> orderList=orderMapper.selectByDUserId(Integer.parseInt(str));
            PageInfo pageInfo=new PageInfo(orderList);
            return ServerResponse.createBySuccess(pageInfo);
        }
        if (type.equals("type")){
            List<Order> orderList=orderMapper.selectByType(Integer.parseInt(str));
            PageInfo pageInfo=new PageInfo(orderList);
            return ServerResponse.createBySuccess(pageInfo);
        }
        return ServerResponse.createByErrorMessage("获取订单信息失败");
    }

    @Override
    public ServerResponse orderItemlists(Integer openId,Long orderNo) {
       int rowcount= orderMapper.checkOrderByUserIdOrderNo(openId,orderNo);
       if (rowcount<=0){
           return ServerResponse.createByErrorMessage("没有该订单");
       }
        List<OrderItem> orderItems=orderItemMapper.selectByOrderNo(orderNo);
       if (orderItems==null){
         return   ServerResponse.createByErrorMessage("该订单没有货物");
       }
     return   ServerResponse.createBySuccess(orderItems);
    }

    public Long getOrderIdByTime(Integer openId) {
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
