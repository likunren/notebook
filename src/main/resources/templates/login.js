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
    $("#regist_password").blur(function(){
        var pwd=$("#regist_password").val().trim();
        var bool=pwdformat(pwd);
        $('#warning_2').hide();
        if(!bool){
            $("#regist_password").val("");
            $("#regist_password").focus();
            $("#warning_2").attr({style:"right:85px"});
            $('#warning_2').show();
        }
    })
    $("#regist_button").click(function () {
        var userName=$("#regist_username").val().trim();
        var nickName=$("#nickname").val().trim();
        var passWord=$("#regist_password").val().trim();
        var final_password=$("#final_password").val().trim();
        $('#warning_2').hide();
        $("#warning_3").hide();
        $("#warning_1").hide();
        if(isEmpty(userName)){
            $("#warning_1").attr({style:"right:85px"});
            $("#warning_1").show();
            return;
        }
        if(isEmpty(passWord) && isEmpty(final_password)){
            $("#warning_2").attr({style:"right:85px"});
            $('#warning_2').show();
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
            success:function (data) {
                var statusCode = data.statusCode;
                if (statusCode == 200) {
                    $("#back").click();
                } else if(statusCode == 203){
                    alert(data.msg)
                    $("#warning_1").attr({style:"right:85px"});
                    $("#warning_1").show();
                    $("#regist_username").val("");
                    $("#regist_username").focus();

                }
            },
            error:function () {
                alert("System error. Bitte ein Moment wieder probieren");
            }
        })
    })
});