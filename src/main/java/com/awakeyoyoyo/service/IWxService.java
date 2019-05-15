package com.awakeyoyoyo.service;

import java.util.Map;

public interface IWxService {
    Map<String,String> Wxlogin(String js_code);
}
