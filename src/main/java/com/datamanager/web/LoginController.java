package com.datamanager.web;


import com.datamanager.dto.LoginResult;
import com.datamanager.dto.SuccessLogin;
import com.datamanager.entity.Userinfo;
import com.datamanager.enums.LoginEnums;
import com.datamanager.exception.LoginException;
import com.datamanager.exception.PasswdErrException;
import com.datamanager.exception.UserAuthException;
import com.datamanager.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 2018-05-29-10:57 Author By AgainP
 */
@Controller
@RequestMapping("/dm")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){

        List<Userinfo> userinfos = loginService.getUserInfos();

        model.addAttribute("userInfos",userinfos);

        return "login";

    }

    @RequestMapping(value = "/{userName}/{userPw}/auth",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SuccessLogin<LoginResult> loginResultSuccessLogin(@PathVariable("userName") String userName,
                                                             @PathVariable("userPw") String userPw){

        SuccessLogin<LoginResult> result;

        try{
            LoginResult loginResult = loginService.loginTest(userName,userPw);
            return new SuccessLogin<LoginResult>(loginResult,true);
        }catch (UserAuthException e){
            LoginResult loginResult = new LoginResult(userName, LoginEnums.EMPTY);
            return new SuccessLogin<LoginResult>(loginResult,false);
        }catch (PasswdErrException e){
            LoginResult loginResult = new LoginResult(userName,LoginEnums.PWD_ERROR);
            return new SuccessLogin<LoginResult>(loginResult,false);
        }catch (LoginException e){
            LoginResult loginResult = new LoginResult(userName,LoginEnums.DATA_REWRITE);
            return new SuccessLogin<LoginResult>(loginResult,false);
        }
    }

    @RequestMapping(value = "/user/getnickname",method = RequestMethod.GET)
    @ResponseBody
    public String getUserName( @CookieValue(value="userId",required = false) Integer userId
                               ,Model model){
        if(userId == null){
            return "未登录";
        }else {
            Userinfo userinfo = loginService.queryById(userId);
            String nickName = userinfo.getNickName();
            return nickName;
        }

    }
}
