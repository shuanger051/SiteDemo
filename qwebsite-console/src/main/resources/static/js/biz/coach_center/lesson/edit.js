var LessonEdit = function (){
    var data;
    var Service = {
        get:function (id){
            Ajax.query("getData",{
                url:"/less/get",
                data:{id:id},
                callback:function (result) {
                    data = result;
                    result.lessonPic = viewPath + result.lessonPic;
                    Tool.set_form_data($("#form1"),result);
                }
            })
        }
    }

    window.Manager = {
        close:function (){
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        },
        detail:function(id,e){
            $(".mengban").fadeIn(200);
            $(".mengban").addClass("mengban-fg");
            $("#tip").fadeIn(200);
        },
        closeWindow:function () {
            $("#suggestion").val("");
            $(".mengban").fadeOut(200);
            $(".tip").fadeOut(200);
        }
    }

    function _initInputEnterEvent() {
        $(".tiptop a").click(function(){
            $(".mengban").fadeOut(200);
            $(".tip").fadeOut(200);
        });
    }

    function _initSuggestForm() {
        $("#suggestForm").Validform({
            tip:3,
            callback:function(form){
                Ajax.submit("saveEntry",{
                    url:"/less/suggestion",
                    type:"put",
                    data:{id:$("#id").val(),suggestion:$("#suggestion").val()},
                    callback:function (result) {
                        if(result === 'success'){
                            Tool.layer_alert("操作成功");
                            $("#suggestion").val("");
                            $(".mengban").fadeOut(200);
                            $(".tip").fadeOut(200);
                        }else{
                            Tool.layer_alert("操作失败");
                        }
                    }
                })
                Tool.go_back();
                return false;
            }
        })
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(){
                Ajax.submit("saveEntry",{
                    url:"/less/reviewed",
                    type:"put",
                    data:{id:$("#id").val()},
                    callback:function (result) {
                        Tool.layer_alert("审核成功");
                    }
                })
                return false;
            }
        });
    }
    $(function () {
        _initForm();
        _initSuggestForm();
        _initInputEnterEvent();
        Service.get(Tool.getReqP("id"));
        var ue = UE.getEditor('txt');
        ue.ready(function () {
            ue.setContent(data.content);
        })
    })
}();