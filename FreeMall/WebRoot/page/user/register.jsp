<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册自由购</title>
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath }/js/content2.js"></script>
    <link type="text/css" href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath }/css/content2.css" rel="stylesheet" >
</head>
<body>
<div class="header">
	<%@include file="/page/header/header.jsp" %>
</div>
<div class="register_content">
    <div class="icon icon1"></div>
    <div class="icon icon2"></div>
    <div class="icon icon3"></div>
    <div class="icon icon4"></div>
    <div class="icon icon5"></div>
    <div class="register_til">
        <h3>自由购注册</h3>
    </div>
    <div class="r_form_item_wrap" id="register_form">
    	<!-- form表单 -->
        <form action="${pageContext.request.contextPath }/register" method="post">
            <div class="r_form_item">
                <div class="y_same_item">
                    <input type="text" class="y_name y_ipt" name="userName" value="${REGISTERUSER.userName }">
                    <span class="y_same_label">用户名</span>
                </div>
                <div class="y_tip_balck">
                    <div class="y_tip_rel">
                        <div class="y_tips_words">4-20位字符，可由英文、数字等任意字符组成，首字母大写</div>
                    </div>
                    <div class="y_tip_right"></div>
                    <div class="y_tip_wrong">
                        <div class="y_tips_words">请输入正确的用户名，用户名应该为4-20位字符</div>
                    </div>
                </div>
                <!--用户名-->
            </div>
            <div class="r_form_item">
                <div class="y_same_item">
                    <input type="text" class="y_tel y_ipt" name="userPhone" value="${REGISTERUSER.userPhone }">
                    <span class="y_same_label">手机号</span>
                </div>
                <div class="y_tip_balck">
                    <div class="y_tip_rel">
                        <div class="y_tips_words">请填写正确的手机号码，以便接受订单通知</div>
                    </div>
                    <div class="y_tip_right"></div>
                    <div class="y_tip_wrong">
                        <div class="y_tips_words">请输入正确的手机号码</div>
                    </div>
                </div>
                <!--手机号-->
            </div>
            <div class="r_form_item">
                <div class="y_same_item">
                    <input type="text" class="y_email y_ipt" name="userEmail" value="${REGISTERUSER.userEmail }">
                    <span class="y_same_label">邮箱</span>
                </div>
                <div class="y_tip_balck">
                    <div class="y_tip_rel">
                        <div class="y_tips_words">请填写正确的邮箱号码</div>
                    </div>
                    <div class="y_tip_right"></div>
                    <div class="y_tip_wrong">
                        <div class="y_tips_words">请输入正确的邮箱号码</div>
                    </div>
                </div>
                <!--邮箱-->
            </div>
            <div class="r_form_item">
                <div class="y_same_item">
                    <input type="text" class="y_idcard y_ipt" name="userIdCare"  value="${REGISTERUSER.userIdCare }">
                    <span class="y_same_label">身份证号</span>
                </div>
                <div class="y_tip_balck">
                    <div class="y_tip_rel">
                        <div class="y_tips_words">请填写正确的身份证号码</div>
                    </div>
                    <div class="y_tip_right"></div>
                    <div class="y_tip_wrong">
                        <div class="y_tips_words">请输入正确的身份证号码</div>
                    </div>
                </div>
                <!--身份证号-->
            </div>
            <div class="r_form_item">
                <div class="y_same_item">
                    <input type="text" class="y_birth y_ipt" name="userBirth" value="${REGISTERUSER.userBirth }">
                    <span class="y_same_label">生日</span>
                </div>
                <div class="y_tip_balck">
                    <div class="y_tip_rel">
                        <div class="y_tips_words">请填写正确的生日日期格式如:1996-05-01</div>
                    </div>
                    <div class="y_tip_right"></div>
                    <div class="y_tip_wrong">
                        <div class="y_tips_words">请输入正确的生日日期</div>
                    </div>
                </div>
                <!--生日-->
            </div>
            <div class="r_form_item">
                <div class="y_same_item">
                    <input type="text" class="y_address y_ipt" name="userAddress" value="${REGISTERUSER.userAddress }">
                    <span class="y_same_label">收货地址</span>
                </div>
                <div class="y_tip_balck">
                    <div class="y_tip_rel">
                        <div class="y_tips_words">请填写正确的收获地址</div>
                    </div>
                    <div class="y_tip_right"></div>
                    <div class="y_tip_wrong">
                        <div class="y_tips_words">请输入正确收获地址</div>
                    </div>
                </div>
                <!--收货地址-->
            </div>
            <div class="r_form_item">
                <div class="y_same_item">
                    <input type="password" class="y_pwd y_tel y_ipt" name="userPwd" value="${REGISTERUSER.userPwd }">
                    <span class="y_same_label">密码</span>
                </div>
                <div class="y_tip_balck">
                    <div class="y_tip_rel">
                        <div class="y_tips_words">4-20位字符，可油英文、数字组成，首字母大写</div>
                    </div>
                    <div class="y_tip_right"></div>
                    <div class="y_tip_wrong">
                        <div class="y_tips_words">请输入正确的密码</div>
                    </div>
                </div>
                <!--密码-->
            </div>
            <div class="r_form_item">
                <div class="y_same_item">
                    <input type="password" class="y_repwd y_ipt">
                    <span class="y_same_label">确认密码</span>
                </div>
                <div class="y_tip_balck">
                    <div class="y_tip_rel">
                        <div class="y_tips_words">请输入密码</div>
                    </div>
                    <div class="y_tip_right"></div>
                    <div class="y_tip_wrong">
                        <div class="y_tips_words">两次密码不一致</div>
                    </div>
                </div>
                <!--确认密码-->
            </div>
            <div class="y_agreement_word">
                点击注册，表示同意FreeMall
                <a href="#">《服务协议》</a>
            </div>
            <input type="submit" class="y_agreement_btn" id="y_agreement_btn" value="同意协议并注册">
        </form>
        <div class="y_clearfix">
            <!--内容为error提示，提示登陆失败-->
            <label class="error_info" id="y_error_info">${REGISTERERROR }</label>
        </div>
    </div>
</div>
<div class="fooder">
    <div>
        <!--版权声明-->
        <span class="statement">Copyright © 2017 FreeMall All Rights Reserved</span>
    </div>
</div>
</body>
</html>