<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
		<button>保存</button>
		<button>取消</button>
	</div>
	<div>
		<form:form name="articleForm" modelAttribute="article" action="${ctx }/admin/article/save" method="post">
			<form:hidden path="id"/>
			<form:textarea path="theOriginal"/>
			
			<form:button>保存</form:button>
		</form:form>
	</div>
</body>
</html>