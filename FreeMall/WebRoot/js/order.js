/**
 * Created by Administrator on 2017/8/10.
 */
/*jquery入口函数*/
$(function () {
   //获取状态吗
    var orderStatu=$("#tabsModSelect").html();
    //头部高亮显示
    $($("#tabsModMain a")[orderStatu]).find(".tabs_mod_tab").addClass("show");
    //console.log(123);

    /*获取所有订单项对象*/
    var boughtWrapperOrderList=$("#boughtWrapperOrder .bought_wrapper_order_item");
    for(var i=0;i<boughtWrapperOrderList.size();i++){
        //为每个订单项添加总额
        /*获取所有商品项的金额*/
        var proPriceList=$(boughtWrapperOrderList[i]).find(".order_pro_item .mod_pro_price span");
        /*总金额*/
        var totalPrice=0;
        for(var j=0;j<proPriceList.size();j++){
            var price=parseFloat(proPriceList[j].innerText.substring(1));
            var proNum=parseInt($(proPriceList[j]).parents(".order_pro_info").find(".mod_pro_number span")[0].innerText);
            totalPrice+=price*proNum;
        }
        totalPrice= Math.round(totalPrice*100)/100;
        /*将结果添加到指定位置*/
        $(boughtWrapperOrderList[i]).find(".pro_item_allPrice em").html(totalPrice);
        
    }
    
    for(var i=0;i<boughtWrapperOrderList.size();i++){
        var orderstate=$(boughtWrapperOrderList[i]).find(".orderStatusName").html()-1;
        //添加状态
        var  stateDd=$(boughtWrapperOrderList[i]).find(".pro_item_state span");
        console.log(stateDd);
        for(var j=0;j<stateDd.size();j++){
            $(stateDd[i]).removeClass("cur");
        }
        $(stateDd[orderstate]).addClass("cur");
        
        //添加对应的操作按钮
        var openA=$(boughtWrapperOrderList[i]).find(".pro_item_option a");
        for(var j=0;j<openA.size();j++){
        	$(openA[j]).hide();
        }
        $(openA[orderstate]).show();

    }
    

});