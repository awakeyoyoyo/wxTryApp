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
    private UserMapper userMapper;
    @Override
    public ServerResponse add(Integer openId, Shipping shipping) {
       shipping.setOpenId(openId);
       int rowcount=shippingMapper.insert(shipping);
       if (rowcount>0){
           return ServerResponse.createBySuccess();
       }
       return ServerResponse.createByErrorMessage("新增地址失败");
    }

    @Override
    public ServerResponse delete(Integer openId, Integer shippingId) {
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
    public ServerResponse<PageInfo> selectByOpenId(Integer openId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shipping> shippingList=shippingMapper.selectByOpenId(openId);
        PageInfo pageInfo=new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse selectByOpenIdShippingId(Integer openId, Integer shippingId) {
        Shipping shipping=shippingMapper.selectByOpenIdShippingId(openId,shippingId);
       return  ServerResponse.createBySuccess(shipping);
    }

    @Override
    public ServerResponse selectMainShippingByopenId(Integer openId) {
        if(openId==null||userMapper.checkByPrimaryKey(openId)<=0){
            return ServerResponse.createByErrorMessage("没有此用户");
        }
        Integer shippingId=userMapper.selectMainShippingIdByopenId(openId);
        if (shippingId==null){
           return ServerResponse.createBySuccess();
        }
        Shipping shipping=shippingMapper.selectByPrimaryKey(shippingId);
        return ServerResponse.createBySuccess(shipping);
    }

    @Override
    public ServerResponse upadateMainShippingByopenId(Integer openId, Integer shippingId) {
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
