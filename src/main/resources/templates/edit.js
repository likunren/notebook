$(function(){
    function addNote(obj,books){
        obj.empty();
        if(books.length>0) {
            for (var i = 0; i < books.length; i++) {
                var sli='<li class="online"><a href="javascript:;"> ' +
                    '<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>' +
                    books[i].cnNotebookName +
                    '</a> </li>';
                var $li=$(sli)
                $li.data("noteId",books[i].cnNotebookId)
                obj.append($li);
            }
        }
    }
    function addBook(obj,books){
        obj.empty();
        if(books.length>0){
            for (var i = 0; i < books.length; i++) {
                var sli='<li class="online">'+
                    '<a >'+
                    '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+
                    books[i].cnNoteTitle +
                    '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'
                    '</a>'+
                    '<div class="note_menu" tabindex="-1">'+
                        '<dl>'+
                            '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="Bewegen..."><i class="fa fa-random"></i></button></dt>'+
                            '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="Teilen"><i class="fa fa-sitemap"></i></button></dt>' +
                             '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="Streichen"><i class="fa fa-times"></i></button></dt>'+
                         '</dl>'+
                      '</div>'+
                '</li>';
                var $li=$(sli)
                $li.data("bookId",books[i].cn_note_id);
                obj.append($li);
            }
        }
    }
    $("#userNotiz ul").on("click","li",function(){
        var bookId=$(this).data("noteId");
        $.ajax({
            url:"note/loadNotes",
            data:{"bookId":bookId},
            type:"post",
            dataType:"json",
            success:function(data){
                var $obj=$("#bookId ul");
                var status=data.statusCode;
                if(status==208){
                    $obj.empty();
                }else{
                    var books=data.objectData;
                    addBook($obj,books);
                }
            },
            error:function(){
                alert("System error. Bitte ein Moment wieder probieren");
            }
        });
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
                       $("#userNotiz ul li:first").click();
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