package com.zw.userlogin.service;

import com.zw.domain.User;

public interface LoginService{
    User toLogin(String username,String passwd);
}
