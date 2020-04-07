<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>商品搜索</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />
<meta id="viewport" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,target-densitydpi=medium" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style"
	content="black-translucent" />
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
        var user_name = "new131";
    var aGlobalBannerHeight = {};
    var is_bianji       = parseInt("0");
    var wap_zz_userid   = "";
    var wap_is_app      = parseInt("0");
    var wap_is_ios      = parseInt("0");
    var wap_userid      = "1715812";
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
<link type="text/css" rel="stylesheet" id="webSkinCss" href="templates/wapother11/css/webskin.css" />
<link type="text/css" rel="stylesheet" href="templates/wapother11/skin_11/style.css" />
<!--change_top_tpl-->
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
<link type="text/css" rel="stylesheet" href="css/wap/huiyuan.css" />
<link rel="stylesheet" type="text/css" href="css/wap/searchStyle.css">

<!-- <script type="text/javascript" src="js/wap/addShopCarList.js"></script> -->

<script type="text/javascript" src=""></script>
<style type="text/css">
.shopInfo .shopImg {
	float: right;
	width: 20px;
	height: 20px;
	line-height: 38px;
}

.shopInfo .shopImg img {
	width: 100%;
}

.shopNum {
	color: #999;
	font-size: 12px;
}
</style>
</head>
<script type="text/javascript">
	var user_name = "new131";
