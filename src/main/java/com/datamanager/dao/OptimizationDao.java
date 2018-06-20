package com.datamanager.dao;

import com.datamanager.entity.Optimization;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 2018-05-28-11:42 Author By AgainP
 */
public interface OptimizationDao {

    /**
     * 通过日期查询相关数据
     * @param summitTime
     * @return
     */
    Optimization queryByDate(String summitTime);

    /**
     * 插入网优日报数据
     * @param gsmAllvo
     * @param gsmBusyvo
     * @param gsmAlldata
     * @param gsmbusydata
     * @param gsmUsage
     * @param gsmConnect
     * @param gsmDrop
     * @param lteAlldata
     * @param lteBusy
     * @param lteConnect
     * @param lteSwitch
     * @param lteDrop
     * @return
     */
    int dailyOptimizationInsert(@Param("gsmAllvo") float gsmAllvo,
                                @Param("gsmBusyvo") float gsmBusyvo,
                                @Param("gsmAlldata") float gsmAlldata,
                                @Param("gsmbusydata") float gsmbusydata,
                                @Param("gsmUsage") float gsmUsage,
                                @Param("gsmConnect") float gsmConnect,
                                @Param("gsmDrop") float gsmDrop,
                                @Param("lteAlldata") float lteAlldata,
                                @Param("lteBusy") float lteBusy,
                                @Param("lteConnect") float lteConnect,
                                @Param("lteSwitch") float lteSwitch,
                                @Param("lteDrop") float lteDrop);

}
