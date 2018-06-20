package com.datamanager.web;

import com.datamanager.dto.*;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 2018-05-18-9:27 Author By AgainP
 */
@Controller
@RequestMapping("/dm")
public class CardRentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CardrentService cardrentService;


    //查询卡列表
    @RequestMapping(value = "/cardrent",method = RequestMethod.GET)
    public String carddataList(Model model,@CookieValue(value="userId",required = false) Integer userId){

        if (userId == null) {
            return "redirect:/dm/login";

        }else{
            List<Carddata> list = cardrentService.getCarddataList();

            List<Rentinfo> rentinfo = cardrentService.getRentInfo();

            model.addAttribute("rentinfo",rentinfo);

            model.addAttribute("list",list);

            return "list";
        }

    }

    //查询已借卡但未还卡的信息
    @RequestMapping(value = "/renthistory",method = RequestMethod.GET)
    public String historyInfo(Model model){
        List<Rentinfo> historyInfo = cardrentService.historyInfo();

        model.addAttribute("historyInfo",historyInfo);

        return "history";
    }

    @RequestMapping(value = "/{cardId}/exposer",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public RentExecutionResult<ExposerRentCard> exposerRentCard(@PathVariable("cardId") Long cardId){

        RentExecutionResult<ExposerRentCard> result;

        try{
            ExposerRentCard exposerRentCard = cardrentService.exposer(cardId);
            if(exposerRentCard.isExposed()){
                result = new RentExecutionResult<ExposerRentCard>(true,exposerRentCard);
            }else{
                result = new RentExecutionResult<ExposerRentCard>(false,exposerRentCard);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result = new RentExecutionResult<ExposerRentCard>(false,e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{cardId}/exposereturn",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public RentExecutionResult<ExposerReturn> exposerReturn(@PathVariable("cardId")Long cardId){

        RentExecutionResult<ExposerReturn> result;

        try {
            ExposerReturn exposerReturn = cardrentService.exposerreturn(cardId);
            if (exposerReturn.isExposed()){
                result = new RentExecutionResult<ExposerReturn>(true,exposerReturn);
            }else{
                result = new RentExecutionResult<ExposerReturn>(false,exposerReturn);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            result = new RentExecutionResult<ExposerReturn>(false,e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{cardId}/{rentName}/{phone}/{rentReason}/{roomNum}/{ydInterface}/rentinfo",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public RentExecutionResult<SuccessRentInfo> successRentInfoRentExecutionResult(@PathVariable("cardId")Long cardId,
                                                                                   @PathVariable("rentName") String rentName,
                                                                                   @PathVariable("phone") Long userPhone,
                                                                                   @PathVariable("rentReason") String rentReason,
                                                                                   @PathVariable("roomNum") String roomNum,
                                                                                   @PathVariable("ydInterface") String ydInterface){
        if(rentName == null || userPhone == null || rentReason == null || roomNum == null || ydInterface==null){
            return new RentExecutionResult<SuccessRentInfo>(false,"信息不全，无法借用");
        }

        RentExecutionResult<SuccessRentInfo> result;

        try {
            SuccessRentInfo successRentInfo = cardrentService.successedrent(cardId,rentName,userPhone,rentReason,roomNum,ydInterface);
            return new RentExecutionResult<SuccessRentInfo>(true,successRentInfo);
        } catch (NoNumberException e) {
            SuccessRentInfo execution = new SuccessRentInfo(cardId, RentinfoEnums.DATA_REWRITE);
            return new RentExecutionResult<SuccessRentInfo>(true,execution);
        } catch (RepeatException e) {
            SuccessRentInfo execution = new SuccessRentInfo(cardId, RentinfoEnums.REPEAT);
            return new RentExecutionResult<SuccessRentInfo>(true,execution);
        } catch (RentFailException e) {
            SuccessRentInfo execution = new SuccessRentInfo(cardId,RentinfoEnums.INNER_ERROR);
            return new RentExecutionResult<SuccessRentInfo>(true,execution);
        }

    }


    @RequestMapping(value = "/{cardId}/returninfo",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public  RentExecutionResult<SuccessReturn> successReturnRentExecutionResult(@PathVariable("cardId") Long cardId){
        RentExecutionResult<SuccessReturn> result;

        try {
            SuccessReturn successReturn = cardrentService.successedreturn(cardId);
            return new RentExecutionResult<SuccessReturn>(true,successReturn);
        } catch (NoNumberException e) {
            SuccessReturn execution = new SuccessReturn(cardId,ReturnEums.REPEAT);
            return new RentExecutionResult<SuccessReturn>(true,execution);
        } catch (RentFailException e) {
            SuccessReturn execution = new SuccessReturn(cardId,ReturnEums.INNER_ERROR);
            return new RentExecutionResult<SuccessReturn>(true,execution);
        }
    }

}
