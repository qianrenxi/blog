<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<c:set var="ctxAdmin" value="${ctx }/admin"/>
<header>
	<nav>
		<ul>
			<li><a href="${ctxAdmin }/article/list">文章管理</a></li>
		</ul>
	</nav>
</header>