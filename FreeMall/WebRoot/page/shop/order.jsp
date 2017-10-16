<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Freemall 订单页</title>
    <link type="text/css" href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath }/css/order.css" rel="stylesheet">
     <link rel="stylesheet" href="${pageContext.request.contextPath }/css/content2.css" type="text/css">
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath }/js/order.js"></script>
    <script src="${pageContext.request.contextPath }/js/content2.js"></script>
</head>
<body>
    <div class="header">
    	<%@include file="/page/header/header.jsp" %>
    </div>
    <!--订单内容页-->
    <!-- 订单内容页开始 -->
    <div class="ordermiddle">
        <div class="order_panel">
        	<!--表示导航开始  -->
            <div class="tabs_mod_container">
                <div class="tabs_mod_main" id="tabsModMain">
                    <!--标识状态-->
                    <label id="tabsModSelect" style="display: none">${ORDERSTATE }</label>
                    <a href="${pageContext.request.contextPath }/control/queryorder?orderstate=0">
                        <div class="tabs_mod_tab">
                             <div class="nav_mod_tab">
                                    <span class="nav_mod_text">所有订单</span>
                                    <span class="tabs_mod_sep">|</span>
                             </div>
                        </div>
                    </a>
                    <a href="${pageContext.request.contextPath }/control/queryorder?orderstate=1">
                        <div class="tabs_mod_tab">
                            <div class="nav_mod_tab">
                                <span class="nav_mod_text">待付款</span>
                                <span class="tabs_mod_sep">|</span>
                            </div>
                        </div>
                    </a>
                    <a href="${pageContext.request.contextPath }/control/queryorder?orderstate=2">
                        <div class="tabs_mod_tab">
                            <div class="nav_mod_tab">
                                <span class="nav_mod_text">待发货</span>
                                <span class="tabs_mod_sep">|</span>
                            </div>
                        </div>
                    </a>
                    <a href="${pageContext.request.contextPath }/control/queryorder?orderstate=3">
                        <div class="tabs_mod_tab">
                            <div class="nav_mod_tab">
                                <span class="nav_mod_text">待收货</span>
                                <span class="tabs_mod_sep">|</span>
                            </div>
                        </div>
                    </a>
                    <!-- 待评价暂时不做 -->
                    <a href="${pageContext.request.contextPath }/control/queryorder?orderstate=4">
                        <div class="tabs_mod_tab">
                            <div class="nav_mod_tab">
                                <span class="nav_mod_text">待评价</span>
                                <span class="tabs_mod_sep">|</span>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <!--表示导航结束  -->
            <!--头部开始-->
            <div class="bought_mod">
                <div class="bougth_mod_content">宝贝</div>
                <div class="bought_mod_price">单价</div>
                <div class="bought_mod_number">数量</div>
                <div class="bought_mod_option">商品操作</div>
                <div class="bought_mod_pay">实付款</div>
                <div class="bought_mod_state">交易状态</div>
                <div class="bought_mod_deal_option">交易操作</div>
            </div>
            <!-- 头部结束 -->
            <!--预留盒子-->
            <div style="width: 100%; height: 22px;"></div>
            <!--订单展示开始-->
            <div class="bought_wrapper_order" id="boughtWrapperOrder">
                <!--订单项-->
                <c:forEach items="${ORDERLIST }" var="temp">
	                <div class="bought_wrapper_order_item">
		                <!-- 订单状态 -->
	                	<label class="orderStatusName" style="display:none;">${temp.statusName }</label>
	                    <!--订单头-->
	                    <div class="order_item_hd" >
	                        <span class="order_item_date">${temp.createDate }</span>
	                        <span class="order_item_no">订单号:<em>${temp.orderNo }</em></span>
	                    </div>
	                    <!--订单内容-->
	                    <div class="order_item_content">
	                        <!--订单商品内容-->
	                        <div class="order_pro_list">
	                            <!--订单商品项-->
	                            <c:forEach items="${temp.cartEntryList }" var="cartTemp">
		                            <div class="order_pro_item">
		                                <div class="order_pro_info">
		                                    <div class="mod_media_img">
		                                        <a href="${pageContext.request.contextPath }/proview?goodsId=${cartTemp.proId}">
		                                            <img src="${pageContext.request.contextPath }/${cartTemp.imgAddress}" width="80px" height="80px" alt="">
		                                        </a>
		                                    </div>
		                                    <div class="mod_media_detail">
		                                        <a href="${pageContext.request.contextPath }/proview?goodsId=${cartTemp.proId}">
		                                            <span>${cartTemp.proName}</span>
		                                        </a>
		                                        <!--暂定-->
		                                    </div>
		                                    <!--商品价格-->
		                                    <div class="mod_pro_price">
		                                        <span><em>￥</em>${cartTemp.proPrice }</span>
		                                    </div>
		                                    <!--商品数量-->
		                                    <div class="mod_pro_number">
		                                        <span>${cartTemp.proCount }</span>
		                                    </div>
		                                    <!--商品操作-->
		                                    <div class="mod_pro_option">
		                                        <a href="">申请售后</a>
		                                    </div>
		                                </div>
		                            </div>
	                            </c:forEach>
	                        	<!-- 订单项结束 -->
	                        </div>
	                        <!--总价格-->
	                        <div class="pro_item_allPrice">
	                            <span>￥<em></em></span>
	                            <span>(含运费：￥0.00)</span>
	                        </div>
	                        <!--交易状态-->
	                        <div class="pro_item_state">
	                        	<!-- 如果达到那种状态就在前面加上curclass -->
	                        	<span>待付款</span>
	                        	<span>待发货</span>
	                        	<span>待收货</span>
	                            <span>交易成功</span>
	                        </div>
	                        <!--交易操作-->
	                        <div class="pro_item_option">
	                            <p class="margin_button">
	                            	<a href="${pageContext.request.contextPath }/control/commint?orderno=${temp.orderNo }&option=1" class="margin_btn">前往付款</a>
	                            	<a href="${pageContext.request.contextPath }/control/commint?orderno=${temp.orderNo }&option=2" class="margin_btn">等待发货</a>
	                            	<a href="${pageContext.request.contextPath }/control/commint?orderno=${temp.orderNo }&option=3" class="margin_btn">确认收货</a>
	                                <a href="${pageContext.request.contextPath }/control/commint?orderno=${temp.orderNo }&option=4" class="margin_btn">前往评价</a>
	                                <a href="javascript:;" class="margin_btn">交易完成</a>
	                            </p>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
           		<!-- 订单项结束 -->
            </div>
            <!-- 订单展示结束 -->
        </div>
    </div>
    <!-- 订单内容页结束 -->
    <div style="width: 100%;height: 20px ;clear: both"></div>
	<div class="fooder">
		 <%@include file="/page/fooder/fooder.jsp" %>
	</div>
</body>
</html>

