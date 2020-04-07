 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>生鲜商品管理</title>
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
    
    <script type="text/javascript" charset="utf-8" src="../admin/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="../admin/ueditor/ueditor.all.js"></script>
		<script type="text/javascript" charset="utf-8" src="../admin/ueditor/ueditor.all.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="../admin/ueditor/lang/zh-cn/zh-cn.js"></script>
		
		<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript">
			function logout(){
				if(confirm("您确定要退出系统吗？")){
					window.location.href="logout";
				}
			}
		</script>
		<script type="text/javascript">
			function formcheckForm(){
				var flag = false;
				var goods_content_value = UE.getEditor('goods_content_editor').getContent();
		        document.getElementById('goods_content_id').value = goods_content_value;//给goods_content_value的input赋值
		        var shop_id = document.getElementById('shop_id').value;
		        if (shop_id == 0) {
		        	alert("店铺不能为空！");
		        	flag = false;
		        } else {
		        	var goodstype_id = document.getElementById('goodstype_id').value;
			        if (goodstype_id == 0) {
			        	alert("商品类型不能为空！");
			        	flag = false;
			        } else {
			        	var goods_images = document.getElementById('goods_images').value;
				        if (goods_images == '') {
				        	alert("商品图片不能为空！");
				        	flag = false;
				        } else {
				        	var goods_name = document.getElementById('goods_name').value;
				        	if (goods_name == '') {
				        		alert("商品名称不能为空！");
					        	flag = false;
				        	} else {
				        		var goods_price = document.getElementById('goods_price').value;
				        		if (goods_price == '') {
				        			alert("商品价格不能为空！");
						        	flag = false;
				        		} else {
				        			var goods_num = document.getElementById('goods_num').value;
				        			if (goods_num == '') {
				        				alert("商品数量不能为空！");
							        	flag = false;
				        			} else {
				        				if (goods_content_value == '') {
						        			alert("商品介绍不能为空！");
								        	flag = false;
						        		} else {
						        			alert("商品信息提交成功！");
											flag = true;
						        		}
				        			}
				        		}
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
                                <h1>新增商品信息</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 p-0">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="#">生鲜商品管理</a></li>
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
                                        <form class="form-horizontal form-bordered" method="post" action="goodssave" onsubmit="return formcheckForm();">
                                        	<input type="hidden" name="goodsId" value="${goodsId}">
                                        	<input type="hidden" name="goods_promote" value="1">
                                        	<div class="form-group">
						                        <label>所属店铺</label>
								                <select id="shop_id" name="shop_id" class="" style="width:150px;height:30px;">
								                    <option value="0">请选择店铺</option>
												    <c:forEach var="shop" items="${shoplist}">
												         <option value="${shop.shop_id}" ${shop.shop_id==goods.shop_id?'selected':'' }>${shop.shop_name}</option>
												    </c:forEach>
								                </select>
							                </div>
                                            <div class="form-group">
						                        <label>商品类型</label>
								                <select id="goodstype_id" name="goodstype_id" class="" style="width:150px;height:30px;">
								                    <option value="0">请选择类型</option>
												    <c:forEach var="goodstype" items="${goodstypelist}">
												         <option value="${goodstype.goodstype_id}" ${goodstype.goodstype_id==goods.goodstype_id?'selected':'' }>${goodstype.goodstype_name}</option>
												    </c:forEach>
								                </select>
							                </div>
                                            <div class="form-group">
							                    <label>商品图片</label>
						                        <input id="goods_images" type="text" class="form-control" name="goods_images" placeholder="商品图片地址" value="${goods.goods_images}" readonly="readonly">
						                        <div>
														<div id="upload_img_wrap_head" class="input-group " style="margin-top: .5em;">
															<c:if test="${goods.goods_images != null}">
																<img id="lastview" src="${goods.goods_images}" style="width:80px;">
															</c:if>
															<c:if test="${goods.goods_images == null}">
																<img src="../admin/images/noimage.png" onerror="" class="img-responsive img-thumbnail" width="80" />
															</c:if>
														</div>
														<div class="input-group " style="margin-top: .5em;">
															<span>
																<button class="layui-btn layui-btn-mini" type="button" id="goods_images_upload_img_btn">选择图片</button>
																<!-- 加载编辑器的容器 -->
																<textarea id="adminuserimageuploadEditor" style="display: none;"></textarea>
															</span>
														</div>
												</div>
												<!-- 使用ue -->
												<script type="text/javascript">
													// 实例化编辑器，这里注意配置项隐藏编辑器并禁用默认的基础功能。
													var adminuserimageuploadEditor = UE.getEditor("adminuserimageuploadEditor", {
														isShow: false,
														focus: false,
														enableAutoSave: false,
														autoSyncData: false,
														autoFloatEnabled:false,
														wordCount: false,
														sourceEditor: null,
														scaleEnabled:true,
														toolbars: [["insertimage", "attachment"]]
													});
																													 
													// 监听多图上传和上传附件组件的插入动作
													adminuserimageuploadEditor.ready(function () {
														adminuserimageuploadEditor.addListener("beforeInsertImage", _headbeforeInsertImage);
														adminuserimageuploadEditor.addListener("afterUpfile",_afterUpfile);
													});
																													 
													// 自定义按钮绑定触发多图上传和上传附件对话框事件
													document.getElementById('goods_images_upload_img_btn').onclick = function () {
														var dialog = adminuserimageuploadEditor.getDialog("insertimage");
														dialog.title = '多图上传';
														dialog.render();
														dialog.open();
													};
													// 多图上传动作
													function _headbeforeInsertImage(t, result) {
														var imageHtml = '<li><img src="'+result[0].src+'" alt="'+result[0].alt+'" class="img-responsive img-thumbnail" width="80"></br>'+result[0].alt+'</li>';
														document.getElementById('upload_img_wrap_head').innerHTML = imageHtml;
														document.getElementById('goods_images').value = result[0].src;//给goods_images的input赋值
													}
												</script>
						                    </div>
                                            <div class="form-group">
	                                             <label>商品名称</label>
	                                             <input type="text" class="form-control" id="goods_name" name="goods_name" placeholder="请输入商品名称" value="${goods.goods_name}">
	                                        </div>	
	                                        <div class="form-group">
	                                             <label>商品价格</label>
	                                             <input type="text" class="form-control" id="goods_price" name="goods_price" placeholder="请输入商品价格" value="${goods.goods_price}">
	                                        </div>
	                                        <div class="form-group">
	                                             <label>商品数量</label>
	                                             <input type="text" class="form-control" id="goods_num" name="goods_num" placeholder="请输入商品数量" value="${goods.goods_num}">
	                                        </div>
                                        	<div class="form-group">
							                    <label>商品介绍</label>
												<div>
													<div style="height:auto">
														<input type="hidden" id="goods_content_id" name="goods_content" value="">
														<script id="goods_content_editor" type="text/javascript" charset="utf-8">${goods.goods_content}</script>
													</div>
													<div class="help-block">内容，可上传图片</div>
												</div>
												<script type="text/javascript" charset="utf-8">
													window.onload = function() {
														UE.getEditor('goods_content_editor');
													}
												</script>
					                        </div>
                                            <button type="submit" class="btn btn-success">提交</button>
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