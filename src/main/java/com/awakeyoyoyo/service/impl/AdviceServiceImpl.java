package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.dao.AdviceMapper;
import com.awakeyoyoyo.dao.ChargeMapper;
import com.awakeyoyoyo.entity.Advice;
import com.awakeyoyoyo.entity.Charge;
import com.awakeyoyoyo.service.IAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("iAdviceService")
public class AdviceServiceImpl implements IAdviceService{
    @Autowired
    private AdviceMapper adviceMapper;
    @Autowired
    private ChargeMapper chargeMapper;
    @Override
    public ServerResponse add(String mxg) {
        Advice advice=new Advice();
        advice.setCreateTime(new Date());
        advice.setAdviceMxg(mxg);
        if (adviceMapper.insertSelective(advice)>=1){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("新增通知失败");
    }

    @Override
    public ServerResponse delete(Integer id) {
       if (adviceMapper.deleteByPrimaryKey(id)>=1)
       {
           return ServerResponse.createBySuccess();
       }
       return ServerResponse.createByErrorMessage("删除通知失败");
    }

    @Override
    public ServerResponse getAdvice(String openId) {
        List<Advice> adviceList=adviceMapper.selectByOpenId(openId);
        List<Charge> chargeList=chargeMapper.selectByOpenId(openId);
        Map<String,List> allAdvice=new HashMap<>();
        allAdvice.put("advice",adviceList);
        allAdvice.put("charge",chargeList);
        return ServerResponse.createBySuccess(allAdvice);
    }

    @Override
    public ServerResponse getAdvices() {
        List<Advice> adviceList=adviceMapper.selectByOpenId("1000");
        return ServerResponse.createBySuccess(adviceList);
    }

    @Override
    public ServerResponse oldAdvice(Integer[] ids) {
        for (Integer x:ids) {
            Advice advice =new Advice();
            advice.setId(x);
            advice.setStatus(1);
            adviceMapper.updateByPrimaryKeySelective(advice);
        }
        return ServerResponse.createBySuccess();
    }
}
