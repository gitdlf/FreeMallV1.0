<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FreeMall商品评价</title>
    <link type="text/css" href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath }/css/activity.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath }/css/evaluate.css" rel="stylesheet">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/content2.css" type="text/css">
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath }/js/content2.js"></script>
    <script src="${pageContext.request.contextPath }/js/evaluate.js"></script>
</head>
<body>
<div class="header">
	<%@include file="/page/header/header.jsp" %>
</div>
<div class="container">
    <div class="w">
        <!--订单描述头部开始-->
        <div class="detail_hd">
            <!--订单信息开始-->
            <div class="orderinfo">
                <h3 class="o-title">评价订单</h3>
                <div class="o-info">
                    <span class="mr20">订单号：<a href="javascript;;" target="_blank"  class="gray1">${ORDERCOMMENTENTRY.orderNo }</a></span>
                    <span>${ORDERCOMMENTENTRY.createDate }</span>
                </div>
            </div>
            <!--订单信息结束-->
        </div>
        <!--订单描述头部结束-->
        <!--订单评价主体内容开始-->
        <div class="mycomment_form">
            <form action="${pageContext.request.contextPath }/control/addcommint" method="post">
                <!--page1 start-->
                <div class="form-part1" id="formPart1">
                    <!--商品开始1-->
                   <c:forEach items="${ORDERCOMMENTENTRY.cartEntryList }" var="temp">
                   		 <div class="f-item ">
	                        <!--初始配置-->
	                        <input type="hidden" name="proIdList" value="${temp.proId}">
	                        <div class="fi-info">
	                            <div class="comment-goods">
	                                <div class="p-img">
	                                    <a href="${pageContext.request.contextPath }/proview?goodsId=${temp.proId}" target="_blank">
	                                        <img width="100px" height="100px" src="${pageContext.request.contextPath }/${temp.imgAddress}" alt="">
	                                    </a>
	                                </div>
	                                <div class="p-name">
	                                    <a href="${pageContext.request.contextPath }/proview?goodsId=${temp.proId}" target="_blank">${temp.proName}</a>
	                                </div>
	                                <div class="p-price">
	                                    <strong>${temp.proPrice}</strong>
	                                </div>
	                                <div class="p-attr"> </div>
	                            </div>
	                        </div>
	                        <div class="fi-operate">
	                            <div class="fi-tip">
	                                <i class="tip-icon"></i>
	                                <em class="tip-text">请至少填写一件商品的评价</em>
	                            </div>
	                            <div class="fop-item fop-star">
	                                <div class="fop-label">商品满意度</div>
	                                <div class="fop-main">
	                                    <span class="commstar">
	                                        <!--如果确定就active属性同时star-info高亮-->
	                                        <span class="star star1"><span style="display: none">1</span></span>
	                                        <span class="star star2"><span style="display: none">2</span></span>
	                                        <span class="star star3"><span style="display: none">3</span></span>
	                                        <span class="star star4"><span style="display: none">4</span></span>
	                                        <span class="star star5"><span style="display: none">5</span></span>
	                                        <span class="star-info highlight"><b>0</b>分</span>
	                                        <!--用于存放星级-->
	                                        <input type="text" value="0" name="state${temp.proId}" style="display: none">
	                                    </span>
	                                </div>
	                                <div class="fop-tip"><i class="tip-icon"></i><em class="tip-text"></em></div>
	                            </div>
	                            <div class="fop-item ">
	                                    <div class="fop-label">评价晒单</div>
	                                    <div class="fop-main">
	                                        <div class="f-textarea">
	                                            <textarea name="message${temp.proId}" placeholder="商品是否给力？快分享你的购买心得吧~"></textarea>
	                                            <div class="textarea-ext">还可输入<span>500</span>字</div>
	                                        </div>
	                                    </div>
	                                    <div class="fop-tip"><i class="tip-icon"></i><em class="tip-text"></em></div>
	                                </div>
	                        </div>
	                    </div>
                   </c:forEach>
                    <!--商品结束1-->
                </div>
                <!--page1 end-->
                <!--page2 start-->
                <!--提交按钮-->
                <div class="f-btnbox">
                    <a href="javascript:;" class="btn-submit" id="valuateBtnSubmit">提交</a>
                    <input type="submit" style="visibility: hidden">
                </div>
                <!--page2 end-->
            </form>
        </div>
        <!--订单评价主体内容结束-->
    </div>
</div>
<div class="fooder">
	<%@include file="/page/fooder/fooder.jsp" %>
</div>
</body>
</html>















