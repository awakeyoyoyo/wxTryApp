package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.entity.Shipping;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IShippingService {
    ServerResponse add(Integer openId, Shipping shipping);

    ServerResponse delete(Integer openId, Integer shippingId);

    ServerResponse update(Shipping shipping);

    ServerResponse<PageInfo> selectByOpenId(Integer openId,int pageNum,int pageSize);

    ServerResponse selectByOpenIdShippingId(Integer openId, Integer shippingId);

    ServerResponse selectMainShippingByopenId(Integer openId);

    ServerResponse upadateMainShippingByopenId(Integer openId, Integer shippingId);
}
