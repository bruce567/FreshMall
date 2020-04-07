<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html style="font-size: 100px;">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=0">
<script src="V/static/js/jquery-3.0.0.min.js"></script>
<script src="V/static/layui/layui.js"></script>
<script src="V/static/js/md5.js"></script>
<style>
html, body {
	font-family: '微软雅黑';
	font-size: 10px;
	max-width: 750px;
	margin: 0 auto;
	background: #eee;
}

button {
	-webkit-tap-highlight-color: transparent;
}

body, p, h1, h2, h3, h4, h5, h6, ul, ol, li, a, input, dl, dt, dd, img {
	margin: 0;
	padding: 0;
	font-family: "微软雅黑", "宋体", arial, verdana, sans-serif;
	color: #606060;
	border: none;
}

ol, ul, ol li, ul li {
	/* list-style: none; */
	
}

a {
	text-decoration: none;
}

em, i {
	font-style: normal;
}

/*clearfix*/
.clearfix:after {
	content: ".";
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
}

.clearfix {
	zoom: 1;
}

.hidden {
	display: none;
}

/*让滚动条隐藏*/
body::-webkit-scrollbar {
	width: 0px;
}

button {
	border-color: transparent !important;
	outline: none;
	cursor: pointer;
	padding: 0 !important;
	box-sizing: inherit;
	background-color: transparent;
}

/*更改导航小圆点的样式*/
#fp-nav ul li a.active span, .fp-slidesNav ul li a.active span {
	background: #FA714D !important;
	/*这里设置的是活动导航的颜色*/
	width: 13px;
	height: 13px;
	border-radius: 50%;
}

#fp-nav ul li a span, .fp-slidesNav ul li a span {
	/*这里设置的是非活动导航的颜色*/
	background-color: #FEE4D9;
	width: 5px;
	height: 5px;
}

