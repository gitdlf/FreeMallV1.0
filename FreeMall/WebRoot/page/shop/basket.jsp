<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>我的购物车</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/basketlf.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/content2.css">
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath }/js/content2.js"></script>
    <script src="${pageContext.request.contextPath }/js/basket.js"></script>
</head>
<body>
    <div class="header">
    	<%@include file="/page/header/cartHeader.jsp" %>
    </div>
<!--商品详情页内容，宽度为1216,居中，其他没有要求-->
    <div class="yhd_cart_content">
            <!--商品展示start-->
            <div id="cart_main_body">
                <!--配置全局配置的位置-->
                <!--商品区域-->
                <div class="wrap">
                    <!--头部开始-->
                   <div class="wrap_limit">
                       <div class="cart_list_header">
                        <span class="checkbox">
                            <!--如果选择添加checked 样式-->
                            <input type="checkbox" class="check check_all checked" id="all_checked">
                                <i class="iconfont">v</i>
                            </input>
                            全选
                        </span>
                           <span class="tit">商品信息</span>
                           <span class="price">单价（元）</span>
                           <span class="num">数量</span>
                           <span class="total">小计（元）</span>
                           <span class="act">操作</span>
                       </div>
                   </div>
                    <!--头部结束-->
                    <!--//利用form表单传输数据-->
                    <form action="${pageContext.request.contextPath }/control/addorder" method="post">
                        <div class="cart_list_limit" id="cartShopList">
                        	<c:forEach items="${CARTTAG }" var="temp">
                        		 <div class="cart_list cart_shop_list" >
	                                <!--楼层头-->
	                                <div class="cart_tit">
	                                <span class="checkbox">
	                                    <input type="checkbox" class="check check_list checked" value="${temp.cartId }" name="cartlist">
	                                    <a href="${pageContext.request.contextPath }/page/index.jsp" class="label">FreeMall官方旗舰店</a>
	                                </span>
	                                    <!--已免邮-->
	                                    <div class="free_pos">
	                                        已免邮
	                                    </div>
	                                </div>
	
	                                <!--商品内容-->
	                                <div class="cart_list_warp">
	                                    <div class="cart_list_item">
	                                        <!--商品详情-->
	                                        <a href="${pageContext.request.contextPath }/proview?goodsId=${temp.goodsEntry.goodsId}" class="item_pic">
	                                            <img src="${pageContext.request.contextPath }/${temp.goodsEntry.imageAddress}" width="75px" height="75px" alt="">
	                                        </a>
	                                        <a href="${pageContext.request.contextPath }/proview?goodsId=${temp.goodsEntry.goodsId}"  class="item_tit" >
	                                            ${temp.goodsEntry.goodsName}
	                                        </a>
	                                        <!--单价-->
	                                        <div class="item_price">
	                                            <p>${temp.goodsEntry.price}</p>
	                                        </div>
	                                        <!--数量-->
	                                        <div class="item_num">
	                                            <div class="num_act">
	                                                <!--库存-->
	                                                <label class="stockNum" style="display: none">${temp.goodsEntry.stack}</label>
	                                                <a href="javascript:;" class="minus">-</a>
	                                                <input type="text" class="input" value="${temp.proCount}" name="proNum${temp.cartId}">
	                                                <a href="javascript:;" class="add">+</a>
	                                            </div>
	                                            <span class="stock">库存紧张</span>
	                                        </div>
	                                        <!--小计-->
	                                        <div class="item_amount">
	                                            <div class="item_a_money">160.00</div>
	                                        </div>
	                                        <!--操作-->
	                                        <div class="item_act">
	                                            <a href="${pageContext.request.contextPath }/control/delcart?cartid=${temp.cartId}" title="删除" class="del_btn">
	                                            </a>
	                                        </div>
	                                    </div>
	                                </div>
	                                <div style="clear: both;width: 100%;height: 20px" ></div>
	                            </div>
                        	
                        	</c:forEach>
                           
                        	<!-- 内容结束 -->
                        </div>
                        <!--结算工具栏开始-->
                        <div id="checkOutBar" class="setting_column_bar ">
                            <div class="pay_tools_bar">
                                <div class="pay_tools_inner">
                                    <div class="clearfix">
                                        <span class="select_all_innser">
                                            <input type="checkbox" id="selectAllInner">
                                            <label class="all_checked_label">全选（共<b></b>件)</label>
                                        </span>
                                        |
                                        <span></span>
                                    </div>
                                    <div class="clearfix_right">
                                        <!--如果没有选择商品的话就添加unable-->
                                        <a href="javascript:;" class="checkout_btn unable" id="checkoutBtn">去结算</a>
                                        <input id="checkoutSubmit" type="submit" style="visibility: hidden">
                                        <!--<button class="checkout_btn unable">去结算</button>-->
                                        <div class="r_price_total" id="rPriceTotal">
                                            合计：
                                            <span class="rpt_count">￥<b>0.00</b></span>
                                        </div>
                                        <div class="r_prod_view">
                                            <span class="rpt_count" id="rptCount">
                                                已选商品
                                                <b></b>
                                                件
                                            </span>|
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <!--结算工具栏结束-->
                    </form>
                </div>
            </div>
            <!--商品展示end-->
    </div>
    <div style="width: 100%;height: 50px;"></div>
    <div class="fooder"></div>
</body>
</html>

