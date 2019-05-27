package com.awakeyoyoyo.controller.protal;
import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.service.IAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/advice")
//@Api(description = "测试接口")
public class AdviceController {
    @Autowired
    private IAdviceService adviceService;
    //发布通知
    @RequestMapping(value = "/send.do",method = RequestMethod.POST)
    @ResponseBody
//    @ApiOperation(value = "hello接口", notes = "hello接口")
    public ServerResponse sendAdvice(String mxg){
        if (mxg==null){
            return ServerResponse.createByErrorMessage("未传入信息");
        }
        return  adviceService.add(mxg);
    }
    //删除通知
    @RequestMapping(value="/delete.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse sendAdvice(Integer id){
        if (id==null){
            return ServerResponse.createByErrorMessage("未传入id");
        }
        return  adviceService.delete(id);
    }
    //获取一个人的所有通知包括投诉
    @RequestMapping(value = "/getAdvice.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getAdvice(HttpServletRequest request){
        String openId=(String) request.getAttribute("openId");
        if (openId==null){
            return ServerResponse.createByErrorMessage("未传入openid");
        }
        return  adviceService.getAdvice(openId);
    }
    //获取所有官方发布的通知
    @RequestMapping(value = "/getAdvices.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getAdvices(){
        return  adviceService.getAdvices();
    }
    //已阅读
    @RequestMapping(value = "/oldAdvice.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse oldAdvice(@RequestParam (value = "ids[]") Integer[] ids){
        if (ids==null){
            return ServerResponse.createByErrorMessage("未传入ids");
        }
        return  adviceService.oldAdvice(ids);
    }
}
