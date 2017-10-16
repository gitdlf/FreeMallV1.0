<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>

	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

	<title>404 - 当前页面不存在</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>

	<style>

	body{

		background: #ccc;

	}

	.xy{

		width: 650px;

		height: 400px;

		position: absolute;

		top: 50%;

		left: 50%;

		margin-left: -325px;

		margin-top: -200px;

	}

	.xydd{

		color: #999;

		font-family: '微软雅黑';

		font-size: 20px;

		text-align: center;

	}

	</style>

</head>

<body>
	<div class="xy">

		<img src="${pageContext.request.contextPath }/images/404.jpg" alt="" />

	</div>

	<div class="xydd">

		<h1>当前页面被UFO抓走了！！！</h1>
		<h5 id="showTime"><span>3</span>秒后跳转到首页...</h5>

	</div>
<span id="turntoUrl" style="display: none">${pageContext.request.contextPath }/index</span>
<script type="text/javascript">
	setInterval(function () {
		var url=$("#turntoUrl").html();
		var showTime=$("#showTime span").html();
		if(showTime<=1){
			window.open(url,"_self");	
		}else{
			showTime--;
			$("#showTime span").html(showTime);
		}
		
		
	}, 1000);
</script>
</body>

</html>

<!--代码整理：js代码 www.jsdaima.com-->