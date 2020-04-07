<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html data-dpr="1" style="font-size: 102.4px;">
<head>
<meta charset="gbk">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
<title>商品分类页面</title>
<link rel="stylesheet" type="text/css" href="css/wap/classify_style3_animate.css">
<link rel="stylesheet" type="text/css" href="css/wap/classify_style3_index.css">
<script src="js/classify_style3_jquery.min.js"></script>
<script type="text/javascript" src="js/classify_style3_fontsize.js"></script>
<script type="text/javascript" src="js/classify_style3_flexible.js"></script>
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
<!--change_top_tpl-->
<script type="text/javascript" src="js/wap/new_wap_public.js"></script>
<link type="text/css" rel="stylesheet" href="css/wap/new/index.css">
<script type="text/javascript" src="js/wap/wapShare.js"></script>
<script type="text/javascript" src="js/wap/doc_json.js"></script>
<link type="text/css" rel="stylesheet" href="css/wap/icomoon_style.css">
<!-- 图标文字 -->
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfont.css">
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfontNew.css">
<!-- end -->
<link type="text/css" rel="stylesheet" href="images/wap/web_style/base_module_style.min.css">
<link type="text/css" rel="stylesheet" href="wap/include/user_define_css.css">
<script type="text/javascript">
	$(function(){
		ajax_bigclass_list('5333293');
		$('.wrapper').navbarscroll();
	    // 分类切换
	    $(".classify-index").click(function(){
		    $(this).addClass("on this_font_color").siblings().removeClass("on this_font_color");
		    // $(this).css("color",'#00a2ff').siblings().css("color",'#333');
		    $('#list_tag').val($(this).attr('alt'));
		    $(".tab-list").hide().eq($(this).index()).show();
	  	});
	});
	//频道获取分类
	function get_big_class(cid){
		cid=parseInt(cid);
		if(!isNaN(cid) && cid){
			window.location.href=''+cid;
		}
	}
	
	
	function ajax_bigclass_list(big_id) {
	    var pro_cid = $('input[name=pro_cid]').val(); 
	    $('#sub_more').html('<div style="text-align: center;padding:1rem 0;margin: 42%;"><img src="/images/wap/loading.gif"></div>');
	     $.ajax({
	          url:''+pro_cid+'&style=1&ajax_big_id='+big_id,
	          type:'get',
	          success: function(data){
	              if(data!=''){
	                  $('#sub_more').html(data);
	              } else {
	              	 $('#sub_more').html('<div style="text-align: center;padding:1rem 0;margin: 20%;"><img src="images/no.png" style="width: 1.8rem;height: 1.8rem;"><p style="margin-top:0.2rem;font-size: 0.24rem;color: #999;">您还没有添加任何分类~</p></div>');
	              }
	          }
	      });
	}
	</script>
