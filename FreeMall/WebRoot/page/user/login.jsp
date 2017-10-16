<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath }/js/content2.js"></script>
    <link type="text/css" href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath }/css/content2.css" rel="stylesheet" >
</head>
<body >
<div class="header">
<%@include file="/page/header/header.jsp" %>
</div>

<div class="login_content">
    <div class="login_image">
    <!--图片大小宽：510px 高：315px-->
    <img src="${pageContext.request.contextPath }/images/login/login_info.jpg" width="510px" height="315px">
    </div>
    <div class="login_info">
        <div class="clearfix">
            <span>自由购用户登录</span>
            <a href="${pageContext.request.contextPath }/page/user/register.jsp">注册新账号</a>
        </div>
        <div class="form_item_wrap">
            <form action="${pageContext.request.contextPath }/login" method="post" id="login_form">
                <!--330px*54px-->
                <div class="form_item">
                    <label class="user_ico">&nbsp;</label>
                    <input type="text" class="input_user ipt" placeholder="用户名" name="userName" value="${LOGINUSER.userName }">
                </div>
                <div class="form_item">
                    <label class="pwd_ico">&nbsp;</label>
                    <input type="password" class="input_pwd ipt" placeholder="密码" name=userPwd value="${LOGINUSER.userPwd }">
                </div>
                <div class="clearfix auto_login">
                    <!--<span>自动登录</span>-->
                    <a href="#">忘记密码？</a>
                </div>
                <div>
                    <input type="submit" class="login_btn" id="login_btn">
                </div>
            </form>
            <div class="clearfix">
                <!--内容为error提示，提示登陆失败-->
                <label class="error_info" id="error_info">${LOGINERROR }</label>
            </div>
        </div>
    </div>
</div>
<div class="fooder">
    <%@include file="/page/fooder/fooder.jsp" %>
</div>
</body>
</html>