package com.datamanager.dao;

import com.datamanager.entity.Broadband;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 2018-05-28-11:41 Author By AgainP
 */
public interface BroadbandDao {

    /**
     * 根据日期查询家宽数据
     * @param summitTime
     * @return
     */
    Broadband queryByDate(String summitTime);

    /**
     *
     * 插入家宽集客日报数据
     * @param groupAll
     * @param dataLine
     * @param voiceLine
     * @param gprsLine
     * @param rentLine
     * @param groupMsg
     * @param schoolLine
     * @param familyAll
     * @param oneLine
     * @param opticalLine
     * @param oneAdd
     * @param opticalAdd
     * @return
     */
    int dailyBroadbandInsert(@Param("groupAll") int groupAll,
                             @Param("dataLine") int dataLine,
                             @Param("voiceLine") int voiceLine,
                             @Param("gprsLine") int gprsLine,
                             @Param("rentLine") int rentLine,
                             @Param("groupMsg") int groupMsg,
                             @Param("schoolLine") int schoolLine,
                             @Param("familyAll") int familyAll,
                             @Param("oneLine") int oneLine,
                             @Param("opticalLine") int opticalLine,
                             @Param("oneAdd") int oneAdd,
                             @Param("opticalAdd") int opticalAdd);

}
