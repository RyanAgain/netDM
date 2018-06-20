package com.datamanager.service;

import com.datamanager.dto.ExposerRentCard;
import com.datamanager.dto.ExposerReturn;
import com.datamanager.dto.SuccessRentInfo;
import com.datamanager.dto.SuccessReturn;
import com.datamanager.entity.Carddata;
import com.datamanager.entity.Rentinfo;
import com.datamanager.exception.NoNumberException;
import com.datamanager.exception.RentFailException;
import com.datamanager.exception.RepeatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 2018-05-17-14:58 Author By AgainP
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class CardrentServiceTest {



    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CardrentService cardrentService;

    @Test
    public void getCarddataList() throws Exception {
        List<Carddata> carddataList = cardrentService.getCarddataList();
        logger.info("carddataList={}", carddataList);
    }

    @Test
    public void getRentInfo() throws Exception {
        List<Rentinfo> rentinfoList = cardrentService.getRentInfo();
        logger.info("rentinfoList={}",rentinfoList);
    }

    @Test
    public void getById() throws Exception {
        long id = 1;
        Carddata carddata = cardrentService.getById(id);
        logger.info("carddata={}", carddata);
    }

    @Test
    public void exposer() throws Exception {
    }

    @Test
    public void successedrent() throws Exception {
        long id = 2;
        ExposerRentCard exposer = cardrentService.exposer(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            String userName = "黄良俊";
            long userPhone = 13900001111L;
            String rentReason = "出入测试";
            String roomNum = "古塔六楼";
            String ydInterface = "张三";
            try {
                SuccessRentInfo successRentInfo = cardrentService.successedrent(id,userName,userPhone,rentReason,roomNum,ydInterface);
                logger.info("successRentInfo={}", successRentInfo);
            } catch (NoNumberException e){
                logger.error(e.getMessage());
            }catch (RepeatException e){
                logger.error(e.getMessage());
            }catch (RentFailException e){
                logger.error(e.getMessage());
            }
        }else {
            logger.warn("exposed={}", exposer);
        }
    }

    @Test
    public void successedreturn() throws Exception {
        long id = 2;
        ExposerReturn exposerReturn = cardrentService.exposerreturn(id);
        if(exposerReturn.isExposed()){
            logger.info("exposerReturn={}",exposerReturn);
        try{
            SuccessReturn successReturn = cardrentService.successedreturn(id);
            logger.info("successReturn={}", successReturn);

        }catch (NoNumberException e){

            logger.error(e.getMessage());

        }catch (RentFailException e){

            logger.error(e.getMessage());
        }
        }else {
            logger.warn("exposed={}", exposerReturn);
        }
    }

}