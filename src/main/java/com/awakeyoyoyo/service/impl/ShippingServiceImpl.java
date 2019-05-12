package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.dao.ShippingMapper;
import com.awakeyoyoyo.entity.Shipping;
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
    @Override
    public ServerResponse add(Integer userId, Shipping shipping) {
       shipping.setUserId(userId);
       int rowcount=shippingMapper.insert(shipping);
       if (rowcount>0){
           return ServerResponse.createBySuccess();
       }
       return ServerResponse.createByErrorMessage("新增地址失败");
    }

    @Override
    public ServerResponse delete(Integer userId, Integer shippingId) {
        int rowcount=shippingMapper.deleteByUserIdShippingId(userId,shippingId);
        if (rowcount>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }

    @Override
    public ServerResponse update( Shipping shipping) {

        int rowcount=shippingMapper.updateByPrimaryKeySelective(shipping);
        if (rowcount>0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("修改地址失败");
    }

    @Override
    public ServerResponse<PageInfo> selectByUserId(Integer userId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shipping> shippingList=shippingMapper.selectByUserId(userId);
        PageInfo pageInfo=new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse selectByUserIdShippingId(Integer userId, Integer shippingId) {
        Shipping shipping=shippingMapper.selectByUserIdShippingId(userId,shippingId);
       return  ServerResponse.createBySuccess(shipping);
    }
}
