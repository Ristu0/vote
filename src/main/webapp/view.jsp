<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("text/html;charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<jsp:include page="top.jsp"/>
<div id="vote" class="wrap">
    <h2>查看投票</h2>
    <ul class="list">
        <li>
            <h4>${requestScope.subjectDTO.vsTitle}</h4>
            <p class="info">共有 ${requestScope.subjectDTO.optionCount}个选项，已有${requestScope.subjectDTO.personCount}个网友参与了投票。</p>
            <ol>

                <c:forEach items="${requestScope.subjectDTO.optionDTOS}" var="option">

                <li>${option.voOption}
                    <div class="rate">
                        <div class="ratebg" data="${option.count/requestScope.count*100}"></div>
                        <p>${option.count}票 <span>(${option.count/requestScope.count*100}%)</span>
                        </p>
                    </div>
                </li>

                </c:forEach>
            </ol>
            <div class="goback"><a href="subject!list.action?subject.id=/*<s:property value='subject.id'/>*/">返回投票列表</a>
            </div>
        </li>
    </ul>
</div>
<div id="footer" class="wrap">
    百知 &copy; 版权所有
</div>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryui/themes/base/jquery-ui.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jqueryui/jquery-ui.js"></script>
<script>
    $(".ratebg").each(function (i, ele) {
        var v = parseInt($(ele).attr("data"));
        $(ele).progressbar({
            value: v
        });
    });
</script>
</body>
</html>
