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
                $li.data("bookId",books[i].cnNotebookId)
                obj.append($li);
            }
        }
    }
    function addBook(obj,books){
        obj.empty();
        $("#input_note_title").val("");
        um.setContent("");
        if(books.length>0){
            for (var i = 0; i < books.length; i++) {
                var sli='<li class="online">'+
                    '<a >'+
                    '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+
                    books[i].cnNoteTitle +
                    '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'+
                    '</a>'+
                    '<div class="note_menu" tabindex="-1">'+
                        '<dl>'+
                            '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="Bewegen..."><i class="fa fa-random"></i></button></dt>'+
                            '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="Teilen"><i class="fa fa-sitemap"></i></button></dt>' +
                             '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="Streichen"><i class="fa fa-times"></i></button></dt>'+
                         '</dl>'+
                      '</div>'+
                '</li>';
                obj.append($(sli).data("noteId",books[i].cnNoteId));
            }
        }
    }
    $("#can").on("click","div.modal-header .close",function(){
        $('#can').empty();
        $('.opacity_bg').hide();
    })
    $("#can").on("click",".cancle",function(){
        $('#can').empty();
        $('.opacity_bg').hide();
    });
    $("#add_note").click(function(){
        $("#can").load('./alert/alert_notebook.html');
        $('.opacity_bg').show();

    });
    $("#add_notebook").click(function(){
        $('#can').load('./alert/alert_note.html');
        $('.opacity_bg').show();
    });
    $("#can").on("click","#saveNote",function(){
        var $bookObj=$("#userNotiz ul li a.checked");
        var cnNotebookId= $bookObj.parent().data("bookId");
        var cnUserId=getCookie("userId")
        var cnNoteTitle=$("#input_notebook").val();
        if(isEmpty(cnNoteTitle)){
            alert("Bitte geben Sie Notename ein?");
            $("#input_notebook").focus();
            return;
        }
       $.ajax({
           url:"note/addNote",
           data:{"cnNotebookId":cnNotebookId,"cnUserId":cnUserId,"cnNoteTitle":cnNoteTitle},
           dataType:"json",
           type:"post",
           success:function(data){
               var statusCode=data.statusCode;
               var noteObj=data.objectData;
               if(statusCode==200){
                   $('#can').empty();
                   $('.opacity_bg').hide();
                   var obj = $("#bookId .contacts-list");
                   var sli = '<li class="online">'+
                                 '<a >'+
                                 '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+
                                    noteObj.cnNoteTitle +
                                 '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'+
                                 '</a>'+
                                 '<div class="note_menu" tabindex="-1">'+
                                 '<dl>'+
                                 '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="Bewegen..."><i class="fa fa-random"></i></button></dt>'+
                                 '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="Teilen"><i class="fa fa-sitemap"></i></button></dt>' +
                                 '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="Streichen"><i class="fa fa-times"></i></button></dt>'+
                                 '</dl>'+
                                 '</div>'+
                              '</li>';
                   var $li = $(sli)
                   $li.data("noteId", noteObj.cnNoteId)
                   obj.prepend($li);
               }
           },
           error:function(error){
               alert("Die Daten sind nicht elfolgreich gespeichert.")
           }

       })
    })
    $("#can").on("click","#delNote",function(){
        var $bookId=$("#bookId ul li a.checked");
        var noteId=$bookId.parents("li").data("noteId");
        $.ajax({
           url:"note/delNote",
           data:{"noteId":noteId},
           dataType:"json",
           type:"post",
           success:function(data){
               var statusCode=data.statusCode;
               var msg=data.msg;
               if(statusCode==200){
                   $('#can').empty();
                   alert(msg);
                   $bookId.parents("li").remove();
               }
           },
            erroe:function(error){
                alert("Die Daten sind nicht elfolgreich entfernen.")
            }
        });
    })
    $("#can").on("click","#saveBook",function(){
       var noteBookName=$("#input_note").val();
        if(isEmpty(noteBookName)){
            alert("Bitte geben Sie Notebooksname ein?");
            $("#input_note").focus();
            return;
        }
       var cnUserId=getCookie("userId");
       $.ajax({
           url:"book/add",
           data:{"cnUserId":cnUserId,"noteBookName":noteBookName},
           dataType:"json",
           type:"post",
           success:function(data){
                var statusCode=data.statusCode;
                var noteBookObj=data.objectData;
                if(statusCode==200) {
                    $('#can').empty();
                    $('.opacity_bg').hide();
                    var obj = $("#userNotiz .contacts-list");
                    var sli = '<li class="online"><a href="javascript:;"> ' +
                        '<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>' +
                        noteBookObj.cnNotebookName +
                        '</a> </li>';
                    var $li = $(sli)
                    $li.data("bookId", noteBookObj.cnNotebookId)
                    obj.prepend($li);
                }else {
                    alert(data.msg);
                }
           },
           error:function(error){
               alert("Die Daten sind nicht elfolgreich gespeichert.");
           }
       })
    });
    $("#save_note").click(function(){
        var $noteTitle=$("#bookId ul li a.checked");
        var noteId= $noteTitle.parent().data("noteId");
        if(noteId==undefined){
            alert("Sie haben eine Note,die Sie speichern möchten, nicht ausgewählt.");
            return;
        }
        var noteTitle= $("#input_note_title").val();
        var noteBody=um.getContent();
        $.ajax({
            url:"note/update",
            data:{"noteId":noteId,"noteTitle":noteTitle,"noteBody":noteBody},
            dataType:"json",
            type:"post",
            success:function(data){
                var status=data.statusCode;
                var noteTitle=data.objectData;
                if(status==200) {
                    $noteTitle.html( '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+
                        noteTitle +
                        '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>');
                    alert(data.msg);
                }else{
                    alert("Die Daten sind nicht elfolgreich gespeichert.")
                }
            },
            error:function(error){
                alert("System error. Bitte ein Moment wieder probieren");
            }
        })
    })
    $("body").click(function(){
      $("#bookId ul li div.note_menu").hide();
    });
    $("#bookId ul").on("click","li .btn_slide_down",function(e){
        $(this).parents("li").click();
        $(this).parents("li").siblings().children(".note_menu").hide();
        $(this).parents("li").children(".note_menu").slideDown(1000);
        e.stopPropagation();
    });
    $("#bookId ul").on("click","li .btn_delete",function(){
        $('#can').load('./alert/alert_delete_note.html');
    });
    $("#bookId ul").on("click","li .btn_share",function(){
       var noteId=$(this).parents("li").data("noteId");
       var $obj=$(this).parents("li").children("a").find(".btn_slide_down");
       $.ajax({
           url:"share/add",
           data:{"noteId":noteId},
           dataType:"json",
           type:"post",
           success:function(data){
               var note=data.objectData;
               var status=data.statusCode;
               if(status==200){
                   $obj.before("&nbsp;&nbsp;<i class='fa fa-sitemap'></i>");
                   alert(data.msg);
               }
           },
           error:function (error) {
               alert("System error. Bitte ein Moment wieder probieren");
           }
       });
    })
    $("#bookId ul").on("click","li",function(){
        var noteId=$(this).data("noteId");
        $(this).siblings().children("a").removeClass("checked");
        $(this).children("a").addClass("checked");
        $.ajax({
            url:"note/loadNote",
            data:{"noteId":noteId},
            type:"post",
            dataType:"json",
            success:function(data){
                var note=data.objectData;
                var status=data.statusCode;
                if(status==200) {
                    $("#input_note_title").val(note.cnNoteTitle);
                    um.setContent(note.cnNoteBody);
                }
             },
            error:function(error){
                alert("System error. Bitte ein Moment wieder probieren");
             }
        });
    })
    $("#userNotiz ul").on("click","li",function(){
        var bookId=$(this).data("bookId");
        $(this).siblings().children("a").removeClass("checked");
        $(this).children("a").addClass("checked");
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
                       $("#cnUserName").text(getCookie("cnUserName"));
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