</head>
<body>
<div>
	<a href="search.jsp"> <img src="images/search2.png" style="margin-left: 20px" width="25px" height="25px">
	</a>

	<a href="frontuser"> 
				<img src="images/person2.png" width="25px" height="25px" style="margin-left:264px">
			</a>
		</div>
	
	<div class="classify-tab">
		<div class="tab-list big_class_list">
			<div class="category" style="margin-top:-110px;">
				<div class="category-left" id="category-left">
					<!-- <div id="category_all" class="category-list" alt="5333293" onclick="OpenSub(this)">
						<a href="goodstype">
							全部<div class="at-line this_color"></div>
						</a>
					</div>
					<div id="category_${goodstype.goodstype_id}" class="category-list at" onclick="OpenSub(this)">
						<a href="goodstype?goodstype_id=${goodstype.goodstype_id}">
							${goodstype.goodstype_name}
							<div class="at-line this_color"></div>
						</a>
					</div>	 -->
				</div>
				<div class="category-right ">
					<div class="category-item show" id="pageCon">
						<!-- <div class="category-li">
							<a href="goodsinfo?goods_id=${goods.goods_id}" style="text-align: center;"> 
								<img src="${goods.goods_images}">
								<div class="goods-names">${goods.goods_name}</div>
							</a>
						</div> -->
					</div>
				</div>
				<script type="text/javascript">
					// 获取小类
					function OpenSub(_this,goodstype_id) {
						get_list(goodstype_id);
					  	var big_id = $(_this).attr('alt');
					  	var old_big_id = $('input[name=old_big_id]').val();
					  	if (big_id !=old_big_id) {
					  		ajax_bigclass_list(big_id);
					  		$(_this).addClass("at").siblings().removeClass("at");
					  		$('input[name=old_big_id]').val(big_id);
					  	}
					}
					function get_list(goodstype_id){
						$.post(
							"goodstype",
							{
								goodstype_id : goodstype_id,
							},
							function(result) {
								var result = eval('(' + result + ')');
								var goodstypelist = result.goodstypelist;//商品类型列表
								var categorycontent = '';
								document.getElementById('category-left').innerHTML='';
								for(var i=0; i<goodstypelist.length; i++){
									if (goodstype_id == 0) {
										if (goodstypelist[i]['goodstype_id'] == 1) {
											categorycontent += '<div id="category_'+goodstypelist[i]['goodstype_id']+'" class="category-list at" onclick="OpenSub(this,'+goodstypelist[i]['goodstype_id']+')">'
											+''+goodstypelist[i]['goodstype_name']+''
											+'<div class="at-line this_color"></div></div>';
										} else {
											categorycontent += '<div id="category_'+goodstypelist[i]['goodstype_id']+'" class="category-list" onclick="OpenSub(this,'+goodstypelist[i]['goodstype_id']+')">'
											+''+goodstypelist[i]['goodstype_name']+''
											+'<div class="at-line this_color"></div></div>';
										}
									} else {
										if (goodstype_id == goodstypelist[i]['goodstype_id']) {
											categorycontent += '<div id="category_'+goodstypelist[i]['goodstype_id']+'" class="category-list at" onclick="OpenSub(this,'+goodstypelist[i]['goodstype_id']+')">'
											+''+goodstypelist[i]['goodstype_name']+''
											+'<div class="at-line this_color"></div></div>';
										} else {
											categorycontent += '<div id="category_'+goodstypelist[i]['goodstype_id']+'" class="category-list" onclick="OpenSub(this,'+goodstypelist[i]['goodstype_id']+')">'
											+''+goodstypelist[i]['goodstype_name']+''
											+'<div class="at-line this_color"></div></div>';
										}
									}
								}
								
								categorycontent += '<div style="margin-bottom: 40px;"></div>';
								
				                $("#category-left").append(categorycontent);
				                
								var goodslist = result.goodslist;//商品列表
								var content = '';
								document.getElementById('pageCon').innerHTML='';
								for(var i=0; i<goodslist.length; i++){
									content += '<div class="category-li">'
											+'<a href="goodsinfo?goods_id='+goodslist[i]['goods_id']+'" style="text-align: center;">'
											+'<img src="'+goodslist[i]['goods_images']+'">'
											+'<div class="goods-names">'+goodslist[i]['goods_name']+'</div>'
											+'</a></div>';
								}
				                $("#pageCon").append(content);
							});
					}
					get_list(0);
				</script>
			</div>
		</div>
	</div>
	<input type="hidden" name="pro_cid" value="21601173">
	<input type="hidden" name="old_big_id" value="5333293">
	<script type="text/javascript" src="js/classify_style3_iscroll.js"></script>
	<script type="text/javascript" src="js/classify_style3_navbarscroll.js"></script>
	<!--文章详细页不显示底部-->
	<div class="toolMenuBg" id="tool_menu_bg"></div>
	<div class="toolMenu" id="tool_menu">
		<menu class="toolBut q ">
			<li id="toolHome" sorts="13" style="width: 25%;">
				<a id="index_link" href="mainindex"> 
					<b class="icon" id="icon_408593"> 
						<img src="images/16164581_1570612051.png" width="20" height="20">
					</b> 
					<strong>首页</strong>
				</a>
			</li>
			<li id="toolProClass" cur="" sorts="12" style="width: 25%;">
				<a class="cur" href="goodstype.jsp">
					<b class="icon" id="icon_408600"> 
						<img src="images/16164754_1570612237.png" width="20" height="20">
					</b> 
					<strong>分类</strong>
				</a>
			</li>
			<li id="toolShoppingCar" sorts="11" style="width: 25%;">
				<a href="frontcart"> 
					<b class="icon" id="icon_408596"> 
						<img src="images/16164614_1570612083.png" width="20" height="20">
					</b> 
					<strong>购物</strong>
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
	<script type="text/javascript">
        $(function(){
             if($(".main").length){
                 $(".main").css("min-height",$(window).height());
             }
        })
    </script>
	<div class="Nzz" id="Nzz"></div>
	<script language="javascript">
    	var windowW = $(window).width(),windowH = $(window).height();
   		$(window).resize(function(){})
    	$(function(){});
    </script>

	<script type="text/javascript">
        $(function(){
            var a_len = $("#login_a").children("a").length;
            if (a_len ==1){
                $(".more_div_a a").css("margin","0 50px");
            }
            if (a_len == 0){
                $(".more_login_div").remove();
            }
        })
    </script>
	<script type="text/javascript">
	</script>
</body>
</html>