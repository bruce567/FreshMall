<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>待收货订单页面</title>
<meta id="viewport" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,target-densitydpi=medium"/>
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
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no ,target-densitydpi=medium, viewport-fit=cover" name="viewport" id="viewport"/>
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
<link type="text/css" rel="stylesheet" href="css/wap/new/index.css" >
<script type="text/javascript" src="js/wap/wapShare.js"></script>
<script type="text/javascript" src="js/wap/doc_json.js"></script>                                        
<link type="text/css" rel="stylesheet" href="css/wap/icomoon_style.css" />
<!-- 图标文字 -->
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfont.css">
<link rel="stylesheet" type="text/css" href="css/tubiao/iconfontNew.css">
<!-- end -->
<link type="text/css" rel="stylesheet" href="images/wap/web_style/base_module_style.min.css" />
<link type="text/css" rel="stylesheet" href="wap/include/user_define_css.css" />
<link href="css/wap/userCenter.css" rel="stylesheet" type="text/css" />
<link href="css/wap/iconfont_new/iconfont.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function buyDelete(buyId) {
		if (confirm("确定要取消该订单吗?")) {
			$.post(
				"buydelete",
				{
					buyId : buyId
				},
				function(result) {
					var result = eval('(' + result + ')');
					if (result.error) {
						alert(result.error);
					} else {
						alert("取消成功！");
						window.location.href = "frontuserorder";
					}
			});
		}
	}
	function buyshouhuo(buyId) {
		if (confirm("确定要确认收货吗?")) {
			$.post(
				"buyshouhuo",
				{
					buyId : buyId
				},
				function(result) {
					var result = eval('(' + result + ')');
					if (result.error) {
						alert(result.error);
					} else {
						alert("已确认收货，去评价吧！");
						window.location.href = "frontuserorder";
					}
			});
		}
	}
</script>
</head>

<body>
	    <div class="public_frame">
        <div class="frame_min">
            <div class="public_tit" style="height:45px;">
                <div style="float:left;margin-left:15px;margin-top:12px;">
	                <a href="frontuser" class="Return1">
						<img src="images/Return3.png" alt="" width="40" height="25"/>
					</a>
				</div>
				<div style="float:left">
                	<span style="font-size:15px;">待收货订单</span>
                </div>
            </div>
            <div class="public_bg"><p></p></div>
            <div class="public_div">
            	<c:forEach varStatus="i" var="buy" items="${buylist}">
                	<div class="address_list_div">
		              <span>
		                  <em>订单编号</em>
		                    <strong>${buy.buy_sn}</strong>
		                </span>
		                <p>订单内容:${buy.buy_content}</p>
		                <p>下单时间:${buy.buy_addtime}</p>
		                <p>订单价格:${buy.buy_price}元</p>
		                <p>订单留言:${buy.buy_message}</p>
		                <p>订单地址:${buy.buy_address}</p>
		                <c:if test="${buy.buy_status==1}">
							<p>订单状态：未支付</p>
						</c:if>
						<c:if test="${buy.buy_status==2}">
							<p>订单状态：等待发货</p>
						</c:if>
						<c:if test="${buy.buy_status==3}">
							<p style="color:#ff00ff">订单状态：等待确认收货</p>
						</c:if>
						<c:if test="${buy.buy_status==4}">
							<p>订单状态：待评价</p>
						</c:if>
						<c:if test="${buy.buy_status==5}">
							<p>订单状态：已完成</p>
						</c:if>
		                <div class="address_list_bottom">
		                  <!-- 未发货可以取消订单 -->
		                  <c:if test="${buy.buy_status==2}">
		                  	<a onclick="buyDelete('${buy.buy_id}')" class="addredd_a2 del">
		                      <i class="iconfont icon-iconfontshanchu"></i>
		                        <font>取消</font>
		                    </a>
		                  </c:if>
		                  <!-- 已发货可以确认收货 -->
		                  
		                  <c:if test="${buy.buy_status==3}">
		                  	<button onclick="buyshouhuo('${buy.buy_id}')" class="addredd_a2 del"  style="background-color:#ff7f50;width:90px;height:28px;border:0px;border-radius:6px;">
		                      <i class="iconfont icon-iconfontshanchu"></i>
		                        <a style="color:#FFFFFF;font-size:16px;border-radius:10px;">确认收货</a>
		                    </button>
		                  </c:if>
		                  
		                  <%-- <c:if test="${buy.buy_status==3}">
		                  	<a onclick="buyshouhuo('${buy.buy_id}')" class="addredd_a2 del">
		                      <i class="iconfont icon-iconfontshanchu"></i>
		                        <font>确认收货</font>
		                    </a>
		                  </c:if> --%>
		                  
		                  <!-- 确认收货后可以评价 -->
		                  <c:if test="${buy.buy_status==4}">
		                  	<a href="frontuserevaluate?buy_id=${buy.buy_id}&goods_id=${buy.goods_id}" class="addredd_a2 del">
		                      <i class="iconfont icon-iconfontshanchu"></i>
		                        <font>评价</font>
		                    </a>
		                  </c:if>
		                </div>
		            </div>
		          </c:forEach>
            </div>
            <div class="no_div"></div>
        </div>
    </div>
<img id="wapCountImg" src="" style="width: 0;height: 0; display: block;">
<img id="countTimeImg" src="" style="width: 0;height: 0; display: block;">
</body>
</html>
