package com.datamanager.service;

import com.datamanager.dto.DailyMsgInsert;
import com.datamanager.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 2018-05-28-16:35 Author By AgainP
 */
public interface DailyMessageService {

    Broadband queryBdata(String sumiitTime);

    Core queryCdata(String sumiitTime);

    Optimization queryOdata(String sumiitTime);

    Wireless queryWdata(String sumiitTime);

    Transfer queryTdata(String summitTime);

    DailyMsgInsert coreDaily(int userId, float gsmNum, float lteNum, float volteNum,
                             float volteErl, float lteRatio);

    DailyMsgInsert broadbandDaily(int userId, int groupAll, int dataLine, int voiceLine, int gprsLine,
                                  int rentLine, int groupMsg, int schoolLine, int familyAll, int oneLine,
                                  int opticalLine, int oneAdd, int opticalAdd);

    DailyMsgInsert optimizationDaily(int userId, float gsmAllvo, float gsmBusyvo, float gsmAlldata, float gsmbusydata,
                                     float gsmUsage, float gsmConnect, float gsmDrop, float lteAlldata, float lteBusy, float lteConnect,
                                     float lteSwitch, float lteDrop);

    DailyMsgInsert wirelessDaily(int userId, int gsmAll, int gsmWave, int gsmDead, int rsAll,
                                 int rsDead, int lteAll, int lteWave, int lteDead, int wlanAc,
                                 int wlanHot, int wlanAp, float wlanAllvo, float wlanApdead, float wlanApdrop);

    DailyMsgInsert transferDaily(int userId,
                                 String firstUse, float firstUsage,
                                 String secUse, float secUsage,
                                 String thirdUse, float thirdUsage,
                                 String forthUse, float forthUsage,
                                 String fifthUse, float fifthUsage);

}
