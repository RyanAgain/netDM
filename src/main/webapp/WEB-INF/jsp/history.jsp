<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN" >
<head >
    <%@include file="common/head.jsp" %>
    <title >借卡历史</title >

</head >

<body >

<div class="container" >
    <div class="page-header text-center" style="background-color: #dceaf4" >
        <h1 ><span class="icon-retweet" > </span > 核心机房借卡管理系统</h1 >
    </div >

    <div class="text-center"><h4 >出借历史</h4 ></div >
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
            <th >归还时间</th >
        </tr >
        </thead >
        <tbody >
        <c:forEach var="rent" items="${historyInfo}">
        <tr >
            <td >${rent.rentName}</td >
            <td >${rent.rentPhone}</td >
            <td >${rent.cardId}</td >
            <td >${rent.rentReason}</td >
            <td >${rent.roomNum}</td >
            <td >${rent.ydInterface}</td >
            <td ><fmt:formatDate value="${rent.startTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td >
            <td ><fmt:formatDate value="${rent.endTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td >
            </c:forEach>
        </tbody >
    </table >
</div >
</div>

</body >


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/resource/script/jquery-3.3.1.min.js" ></script >
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/resource/bootstap/js/bootstrap.min.js" ></script >


</html >