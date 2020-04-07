<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>个人中心</title>
<meta id="viewport" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,target-densitydpi=medium" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
<meta content="telephone=no" name="format-detection" />
<meta content="email=no" name="format-detection" />
<link type="text/css" rel="stylesheet" href="css/wap/base.css" />
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
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no ,target-densitydpi=medium, viewport-fit=cover"
	name="viewport" id="viewport" />
<meta name="applicable-device" content="mobile" />

<script type="text/javascript">
	var user_name = "zmnew380";
	var aGlobalBannerHeight = {};
	var is_bianji = parseInt("0");
	var wap_zz_userid = "";
	var wap_is_app = parseInt("0");
	var wap_is_ios = parseInt("0");
	var wap_userid = "1946715";
	var css_channel_id = '2';
	var channel_type = parseInt('1002');
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
<!--  -->
<link type="text/css" rel="stylesheet" href="plugins/wap/swiper/swiper-4.3.3.min.css" />
<link type="text/css" rel="stylesheet" href="plugins/public/js/slidingVerification/sliding_verification_style.css" />

<link type="text/css" rel="stylesheet" href="css/wap/web_frame.css" />
<link type="text/css" rel="stylesheet" href="css/wap/wxShareAlert.css" />
<link type="text/css" rel="stylesheet" id="webSkinCss" href="templates/wapother11/css/webskin.css" />
<link type="text/css" rel="stylesheet" href="templates/wapother11/skin_11/style.css" />
<!--change_top_tpl-->
<link type="text/css" rel="stylesheet" href="css/wap/new/index.css">

<link type="text/css" rel="stylesheet" href="css/wap/icomoon_style.css" />
<!-- 图标文字 -->
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfont.css">
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfontNew.css">
<!-- end -->
<link type="text/css" rel="stylesheet" href="images/wap/web_style/base_module_style.min.css" />
<link type="text/css" rel="stylesheet" href="wap/include/user_define_css.css" />
<link type="text/css" rel="stylesheet" href="css/wap/huiyuan.css" />
<link type="text/css" rel="stylesheet" href="css/wap/web_userCenter.css" />
<link href="css/wap/iconfont_new/iconfont.css" rel="stylesheet" type="text/css" />
<link href="css/VNew/animate.min.css" rel="stylesheet" type="text/css" />
<link href="css/wap/huiyuan3.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/wap/usercenter/index_js.js"></script>
<style>
a:hover {
	text-decoration: none;
}

.from_div {
	position: absolute;
	top: 16%;
	left: 6%;
	width: 217px;
}

.from_div .photo {
	float: left;
	top: 2%
}

.name_img {
	display: block;
	margin-right: 20px;
	height: 35px;
	background: url(images/shengqing.png) no-repeat left center;
	background-size: 28%;
	float: left
}

.name_img1 {
	display: block;
	margin-right: 20px;
	height: 35px;
	background: url(images/shengqing.png) no-repeat left center;
	background-size: 22%;
	float: left
}

.name_img2 {
	display: block;
	margin-right: 20px;
	height: 35px;
	background: url(images/chakan.png) no-repeat left center;
	background-size: 24%;
	float: left
}

.name_img a, .name_img1 a, .name_img2 a {
	display: block;
	line-height: 38px;
	margin-left: 20px;
}

#wap_out {
	position: relative;
}

.loginexit a {
	color: #fff;
}

.memberCenter .shengji_vip {
	display: block;
	margin: 15px;
	border-radius: 5px;
	font-size: 16px;
	color: #FFF;
	text-align: center;
	padding: 15px 0;
	background-color: #ff6600;
}

.vipcard_a:hover {
	text-decoration: none;
}

.info_img_s {
	position: absolute;
	width: 18px;
	height: 18px;
	line-height: 18px;
	border: 1px solid #fff;
	text-decoration: none;
	background-color: #f00;
	right: -9px;
	top: -12px;
	border-radius: 20px;
	font-size: 13px;
	color: #FFF;
	text-align: center;
}

.mar_px span, .mar_px em {
	margin: 13px 0;
}

.afficheModule {
	background: #fff;
	margin-bottom: 1px;
}

.afficheModule .afficheDiv li {
	white-space: initial;
}

