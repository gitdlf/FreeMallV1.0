<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>FreeMall</title>
    <link type="text/css" href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath }/css/side-nav.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath }/css/activity.css" rel="stylesheet">
    <link type="text/css"  href="${pageContext.request.contextPath }/css/banner.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath }/css/cate.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/goodsinfo.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/content2.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/index_banner.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/index_cate.js"></script>
    <script src="${pageContext.request.contextPath }/js/content2.js"></script>
</head>
<body>
<div class="header">
	<%@include file="/page/header/header.jsp" %>
</div>
<div class="middle">
    <div class="cate_main">
        <div class="cate">
            <div class="category">
                <ol class="category_list">
                	<c:forEach items="${INDEXCATEGORY }" var="temp">
	                	<li class="cate_menu_item">
	                        <div class="cates"><a href="${pageContext.request.contextPath }/category?cate=parent&cateid=${temp.parentCateId}">${temp.parentCateName }</a></div>
	                    </li>
                	</c:forEach>
                </ol>
            </div>
        </div>
        <div class="hidden_main">
            <ol class="hidden_list">
            	<c:forEach items="${INDEXCATEGORY }" begin="0" var="temp">
            		<li class="hidden_list_item">
	                    <div class="hidden_part">
	                        <div class="details">
	                        	<div class="limit_details">
	                        		<c:forEach items="${temp.childCateList }" var="item">
	                    				<a href="${pageContext.request.contextPath }/category?cate=child&cateid=${item.childCateId}">${item.childCateName}</a>
	                    			</c:forEach>
	                        	</div>
	                        </div>
	                        <div class="img_details">
	                        	<c:forEach items="${temp.goodsList }" var="temp">
	                        		<a href="${pageContext.request.contextPath }/proview?goodsId=${temp.goodsId}"><img src="${pageContext.request.contextPath }/${temp.imageAddress}" ></a>
	                        	</c:forEach>
	                        </div>
	                    </div>
	                </li>
            	</c:forEach>
            </ol>
        </div>
    </div>

    <!--banner start-->
    <div class="banner">
        <!--banner_main start-->
        <div class="banner_main">
            <!--banner_ul start-->
            <ul class="banner_ul">
            	<c:forEach items="${INDEXBANNER }" var="temp">
            		<li><a href="${pageContext.request.contextPath }/category?cate=parent&cateid=${temp.parentCateId}"><img src="${pageContext.request.contextPath }${temp.imageAddress}"></a></li>
            	</c:forEach>
            </ul>
        </div>
        <!--banner_ul end-->
        <!--banner_span start-->
        <div class="banner_span">
            <p>
                <span class="active"></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </p>
        </div>
        <p class="prev"></p>
        <p class="next"></p>
    </div>
    <!--banner_span end-->
    <div class="activity">
        <div class="activeul">
            <div class="activeul_header">
                <div class="activep_div activep_show" id="activep_one"><p class="activep select_show">促销</p></div>
                <div class="activep_div" id="activep_two"> <p class="activep">公告</p></div>
                <div class="activep_div"><p class="activep activep_more"><a href="#">更多</a></p></div>
            </div>
            <!--设置最新活动的内容-->
            <ul class="activeul" id="activeul_one">
                <li class="activenbsp"></li>
                <li class="activeli"><a href="${pageContext.request.contextPath }/activity?activityNo=1000000454125857"class="activea">限时特购1号专项限时行动</a></li>
                <li class="activeli"><a href="#"class="activea">国际大牌厨具799减200</a></li>
                <li class="activeli"> <a href="#"class="activea">会员充值200返100，多充多送</a></li>
                <li class="activeli"><a href="#"class="activea">联想笔记本半价优惠，仅此一日哦！</a></li>
                <li class="activeli"><a href="#"class="activea">积分兑换正在进行中...</a></li>
                <li class="activeli"><a href="#"class="activea">全场商品5人以上团购1折</a></li>
                <li class="activeli"><a href="#"class="activea">全场男装购买达1000元及以上5折起</a></li>
                <li class="activeli"><a href="#"class="activea">美妆到新货了，美女们不要错过啊</a></li>
                <li class="activeli"><a href="#"class="activea">水星家纺尚新低至12.9元</a></li>
            </ul>
            <ul class="activeul activeul2" id="activeul_two">
                <li class="activenbsp"></li>
                <li class="activeli"><a href="#"class="activea">美妆到新货了，美女们不要错过啊</a></li>
                <li class="activeli"> <a href="#"class="activea">会员充值200返100，多充多送</a></li>
                <li class="activeli"><a href="#"class="activea">买手机送女友了</a></li>
                <li class="activeli"><a href="#"class="activea">国际大牌厨具799减200</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="content">
    <div class="content_size">
        <div class="side-nav" id="sideNav"><!-- 这是侧边框-->
            <div class="side_nav_filex">
                <ul>
                    <li class="csnli1"><a href="#achorAIC" class="csna">家电手机</a></li>
                    <li class="csnli2"><a href="#achorCOD" class="csna">电脑数码</a></li>
                    <li class="csnli3"><a href="#achorP3C" class="csna">3C运动</a></li>
                    <li class="csnli4"><a href="#achorLBB" class="csna">母婴家具</a></li>
                    <!--<li class="csnli5"><a href="#" class="csna">家居生活</a></li>
                    <li class="csnli6"><a href="#" class="csna">手机家电</a></li>
                    <li class="csnli7"><a href="#" class="csna">服饰鞋包</a></li>
                    <li class="csnli8"><a href="#" class="csna">科技产品</a></li>
                    <li class="csnli9"><a href="#" class="csna">懂你想要</a></li>-->
                </ul>
            </div>
        </div>
        
        <!-- 中部雷荣展示域 -->
          <div class="index_content_shop" id="chnInnerWrapper">
            <!--家电手机-->
            <c:forEach items="${INDEXCONTENTINFO}" var="temp">
	            <div class="need_ani" >
	                <div class="chn_inner">
	                    <div class="chn_inner_hd">
	                        <h3 class="pt_tit" >${temp.title}</h3>
	                        <div class="pt_tags">
	                        	<c:forEach items="${temp.tags }" var="tag">
	                        		<a class="pt_tags_item" href="javascript:;">${tag }</a>
	                        	</c:forEach>
	                            <!-- 
	                            <a class="pt_tags_item" href="javascript:;">空调</a>
	                            <a class="pt_tags_item" href="javascript:;">洗衣机</a> -->
	                        </div>
	                    </div>
	                    <div class="chn_inner_wrapper">
	                        <ul class="chn_inner_list">
	                        	<c:forEach items="${temp.goodsList }" var="goods">
	                        		<li class="chn_inner_item">
		                                <a href="${pageContext.request.contextPath }/proview?goodsId=${goods.goodsId} "  class="chn_item_lk">
		                                    <img src="${pageContext.request.contextPath }/${goods.imageAddress }" alt="">
		                                    <div class="more_info">
		                                        <p class="more_info_name">${goods.goodsName }</p>
		                                        <p class="more_info_price">
		                                            <i>￥</i>
		                                            <span class="more_info_price_txt">${goods.price }</span>
		                                        </p>
		                                    </div>
		                                </a>
	                            	</li>
	                        	</c:forEach>
	                        </ul>
	                    </div>
	                </div>
            	</div>
            </c:forEach>
        </div>
   
    <div style="height: 50px;clear: both"></div>
    </div>
</div>

<div class="fooder">
    <%@include file="/page/fooder/fooder.jsp" %>
</div>
</body>
</html>