/*文字样式*/
#fp-nav ul li .fp-tooltip {
	color: #000;
}
</style>
<link href="V/static/css/app.9b9ba36f47c49c69b079eb1e3a0ed0a8.css" rel="stylesheet">
<link id="layuicss-layer" rel="stylesheet" href="V/static/layui/css/modules/layer/default/layer.css" media="all">
<meta data-vue-meta="1" name="keyword" content="">
<meta data-vue-meta="1" name="description" content="">
</head>
<body>
	<div data-v-911c958c="" id="app">
		<div data-v-383fd33b="" data-v-911c958c="" id="app" class="color11">
			<div data-v-383fd33b="" class="contianer">
				<div data-v-383fd33b="" class="back_page">
					<div data-v-383fd33b="" class="back_page_box">
						<div data-v-383fd33b="" class="back_page_arrow"></div>
					</div>
				</div>
				<div data-v-383fd33b="" class="voerTop_menu" style="opacity: 1;">
					<div data-v-383fd33b="" class="voerTop_menuLeft">
						<a href="javascript:history.go(-1);">
							<span data-v-383fd33b=""></span>
						</a>
					</div>
					<div data-v-383fd33b="" class="voerTop_menuCenter">
						<span data-v-383fd33b="" class="topOn">商品</span>
					</div>
				</div>
				<div data-v-383fd33b="" class="contianer_top">
					<div data-v-383fd33b="" class="contianer_content">
						<div data-v-383fd33b="" class="swiper-container swiper-container-initialized swiper-container-horizontal" style="cursor: -webkit-grab;">
							<div class="swiper-wrapper" style="transform: translate3d(0px, 0px, 0px); transition-duration: 0ms;">
								<div data-v-383fd33b="" class="swiperPic swiper-slide swiper-slide-active" style="margin-top:35px;" align="center">
									<img src="${goods.goods_images}" alt="${goods.goods_name}" width="400px" height="400px" style="margin-left:10px;">
								</div>
							</div>
							<span class="swiper-notification" aria-live="assertive"
								aria-atomic="true"></span>
						</div>
					</div>
				</div>
				<div data-v-383fd33b="" class="container_content paddingBottom">
					<div data-v-383fd33b="" class="container_content_top">
						<div data-v-383fd33b="" class="container_content_price">
							<div data-v-383fd33b="" class="container_content_priceLeft">
								<div data-v-383fd33b="" class="container_content_priceAfter">
									<div data-v-383fd33b="">
										<span data-v-383fd33b="" class="small_font">￥</span>${goods.goods_price}
									</div>
								</div>
							</div>
						</div>
						<div data-v-383fd33b="" class="container_content_title">
							<span data-v-383fd33b="" class="top_title">
								<span data-v-383fd33b="" class="title_text">${goods.goods_name}</span>
							</span>
							<br>
							<input type="hidden" id="goods_promote" name="goods_promote" value="${goods.goods_promote}">
							<!-- 抢购商品 -->
							<c:if test="${goods.goods_promote == 2}">
								<span data-v-383fd33b="" class="top_title">
									<span data-v-383fd33b="" class="title_text">开始抢购时间：${goods.goods_starttime}</span>
								</span><br>
								<span data-v-383fd33b="" class="top_title">
									<span data-v-383fd33b="" class="title_text">结束抢购时间：${goods.goods_endtime}</span>
								</span>
							</c:if>
							<div data-v-383fd33b="" class="tip_number">
								<div data-v-383fd33b="" class="tip">
								</div>
								<div data-v-383fd33b="" style="flex: 0 0 auto;">
								</div>
							</div>
						</div>
					</div>
					<div data-v-383fd33b="" style="margin-bottom: 0.2rem;">
						<div data-v-383fd33b="" class="preferential_box"></div>
					</div>
					<div data-v-383fd33b="" class="params_detailBox">
						<div data-v-383fd33b="" class="params_detailTitle_box">
							<div data-v-383fd33b="" id="params_detailTitle"
								class="params_detailTitle">
								<span data-v-383fd33b="" class="on">商品详情</span>
							</div>
						</div>
						<div data-v-383fd33b="" class="params_detailImg">
							<div data-v-383fd33b="">
								<div data-v-383fd33b="" class="contentDeatils">
									<p>${goods.goods_content}</p>
								</div>
							</div>
						</div>
					</div>
					<div data-v-383fd33b="" class="params_detailBox">
						<div data-v-383fd33b="" class="params_detailTitle_box">
							<div data-v-383fd33b="" id="params_detailTitle"
								class="params_detailTitle">
								<span data-v-383fd33b="" class="on">商品评价</span>
							</div>
						</div>
						<div data-v-383fd33b="" class="params_detailImg">
							<div data-v-383fd33b="">
								<c:forEach varStatus="i" var="goodsevaluate" items="${goodsevaluatelist}">
									<div data-v-383fd33b="" class="contentDeatils" style="float:left;">
										${goodsevaluate.adminuser_username}
									</div>
									<div data-v-383fd33b="" class="contentDeatils" style="float:left;">
										评分:
										<c:if test="${goodsevaluate.goodsevaluate_star==1}">
											1分
										</c:if>
										<c:if test="${goodsevaluate.goodsevaluate_star==2}">
											2分
										</c:if>
										<c:if test="${goodsevaluate.goodsevaluate_star==3}">
											3分
										</c:if>
										<c:if test="${goodsevaluate.goodsevaluate_star==4}">
											4分
										</c:if>
										<c:if test="${goodsevaluate.goodsevaluate_star==5}">
											5分
										</c:if>
									</div>
									<div data-v-383fd33b="" class="contentDeatils">
										${goodsevaluate.goodsevaluate_addtime}
									</div>
									<div data-v-383fd33b="" class="contentDeatils">
										${goodsevaluate.goodsevaluate_content}
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div data-v-383fd33b="" class="shop_footer">
					<div data-v-383fd33b="" class="footer_home">
						<div data-v-383fd33b="" class="footer_home_box">
							<img data-v-383fd33b="" src="images/store.png" alt="首页"> 
							<a href="mainindex"><span data-v-383fd33b="">首页</span></a>
						</div>
						<div data-v-383fd33b="" class="footer_home_box">
							<img data-v-383fd33b="" src="images/collection.png" alt="收藏">
							<a href="frontshop?shop_id=${goods.shop_id}"><span data-v-383fd33b="">店铺</span></a>
						</div>
					</div>
					<div data-v-383fd33b="" class="footer_right">
					
					
						<c:if test="${currentUser == null || currentUser == ''}">
							<div data-v-383fd33b="" class="footer_shoppingCat">
								<div data-v-383fd33b="">
									<button data-v-383fd33b="" class="colorShoppCat" onclick="gotologin();"
										style="background: rgb(255, 101, 7) !important; width: 2rem; color: rgb(255, 255, 255) !important;">
										加入购物车
									</button>
								</div>
							</div>
							<div data-v-383fd33b="" class="footer_shoppingCat">
								<div data-v-383fd33b="">
									<button data-v-383fd33b="" class="colorBuynow" onclick="gotologin();"
										style="background: rgb(255, 101, 7) !important; width: 2rem; color: rgb(255, 255, 255) !important;">
										立即购买
									</button>
								</div>
							</div>
							<script type="text/javascript">
								function gotologin() {
									window.location.href = "login.html";
								}
							</script>
						</c:if>
						<c:if test="${currentUser != null && currentUser != ''}">
							<div data-v-383fd33b="" class="footer_shoppingCat">
								<div data-v-383fd33b="">
									<button data-v-383fd33b="" class="colorShoppCat" onclick="openselect()"
										style="background: rgb(255, 101, 7) !important; width: 2rem; color: rgb(255, 255, 255) !important;">
										加入购物车
									</button>
								</div>
							</div>
							<div data-v-383fd33b="" class="footer_shoppingCat">
								<div data-v-383fd33b="">
									<button data-v-383fd33b="" class="colorBuynow" onclick="openselect()"
										style="background: rgb(255, 101, 7) !important; width: 2rem; color: rgb(255, 255, 255) !important;">
										立即购买
									</button>
								</div>
							</div>
							
							<script type="text/javascript">
								function openselect() {
									document.getElementById('selectwindow').style.display = 'block';
								}
							</script>
						</c:if>
						
						
					</div>
				</div>
				<div id="selectwindow" data-v-71d1a8b7="" data-v-383fd33b="" style="display:none;">
					<div data-v-71d1a8b7="" class="CustomPopupBefore CustomPopup" style=""></div>
					<div data-v-71d1a8b7="" class="CustomPopupContent CustomPopupContentShow">
						<div data-v-383fd33b="" data-v-71d1a8b7="" class="PoperContentView shoppingStatusView">
							<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_top">
								<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_topImg">
									<img data-v-383fd33b="" data-v-71d1a8b7="" src="${goods.goods_images}" alt="图片">
								</div>
								<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_topStatus">
									<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_topPrice">
										<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_PriceBox">
											<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_topReduction">
												<span data-v-383fd33b="" data-v-71d1a8b7="" style="color: rgb(240, 37, 15) !important; font-size: 0.34rem !important;">
													<span data-v-383fd33b="" data-v-71d1a8b7="">￥</span> 
													<span data-v-383fd33b="" data-v-71d1a8b7="">${goods.goods_price}</span>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_colseBtn" onclick="closeselect()">
									<img data-v-383fd33b="" data-v-71d1a8b7="" src="images/close1.png" alt="关闭">
								</div>
								<script type="text/javascript">
									function closeselect() {
										document.getElementById('selectwindow').style.display = 'none';
									}
								</script>
							</div>
							<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_infos">
								<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_infosBox">
									<div data-v-383fd33b="" data-v-71d1a8b7="">
										<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_infosNumbers">
											<em data-v-383fd33b="" data-v-71d1a8b7="">购买数量</em>
											<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_numbersChange">
												<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_numbersChangeBox">
													<span onclick="subnum()" data-v-383fd33b="" data-v-71d1a8b7="" class="reduce">—</span>
													<input id="num" data-v-383fd33b="" data-v-71d1a8b7="" type="number" value="1">
													<span onclick="addnum()" data-v-383fd33b="" data-v-71d1a8b7="" class="add">
														<div style="margin-top:-5px;">+</div>
													</span>
												</div>
											</div>
											<script type="text/javascript">
												function subnum() {
													var num = document.getElementById('num').value;
													if (num > 1) {
														num = num - 1;
														document.getElementById('num').value = num;
													}
												}
												function addnum() {
													var num = document.getElementById('num').value;
													if (num < 20) {
														num = Number(num) + Number(1);
														document.getElementById('num').value = num;
													}
												}
											</script>
										</div>
									</div>
								</div>
								<style>
									.shoppingStatus_changePhone .cur{border:2px solid #72a75a;}
								</style>
								<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_Yesphone" style="display: block;">
									<span data-v-383fd33b="" data-v-71d1a8b7="">使用优惠券</span>
									<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingStatus_changePhone" id="pay_ment">
										<em class="cur" data-v-383fd33b="" data-v-71d1a8b7="" style="width:130px;">平台:${couponlistformanager.coupon_name}
											<input type="radio" name="coupon_type" style="display: none;" value="${couponlistformanager.coupon_id}" checked="checked">
										</em>
										<em data-v-383fd33b="" data-v-71d1a8b7="" style="width:130px;">商家:${couponlistforshop.coupon_name}
											<input type="radio" name="coupon_type" style="display: none;" value="${couponlistforshop.coupon_id}">
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
								</div>
							</div>
							<div data-v-383fd33b="" data-v-71d1a8b7="">
								<div data-v-383fd33b="" data-v-71d1a8b7="" class="shoppingChangeBtn shoppingChangeBtn">
								
								    <button data-v-383fd33b="" class="colorBuynow" onclick="addcart(${goods.goods_id});"
										style="background: rgb(255, 101, 7) !important; width: 2rem; color: rgb(255, 255, 255) !important;width:120px;height:45px;border:0px;border-radius:10px;font-size:18px;">         
										加入购物车
									</button>
									<button data-v-383fd33b="" class="colorBuynow" onclick="gobuy(${goods.goods_id});"
										style="background: rgb(255, 101, 7) !important; width: 2rem; color: rgb(255, 255, 255) !important;width:120px;height:45px;border:0px;border-radius:10px;font-size:18px;">         
										立即购买
									</button>
								    
									<%-- <div data-v-383fd33b="" data-v-71d1a8b7="" class="" onclick="addcart(${goods.goods_id});">加入购物车</div>
									<div data-v-383fd33b="" data-v-71d1a8b7="" class="" onclick="gobuy(${goods.goods_id});">立即购买</div> --%>
									<script type="text/javascript">
										function gobuy(goods_id) {
											var coupon_type = $("input[name='coupon_type']:checked").val();
											var num = document.getElementById('num').value;
											var goods_promote = document.getElementById('goods_promote').value;
											//立即购买
											$.post(
												"gobuy",
												{
													goods_id : goods_id,
													coupon_type : coupon_type,
													num : num,
													goods_promote : goods_promote
												},
												function(result) {
													var result = eval('(' + result + ')');
													if (result.result=="fail") {
														alert("购买失败，请确认网络");
													} else if (result.result=="success") {
														window.location.href = "checkorderforgobuy?cart_id="+result.cart_id;
													} else if (result.result=="failone") {
														alert("抢购还未开始");
													} else if (result.result=="failtwo") {
														alert("限时抢购已经结束");
													}
												});
										}
									</script>
									<script type="text/javascript">
										function addcart(goods_id) {
											var goods_promote = document.getElementById('goods_promote').value;
											if (goods_promote == 2) {//限时抢购商品
												alert("限时抢购商品只能选择立即购买");
											} else {
												var coupon_type = $("input[name='coupon_type']:checked").val();
												var num = document.getElementById('num').value;
												//加入购物车
												$.post(
													"addcart",
													{
														goods_id : goods_id,
														coupon_type : coupon_type,
														num : num
													},
													function(result) {
														var result = eval('(' + result + ')');
														if (result.result=="fail") {
															alert("加入购物车失败，请确认网络");
														} else if (result.result=="success") {
															alert("加入购物车成功！");
															window.location.href = "mainindex";
														}
													});
											}
										}
									</script>
								</div>
							</div>
						</div>
					</div>
					<div data-v-71d1a8b7="" class="CustomPopupContentMask"></div>
					<div data-v-71d1a8b7="" class="CustomPopupContentFull"></div>
				</div>
			</div>
			<div data-v-383fd33b=""></div>
			<div data-v-383fd33b=""></div>
		</div>
	</div>
	<script>/*750代表宽度，100代表换算比例，这里写100是
		    为了以后好算,比如，你测量的一个宽度是100px,就可以写为1rem,以及1px=0.01rem等等*/
		  window.onload = function () {
		    getRem(750, 100)
		  };
		  window.onresize = function () {
		    getRem(750, 100)
		  };
		  function getRem(pwidth, prem) {
		    var html = document.getElementsByTagName("html")[0];
		    var oWidth = document.body.clientWidth || document.documentElement.clientWidth;
		    html.style.fontSize = oWidth / pwidth * prem + "px";
		  }
	</script>
	<div class="layui-layer-move"></div>
</body>
</html>