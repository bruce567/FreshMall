<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>修改我的资料</title>
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
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no ,target-densitydpi=medium, viewport-fit=cover" name="viewport" id="viewport" />
<meta name="applicable-device" content="mobile" />

<script type="text/javascript">
    var user_name = "waimai2";
    var aGlobalBannerHeight = {};
    var is_bianji       = parseInt("0");
    var wap_zz_userid   = "";
    var wap_is_app      = parseInt("0");
    var wap_is_ios      = parseInt("0");
    var wap_userid      = "1659475";
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
<!--  -->
<link type="text/css" rel="stylesheet" href="plugins/wap/swiper/swiper-4.3.3.min.css" />
<script src="plugins/wap/swiper/swiper-4.3.3.min.js"></script>
<script type="text/javascript" src="plugins/wap/js/swipe.min.js"></script>
<link type="text/css" rel="stylesheet" href="plugins/public/js/slidingVerification/sliding_verification_style.css" />
<script type="text/javascript" src="plugins/public/js/slidingVerification/sliding_tn_code.js"></script>
<script type="text/javascript" src="js/wap/ajax_info.js"></script>
<script src="js/md5.js"></script>
<script type="text/javascript" src="js/wap/public.js"></script>
<link type="text/css" rel="stylesheet" href="css/wap/web_frame.css" />
<link type="text/css" rel="stylesheet" href="css/wap/wxShareAlert.css" />
<link type="text/css" rel="stylesheet" id="webSkinCss" href="templates/wapother39/css/webskin.css" />
<link type="text/css" rel="stylesheet" href="templates/wapother39/skin_39/style.css" />
<script type="text/javascript" src="js/wap/new_wap_public.js"></script>
<link type="text/css" rel="stylesheet" href="css/wap/new/index.css">
<script type="text/javascript" src="js/wap/wapShare.js"></script>
<script type="text/javascript" src="js/wap/doc_json.js"></script>
<link type="text/css" rel="stylesheet" href="css/wap/icomoon_style.css" />
<!-- 图标文字 -->
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfont.css">
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfontNew.css">
<!-- end -->
<link type="text/css" rel="stylesheet" href="images/wap/web_style/base_module_style.min.css" />
<link type="text/css" rel="stylesheet" href="wap/include/user_define_css.css" />
<link rel="stylesheet" type="text/css" href="css/wap/jquery.validation.css">
<script type="text/javascript" src="js/wap/form_validation_jquery.validate.js"></script>

<link href="css/wap/huiyuan3.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/wap/usercenter/index_js.js"></script>
<style>
body {
	background-color: initial;
}

.hideinput {
	display: none;
}

#myform {
	background-color: #FFF;
	padding-bottom: 5px;
}

.weui-cell {
	padding: 10px;
}

.weui-cell__hd label {
	width: 90px;
	text-align: right
}

.or_size_div {
	width: 90px;
	text-align: right;
	color: #333;
}

.weui-cells__title {
	color: #333;
}

.ev_empy {
	display: block;
	margin: 0;
}

.weui-cells_form input, .weui-cells_form textarea, .weui-cells_form label[for]
	{
	font-size: 14px;
}
</style>

<script type="text/javascript">
	function formcheckForm(){
	    var flag = false;
	    var user_name = document.getElementById('user_name').value;
    	if (user_name == '') {
    		alert("用户名称不能为空哦！");
    		flag = false;
    	} else {
    		var user_password = document.getElementById('user_password').value;
    		if (user_password == '') {
    			alert("用户密码不能为空哦！");
        		flag = false;
    		} else {
    			alert("修改资料成功！");
		    	flag = true;
    		}
    	}
	    return flag;
	}
</script>

<body>

	<div class="public_frame">
		<div class="min_frame">
			<div>
				<a href="user.jsp">
					<img src="images/Return3.png" width="40px" height="25px" style="margin-left:10px">
				</a> 
			</div>
		</div>
	</div>
	
	<div class="wrapper">
		<div class="wrapper_c">
			<div class="wrapper_bg">
				<p></p>
			</div>
			<div class="max_wrapper_c">
				<div class="settlement_tit">
					<a href="frontuser" class="Return1">
						<img src="images/Return.png" alt="" />
					</a> 
					<span>我的资料</span>
				</div>
				<form method="post" action="userupdateinfo" onsubmit="return formcheckForm();">
					<div class="bg_color">
						<div class="forward_input">
							<font>*</font><span>手机号码</label></span>
							<p>
								<input readonly='readonly' type="text" maxlength="64" value="${user.adminuser_iphone}" placeholder="手机号码">
							</p>
						</div>
						<div class="forward_input">
							<font>*</font><span>用户名</label></span>
							<p>
								<input type="text" id="user_name" name="user_name" value="${user.adminuser_username}" placeholder="请输入姓名">
							</p>
						</div>
						<div class="forward_input">
							<font>*</font><span>密码</label></span>
							<p>
								<input type="text" maxlength="64" id="user_password" name="user_password" value="${user.adminuser_password}" placeholder="请输入密码">
							</p>
						</div>
						<div class="forward_input">
							<font>*</font><span>注册时间</label></span>
							<p>
								<input readonly='readonly' id="user_registertime" name="user_registertime" type="text" maxlength="64" value="${user.adminuser_registertime}" placeholder="注册时间">
							</p>
						</div>
						<div class="out" align="center">
							<input type="submit" value="提交修改" style="background-color:#ff772f;color:#fff;width:300px;height:45px;border:0px;border-radius:10px;">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<style type="text/css">
		.showImg_c {
			position: fixed;
			top: 0;
			left: 0;
			right: 0;
			bottom: 0;
			background: rgba(0, 0, 0, 0.5);
			display: flex;
			align-items: center;
			justify-content: center;
			z-index: 9;
		}
		
		.showImg_c img {
			max-width: 100%;
			max-height: 100%;
		}
	</style>
	<script language="javascript">
    	var windowW = $(window).width(),windowH = $(window).height();
    		$(window).resize(function(){
            })
    		$(function(){
        });

    </script>
</body>
</html>
