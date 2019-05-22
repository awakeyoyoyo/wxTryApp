package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;

public interface ICreditService {
    ServerResponse getPersonCredit(Integer openId);

    ServerResponse getAllCredit(int pageNum,int pageSize);
}
