<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"> 
<title>评价</title>	 			
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
<style>
        body,ul,li{
            padding:0;
            margin: 0;
        }
        li{
            list-style: none;
        }
        .rating{
            width: 300px;
            height: 26px;
        }
        .rating-item{
            float: left;
            width:35px;
            height: 50px;
            background: url("images/xing.png") no-repeat ;
            -webkit-background-size:30px 100px;
            overflow: hidden;
        }
    </style>

<script type="text/javascript">
	function formcheckForm(){
	    var flag = false;
	    var buy_sn = document.getElementById('buy_sn').value;
    	if (buy_sn == '') {
    		alert("订单编号不能为空哦！");
    		flag = false;
    	} else {
    		var goods_name = document.getElementById('goods_name').value;
    		if (goods_name == '') {
    			alert("商品名称不能为空哦！");
        		flag = false;
    		} else {
    			var starcount = document.getElementById('starcount').value;
    			if (starcount == '') {
    				alert("评价星级不能为空哦！");
            		flag = false;
    			} else {
    				var goodsevaluate_content = document.getElementById('goodsevaluate_content').value;
    				if (goodsevaluate_content == '') {
    					alert("评价内容不能为空哦！");
                		flag = false;
    				} else {
    					alert("评价成功！");
    			    	flag = true;
    				}
    			}
    		}
    	}
	    return flag;
	}
</script>

<body>

	<div class="wrapper" style="background-color:#ffffff;">
		<div class="wrapper_c">
			<div class="wrapper_bg">
				<p></p>
			</div>
			<div class="max_wrapper_c">
				<div>
					<a href="javascript:history.go(-1);" class="Return1" style="margin-left:5px">
						<img src="images/Return3.png" alt="" width="40" height="25"/>
					</a> 
				<span style="color:#8fbc8f;font-size:13px;margin-left:85px">请不要恶意评价哦~~</span>
				</div>
				<form method="post" action="userevaluatesave" onsubmit="return formcheckForm();">
					<input type="hidden" id="buy_id" name="buy_id" value="${buy.buy_id}">
					<input type="hidden" id="goods_id" name="goods_id" value="${goods.goods_id}">
					<div class="bg_color">
						<div class="forward_input">
							<span>订单编号:</span>
							<p>
								<input readonly='readonly' id="buy_sn" name="buy_sn" type="text" maxlength="64" value="${buy.buy_sn}" readonly="readonly">
							</p>
						</div>
						<div class="forward_input">
							<span>生鲜名称:</span>
							<p>
								<input readonly='readonly' id="goods_name" name="goods_name" type="text" maxlength="64" value="${goods.goods_name}" readonly="readonly">
							</p>
						</div>
						<input type="hidden" id="starcount" name="starcount" value="3">
						<div class="forward_input">
							<span>描述相符:</span>
							<div class="wrap" style=" margin-left:180px;">
								<ul class="rating" id="rating">
							        <li class="rating-item" title="很不好"></li>
							        <li class="rating-item" title="不好"></li>
							        <li class="rating-item" title="一般"></li>
							        <li class="rating-item" title="好"></li>
							        <li class="rating-item" title="很好"></li>
							    </ul>
							</div>
							<script src="js/jquery-2.1.3.min.js"></script>
							<script>
						        var num = 2;//点亮个数
						        $item = $('#rating').find('.rating-item');//获取的所有li
						        //点亮星星函数
						        var dianLiang = function (num) {
						            $item.each(function (index) { //遍历所有li,即所有星星
						                if (index < num){
						                    $(this).css('background-position','0 0') //点亮
						                }else {
						                    $(this).css('background-position','0 -58px') //未点亮
						                }
						            })
						        }
						    //    初始化,默认点亮2颗
						        dianLiang(num)
						    //    绑定事件
						        $item.on('mouseover',function () {
						            dianLiang($(this).index() + 1)
						        }).on('click',function () {
						            dianLiang($(this).index() +1);
						            num = $(this).index() +1
						        })
						        $('#rating').on('mouseout',function () {
						            dianLiang(num)
						            document.getElementById('starcount').value = num;
						        })
						    </script>
						</div>
						
						<!-- <input type="hidden" id="starcount" name="starcount" value="3">
						<div class="forward_input">
							<span>配送服务:</span>
							<div class="wrap" style=" margin-left:180px;">
								<ul class="rating" id="rating">
							        <li class="rating-item" title="很不好"></li>
							        <li class="rating-item" title="不好"></li>
							        <li class="rating-item" title="一般"></li>
							        <li class="rating-item" title="好"></li>
							        <li class="rating-item" title="很好"></li>
							    </ul>
							</div>
							<script src="js/jquery-2.1.3.min.js"></script>
							<script>
						        var num = 2;//点亮个数
						        $item = $('#rating').find('.rating-item');//获取的所有li
						        //点亮星星函数
						        var dianLiang = function (num) {
						            $item.each(function (index) { //遍历所有li,即所有星星
						                if (index < num){
						                    $(this).css('background-position','0 0') //点亮
						                }else {
						                    $(this).css('background-position','0 -58px') //未点亮
						                }
						            })
						        }
						    //    初始化,默认点亮2颗
						        dianLiang(num)
						    //    绑定事件
						        $item.on('mouseover',function () {
						            dianLiang($(this).index() + 1)
						        }).on('click',function () {
						            dianLiang($(this).index() +1);
						            num = $(this).index() +1
						        })
						        $('#rating').on('mouseout',function () {
						            dianLiang(num)
						            document.getElementById('starcount').value = num;
						        })
						    </script>
						</div> -->
						
						<!-- <input type="hidden" id="starcount" name="starcount" value="3">
						<div class="forward_input">
							<span>服务态度:</span>
							<div class="wrap" style=" margin-left:180px;">
								<ul class="rating" id="rating">
							        <li class="rating-item" title="很不好"></li>
							        <li class="rating-item" title="不好"></li>
							        <li class="rating-item" title="一般"></li>
							        <li class="rating-item" title="好"></li>
							        <li class="rating-item" title="很好"></li>
							    </ul>
							</div>
							<script src="js/jquery-2.1.3.min.js"></script>
							<script>
						        var num = 2;//点亮个数
						        $item = $('#rating').find('.rating-item');//获取的所有li
						        //点亮星星函数
						        var dianLiang = function (num) {
						            $item.each(function (index) { //遍历所有li,即所有星星
						                if (index < num){
						                    $(this).css('background-position','0 0') //点亮
						                }else {
						                    $(this).css('background-position','0 -58px') //未点亮
						                }
						            })
						        }
						    //    初始化,默认点亮2颗
						        dianLiang(num)
						    //    绑定事件
						        $item.on('mouseover',function () {
						            dianLiang($(this).index() + 1)
						        }).on('click',function () {
						            dianLiang($(this).index() +1);
						            num = $(this).index() +1
						        })
						        $('#rating').on('mouseout',function () {
						            dianLiang(num)
						            document.getElementById('starcount').value = num;
						        })
						    </script>
						</div> -->
						
						<div class="forward_input">
							<span>评价内容</span>
							<div style="float:right;" align="center">
								<textarea id="goodsevaluate_content" name="goodsevaluate_content" rows="5" cols="40"></textarea>
							</div>
						</div>
						<div class="out" align="center">
							<input type="submit" value="提交评价" style="background-color:#ff7f50;color:#fff;width:300px;height:45px;border:0px;border-radius:6px;">
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
