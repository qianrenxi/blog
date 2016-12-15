<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="include/assets.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="include/header.jsp"></jsp:include>
	
  <div id="index-banner" class="parallax-container hide">
    <div class="section no-pad-bot">
      <div class="container">
        <br><br>
        <h1 class="header center teal-text text-lighten-2">Parallax Template</h1>
        <div class="row center">
          <h5 class="header col s12 light">A modern responsive front-end framework based on Material Design</h5>
        </div>
        <div class="row center">
          <a href="http://materializecss.com/getting-started.html" id="download-button" class="btn-large waves-effect waves-light teal lighten-1">Get Started</a>
        </div>
        <br><br>

      </div>
    </div>
    <div class="parallax"><img src="${ctx }/assets/home/images/background1.jpg" alt="Unsplashed background img 1"></div>
  </div>
  
  <div class="container">
  	<div class="row">
  		<div class="col s12 l8">
		  	<c:forEach items="${latestArticles.content }" var="article">
	          <div class="card">
	            <div class="card-content">
	              <span class="card-title orange-text darken-2">${article.title }</span>
	              <p>I am a very simple card. I am good at containing small bits of information.
	              I am convenient because I require little markup to use effectively.</p>
	            </div>
	            <div class="card-action">
	              <a href="${ctx }/article/${article.id }">阅读全文</a>
	            </div>
	          </div>
		  	</c:forEach>
  		</div>
  		<div class="col s12 l4">
  			<div class="card">
	            <div class="card-content">
	              <span class="card-title orange-text darken-2">我的文章 （12篇）</span>
	              <p>
	              	
	              </p>
	              <p style="text-align: center;">
	              	<a class="waves-effect waves-light btn-large" style="width: 100%;">Add Article</a>
	              </p>
	            </div>
	        </div>
  		</div>
  	</div>
  </div>
  
  <jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>