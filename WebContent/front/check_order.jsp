<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link type="text/css" rel="stylesheet" href="css/wap/web_shoppingCar.css">
<title>订单结算</title>
<meta id="viewport" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,target-densitydpi=medium">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
<meta content="telephone=no" name="format-detection">
<meta content="email=no" name="format-detection">
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
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no ,target-densitydpi=medium, viewport-fit=cover"
	name="viewport" id="viewport">
<meta name="applicable-device" content="mobile">

<script type="text/javascript">
        var user_name = "zmnew380";
    var aGlobalBannerHeight = {};
    var is_bianji       = parseInt("0");
    var wap_zz_userid   = "";
    var wap_is_app      = parseInt("0");
    var wap_is_ios      = parseInt("0");
    var wap_userid      = "1946715";
    var css_channel_id  = '0';
    var channel_type  = parseInt('');
    var APP_V           = '0';
    var AGENT_ID        = '';
    var IS_NEWS_ARTICEL        = parseInt('0');
    var LANGUAGE_TYPE        = parseInt('0');
    var is_wap_view     = parseInt(0);
    var show_check     = parseInt(0);
            var use_wxchat_map = 0;
    </script>
<script type="text/javascript" src="Language/Zh-cn/Language.js"></script>
<script type="text/javascript" src="plugins/public/js/cookies.js"></script>
<script src="plugins/public/js/jquery-1.7.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="plugins/wap/swiper/swiper-4.3.3.min.css">
<script src="plugins/wap/swiper/swiper-4.3.3.min.js"></script>
<script type="text/javascript" src="plugins/wap/js/swipe.min.js"></script>
<link type="text/css" rel="stylesheet" href="plugins/public/js/slidingVerification/sliding_verification_style.css">
<script type="text/javascript" src="plugins/public/js/slidingVerification/sliding_tn_code.js"></script>
<script type="text/javascript" src="js/wap/ajax_info.js"></script>
<script src="js/md5.js"></script>
<script type="text/javascript" src="js/wap/public.js"></script>
<link type="text/css" rel="stylesheet" href="css/wap/web_frame.css">
<link type="text/css" rel="stylesheet" href="css/wap/wxShareAlert.css">
<link type="text/css" rel="stylesheet" id="webSkinCss" href="templates/wapother11/css/webskin.css">
<link type="text/css" rel="stylesheet" href="templates/wapother11/skin_11/style.css">
<link type="text/css" rel="stylesheet" href="css/wap/icomoon_style.css">
<!-- 图标文字 -->
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfont.css">
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfontNew.css">
<!-- end -->
<link type="text/css" rel="stylesheet" href="images/wap/web_style/base_module_style.min.css">
<link type="text/css" rel="stylesheet" href="wap/include/user_define_css.css">
<link rel="stylesheet" href="css/wap/order_style.css">
<link rel="stylesheet" href="dom/Product/Css/public_style.css">
<link href="css/form_order/css.css" rel="stylesheet" type="text/css">
<link href="css/wap/iconfont_new/iconfont.css" rel="stylesheet" type="text/css">
<link href="weiUI/css/weui.css" rel="stylesheet" type="text/css">
<link href="weiUI/css/jquery-weui.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="js/timepicker/date_plug/lCalendar.css">
<script type="text/javascript" src="js/timepicker/date_plug/lCalendar.min.js"></script>
<style type="text/css">
#div_addre_list, #div_addre_add, #div_addre_edit, #div_payCard,
	#div_redBag, #div_fapiao, #div_paySend, #div_proList, #div_tit {
	display: none;
}

.list_eka label.w_auto {
	max-width: 158px;
	width: auto;
	float: left;
}

.caution {
	color: #f90;
}

.list_payment .list_payment_info li {
	height: auto;
}

.upfile {
	border: 1px solid #ccc;
	float: left;
	margin-top: 5px;
	color: #888;
	padding: 0 10px;
	border-radius: 4px;
	line-height: 20px;
}

.upfile_p {
	clear: both;
}

.upfile_l {
	max-width: 200px;
	height: 20px;
	line-height: 20px;
	float: left;
	margin-left: 8px;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 1;
	overflow: hidden;
	margin-top: 5px;
}
/*表单弹窗*/
.alert_frame_margin {
	max-width: 640px;
	margin: 0 auto;
}

