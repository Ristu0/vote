<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("text/html;charset=UTF-8");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>参与投票</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<jsp:include page="top.jsp"/>
<div id="vote" class="wrap">
    <h2>参与投票</h2>
    <ul class="list">
        <li>
            <h4></h4>
            <p class="info">共有${requestScope.vote.optionCount} 个选项，已有${requestScope.vote.personCount} 个网友参与了投票。</p>
            <form method="post" action="${pageContext.request.contextPath}/vote/addVoteResult"
                  onsubmit="return validate();" id="voteResultForm">
                <input type="hidden" name="vsId" value="${requestScope.vote.vsId}">
                <ol>
                    <s:if test="${requestScope.vote.vsType==0}">
                        <s:forEach var="vo" items="${requestScope.vote.voteOptions}">
                            <li>
                                <input type="checkbox" name="voId" value="${vo.voId}">${vo.voOption}
                            </li>
                        </s:forEach>
                    </s:if>
                    <s:if test="${requestScope.vote.vsType==1}">
                        <s:forEach var="vo" items="${requestScope.vote.voteOptions}">
                            <li>
                                <input type="radio" name="voId" value="${vo.voId}">${vo.voOption}
                            </li>
                        </s:forEach>
                    </s:if>
                </ol>
                <p class="voteView">
                    <button>投票</button>
                    <a href="#">查看</a>
                </p>
            </form>
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
    $(function () {
        $(".voteView").children("button").button({
            icons: {
                primary: "ui-icon-locked"
            },
            onClick: function () {
                $("#voteResultForm").submit();
            }
        }).next().button({
            icons: {
                primary: "ui-icon-locked"
            }
        });
    })

    function validate() {
        var options = $("input[name='voId']:checked").val();
        if (options == null || options == "undefined" || options.length == 0) {
            alert("请至少选择一个投票项！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
