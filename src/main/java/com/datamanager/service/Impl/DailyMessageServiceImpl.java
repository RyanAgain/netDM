package com.datamanager.service.Impl;

import com.datamanager.dao.*;
import com.datamanager.dto.DailyMsgInsert;
import com.datamanager.entity.*;
import com.datamanager.enums.DailyMsgEnums;
import com.datamanager.exception.RentFailException;
import com.datamanager.exception.RepeatException;
import com.datamanager.exception.UserAuthException;
import com.datamanager.service.DailyMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2018-05-28-17:45 Author By AgainP
 */
@Service
public class DailyMessageServiceImpl implements DailyMessageService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserinfoDao userinfoDao;

    @Autowired
    private BroadbandDao broadbandDao;

    @Autowired
    private CoreDao coreDao;

    @Autowired
    private OptimizationDao optimizationDao;

    @Autowired
    private WirelessDao wirelessDao;

    @Autowired
    private TransferDao transferDao;

    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }


    @Override
    public Broadband queryBdata(String sumiitTime) {
        return broadbandDao.queryByDate(sumiitTime);
    }

    @Override
    public Core queryCdata(String sumiitTime) {
        return coreDao.queryByDate(sumiitTime);
    }

    @Override
    public Optimization queryOdata(String sumiitTime) {
        return optimizationDao.queryByDate(sumiitTime);
    }

    @Override
    public Wireless queryWdata(String sumiitTime) {
        return wirelessDao.queryByTime(sumiitTime);
    }

    @Override
    public Transfer queryTdata(String summitTime) {
        return transferDao.queryByTime(summitTime);
    }

    @Override
    public DailyMsgInsert broadbandDaily(int userId, int groupAll, int dataLine, int voiceLine, int gprsLine, int rentLine, int groupMsg, int schoolLine, int familyAll, int oneLine, int opticalLine, int oneAdd, int opticalAdd) {
        try {
            Userinfo userinfo = userinfoDao.queryById(userId);
            int auth = userinfo.getUserRole();

            if( auth != 0 && auth != 3 ){
                throw new UserAuthException("用户权限不足，无法插入");
            }else if(broadbandDao.queryByDate(getStringDateShort())!=null){
                throw new RepeatException("数据异常，重复插入数据");
            }else{
                int  dailyBroadbandInsert = broadbandDao.dailyBroadbandInsert(groupAll,dataLine,voiceLine,gprsLine,rentLine,groupMsg,
                                                                              schoolLine,familyAll,oneLine,opticalLine,oneAdd,opticalAdd);
                Broadband broadband = broadbandDao.queryByDate(getStringDateShort());
                return new DailyMsgInsert(DailyMsgEnums.SUCCESS,broadband);
            }
        } catch (UserAuthException  | RepeatException e1) {
            throw e1;
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new RentFailException("插入异常 :"+e.getMessage());
        }
    }

    @Override
    public DailyMsgInsert coreDaily(int userId, float gsmNum, float lteNum, float volteNum, float volteErl, float lteRatio) {
        try {
            Userinfo userinfo = userinfoDao.queryById(userId);
            int auth = userinfo.getUserRole();

            if( auth != 0 && auth != 4 ){
                throw new UserAuthException("用户权限不足，无法插入");
            }else if(coreDao.queryByDate(getStringDateShort()) != null ){
                throw new RepeatException("数据异常，不能重复插入");
            }else{
                int dailyCoreInsert = coreDao.dailyCoreInsert(gsmNum,lteNum,volteNum,volteErl, lteRatio);
                Core core = coreDao.queryByDate(getStringDateShort());
                return new DailyMsgInsert(DailyMsgEnums.SUCCESS,core);
            }
        } catch (UserAuthException | RepeatException e1) {
            throw e1;
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new RentFailException("插入异常 :"+e.getMessage());
        }
    }

    @Override
    public DailyMsgInsert optimizationDaily(int userId, float gsmAllvo, float gsmBusyvo, float gsmAlldata, float gsmbusydata, float gsmUsage, float gsmConnect, float gsmDrop, float lteAlldata, float lteBusy, float lteConnect, float lteSwitch, float lteDrop) {
        try {
            Userinfo userinfo = userinfoDao.queryById(userId);
            int auth = userinfo.getUserRole();

            if( auth != 0 && auth != 2 ){
                throw new UserAuthException("用户权限不足，无法插入");
            }else if(optimizationDao.queryByDate(getStringDateShort()) != null){
                throw new RepeatException("数据异常，不能重复插入");
            }else{
                int dailyOpInsert = optimizationDao.dailyOptimizationInsert(gsmAllvo,gsmBusyvo,gsmAlldata,gsmbusydata,gsmUsage,
                                                                            gsmConnect,gsmDrop,lteAlldata,lteBusy,lteConnect,lteSwitch,lteDrop);
                Optimization optimization= optimizationDao.queryByDate(getStringDateShort());
                return new DailyMsgInsert(DailyMsgEnums.SUCCESS,optimization);
            }
        } catch (UserAuthException | RepeatException e1) {
            throw e1;
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new RentFailException("插入异常 :"+e.getMessage());
        }
    }

    @Override
    public DailyMsgInsert wirelessDaily(int userId, int gsmAll, int gsmWave, int gsmDead, int rsAll, int rsDead, int lteAll, int lteWave, int lteDead, int wlanAc, int wlanHot, int wlanAp, float wlanAllvo, float wlanApdead, float wlanApdrop) {
        try {
            Userinfo userinfo = userinfoDao.queryById(userId);
            int auth = userinfo.getUserRole();

            if( auth != 0 && auth != 1 ){
                throw new UserAuthException("用户权限不足，无法插入");
            }else if(wirelessDao.queryByTime(getStringDateShort()) != null){
                throw new RepeatException("数据异常，不能重复插入");
            }else{
                int dailyWiInsert = wirelessDao.dailyWirelessInsert(gsmAll,gsmWave,gsmDead,rsAll,rsDead,
                                                                    lteAll,lteWave,lteDead,wlanAc,wlanHot,wlanAp,wlanAllvo,wlanApdead,wlanApdrop);
                Wireless wireless= wirelessDao.queryByTime(getStringDateShort());
                return new DailyMsgInsert(DailyMsgEnums.SUCCESS,wireless);
            }
        } catch (UserAuthException | RepeatException e1) {
            throw e1;
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new RentFailException("插入异常 :"+e.getMessage());
        }
    }

    @Override
    public DailyMsgInsert transferDaily(int userId, String firstUse, float firstUsage, String secUse, float secUsage, String thirdUse, float thirdUsage, String forthUse, float forthUsage, String fifthUse, float fifthUsage) {
        try {
            Userinfo userinfo = userinfoDao.queryById(userId);
            int auth = userinfo.getUserRole();

            if( auth != 0 && auth != 5 ){
                throw new UserAuthException("用户权限不足，无法插入");
            }else if(transferDao.queryByTime(getStringDateShort()) != null){
                throw new RepeatException("数据异常，不能重复插入");
            }else{
                int dailyFInsert = transferDao.transferinsert(firstUse,firstUsage,secUse,secUsage,thirdUse,thirdUsage, forthUse,forthUsage,fifthUse,fifthUsage);
                Transfer transfer= transferDao.queryByTime(getStringDateShort());
                return new DailyMsgInsert(DailyMsgEnums.SUCCESS,transfer);
            }
        } catch (UserAuthException | RepeatException e1) {
            throw e1;
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new RentFailException("插入异常 :"+e.getMessage());
        }
    }
}

