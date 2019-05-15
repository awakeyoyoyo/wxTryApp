package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;

public interface IUserService {
    ServerResponse login(String js_code);
}
