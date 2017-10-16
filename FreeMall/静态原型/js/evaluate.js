/**
 * Created by oaec0105 on 2017/8/13.
 */
/*入口函数*/
$(function () {
    /*绑定评价星的固定*/
    $("#formPart1 .f-item .fi-operate .commstar span").on("click", function () {
        $(this).parent().find("span").removeClass("active");
        $(this).addClass("active");
        $(this).parent().find(".star-info b").html($(this).find("span").html());
        $(this).parent().find("input").val($(this).find("span").html());
    });

    $("#formPart1 .f-item .fi-operate textarea").on("focus", function () {
        $(this).on("keyup", function () {
            var areaText=$(this).val();
            if(areaText.length>=500){
                areaText=areaText.substring(0,500);
                $(this).val(areaText);
            }
            var wardNum=500-areaText.length;
            $(this).parent().find(".textarea-ext span").html(wardNum);
        });
    });

    /*提交事件*/
    $("#valuateBtnSubmit").on("click", function () {
        //判断用户是否评价过
        var areas=$("#formPart1 .f-item .fi-operate textarea");
        var judge=false;
        for(var i=0;i<areas.size();i++){
           if(areas[i].value.trim()==""){
               judge=judge||false;
           }else{
               judge=judge||true;
           }
        }
        if(judge){
            //提交
            $(this).parent().find("input").click();
        }
        return  false;
    });
});

