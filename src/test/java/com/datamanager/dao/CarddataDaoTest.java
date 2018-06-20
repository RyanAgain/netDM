package com.datamanager.dao;

import com.datamanager.entity.Carddata;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 2018-04-12-17:19 Author By AgainP
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CarddataDaoTest {
    @Resource
    private CarddataDao carddataDao;


    @Test
    public void changestate() throws Exception {
        long cardId=1;
        int state = 0;
        int changestate = carddataDao.changestate(cardId,state);
        System.out.println("changestate" + changestate);
    }

    @Test
    public void queryById() throws Exception {
        long cardId=1;
        Carddata carddata = carddataDao.queryById(cardId);
        System.out.println(carddata);
    }

    @Test
    public void queryByAll() throws Exception {
        List<Carddata> carddatas = carddataDao.queryByAll(0,5);
        for(Carddata carddata:carddatas){
            System.out.println(carddata);
        }
    }

}