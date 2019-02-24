<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>注 册</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function checkName() {
            var name = $("#username").val();
            if (name == ""||name==null) {
                $("#passwordInfo").text("用户名不能为空！");
            }else {
                $("#submit").prop("disabled","");
            }
        };

        function checkPwd() {
            var pwd1 = $("#pwd1").val();
            var pwd2 = $("#pwd2").val();
            console.log(pwd2);
            if (pwd1==pwd2){
                $("#passwordInfo").text("");
                $("#submit").prop("disabled","");
            }else {
                $("#passwordInfo").text("两次输入的密码不一致!");
            }
        };
    </script>
</head>
<body>
<div id="header" class="wrap">
    <img src="${pageContext.request.contextPath}/images/logo.gif"/>
</div>
<div id="navbar" class="wrap">
    <div class="search">
        <!--
            <form method="get" action="index.html">
                <input type="text" name="keywords" class="input-text" /><input type="submit" name="submit" class="input-button" value="" />
            </form>
        -->
    </div>
</div>
<div id="register" class="box">
    <h2>新用户注册</h2>
    <div class="content">
        <form method="post" action="${pageContext.request.contextPath}/user/regist" id="checkForm">
            <dl>
                <dt>用户名：</dt>
                <dd><input id="username" type="text" class="input-text" name="vuUserName" onblur="checkName()"/></dd>
                <dt>密码：</dt>
                <dd><input id="pwd1" type="password" class="input-text" name="vuPassword" /></dd>
                <dt>确认密码：</dt>
                <dd><input  id="pwd2" type="password" class="input-text" name="confirmPassword" onKeyUp  ="checkPwd()" /></dd>
                <span id="passwordInfo" style="color:red"></span>
                <dt></dt>
                <dd><input type="submit" value=" " class="input-button" name="submit" disabled="disabled" id="submit"/></dd>
            </dl>
        </form>
        <div class="error"><%--<s:fielderror/>--%></div>
        <div class="error"><%--<s:actionerror/>--%></div>
    </div>
</div>
<div id="footer" class="wrap">
    百知 &copy; 版权所有
</div>
</body>
</html>
