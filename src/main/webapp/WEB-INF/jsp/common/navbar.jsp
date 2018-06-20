<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="span2" style="background-color: white;min-height: 800px">

    <div class="logo" style="margin: 10px">
        <div class="media" >
            <a href="#" class="pull-left">
                <img class="media-object" src="/resource/img/userlogo.png" alt="用户头像" style="width: 64px;height: 64px" >
            </a>
            <div class="media-body">
                <h5 class="media-heading" id="nickName"></h5>
                <button class="btn btn-small btn-inverse" onclick="common.logout()">注销</button>
            </div>
        </div >
    </div>
    <ul class="nav nav-tabs nav-stacked">
        <li class="nav-header" style="font-size: 15px;color: whitesmoke; background-color: #333333">管理模块</li>
        <li><a href="#" >首页（建设中）</a ></li>
        <li ><a href="/dm/cardrent" >机房出入管理</a ></li >
        <li ><a href="/dm/message" >日常信息报送</a ></li >
        <li ><a href="#" >应急信息报送（建设中）</a ></li >

    </ul>

</div>
