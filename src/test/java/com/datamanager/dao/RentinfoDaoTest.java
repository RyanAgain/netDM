package com.datamanager.dao;

import com.datamanager.entity.Rentinfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 2018-04-13-10:03 Author By AgainP
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RentinfoDaoTest {



    @Resource
    private RentinfoDao rentinfoDao;

    @Test
    public void successRentInfo() throws Exception {
        long cardId = 1;
        String rentName = "李五";
        long rentPhone = 13922120010L;
        String rentReason = "出入测试";
        String roomNum = "古塔六楼";
        String ydInterface = "张三";
        int info = rentinfoDao.SuccessRentInfo(cardId,rentName,rentPhone,rentReason,roomNum,ydInterface);
        System.out.println("info :"+info);
    }


    @Test
    public void queryIdOrder() throws Exception {

        long cardId = 1;
        Rentinfo rentinfo = rentinfoDao.queryIdOrder(cardId);
        System.out.println(rentinfo);
    }


    @Test
    public void queryNoEndTime() throws Exception {
        String rentName = "李四";
        List<Rentinfo> rentinfos = rentinfoDao.queryNoEndTime(rentName);
        for(Rentinfo rentinfo : rentinfos){
            System.out.println(rentinfo);
        }
    }


    @Test
    public void returnCard() throws Exception {
        long cardId = 5;
        int returncard = rentinfoDao.ReturnCard(cardId);
        System.out.println("returncard : "+ returncard);
    }

    @Test
    public void queryRentById() throws Exception {
        long cardId = 3;
        List<Rentinfo> rentinfos = rentinfoDao.queryRentById(cardId);
        for(Rentinfo rentinfo : rentinfos){
            System.out.println(rentinfo);
        }
    }

    @Test
    public void queryRentByAll() throws Exception {
        List<Rentinfo> rentinfos = rentinfoDao.queryRentByAll();
        for(Rentinfo rentinfo : rentinfos){
            System.out.println(rentinfo);
        }
    }

}