</script>
<body>
	<div class="main searchInfo wrapper">
		<div class="searchTit">
			<form name="search_form" action="search?type=search" method="post" id="search_form">
				<a href="javascript:history.go(-1)" class="returnUrl"></a> 
				<span class="searchText"> 
					<input type="text" id="searchvalue" name="searchvalue" placeholder="请输入搜索内容" value="">
					<a href="###" class="clearText" id="clearUrl"></a>
				</span> 				
				<a href="###" class="clearUrl" id="subBtn"><img src="images/search2.png"
												width="30" height="30"></a>

				<!-- <a href="###" class="clearUrl" id="subBtn">&#25628;&#32034;</a> -->
			</form>
		</div>
		
		<div class="searchC noPadding removeC">
			<c:if test="${searchresult==null}">
				<div class="imgList3">
					<dl>
						<dd style="text-align: center; margin: 20px;">
							<p style="padding: 10px 40px;">
								<img src="images/no_results.png" width="150">
							</p>
							<p style="font-size: 16px;">未找到相关内容</p>
						</dd>
					</dl>
				</div>
			</c:if>
			
			<c:if test="${searchresult==0}">
				<div class="imgList3">
					<dl>
						<dd style="text-align: center; margin: 20px;">
							<p style="padding: 10px 40px;">
								<img src="images/no_results.png" width="150">
							</p>
							<p style="font-size: 16px;">未找到相关内容</p>
						</dd>
					</dl>
				</div>
			</c:if>
			
			<c:if test="${searchresult==1}">
				<div visible="show" rel="r_layout_1" lock="lock" changes="0" id="row_15" class="customModuleRow ">
						<div class="customModule  load-animate" data-animate-name="fadeInUp" data-animate-duration="1.00s" data-animate-delay="0.10s">
							<div class="Mo " id="Mo_15" motype='6'>
								<table class="MoT">
									<tbody>
										<tr>
											<td class="MoTL"></td>
											<td class="MoTM"></td>
											<td class="MoTR"></td>
										</tr>
									</tbody>
								</table>
								<table class="MoBody">
									<tbody>
										<tr>
											<td class="MoBodyL"></td>
											<td class="MoBodyM">
												<div class="MoBodyC">
													<div class=" proListmodule_1 " id="prolist_10313362">
														<ul class="q">
															<c:forEach varStatus="i" var="goods" items="${goodslist}">
																<li class="list_setup">
																	<div class="pic" style="width: 150px; height: 85px;">
																		<i class="hook"></i>
																		<a href="goodsinfo?goods_id=${goods.goods_id}">
																			<img class="lazy-loading" src="${goods.goods_images}" />
																		</a>
																	</div>
																	<div class="proAttr" style="margin-top:15px;">
																		<h3>
																			<a href="goodsinfo?goods_id=${goods.goods_id}" class="proName urlfont">
																				${goods.goods_name}
																			</a>
																		</h3>
																		<h3>
																			<a href="goodsinfo?goods_id=${goods.goods_id}" class="proName urlfont" style="color:#f83131;">
																				￥：${goods.goods_price}
																			</a>
																		</h3>
																		<a href="goodsinfo?goods_id=${goods.goods_id}">
																			<p class="btn_position">
																				<em class="eButObj">了解详情</em>
																			</p>
																		</a>
																	</div>
																</li>
															</c:forEach>
														</ul>
													</div>
												</div>
											</td>
											<td class="MoBodyR"></td>
										</tr>
									</tbody>
								</table>
								<table class="MoB">
									<tbody>
										<tr>
											<td class="MoBL"></td>
											<td class="MoBM"></td>
											<td class="MoBR"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
			</c:if>
		</div>
	</div>
	<!--文章详细页不显示底部-->
	
	
	<div class="toolMenuBg" id="tool_menu_bg"></div>
		<div class="toolMenu" id="tool_menu">
			<menu class="toolBut q ">
				<li id="toolHome" cur="" sorts="13" style="width: 25%;">
					<a id="index_link" class="cur" href="mainindex">
						<b class="icon" id="icon_408593"> 
							<img src="images/16164734_1570612216.png" width="20" height="20">
						</b> 
						<strong>首页</strong>
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
						</b> 
						<strong>购物车</strong>
					</a>
				</li>
				<li id="toolMember" sorts="10" style="width: 25%;">
					<a href="frontuser"> 
						<b class="icon" id="icon_408594"> 
							<img src="images/16164595_1570612069.png" width="20" height="20">
						</b> 
						<strong>我的</strong>
					</a>
				</li>
			</menu>
		</div>
		<div class="Nzz" id="Nzz"></div>
		<script language="javascript">
			var windowW = $(window).width(),windowH = $(window).height();
			$(window).resize(function(){
			setTimeout(function(){
			ButGroupLeftPosition();
			},500);
			})
			$(function(){
			ButGroupLeftPosition();
			});
		</script>
	</div>
	<script>
		$(function(){
			newMenu();
			$(window).size(function(){
			newMenu();
			})
		})
	</script>
	
	
	
	<script src="/js/site_stats.js" id="SiteStats" data-val="1"></script>
	<!--统计-->
	
	<img id="wapCountImg" src=""
		style="width: 0; height: 0; display: block;">
	<img id="countTimeImg" src=""
		style="width: 0; height: 0; display: block;">
	<script type="text/javascript">
	function res_location(url){
		window.location.href=url;
	}
		$(function(){
		$('#keyword').keyup(function(){
			var val=$.trim($(this).val());
			if(val){
				$('#clearUrl').show();
			}else{
				$('#clearUrl').hide();
			}
		})
		//提交搜素
		$('#subBtn').click(function(){
			var kw=$.trim($('#keyword').val());
			var defkw='请输入搜索内容';
			kw=kw ? kw :defkw;
			if(kw){
				$('#keyword').val(kw);
				$('#search_form').submit();
			}
		})
		/*历史搜索*/
		//取消
		$('#clearUrl').click(function(){
			var str='';
			str=str ? str :'';
			$('#keyword').val('');
			$('#keyword').attr('placeholder',str);
			$('#historyDiv').show();
			$('#hotDiv').show();
			$(this).hide();
			$('.removeC').remove();
		})

		//加载更多
		$(document).scroll(function(){
			var scrollTop = $(this).scrollTop(),
				scrollHeight = $(document).height(),
				windowHeight = $(window).height();
			if (scrollHeight - windowHeight -40 <= scrollTop) {
				$("#listMore a").trigger('click');
				//$('#listMore').remove();
			}
		})	
	})
</script>
</body>
</html>