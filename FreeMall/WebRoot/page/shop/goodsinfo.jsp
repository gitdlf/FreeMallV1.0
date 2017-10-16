<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>商品详情</title>
<link type="text/css" href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
<link type="text/css" href="${pageContext.request.contextPath }/css/goodsinfo.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/content2.css" type="text/css">
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath }/js/content2.js"></script>
</head>
<body>
<div class="header">
	<%@include file="/page/header/header.jsp" %>
</div>
<!--商品详情页内容，1076,居中，其他没有要求-->
     <div class="detail_wrap">
         <!--商品描述区域-->
         <div class="pro_detail_one">
             <!--左侧主图区域-->
             <div class="pro_detail_img">
                 <div class="pro_img">
                     <img id="proImgAddToMiniCart"  src="${pageContext.request.contextPath }/${GOODSINFO.imageAddress}" height="360px" alt="">
                 </div>
             </div>
             <!--右侧描述区域-->
             <div class="pro_content">
                 <div class="pro_detail_infomation">
                     <div class="mod_detailinfo_proName">
                         <h1 id="proNameAddToMiniCart" class="mh">${GOODSINFO.goodsName}</h1>
                     </div>
                     <div class="mod_detailinfo_priceSales">
                         <div class="price">
                             <ul class="clearfix">
                                 <li class="tag">价格</li>
                                 <li class="price_number">
                                     <span class="current_price" id="proPriceAddToMiniCart">
                                         <em>￥</em>
                                         ${GOODSINFO.price}
                                     </span>
                                 </li>
                                 <li class="price_rel"></li>
                             </ul>
                         </div>
                         <div class="msgbox">
                             <p>
                                 <span>支持</span>
                                 <a href="javascript:;">货到付款</a>
                                 <span class="line">|</span>
                                 <a href="javascript:;">免运费</a>
                             </p>
                         </div>
                         <div class="new-dong">
                             <img class="dimg" src="${pageContext.request.contextPath }/images/goodsinfo/new-top.png" alt="">
                             <span>冰点价</span>
                         </div>
                     </div>

                     <div class="mod_detailinfo_address">
                         <p>
                             本商品有自由购自营提供，支持&nbsp;
                             <a href="javascript:;">准时达</a>&nbsp;
                         </p>
                     </div>
                     <div class="mod_cuputing">
                         <div class="cuputing_clearfix">
                             <div class="computing_item">
                                 <div class="computing_num">
                                     <!--库存-->
                                     <span id="proMaxNum" style="display: none"> ${GOODSINFO.stack}</span>
                                     <input type="text" value="1" class="num" id="proNum">
                                 </div>
                                 <div class="computing_act">
                                     <input type="button" class="add" id="proNumAdd">
                                     <input type="button" class="no_reduce" id="proNumSub">
                                 </div>
                             </div>
                             <div class="cartbox">
                             <%-- ${pageContext.request.contextPath }/control/cart?goodsId=${GOODSINFO.goodsId} --%>
                                 <a href="${pageContext.request.contextPath }/control/cart?goodsId=${GOODSINFO.goodsId}" class="buy_btn" id="cart_buy_btn"><span></span></a>
                             </div>
                         </div>
                         <label id="maxErrorInfo">*已达到最大库存</label>
                         <label id="cartBuyInfo"></label>
                     </div>
                 </div>
             </div>
         </div>

         <!--详细描述区域-->
         <div class="pro_detail_two">
             <div class="pro_detail_info">
                <div class="pro_detail_info_title">
                    <i></i>
                    <span>商品详情</span>
                    <div class="des_info">
                        <dl>
                            <dt>规格参数</dt>
                            <dd>产地:中国大陆</dd>
                            <dd>类别:食品</dd>
                            <dd>口味:其他口味</dd>
                            <dd>进口/国产:国产</dd>
                            <dd>组合包装:组合装</dd>
                            <dd>描述:${GOODSINFO.introduce}</dd>
                        </dl>
                    </div>
                </div>
             </div>
            <div style="width: 300px;height: 180px;"></div>
         </div>
         <!--用户评价区域-->
         <div class="pro_detail_three">
             <div class="user_message">
                 <div class="user_message_title">
                     <i></i>
                     <span>用户评价</span>
                 </div>
                 <div class="comment_con">
                    <div class="main">
                    	<c:forEach items="${GOODSINFO.messageList }" var="temp">
                    		<div class="comment_item">
	                            <div class="face">
	                                <img src="${pageContext.request.contextPath }/images/goodsinfo/peopleicon_05.gif" width="50px"  height="50px" alt="">
	                            </div>
	                            <div class="namebox">
	                                <span class="name"><em>${temp.createAuthor }</em></span>
	                            </div>
	                            <dl>
	                                <dt class="user_info">
	                                    <span class="typeNum">评分：</span>
	                                    <span class="start s${temp.userState }"></span>
	                                </dt>
	                                <dd class="clearfix">
	                                    <span class="type">内容：</span>
	                                    <span class="text">&nbsp;&nbsp;${temp.content }</span>
	                                </dd>
	                                <dd class="replyBtn">
	                                    <span class="date">时间：${temp.createDate }</span>
	                                </dd>
	                            </dl>
                       		</div>
                    	</c:forEach>
                    </div>
                 </div>
             </div>
         </div>
    </div>
<div class="fooder">
	<%@include file="/page/fooder/fooder.jsp" %>
</div>

</body>
</html>