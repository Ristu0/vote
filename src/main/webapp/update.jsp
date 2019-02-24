<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib
        uri="http://java.sun.com/jsp/jstl/core"
        prefix='c' %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<jsp:include page="comm/comm_jQueryUI_js.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/j.js"></script>
<div id="index" class="content wrap">
    <div class="addVote">
        <jsp:include page="top.jsp"/>
        <h2>修改投票</h2>
        <div id="message" class="box wrap">
            <div class="content">
                <div class="vote-content">
                    <form action="${pageContext.request.contextPath}/votesubject/updateVote" name=""
                          onsubmit="return validate();">
                        <%--<s:hidden name="subject.id" id="id"></s:hidden>--%>
                        <dl>
                            <dt>投票类型：</dt>
                            <dd>

                                <c:if test="${requestScope.voteSubject.vsType==0}">
                                    <input type="radio" name="vsType" value="0" checked=checked/>单选
                                    <input type="radio" name="vsType" value="1"/>多选
                                </c:if>
                                <c:if test="${requestScope.voteSubject.vsType==1}">
                                    <input type="radio" name="vsType" value="0"/>单选
                                    <input type="radio" name="vsType" value="1" checked=checked/>多选
                                </c:if>

                            </dd>
                            <dt>投票内容：</dt>
                            <dd>
                                <p>
                                    <input hidden="hidden" name="vsId" value="${requestScope.voteSubject.vsId}"/>
                                    <input readonly="readonly" name="vsTitle" class="input-text"
                                           value="${requestScope.voteSubject.vsTitle}"/>
                                </p>
                            </dd>
                            <dt>投票选项：</dt>
                            <dd id="voteoptions">
                                <c:forEach items="${requestScope.voteSubject.voteOptions}" var="p">
                                    <p><input readonly="readonly" type="text" name="option" class="input-text"
                                              value="${p.voOption}"/></p>
                                </c:forEach>
                            </dd>
                            <dt></dt>
                            <dd class="button">
                                <input type="image" src="${pageContext.request.contextPath}/images/button_submit.gif"/>
                                <a id="addOption" href="javascript:void(0);">增加选项</a>
                                <a href="${pageContext.request.contextPath}/index.jsp">取消操作</a>
                            </dd>
                        </dl>
                    </form>
                </div>
            </div>
        </div>
        <div id="dialog-message" title="警告" style="height:80px;width:130px;display:none">
            <p>投票内容不能为空</p>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</div>
<script>

    $("#voteTitle").blur(function () {
        var voteTitle = $(this).val();
        validateTitle(voteTitle);
    });

    $("#addOption").click(function () {
        var $p = $('<p></p>');
        var $text = $('<input type="text" class="input-text" name="options" />');
        var $del = $('<input type="button" value="删除"/>');
        $del.click(function () {
            $(this).parent().remove();
        });
        $p.append($text).append($del);
        $("#voteoptions").append($p);
    });

    function validate() {
        var voteTitle = $('#voteTitle').val();

        return validateTitle(voteTitle);

    }

    function validateTitle(v) {
        /* if (null == v || '' == v) {
             $("#dialog-message").dialog({
                 modal: true,
                 buttons: {
                     Ok: function () {
                         $(this).dialog("close");
                     }
                 }
             });
             return false;
         }
         return true;*/
    }

    /*
     * 后续可以考虑使用ajax发送数据提交，并根据返回结果决定下一步的操作
     */
    /*
    function update(){
        if(validate()){
            var id = $("#id").val();
            var title = $("#voteTitle").val();
            var type =  $("input[name='subject.type']").val();
            var options = "";
                $("input[name='options']").each(function(){
                    options+= $(this).val()+",";
            });
            var data ="subject.id="+id+"&subject.title="+title+"&subject.type="+type+"&options="+options;
            $.ajax({
                url:'modifySubject.action',
                data:data,
                success:function(result){
                    alert(result);
                    window.location.href="subject!list.action";
                },
                error: function() {
                    alert("ajax执行失败");
                }
            });
        }
    }
    */
</script>
