package com.zw.userlogin.controller;

import com.zw.api.openfeign.EmployeeFeign;
import com.zw.api.openfeign.PerformanceFeign;
import com.zw.api.openfeign.WagesscaleFeign;

import com.zw.domain.ResponseCode;
import com.zw.domain.ResponseObject;
import com.zw.domain.User;
import com.zw.userlogin.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    /**
     * 注入redis模板类
     */
//    @Autowired
//    private RedisTemplate redisTemplate;

    @Autowired
    private LoginService loginService;


    //    注入工资标准模块远程接口
    @Autowired
    private WagesscaleFeign wagesscaleFeign;
    //    注入具体表现模块远程接口
    @Autowired
    private PerformanceFeign performanceFeign;
    //    注入员工模块远程接口
    @Autowired
    private EmployeeFeign employeeFeign;

    @GetMapping("/tologin")
    @ResponseBody
    public Object toLogin( String username, String passwd){
        User user=null;
        ResponseObject responseObject=new ResponseObject();
        user=loginService.toLogin(username, passwd);
        //判断是否有该用户
        if (user!=null) {
            //生成uuid
//            String uuid= UUID.randomUUID().toString();
            //将uuid作为键，用户对象作为值存入redis中
//            redisTemplate.opsForValue().set(uuid,user.toString(), Duration.ofSeconds(7200));
            //在响应头中添加token
            //request.mutate().header("Auth","bearer "+uuid).build();
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            template.header("Auth","bearer "+uuid);
//            response.addHeader("Auth","bearer "+uuid);
            responseObject.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
            responseObject.setMessage("登录成功");
            responseObject.setData(user);
        }else {
            responseObject.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            responseObject.setMessage("登录失败");
        }
        return responseObject;
    }
    //跳转首页
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    //跳转登录页
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
