$(function(){
    $(".btn-login").click(function(){
        $("#form").hide();
        $("#tip").show();
    });

    $("#btn-look").click(function(){
        $("#head-title").html("查看留言");
        $("#tb").show();
        $("#tb-content").show();
        $("#reply-content").hide();
        $("#div-content").hide();
        $("#look-content").hide();

    });

    $("#btn-make").click(function(){
        $("#head-title").html("修改留言");
        $("#tb").show();
        $("#tb-content").hide();
        $("#tr-content").show();
        $("#reply-content").show();
        $("#look-content").hide();
        $("#div-content").hide();
    });

    $("#btn-send").click(function(){
        $("#head-title").html("发布留言");
        $("#tb").hide();
        $("#look-content").show();
        $("#reply-content").hide();
        $("#tr-content").show();
        $("#div-content").show();
    });
});