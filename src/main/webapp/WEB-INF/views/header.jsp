<%--
  Created by IntelliJ IDEA.
  User: 乐嘉伟
  Date: 2021/6/22
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="Metro-UI-CSS-master/build/css/metro-all.css">
    <title>我的主页</title>
</head>
<body background="Picture/background.jpg" style="background-size:100% 100%;background-attachment: fixed;">

<div data-role="appbar" data-expand-point="md" style="background-color:#6AAB9C;height: 10%;opacity: 85%">
    <ul class="app-bar-menu">
        <li><a href="#">我的主页</a></li>
        <li>
            <a href="#" class="dropdown-toggle">我的账户</a>
            <ul class="d-menu" data-role="dropdown">
                <li><a href="#">展示全部</a></li>
                <li class="divider bg-lightGray"></li>
                <li><a href="#">账户1</a></li>
                <li><a href="#">账户2</a></li>
            </ul>
        </li>
        <li><a href="#">联系开发者</a></li>
        <li><a href="#">个人信息</a></li>
    </ul>
</div>
<div style="height:10%;opacity: 100% "></div>
</body>
</html>
