$(function(){
    function loadUserBooks(){
        var userId=getCookie("userId");
        if(userId==null || userId==""){
            window.location.href="login.html";
        }else{
           $.ajax({
               url:"book/loadBooks",
               type:"post",
               data:{"userId":userId},
               dataType:"json",
               success:function(data){
                   var status=data.statusCode;
                   if(status==208){

                   }
               },
               error:function(error){
                   alert("System error. Bitte ein Moment wieder probieren");
               }

           })
        }
    };
    loadUserBooks();
});