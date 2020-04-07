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
<title>购物车</title>
</head>
<body>
	<div data-v-911c958c="" id="app">
		<div data-v-1976624a="" data-v-911c958c="" id="app" class="color11">
			<div data-v-1976624a="" class="shoppingCat_title">
			   <a href="mainindex" class="Return1">
				<img src="images/Return3.png" alt="" width="40" height="25"/>
					</a>
				
				<span data-v-1976624a="" class="shoppingCat_text" style="font-size:20px;">购物车</span> 
				<span data-v-1976624a="" class="shoppingCat_management">
			</div>
			
			
			<c:if test="${empty cartlist}">
			
			<div data-v-1976624a="" class="container reduceTopValue">
				
				
				<div data-v-1976624a="" class="shopping_ifEmpty">
					<div data-v-1976624a="">
						<img src="images/empty.png" width="80" height="80" />
					</div>
					<div data-v-1976624a="">
						<span data-v-1976624a="">什么东西也没有</span>
					</div>
					<div data-v-1976624a="">
						<span data-v-1976624a="">再忙，也要记得买点东西犒劳自己~~</span>
					</div>
					
					<div data-v-1976624a="">
				  		<button data-v-1976624a="" style="background-color:#32CD32">						
							<td><a data-v-1976624a="" href="goodstype.jsp" class="Home" style=" color:#FFDEAD">去逛逛</a></td>
						</button>
					</div>				
					    						
				</div>
			</div>
			
			</c:if>
			
			
			<c:if test="${not empty cartlist}">
			<div data-v-1976624a="" class="container reduceTopValue">
				<div data-v-1976624a="" class="shopping_ifNotEmpty">
					<div data-v-1976624a="" class="shoppingCat_content">
						<div data-v-1976624a="" class="shoppingCat_main">
							<c:forEach varStatus="i" var="cart" items="${cartlist}">
							<div data-v-1976624a="" class=" shoppingCat_mainBox shoppingMain_BoxBorder">
								<div data-v-1976624a="" class="shoppingMain_bulkTime"></div>
								<div data-v-1976624a="" class="shoppingMain_BoxMain">
									<div data-v-1976624a="" class="shoppingMain_Box">
										<div data-v-1976624a="" class="shoppingMain_picture">
											<div data-v-1976624a="" class="shoppingMain_pictureBox">
												<img data-v-1976624a="" src="${cart.goods_images}" alt="图片">
											</div>
										</div>
										<div data-v-1976624a="" class="shoppingMain_information">
											<div data-v-1976624a="" class="shoppingMain_informationTop">
												<div data-v-1976624a="" class="shoppingMain_title">
													${cart.goods_name}
												</div>
											</div>
											
											<div style="margin-left:170px;margin-top:-50px;border-radius:6px;width:50px;height:30px;background-color:#6974f3;text-align:center;font-size:15px;line-height:30px;">
												<a onclick="deletecart('${cart.cart_id}')" style="color:#fff;">
													删除
												</a>
											</div>
											<script type="text/javascript">
												function deletecart(cart_id) {
													if (confirm("确定要删除这个课程吗?")) {
														$.post(
															"deletecart",
															{
																cart_id : cart_id
															},
															function(result) {
																var result = eval('(' + result + ')');
																if (result.error) {
																	alert(result.error);
																} else {
																	alert("删除成功！");
																	window.location.href = "frontcart";
																}
														});
													}
												}
											</script>
											
											
											<div data-v-1976624a="" class="shoppingMain_price">
												<div data-v-1976624a="" class="shoppingMain_priceBox">
													<span data-v-1976624a="">
													<span data-v-1976624a="" class="smallText">￥</span> 
														<span id="cart_goodsprice_${i.count}">${cart.cart_price}</span>
													</span>
												</div>
												<div data-v-1976624a="" class="shoppingMain_priceNum">
													<div onclick="subnum(${i.count},${cart.cart_id})" data-v-1976624a="" class="shoppingMain_priceReduce">
														<img data-v-1976624a="" src="images/reduceYes.png" alt="reduce"> 
													</div>
													<div data-v-1976624a="" class="shoppingMain_priceInput">
														<input id="num_${i.count}" data-v-1976624a="" type="number" value="${cart.cart_addnum}" readonly="readonly">
													</div>
													<div onclick="addnum(${i.count},${cart.cart_id})" data-v-1976624a="" class="shoppingMain_priceAdd">
														<img data-v-1976624a="" src="images/add.png" alt="add">
													</div>
												</div>
												<script type="text/javascript">
													function subnum(count,cart_id) {
														var num_count = document.getElementById('num_'+count).value;
														if (num_count > 1) {
															num_count = num_count - 1;
															document.getElementById('num_'+count).value = num_count;
															//减购物车数量
															$.post(
																	"subcartnum",
																	{
																		cart_id : cart_id
																	},
																	function(result) {
																		var result = eval('(' + result + ')');
																		if (result.result=="fail") {
																			alert("修改购物车失败，请确认网络");
																		} else if (result.result=="success") {
																			//设置购物车单个商品的价格
																			document.getElementById('cart_goodsprice_'+count).innerText = result.cart_goodsprice;
																			//设置购物车总价格
																			document.getElementById('sumprice').innerText = result.sumprice;
																		}
																	});
														}
													}
													function addnum(count,cart_id) {
														var num_count = document.getElementById('num_'+count).value;
														if (num_count < 20) {
															num_count = Number(num_count) + Number(1);
															document.getElementById('num_'+count).value = num_count;
															//减购物车数量
															$.post(
																	"addcartnum",
																	{
																		cart_id : cart_id
																	},
																	function(result) {
																		var result = eval('(' + result + ')');
																		if (result.result=="fail") {
																			alert("修改购物车失败，请确认网络");
																		} else if (result.result=="success") {
																			//设置购物车单个商品的价格
																			document.getElementById('cart_goodsprice_'+count).innerText = result.cart_goodsprice;
																			//设置购物车总价格
																			document.getElementById('sumprice').innerText = result.sumprice;
																		}
																	});
														}
													}
												</script>
											</div>
										</div>
									</div>
									<div data-v-1976624a="" class="shoppingMain_buyNum">
									</div>
								</div>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			</c:if>
			
			
			<div data-v-1976624a="" class="footer">
				<div data-v-1976624a="" class="footer_price">
					<div data-v-1976624a="" class="footer_allPrice">
						<span data-v-1976624a=""> 合计: 
							<em data-v-1976624a="">
								<span data-v-1976624a="">￥</span> <span id="sumprice">${sumprice}</span>
							</em>
						</span>
					</div>
				</div>
				<div data-v-1976624a="" class="footer_settlement">
					<button data-v-1976624a="" class="footer_settlementBtn" style="" onclick="gotocheckorder()">去结算</button>
					<script type="text/javascript">
						function gotocheckorder() {
							window.location.href = "checkorderforcart";
						}
					</script>
				</div>
			</div>
		</div>
	</div>
	<script>
		/*750代表设计师给的设计稿的宽度，你的设计稿是多少，就写多少;100代表换算比例，这里写100是
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