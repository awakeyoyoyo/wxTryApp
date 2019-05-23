package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.entity.Shipping;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IShippingService {
    ServerResponse add(String openId, Shipping shipping);

    ServerResponse delete(String openId, Integer shippingId);

    ServerResponse update(Shipping shipping);

    ServerResponse<PageInfo> selectByOpenId(String openId,int pageNum,int pageSize);

    ServerResponse selectByOpenIdShippingId(String openId, Integer shippingId);

    ServerResponse selectMainShippingByopenId(String openId);

    ServerResponse upadateMainShippingByopenId(String openId, Integer shippingId);
}
