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
                var statusCode=data.statusCode;
                if(statusCode==200){
                    window.location.href="edit.html";
                }else{
                    alert(data.msg);
                }
            },
            error:function (error) {
                alert("System error. Bitte ein Moment wieder probieren");
            }
        })
    });
});