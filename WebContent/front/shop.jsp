<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="wap-font-scale" content="no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
<meta content="telephone=no" name="format-detection">
<meta content="email=no" name="format-detection">
<title>店铺</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript">
	var wapContainerJson = {};
	var show_module_js = {
		"formUploadFile" : 0,
		"show_statistics_js" : 0,
		"show_biaodan_js" : 0,
		"show_container_js" : 0,
		"show_oto_js" : 0,
		"show_group_js" : 0,
		"show_thread_js" : 0,
		"show_forums_js" : 0,
		"show_shops_js" : 0
	};
	var city_setInfo_json = {
		"del_city" : "1"
	};
	var formUploadFile = parseInt('');
	var wapClassifyJson = '';
	var home_index = parseInt('');
	var noEditTag = parseInt('0');
	var form_group_id = parseInt('');
	var form_channel_id = parseInt('21601173');
</script>
<link type="text/css" rel="stylesheet" href="css/wap/base.css">
<meta name="format-detection" content="telephone=no">
<meta name="format-detection" content="email=no">
<meta content="true" name="HandheldFriendly">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="standard" name="layoutmode">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="webkit" name="renderer">
<meta name="mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no ,target-densitydpi=medium, viewport-fit=cover" name="viewport" id="viewport">
<meta name="applicable-device" content="mobile">

<script type="text/javascript">
	var user_name = "zmnew380";
	var aGlobalBannerHeight = {};
	var is_bianji = parseInt("0");
	var wap_zz_userid = "";
	var wap_is_app = parseInt("0");
	var wap_is_ios = parseInt("0");
	var wap_userid = "1946715";
	var css_channel_id = '21601173';
	var channel_type = parseInt('10');
	var APP_V = '0';
	var AGENT_ID = '0';
	var IS_NEWS_ARTICEL = parseInt('0');
	var LANGUAGE_TYPE = parseInt('0');
	var is_wap_view = parseInt(0);
	var show_check = parseInt(0);
	var use_wxchat_map = 0;
</script>
<script type="text/javascript" src="Language/Zh-cn/Language.js"></script>
<script type="text/javascript" src="plugins/public/js/cookies.js"></script>
<script src="plugins/public/js/jquery-1.7.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="plugins/wap/swiper/swiper-4.3.3.min.css">
<link type="text/css" rel="stylesheet" href="plugins/public/js/slidingVerification/sliding_verification_style.css">

<link type="text/css" rel="stylesheet" href="css/wap/web_frame.css">
<link type="text/css" rel="stylesheet" href="css/wap/wxShareAlert.css">
<link type="text/css" rel="stylesheet" id="webSkinCss" href="templates/wapother11/css/webskin.css">
<link type="text/css" rel="stylesheet" href="templates/wapother11/skin_11/style.css">
<!--change_top_tpl-->
<link type="text/css" rel="stylesheet" href="css/wap/new/index.css">
<link type="text/css" rel="stylesheet" href="css/wap/icomoon_style.css">
<!-- 图标文字 -->
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfont.css">
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfontNew.css">
<!-- end -->
<link type="text/css" rel="stylesheet" href="images/wap/web_style/base_module_style.min.css">
<link type="text/css" rel="stylesheet" href="wap/include/user_define_css.css">

<script type="text/javascript">
	var cart_num_back_color = "#c00";
	var cart_num_text_color = "#fff";
</script>

<link type="text/css" rel="stylesheet" href="plugins/public/css/animate.min.css">
<link type="text/css" rel="stylesheet" href="css/wap/wap_wholesale.css">