.new_head_info {
	padding: 15px 10px;
	position: relative;
	overflow: hidden;
}

.new_head_info a {
	float: left;
	display: block;
	width: 25px;
	height: 25px;
	overflow: hidden;
}

.new_head_info a img {
	width: 100%;
}

.new_head_info p {
	display: block;
	width: 5px;
	height: 5px;
	background-color: red;
	border-radius: 50%;
	overflow: hidden;
	position: absolute;
	top: 15px;
	left: 30px;
}

.new_head_info a:last-child {
	float: right;
}

.new_head_con, .new_head_con1 {
	padding: 0 10px;
	overflow: hidden
}

.new_head_L, .new_head_L1 {
	float: left;
	margin-right: 10px;
}

.new_head_L span {
	display: block;
	width: 60px;
	height: 60px;
	overflow: hidden;
	border-radius: 50%;
	border: 1px solid #FFF;
	float: left;
	margin-right: 10px;
}

.new_head_L span img {
	width: 100%;
}

.new_head_L p {
	float: left;
}

.new_head_L p em {
	display: block;
	font-size: 14px;
	color: #FFF;
	padding: 10px 0px 5px 0px;
}

.new_head_L p strong {
	display: block;
	font-size: 12px;
	color: #FFF;
}

.new_head_con a {
	display: block;
	margin-top: 15px;
	color: #FFF;
	font-size: 14px;
	border-radius: 25px;
	border: 1px solid #FFF;
	overflow: hidden;
	text-align: center;
	padding: 5px 0;
}

.tongzhi {
	background-color: #fff6d9;
	overflow: hidden;
	padding: 10px;
	height: 18px;
}

.tongzhi em {
	display: block;
	width: 20px;
	height: 18px;
	float: left;
	margin-right: 10px;
}

.tongzhi em img {
	width: 100%;
}

.tongzhi strong {
	display: block;
	overflow: hidden;
	font-size: 12px;
	color: #555555;
	line-height: 18px;
	margin-bottom: 10px;
}

.tongzhi ul li {
	display: block;
	overflow: hidden;
	font-size: 12px;
	color: #555555;
	line-height: 18px;
	margin-bottom: 10px;
}

.new_info_tit {
	padding: 5px 10px;
	font-size: 14px;
	color: #333;
}

.bor_div1 {
	border-top: 1px solid #e8e8e8;
	border-bottom: 1px solid #e8e8e8
}

.wap_list_t:last-child {
	border-bottom: 0;
}

.new_head_con1 {
	padding-right: 0;
}

.new_head_L1 span {
	display: block;
	float: left;
	width: 60px;
	height: 60px;
	margin-right: 10px;
	position: relative;
}

.new_head_L1 span em {
	display: block;
	border: 1px solid #FFF;
	width: 58px;
	height: 58px;
	border-radius: 50%;
	overflow: hidden;
}

.new_head_L1 span em img {
	width: 100%;
}

.new_head_L1 span a {
	display: block;
	width: 23px;
	height: 23px;
	overflow: hidden;
	border-radius: 50%;
	position: absolute;
	right: 0;
	bottom: 0;
}

.new_head_L1 span a img {
	width: 100%;
}

.ok_logo {
	float: left;
}

.ok_logo_p {
	display: block;
	font-size: 14px;
	color: #FFF;
	padding: 10px 0px 5px 0px;
}

.ok_logo_vip {
	width: 100%;
}

.ok_logo_vip p {
	background-color: #FFF;
	border-radius: 25px;
	padding: 2px;
	display: inline-block;
	overflow: hidden;
	float: left;
}

.ok_logo_vip p em {
	display: block;
	width: 20px;
	height: 20px;
	overflow: hidden;
	border-radius: 50%;
	float: left;
}

.ok_logo_vip p em img {
	width: 100%;
}

.ok_logo_vip p strong {
	display: block;
	line-height: 20px;
	font-size: 14px;
	color: #489fef;
	float: left;
	padding: 0 4px;
}

.ok_logo_vip label {
	float: left;
	margin-left: 10px;
	width: 20px;
	height: 20px;
	display: block;
}

.ok_logo_vip label img {
	width: 100%;
}

