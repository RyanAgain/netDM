<%--
  Created by IntelliJ IDEA.
  User: AgainP
  Date: 2018-05-29
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html >
<head >
    <%@include file="common/head.jsp" %>
    <title >网络运行日报</title >
</head >
<body style="background-color: #333333;background-image: url('/resource/img/batthern.png')">


<div class="navbar navbar-static-top navbar-inverse">
    <div class="navbar-inner">
        <h4 style="color: whitesmoke"><i class="icon-th-large icon-white">   </i>网络综合管理系统</h4>
    </div>
</div>



<div class="container-fluid" >
    <div class="row-fluid" >
        <%@include file="common/navbar.jsp" %>

        <div class="span10" style="background-color: white;min-height: 800px" >
            <div class="page-header text-center" >
                <h2 ><i class="icon-retweet" > </i >网络运行日报信息填报</h2 ></div >
            <div class="tabwindow" style="margin: 10px">
            <ul class="nav nav-tabs" >
                <li ><a href="#home" data-toggle="tab" >首页汇总</a ></li >
                <li ><a href="#coredaily" data-toggle="tab" >核心数据</a ></li >
                <li ><a href="#transferdaily" data-toggle="tab" >传输数据</a ></li >
                <li ><a href="#wirelessdaily" data-toggle="tab" >无线数据</a ></li >
                <li ><a href="#optimization" data-toggle="tab" >网优数据</a ></li >
                <li ><a href="#broadband" data-toggle="tab" >集客家宽</a ></li >
            </ul >

            <div class="tab-content" >

                <div class="tab-pane active" id="home" >
                    <p >
                        【GSM网络】今天GSM基站${wireless.gsmAll}个，退服未恢复${wireless.gsmDead}，现网在网载波${wireless.gsmWave}个；直放站共${wireless.rsAll}个，退服未恢复${wireless.rsDead}个。昨日忙时GSM用户登记数：${core.gsmNum}万个，全天话务量为${optimization.gsmAllvo}万Erl，最忙时${optimization.gsmBusyvo}万Erl；数据业务量${optimization.gsmAlldata}Gbyte,占三网流量,最忙时数据流量${optimization.gsmbusydata}GByte；最忙时无线利用率${optimization.gsmUsage}%;本月截至${gd7}日，GSM接通率${optimization.gsmConnect}%(挑战值98%)，掉话率${optimization.gsmDrop}%(挑战值0.9%)。</p >
                    <p >
                        【LTE网络】今天LTE基站${wireless.lteAll}个，退服未恢复站点数 ${wireless.lteDead}个。昨日LTE用户数为${core.lteNum}万个。全天数据流量 ${optimization.lteAlldata}Gbyte,占三网流量%,忙时数据流量${optimization.lteBusy}GByte；昨天驻留比为${core.lteRatio}%，业务接通率${optimization.lteConnect}%、切换成功率${optimization.lteSwitch}%、掉线率${optimization.lteDrop}%。</p >
                    <p >【VOLTE网络】${wireless.summitTime} VOLTE用户登记数：${core.volteNum}万人。话务量：${core.volteErl}万Erl。</p >
                    <p >【WLAN网络】${wireless.summitTime}
                        网管运行AC ${wireless.wlanAc}个，热点 ${wireless.wlanHot}个，AP ${wireless.wlanAp}个，上下行总流量是${wireless.wlanAllvo}GByte，本月截至19日AP退服率为${wireless.wlanApdead}%（挑战值为2.00%)，AP下线率为 ${wireless.wlanApdrop}（挑战值：0.2）。</p >
                    <p >【集客家宽】${wireless.summitTime}
                        全网集团客户站点数 ${broadband.groupAll}个（数据专线 ${broadband.dataLine}个、语音专线 ${broadband.voiceLine}个、GPRS ${broadband.gprsLine}个、
                        电路出租 ${broadband.rentLine}个、集团短信 ${broadband.groupMsg}个
                        、校讯通 ${broadband.schoolLine}个）、家庭客户 ${broadband.familyAll}个（一线通 ${broadband.oneLine}个，光纤到户 ${broadband.opticalLine}个），一线通新增 ${broadband.oneAdd}户，新增光纤到户 ${broadband.opticalAdd}户，运行正常，特此汇报。</p >
                </div >

                <div class="tab-pane" id="coredaily" >
                    昨日忙时GSM用户登记数：<input type="text" id="gsmNum" class="input-mini core" >万个
                    <hr />
                    昨日忙时LTE用户登记数：<input type="text" id="lteNum" class="input-mini core" >万个
                    <hr />
                    昨天VOLTE用户登记数： <input type="text" id="volteNum" class="input-mini core" >万人，话务量：<input type="text"
                                                                                                          id="volteErl"
                                                                                                          class="input-mini core" >万Erl
                    <hr />
                    昨天4G驻留比为： <input type="text" id="lteRatio" class="input-mini core" >%
                    <hr />
                    <button class="btn btn-large btn-primary" type="button" id="coresumiit"
                            onclick="dailymessage.coresummit()" >提交
                    </button >
                    <span id="coreErrorInfo" ></span >
                </div >

                <div class="tab-pane" id="transferdaily" >
                    ①: <input type="text" placeholder="基站" id="tj1" class="input-medium transfer" >， <input id="ly1"
                                                                                                            type="text"
                                                                                                            placeholder="利用率"
                                                                                                            class="input-mini transfer" ><span >%</span >
                    <hr >
                    ②: <input type="text" placeholder="基站" id="tj2" class="input-medium transfer" >， <input id="ly2"
                                                                                                            type="text"
                                                                                                            placeholder="利用率"
                                                                                                            class="input-mini transfer" ><span >%</span >
                    <hr >
                    ③: <input type="text" placeholder="基站" id="tj3" class="input-medium transfer" >，<input id="ly3"
                                                                                                           type="text"
                                                                                                           placeholder="利用率"
                                                                                                           class="input-mini transfer" ><span >%</span >
                    <hr >
                    ④: <input type="text" placeholder="基站" id="tj4" class="input-medium transfer" >，<input id="ly4"
                                                                                                           type="text"
                                                                                                           placeholder="利用率"
                                                                                                           class="input-mini transfer" ><span >%</span >
                    <hr >
                    ⑤: <input type="text" placeholder="基站" id="tj5" class="input-medium transfer" >，<input id="ly5"
                                                                                                           type="text"
                                                                                                           placeholder="利用率"
                                                                                                           class="input-mini transfer" ><span >%</span >
                    <hr >
                    <button class="btn btn-large btn-primary" type="button" id="trsumiit"
                            onclick="dailymessage.trsummit()" >提交
                    </button >
                    <span id="trErrorInfo" ></span >
                </div >

                <div class="tab-pane" id="wirelessdaily" >
                    <form class="form-inline" >
                        <p >【GSM网络】今天GSM基站<input type="text" id="gsmAll" class="input-mini wireless" >个，退服未恢复<input
                                type="text" id="gsmDead" class="input-mini wireless" > 个；现网在网载波<input type="text"
                                                                                                      id="gsmWave"
                                                                                                      class="input-mini wireless" >个。
                        </p >
                        <p >直放站共<input type="text" id="rsAll" class="input-mini wireless" >个，退服未恢复<input type="text"
                                                                                                         id="rsDead"
                                                                                                         class="input-mini wirelesswireless" >个。
                        </p >
                        <hr >
                        【LTE网络】今天LTE基站<input type="text" id="lteAll" class="input-mini wireless" >个，退服未恢复站点数<input
                            type="text" id="lteDead" class="input-mini wireless" >个；现网在网载波<input type="text"
                                                                                                 id="lteWave"
                                                                                                 class="input-mini wireless" >。
                        <hr >
                        【WLAN网络】昨天网管运行AC<input type="text" id="wlanAc" class="input-mini wireless" >个，热点<input
                            type="text" id="wlanHot" class="input-mini wireless" >个，AP<input type="text" id="wlanAp"
                                                                                             class="input-mini wireless" >个，上下行总流量<input
                            type="text" id="wlanAllvo" class="input-mini wireless" >GByte<br >
                        <p ><span style="margin-left:115px" >AP退服率为<input type="text" id="wlanApdead"
                                                                          class="input-mini wireless" >%（挑战值为2.00%)，AP下线率为<input
                                type="text" id="wlanApdrop" class="input-mini wireless" >（挑战值：0.2）。</span ></p >
                        <hr >
                        <button class="btn btn-large btn-primary" type="button" id="wlsumiit"
                                onclick="dailymessage.wlsummit()" >提交
                        </button >
                        <span id="wlErrorInfo" ></span >
                    </form >
                </div >

                <div class="tab-pane" id="optimization" >
                    <form >
                        【2G】全天话务量为<input type="text" id="gsmAllvo" class="input-mini opti" >万Erl，最忙时<input type="text"
                                                                                                           id="gsmBusyvo"
                                                                                                           class="input-mini opti" >万Erl；<br >
                        <span style="margin-left:55px" >数据业务量<input type="text" id="gsmAlldata"
                                                                    class="input-mini opti" >GByte，最忙时数据流量<input
                                type="text" id="gsmbusydata" class="input-mini opti" >GByte；<br ></span >
                        <span style="margin-left:55px" > 最忙时无线利用率<input type="text" id="gsmUsage"
                                                                        class="input-mini opti" >%；<br ></span >
                        <span style="margin-left:55px" > 本月截至<input type="text" id="opdate" class="input-mini opti" >日，GSM接通率<input
                                type="text" id="gsmConnect" class="input-mini opti" >% ( 挑战值98% )，掉话率<input type="text"
                                                                                                            id="gsmDrop"
                                                                                                            class="input-mini opti" >% ( 挑战值0.9% )。</span >
                        <hr >
                        【4G】全天数据流量<input type="text" id="lteAlldata" class="input-mini opti" >GByte,忙时数据流量<input
                            type="text" id="lteBusy" class="input-mini opti" >GByte，<br ></span >
                        <span style="margin-left:55px" > 业务接通率<input type="text" id="lteConnect"
                                                                     class="input-mini opti" >%，切换成功率<input type="text"
                                                                                                            id="lteSwitch"
                                                                                                            class="input-mini opti" >%，掉线率 <input
                                type="text" id="" class="input-mini opti" >%</span >
                        <hr >
                        <button class="btn btn-large btn-primary" type="button" id="opsumiit"
                                onclick="dailymessage.opsummit()" >提交
                        </button >
                        <span id="opErrorInfo" ></span >
                    </form >
                </div >

                <div class="tab-pane" id="broadband" >
                    <form >
                        <b >全网集团客户站点数<input type="text" id="groupAll" class="input-mini broad" >个：</b ><br >
                        数据专线<input type="text" id="dataLine" class="input-mini broad" >个、语音专线<input type="text"
                                                                                                    id="voiceLine"
                                                                                                    class="input-mini broad" >个、GPRS<input
                            type="text" id="gprsLine" class="input-mini broad" >个<br >
                        电路出租<input type="text" id="rentLine" class="input-mini broad" >个、集团短信<input type="text"
                                                                                                    id="groupMsg"
                                                                                                    class="input-mini broad" >个
                        、校讯通<input type="text" id="schoolLine" class="input-mini broad" >个<br >
                        <hr >
                        <b >家庭客户<input type="text" id="familyAll" class="input-mini broad" >个</b >：<br >
                        一线通<input type="text" id="oneLine" class="input-mini broad" >个，光纤到户<input type="text"
                                                                                                  id="opticalLine"
                                                                                                  class="input-mini broad" >个<br >
                        <b >一线通新增<input type="text" id="oneAdd" class="input-mini broad" >户，新增光纤到户<input type="text"
                                                                                                         id="opticalAdd"
                                                                                                         class="input-mini broad" >户。</b >
                        <hr >
                        <button class="btn btn-large btn-primary" type="button" id="brsumiit"
                                onclick="dailymessage.brsummit()" >提交
                        </button >
                        <span id="brErrorInfo" ></span >
                    </form >

                </div >
            </div >
            </div>
        </div >
    </div >

</div >


</body >
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/resource/script/jquery-3.3.1.min.js" ></script >

<script src="/resource/script/jquery.cookie.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/resource/bootstrap/js/bootstrap.min.js" ></script >

<script src="/resource/script/common.js" type="text/javascript"></script>

<script src="/resource/script/dailymessage.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        common.getnickName()
    });
</script>
</html >
