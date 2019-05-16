package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;

import java.util.Map;

public interface IWxService {
  Map<String,String> Wxlogin(String js_code);
}
