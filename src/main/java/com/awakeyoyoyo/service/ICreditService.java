package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;

public interface ICreditService {
    ServerResponse getPersonCredit(String openId);

    ServerResponse getAllCredit(int pageNum,int pageSize);

    ServerResponse doEstimate(String openId, String dopenId, String estimatedo_code,Long orderNo,String mxg);
}
