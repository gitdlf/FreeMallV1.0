$(function () {
    var index=0;
    var interval=null;
    var num=$(".banner_span span").length;

    //保证第一张在最上面
    $(".banner_ul li:gt(0)").hide();
    //给span添加点击事件
    $(".banner_span span").click(function () {
        $(this).addClass("active").siblings().removeClass("active");
        var index1=$(".banner_span span").index(this);

        $(".banner_ul li").eq(index1).fadeIn("slow").siblings().fadeOut("slow");
        index=index1;
    });
    //给prev添加点击事件
    $(".prev").click(function () {
        if(index==0){
            index=num;
        }
        $(".banner_ul li").eq(index-1).fadeIn().siblings().fadeOut();
        $(".banner_span span").eq(index-1).addClass("active").siblings().removeClass("active");
        index--;
    });
    //给next添加点击事件
    $(".next").click(function () {
        if(index==num-1){
            index=-1;
        }
        $(".banner_ul li").eq(index+1).fadeIn().siblings().fadeOut();
        $(".banner_span span").eq(index+1).addClass("active").siblings().removeClass("active");
        index++;
    });
    //自动播放函数方法里面调用自动播放下一张图片的方法
    function autoPlay() {
        interval=setInterval(function () {
            autoPlayNext();
        },4000)
    }
    //封装自动播放下一张图片的函数方法
    function autoPlayNext() {
        if(index==num-1){
            index=-1;
        }
        $(".banner_ul li").eq(index+1).fadeIn().siblings().fadeOut();
        $(".banner_span span").eq(index+1).addClass("active").siblings().removeClass("active");
        index++;
    }
    //鼠标移动上去就清除定时器
    $(".banner").mouseover(function () {
        clearInterval(interval);
    });
    //鼠标移开就自动播放
    $(".banner").mouseout(function () {
        autoPlay();
    });
    autoPlay();
});