<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>生鲜商场后台管理系统</title>
    <!-- ================= Favicon ================== -->
    <!-- Standard -->
    <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
    <!-- Retina iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
    <!-- Retina iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
    <!-- Standard iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
    <!-- Standard iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">
    <!-- Styles -->
    <link href="assets/fontAwesome/css/fontawesome-all.min.css" rel="stylesheet">
    <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="assets/css/lib/mmc-chat.css" rel="stylesheet" />
    <link href="assets/css/lib/sidebar.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/lib/nixon.css" rel="stylesheet">
    <link href="assets/lib/lobipanel/css/lobipanel.min.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
</head>

<body>
    <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
        <div class="nano">
            <div class="nano-content">
                <ul>
                	<li class="active">
                		<a class="sidebar-sub-toggle">
                			<i class="ti-layout"></i>欢迎登录系统
                		</a>
                    </li>
                	<li>
                		<a class="sidebar-sub-toggle">
                			<i class="ti-layout"></i>管理员信息管理
                			<span class="sidebar-collapse-icon ti-angle-down"></span>
                		</a>
                        <ul>
                            <li><a href="adminuserlist">管理员信息</a></li>
                            <li><a href="adminuserupdatepassword">修改管理员密码</a></li>
                        </ul>
                    </li>
                    
                    <li>
						<a class="sidebar-sub-toggle">
							<i class="ti-bar-chart-alt"></i>用户信息管理  
							<span class="sidebar-collapse-icon ti-angle-down"></span>
						</a>
                        <ul>
                            <li><a href="userlist">用户信息</a></li>
                        </ul>
                    </li>
                    
					<li>
						<a class="sidebar-sub-toggle">
							<i class="ti-layout"></i>店铺信息管理 
							<span class="sidebar-collapse-icon ti-angle-down"></span>
						</a>
                        <ul>
                            <li><a href="shoplist">店铺信息</a></li>
                        </ul>
                    </li>
					<li>
						<a class="sidebar-sub-toggle">
							<i class="ti-panel"></i>商品类型管理 
							<span class="sidebar-collapse-icon ti-angle-down"></span>
						</a>
                        <ul>
                            <li><a href="goodstypelist">商品类型</a></li>
                        </ul>
                    </li>
					<li>
						<a class="sidebar-sub-toggle">
							<i class="ti-bar-chart-alt"></i>生鲜商品管理  
							<span class="sidebar-collapse-icon ti-angle-down"></span>
						</a>
                        <ul>
                            <li><a href="goodslist">生鲜商品</a></li>
                        </ul>
                    </li>	
                    
                    <li>
						<a class="sidebar-sub-toggle">
							<i class="ti-bar-chart-alt"></i>限时抢购管理 
							<span class="sidebar-collapse-icon ti-angle-down"></span>
						</a>
                        <ul>
                            <li><a href="goodslimittimelist">限时抢购</a></li>
                        </ul>
                    </li>
					
					<li>
						<a class="sidebar-sub-toggle">
							<i class="ti-layout-grid4-alt"></i>优惠券管理 
							<span class="sidebar-collapse-icon ti-angle-down"></span>
						</a>
                        <ul>
                            <li><a href="couponlist">优惠券</a></li> 
                        </ul>
                    </li>
					
					<li>
						<a class="sidebar-sub-toggle">
							<i class="ti-heart"></i> 订单信息管理  
							<span class="sidebar-collapse-icon ti-angle-down"></span>
						</a>
                        <ul>
                            <li><a href="buylist">订单信息 </a></li>
                        </ul>
                    </li>
                    <li><a href="javascript:logout()"><i class="ti-close"></i>退出系统</a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- /# sidebar -->
    <div class="header">
        <div class="pull-left">
            <div class="logo">
                <a href="index.html">
                    <img id="logoImg" src="logo/logo.png" data-logo_big="logo/logo.png" data-logo_small="logo/logoSmall.png" alt="Nixon" />
                </a>
            </div>
        </div>
        <div class="pull-right p-r-15">
            <ul>
                <li class="header-icon dib">
                	<img class="avatar-img" src="assets/images/avatar/1.jpg" alt="" /> 
                	<span class="user-avatar">${currentAdminUser.adminuser_username }<i class="ti-angle-down f-s-10"></i></span>
                    <div class="drop-down dropdown-profile">
                        <div class="dropdown-content-body">
                            <ul>
                                <li><a href="javascript:logout()"><i class="ti-power-off"></i> <span>退出</span></a></li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    
    <div class="content-wrap">
        <div class="main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 p-0">
                        <div class="page-header">
                            <div class="page-title">
                                <h1>生鲜商场后台管理系统主页</h1>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                    <div class="col-lg-4 p-0">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="#">欢迎登录</a></li>
                                    <li class="active">Home</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                </div>
                <!-- /# row -->
                <div class="main-content">
                    <div class="row">
                    	<div align="center" style="margin-top:180px;">
                    		<span style="color:#00838d;font-size:40px;">欢迎使用生鲜商场后台管理系统！</span>
                    	</div>
                    </div>
               </div>
 </div>
 <!-- /# container-fluid -->
</div>
<!-- /# main -->
</div>
<!-- /# content wrap -->
<script src="assets/js/lib/jquery.min.js"></script>
<!-- jquery vendor -->
<script src="assets/js/lib/jquery.nanoscroller.min.js"></script>
<!-- nano scroller -->
<script src="assets/js/lib/sidebar.js"></script>
<!-- sidebar -->
<script src="assets/js/lib/bootstrap.min.js"></script>
<!-- bootstrap -->
<script src="assets/js/lib/mmc-common.js"></script>
<script src="assets/js/lib/mmc-chat.js"></script>
<!--  Chart js -->
<script src="assets/js/lib/chart-js/Chart.bundle.js"></script>
<script src="assets/js/lib/chart-js/chartjs-init.js"></script>
<!-- // Chart js -->
<!--  Datamap -->
<script src="assets/js/lib/datamap/d3.min.js"></script>
<script src="assets/js/lib/datamap/topojson.js"></script>
<script src="assets/js/lib/datamap/datamaps.world.min.js"></script>
<script src="assets/js/lib/datamap/datamap-init.js"></script>
<script src="assets/lib/lobipanel/js/lobipanel.js"></script>
<!-- // Datamap -->
<script src="assets/js/scripts.js"></script>
<!-- scripit init-->
<script>
    $(document).ready(function() {
        $('#lobipanel-custom-control').lobiPanel({
            reload: false,
            close: false,
            editTitle: false
        });
    });
</script>
</body>

</html>