.alert_frame_content {
	background-color: #fff;
	border-radius: 5px;
	height: 168px;
	left: 50%;
	margin: -84px 0 0 -150px;
	overflow: hidden;
	position: fixed;
	top: 50%;
	width: 300px;
	z-index: 3000;
}

.alt_close_frame {
	float: right;
	padding: 10px;
}

.alert_frame_content iframe {
	border: 0;
	width: 100%;
	height: 123px;
	overflow: hidden;
}

.alt_loading {
	background: #fff url('/images/loading.gif') no-repeat center center;
	width: 100%;
	height: 100%;
	position: absolute;
}

.Certificates, .Certificates1 {
	padding: 10px 15px;
	border-top: 1px solid #e8e8e8;
	border-bottom: 1px solid #e8e8e8;
	overflow: hidden;
}

.Certificates input {
	width: 84%;
	float: left;
	border: 1px solid #e8e8e8;
	border-right: 0;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	color: #333;
}

.Certificates a {
	display: block;
	overflow: hidden;
	background-color: #ff9600;
	color: #FFF;
	font-size: 14px;
	line-height: 32px;
	text-align: center;
}

.Certificates1 span {
	display: block;
	width: 73%;
	font-size: 14px;
	color: #555;
	float: left;
	line-height: 30px;
}

.Certificates1 a {
	display: block;
	width: 75px;
	overflow: hidden;
	border: 1px solid #e8e8e8;
	color: #999;
	text-align: center;
	line-height: 28px;
	border-radius: 25px;
	float: right;
}

.WifiDevice {
	overflow: hidden;
	padding: 10px 20px 10px 10px;
	background: #ffffff;
	border-bottom: 1px solid #f9f9f9;
}

.WifiDevice_p {
	display: block;
	float: left;
	font-size: 14px;
	margin-top: 5px;
	margin-right: 10px;
}

.WifiDevice_input {
	overflow: hidden;
	border: 1px solid #e9e9e9;
	display: table;
	border-radius: 4px;
	width: 60%;
}

.WifiDevice_input input {
	width: 97%;
	padding: 5px 1.5%;
	font-size: 14px;
}
</style>
<script type="text/javascript" src="Language/Zh-cn/87/Language.js"></script>
<script>
var user_id = 1946715;
var is_balance=0;
var zz_use_money=0;
var is_jifen=0;
var zz_use_jifen=0;
var is_redBag=0;
</script>
<!-- 新加样式 -->
<link rel="stylesheet" type="text/css" href="css/wap/new_detail_style.css">
</head>

