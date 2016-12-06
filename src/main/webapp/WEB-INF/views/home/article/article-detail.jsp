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
<article>
<h1>${article.title }</h1>
${article.content }
</article>
</body>
</html>