.qiandao {
	display: inline-block;
	float: right;
	background: #056ecc;
	padding: 5px 12px;
	border-radius: 25px 0px 0px 25px;
	font-size: 14px;
	color: #FFF;
}

.userC {
	background-color: transparent;
}
</style>
<script>
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
	var home_index = 0;
	var city_setInfo_json = {};
	var formUploadFile = parseInt('');
	var wapContainerJson = {};
	function reset_img_url(url, id) {
		if (id && url) {
			console.log($('#' + id).html());
			$('#' + id).find('.FreeImg_max img').attr('src', url);
		}
	}
	$(function() {
		$("#card_front").click(function() {
			$(this).hide();
			$("#card_back").show();
		});
		$("#card_back").click(function() {
			$(this).hide();
			$("#card_front").show();
		});
		var span_length = $(".wap_list_c1 span").length;
		var span_w = 100 / span_length;
		$(".wap_list_c1 span").width(span_w + '%');

		var property_span_length = $('#my_property').children('span').length;
		for (var i = 1; i < property_span_length; i++) {
			if (i % 4 == 0)
				continue;
			$("#my_property").find("span").eq(i - 1).after("<em></em>");
		}
	});

	// 上下滚动
	function AutoScroll(obj) {
		$(obj).find("ul:first").animate({
			marginTop : "-30px"
		}, 500, function() {
			$(this).css({
				marginTop : "0px"
			}).find("li:first").appendTo(this);
		});
	}
	$(document).ready(function() {
		var myar = setInterval('AutoScroll("#affiche_scroll")', 3000);
		$("#affiche_scroll").hover(function() {
			clearInterval(myar);
		}, function() {
			myar = setInterval('AutoScroll("#affiche_scroll")', 3000)
		}); //当鼠标放上去的时候，滚动停止，鼠标离开的时候滚动开始  
	});
