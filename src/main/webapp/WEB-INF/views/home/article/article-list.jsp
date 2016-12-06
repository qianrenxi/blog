<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Blog of Qian Renxi</h1>
<hr>
<a href="${ctx }/admin">管理</a>
<a href="${ctx }/article/list">文章</a>
<hr>
<ul>
<c:forEach items="${articles.content }" var="article">
	<li>
		<a href="${ctx }/article/${article.id }">${article.title }</a><br>
		<span>作者：</span>
		<c:forEach items="${article.authors }" var="author" varStatus="status">
			<c:if test="${status.count > 1 }">,</c:if>
			<span>${author.name }</span>
			<c:if test="${not empty author.email }"><span>&lt;${author.email }&gt;</span></c:if>
		</c:forEach>
		<span>发表日期：</span><span>${article.reversionInfo.date }</span>
	</li>
</c:forEach>
</ul>
</body>
</html>