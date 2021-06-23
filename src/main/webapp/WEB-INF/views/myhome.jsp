<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: 乐嘉伟
  Date: 2021/6/22
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%
    User user=(User)request.getAttribute("user");
    String pic;
    pic=user.getPicture() == null?"Picture/userPic.jpg":"getImg?id="+user.getUserid();
%>
<html>
<body>
<div id="menu" class="bg-white" style="width:15%;height:100%;opacity: 85%;float:right">
    <div class="social-box">
        <div class="header fg-white" style="background-color:#6AAB9C">
            <img src="<%=pic%>" class="avatar" >
            <div class="title">${user.getUsername()}</div>
            <div class="subtitle">你从${user.getRegisterDate()}来到这里哟</div>
        </div>
        <ul class="skills">
        <li>
            <div class="text-bold">6</div>
            <div>账户</div>
        </li>
        <li>
            <div class="text-bold">4</div>
            <div>记账</div>
        </li>
        </ul>
    </div>
    <div style="height:100px;width: 100px;background-color: #6AAB9C;position: fixed;right: 3.4%;bottom: 10%;border-radius: 1000px;opacity: 80%">
        <div style="top:34px;margin:auto auto;text-align:center">
            <a style="text-decoration: none;color: black" href="#"><h3>记账</h3></a>
        </div>
    </div>
</div>
<div id="content" style="background-color:#EEEEEE;height:100%;width:85%;opacity: 85%;float:right;">
    <div data-role="splitter" class="h-100" data-min-sizes="250">
        <div class="d-flex flex-justify-center flex-align-center">This is panel 1</div>
        <div data-role="splitter" data-split-mode="vertical" data-min-sizes="150">
            <div class="d-flex flex-justify-center flex-align-center">Panel 1</div>
            <div class="d-flex flex-justify-center flex-align-center">Panel 2</div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
