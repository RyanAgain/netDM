package com.datamanager.dao;

import com.datamanager.entity.Userinfo;

import java.util.List;

/**
 * 2018-05-28-18:37 Author By AgainP
 */
public interface UserinfoDao {

    Userinfo queryById(int userId);

    Userinfo queryByName(String userName);

    List<Userinfo> getUserinfo();
}