</script>
<!-- <script src="/js/wap/swiper-4.3.3.min.js"></script> -->
<script src="js/wap/wap_module_data.js"></script>
</head>
<body data-ver="1">
	<div class="wrapper1" id="wrapper">
		<div class="mainContainer1">
			<link type="text/css" rel="stylesheet" href="css/wap/new_wap_userCenter.css" />
			<style type="text/css">
				.wap_list {
					margin-bottom: 0;
				}
				
				.wap_list_t:last-child {
					border-bottom: 1px solid #EDEDED;
				}
			</style>
			<div class="memberCenter">
				<div class="con" style="padding: 0;">
					<div class="memberInfo" style="padding: 0;">
						<!-- 修改 -->
						<div class="addContainer q" id="add_container">
							<div visible="" rel="r_layout_1" lock="lock" changes="0" class="customModuleRow" data-channelid="2" data-type="1002" data-show="s6" id="userCenter_2">
								<div class="customModule">
									<div class="Mo userC" motype="s6" id="userCenter_2">
										<div class="Index_head">
											<div class="Index_head_bg" dddd>
												<img src="images/head_bg.png" alt="" />
											</div>
											<div class="Index_head_newbg">
												<img src="images/head_bgnew.png" alt="" />
											</div>
											<div class="Index_head_C">
												<div >
													<a href="javascript:history.go(-1);" class="Return">
														<img src="images/Return3.png" alt="" width="40" height="25" style="margin-left:12px"/>
													</a>
													<a href="frontshop?shop_id=3" class="Home">
														<img src="images/home3.png" width="40" height="25" style="margin-left:240px"/>
													</a>
												</div>
												<div class="Index_head_user">
													<div class="Index_head_img">
														<a>
															<em style="text-align: center; font-size: 1.12rem; color: #fff; line-height: 1.12rem;">
																<img src="images/user_photo.png" width="55px;" style="margin-left:2px;"/>
															</em>
														</a>
													</div>
													<div class="user_name">
														<em style="font-size:16px">用户的名称：${user.adminuser_username}</em>
													</div>
													<div class="ordinary" style="font-size:14px">用户手机号：${user.adminuser_iphone}</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div visible="" rel="r_layout_1" lock="lock" changes="0" class="customModuleRow" data-channelid="2" data-type="1002" data-show="s7" id="userCenter_2">
								<div class="customModule">
									<div class="Mo userC" motype="s7" id="userCenter_2">
										<div class="my_order">
											<a href="frontuserorder" class="my_order_t"> 
												<span>
													<img src="images/icon4.png" alt="" />
												</span>
												<p>我的订单</p>
												<strong>
													<img src="images/link.png" alt="" />
												</strong>
											</a>
											<div class="my_order_c">
												<a href="frontuserorderwait" style="width: 32.7%">
													<p>
														<img src="images/order_img4.png" alt="" />
													</p> 
													<span>待发货</span>
												</a>
												<a href="frontuserordershouhuo" style="width: 32.7%">
													<p>
														<img src="images/order_img5.png" alt="" />
													</p> 
													<span>待收货</span>
												</a>
												<a href="frontuserorderpingjia" style="width: 32.7%">
													<p>
														<img src="images/order_img7.png" alt="" />
													</p> 
													<span>评价</span>
												</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div visible="" rel="r_layout_1" lock="lock" changes="0" class="customModuleRow" data-channelid="2" data-type="1002" data-show="s9" id="userCenter_2">
								<div class="customModule">
									<div class="Mo userC" motype="s9" id="userCenter_2">
										<div class="my_order">
											<a href="frontuserinfo" class="my_data"> 
												<span>
													<img src="images/data_img7.png" alt="" />
												</span>
												<p>我的资料</p> 
												<strong>
													<img src="images/link.png" alt="" />
												</strong>
											</a> 
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="wap_out">
							<div class="out">
								<a href="frontlogout" style="border-radius:10px;font-size:20px;">退&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 手机号绑定(编辑模式不显示) -->
		</div>
	</div>

	<script>
		function relF() {
			window.location.href = '';
		}
		$(function() {

			$(".Index_head_bg img").attr('src',
					'images/user_center_bg.jpg');

			if ($(".Index_head .info_div a").length == 2) {
				$(".Index_head .info_div a").css('width', '49%');
			}
		})
	</script>
	<script src="plugins/wap/swiper/swiper-4.3.3.min.js"></script>
	<script type="text/javascript" src="plugins/wap/js/swipe.min.js"></script>

	<script type="text/javascript" src="plugins/public/js/slidingVerification/sliding_tn_code.js"></script>
	<script type="text/javascript" src="js/wap/ajax_info.js"></script>
	<script src="js/md5.js"></script>
	<script type="text/javascript" src="js/wap/public.js"></script>
	<!--change_top_tpl-->
	<script type="text/javascript" src="js/wap/new_wap_public.js"></script>
	<script type="text/javascript" src="js/wap/wapShare.js"></script>
	<script type="text/javascript" src="js/wap/doc_json.js"></script>

	<!-- 移动到index_min.tpl -->
	<!--  -->
	<!--文章详细页不显示底部-->
	<div class="toolMenuBg" id="tool_menu_bg"></div>
	<div class="toolMenu" id="tool_menu">
		<menu class="toolBut q ">
			<li id="toolHome" sorts="13" style="width: 25%;">
				<a id="index_link" href="mainindex"> 
					<b class="icon" id="icon_408593"> 
						<img src="images/16164581_1570612051.png" width="20" height="20" />
					</b> <strong>首页</strong>
				</a>
			</li>
			<li id="toolProClass" sorts="12" style="width: 25%;">
				<a href="goodstype.jsp"> 
					<b class="icon" id="icon_408600"> 
						<img src="images/16164630_1570612096.png" width="20" height="20" />
					</b> <strong>分类</strong>
				</a>
			</li>
			<li id="toolShoppingCar" sorts="11" style="width: 25%;">
				<a href="frontcart"> 
					<b class="icon" id="icon_408596"> 
						<img src="images/16164614_1570612083.png" width="20" height="20" />
					</b> <strong>购物</strong>
				</a>
			</li>
			<li id="toolMember" cur sorts="10" style="width: 25%;">
				<a href="frontuser" class="cur">
					<b class="icon" id="icon_408594">
						<img src="images/16164766_1570612263.png" width="20" height="20" />
					</b> <strong>我的</strong>
				</a>
			</li>
		</menu>
	</div>
</body>
</html>
