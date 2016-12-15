<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>

<header>
	<nav class="white" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="${ctx }/" class="brand-logo">我的博客</a>
			<ul class="right hide-on-med-and-down">
				<li class="active"><a href="${ctx }/">首页</a></li>
				<li><a href="${ctx }/article/list">文章</a></li>
				<li><a href="${ctx }/">关于</a></li>
				<li><a href="${ctx }/admin" target="_blank">管理</a></li>
			</ul>
			
			<ul id="nav-mobile" class="side-nav">
				<li><a href="${ctx }/">首页</a></li>
				<li><a href="${ctx }/article/list">文章</a></li>
				<li><a href="${ctx }/">关于</a></li>
				<li><a href="${ctx }/admin">管理</a></li>
			</ul>
			<a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
		</div>
	</nav>
</header>