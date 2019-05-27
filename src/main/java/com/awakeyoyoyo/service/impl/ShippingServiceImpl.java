package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.dao.ShippingMapper;
import com.awakeyoyoyo.dao.UserMapper;
import com.awakeyoyoyo.entity.Shipping;
import com.awakeyoyoyo.entity.User;
import com.awakeyoyoyo.service.IShippingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {
    @Autowired
    private ShippingMapper shippingMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public ServerResponse add(String openId, Shipping shipping) {
        System.out.println(openId);
       shipping.setOpenId(openId);
       int rowcount=shippingMapper.insert(shipping);
       if (rowcount>0){
           return ServerResponse.createBySuccess();
       }
       return ServerResponse.createByErrorMessage("新增地址失败");
    }

    @Override
    public ServerResponse delete(String openId, Integer shippingId) {
        int rowcount=shippingMapper.deleteByOpenIdShippingId(openId,shippingId);
        if (rowcount>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }

    @Override
    public ServerResponse update(Shipping shipping) {

        int rowcount=shippingMapper.updateByPrimaryKeySelective(shipping);

        if (rowcount>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("修改地址失败");
    }

    @Override
    public ServerResponse selectByOpenId(String openId) {
        List<Shipping> shippingList=shippingMapper.selectByOpenId(openId);

        return ServerResponse.createBySuccess(shippingList);
    }

    @Override
    public ServerResponse selectByOpenIdShippingId(String openId, Integer shippingId) {
        Shipping shipping=shippingMapper.selectByOpenIdShippingId(openId,shippingId);
       return  ServerResponse.createBySuccess(shipping);
    }

    @Override
    public ServerResponse selectMainShippingByopenId(String openId) {
        if(openId==null||userMapper.checkByPrimaryKey(openId)<=0){
            return ServerResponse.createByErrorMessage("没有此用户");
        }
        Integer shippingId=userMapper.selectMainShippingIdByopenId(openId);
        if (shippingId==null){
           return ServerResponse.createBySuccess();
        }
        Shipping shipping=shippingMapper.selectByPrimaryKey(shippingId);
//        if (shipping==null){
//            return ServerResponse.createBySuccess();
//        }
        return ServerResponse.createBySuccess(shipping);
    }

    @Override
    public ServerResponse upadateMainShippingByopenId(String openId, Integer shippingId) {
        if(openId==null||userMapper.checkByPrimaryKey(openId)<=0){
            return ServerResponse.createByErrorMessage("没有此用户");
        }
        User user=new User();
        user.setOpenId(openId);
        user.setUserShippingid(shippingId);
        if (userMapper.updateByPrimaryKeySelective(user)>=1){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("更新主地址失败");
    }
}
