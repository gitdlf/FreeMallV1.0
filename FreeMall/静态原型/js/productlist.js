/**
 * Created by Administrator on 2017/8/9.
 */
/*jquery入口*/
$(function () {
    /*商品展示也的价格区间特效*/
    $("#boxTopPrice input").on("focus", function () {
        $(this).parent().parent().find(".boxCon").show();
    });

    $("#boxTopPrice input").on("click", function () {
        $(this).parent().parent().find(".boxCon").show();
    });

    $("#boxTopPrice").parent().on("mouseleave", function () {
        $(this).parent().parent().find(".boxCon").hide(1000);
    });

    /*点击清除按钮*/
    $("#boxConBtn .btn1").on("click", function () {
        var ips=$("#boxTopPrice input");
        for(var i=0;i<ips.size();i++){
            ips.val("");
        }
    });

    /*我们需要向数据查找数据，展示不实现*/
    /*点击确定按钮*/
    $("#boxConBtn .btn2").on("click", function () {
        var minPrice = $("#boxTopPrice .ip1").val();
        var maxPrice = $("#boxTopPrice .ip2").val();
        if (maxPrice == minPrice || maxPrice < minPrice || minPrice == null || maxPrice == null || minPrice.trim() == "" || maxPrice.trim() == "") {
            return false;
        }
        var priceList = $("#itemSearchList .mod_search_pro .proPrice em");
        for (var i = 0; i < priceList.size(); i++) {
            /*获取价格*/
            price = $("#itemSearchList .mod_search_pro .proPrice em")[i].innerText.substring(1);
            if (parseFloat(price) > parseFloat(maxPrice) || parseFloat(price) < parseFloat(minPrice)) {
                $(priceList[i]).parents(".mod_search_pro").hide();
            } else {
                $(priceList[i]).parents(".mod_search_pro").show();
            }
        }
    });


        /*综合，销量，价格，新品功能实现*/
        //综合默认都显示
    $("#sortProBtn a").click(function () {
       $(this).addClass("show");
       $(this).siblings().removeClass("show");
    });

    /*综合排序*/
    $("#sortProBtn .zh").click(function () {
        //获取每个商品的销量信息
        var arr = $("#itemSearchList .mod_search_pro .storeTotel span");
        var arrs=$(arr).parents(".mod_search_pro").find(" .proPrice em");
        var i = arr.length, j;
        var tempExchangVal;
        while (i > 0) {
            for (j = 0; j < i - 1; j++) {
                if ((parseInt(arr[j].innerHTML) > parseInt(arr[j + 1].innerHTML))&&parseInt(arr[j].innerText.substring(1)) < parseInt(arr[j + 1].innerText.substring(1))) {
                    tempExchangVal = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempExchangVal;
                }
            }
            i--;
        }
        var itemSearchList=$("#itemSearchList").html("");
        for(var i=arr.size()-1;i>=0;i--){
            itemSearchList.append($(arr[i]).parents(".mod_search_pro"));
        }
    });


    /*销量排序*/
    $("#sortProBtn .total").click(function () {
        //获取每个商品的销量信息
        var arr = $("#itemSearchList .mod_search_pro .storeTotel span");
        var i = arr.length, j;
        var tempExchangVal;
        while (i > 0) {
            for (j = 0; j < i - 1; j++) {
                if (parseInt(arr[j].innerHTML) > parseInt(arr[j + 1].innerHTML)) {
                    tempExchangVal = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempExchangVal;
                }
            }
            i--;
        }
        var itemSearchList=$("#itemSearchList").html("");
        for(var i=arr.size()-1;i>=0;i--){
            itemSearchList.append($(arr[i]).parents(".mod_search_pro"));
        }

    });


    /*价格排序*/
    $("#sortProBtn .price").click(function () {
        //获取每个商品的销量信息
        var arr = $("#itemSearchList .mod_search_pro  .proPrice em");
        var i = arr.length, j;
        var tempExchangVal;
        //$("#itemSearchList .mod_search_pro .proPrice em")[i].innerText.substring(1)
        while (i > 0) {
            for (j = 0; j < i - 1; j++) {
                if (parseInt(arr[j].innerText.substring(1)) > parseInt(arr[j + 1].innerText.substring(1))) {
                    tempExchangVal = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempExchangVal;
                }
            }
            i--;
        }
        var itemSearchList=$("#itemSearchList").html("");
        for(var i=0;i<=arr.size()-1;i++){
            itemSearchList.append($(arr[i]).parents(".mod_search_pro"));
        }

    });

    /*加载页面分页*/
    var pageMaxNumber=$("#pageMaxNumber").html();
    var pageNumberUrl=$("#pageUrl").html();
    for(var i=pageMaxNumber;i>=1;i--){
        var a=$("<a href='"+pageNumberUrl+i+"'>"+i+"</a>");
        $("#turnPage .page_index_start").after(a);
    }


    /*分页效果，获取当前页码并在指定的a标签添加show样式*/
    var pageNum=$("#pageNumber").html();
    $("#turnPage a").eq(pageNum).addClass("show");

    /*判断上一页下一页是否有效*/
    $($("#turnPage .page_prev")[0]).on("click", function () {
        //上一页
        if(parseInt(pageNum)<=1){
            return false;
        }
    });

    $($("#turnPage .page_prev")[1]).on("click", function () {
        if(parseInt(pageNum)>=parseInt(pageMaxNumber)){
            return false;
        }
    });


    /*商品List页的加商品减商品以及加入购物车实现*/
    /*$($("#itemSearchList .mod_search_pro .itemBox .item_act .shopping_num .pro_buy_btn")[1])*/
    /*加入购车功能的ajax*/
    $("#itemSearchList .mod_search_pro .itemBox .item_act .shopping_num .pro_buy_btn").click(function () {
        var tagUrl=this.href;
        //商品数量
        var proNum=$(this).parents(".shopping_num").find("input").val();
        console.log(tagUrl);
        var btn=$(this);
        $.ajax({
            url:tagUrl,
            type:"get",
            data:"proNum="+proNum,
            success: function () {
                //成功的回调函数
                $(btn).parent(".shopping_actfl").find(".pro_buy_btn_label").html("*添加成功");
                $(btn).parent(".shopping_actfl").find(".pro_buy_btn_label").show();
                $(btn).parents(".shopping_num").find(".pro_buy_btn_max_error").hide();
                var imgSrc=$(btn).parents(".itemBox").find(".proImg img")[0].src
                var proName=$(btn).parents(".itemBox").find(".proName a")[0].innerHTML;
                var proPrice=$(btn).parents(".itemBox").find(".proPrice em")[0].innerText.substring(1);
                var ddObj=$("<dd class='hd_cart_cur'><div class='hd_cart_item'>" +
                    "<img class='hd_pro_img' src="+imgSrc+" alt='' width='50px' height='50px'>" +
                    "<div class='hd_cart_detail'>" +
                    "<a href='javascript:;' class='hd_pro_name'>"+proName+"</a>" +
                    "<a href='javascript:;' class='hd_pro_number'>数量:<em>"+proNum+"</em></a>" +
                    "<p><em>￥<span class='pro_totl'>"+(proPrice*proNum)+"</span></em></p>" +
                    "</div></div></dd>");
                ddObj.addClass("hd_cart_cur");
                console.log(ddObj);
                $("#hdCartList dl dt").after(ddObj);
                calculationPrice();
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                $(btn).parent(".shopping_actfl").find(".pro_buy_btn_label").html("*添加失败");
                //$(btn).parent().find(".pro_buy_btn_label").html("lfsenior")
                //console.log(btn);
                $(btn).parent(".shopping_actfl").find(".pro_buy_btn_label").show();
                $(btn).parents(".shopping_num").find(".pro_buy_btn_max_error").hide();
                console.log(XMLHttpRequest.status);
                //window.open("./page/user/login.jsp","_self");
            }
        });
        return false;
    });

    $("#itemSearchList .mod_search_pro .itemBox .item_act .shopping_num .pro_buy_btn").on("mouseleave", function () {
        $(this).parent(".shopping_actfl").find(".pro_buy_btn_label").hide();
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
    /*add功能*/

    $("#itemSearchList .mod_search_pro .itemBox .item_act .shopping_num .add").click(function () {
        var proNum=$(this).parents(".shopping_num").find("input").val();
        //shopping_num_max_pro最大库存
        var proMaxNum=$(this).parents(".shopping_num").find(".shopping_num_max_pro").html();
        if(parseInt(proNum)>=parseInt(proMaxNum)){
            //pro_buy_btn_max_error超出库存
            $(this).parents(".shopping_num").find(".pro_buy_btn_max_error").show();
            return;
        }
        proNum++;
        $(this).parents(".shopping_num").find("input").val(proNum);
    });

    //sub功能
    $("#itemSearchList .mod_search_pro .itemBox .item_act .shopping_num .dis_decrease").click(function () {
        var proNum=$(this).parents(".shopping_num").find("input").val();
        //shopping_num_max_pro最大库存
        var proMaxNum=$(this).parents(".shopping_num").find(".shopping_num_max_pro").html();
        if(parseInt(proNum)<=parseInt(proMaxNum)){
            proNum--;
        }
        if(parseInt(proNum)<=1){
            proNum=1;
        }
        $(this).parents(".shopping_num").find("input").val(proNum);
        $(this).parents(".shopping_num").find(".pro_buy_btn_max_error").hide();
    });

    /*添加购物车成功往页面购物车中添加信息*/

});