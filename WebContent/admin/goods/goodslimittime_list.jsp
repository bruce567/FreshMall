<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>限时抢购管理</title>
	
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
    <script type="text/javascript">
			function logout(){
				if(confirm("您确定要退出系统吗？")){
					window.location.href="logout";
				}
			}
		</script>
		<script type="text/javascript">
			function goodsDelete(goodsId) {
				if (confirm("确定要删除这条记录吗?")) {
					$.post(
						"goodsdelete",
						{
							goodsId : goodsId
						},
						function(result) {
							var result = eval('(' + result + ')');
							if (result.error) {
								alert(result.error);
							} else {
								alert("删除成功！");
								window.location.href = "goodslimittimelist";
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
                                <h1>限时抢购商品列表</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 p-0">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="#">限时抢购管理</a></li>
                                    <li class="active">限时抢购商品列表</li>
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
												<a type="button" class="btn btn-success m-b-10" href="goodslimittimepreSave">添加商品</a>
			                                    <a type="button" class="btn btn-warning m-b-10" href="goodslimittimelist">刷新</a>
											</h6>
										</div>
										<div class="panel-actions" style="float:right;width:430px;margin-top:10px;margin-right:15px;">
											<form name="myForm" method="post" action="goodslimittimelist">
												<input type="hidden" name="type" value="search">
			                                    <div class="form-group" style="float:left;width:180px;">
													<div class="col-md-9">
														<select id="searchType" name="searchType" class="form-control" size="1" style="width:180px;height:42px;">
															<option value="goodsname">商品名称</option>
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
												<th>商品图片</th>
											    <th>商品名称</th>
											    <th>商品类型</th>
											    <th>店铺名称</th>
											    <th>商品价格</th>
											    <th>商品数量</th>
											    <th>开始时间</th>
											    <th>结束时间</th>
												<th style="float:left;border:0px;">操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach varStatus="i" var="goods" items="${goodslist}">
	                                            <tr>
													<td>${i.count+(page-1)*pageSize }</td>
													<td>
														<img src="${goods.goods_images}" style="width:100px; height:100px;">
													</td>
											        <td>${goods.goods_name}</td>
											        <td>${goods.goodstype_name}</td>
											        <td>${goods.shop_name}</td>
											        <td>${goods.goods_price}</td>
											        <td>${goods.goods_num}</td>
											        <td>${goods.goods_starttime}</td>
											        <td>${goods.goods_endtime}</td>
													<td>
														<div style="float:left;margin-right:10px;">
															<a class="btn btn-xs btn-warning" href="goodslimittimepreSave?goodsId=${goods.goods_id}">编辑</a>
														</div>
														<div style="float:left;">
											        		<a class="btn btn-xs btn-danger" onclick="goodsDelete('${goods.goods_id}')">删除</a>
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