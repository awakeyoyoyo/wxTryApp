package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.common.UserSexCode;
import com.awakeyoyoyo.common.UserStatusCode;
import com.awakeyoyoyo.dao.AdviceMapper;
import com.awakeyoyoyo.dao.CreditMapper;
import com.awakeyoyoyo.dao.UserMapper;
import com.awakeyoyoyo.entity.Advice;
import com.awakeyoyoyo.entity.Credit;
import com.awakeyoyoyo.entity.User;
import com.awakeyoyoyo.service.IUserService;
import com.awakeyoyoyo.service.IWxService;
import com.awakeyoyoyo.utils.Constant;
import com.awakeyoyoyo.utils.JWTUtils;
import com.awakeyoyoyo.vo.WxUserVo;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IWxService wxService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CreditMapper creditMapper;
    @Autowired
    private AdviceMapper adviceMapper;
    @Override
    public ServerResponse login(String js_code,String token1) {
//        System.out.println("nick="+userVo.getNickName());
//        System.out.println("sex="+userVo.getGender());
        if (null!=token1) {
            //解析token
            Claims claims = null;
            try {
                claims = JWTUtils.parseJWT(token1);

            } catch (Exception e) {
                return ServerResponse.createByErrorMessage("身份认证失败");
            }
            String openId1 = claims.get("open_id", String.class);
            if (null != openId1) {
                //查询数据库
                int rowcount = userMapper.checkByPrimaryKey(openId1);
                if (rowcount >= 1) {
                    return ServerResponse.createBySuccess(token1);
                }
                return ServerResponse.createByErrorMessage("身份认证失败");
            }
        }
        //http请求去wx后台

        Map<String,String> result=wxService.Wxlogin(js_code);
        if (result.get("open_id")==null||result.get("open_id").isEmpty()){
           return ServerResponse.createByErrorMessage("登陆失败重新打开");
        }
        //返回一个openid
        System.out.println("openid="+result.get("open_id"));
        String openId=result.get("open_id");
        //入k库
        if (userMapper.selectByPrimaryKey(openId)==null)
        {
            User user=new User();
            user.setOpenId(openId);
            //微信的一些数据
//            user.setUserName(userVo.getNickName());
//            switch(userVo.getGender()){
//                case 0 :
//                    user.setUserSex(UserSexCode.NOSEE.getDesc());
//                    break; //可选
//                case 1 :
//                    user.setUserSex(UserSexCode.MAN.getDesc());
//                    break; //可选
//                case 2 :
//                    user.setUserSex(UserSexCode.WOMEN.getDesc());
//                    break; //可选
//            }
            userMapper.insert(user);
            Credit credit=new Credit();
            credit.setOpenId(openId);
            if (creditMapper.selectByOpenID(openId)<=0)
            {
                creditMapper.insert(credit);
            }
        }
        //token
        String token="";
        try {
            token=JWTUtils.createJWT(result.get("open_id"), Constant.JWT_TTL);
        } catch (Exception e) {
            ServerResponse.createByErrorMessage("生成Token失败");
            e.printStackTrace();
        }
        //返回token
        return  ServerResponse.createBySuccess(token);
    }

    @Override
    public ServerResponse getInformation(String openId) {
       User user=userMapper.selectByPrimaryKey(openId);
       if (user==null){
           return ServerResponse.createByErrorMessage("传入错误参数");
       }
       return ServerResponse.createBySuccess(user);
    }

    @Override
    public ServerResponse updateInformation(User user) {
        if (user==null){
            return ServerResponse.createByErrorMessage("更新信息失败");
        }
       int rowcount= userMapper.updateByPrimaryKeySelective(user);
       if (rowcount<=0){
           return ServerResponse.createByErrorMessage("更新信息失败");
       }
       return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse ggUser(String openId) {
        if (openId==null||userMapper.checkByPrimaryKey(openId)<=0){
            return ServerResponse.createByErrorMessage("传入错误参数或为传参");
        }
        User user=new User();
        user.setOpenId(openId);
        user.setUserStatus(UserStatusCode.FREEZE.getCode());
        if (userMapper.updateByPrimaryKeySelective(user)<=0)
        {
            return ServerResponse.createByErrorMessage("冻结用户失败");
        }

        //发送通知 你被冻结了
        Advice advice=new Advice();
        advice.setCreateTime(new Date());
        advice.setAdviceMxg("您的账号被冻结了");
        advice.setOpenId(openId);
        adviceMapper.insertSelective(advice);
        return ServerResponse.createBySuccess();
    }
}
