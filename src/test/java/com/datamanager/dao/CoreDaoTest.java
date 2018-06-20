package com.datamanager.dao;

import com.datamanager.entity.Core;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * 2018-05-29-10:11 Author By AgainP
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CoreDaoTest {

    @Resource
    private CoreDao coreDao;

    @Test
    public void queryByDate() throws Exception {
        String date = "2018-05-29";
        Core core = coreDao.queryByDate(date);
        System.out.println("core" + core);
    }

    @Test
    public void dailyCoreInsert() throws Exception {
      Float gsmNum = 22.22F;
      Float lteNum = 33.33F;
      Float volteNum = 44.44F;
      Float volteErl = 55.55F;
      Float lteRatio = 66.66F;
      int daliy = coreDao.dailyCoreInsert(gsmNum,lteNum,volteNum,volteErl,lteRatio);




    }

}