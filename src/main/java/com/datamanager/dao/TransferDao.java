package com.datamanager.dao;

import com.datamanager.entity.Transfer;
import org.apache.ibatis.annotations.Param;

/**
 * 2018-06-01-15:58 Author By AgainP
 */
public interface TransferDao {


    /**
     * 插入基站日报信息
     * @param firstUse
     * @param firstUsage
     * @param secUse
     * @param secUsage
     * @param thirdUse
     * @param thirdUsage
     * @param forthUse
     * @param forthUsage
     * @param fifthUse
     * @param fifthUsage
     * @return
     */
    int transferinsert(@Param("firstUse") String firstUse, @Param("firstUsage") float firstUsage,
                       @Param("secUse") String secUse, @Param("secUsage") float secUsage,
                       @Param("thirdUse") String thirdUse, @Param("thirdUsage") float thirdUsage,
                       @Param("forthUse") String forthUse, @Param("forthUsage") float forthUsage,
                       @Param("fifthUse") String fifthUse, @Param("fifthUsage") float fifthUsage);


    /**
     * 根据实际时间查询结果
     * @param summitTime
     * @return
     */
    Transfer queryByTime(String summitTime);
}
