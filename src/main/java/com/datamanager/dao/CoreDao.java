package com.datamanager.dao;

import com.datamanager.entity.Core;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 2018-05-28-11:42 Author By AgainP
 */
public interface CoreDao {

    /**
     * 通过日期查询数据
     * @param summitTime
     * @return
     */
    Core queryByDate(String summitTime);

    /**
     * 插入日报内容
     * @param gsmNum
     * @param lteNum
     * @param volteNum
     * @param volteErl
     * @param lteRatio
     * @return
     */
    int dailyCoreInsert(@Param("gsmNum") float gsmNum,
                        @Param("lteNum") float lteNum,
                        @Param("volteNum") float volteNum,
                        @Param("volteErl") float volteErl,
                        @Param("lteRatio")  float lteRatio);

}
