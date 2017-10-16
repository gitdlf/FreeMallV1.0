/**
 * Created by oaec0105 on 2017/8/12.
 */
/*入口函数*/
$(function () {
    $(window).scroll(function () {
        payBar();
    });
    //初始高度
    var mTop = $("#checkOutBar")[0].offsetTop;
    function payBar(){
        //减去滚动条的高度
        var sTop = document.body.scrollTop;
        var heightsss= $(window).height();
        var result = mTop - sTop+$("#checkOutBar").height();
        if(result>heightsss+30){
            $("#checkOutBar").addClass("tools_bar_column");
        }else{
            $("#checkOutBar").removeClass("tools_bar_column");
        }
    }
    payBar();

    /*全选操作*/
    //获取所有多选按钮
    $("#all_checked").on("click",function () {
        var checkboxs=$("#cartShopList input:checkbox");
        for(var i=0;i<checkboxs.size();i++){
            checkboxs[i].checked=this.checked;
        }
        $("#selectAllInner")[0].checked=this.checked;
        getSelProNumber();
    });
    $("#selectAllInner").on("click",function () {
        var checkboxs=$("#cartShopList input:checkbox");
        for(var i=0;i<checkboxs.size();i++){
            checkboxs[i].checked=this.checked;
        }
        $("#all_checked")[0].checked=this.checked;
        getSelProNumber();
    });

    /*获取当前页面商品数目*/
    function getProNumber(){
        //console.log(123);
        $("#selectAllInner").parent().find("b").html($(".cart_shop_list").size());
    }
    /*执行*/
    getProNumber();
    
    /*为所有的多选按钮绑定事件*/
    $("#cartShopList input:checkbox").on("click", function () {
        /*便利所有多选按钮，如果有一个false就上全选的两个false*/
        var checkboxs=$("#cartShopList input:checkbox");
        var judge=true;
        for(var i=0;i<checkboxs.size();i++){
            judge=judge&&checkboxs[i].checked;
        }
        $("#all_checked")[0].checked=judge;
        $("#selectAllInner")[0].checked=judge;
        getSelProNumber();
    })

    /*绑定删除事件*/

    /*计算选中的商品数目与价格*/
    function getSelProNumber(){
       var checkBoxs= $("#cartShopList input:checkbox");
        var count=0;
        var allPrice=0.00;
        for(var i=0;i<checkBoxs.size();i++){
            if(checkBoxs[i].checked){
                //count++;
                //获取所有价格
                var price=parseFloat($(checkBoxs[i]).parents(".cart_list").find(".item_price p").html());
                var num=parseInt($(checkBoxs[i]).parents(".cart_list").find(".item_num  .num_act input").val());
                count+=num;
                allPrice+=price*num;
            }
        }
        /*取两位小数*/
        allPrice=Math.floor(allPrice*100)/100;
        /*页面显示*/
        $("#rptCount b").html(count);
        $("#rPriceTotal b").html(allPrice);
        /*结算按钮的数据*/
        if(count>0){
            $("#checkoutBtn").removeClass("unable");
        }else{
            $("#checkoutBtn").addClass("unable");
        }

    }
    /*初始化*/
    getSelProNumber();
    
    /*add操作*/
    $("#cartShopList .cart_list .cart_list_warp .num_act .add").on("click", function () {
        var currentVal=parseInt($(this).parent().find("input").val());
        var stockNum=parseInt($(this).parent().find(".stockNum").html());
        if(currentVal>=stockNum){
            currentVal=stockNum;
            /*显示库存紧张*/
            $(this).parents(".item_num").find(".stock").show();

        }else{
            currentVal++;
        }
        $(this).parent().find("input").val(currentVal);
        var currentPrice=parseFloat($(this).parents(".cart_list_item").find(".item_price p").html());
        var allPrice=Math.floor(currentPrice*currentVal*100)/100;
        $(this).parents(".cart_list_item").find(".item_amount .item_a_money").html(allPrice);
        getSelProNumber();
    });
    /*sub操作*/
    $("#cartShopList .cart_list .cart_list_warp .num_act .minus").on("click", function () {
        var currentVal=parseInt($(this).parent().find("input").val());
        var stockNum=parseInt($(this).parent().find(".stockNum").html());
        if(currentVal<=1){
            currentVal=1;
            /*显示库存紧张*/
        }else{
            currentVal--;
        }
        $(this).parents(".item_num").find(".stock").hide();
        $(this).parent().find("input").val(currentVal);
        var currentPrice=parseFloat($(this).parents(".cart_list_item").find(".item_price p").html());
        var allPrice=Math.floor(currentPrice*currentVal*100)/100;
        $(this).parents(".cart_list_item").find(".item_amount .item_a_money").html(allPrice);
        getSelProNumber();
    });

    /*输入框失去焦点*/
    $("#cartShopList .cart_list .cart_list_warp .num_act input").on("focusout", function () {
        var currentVal=parseInt($(this).val());
        var stockNum=parseInt($(this).parent().find(".stockNum").html());
        if(currentVal<=1){
            currentVal=1;
        }
        if(currentVal>=stockNum){
            currentVal=stockNum;
        }
        $(this).val(currentVal);
        var currentPrice=parseFloat($(this).parents(".cart_list_item").find(".item_price p").html());
        var allPrice=Math.floor(currentPrice*currentVal*100)/100;
        $(this).parents(".cart_list_item").find(".item_amount .item_a_money").html(allPrice);
        getSelProNumber();
    });
    /*计算小计价格*/

    //删除的ajax操作
    $("#cartShopList .cart_list .cart_list_warp .item_act .del_btn").on("click", function () {
       //获取到url
        var urlHref=this.href;
        var btn=$(this);
        $.ajax({
            url:urlHref,
            type:"post",
            success: function () {
                btn.parents(".cart_list").fadeOut(500, function () {
                    btn.parents(".cart_list").remove();
                    getSelProNumber();
                    getProNumber();
                });
            },
            error: function () {
            }
        })
        return false;
    });
    
    /*去结算*/
    $("#checkoutBtn").on("click", function () {
        if($(this)[0].className.indexOf("unable")==-1){
            $("#checkoutSubmit").click();
        }
    });

    
    
    
    
    //初始化价格
    var temps=$("#cartShopList .cart_list .cart_list_warp .num_act .add");
    for(var i=0;i<temps.size();i++){
    	var currentVal=parseInt($(temps[i]).parent().find("input").val());
        var currentPrice=parseFloat($(temps[i]).parents(".cart_list_item").find(".item_price p").html());
        var allPrice=Math.floor(currentPrice*currentVal*100)/100;
        $(temps[i]).parents(".cart_list_item").find(".item_amount .item_a_money").html(allPrice);
    }

});