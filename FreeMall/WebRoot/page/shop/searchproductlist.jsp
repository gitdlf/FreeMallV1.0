<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
    <link type="text/css" href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/productlist.css" type="text/css">
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath }/js/productlist.js"></script>
    <script src="${pageContext.request.contextPath }/js/content2.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/content2.css" type="text/css">
</head>
<body>
<div class="header">
	<%@include file="/page/header/header.jsp" %>
</div>
<div class="productlist_content">
    <div class="plist">
        <div class="mod_search_select" id="rankOpDiv">
            <div class="sort_b" id="sortProBtn">
                <a href="javascript:;" class="zh show">综合</a>
                <a href="javascript:;" class="total">销量<i class="iconSearc"></i></a>
                <a href="javascript:;" class="price">价格<i class="iconSearch"></i></a>
                <a href="javascript:;" class="newpro">新品<i class="iconSearch"></i></a>
            </div>
            <!--js的功能等过段时间再做-->
            <div class="between">
                <div class="boxTop" id="boxTopPrice">
                    <input type="text" class="ip1" placeholder="￥">
                    -
                    <input type="text" class="ip2" placeholder="￥">
                </div>
                <ul class="boxCon">
                    <li class="first" id="boxConBtn">
                        <a href="javascript:;" class="btn1">清除</a>
                        <a href="javascript:;" class="btn2">确定</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="mod_product_list">
            <div class="list_width" id="itemSearchList">
            	<!--内容页开始  -->
            	<c:forEach items="${GOODSLIST }" var="temp">
            		<div class="mod_search_pro">
	                    <div class="itemBox">
	                        <div class="proImg">
	                            <a href="${pageContext.request.contextPath }/proview?goodsId=${temp.goodsId}" class="img">
	                                <img src="${pageContext.request.contextPath }/${temp.imageAddress}" width="230px" height="230px" alt="">
	                            </a>
	                        </div>
	                        <p class="proPrice">
	                            <em class="num"><b>￥</b>${temp.price }</em>
	                        </p>
	                        <p class="proName">
	                            <a href="${pageContext.request.contextPath }/proview?goodsId=${temp.goodsId}">${temp.goodsName }</a>
	                        </p>
	                         <p style="width: 220px;height: 18px;"></p>
	                        <div class="item_act">
		                        <div class="shopping_num">
		                            <input type="text" value="1">
		                            <span>
		                            <!--最大库存-->
                                   		<label class="shopping_num_max_pro" style="display: none">${temp.stack}</label>
		                                <a class="add sd">加</a>
		                                <a class="dis_decrease sd">减</a>
		                            </span>
		                            <div class="shopping_actfl">
		                                <a href="${pageContext.request.contextPath }/control/cart?goodsId=${temp.goodsId}" class="pro_buy_btn">
		                                    加入购物车
		                                </a>
		                                 <label class="pro_buy_btn_label" style="display: none"></label>
                                    	<label class="pro_buy_btn_max_error" style="display: none">*超出库存</label>
		                            </div>
		                        </div>
	                    	</div>
	                        <p class="storeTotel"> 销量:<span>${temp.saleNum }</span></p>
	                    </div>
	                </div>
            	</c:forEach>
            <!-- 内容页结束 -->
            
            </div>
        </div>
        <!--分页-->
         <div class="mod_turn_page">
            <!--当前页面-->
            <label id="pageNumber" style="display: none">${PAGEBEAN.currentPage }</label>
            <!--最大页面-->
            <label id="pageMaxNumber" style="display: none">${PAGEBEAN.totalPage }</label>
            <!--页面url缺pg的值-->
            <label id="pageUrl" style="display: none">${pageContext.request.contextPath }/search?keywords=${KEYWORDS }&pg=</label>
            <div class="turn_page" id="turnPage">
                <a href="${pageContext.request.contextPath }/search?keywords=${KEYWORDS }&pg=${PAGEBEAN.currentPage-1 }" class="page_prev page_index_start">上一页</a>
                <!--<a href="">1</a>
                <a href="">2</a>
                <a href="">3</a>-->
                <a href="${pageContext.request.contextPath }/search?keywords=${KEYWORDS }&pg=${PAGEBEAN.currentPage+1 }" class="page_prev">下一页</a>
            </div>
        </div>
    </div>
</div>
<div class="fooder">
	<%@include file="/page/fooder/fooder.jsp" %>
</div>
</body>
</html>
























