package com.awakeyoyoyo.Interceptor;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.service.IUserService;
import com.awakeyoyoyo.utils.JWTUtils;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class TokenInterceptor implements HandlerInterceptor {
    private IUserService iUserService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //表头中拿token
        String token=httpServletRequest.getHeader("token");
        if (null!=token){
            //解析token
            Claims  claims=JWTUtils.parseJWT(token);
            //拿到openid
            String openid=claims.get("openid",String.class);
            if (null!=openid){
                //查询数据库
                //todo
            int rowcount=1;
                    //iUserService.checkOpenId();
            if (rowcount>=1){
                httpServletRequest.setAttribute("openid",openid);
                return true;
              }
            }
         }
            //重置response
            httpServletResponse.reset();
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            ServerResponse sr=ServerResponse.createByErrorMessage("身份认证失败");
            Gson gson=new Gson();
            PrintWriter pw = httpServletResponse.getWriter();
            pw.write(gson.toJson(sr));
            pw.flush();
            pw.close();
            return false;//不放行

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
