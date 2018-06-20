package com.datamanager.web;

import com.datamanager.dto.DailyMsgInsert;
import com.datamanager.dto.InsertDailyMsgResult;
import com.datamanager.entity.Broadband;
import com.datamanager.entity.Core;
import com.datamanager.entity.Optimization;
import com.datamanager.entity.Wireless;
import com.datamanager.enums.DailyMsgEnums;
import com.datamanager.exception.RepeatException;
import com.datamanager.exception.UserAuthException;
import com.datamanager.service.DailyMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.datamanager.service.Impl.DailyMessageServiceImpl.getStringDateShort;

/**
 * 2018-05-29-10:52 Author By AgainP
 */
@Controller
@RequestMapping("/dm")
public class DailyMessageController {

    @Autowired
    private DailyMessageService dailyMessageService;


    @RequestMapping(value = "/message",method = RequestMethod.GET)
    public String dailymessage(Model model,@CookieValue(value="userId",required = false) Integer userId){

        if (userId == null) {
            return "redirect:/dm/login";
        } else {
            Broadband broadband = dailyMessageService.queryBdata(getStringDateShort());

            Core core = dailyMessageService.queryCdata(getStringDateShort());

            Optimization optimization = dailyMessageService.queryOdata(getStringDateShort());

            Wireless wireless = dailyMessageService.queryWdata(getStringDateShort());

            model.addAttribute("broadband", broadband);

            model.addAttribute("core", core);

            model.addAttribute("optimization", optimization);

            model.addAttribute("wireless", wireless);

            return "daily";
        }


    }




