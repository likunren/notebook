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
                    var cnUserId=data.objectData.cnUserId;
                    addCookie("userId",cnUserId,1)
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
    $("#regist_button").click(function () {
        var userName=$("#regist_username").val().trim();
        var nickName=$("#nickname").val().trim();
        var passWord=$("#regist_password").val().trim();
        var final_password=$("#final_password").val().trim();
        if(isEmpty(userName)){
            $("#warning_1").attr({style:"right:85px"});
            $("#warning_1").show();
            return;
        }
        if(!compareTo(passWord,final_password)){
            $("#warning_3").attr({style:"right:85px"});
            $("#warning_3").show();
            return;
        }
        $.ajax({
            url:"user/addUser",
            type:"post",
            data:{"userName":userName,"nickName":nickName,"passWord":passWord},
            dataType:"json",
            success:function () {

            },
            error:function () {

            }
        })
    })
});