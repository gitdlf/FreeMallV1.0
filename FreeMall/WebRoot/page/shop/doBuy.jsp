<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单正在处理</title>
    <link type="text/css" href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath }/css/activity.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/content2.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath }/js/content2.js"></script>
</head>
<body>
<div class="header">
	<%@include file="/page/header/cartHeader.jsp" %>
</div>
<div class="dobugmiddle">
    <div class="dobugmiddlecenter">
        恭喜！购买成功！正在跳转订单页面...
		<span id="turntoUrl" style="display: none">${pageContext.request.contextPath }/control/queryorder</span>
    </div>

</div>

<div class="fooder">
	 <%@include file="/page/fooder/fooder.jsp" %>
</div>
<script type="text/javascript">
	setInterval(function () {
		var url=$("#turntoUrl").html();
		window.open(url,"_self");
	}, 1000)
</script>
</body>
</html>