$(function(){
    var cate_menu_item_index=0;
    var cate_part_index=0;
    $(".category_list li").mouseover(function () {
            // debugger
             cate_menu_item_index=$(this).index();
            // alert(cate_menu_item_index);
            // $(".hidden_list_item").eq(cate_menu_item_index).css("display", "block");
            // $(".hidden_main").css("display","block");
            $(".hidden_list_item").eq(cate_menu_item_index).show();
        $(".hidden_list_item").eq(cate_menu_item_index).siblings().hide()
            $(".hidden_list_item .hidden_part").eq(cate_menu_item_index).show()
        // $(".hidden_list_item .hidden_part").parent().show();
            $(".cate_main").show();

    })
    // $(".category_list li").mouseleave(function () {
    //     cate_menu_item_index=$(this).index();
    //     $(".hidden_list_item").eq(cate_menu_item_index).css("display", "none");
    //     // $(".cate_part").eq(cate_menu_item_index).hide()
    // })
    $(".cate_main").mouseleave(function () {
        // cate_menu_item_index=$(this).index();
        $(".hidden_list_item .hidden_part").css("display", "none");
        // $(".cate_part").eq(cate_menu_item_index).hide()
    })
})