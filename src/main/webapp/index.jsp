<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("text/html;charset=UTF-8");
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>投票列表</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <jsp:include page="comm/comm_jQueryUI_js.jsp"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/j.js"></script>
    <jsp:include page="comm/comm_easyUI_js.jsp"/>
    <%--
    --%>
    <script type="text/javascript" src="js/e.js"></script>
    <script type="text/javascript">
        function person_fm(value) {
            if (value == null) {
                return 0;
            }
            return value;
        }
        $(function () {
            $('#mygrid').datagrid({
                url: '${pageContext.request.contextPath}/vote/voteList',
                rownumbers: true,
                iconCls: 'icon-search',
                pagination: true,//显示底部分页栏
                pageSize: 10,//默认每页记录数，pagination参数为true时才有效
                pageList: [5, 10, 15], //显示列表记录数的下拉框选项，pagination参数为true时才有效
                fitColumns: true,//自适应宽度，防止水平滚动
                striped: true,//隔行变色
                columns: [[
                    {field: 'vsId', title: 'vsId', hidden: 'true'},
                    {field: 'vsTitle', title: '投票标题', width: 300},
                    {field: 'optionCount', title: '选项数', align: 'right'},
                    {field: 'personCount', title: '投票人数', align: 'right', formatter: person_fm},
                    {
                        field: 'opr', title: '操作', align: 'center', formatter: function () {
                            return "<a herf='#' style='color:red;'>参加投票</a>";
                        }
                    }
                ]],
                onClickCell: function (index, field) {
                    if (field == "opr") {
                        var id = $(this).datagrid("getRows")[index].vsId;
                        window.location.href = "${pageContext.request.contextPath}/vote/showVote?id=" + id;
                    }
                }
            });
            $("#gridSearch").click(function () {
                var name = $('#keywords').val();
                $('#mygrid').datagrid('load', {keywords: name});
            });
        });
    </script>
</head>
<body>
<jsp:include page="top.jsp"/>
<div id="index" class="content wrap">
    <div id="tabs">
        <ul>
            <li><a href="#tabs-1">返回列表</a></li>
            <li><a href="#tabs-2">发布新投票</a></li>
            <li><a href="manage.jsp">维护</a></li>
            <li style="float:right;margin:5px 10px 0 0">
                您好，<%--<s:property value="(#session['loginUser']).userName"/>--%></li>
        </ul>
        <div id="tabs-1">
            <div class="info">
                <div class="search">
                    <input id="keywords" class="autoComplete" type="text" name="keywords" value=""/>
                    <input id="gridSearch" class="gridSearch" type="button" name="search" value="搜索"/>
                </div>
            </div>
            <table id="mygrid"></table>
        </div>
        <div id="tabs-2">
            <jsp:include page="add.jsp"/>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>