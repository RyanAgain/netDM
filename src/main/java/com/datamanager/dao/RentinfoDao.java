package com.datamanager.dao;

import com.datamanager.entity.Rentinfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 2018-04-11-23:53 Author By AgainP
 */
public interface RentinfoDao {

    /**
     *输入借卡人信息进行借卡
     * @param cardId
     * @param rentName
     * @param rentPhone
     * @return
     */
    int SuccessRentInfo(@Param("cardId") long cardId,
                        @Param("rentName") String rentName,
                        @Param("rentPhone") long rentPhone,
                        @Param("rentReason") String rentReason,
                        @Param("roomNum") String roomNum,
                        @Param("ydInterface") String ydInterface);

    /**
     * 归还卡时间
     * @param cardId
     * @return
     */
    int ReturnCard(@Param("cardId") long cardId);

    /**
     * 通过姓名查找“已借卡，但未还卡”的信息，主要用于判断用户是否一次借多卡；
     * @param rentName
     * @return
     */
    List<Rentinfo> queryNoEndTime(String rentName);

    /**
     * 查找“已借卡，但未还卡”的信息，用于显示在网页上
     * @return
     */
    List<Rentinfo> queryNoReturnCard();

    /**
     * 通过卡号查找借卡信息
     * @param cardId
     * @return
     */
    List<Rentinfo> queryRentById(long cardId);


    /**
     * 通过卡号查询最新一条借用的记录
     * @param cardId
     * @return
     */
    Rentinfo queryIdOrder(long cardId);


    /**
     * 返回历史借卡人员列表
     * @return
     */
    List<Rentinfo> queryRentByAll();

}
