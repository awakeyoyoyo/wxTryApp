package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.EstimateCode;
import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.dao.AdviceMapper;
import com.awakeyoyoyo.dao.ChargeMapper;
import com.awakeyoyoyo.dao.CreditMapper;
import com.awakeyoyoyo.dao.OrderMapper;
import com.awakeyoyoyo.entity.Advice;
import com.awakeyoyoyo.entity.Charge;
import com.awakeyoyoyo.entity.Credit;
import com.awakeyoyoyo.entity.Order;
import com.awakeyoyoyo.service.ICreditService;
import com.awakeyoyoyo.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("iCreditService")
public class CreditService implements ICreditService {
    @Autowired
    private CreditMapper creditMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AdviceMapper adviceMapper;
    @Autowired
    private ChargeMapper chargeMapper;
    @Autowired
    private IUserService userService;
    @Override
    public ServerResponse getPersonCredit(String openId) {
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

    @Override
    public ServerResponse doEstimate(String openId, String dopenId, String estimatedo_code,Long orderNo,String mxg) {
        //查询两个id和订单号是否有订单
        if (orderMapper.checkOrderByOpenIdOrderNoDopenId(openId,dopenId,orderNo)<=0){
            return ServerResponse.createByErrorMessage("错误订单信息");
        }
        if (estimatedo_code== EstimateCode.GOOD.getDesc()){
            creditMapper.addUserCreditByuserId(dopenId);
        }
      else {
            //投诉
            creditMapper.addUserCreditByuserId(dopenId);
            Charge charge=new Charge();
            charge.setChargeMxg(mxg);
            charge.setCreateTime(new Date());
            charge.setDpoenId(dopenId);
            charge.setOpenId(openId);
            chargeMapper.insertSelective(charge);
            //插入通知
            Advice advice=new Advice();
            advice.setCreateTime(new Date());
            advice.setAdviceMxg("您收到了一个投诉");
            advice.setOpenId(dopenId);
            adviceMapper.insertSelective(advice);
            //
            userService.ggUser(dopenId);
        }
        return ServerResponse.createBySuccess();
    }
}
