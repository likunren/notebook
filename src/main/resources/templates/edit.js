$(function(){
    function addNote(obj,books){
        obj.empty();
        if(books.length>0) {
            for (var i = 0; i < books.length; i++) {
                obj.append('<li class="online"><a href="javascript:;"> ' +
                    '<input type="hidden" value="'+books[i].cnNotebookId+'" />'+
                    '<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>' +
                    books[i].cnNotebookName +
                    '</a> </li>');
            }
        }
    }
    $("#userNotiz ul").on("click","li",function(e){
        var $obj=$(e.target);
        var noteId=$obj.children(":hidden").val();
    });
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
                  var obj= $("#userNotiz .contacts-list");
                   if(status==208){
                        obj.empty();
                   }else{
                       var books=data.objectData;
                       addNote(obj,books);
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