<body>
	<div class="area_margin">
		<div id="all_div">
			<div class="order_tit">
				<a href="javascript:history.go(-1)" class="return_url">
					<span>
						<img src="images/return_tit.png">
					</span>
				</a>
				<h2>确认订单</h2>
			</div>
			<div class="margin_t confirm_order">
					<div class="order_list margin_b">
						<dl class="margin_b">
							<c:forEach varStatus="i" var="cart" items="${cartlist}">
								<dd class="clearfix list_name list_name_main">
									<span class="name_img">
										<img src="${cart.goods_images}">
									</span>
									<span class="name_text"> 
										${cart.goods_name} &nbsp;&nbsp;<br> x${cart.cart_addnum} &nbsp;&nbsp;&nbsp;&nbsp;
									</span> 
									<em class="star_color">￥${cart.cart_price}</em>
								</dd>
							</c:forEach>

							<dd class="clearfix list_Message">
								<input id="buy_message" type="text" name="remarks" maxlength="45" placeholder="给商家留言（选填，45字以内）：" value="">
							</dd>
							
							<dd class="clearfix list_Message">
								<input id="buy_address" type="text" name="remarks" maxlength="45" placeholder="填写收货地址" value="">
							</dd>
							
							<dd class="clearfix list_Message">
								<style>
									.shoppingStatus_changePhone .cur{border:2px solid #72a75a;}
								</style>
								<span data-v-383fd33b="" data-v-71d1a8b7="">支付方式</span>
								<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_changePhone" id="pay_ment" style="margin-top:10px;">
									<em class="cur" data-v-383fd33b="" data-v-71d1a8b7="" style="width:150px;font-size:14px;">支付宝支付
										<input type="radio" name="payment_id" style="display: none;" value="1" checked="checked">
									</em>
									<em data-v-383fd33b="" data-v-71d1a8b7="" style="width:150px;margin-left:20px;font-size:14px;">微信支付
										<input type="radio" name="payment_id" style="display: none;" value="2">
									</em>
									<em data-v-383fd33b="" data-v-71d1a8b7="" style="width:150px;margin-left:20px;font-size:14px;">银行卡支付
										<input type="radio" name="payment_id" style="display: none;" value="3">
									</em>
									<script type="text/javascript">
									    $("#pay_ment em").click(function(){
										    var t = $(this);
										    if(!t.hasClass("cur")){
										        t.addClass("cur").siblings("em").removeClass("cur");
										        var inp = t.find('input');
										        inp.attr('checked','checked');
										    }
										})
									</script>
								</div>
							</dd>
						</dl>
						<ul class="Price_list">
							<li class="sum">需支付：<em class="star_color" id="allMoney1">￥${sumprice}</em></li>
							<input type="hidden" id="sumprice" name="sumprice" value="${sumprice}">
						</ul>
					</div>
					<div class="add_address_btn">
						<input type="hidden" id="cart_id" name="cart_id" value="${cart_id}">
						<a onclick="checkpay();" class="tijao" id="tijao" style="background-color:#00ce97;"> 确认支付 </a>
						<script type="text/javascript">
							//创建订单
							function checkpay() {
								//生成订单
								var buy_message = document.getElementById("buy_message").value;//获取订单留言
								if (buy_message == '') {
									alert("用户留言不能为空!");
								} else {
									var buy_address = document.getElementById("buy_address").value;//获取收货地址
									if (buy_address == '') {
										alert("收货地址不能为空!");
									} else {
										if (confirm("确定要支付该订单吗?")) {
											var cart_id = document.getElementById("cart_id").value;//获取购物车id
											if (cart_id == '') {
												cart_id = 0;
											}
											var sumprice = document.getElementById("sumprice").value;//获取订单价格
											var payment_id = $("input[name='payment_id']:checked").val();
											$.post(
													"createbuy",
													{
														payment_id : payment_id,
														buy_price : sumprice,
														buy_message : buy_message,
														buy_address : buy_address,
														cart_id : cart_id
													},
													function(result) {
														var result = eval('(' + result + ')');
														if (result.result=="fail") {
															alert("下单失败，请确认网络");
														} else if (result.result=="success") {
															alert("订单支付成功");
															window.location.href = "mainindex";
														}
											});
										}
									}
								}
							}
						</script>
					</div>
			</div>
		</div>
	</div>
	<div class="alt_frame" style="display: none;">
		<div class="alert_frame_bg"></div>
		<div class="alert_frame_margin">
			<div class="alert_frame_content">
				<div class="alt_loading" id="alt_loading"></div>
				<div class="alt_close_frame">
					<a href="javascript:;">X</a>
				</div>
				<iframe id="alt_iframe" src=""></iframe>
			</div>
		</div>
	</div>
	<style>
.Real_name_bg {
	position: fixed;
	width: 100%;
	top: 0;
	bottom: 0;
}

.Real_name_bg p {
	display: block;
	position: relative;
	max-width: 640px;
	height: 100%;
	margin: 0 auto;
	left: 0;
	right: 0;
	opacity: 0.5;
	background-color: #000;
}

.Real_name {
	position: fixed;
	width: 100%;
	bottom: 0;
	background-color: #FFF;
}

.Real_name_tit {
	padding: 10px 0px;
	overflow: hidden;
	border-bottom: 1px solid #e8e8e8;
	position: relative;
}

.Real_name_L {
	position: absolute;
	left: 15px;
	top: 10px;
	font-size: 14px;
	color: #ff9900;
}

.Real_name_tit span {
	display: block;
	width: 100%;
	text-align: center;
	font-size: 14px;
	color: #000;
}

.Real_name_R {
	position: absolute;
	right: 15px;
	font-size: 14px;
	color: #ff9900;
	top: 10px;
}

.Real_name_con {
	width: 100%;
}

.Real_name_con p {
	display: block;
	border-bottom: 1px solid #e8e8e8;
	font-size: 14px;
	color: #ff9900;
	padding: 10px 15px;
}

.Real_name_con span {
	display: block;
	border-bottom: 1px solid #e8e8e8;
	font-size: 14px;
	color: #000;
	padding: 10px 15px;
}

.Real_name_con span em {
	display: block;
	float: left;
	width: 65px;
	float: left;
}

.Real_name_con span strong {
	display: block;
	overflow: hidden;
	font-weight: 500;
}
</style>
</body>
</html>