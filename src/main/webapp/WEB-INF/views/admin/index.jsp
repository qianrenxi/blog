<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理</title>
<jsp:include page="include/assets.jsp"></jsp:include>
</head>
<body class="navbar-fixed sidebar-nav fixed-nav">
	<jsp:include page="include/header.jsp"></jsp:include>
	
	<div class="sidebar">
        <nav class="sidebar-nav">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="main.html"><i class="icon-speedometer"></i> Dashboard <span class="tag tag-info">NEW</span></a>
                </li>
                
                <!-- <li class="nav-title">
                    <span>博客文章</span>
                </li> -->
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-puzzle"></i> 文章管理</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="${ctxAdmin }/article/list"><i class="icon-puzzle"></i> 文章列表</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="components/social-buttons.html"><i class="icon-puzzle"></i> Social Buttons</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="components/cards.html"><i class="icon-puzzle"></i> Cards</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="components/forms.html"><i class="icon-puzzle"></i> Forms</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="components/switches.html"><i class="icon-puzzle"></i> Switches</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="components/tables.html"><i class="icon-puzzle"></i> Tables</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="components/tabs.html"><i class="icon-puzzle"></i> Tabs</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
    
    <!-- Main content -->
    <main class="main">
    	<!-- Breadcrumb -->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">Home</li>
            <li class="breadcrumb-item"><a href="#">Admin</a>
            </li>
            <li class="breadcrumb-item active">Dashboard</li>

            <!-- Breadcrumb Menu-->
            <li class="breadcrumb-menu">
                <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                    <a class="btn btn-secondary" href="#"><i class="icon-speech"></i></a>
                    <a class="btn btn-secondary" href="./"><i class="icon-graph"></i> &nbsp;Dashboard</a>
                    <a class="btn btn-secondary" href="#"><i class="icon-settings"></i> &nbsp;Settings</a>
                </div>
            </li>
        </ol>
        
        <div class="container-fluid">
            <div id="ui-view"></div>
        </div>
        <!-- /.conainer-fluid -->
    </main>
	
	<jsp:include page="include/footer.jsp"></jsp:include>
	
	<!-- Bootstrap and necessary plugins -->
    <script src="${ctx }/assets/admin/vendors/jquery/dist/jquery.min.js"></script>
    <script src="${ctx }/assets/admin/vendors/tether/dist/js/tether.min.js"></script>
    <script src="${ctx }/assets/admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${ctx }/assets/admin/vendors/pace/pace.min.js"></script>

    <!-- Plugins and scripts required by all views -->
    <script src="${ctx }/assets/admin/vendors/chart.js/dist/Chart.min.js"></script>

    <!-- GenesisUI main scripts -->
    <script src="${ctx }/assets/admin/scripts/main.js"></script>
</body>
</html>