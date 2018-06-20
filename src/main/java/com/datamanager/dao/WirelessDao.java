package com.datamanager.dao;

import com.datamanager.entity.Wireless;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 2018-05-28-11:42 Author By AgainP
 */
public interface WirelessDao {


    /**
     * 日报信息插入
     * @param gsmAll
     * @param gsmWave
     * @param gsmDead
     * @param rsAll
     * @param rsDead
     * @param lteAll
     * @param lteWave
     * @param lteDead
     * @param wlanAc
     * @param wlanHot
     * @param wlanAp
     * @param wlanAllvo
     * @param wlanApdead
     * @param wlanApdrop
     * @return
     */
    int dailyWirelessInsert(@Param("gsmAll") int gsmAll,
                            @Param("gsmWave") int gsmWave,
                            @Param("gsmDead") int gsmDead,
                            @Param("rsAll") int rsAll,
                            @Param("rsDead") int rsDead,
                            @Param("lteAll") int lteAll,
                            @Param("lteWave") int lteWave,
                            @Param("lteDead") int lteDead,
                            @Param("wlanAc") int wlanAc,
                            @Param("wlanHot") int wlanHot,
                            @Param("wlanAp") int wlanAp,
                            @Param("wlanAllvo") float wlanAllvo,
                            @Param("wlanApdead") float wlanApdead,
                            @Param("wlanApdrop") float wlanApdrop
                            );

    /**
     * 通过时间查询记录
     * @param summitTime
     * @return
     */
    Wireless queryByTime(String summitTime);


}
