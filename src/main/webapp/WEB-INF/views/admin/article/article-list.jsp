<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<c:set var="ctxAdmin" value="${ctx }/admin"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../include/header.jsp"></jsp:include>
	<div class="actions">
		<a href="${ctxAdmin }/article/add">添加</a>
	</div>
	<div>
		<c:forEach items="${articles.content }" var="article">
			<div>
				<a href="${ctx }/article/${article.id }">${article.title }</a>
				<a href="${ctxAdmin }/article/${article.id }/edit">编辑</a>
				<a href="${ctxAdmin }/article/edit?ids[]=${article.id }">删除</a>
			</div>
		</c:forEach>
	</div>
</body>
</html>