    @RequestMapping(value = "/{groupAll}/{dataLine}/{voiceLine}/{gprsLine}/{rentLine}/{groupMsg}/{schoolLine}/{familyAll}/{oneLine}/{opticalLine}/{oneAdd}/{opticalAdd}/broadband",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public InsertDailyMsgResult<DailyMsgInsert> dailyBMsgResult(@CookieValue(value="userId",required = false) Integer userId,
                                                                @PathVariable("groupAll") int groupAll,
                                                                @PathVariable("dataLine") int dataLine,@PathVariable("voiceLine") int voiceLine,
                                                                @PathVariable("gprsLine") int gprsLine,@PathVariable("rentLine") int rentLine,
                                                                @PathVariable("groupMsg") int groupMsg,@PathVariable("schoolLine") int schoolLine,
                                                                @PathVariable("familyAll") int familyAll,@PathVariable("oneLine") int oneLine,
                                                                @PathVariable("opticalLine") int opticalLine,@PathVariable("oneAdd") int oneAdd,
                                                                @PathVariable("opticalAdd") int opticalAdd)
    {
        if(userId==null)
        {
            return new InsertDailyMsgResult<DailyMsgInsert>(false,"未注册");
        }

        InsertDailyMsgResult<DailyMsgInsert> result;

        try{
            DailyMsgInsert broadbandDaily = dailyMessageService.broadbandDaily(userId,groupAll,dataLine,voiceLine,gprsLine,
                                                                                rentLine,groupMsg,schoolLine,familyAll,oneLine,
                                                                                opticalLine,oneAdd,opticalAdd);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,broadbandDaily);
        }catch (UserAuthException e1){
            DailyMsgInsert broadbandDaily = new DailyMsgInsert(DailyMsgEnums.PERMISSION_ERROR);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,broadbandDaily);
        }catch (RepeatException e2){
            DailyMsgInsert broadbandDaily = new DailyMsgInsert(DailyMsgEnums.REPEAT);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,broadbandDaily);
        }catch (Exception e){
            DailyMsgInsert broadbandDaily = new DailyMsgInsert(DailyMsgEnums.INNER_ERROR);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,broadbandDaily);
        }

    }

    @RequestMapping(value = "/{gsmAll}/{gsmWave}/{gsmDead}/{rsAll}/{rsDead}/{lteAll}/{lteWave}/{lteDead}/{wlanAc}/{wlanHot}/{wlanAp}/{wlanAllvo}/{wlanApdead}/{wlanApdrop}/wireless",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public InsertDailyMsgResult<DailyMsgInsert> dailyWMsgResult (@CookieValue(value="userId",required = false) Integer userId,
                                                                 @PathVariable("gsmAll") int gsmAll, @PathVariable("gsmWave") int gsmWave,
                                                                 @PathVariable("gsmDead") int gsmDead, @PathVariable("rsAll") int rsAll,
                                                                 @PathVariable("rsDead") int rsDead, @PathVariable("lteAll") int lteAll,
                                                                 @PathVariable("lteWave") int lteWave, @PathVariable("lteDead") int lteDead,
                                                                 @PathVariable("wlanAc") int wlanAc, @PathVariable("wlanHot") int wlanHot,
                                                                 @PathVariable("wlanAp") int wlanAp, @PathVariable("wlanAllvo") float wlanAllvo,
                                                                 @PathVariable("wlanApdead") float wlanApdead, @PathVariable("wlanApdrop") float wlanApdrop)
    {
            if(userId==null)
            {
                return new InsertDailyMsgResult<DailyMsgInsert>(false,"未注册");
            }

            InsertDailyMsgResult<DailyMsgInsert> result;

            try{
                DailyMsgInsert wirelessDaily = dailyMessageService.wirelessDaily(userId,gsmAll,gsmWave,gsmDead,rsAll,rsDead,
                                                                                    lteAll,lteWave,lteDead,wlanAc,wlanHot,wlanAp,
                                                                                    wlanAllvo,wlanApdead,wlanApdrop);
                return new InsertDailyMsgResult<DailyMsgInsert>(true,wirelessDaily);
            }catch (UserAuthException e1){
                DailyMsgInsert wirelessDaily = new DailyMsgInsert(DailyMsgEnums.PERMISSION_ERROR);
                return new InsertDailyMsgResult<DailyMsgInsert>(true,wirelessDaily);
            }catch (RepeatException e2){
                DailyMsgInsert wirelessDaily = new DailyMsgInsert(DailyMsgEnums.REPEAT);
                return new InsertDailyMsgResult<DailyMsgInsert>(true,wirelessDaily);
            }catch (Exception e){
                DailyMsgInsert wirelessDaily = new DailyMsgInsert(DailyMsgEnums.INNER_ERROR);
                return new InsertDailyMsgResult<DailyMsgInsert>(true,wirelessDaily);
            }

    }

    @RequestMapping(value = "/{gsmAllvo}/{gsmBusyvo}/{gsmAlldata}/{gsmbusydata}/{gsmUsage}/{gsmConnect}/{gsmDrop}/{lteAlldata}/{lteBusy}/{lteConnect}/{lteSwitch}/{lteDrop}/optimization",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public InsertDailyMsgResult<DailyMsgInsert> dailyOMsgResult(@CookieValue(value="userId",required = false) Integer userId,
                                                                @PathVariable("gsmAllvo") float gsmAllvo,@PathVariable("gsmBusyvo") float gsmBusyvo,
                                                                @PathVariable("gsmAllvo") float gsmAlldata, @PathVariable("gsmAllvo") float gsmbusydata,
                                                                @PathVariable("gsmAllvo")  float gsmUsage, @PathVariable("gsmAllvo") float gsmConnect,
                                                                @PathVariable("gsmAllvo") float gsmDrop, @PathVariable("gsmAllvo") float lteAlldata,
                                                                @PathVariable("gsmAllvo") float lteBusy, @PathVariable("gsmAllvo") float lteConnect,
                                                                @PathVariable("gsmAllvo") float lteSwitch, @PathVariable("gsmAllvo") float lteDrop)
    {

        if(userId==null)
        {
            return new InsertDailyMsgResult<DailyMsgInsert>(false,"未注册");
        }

        InsertDailyMsgResult<DailyMsgInsert> result;

        try{
            DailyMsgInsert optimizationDaily = dailyMessageService.optimizationDaily(userId,gsmAllvo,gsmBusyvo,gsmAlldata,gsmbusydata,gsmUsage,
                                                                                 gsmConnect,gsmDrop,lteAlldata,lteBusy,lteConnect,lteSwitch,lteDrop);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,optimizationDaily);
        }catch (UserAuthException e1){
            DailyMsgInsert optimizationDaily = new DailyMsgInsert(DailyMsgEnums.PERMISSION_ERROR);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,optimizationDaily);
        }catch (RepeatException e2){
            DailyMsgInsert optimizationDaily = new DailyMsgInsert(DailyMsgEnums.REPEAT);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,optimizationDaily);
        }catch (Exception e){
            DailyMsgInsert optimizationDaily = new DailyMsgInsert(DailyMsgEnums.INNER_ERROR);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,optimizationDaily);
        }

    }

    @RequestMapping(value = "/{gsmNum}/{lteNum}/{volteNum}/{volteErl}/{lteRatio}/core",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public InsertDailyMsgResult<DailyMsgInsert> dailyCMsgResult(@CookieValue(value="userId",required = false) Integer userId,
                                                                @PathVariable("gsmNum") float gsmNum,
                                                                @PathVariable("lteNum") float lteNum,
                                                                @PathVariable("volteNum") float volteNum,
                                                                @PathVariable("volteErl") float volteErl,
                                                                @PathVariable("lteRatio") float lteRatio)
    {
        if(userId==null)
        {
            return new InsertDailyMsgResult<DailyMsgInsert>(false,"未注册");
        }

        InsertDailyMsgResult<DailyMsgInsert> result;

        try{
            DailyMsgInsert coredaily = dailyMessageService.coreDaily(userId,gsmNum,lteNum,volteNum,volteErl, lteRatio);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,coredaily);
        }catch (UserAuthException e1){
            DailyMsgInsert coredaily = new DailyMsgInsert(DailyMsgEnums.PERMISSION_ERROR);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,coredaily);
        }catch (RepeatException e2){
            DailyMsgInsert coredaily = new DailyMsgInsert(DailyMsgEnums.REPEAT);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,coredaily);
        }catch (Exception e){
            DailyMsgInsert coredaily = new DailyMsgInsert(DailyMsgEnums.INNER_ERROR);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,coredaily);
        }

    }


    @RequestMapping(value = "/{firstUse}/{firstUsage}/{secUse}/{secUsage}/{thirdUse}/{thirdUsage}/{forthUse}/{forthUsage}/{fifthUse}/{fifthUsage}/transfer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public InsertDailyMsgResult<DailyMsgInsert> dailyTMsgResult(@CookieValue(value="userId",required = false) Integer userId,
                                                                @PathVariable("firstUse") String firstUse,@PathVariable("firstUsage")  float firstUsage,
                                                                @PathVariable("secUse") String secUse, @PathVariable("secUsage") float secUsage,
                                                                @PathVariable("thirdUse") String thirdUse, @PathVariable("thirdUsage") float thirdUsage,
                                                                @PathVariable("forthUse") String forthUse, @PathVariable("forthUsage") float forthUsage,
                                                                @PathVariable("fifthUse") String fifthUse, @PathVariable("fifthUsage") float fifthUsage)

    {
        if(userId==null)
        {
            return new InsertDailyMsgResult<DailyMsgInsert>(false,"未注册");
        }

        InsertDailyMsgResult<DailyMsgInsert> result;

        try{
            DailyMsgInsert transferdaily = dailyMessageService.transferDaily(userId,firstUse,firstUsage,secUse,secUsage,thirdUse,thirdUsage, forthUse,forthUsage,fifthUse,fifthUsage);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,transferdaily);
        }catch (UserAuthException e1){
            DailyMsgInsert transferdaily = new DailyMsgInsert(DailyMsgEnums.PERMISSION_ERROR);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,transferdaily);
        }catch (RepeatException e2){
            DailyMsgInsert transferdaily = new DailyMsgInsert(DailyMsgEnums.REPEAT);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,transferdaily);
        }catch (Exception e){
            DailyMsgInsert transferdaily = new DailyMsgInsert(DailyMsgEnums.INNER_ERROR);
            return new InsertDailyMsgResult<DailyMsgInsert>(true,transferdaily);
        }

    }
}
