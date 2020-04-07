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
    <link href="css/page.css" rel="stylesheet">
    <script type="text/javascript">
			function logout(){
				if(confirm("您确定要退出系统吗？")){
					window.location.href="logout";
				}
			}
		</script>
		<script type="text/javascript">
			function adminuserDelete(adminuserId) {
				if (confirm("确定要删除这条记录吗?")) {
					$.post(
						"adminuserdelete",
						{
							adminuserId : adminuserId
						},
						function(result) {
							var result = eval('(' + result + ')');
							if (result.error) {
								alert(result.error);
							} else {
								alert("删除成功！");
								window.location.href = "adminuserlist";
							}
					});
				}
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
							<i class="ti-panel"></i>商品类型管理 
							<span class="sidebar-collapse-icon ti-angle-down"></span>
						</a>
                        <ul>
                            <li><a href="goodstypelist">类型类型</a></li>
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
							<i class="ti-heart"></i>订单信息管理  
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
    </div><!-- /# sidebar -->

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
                                <h1>管理员管理列表</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 p-0">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="#">管理员信息管理</a></li>
                                    <li class="active">管理员管理列表</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="main-content">
                    <div class="row">
                        <div class="col-lg-20">
                            <div class="card alert">
                                <div class="card-header">
                                    <div class="panel-heading bk-bg-white">
                                    	<div style="float:left;">
											<h6>
												<a type="button" class="btn btn-success m-b-10" href="adminuserpreSave">添加管理员</a>
			                                    <a type="button" class="btn btn-warning m-b-10" href="adminuserlist">刷新</a>
											</h6>
										</div>
										<div class="panel-actions" style="float:right;width:430px;margin-top:10px;margin-right:15px;">
											<form name="myForm" method="post" action="adminuserlist">
												<input type="hidden" name="type" value="search">
			                                    <div class="form-group" style="float:left;width:180px;">
													<div class="col-md-9">
														<select id="searchType" name="searchType" class="form-control" size="1" style="width:180px;height:42px;">
															<option value="adminusername">管理员名称</option>
															<option value="adminusersn">管理员编号</option>
														</select>
													</div>
												</div>
			                                    <div class="form-group" style="float:left;width:210px;margin-left:5px;">
													<div class="col-md-12">
														<div class="input-group">
															<input type="text" id="searchvalue" name="searchvalue" class="form-control" placeholder="请输入搜索条件" style="width:200px;height:42px;" />
															<span class="input-group-btn">
																<button type="submit" class="btn btn-success"><i class="fa fa-search"></i></button>
															</span>
														</div>
													</div>
												</div>
											</form>
										</div>
									</div>
                                </div>
                                <div class="card-body">
                                    <table class="table table-responsive table-bordered">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
												<th>管理员编号</th>
												<th>管理员名称</th>
												<th>手机号码</th>
												<th>电子邮箱</th>
												<th>登录时间</th>
												<th>登录IP</th>
												<th style="float:left;border:0px;">操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach varStatus="i" var="adminuser" items="${adminuserList}">
	                                            <tr>
													<td>${i.count+(page-1)*pageSize }</td>
													<td>${adminuser.adminuser_sn}</td>
	                                                <td>${adminuser.adminuser_username}</td>
	                                                <td>${adminuser.adminuser_iphone}</td>
											        <td>${adminuser.adminuser_email}</td>
											        <td>${adminuser.adminuser_lastertime}</td>
											        <td>${adminuser.adminuser_lasterip}</td>
													<td>
											        	<input type="hidden" id="ifadminuser_status_${i.count}" name="adminuser_status" value="${adminuser.adminuser_status }">
											        	<div id="adminuseropen_${i.count }" style="display:none;float:left;margin-right:10px;">
															<a onclick="updateadminusertoclose(${adminuser.adminuser_id},${i.count});" class="btn btn-xs btn-success" >锁定</a>
														</div>
														<div id="adminuserclose_${i.count }" style="display:none;float:left;margin-right:10px;">
															<a onclick="updateadminusertoopen(${adminuser.adminuser_id},${i.count});" class="btn btn-xs btn-info" lay-event="detail">解锁</a>
														</div>
														<script type="text/javascript">
															uploadadminuserstatus(0, ${i.count });
															function uploadadminuserstatus(adminuser_id, icount) {
																var ifadminuser_status_count = "ifadminuser_status_"+icount;
																var ifadminuserstatus = document.getElementById(ifadminuser_status_count).value;
																var adminuseropen_count = "adminuseropen_"+icount;
																var adminuserclose_count = "adminuserclose_"+icount;
																if (ifadminuserstatus == 1) {
																	document.getElementById(adminuseropen_count).style.display = 'block';
																	document.getElementById(adminuserclose_count).style.display = 'none';
																} else if (ifadminuserstatus == 2) {
																	document.getElementById(adminuseropen_count).style.display = 'none';
																	document.getElementById(adminuserclose_count).style.display = 'block';
																}
															}
															function updateadminusertoclose(adminuser_id, icount) {
																if (confirm("确定要锁定该用户吗?")) {
																	$.post(
																		"updateadminusertoclose",
																		{
																			adminuser_id : adminuser_id
																		},
																		function(result) {
																			var result = eval('(' + result + ')');
																			if (result.result == "success") {
																				var adminuseropen_count = "adminuseropen_"+icount;
																				var adminuserclose_count = "adminuserclose_"+icount;
																				document.getElementById(adminuseropen_count).style.display = 'none';
																				document.getElementById(adminuserclose_count).style.display = 'block';
																			} else {
																				alert("设置失败");
																			}
																		});
																}
															}
															function updateadminusertoopen(adminuser_id, icount) {
																if (confirm("确定要解锁该用户吗?")) {
																	$.post(
																		"updateadminusertoopen",
																		{
																			adminuser_id : adminuser_id
																		},
																		function(result) {
																			var result = eval('(' + result + ')');
																			if (result.result == "success") {
																				var adminuseropen_count = "adminuseropen_"+icount;
																				var adminuserclose_count = "adminuserclose_"+icount;
																				document.getElementById(adminuseropen_count).style.display = 'block';
																				document.getElementById(adminuserclose_count).style.display = 'none';
																			} else {
																				alert("设置失败");
																		}
																	});
																}
															}
														</script>
														<div style="float:left;margin-right:10px;">
															<a class="btn btn-xs btn-warning" href="adminuserpreSave?adminuserId=${adminuser.adminuser_id}">编辑</a>
														</div>
														<div style="float:left;">
											        		<a class="btn btn-xs btn-danger" onclick="adminuserDelete('${adminuser.adminuser_id}')">删除</a>
														</div>
											        </td>
												</tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div align="center">
									<ul class="pagination">${pageCode }</ul>
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