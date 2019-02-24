<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%--<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("text/html;charset=UTF-8");
%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>管理投票</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <jsp:include page="comm/comm_jQueryUI_js.jsp"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/e.js"></script>
    <jsp:include page="comm/comm_easyUI_js.jsp"/>

</head>
<body>
<div class="info">
    <div class="search">
        <input class="autoComplete" id="manageKeywords" type="text" name="keywords" value=""/>
        <input id="manageSearch" class="gridSearch" type="button" name="search" value="搜索"/>
    </div>
</div>
<table id="manageGrid" class="easyui-datagrid"></table>
<script type="text/javascript">
    function person_fm(value) {
        if (value == null) {
            return 0;
        }
        return value;
    }

    $(function () {
        manageGrid();
        $("#manageSearch").click(function () {
            var keywords = $('#manageKeywords').val();
            $('#manageGrid').datagrid('load', {keywords: keywords});
        });
    });

    function manageGrid() {
        $('#manageGrid').datagrid({
            url: '${pageContext.request.contextPath}/vote/voteList',
            //singleSelect:true,
            rownumbers: true,
            iconCls: 'icon-search',
            pagination: true,//显示底部分页栏
            pageSize: 10,//默认每页记录数，pagination参数为true时才有效
            pageList: [5, 10, 15], //显示列表记录数的下拉框选项，pagination参数为true时才有效
            fitColumns: true,//自适应宽度，防止水平滚动
            striped: true,//隔行变色
            columns: [[
                {field: 'vsId', title: 'id', hidden: 'true'},
                {field: 'vsTitle', title: '投票标题', width: 300},
                {field: 'optionCount', title: '选项数', align: 'right'},
                {field: 'personCount', title: '投票人数', align: 'right', formatter: person_fm},
                {
                    field: 'opr', title: '操作', align: 'center', formatter: function () {
                        return "<a herf='#' style='color:red;'>维护</a>";
                    }
                }
            ]],
            onClickCell: function (index, field, v) {
                /*if (field == "update") {*/
                var id = $(this).datagrid("getRows")[index].vsId;
                window.location.href = "${pageContext.request.contextPath}/votesubject/showOne?id=" + id;
                /* }*/
            },
            loadMsg: "正努力为您加载中......"
        });
    }

</script>
</body>
</html>
