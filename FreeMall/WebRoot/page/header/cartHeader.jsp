<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <!--头部上方-->
    <div class="hd_top_bar">
        <div class="hd_warp">
            <!--左边-->
            <div class="hd_warp_left">
            	<%--如果session里没有LOGINTAG说明用户没有登录 --%>
            	<c:choose>
            		<c:when test="${empty sessionScope.LOGINTAG }">
	            		<!--未登录状态-->
		                <div class="hd_unlogin">
		                    <a class="hd_login_page" href="${pageContext.request.contextPath }/page/user/login.jsp">Hi,请登录</a>
		                    <a class="hd_register_page" href="${pageContext.request.contextPath }/page/user/register.jsp">注册</a>
		                </div>
            		</c:when>
	            	<c:otherwise>
		            	 <!--登录状态-->
		                <div class="hd_login" id="hdLogin">
		                	<!-- 显示登录用户名 -->
		                    <a href="javascript:;" class="hd_login_info">Hi,${sessionScope.LOGINTAG.userName }</a>
		                </div>
		                <div class="hd_user_privilege">
		                    <a href="${pageContext.request.contextPath }/outlogin" class="hd_login_out">退出登录</a>
		                    <div class="hd_user_clearfix">
		                        <div class="hd_user_img">
		                            <img src="${pageContext.request.contextPath }/images/header/peopleicon_02.gif" alt="">
		                        </div>
		                        <div class="hd_user_f1">
		                            <a href="javascript:;" class="hd_user_name">${sessionScope.LOGINTAG.userName }</a>
		                            <a href="javascript:;" class="hd_vip">尊贵的会员</a>
		                        </div>
		                    </div>
		                </div>
	            	</c:otherwise>

            	</c:choose>
            </div>
            <!--右边-->
            <div class="hd_top_right">
                <ul>
                    <li class="hd_has_child">
                        <!--我的订单-->
                        <div class="hd_menu">
                            <a href="${pageContext.request.contextPath }/control/queryorder">我的订单</a>
                        </div>

                    </li>
                    <li class="hd_has_child">
                        <!--收藏-->
                        <div class="hd_menu">
                            <a href="">网页收藏</a>
                        </div>
                    </li>
                    <li class="hd_has_child">
                        <!--网站导航-->
                        <div class="hd_menu" id="hd_menu_nav">
                            <a href="javascript:;" > 网站导航</a>
                        </div>
                        <div class="hd_menu_list">
                            <a href="${pageContext.request.contextPath }/page/user/login.jsp" >登录页面</a>
                            <a href="${pageContext.request.contextPath }/page/user/register.jsp" >注册页面</a>
                            <a href="${pageContext.request.contextPath }/page/index.jsp" >网站首页</a>
                            <a href="${pageContext.request.contextPath }/control/queryorder" >订单页面</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--头部下方-->
    <div class="hd_content_var">
        <div class="hd_logo_area">
            <!--跳转到首页-->
            <a href="${pageContext.request.contextPath }/index" class="hd_logo">
                <!--261*150-->
                <img src="${pageContext.request.contextPath }/images/header/logo.png" width="261px" height="150px" alt="网站logo">
            </a>
        </div>
        <div class="hd_content_right">
            <div class="hd_clearfix">
                <div class="hd_search">
                   <div class="hd_search_form">
                       <input type="text" class="hd_search_ipt" id="hdSearchIpt" placeholder="请输入关键字" value="${KEYWORDS }">
                       <a href="${pageContext.request.contextPath }/search?keywords=" class="hd_search_btn" id="hdSearchBtn"></a>
                   </div>
                </div>
                <%-- <div class="hd_mini_cart">
                    <a href="${pageContext.request.contextPath }/control/cart" class="hd_cart_name" id="hdCarName">购物车</a>
                    <div class="hd_cart_show">
                    	购物车内容显示
                    	c:choose>
                    		<c:when test="${not empty sessionScope.CARTTAG }">
                    			<!--购物车没有物品-->
		                        <div class="hd_none_tips">
		                            <span class="hd_none_icon"></span>
		                            <p class="hd_none_text">您的购物车里还没有1号店的商品哦~~</p>
		                        </div>
                    		</c:when>
                    		<c:otherwise>
                    			<!--购物车有物品-->
		                        <div class="hd_tips">
		                            <div class="hd_cart_wrap">
		                                <div class="hd_cart_list" id="hdCartList">
		                                    <!--商品详情-->
		                                    <dl>
		                                        <!--头部提示-->
		                                        <dt>
		                                            <a href="" class="hd_cart_list_titl">自由购</a>
		                                            <span>
		                                                共<i></i>件商品
		                                            </span>
		                                        </dt>
		                                        <!--商品详情页-->
		                                        <c:forEach items="${sessionScope.CARTTAG }" var="item" varStatus="temp">
		                                        	<dd class="hd_cart_cur">
			                                            <div class="hd_cart_item">
			                                                <!--60*60-->
			                                                <img class="hd_pro_img" src="${pageContext.request.contextPath }/page/${item.imgAddress }" alt="" width="50px" height="50px">
			                                                <div class="hd_cart_detail">
			                                                    <a href="" class="hd_pro_name">${item.proName }</a>
			                                                    <a href="" class="hd_pro_number">数量:<em>${item.proCount }</em></a>
			                                                    <p><em>￥<span class="pro_totl">${item.proPrice }</span></em></p>
			                                                </div>
			                                            </div>
		                                       		</dd>
		                                        </c:forEach>
		                                    </dl>
		
		                                </div>
		                            </div>
		                            <div class="hd_totla_pro">
		                                <div class="f1">
		                                    <span class="hd_all">合计</span>
		                                    <b><em>￥<span class="pro_all_totl" id="proALlTotl"></span></em></b>
		                                </div>
		                                <a href="" class="hd_cart_btn">打开购物车</a>
		                            </div>
		                        </div>
                    		</c:otherwise>
                    	</c:choose>
                        
                        
                    </div>
                </div> --%>
            </div>
            <div class="hd_header_nav">
                <p class="hd_hot_search">
                	<c:forEach items="${HOTKEYWORDS}" var="temp">
	                    <a href="${pageContext.request.contextPath }/search?keywords=${temp}" target="_self">${temp }</a>
                	</c:forEach>
                </p>
            </div>
        </div>
    </div>
