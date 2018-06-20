package com.datamanager.service.Impl;

import com.datamanager.dao.UserinfoDao;
import com.datamanager.dto.LoginResult;
import com.datamanager.entity.Userinfo;
import com.datamanager.enums.LoginEnums;
import com.datamanager.exception.LoginException;
import com.datamanager.exception.PasswdErrException;
import com.datamanager.exception.UserAuthException;
import com.datamanager.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * 2018-06-07-17:24 Author By AgainP
 */
@Service
public class LoginServiceImpl implements LoginService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserinfoDao userinfoDao;

    //盐值，用于生成MD5
    private String salt = "565%$#@#@$#dsajd11";

    private String passwdMD5(String passwd) {
        String baseUrl = passwd + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(baseUrl.getBytes());
        return md5;
    }


    @Override
    public Userinfo queryById(int userId) {
        return userinfoDao.queryById(userId);
    }

    @Override
    public List<Userinfo> getUserInfos() {
        return userinfoDao.getUserinfo();
    }

    @Override
    public LoginResult loginTest(String username, String passwd) {
        try {

            Userinfo userinfo = userinfoDao.queryByName(username);

            if (userinfo == null) {
                throw new UserAuthException("账号错误或尚未注册");
            } else if (!passwd.equals(userinfo.getUserPw())) {
                throw new PasswdErrException("密码错误，请检查密码");
            } else {
                int userId = userinfo.getUserId();
                return new LoginResult(userId, LoginEnums.SUCCESS);
            }
        } catch (UserAuthException | PasswdErrException e1) {
            throw e1;
        }  catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new LoginException("Login inner error"+e.getMessage());
        }

    }
}
