package com.awakeyoyoyo.Interceptor;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.common.UserStatusCode;
import com.awakeyoyoyo.dao.UserMapper;
import com.awakeyoyoyo.entity.User;
import com.awakeyoyoyo.service.IUserService;
import com.awakeyoyoyo.utils.JWTUtils;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class UserdoInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object o) throws Exception {
    //   Request.getParameter("openid");
    //    String token=Request.getHeader("token");
    //    Claims claims= JWTUtils.parseJWT(token);
     //   String openid=claims.get("openid",String.class);
        String openid=Request.getParameter("openid");
        //数据库查询用户状态
        //查询用户信息是否完整
        //todo
        User user=userMapper.selectByPrimaryKey(Integer.parseInt(openid));
        //iUserService.checkUserStatus(openid);
//        if (openid!=null&&iUserService.checkUserStatus(openid)){
//            return true;
//        }
        if (user.getUserStatus()== UserStatusCode.FREEZE.getCode()){
        Response.reset();
        Response.setCharacterEncoding("UTF-8");
        Response.setContentType("application/json;charset=UTF-8");
        ServerResponse sr=ServerResponse.createByErrorMessage("用户被冻结");
        Gson gson=new Gson();
        PrintWriter pw = Response.getWriter();
        pw.write(gson.toJson(sr));
        pw.flush();
        pw.close();
        return false;//不放行
        }
        boolean mxgtrue=false;
      if ( null!=user.getUserBuilding())
        if (null != user.getUserCollege())
        if (null != user.getUserDomitory())
            if (null != user.getUserWx())
            if (null != user.getUserName())
            if (null != user.getUserPhone())
            if (null != user.getUserProfession())
            if (null != user.getUserNumber())
                if (null != user.getUserSex())
                    mxgtrue=true;
      if (mxgtrue){
          return true;
      }
        Response.reset();
        Response.setCharacterEncoding("UTF-8");
        Response.setContentType("application/json;charset=UTF-8");
        ServerResponse sr=ServerResponse.createByErrorMessage("用户信息不完整");
        Gson gson=new Gson();
        PrintWriter pw = Response.getWriter();
        pw.write(gson.toJson(sr));
        pw.flush();
        pw.close();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
