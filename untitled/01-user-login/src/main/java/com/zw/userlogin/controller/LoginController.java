package com.zw.userlogin.controller;

import com.zw.api.openfeign.EmployeeFeign;
import com.zw.api.openfeign.PerformanceFeign;
import com.zw.api.openfeign.WagesscaleFeign;
import com.zw.domain.Employee;
import com.zw.domain.ResponseCode;
import com.zw.domain.ResponseObject;
import com.zw.domain.User;
import com.zw.userlogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {
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

//    /**
//     * 调用远程接口跳转员工列表页
//     * @return
//     */
//    //跳转员工列表页
//    @GetMapping("/todetail")
//    public String todetail(){
//        return employeeFeign.todetail();
//    }
//
//    //跳转具体表现的员工列表页
//    @GetMapping("/toPerformance")
//    public String toPerformance(){
//        return performanceFeign.toPerformance();
//    }
//
//    //跳转工资标准页
//    @GetMapping("/toWagesscale")
//    public String toWagesscale(){
//        return wagesscaleFeign.toWagesscale();
//    }


    @GetMapping("/tologin")
    @ResponseBody
    public Object toLogin(String username,String passwd){
        User user=null;
        ResponseObject responseObject=new ResponseObject();
        user= loginService.toLogin(username, passwd);
        //判断是否有该用户
        if (user!=null) {
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
