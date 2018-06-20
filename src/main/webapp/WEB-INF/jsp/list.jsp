<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN" >
<head >
    <%@include file="common/head.jsp" %>
    <title >核心机房借卡管理系统</title >

</head >
<body style="background-color: #333333;background-image: url('/resource/img/batthern.png')">

<div class="navbar navbar-static-top navbar-inverse">
    <div class="navbar-inner">
        <h4 style="color: whitesmoke"><i class="icon-th-large icon-white">   </i>网络综合管理系统</h4>
    </div>
</div>

<div class="container-fluid">

    <div class="row-fluid">
        <%@include file="common/navbar.jsp" %>

<div class="span10" style="background-color: white;min-height: 800px">

    <div class="page-header text-center" >
        <h2 ><i class="icon-retweet" > </i > 核心机房出入管理</h2 >
    </div>

        <div class="row-fluid">
        <ul class="thumbnails" >
            <c:forEach var="card" items="${list}" >
                <li class="span4" >
                    <div class="thumbnail text-center" >
                        <img src="/resource/img/card${card.cardId}.png"
                             alt="${card.cardId}" style="width: 300px;height: 200px">
                        <h4 >${card.cardName}</h4 >
                        <p >
                            <button class="btn btn-success" id="endRentBtn${card.cardId}"
                                    onclick="cardrent.showmodal(${card.cardId})" >借用
                            </button >
                        </p >
                    </div >
                </li >
            </c:forEach >
        </ul >
    </div >

        <div class="page-body"><h4 class="text-center" >借用人情况</h4 >
            <a href="history" target="_blank" >
                <button type="button" class="btn btn-default" style="display: inline;float: right" ><i
                        class="icon-share" > </i >查看出借历史
                </button >
            </a >
            <div class="table-window" style="margin: 5px">
        <table class="table table-bordered" >
            <thead >
            <tr >
                <th >联系人</th >
                <th >电话</th >
                <th >借用卡号</th >
                <th >借用原因</th >
                <th >进入机房</th >
                <th >移动接口人</th >
                <th >借用时间</th >
                <th >归还</th >
            </tr >
            </thead >
            <tbody >
            <c:forEach var="rent" items="${rentinfo}" >
                <tr >
                    <td >${rent.rentName}</td >
                    <td >${rent.rentPhone}</td >
                    <td >${rent.cardId}</td >
                    <td >${rent.rentReason}</td >
                    <td >${rent.roomNum}</td >
                    <td >${rent.ydInterface}</td >
                    <td ><fmt:formatDate value="${rent.startTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td >
                    <td >
                        <button class="btn btn-warning" id="returnBtn${rent.cardId}"
                                onclick="cardrent.returncard(${rent.cardId})" >归还
                        </button >
                    </td >
                </tr >
            </c:forEach >
            </tbody >
        </table >
            </div>
    </div >


    <div class="modal hide fade" id="nameAPhone" >
        <div class="modal-header" >
            <h3 class="modal-title text-center" >
                请填写您的个人信息
            </h3 >
        </div >

        <div class="modal-body" >
            <div class="row" style="margin-bottom: 10px" >
                <div class="span8 offset2" >
                    <div class="input-group input-group-lg" >
                        <%--<span class="glyphicon glyphicon-user input-group-addon"></span>--%>
                        <i class="icon-user" ></i >
                        <input type="text" name="rentName" id="rentNameKey" placeholder="请填写您的姓名" class="form-control" >
                    </div >
                </div >
            </div >

            <div class="row" style="margin-bottom: 10px" >
                <div class="span8 offset2" >
                    <div class="input-group input-group-lg" >
                        <%--<span class="glyphicon glyphicon-phone input-group-addon"></span>--%>
                        <i class="icon-bell" ></i >
                        <input type="text" name="rentPhone" id="rentPhoneKey" placeholder="请填写您的手机"
                               class="form-control" >
                    </div >
                </div >
            </div >

            <div class="row" style="margin-bottom: 10px" >
                <div class="span8 offset2" >
                    <div class="input-group input-group-lg" >
                        <%--<span class="glyphicon glyphicon-question-sign input-group-addon"></span>--%>
                        <i class="icon-question-sign" ></i >
                        <%--<input type="text" name="rentReason" id="rentReasonKey" placeholder="请填写借用原因" class="form-control">--%>
                        <select type="text" name="rentReason" id="rentReasonKey" placeholder="请选择借用原因"
                                class="form-control" >
                            <option >请选择借用原因</option >
                            <option >故障处理</option >
                            <option >日常维护</option >
                            <option >例行巡检</option >
                            <option >工程施工</option >
                            <option >其他</option >
                        </select >
                    </div >
                </div >
            </div >

            <div class="row" style="margin-bottom: 10px" >
                <div class="span8 offset2" >
                    <div class="input-group input-group-lg" >
                        <%--<span class="icon-map-marker input-group-addon"></span>--%>
                        <i class="icon-map-marker" ></i >
                        <%--<input type="text" name="roomNum" id="roomNumKey" placeholder="请填写进入的机房" class="form-control">--%>
                        <select type="text" name="roomNum" id="roomNumKey" placeholder="请填写进入的机房" class="form-control" >
                            <option >请选择进入的机房</option >
                            <option >古塔6楼</option >
                            <option >古塔7楼</option >
                            <option >古塔8楼</option >
                            <option >古塔6-7楼</option >
                            <option >古塔6-8楼</option >
                        </select >
                    </div >
                </div >
            </div >

            <div class="row" >
                <div class="span8 offset2" >
                    <div class="input-group input-group-lg" >
                        <%--<span class="icon-link input-group-addon"></span>--%>
                        <i class="icon-warning-sign" ></i >
                        <input type="text" name="ydinterface" id="ydinterfaceKey" placeholder="请填写移动接口人姓名"
                               class="form-control" >
                    </div >
                </div >
            </div >


        </div >

        <div class="modal-footer" >
            <span id="rentInfoMessage" class="glyphcion" ></span >
            <button id="infoBtn" class="btn btn-success" type="button" >
                <span class="glyphicon glyphicon-ok-sign" ></span >
                确认
            </button >
        </div >
    </div >
</div>
</div >
</div>


</body >
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/resource/script/jquery-3.3.1.min.js" ></script >
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/resource/bootstrap/js/bootstrap.min.js" ></script >

<%--加载holder.js--%>
<script src="/resource/bootstrap/js/holder.js" ></script >

<script src="/resource/script/cardrent.js" type="text/javascript" ></script >

<script type="text/javascript" >
    $(document).ready((function () {
        cardrent.list.init();
        common.getnickName();
    }));


</script >
</html >
