package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.entity.Shipping;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IShippingService {
    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse delete(Integer userId, Integer shippingId);

    ServerResponse update(Shipping shipping);

    ServerResponse<PageInfo> selectByUserId(Integer userId,int pageNum,int pageSize);

    ServerResponse selectByUserIdShippingId(Integer userId, Integer shippingId);
}
