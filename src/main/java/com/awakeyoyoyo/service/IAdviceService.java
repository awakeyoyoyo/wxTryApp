package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;

public interface IAdviceService {

    ServerResponse add(String mxg);

    ServerResponse delete(Integer id);

    ServerResponse getAdvice(String openId);

    ServerResponse getAdvices();

    ServerResponse oldAdvice(Integer[] ids);
}