</head>
<body>
	<div class="webBody" state="close" id="webBody" data-curbg="wbg_0" data-ver="1">
		<style type="text/css">
			.mainContainer {
				min-height: 300px;
			}
		</style>
		<div class="wrapper" id="wrapper" data-curbg="wbg_"
			style="min-height: 562px;">
			<!--系统搜索模块START-->
			<!--系统搜索模块END-->

			<link type="text/css" rel="stylesheet" href="css/wap/pro_css.css">
			<style>
				.wrapper .ev_t_top_div1 {
					padding: 5px 0;
				}
			</style>
			<!-- <script src="/js/wap/wapShare.js"></script>
			<div class="searchPop">
				<div class="fixedBg"></div>
				<div class="searchFixed">
					<div class="input">
						<i></i>
						<form id="search_form" name="search_form" method="get" action="#" class="ev_t_top_search_input">
						</form>
					</div>
					<a href="javascript:;" class="sBtn">搜索</a>
				</div>
			</div> -->
			<div class="ev_t_top1" id="evTTop2" visible="show" style="display: block">
				<div class="ev_t_top_div1 bgSetup">
					<div class="ev_location">
						<a href="javascript:window.history.go(-1);" class="ev_t_home1"></a>
						<div align="center" style="margin-left:170px;">
							<span style="font-size:16px;">${shop.shop_name}</span>
						</div>
					</div>
				</div>
			</div>
			<div style="height: 40px; display: block"></div>
			<div class="mainContainer">
				<div class="addContainer q" id="add_container">
					<div visible="" rel="r_layout_1" lock="lock" changes="0" id="channel_row_21601173_list" class="customModuleRow innerProductRow">
						<div class="customModule ">
							<div class="Mo   moStyle" id="channel_mo_21601173_list" motype="s1" data-liststyle="10_3">
								<div class="ev_t_product mo_bg">
									<div class="ev_t_product_tit"></div>
									<div id="pro_listInfo" class="contentlist">
										<div class="ev_t_product_list2" style="margin: 0 auto 0;">
											<ol>
												<c:forEach varStatus="i" var="goods" items="${goodslist}">
													<li>
														<div class="ev_t_product_list_div position_r">
															<div class="mo_list">
																<div class="ev_t_product_list_pic imgState">
																	<a href="goodsinfo?goods_id=${goods.goods_id}" class="pro_img"> 
																		<img src="${goods.goods_images}" style="height:180px;">
																	</a>
																</div>
																<div class="ev_t_product_list_text">
																	<a class="urlfont public_margin_b" href="goodsinfo?goods_id=${goods.goods_id}">
																		${goods.goods_name}
																	</a>
																	<div class="carStyleNew">
																		<div class="q" style="position: relative;">
																			<span class="ev_t_product_list_price proPrice">
																				<font class="newPrice">￥${goods.goods_price}元</font>
																			</span>
																		</div>
																		<div style="display: flex; align-items: center; justify-content: space-between;">
																			<div style="flex: 1; display: flex; flex-flow: column; width: 100%;">
																			</div>
																		</div>
																		<a class="list_shopping_img prolist-new-addpro" href="goodsinfo?goods_id=${goods.goods_id}" data-feature="0" data-is_join="0" data-is_spec="" data-small="1" data-pid="15872449" style="bottom: 10px;"> 
																			<img src="images/shopping_icon.png">
																		</a>
																	</div>
																</div>
															</div>
														</div>
													</li>
												</c:forEach>
											</ol>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="specHtml"></div>
		<script src="js/wap/wap_module_data.js"></script>
		<script src="plugins/wap/swiper/swiper-4.3.3.min.js"></script>
		<script type="text/javascript" src="plugins/wap/js/swipe.min.js"></script>
		<script type="text/javascript" src="plugins/public/js/slidingVerification/sliding_tn_code.js"></script>
		<script type="text/javascript" src="js/wap/ajax_info.js"></script>
		<script src="js/md5.js"></script>
		<script type="text/javascript" src="js/wap/public.js"></script>

		<!--change_top_tpl-->
		<script type="text/javascript" src="js/wap/new_wap_public.js"></script>
		<script type="text/javascript" src="js/wap/wapShare.js"></script>
		<script type="text/javascript" src="js/wap/pro_json.js"></script>

		<script src="js/wap/addProToShopCar.js" type="text/javascript"></script>
		<!--文章详细页不显示底部-->
		<div class="toolMenuBg" id="tool_menu_bg"></div>
		<div class="toolMenu" id="tool_menu">
			<menu class="toolBut q ">
				<li id="toolHome" sorts="13" style="width: 25%;">
					<a id="index_link" href="mainindex"> 
						<b class="icon" id="icon_408593"> 
							<img src="images/16164581_1570612051.png" width="20" height="20">
						</b> <strong>首页</strong>
					</a>
				</li>
				<li id="toolProClass" sorts="12" style="width: 25%;">
					<a href="goodstype.jsp"> 
						<b class="icon" id="icon_408600"> 
							<img src="images/16164630_1570612096.png" width="20" height="20">
						</b> <strong>分类</strong>
					</a>
				</li>
				<li id="toolShoppingCar" sorts="11" style="width: 25%;">
					<a href="frontcart"> 
						<b class="icon" id="icon_408596"> 
							<img src="images/16164614_1570612083.png" width="20" height="20">
						</b> <strong>购物</strong>
					</a>
				</li>
				<li id="toolMember" sorts="10" style="width: 25%;">
					<a href="frontuser"> 
						<b class="icon" id="icon_408594"> 
							<img src="images/16164595_1570612069.png" width="20" height="20">
						</b> <strong>我的</strong>
					</a>
				</li>
			</menu>
		</div>
	</div>
	<script>
	$(function(){
		newMenu();
			$(window).size(function(){
			newMenu();
		})
	})
	</script>
</body>
</html>