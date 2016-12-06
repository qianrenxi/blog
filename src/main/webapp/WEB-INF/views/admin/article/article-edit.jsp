<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp" %>

<div class="animated fadeIn">
	<div class="row">
		<div class="col-xs-12">
			<div class="card">
				<div class="card-header">
					<c:choose>
						<c:when test="${article.id > 0 }">
							<strong>[编辑]${artitle.title }</strong>
						</c:when>
						<c:otherwise>
							<strong>添加文章</strong>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="card-block">
					<form:form name="articleForm" modelAttribute="article" action="${ctx }/admin/article/save" method="post">
						<form:hidden path="id"/>
						<div class="form-group">
							<label>文章内容</label>
							<form:textarea path="theOriginal" cssClass="form-control" rows="30" />
							<span class="help-block">请输入文章内容</span>
						</div>
						<div class="form-group hide">
							<form:button class="btn btn-primary">保存</form:button>
							<a class="btn btn-secondary go-back"><i class="fa fa-back"></i> 取消</a>
						</div>
					</form:form>
				</div>
				<div class="card-footer">
					<button class="btn btn-primary action-save">保存</button>
					<a class="btn btn-secondary go-back"><i class="fa fa-back"></i> 取消</a>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
$(".action-save").click(function(){
	var f = $("form[name='articleForm']");
	var action = f.prop("action");
	var data = f.serializeArray();
	var method = f.prop("method") || 'post';
	
	$.ajax({
		type: method,
		url: action,
		data: data,
		dataType: 'json',
		success: onPostSuccess,
		error: onPostError
	});
	
	function onPostSuccess(result){
		loadPage("${ctxAdmin }/article/list");
	}
	
	function onPostError(result){
		console.log("Post form error.");
	}
});
</script>