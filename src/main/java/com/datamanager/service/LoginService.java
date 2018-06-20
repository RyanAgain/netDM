package com.datamanager.service;

import com.datamanager.dto.LoginResult;
import com.datamanager.entity.Userinfo;

import java.util.List;

/**
 * 2018-06-07-17:13 Author By AgainP
 */
public interface LoginService {

    LoginResult loginTest(String username,String passwd);

    List<Userinfo> getUserInfos();

    Userinfo queryById(int userId);


}
