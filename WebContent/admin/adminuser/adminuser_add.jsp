 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理员信息管理</title>
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
    <link href="assets/css/style.css" rel="stylesheet">
    
    <script type="text/javascript" src="../js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript">
			function logout(){
				if(confirm("您确定要退出系统吗？")){
					window.location.href="logout";
				}
			}
		</script>
		<script type="text/javascript">
			function adminusersave(){
		        var adminuser_username = document.getElementById('adminuser_username').value;
		        if (adminuser_username == '') {
		        	alert("管理员名称不能为空");
		        } else {
					var adminuser_password = document.getElementById('adminuser_password').value;
		        	if (adminuser_password == '') {
		        		alert("管理员密码不能为空！");
		        	} else {
	
						var adminuser_iphone = document.getElementById('adminuser_iphone').value;
						if (adminuser_iphone == '') {
							alert("手机号码不能为空！");
						} else {
							var adminuser_email = document.getElementById('adminuser_email').value;
							if (adminuser_email == '') {
								alert("电子邮箱不能为空！");
							} else {
								var adminuserId = document.getElementById('adminuserId').value;
								var adminuser_sn = document.getElementById('adminuser_sn').value;
								$.post(
										"adminusersave",
										{
											adminuserId : adminuserId,
											adminuser_sn : adminuser_sn,
											adminuser_username : adminuser_username,
											adminuser_password : adminuser_password,
											adminuser_iphone : adminuser_iphone,
											adminuser_email : adminuser_email
										},
										function(result) {
											var result = eval('(' + result + ')');
											if (result.result == "failone") {
												alert("用户名已存在");
											} else if (result.result == "successone") {
												alert("修改管理员信息成功");
												window.location.href = "adminuserlist";
											} else if (result.result == "failtwo") {
												alert("修改管理员信息失败");
											} else if (result.result == "successtwo") {
												alert("添加管理员成功");
												window.location.href = "adminuserlist";
											} else if (result.result == "failthree") {
												alert("添加管理员失败");
											}
									});
							}
						}
		        	}
				}
		        return flag;
			}
		</script>
</head>

<body>

    <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
        <div class="nano">
            <div class="nano-content">
                <ul>
                	<li class="active">
                		<a class="sidebar-sub-toggle">
                			<i class="ti-layout"></i>功能如下
                		</a>
                    </li>
                	<li>
                		<a class="sidebar-sub-toggle">
                			<i class="ti-layout"></i> 管理员信息管理
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
							<i class="ti-panel"></i> 商品类型管理 
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
    <div class="header">
        <div class="pull-left">
           <div class="logo">
                <a href="adminuserlist">
                    <img id="logoImg"  src="logo/logo.png"   data-logo_big="logo/logo.png" data-logo_small="logo/logoSmall.png" alt="Nixon" />
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
                                <h1>新增管理员信息</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 p-0">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="#">管理员信息管理</a></li>
                                    <li class="active">${title}</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="main-content">
					<div class="row">
                        <div class="col-lg-10">
                            <div class="card alert">
                                <div class="card-header">
                                    <h4>${title}</h4>
                                    <div class="card-header-right-icon">
                                        <ul>
                                            <li class="card-close" data-dismiss="alert"><i class="ti-close"></i></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="basic-form">
                                        <form>
                                        	<input type="hidden" id="adminuserId" name="adminuserId" value="${adminuserId}">
                                            <div class="form-group">
												<label>管理员编号</label>
												<c:choose>
													 <c:when test="${adminuser.adminuser_sn != '' && adminuser.adminuser_sn != null}">
														<input type="text" class="form-control" id="adminuser_sn" name="adminuser_sn" value="${adminuser.adminuser_sn}" readonly="readonly">
													 </c:when>
													 <c:otherwise>
														<input type="text" class="form-control" id="adminuser_sn" name="adminuser_sn" value="${adminuser_sn_max}" readonly="readonly">
													 </c:otherwise>
												</c:choose>
												<span class="help-block">管理员编号由系统自动生成，不可编辑</span>
											</div>
                                            <div class="form-group">
	                                             <label>管理员名称</label>
	                                             <input type="text" class="form-control" id="adminuser_username" name="adminuser_username" placeholder="请输入管理员名称" value="${adminuser.adminuser_username}">
	                                        </div>
                                            <div class="form-group">
	                                             <label>管理员密码</label>
	                                             <input type="password" class="form-control" id="adminuser_password" name="adminuser_password" placeholder="请输入密码" value="${adminuser.adminuser_password}">
	                                        </div>
	                                        <div class="form-group">
                                                 <label>手机号码</label>
                                                 <input type="number" class="form-control" id="adminuser_iphone" name="adminuser_iphone" placeholder="请输入手机号码" value="${adminuser.adminuser_iphone}">
                                        	</div>
                                        	<div class="form-group">
	                                             <label>电子邮箱</label>
	                                             <input type="text" class="form-control" id="adminuser_email" name="adminuser_email" placeholder="请输入电子邮箱" value="${adminuser.adminuser_email}">
	                                        </div>
                                            <button type="button" class="btn btn-success" onclick="adminusersave();">提交</button>
					                        <button type="button" class="btn btn-default" onclick="javascript:history.back()">返回</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
				</div>
            </div>
        </div>
    </div>
    <script src="assets/js/lib/jquery.min.js"></script><!-- jquery vendor -->
    <script src="assets/js/lib/jquery.nanoscroller.min.js"></script><!-- nano scroller -->   
    <script src="assets/js/lib/sidebar.js"></script><!-- sidebar -->
    <script src="assets/js/lib/bootstrap.min.js"></script><!-- bootstrap -->
    <script src="assets/js/lib/mmc-common.js"></script>
    <script src="assets/js/lib/mmc-chat.js"></script>
    <script src="assets/js/scripts.js"></script><!-- scripit init-->
</body>
</html>