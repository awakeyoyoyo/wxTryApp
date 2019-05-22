package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.dao.CreditMapper;
import com.awakeyoyoyo.entity.Credit;
import com.awakeyoyoyo.entity.Order;
import com.awakeyoyoyo.service.ICreditService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iCreditService")
public class CreditService implements ICreditService {
    @Autowired
    private CreditMapper creditMapper;
    @Override
    public ServerResponse getPersonCredit(Integer openId) {
        Credit credit=creditMapper.selectByOpenId(openId);
        return ServerResponse.createBySuccess(credit);
    }

    @Override
    public ServerResponse<PageInfo> getAllCredit(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Credit> credits=creditMapper.selectAll();
        PageInfo pageInfo=new PageInfo(credits);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
