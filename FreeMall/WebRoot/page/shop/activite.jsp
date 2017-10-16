<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>最新活动</title>
    <link type="text/css" href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/css/activite.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/content2.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath }/js/content2.js"></script>
</head>
<body>
<!--这是头部展示-->

<div class="header">
	<%@include file="/page/header/header.jsp" %>
</div>

<!--这是中间展示-->
<div class="activitycenter">

    <!--活动头部 start-->
    <!--  得用el表达式获取-->
    	<div class="activite_header">
        <a href="#"><img src="${pageContext.request.contextPath}/${ACTIVITYENTRY.proIdList[0].backgroundImagesAddress}" ></a>
    </div>
    <!--活动头部  end-->
    <!--活动推荐商品父容器 start-->
    <div class="activite_recommend_main">
    <!--活动推荐商品子容器 start-->
    <div class="activite_recommend_product">
        <!--活动推荐标题 start-->
        <div class="activite_recommend_title">
            <div class="activite_recommend_title_wire">\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\</div>
            <div class="activite_recommend_title_blank"></div>
            <div class="activite_recommend_title_name_main">
                <div class="activite_recommend_title_name">店铺推荐</div>
                <div class="activite_recommend_title_f_name">TREND GLASSES</div>
            </div>
            <div class="activite_recommend_title_blank"></div>
            <div class="activite_recommend_title_wire">\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\</div>
        </div>
        <!--活动推荐标题 end-->
        <!--活动推荐详情 start-->
        <div class="activite_recommend_details">
           <c:forEach items="${ACTIVITYENTRY.proList}" var="temp">
           		<div class="activite_recommend_title_img1">
               	 	<a href="${pageContext.request.contextPath}/proview?goodsId=${temp.goodsId}"><img src="${pageContext.request.contextPath}/${temp.imageAddress}"></a>
            	</div>
           </c:forEach>
        </div>
        <!--活动推荐详情 end-->
    </div>
        <!--活动推荐商品子容器 end-->
    </div>
</div>

<!--&lt;!&ndash;这是尾部展示&ndash;&gt;-->
<div class="fooder">
 	<%@include file="/page/fooder/fooder.jsp" %>
</div>
</body>
</html>