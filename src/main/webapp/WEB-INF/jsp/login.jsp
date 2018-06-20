<%--
  Created by IntelliJ IDEA.
  User: AgainP
  Date: 2018-06-07
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN" >
<head >
    <%@include file="common/head.jsp" %>
    <title >肇庆网管综合管理系统</title >
</head >
<body style="background-color: #333333;background-image: url('/resource/img/batthern.png')">

<div class="navbar navbar-static-top navbar-inverse">
    <div class="navbar-inner">
        <h4 style="color: whitesmoke"><i class="icon-th-large icon-white">   </i>网络综合管理系统</h4>
    </div>
</div>

<div class="span6 offset3" id="loginbox" style="background-color:rgba(255,255,255,0.8);border:medium double black;position: absolute;left: 20%;top: 150px">
    <div class="text-center">
        <h3 >肇庆网管综合管理系统</h3 >
    </div >
    <div >
        <div class="control-group text-center" >
            <div class="controls" >
                <div class="input-prepend" >
                    <span class="add-on" ><i class="icon-user" ></i ></span >
                    <input class="span4 offset2" id="username" type="text" placeholder="请输入账号" >
                </div >
            </div >
        </div >

        <div class="control-group text-center" >
            <div class="controls" >
                <div class="input-prepend" >
                    <span class="add-on" ><i class="icon-lock" ></i ></span >
                    <input class="span4 offset2" id="passwd" type="password" placeholder="请输入密码" >
                </div >
            </div >
        </div >
    </div >
    <div class="text-center">
        <span id="loginMessage"></span>
        <button class="btn btn-primary" id="loginAuth" onclick="login.loginauth()">登录</button >
    </div >
</div >


</body >

<script src="/resource/script/jquery-3.3.1.min.js" ></script >

<script src="/resource/script/jquery.cookie.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/resource/bootstrap/js/bootstrap.min.js" ></script >

<script src="/resource/script/login.js" type="text/javascript" ></script >

</html >
