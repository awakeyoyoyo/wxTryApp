package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.OrderStatusCode;
import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.dao.OrderItemMapper;

import com.awakeyoyoyo.dao.UserMapper;
import com.awakeyoyoyo.dao.WxorderMapper;

import com.awakeyoyoyo.entity.OrderItem;
import com.awakeyoyoyo.entity.Shipping;
import com.awakeyoyoyo.entity.Wxorder;
import com.awakeyoyoyo.service.IOrderService;
import com.awakeyoyoyo.utils.DateUtils;
import com.awakeyoyoyo.vo.OrderVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private WxorderMapper wxorderMapper;
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
            item.setUserId(orderVo.getUserId());
            //添加订单号
            item.setOrderNo(orderNo);
            rowcount= orderItemMapper.insert(item);
            if (rowcount<=0){
                return  ServerResponse.createByErrorMessage("新建订单失败");
            }
        }
        //插入数据库
        Wxorder order=new Wxorder();
        order.setCreateTime(new Date());
        order.setOrderMxg(orderVo.getOrderMxg());
        order.setOrderType(orderVo.getOrderType());
        order.setShippingId(orderVo.getShippingId());
        order.setOverTime(DateUtils.StrToDate(orderVo.getOverTime()));
        order.setPrice(orderVo.getPrice());
        order.setTakeAddress(orderVo.getTakeAddress());
        order.setUserId(orderVo.getUserId());
        order.setStatus(OrderStatusCode.UnAccept.getCode());
        rowcount=wxorderMapper.insert(order);
        if (rowcount<=0){
            return ServerResponse.createByErrorMessage("新建订单失败");
        }
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse acceptOrder(Long orderNo, Integer duserId) {
        //检测用户是否存在以及是否含有权力
        int rowcount=userMapper.checkByPrimaryKey(duserId);
        if (rowcount<=0){
            return  ServerResponse.createByErrorMessage("错误用户id");
        }
            Wxorder order=wxorderMapper.selectByPrimaryKey(orderNo);
        if (order==null){
            return ServerResponse.createByErrorMessage("错误的订单号");
        }
        //判断订单的信息
        if (order.getStatus()!=OrderStatusCode.UnAccept.getCode()){
            return ServerResponse.createByErrorMessage("该订单不可接");
        }
       //判断是否超时
        order.setStatus(OrderStatusCode.IsAccept.getCode());
        order.setDuserId(duserId);
        order.setAcceptTime(new Date());
        rowcount=wxorderMapper.updateByPrimaryKeySelective(order);
        if (rowcount<=0){
            return ServerResponse.createByErrorMessage("接单失败");
        }
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse cancelOrder(Long orderNo, Integer userId) {

        int rowcount=wxorderMapper.checkOrderByUserIdOrderNo(userId, orderNo);
        if (rowcount<=0){
            return ServerResponse.createByErrorMessage("传错误参数");
        }
        Wxorder order=new Wxorder();
        order.setStatus(OrderStatusCode.Canceled.getCode());
        order.setOrderNo(orderNo);
        rowcount=wxorderMapper.updateByPrimaryKeySelective(order);
        if (rowcount<=0){
            return ServerResponse.createByErrorMessage("取消订单失败");
        }
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse<PageInfo> lists(int pageNum, int pageSize,String type,String str) {
        PageHelper.startPage(pageNum,pageSize);
      //获取全部订单list
        if (type==null){
        List<Wxorder> orderList=wxorderMapper.selectByStatus(OrderStatusCode.UnAccept.getCode());
        PageInfo pageInfo=new PageInfo(orderList);
        return ServerResponse.createBySuccess(pageInfo);
        }
        //获取该用户的订单
        if (type.equals("user")){
            List<Wxorder> orderList=wxorderMapper.selectByUserId(Integer.parseInt(str));
            PageInfo pageInfo=new PageInfo(orderList);
            return ServerResponse.createBySuccess(pageInfo);
        }
        //获取该用户所接的单
        if (type.equals("duser")){
            List<Wxorder> orderList=wxorderMapper.selectByDUserId(Integer.parseInt(str));
            PageInfo pageInfo=new PageInfo(orderList);
            return ServerResponse.createBySuccess(pageInfo);
        }
        if (type.equals("type")){
            List<Wxorder> orderList=wxorderMapper.selectByType(Integer.parseInt(str));
            PageInfo pageInfo=new PageInfo(orderList);
            return ServerResponse.createBySuccess(pageInfo);
        }
        return ServerResponse.createByErrorMessage("获取订单信息失败");
    }

    public Long getOrderIdByTime(Integer userId) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHH");
        String newDate=sdf.format(new Date());
        String result="";
         Random random=new Random();
            for(int i=0;i<3;i++){
            result+=random.nextInt(10);
            }
            return  Long.parseLong(newDate+userId+result);
    }

}
