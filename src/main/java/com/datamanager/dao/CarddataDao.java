package com.datamanager.dao;

import com.datamanager.entity.Carddata;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2018-04-11-23:49 Author By AgainP
 */
public interface CarddataDao {
    /**
     * 选择卡Id进行状态转换
     * @param cardId
     * @param cardState
     * @return
     */
    int changestate(@Param("cardId") long cardId,@Param("cardState")int cardState);

    /**
     * 根据ID进行查询，返回一个Carddata的对象
     * @param cardId
     * @return
     */
    Carddata queryById(long cardId);

    /**
     * 批量查询，注意mybatis多个传入值时，要使用@Param的注解
     * @param offset
     * @param limit
     * @return
     */
    List<Carddata> queryByAll(@Param("offset") int offset,@Param("limit") int limit);
}
