<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp" %>

<div class="animated fadeIn">
	<div class="card">
		<div class="card-block">
			<div class="row">
				<div class="col-xs-5">
                    <h4 class="card-title">文章管理</h4>
                    <div class="small text-muted" style="margin-top:-10px;">管理管理文章</div>
                </div>
                <div class="col-xs-7">
                	<div class="btn-toolbar float-xs-right" role="toolbar" aria-label="Toolbar with button groups">
                		<div class="btn-group" role="group" aria-label="Second group">
                            <button type="button" class="btn btn-primary actions-article-add"><i class="icon-plus"></i> 添加文章
                            </button>
                        </div>
                	</div>
                </div>
			</div>
			<div class="span-8"></div>
			<!-- <div class="table-before">
			</div> -->
			<div class="row">
				<div class="col-xs-6">
                    <form class="form-horizontal">
                    <div class="row">
                    	<div class="col-xl-6">
                    		<div class="input-group">
                    			<input class="form-control" placeholder="Please enter keywords for search">
                    			<span class="input-group-btn">
                    				<button type="button" class="btn btn-primary">Search</button>
                    			</span>
                    		</div>
		                </div>
		            </div>
		            </form>
                </div>
                <div class="col-xs-6">
                	<div class="btn-toolbar float-xs-right" role="toolbar" aria-label="Toolbar with button groups">
                		<div class="btn-group" role="group" aria-label="Second group">
                            <button type="button" class="btn btn-danger actions-article-delete"><i class="fa fa-trash-o"></i> 批量删除
                            </button>
                        </div>
                	</div>
                </div>
			</div>
			<div class="span-8"></div>
			<table class="table table-hover table-outline mb-0 hidden-sm-down">
				<thead class="thead-default">
					<tr>
						<th>Title</th>
						<th>Authors</th>
						<th>Version Number</th>
						<th>Date</th>
						<th>Remark</th>
						<th class="text-xs-right">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${articles.content }" var="article">
						<tr>
							<td><a href="${ctx }/article/${article.id }" target="_blank">${article.title }</a></td>
							<td>
								<c:forEach items="${article.authors }" var="author" varStatus="status">
									<c:if test="${status.count>1 }">,</c:if>
									<span>${author.name }</span>
								</c:forEach>
							</td>
							<td>${article.reversionInfo.number }</td>
							<td>${article.reversionInfo.date }</td>
							<td>${article.reversionInfo.remark }</td>
							<td class="text-xs-right">
								<a class="load-page" href="${ctxAdmin }/article/${article.id }/edit">编辑</a>
								<a href="${ctxAdmin }/article/delete?ids[]=${article.id }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="table-after">
				<div class="pagenation"></div>
			</div>
		</div>
	</div>
</div>
	
<script>
var requireJS = [];

// loadJS(requireJS, "js/views/main.js");
$(function(){
	$(".actions-article-add").click(function(){
		loadPage("${ctxAdmin }/article/add");
	});
});
</script>