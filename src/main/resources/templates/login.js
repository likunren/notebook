$(function(){
    $("#login").click(function(){
        var userName=$("#userName").val().trim();
        var passWord=$("#passWord").val().trim();
        $("#errorMsg").empty();
        if(isEmpty(userName)){
            $("#errorMsg").text("UserName kann nicht leer sein.");
            $("#userName").focus();
            return;
        }
        if(isEmpty(passWord)){
            $("#errorMsg").text("PassWord kann nicht leer sein.");
            $("#passWord").focus();
            return;
        }
        $.ajax({
            url:"user/login",
            type:"post",
            data:{"userName":userName,"passWord":passWord},
            dataType:"json",
            success:function(data){
                alert(data.objectData.cnUserName);
            },
            error:function () {

            }

        })
    });
});