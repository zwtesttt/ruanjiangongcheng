package com.zw.userlogin.service;

import com.zw.domain.User;
import com.zw.userlogin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录方法
     * @param username 用户名
     * @param passwd 密码
     * @return 用户对象
     */
    @Override
    public User toLogin(String username, String passwd) {
        User user=null;
        try {
//            查询用户密码
            user=userMapper.toLogin(username,passwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
