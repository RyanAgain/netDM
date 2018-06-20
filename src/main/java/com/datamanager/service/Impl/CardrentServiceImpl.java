package com.datamanager.service.Impl;

import com.datamanager.dao.CarddataDao;
import com.datamanager.dao.RentinfoDao;
import com.datamanager.dto.ExposerRentCard;
import com.datamanager.dto.ExposerReturn;
import com.datamanager.dto.SuccessRentInfo;
import com.datamanager.dto.SuccessReturn;
import com.datamanager.entity.Carddata;
import com.datamanager.entity.Rentinfo;
import com.datamanager.enums.RentinfoEnums;
import com.datamanager.enums.ReturnEums;
import com.datamanager.exception.NoNumberException;
import com.datamanager.exception.RentFailException;
import com.datamanager.exception.RepeatException;
import com.datamanager.service.CardrentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 2018-05-16-17:26 Author By AgainP
 */
@Service
public class CardrentServiceImpl implements CardrentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private CarddataDao carddataDao;

    @Autowired
    private RentinfoDao rentinfoDao;

    @Override
    public List<Carddata> getCarddataList() {
        return carddataDao.queryByAll(0,5);
    }

    @Override
    public Carddata getById(long cardId) {
        return carddataDao.queryById(cardId);
    }

    @Override
    public List<Rentinfo> historyInfo() {

        return rentinfoDao.queryRentByAll();
    }

    @Override
    public List<Rentinfo> getRentInfo() {
        return rentinfoDao.queryNoReturnCard();
    }

    @Override
    public ExposerRentCard exposer(long cardId) {
        Carddata carddata = carddataDao.queryById(cardId);
        int cardstate = carddata.getCardState();
        if (carddata == null){
            return new ExposerRentCard(false,cardId);
        }else if(cardstate==0)
        {
            return new ExposerRentCard(false,cardstate,cardId);
        }else {
            return new ExposerRentCard(true,cardstate,cardId);
        }
    }

    @Transactional
    @Override
    public SuccessRentInfo successedrent(long cardId,String rentName,long userPhone,String rentReason,String roomNum,String ydInterface) {

        try{
            Carddata carddata = carddataDao.queryById(cardId);
            int cardstate = carddata.getCardState();
            if(cardstate == 0){
                throw new NoNumberException("卡已借出，暂时无法借用");
            }else if(!rentinfoDao.queryNoEndTime(rentName).isEmpty()){
                throw new RepeatException("不能同时借用两张卡");
            }else{
                int changeCardState = carddataDao.changestate(cardId,cardstate-1);
                int insertsuccessrentinfo = rentinfoDao.SuccessRentInfo(cardId,rentName,userPhone,rentReason,roomNum,ydInterface);
                Rentinfo rentinfo = rentinfoDao.queryIdOrder(cardId);
                return new SuccessRentInfo(cardId, RentinfoEnums.SUCCESS,rentinfo);
            }
         }catch (RentFailException e){

            throw new RentFailException("系统异常");

        }

    }

    @Override
    public ExposerReturn exposerreturn(long cardId) {
        Carddata carddata = carddataDao.queryById(cardId);
        int cardState = carddata.getCardState();
        if(carddata == null){
            return new ExposerReturn(false,cardId);
        }else if(cardState>0){
            return new ExposerReturn(false,cardState,cardId);
        }else {
            return new ExposerReturn(true,cardState,cardId);
        }
    }

    @Transactional
    @Override
    public SuccessReturn successedreturn(long cardId) {

        try
        {
            Carddata carddata = carddataDao.queryById(cardId);
            int cardState = carddata.getCardState();
            if(cardState == 1){
                throw new NoNumberException("无需归还");
            }else{
                int returnCard = rentinfoDao.ReturnCard(cardId);
                int changeCardState = carddataDao.changestate(cardId,cardState+1);
                return new SuccessReturn(cardId, ReturnEums.SUCCESS,returnCard);
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            //将所有编译期异常，转换为运行期异常；
            throw new RentFailException("系统异常"+e.getMessage());
        }

    }
}
