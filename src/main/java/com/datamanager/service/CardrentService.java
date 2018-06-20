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

import java.util.List;

/**
 * 2018-05-16-14:48 Author By AgainP
 */
public interface CardrentService {

    List<Carddata> getCarddataList();

    Carddata getById(long cardId);

    ExposerRentCard exposer(long cardId);

    List<Rentinfo> historyInfo();

    List<Rentinfo> getRentInfo();

    SuccessRentInfo successedrent(long cardId,String rentName,long userPhone,String rentReason,String roomNum,String ydInterface)
            throws NoNumberException,RepeatException,RentFailException;

    ExposerReturn exposerreturn(long cardId);

    SuccessReturn successedreturn(long cardId)
            throws NoNumberException,RentFailException;


}
