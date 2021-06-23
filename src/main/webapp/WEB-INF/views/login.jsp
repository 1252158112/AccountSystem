<%--
  Created by IntelliJ IDEA.
  User: 乐嘉伟
  Date: 2021/6/20
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="Metro-UI-CSS-master/build/css/metro-all.css">
    <title>简单账本</title>
    <%
        Cookie[] cookies=request.getCookies();
        String Username="";
        String Password="";
        String RememberMe="";
        if (cookies!=null){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("cUsername")){
                    Username=cookie.getValue();
                }
                if (cookie.getName().equals("cPassword")){
                    Password=cookie.getValue();
                }
                if (cookie.getName().equals("cRememberMe")){
                    RememberMe=cookie.getValue();
                }
            }
        }
        if(!RememberMe.equals("1")) {
            Username="";
            Password="";
        }
    %>
</head>
<body background="Picture/background.jpg" style="background-size:100% 100%;background-attachment: fixed;">
<div style="background-color: rgba(255,255,255,0.21)">

    <div data-role="cube"></div>
    <div>
        <h1 align="center">登录</h1>
    </div>
    <div style="width:35%;margin: auto;background-color: rgba(255,255,255,0.6);border-radius: 30px;padding: 20px">
        <%
            if(!(request.getAttribute("message")==null)) {
                out.print("<span class=\"alert tally\" style=\"margin:auto;font-size: 15px \">"+request.getAttribute("message")+"</span>");
            }
        %>
        <div class="text-left">
            <form action="login" method="post">
                <h2>用户名:</h2>
                <div style="left: 20%">
                    <input type="text" class="metro-input" id="username" style="border-radius: 8px;width: 70%;height: 45px" name="username" minlength="8" maxlength="20" value="<%=Username%>"><br>
                </div>

                <h2>密码:</h2>
                <div style="left: 20%">
                    <input type="password" class="metro-input" id="password" style="border-radius: 8px;width: 70%;height: 45px" name="password" minlength="8" maxlength="20" value="<%=Password%>"><br>
                </div>
                <br>
                <input type="checkbox" data-role="checkbox" data-caption="帮我记住我的账号和密码" name="rememberMe" data-style="2" value="1" <%="1".equals(RememberMe)? "checked":""%>>
                <div class="text-center">
                    <a href="register" style="text-decoration: none"><input type="button" class="button" value="没有账号？前往注册" style="border-radius: 10px;font-size: 10px"></a>
                </div>
                <div class="text-right">
                    <input type="submit" class="button" value="登录" style="border-radius: 10px;font-size: 25px">
                </div>

            </form>
        </div>
    </div>
</div>
<script src="Metro-UI-CSS-master/build/js/metro.min.js"></script>
</body>
</html>
