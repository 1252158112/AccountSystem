<%--
  Created by IntelliJ IDEA.
  User: 乐嘉伟
  Date: 2021/6/22
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="Metro-UI-CSS-master/build/css/metro-all.css">
    <title>简单账本</title>
</head>
<body background="Picture/background.jpg" style="background-size:100% 100%;background-attachment: fixed;">
<div style="background-color: rgba(255,255,255,0.21)">

    <div data-role="cube" data-flash-interval="500"></div>
    <div>
        <h1 align="center">欢迎你，新用户</h1>
    </div>
    <div style="width:35%;margin: auto;background-color: rgba(255,255,255,0.6);border-radius: 30px;padding: 20px">
        <%
            if(!(request.getAttribute("message")==null)) {
                out.print("<span class=\"alert tally\" style=\"margin:auto;font-size: 15px \">"+request.getAttribute("message")+"</span>");
            }
        %>
        <div class="text-left">
            <form action="register" method="post" enctype="multipart/form-data">
                <h2>用户名:</h2>
                <div style="left: 20%">
                    <input type="text" class="metro-input" id="username" style="border-radius: 8px;width: 70%;height: 45px" name="username" minlength="8" maxlength="20"><br>
                </div>

                <h2>密码:</h2>
                <div style="left: 20%">
                    <input type="password" class="metro-input" id="password" style="border-radius: 8px;width: 70%;height: 45px" name="password" minlength="8" maxlength="20"><br>
                </div>
                <br>
                你可以选择你的头像：
                <div class="text-right">
                    <input type="file" name="picture"  placeholder="picture" data-button-title="<span class='mif-folder'></span>">
                </div>
                <br>
                <div class="text-center">
                   <a href="login" style="text-decoration: none"><input type="button" class="button" value="我想去登录" style="border-radius: 10px;font-size: 10px"></a>
                </div>
                <div class="text-right">
                    <input type="submit" class="button" value="注册" style="border-radius: 10px;font-size: 25px">
                </div>

            </form>
        </div>
    </div>
</div>
<script src="Metro-UI-CSS-master/build/js/metro.min.js"></script>
</body>
</html>
