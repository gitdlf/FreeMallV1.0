
/**
 * Created by oaec0105 on 2017/8/5.
 */
/*
*
* 登录页事件
*
*
* */
$(function () {
    /*输入框获得焦点*/
    $("#login_form .ipt").focus(function () {
        var login_item = $(this).parent(".form_item");
        login_item.addClass("show");
    });
    /*输入框失去焦点*/
    $("#login_form .ipt").focusout(function () {
        var login_item = $(this).parent(".form_item");
        login_item.removeClass("show");
    });
    /*判断是否错误*/
    var login_erro=$("#error_info");
    if(login_erro.html()==="error"){
        login_erro.html("*用户名或密码错误请重新登录");
    }

    /*登陆提交判断*/
    $("#login_btn").on("click", function () {
        var judge=true;
        var inp=$("#login_form .ipt");
        for(var i=0;i<inp.length;i++){
            if($(inp[i]).val().trim()==""){
                judge=false;
            }
        }
        if(judge){
            login_erro.html("");
        }else{
            login_erro.html("*用户名或密码不能为空");
        }
        return judge;
    });
    /*
    *
    *
    * 注册页事件
    *
    *
    * */

    /*用户点击注册项，y_same_lable的文字移动，弹出提示*/
    $("#register_form .y_ipt").focus(function () {
        var str=$($(this).next("span")[0]).width();
        $(this).next("span").animate({
            left:(-str-20)+'px'
        },1000);
        $(this).parent().next().find(".y_tip_rel").fadeIn(1000);
        $(this).parent().next().find(".y_tip_right").fadeOut(1000);
        $(this).parent().next().find(".y_tip_wrong").fadeOut(1000);
        $(this).parent().parent().addClass("show");
    });

    //用户名判断
    $("#register_form .y_name").on("focusout", function () {
        var val=$(this).val();
        var re=new RegExp("([a-zA-Z0-9]{4,20})");
        //4-20位字符，可由英文、数字等任意字符组成，首字母大写
        if(re.test(val)){
            this.judge=true;
        }else{
            this.judge=false;
        }
    });

    //手机号码判断
    $("#register_form .y_tel").on("focusout", function () {
        var val=$(this).val();
        var re=new RegExp("[0-9]{11}");
        //手机号码为纯数字11位
        if(re.test(val)){
            this.judge=true;
        }else{
            this.judge=false;
        }
    });

    //邮箱判断
    $("#register_form .y_email").on("focusout", function () {
        var val=$(this).val();
        var re=new RegExp("([a-z0-9_\.-]+)@([\da-z0-9\.-]+)\.([a-z\.]{2,6})");
        if(re.test(val)){
            this.judge=true;
        }else{
            this.judge=false;
        }
    });

    //身份证号判断
    $("#register_form .y_idcard").on("focusout", function () {
        var val=$(this).val();
        var re=new RegExp("([0-9]{17}[0-9xX]{1})");
        if(re.test(val)){
            this.judge=true;
        }else{
            this.judge=false;
        }
    });

    //生日判断
    $("#register_form .y_birth").on("focusout", function () {
        var val=$(this).val();
        var re=new RegExp("[0-9]{4}-[0-9]{2}-[0-9]{2}");
        if(re.test(val)){
            this.judge=true;
        }else{
            this.judge=false;
        }
    });

    //收获地址
    $("#register_form .y_address").on("focusout", function () {
        var val=$(this).val();
        if(val.length>4&&val.length<20){
            this.judge=true;
        }else{
            this.judge=false;
        }
    });

    //密码判断
    $("#register_form .y_pwd").on("focusout", function () {
        var val=$(this).val();
        var re=new RegExp("[A-z]{1}[a-zA-Z0-9]{5,19}");
        if(re.test(val)){
            this.judge=true;
        }else{
            this.judge=false;
        }
    });

    //确认判断
    $("#register_form .y_repwd").on("focusout", function () {
        var val=$(this).val();
        var pwdVal=$("#register_form .y_pwd").val();
        if(val===pwdVal){
            this.judge=true;
        }else{
            this.judge=false;
        }
    });

    $("#register_form .y_idcard").on("focusout", function () {
        var val=$(this).val();
        var re=new RegExp("([0-9]{17}[0-9xX]{1})");
        //手机号码为纯数字11位
        if(re.test(val)){
            this.judge=true;
        }else{
            this.judge=false;
        }
    });

    $("#register_form .y_ipt").on("focusout",function () {
        var str=$($(this).next("span")[0]).width();
        $(this).parent().parent().removeClass("show");
        $(this).parent().next().find(".y_tip_rel").fadeOut(1000);
        if(this.judge){
            $(this).parent().next().find(".y_tip_wrong").fadeOut(1000);
            $(this).parent().next().find(".y_tip_right").fadeIn(1000);
        }else{
            $(this).parent().next().find(".y_tip_wrong").fadeIn(1000);
            $(this).parent().next().find(".y_tip_right").fadeOut(1000);
        }
    });


    var y_error_info=$("#y_error_info");
    if(y_error_info.html()==="error"){
    	y_error_info.html("*注册失败，用户名已存在，请重新注册");
    	 var ipt=$("#register_form .y_ipt");
         for(var i=0;i<ipt.size();i++){
        	 $(ipt[i]).focus();
         }
    }
    
/*注册提交判断*/
    $("#y_agreement_btn").on("click", function () {
        var judge=true;
        var ipt=$("#register_form .y_ipt");
        for(var i=0;i<ipt.size();i++){
            if(ipt[i].judge==undefined){
                judge=false;
                break;
            }
            judge=judge&&ipt[i].judge;
        }
        if(judge){
            y_error_info.html("");

        }else{
            y_error_info.html("*请输入正确的注册信息");
        }
        return judge;
    });


    /*
     *
     * 头部js
     *
     * */
    //鼠标移动到头部的网站导航
    $("#hd_menu_nav").on("mouseenter",function () {
        $(this).next().show();
        $(this).addClass("show");
    });
    //鼠标从头部的网站导航移开
    $("#hd_menu_nav").parent().on("mouseleave",function () {
        $("#hd_menu_nav + .hd_menu_list").hide();
        $("#hd_menu_nav").removeClass("show");
    });



    /*购物车的显示*/
    $("#hdCarName").on("mouseenter", function () {
        $(this).next().show();
    });
    $("#hdCarName").parent().on("mouseleave", function () {
        $("#hdCarName").next().hide();
    })

    /*鼠标移动到登录状态的用户名上*/
    $("#hdLogin").on("mouseenter", function () {
        $(this).next().show();
        $(this).addClass("show");
    });
    $("#hdLogin").parent().on("mouseleave", function () {
        $("#hdLogin").removeClass("show");
        $("#hdLogin").next().hide();
    });
    /*计算总价格*/
    function calculationPrice() {
        var proTotlList=$("#hdCartList .pro_totl");
        var allTotl=0;
        for(var i=0;i<proTotlList.size();i++){
            allTotl+=parseFloat($(proTotlList[i]).html());
        }
        allTotl= Math.round(allTotl*100)/100;
        $("#proALlTotl").html(allTotl);
        $("#hdCartList dt i").html(proTotlList.size());
    };

	calculationPrice();
    /*商品详情页*/
    $("#proNumAdd").click(function () {
        var proNum=$("#proNum").val();
        var proMaxNum=$("#proMaxNum").html();
        if(parseInt(proNum)>=parseInt(proMaxNum)){
            $("#maxErrorInfo").show();
            return;
        }
        proNum++;
        $("#proNum").val(proNum);
        $("#proNumSub").addClass("show");
    });

    $("#proNumSub").click(function () {
        var proNum=$("#proNum").val();
        var proMaxNum=$("#proMaxNum").html();
        if(parseInt(proNum)<=parseInt(proMaxNum)){
            proNum--;
        }
        if(parseInt(proNum)<=1){
            proNum=1;
            $("#proNumSub").removeClass("show");
        }
        $("#proNum").val(proNum);
        $("#maxErrorInfo").hide();
    });

    /*首页点击到图片上的样式*/

    $("#chnInnerWrapper li").on("mouseenter", function () {
        $(this).css("border","1px solid #999");
    });
    $("#chnInnerWrapper li").on("mouseleave", function () {
        $(this).css("border","1px solid white");
    });


   /*侧边导航 sideNav*/
    $(window).scroll(function () {
        if(window.pageYOffset>500){
            $("#sideNav").show();
        }else{
            $("#sideNav").hide();
        }
    });
    /*页面搜索按钮功能*/
    $("#hdSearchBtn").on("click", function () {
        var keywords=$("#hdSearchIpt").val();
        var url=$(this)[0].href;
        if(keywords.trim()!=""){
            //执行函数
            window.open(url+keywords,"_self");
        }
        return false;
    });

    $("#hdSearchIpt").keyup(function (event) {
        //按下回车键
        if(event.keyCode==13){
            $("#hdSearchBtn").click();
        }
    });

    /*主页消息动画*/
    $("#activep_one").mouseenter(function () {
        $(this).children(":eq(0)").addClass("select_show");
        $("#activep_two").children(":eq(0)").removeClass("select_show");
        $("#activeul_one").show();
        $("#activeul_two").hide();
    });
    $("#activep_two").mouseenter(function () {
        $(this).children(":eq(0)").addClass("select_show");
        $("#activep_one").children(":eq(0)").removeClass("select_show");
        $("#activeul_two").show();
        $("#activeul_one").hide();
    });

    
    
    /*加入购车功能的ajax*/
    $("#cart_buy_btn").click(function () {
       var tagUrl=this.href;
       //商品数量
       var proNum=$("#proNum").val();
        $.ajax({
            url:tagUrl,
            type:"get",
            data:"proNum="+proNum,
            success: function () {
              //成功的回调函数
                $("#cartBuyInfo").html("*添加购物车成功");
                $("#cartBuyInfo").show();
                $("#maxErrorInfo").hide();
                var imgSrc=$("#proImgAddToMiniCart")[0].src;
                var proName=$("#proNameAddToMiniCart").html();
                var proPrice=$("#proPriceAddToMiniCart")[0].innerText.substring(1);
                var ddObj=$("<dd class='hd_cart_cur'><div class='hd_cart_item'>" +
                    "<img class='hd_pro_img' src="+imgSrc+" alt='' width='50px' height='50px'>" +
                    "<div class='hd_cart_detail'>" +
                    "<a href='javascript:;' class='hd_pro_name'>"+proName+"</a>" +
                    "<a href='javascript:;' class='hd_pro_number'>数量:<em>"+proNum+"</em></a>" +
                    "<p><em>￥<span class='pro_totl'>"+(proPrice*proNum)+"</span></em></p>" +
                    "</div></div></dd>");
               ddObj.addClass("hd_cart_cur");
               $("#hdCartList dl dt").after(ddObj);
               calculationPrice();
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
            	 $("#cartBuyInfo").html("*添加购物车失败，请重新添加");
            	 $("#cartBuyInfo").show();
            	 $("#maxErrorInfo").hide();
            	 //获取状态码
                 if(XMLHttpRequest.status=="302"){
                 	window.open("./page/user/login.jsp","_self");
                 }
            }
        });
        return false;
    });
    
    /*当鼠标移开购物车按钮的时候，添加成功信息隐藏*/
    $("#cart_buy_btn").on("mouseleave", function () {
        $("#cartBuyInfo").hide();
    });
    
    /*主页栏目自动换色，并添加id,document加载完就添加*/
    var sysClass=["achorAIC","achorEIM","achorCOD","achorCOD","achorP3C","achorLAC","achorLBB","achorLH"];
    var chnInner=$(".need_ani .chn_inner_hd");
    for(var i=0;i<chnInner.size();i++){
        $(chnInner[i]).addClass(sysClass[i]);
        if(i%2==0){
            $($(chnInner[i]).find("h3")[0]).attr("id",sysClass[i]);
            $(chnInner[i]).parent().addClass("chn_c1");
        }else{
            $(chnInner[i]).parent().addClass("chn_c2");
        }
    }
});