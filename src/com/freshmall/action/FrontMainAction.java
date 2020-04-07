package com.freshmall.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshmall.model.AdminUser;
import com.freshmall.model.Buy;
import com.freshmall.model.Cart;
import com.freshmall.model.Coupon;
import com.freshmall.model.Goods;
import com.freshmall.model.Goodsevaluate;
import com.freshmall.model.Goodstype;
import com.freshmall.model.Shop;
import com.freshmall.util.GetOrderIdByTime;
import com.freshmall.util.ResponseUtil;
import com.freshmall.model.Goods;
import com.freshmall.model.PageBean;
import com.freshmall.util.PageUtil;
import com.freshmall.util.StringUtil;
import com.freshmall.dao.AdminUserDao;
import com.freshmall.dao.BuyDao;
import com.freshmall.dao.CartDao;
import com.freshmall.dao.CouponDao;
import com.freshmall.dao.GoodsDao;
import com.freshmall.dao.GoodsevaluateDao;
import com.freshmall.dao.GoodstypeDao;
import com.freshmall.dao.ShopDao;

import net.sf.json.JSONObject;

/**
 * 前端主控制类
 * @author gongwei
 *
 */
@Controller
public class FrontMainAction {
	@Resource
	private AdminUserDao adminuserDao;
	@Resource
	private ShopDao shopDao;
	@Resource
	private GoodsDao goodsDao;
	@Resource
	private GoodstypeDao goodstypeDao;
	@Resource
	private CouponDao couponDao;
	@Resource
	private CartDao cartDao;
	@Resource
	private BuyDao buyDao;
	@Resource
	private GoodsevaluateDao goodsevaluateDao;
	/**
	 * 前端用户登录
	 * @return
	 */
	@RequestMapping(value = "/front/frontlogin")
	public void frontlogin(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject resultJson = new JSONObject();
		String user_iphone = request.getParameter("user_iphone");//获取用户手机号码
		String user_password = request.getParameter("user_password");//获取用户密码
		HttpSession session = request.getSession();
		AdminUser user = adminuserDao.userLogin(user_iphone, user_password);
		if (user.getAdminuser_iphone() == null || user.getAdminuser_iphone() == "") {
			resultJson.put("result", "failone");//登录失败，用户不存在
		} else {
			session.setAttribute("currentUser", user);
			//setMaxInactiveInterval设置的是当前会话的失效时间，不是整个web的时间，单位为以秒计算。如果设置的值为零或负数，则表示会话将永远不会超时。
			session.setMaxInactiveInterval(0);
			resultJson.put("result", "success");
		}
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 前端用户注册
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/front/frontregister")
	public String frontregister(HttpServletRequest request, HttpServletResponse response) {
		JSONObject resultJson = new JSONObject();
		String user_iphone = request.getParameter("user_iphone");//获取手机号码
		String user_password = request.getParameter("user_password");//获取用户密码
		String user_name = request.getParameter("user_name");//获取用户名称

		//查询手机号码是否存在
		List<AdminUser> useriphonelist = adminuserDao.findUserByIphone(user_iphone);
		if (useriphonelist.size() > 0) {
			resultJson.put("result", "failone");//手机号码已存在
		} else {
			AdminUser user = new AdminUser();
			user.setAdminuser_username(user_name);//设置用户名称
			user.setAdminuser_password(user_password);//设置用户密码
			user.setAdminuser_iphone(user_iphone);//设置用户手机号码
			//获取当前系统时间
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String user_registertime = formatter.format(date);
			user.setAdminuser_registertime(user_registertime);//设置用户注册时间
			user.setRole_id(2);//设置用户角色 1、管理员 2、用户
			user.setAdminuser_sex(1);//设置用户性别 1、男 0、女
			user.setAdminuser_age(1);//设置用户年龄
			user.setAdminuser_status(1);//设置用户状态 1、正常 2、锁定
			int a = adminuserDao.addAdminUser(user);
			if (a > 0) {//用户添加成功后获取用户id
				resultJson.put("result", "success");//注册成功
			} else {
				resultJson.put("result", "failtwo");//注册失败
			}
		}
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用户退出系统
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/front/frontlogout")
	public void phonelogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("mainindex");//退出后返回首页
	}

	/**
	 * 前台首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/mainindex")
	public String mainindex(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		//查询限时抢购商品列表
		List<Goods> goodslimittimelist = goodsDao.findGoodssLimittime(20);
		model.addAttribute("goodslimittimelist", goodslimittimelist);
		
		//查询商品列表
		List<Goods> goodslist = goodsDao.findGoodssLimit(10);
		model.addAttribute("goodslist", goodslist);
		
		return "index.jsp";
	}


	/**
	 * 商品分类页
	 * @return
	 */
	@RequestMapping(value = "/front/goodstype")
	public void goodstype(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject resultJson = new JSONObject();

		//查询商品分类列表
		List<Goodstype> goodstypelist = goodstypeDao.findGoodstype(null);
		resultJson.put("goodstypelist", goodstypelist);//商品分类列表

		//商品列表
		List<Goods> goodslist = null;
		int goodstype_id = Integer.parseInt(request.getParameter("goodstype_id"));//获取商品类型id
		if (goodstype_id == 0) {//查询第一个分类的商品列表
			goodslist = goodsDao.findGoodsByGoodstypeId(1);
		} else {//按类型查询商品列表
			goodslist = goodsDao.findGoodsByGoodstypeId(goodstype_id);
		}
		resultJson.put("goodslist", goodslist);//商品列表

		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 商品详情页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/goodsinfo")
	public String goodsinfo(Model model, HttpServletRequest request, HttpServletResponse response) {

		String goods_id = request.getParameter("goods_id");//商品id
		//根据商品id查询商品信息
		List<Goods> goodslist = goodsDao.findGoodsById(Integer.parseInt(goods_id));
		Goods goods = new Goods();
		if (goodslist.size() > 0) {
			goods = goodslist.get(0);
		} else {
			goods = null;
		}
		model.addAttribute("goods", goods);

		List<Coupon> couponlistformanager = couponDao.findCouponsForManager();
		model.addAttribute("couponlistformanager", couponlistformanager.get(0));

		List<Coupon> couponlistforshop = couponDao.findCouponsForShop();
		model.addAttribute("couponlistforshop", couponlistforshop.get(0));
		
		//根据商品id查询该商品的评价列表
		List<Goodsevaluate> goodsevaluatelist = goodsevaluateDao
				.findGoodsevaluateByGoodId(Integer.parseInt(goods_id));
		model.addAttribute("goodsevaluatelist", goodsevaluatelist);

		return "goods_info.jsp";
	}

	/**
	 * 加入购物车
	 * @return
	 */
	@RequestMapping(value = "/front/addcart")
	public void addcart(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject resultJson = new JSONObject();
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回用户中心
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id

			Cart cart = new Cart();

			cart.setAdminuser_id(adminuser_id);//设置用户id

			String goods_id = request.getParameter("goods_id");//获取商品id
			cart.setGoods_id(Integer.parseInt(goods_id));//设置商品id

			//根据商品id获取商品信息
			List<Goods> goodslist = goodsDao.findGoodsById(Integer.parseInt(goods_id));
			Goods goods = goodslist.get(0);
			String goods_price = goods.getGoods_price();//获取商品价格

			String coupon_id = request.getParameter("coupon_type");//获取优惠券id
			//根据优惠券id查询优惠券价值
			List<Coupon> couponlist = couponDao.findCouponById(Integer.parseInt(coupon_id));
			Coupon coupon = couponlist.get(0);
			String coupon_price = coupon.getCoupon_price();//获取优惠券价值

			int num = Integer.parseInt(request.getParameter("num"));//获取购买数量

			double goods_sumprice = Double.parseDouble(goods_price) * num;

			double cart_sumprice = goods_sumprice - Double.parseDouble(coupon_price);

			cart.setCart_price(String.valueOf(cart_sumprice));//设置加入购物车的价格

			cart.setCart_addnum(num);//设置加入购物车的数量

			//获取当前系统时间
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String cart_addtime = formatter.format(date);
			cart.setCart_addtime(cart_addtime);//设置加入时间

			int a = cartDao.addCart(cart);//添加购物车记录

			if (a > 0) {
				resultJson.put("result", "success");
			} else {
				resultJson.put("result", "fail");//加入购物车失败
			}
		}
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 减购物车数量
	 * @return
	 */
	@RequestMapping(value = "/front/subcartnum")
	public void subcartnum(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject resultJson = new JSONObject();
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回用户中心
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id
			
			int cart_id = Integer.parseInt(request.getParameter("cart_id"));//获取购物车id
			
			//根据购物车id查询购物车商品信息
			List<Cart> cartlist = cartDao.findCartsById(cart_id);
			Cart cart = cartlist.get(0);
			double goods_price = Double.parseDouble(cart.getGoods_price());//获取商品价格
			
			double cart_price = Double.parseDouble(cart.getCart_price());//获取购物车价格
			
			double cart_goodsprice = 0.0;
			
			if (cart_price > goods_price) {//购物车价格大于商品价格，则修改后购物车价格=购物车价格-商品价格
				cart_goodsprice = cart_price - goods_price;
			} else {//否则修改后购物车的价格为0
				cart_goodsprice = 0.0;
			}
			
			int cart_addnum = cart.getCart_addnum() - 1;
			
			//根据购物车id修改该购物车的数量和价格
			int a = cartDao.updateCartByIdToUpdateNum(cart_id, String.valueOf(cart_goodsprice), cart_addnum);
			if (a > 0) {
				resultJson.put("result", "success");//修改购物车成功
				//根据购物车id重新获取该购物车的价格
				String cart_goodsprice1 = cartDao.findCartsById(cart_id).get(0).getCart_price();
				resultJson.put("cart_goodsprice", cart_goodsprice1);//将该购物车价格传到前台
				
				//查询购物车总价格
				int sumprice = cartDao.CartSumByAdminUser(adminuser_id);
				resultJson.put("sumprice", sumprice);//将购物车总价格传到前台
				
			} else {
				resultJson.put("result", "fail");//修改购物车失败
			}
		}
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 加购物车数量
	 * @return
	 */
	@RequestMapping(value = "/front/addcartnum")
	public void addcartnum(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject resultJson = new JSONObject();
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回用户中心
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id
			
			int cart_id = Integer.parseInt(request.getParameter("cart_id"));//获取购物车id
			
			//根据购物车id查询购物车商品信息
			List<Cart> cartlist = cartDao.findCartsById(cart_id);
			Cart cart = cartlist.get(0);
			double goods_price = Double.parseDouble(cart.getGoods_price());//获取商品价格
			
			double cart_price = Double.parseDouble(cart.getCart_price());//获取购物车价格
			
			double cart_goodsprice = 0.0;
			
			cart_goodsprice = cart_price + goods_price;
			
			int cart_addnum = cart.getCart_addnum() + 1;
			
			//根据购物车id修改该购物车的数量和价格
			int a = cartDao.updateCartByIdToUpdateNum(cart_id, String.valueOf(cart_goodsprice), cart_addnum);
			if (a > 0) {
				resultJson.put("result", "success");//修改购物车成功
				//根据购物车id重新获取该购物车的价格
				String cart_goodsprice1 = cartDao.findCartsById(cart_id).get(0).getCart_price();
				resultJson.put("cart_goodsprice", cart_goodsprice1);//将该购物车价格传到前台
				
				//查询购物车总价格
				int sumprice = cartDao.CartSumByAdminUser(adminuser_id);
				resultJson.put("sumprice", sumprice);//将购物车总价格传到前台
				
			} else {
				resultJson.put("result", "fail");//修改购物车失败
			}
		}
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除购物车操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/front/deletecart")
	public String deletecart(String cart_id, HttpServletRequest request, HttpServletResponse response) {
		cartDao.deleteCart(Integer.parseInt(cart_id));
		JSONObject resultJson = new JSONObject();
		resultJson.put("success", true);
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用户购物车页
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/front/frontcart")
	public String frontcart(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回用户中心
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id
			
			//根据用户id查询该用户的购物车列表
			List<Cart> cartlist = cartDao.findCartsByAdminUserId(adminuser_id);
			model.addAttribute("cartlist", cartlist);
			
			//查询购物车总价格
			int sumprice = cartDao.CartSumByAdminUser(adminuser_id);
			model.addAttribute("sumprice", sumprice);
		}

		return "cart.jsp";
	}
	
	/**
	 * 购物车进入确认订单页
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/front/checkorderforcart")
	public String checkorderforcart(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回用户中心
			response.sendRedirect("mainindex");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id

			//根据用户id查询该用户的购物车列表
			List<Cart> cartlist = cartDao.findCartsByAdminUserId(adminuser_id);

			model.addAttribute("cartlist", cartlist);

			//计算购物车总计
			int sumprice = cartDao.CartSumByAdminUser(adminuser_id);
			model.addAttribute("sumprice", sumprice);

		}
		return "check_order.jsp";
	}
	
	/**
	 * 生成订单
	 * @return
	 */
	@RequestMapping(value = "/front/createbuy")
	public void createbuy(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject resultJson = new JSONObject();
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回用户中心
			response.sendRedirect("mainindex");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id
			int cart_id = Integer.parseInt(request.getParameter("cart_id"));//获取购物车id
			
//			StringBuffer content = new StringBuffer();
			
			int a = 0;
			
			if (cart_id == 0) {//等于0说明是从购物车来的
				//根据用户id查询该用户的购物车列表
				List<Cart> cartlist = cartDao.findCartsByAdminUserId(adminuser_id);
				if (cartlist.size() > 0) {
					for(int i = 0; i< cartlist.size(); i++) {
						Buy buy = new Buy();
						
						buy.setAdminuser_id(adminuser_id);//设置用户id
						
						String buy_sn = GetOrderIdByTime.getOrderIdByTime(String.valueOf(adminuser_id));//创建订单编号
						buy.setBuy_sn(buy_sn);//设置订单编号
						
						String buy_price = cartlist.get(i).getCart_price();//获取购物车价格
						buy.setBuy_price(buy_price);//设置订单价格
						
						//获取当前系统时间
						Date date = new Date();
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String buy_addtime = formatter.format(date);
						buy.setBuy_addtime(buy_addtime);//设置下单时间
						
						String payment_id = request.getParameter("payment_id");//获取支付方式
						buy.setPayment_id(Integer.parseInt(payment_id));//设置支付方式
						
						buy.setBuy_status(2);//设置1、未支付 2、已支付（等待发货） 3、已发货（等待确认收货）4、已确认收货（待评价）5、已评价（完成）
						
						String adminuser_username = user.getAdminuser_username();//获取用户名称
						buy.setAdminuser_username(adminuser_username);//设置用户名称
						
						String adminuser_iphone = user.getAdminuser_iphone();//获取用户手机号码
						buy.setAdminuser_iphone(adminuser_iphone);//设置用户手机号码
						
						String goods_name = cartlist.get(i).getGoods_name();//获取商品名称
						int cart_addnum = cartlist.get(i).getCart_addnum();//获取商品数量
						String goodscart_content = goods_name+"X" + cart_addnum;
						
						buy.setBuy_content(goodscart_content);//设置订单内容
						
						int goods_id = cartlist.get(i).getGoods_id();//获取商品id
						buy.setGoods_id(goods_id);//设置商品id
						
						String buy_message = request.getParameter("buy_message");//获取订单留言
						buy.setBuy_message(buy_message);//设置订单留言
						
						String buy_address = request.getParameter("buy_address");//获取订单地址
						buy.setBuy_address(buy_address);//设置订单地址
						
						a = buyDao.addBuy(buy);//添加一条订单记录
					}
				}
			} else {
				//根据购物车id查询该购物车列表
				List<Cart> cartlist = cartDao.findCartsById(cart_id);
				if (cartlist.size() > 0) {
					for(int i = 0; i< cartlist.size(); i++) {
						Buy buy = new Buy();
						
						buy.setAdminuser_id(adminuser_id);//设置用户id
						
						String buy_sn = GetOrderIdByTime.getOrderIdByTime(String.valueOf(adminuser_id));//创建订单编号
						buy.setBuy_sn(buy_sn);//设置订单编号
						
						String buy_price = request.getParameter("buy_price");//获取订单价格
						buy.setBuy_price(buy_price);//设置订单价格
						
						//获取当前系统时间
						Date date = new Date();
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String buy_addtime = formatter.format(date);
						buy.setBuy_addtime(buy_addtime);//设置下单时间
						
						String payment_id = request.getParameter("payment_id");//获取支付方式
						buy.setPayment_id(Integer.parseInt(payment_id));//设置支付方式
						
						buy.setBuy_status(2);//设置1、未支付 2、已支付（等待发货） 3、已发货（等待确认收货）4、已确认收货（待评价）5、已评价（完成）
						
						String adminuser_username = user.getAdminuser_username();//获取用户名称
						buy.setAdminuser_username(adminuser_username);//设置用户名称
						
						String adminuser_iphone = user.getAdminuser_iphone();//获取用户手机号码
						buy.setAdminuser_iphone(adminuser_iphone);//设置用户手机号码
						
						String goods_name = cartlist.get(i).getGoods_name();//获取商品名称
						int cart_addnum = cartlist.get(i).getCart_addnum();//获取商品数量
						String goodscart_content = goods_name+"X" + cart_addnum;
						
						buy.setBuy_content(goodscart_content);//设置订单内容
						
						int goods_id = cartlist.get(i).getGoods_id();//获取商品id
						buy.setGoods_id(goods_id);//设置商品id
						
						String buy_message = request.getParameter("buy_message");//获取订单留言
						buy.setBuy_message(buy_message);//设置订单留言
						
						String buy_address = request.getParameter("buy_address");//获取订单地址
						buy.setBuy_address(buy_address);//设置订单地址
						
						a = buyDao.addBuy(buy);//添加一条订单记录
					}
				}
			}
			
			if (a > 0) {
				resultJson.put("buy_id", a);
				resultJson.put("result", "success");
				if (cart_id == 0) {//等于0说明是从购物车来的
					//下单成功，删除该用户购物车
					cartDao.deleteCartByAdminuserId(adminuser_id);
				} else {//从立即购买来
					//下单成功，删除该用户购物车
					cartDao.deleteCart(cart_id);
				}
			} else {
				resultJson.put("result", "fail");//用户下单失败
			}
			
		}
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 立即购买
	 * @return
	 */
	@RequestMapping(value = "/front/gobuy")
	public void gobuy(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject resultJson = new JSONObject();
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回用户中心
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id

			Cart cart = new Cart();

			cart.setAdminuser_id(adminuser_id);//设置用户id

			String goods_id = request.getParameter("goods_id");//获取商品id
			cart.setGoods_id(Integer.parseInt(goods_id));//设置商品id
			
			//根据商品id获取商品信息
			List<Goods> goodslist = goodsDao.findGoodsById(Integer.parseInt(goods_id));
			Goods goods = goodslist.get(0);
			
			int goods_promote = Integer.parseInt(request.getParameter("goods_promote"));//获取促销id
			if (goods_promote == 2) {//是限时抢购商品
				//获取当前系统时间
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String current_time = formatter.format(date);
				
				//根据商品id查询该商品的开始抢购时间和结束抢购时间
				String goods_starttime = goods.getGoods_starttime();//获取开始抢购时间
				String goods_starttimes = goods_starttime.replace("T", " ");
				
				String goods_endtime = goods.getGoods_endtime();//获取结束抢购时间
				String goods_endtimes = goods_endtime.replace("T", " ");
				
				int start_result = goods_starttimes.compareTo(current_time);
				
				int end_result = goods_endtimes.compareTo(current_time);
				
				if (start_result > 0) {//还未开始抢购
					resultJson.put("result", "failone");//还未到抢购开始时间
				} else if (end_result < 0) {//已过抢购时间
					resultJson.put("result", "failtwo");//还未到抢购开始时间
				} else {
					String goods_price = goods.getGoods_price();//获取商品价格

					String coupon_id = request.getParameter("coupon_type");//获取优惠券id
					//根据优惠券id查询优惠券价值
					List<Coupon> couponlist = couponDao.findCouponById(Integer.parseInt(coupon_id));
					Coupon coupon = couponlist.get(0);
					String coupon_price = coupon.getCoupon_price();//获取优惠券价值

					int num = Integer.parseInt(request.getParameter("num"));//获取购买数量

					double goods_sumprice = Double.parseDouble(goods_price) * num;

					double cart_sumprice = goods_sumprice - Double.parseDouble(coupon_price);

					cart.setCart_price(String.valueOf(cart_sumprice));//设置加入购物车的价格

					cart.setCart_addnum(num);//设置加入购物车的数量

					//获取当前系统时间
					String cart_addtime = formatter.format(date);
					cart.setCart_addtime(cart_addtime);//设置加入时间

					int a = cartDao.addCart(cart);//添加购物车记录

					if (a > 0) {
						resultJson.put("result", "success");
						resultJson.put("cart_id", a);
					} else {
						resultJson.put("result", "fail");//加入购物车失败
					}
				}
			} else {
				String goods_price = goods.getGoods_price();//获取商品价格

				String coupon_id = request.getParameter("coupon_type");//获取优惠券id
				//根据优惠券id查询优惠券价值
				List<Coupon> couponlist = couponDao.findCouponById(Integer.parseInt(coupon_id));
				Coupon coupon = couponlist.get(0);
				String coupon_price = coupon.getCoupon_price();//获取优惠券价值

				int num = Integer.parseInt(request.getParameter("num"));//获取购买数量

				double goods_sumprice = Double.parseDouble(goods_price) * num;

				double cart_sumprice = goods_sumprice - Double.parseDouble(coupon_price);

				cart.setCart_price(String.valueOf(cart_sumprice));//设置加入购物车的价格

				cart.setCart_addnum(num);//设置加入购物车的数量

				//获取当前系统时间
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String cart_addtime = formatter.format(date);
				cart.setCart_addtime(cart_addtime);//设置加入时间

				int a = cartDao.addCart(cart);//添加购物车记录

				if (a > 0) {
					resultJson.put("result", "success");
					resultJson.put("cart_id", a);
				} else {
					resultJson.put("result", "fail");//加入购物车失败
				}
			}
		}
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 购物车进入确认订单页
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/front/checkorderforgobuy")
	public String checkorderforgobuy(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回用户中心
			response.sendRedirect("mainindex");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id
			
			String cart_id = request.getParameter("cart_id");
			//根据购物车id查询购物车信息

			//根据用户id查询该用户的购物车列表
			List<Cart> cartlist = cartDao.findCartsById(Integer.parseInt(cart_id));

			model.addAttribute("cartlist", cartlist);

			//计算购物车总计
			int sumprice = cartDao.CartSumByAdminUser(adminuser_id);
			model.addAttribute("sumprice", sumprice);
			
			model.addAttribute("cart_id", cart_id);

		}
		return "check_order.jsp";
	}
	
	/**
	 * 用户中心页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/frontuser")
	public String frontuser(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回首页
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id

			//通过用户id查询用户信息
			List<AdminUser> adminuserlist = adminuserDao.findAdminUserById(adminuser_id);
			AdminUser user1 = new AdminUser();
			if (adminuserlist.size() > 0) {
				user1 = adminuserlist.get(0);
			} else {
				user1 = null;
			}

			model.addAttribute("user", user1);

		}
		return "user.jsp";
	}
	
	/**
	 * 用户详情页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/frontuserinfo")
	public String frontuserinfo(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回首页
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id

			//通过用户id查询用户信息
			List<AdminUser> adminuserlist = adminuserDao.findAdminUserById(adminuser_id);
			AdminUser user1 = new AdminUser();
			if (adminuserlist.size() > 0) {
				user1 = adminuserlist.get(0);
			} else {
				user1 = null;
			}

			model.addAttribute("user", user1);

		}
		return "user_info.jsp";
	}
	
	/**
	 * 用户修改个人信息
	 */
	@RequestMapping(value = "/front/userupdateinfo")
	public void userupdateinfo(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回用户中心
			response.sendRedirect("mainindex");
		} else {
			AdminUser user1 = new AdminUser();

			int user_id = user.getAdminuser_id();//获取用户id
			user1.setAdminuser_id(user_id);//设置用户id

			String user_name = request.getParameter("user_name");//获取用户名称
			user1.setAdminuser_username(user_name);//设置用户名称

			String user_password = request.getParameter("user_password");//获取用户密码
			user1.setAdminuser_password(user_password);//设置用户密码

			int a = adminuserDao.updateUserInfo(user1);//修改用户信息

		}
		response.sendRedirect("frontuser");//跳转到用户个人信息页面
	}
	
	/**
	 * 用户订单页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/frontuserorder")
	public String frontuserorder(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回首页
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id
			
			//通过用户id查询用户订单
			List<Buy> buylist = buyDao.findBuysByAdminUserId(adminuser_id);

			model.addAttribute("buylist", buylist);

		}
		return "user_order.jsp";
	}
	
	/**
	 * 用户待发货订单页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/frontuserorderwait")
	public String frontuserorderwait(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回首页
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id
			
			//通过用户id查询用户订单
			List<Buy> buylist = buyDao.findBuysByAdminUserIdToWait(adminuser_id);

			model.addAttribute("buylist", buylist);

		}
		return "user_orderwait.jsp";
	}
	
	/**
	 * 用户待收货订单页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/frontuserordershouhuo")
	public String frontuserordershouhuo(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回首页
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id
			
			//通过用户id查询用户订单
			List<Buy> buylist = buyDao.findBuysByAdminUserIdToShouhuo(adminuser_id);

			model.addAttribute("buylist", buylist);

		}
		return "user_ordershouhuo.jsp";
	}
	
	/**
	 * 用户待评价单页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/frontuserorderpingjia")
	public String frontuserorderpingjia(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回首页
			response.sendRedirect("login.html");
		} else {
			int adminuser_id = user.getAdminuser_id();//获取用户id
			
			//通过用户id查询用户订单
			List<Buy> buylist = buyDao.findBuysByAdminUserIdToPingjia(adminuser_id);

			model.addAttribute("buylist", buylist);

		}
		return "user_orderpingjia.jsp";
	}
	
	/**
	 * 订单取消操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/front/buydelete")
	public String buydelete(String buyId, HttpServletRequest request, HttpServletResponse response) {
		buyDao.deleteBuy(Integer.parseInt(buyId));
		JSONObject resultJson = new JSONObject();
		resultJson.put("success", true);
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 确认收货操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/front/buyshouhuo")
	public String buyshouhuo(String buyId, HttpServletRequest request, HttpServletResponse response) {
		buyDao.updateBuyByIdToShouhuo(Integer.parseInt(buyId));
		JSONObject resultJson = new JSONObject();
		resultJson.put("success", true);
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 订单评价页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/frontuserevaluate")
	public String frontuserevaluate(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回首页
			response.sendRedirect("login.html");
		} else {
			
			int buy_id = Integer.parseInt(request.getParameter("buy_id"));//获取订单id
			
			//根据订单id查询订单信息
			List<Buy> buylist = buyDao.findBuysById(buy_id);
			Buy buy = buylist.get(0);
			model.addAttribute("buy", buy);
			
			int goods_id = Integer.parseInt(request.getParameter("goods_id"));//获取商品id
			
			//根据商品id查询商品信息
			List<Goods> goodslist = goodsDao.findGoodsById(goods_id);
			Goods goods = goodslist.get(0);
			model.addAttribute("goods", goods);

		}
		return "user_evaluate.jsp";
	}
	
	/**
	 * 用户提交评价操作
	 */
	@RequestMapping(value = "/front/userevaluatesave")
	public void userevaluatesave(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//第一部分：从session中获取用户对象
		HttpSession session = request.getSession();
		AdminUser user = (AdminUser) session.getAttribute("currentUser");
		if (user == null) {//该用户未登录，则返回用户中心
			response.sendRedirect("mainindex");
		} else {
			
			Goodsevaluate goodsevaluate = new Goodsevaluate();
			
			int adminuser_id = user.getAdminuser_id();//用户id
			goodsevaluate.setAdminuser_id(adminuser_id);//设置用户id
			
			int buy_id = Integer.parseInt(request.getParameter("buy_id"));//获取订单id
			
			int goods_id = Integer.parseInt(request.getParameter("goods_id"));//获取商品id
			goodsevaluate.setGoods_id(goods_id);//设置商品id
			
			int goodsevaluate_star = Integer.parseInt(request.getParameter("starcount"));//获取评价星级
			goodsevaluate.setGoodsevaluate_star(goodsevaluate_star);//设置星级
			
			String goodsevaluate_content = request.getParameter("goodsevaluate_content");//获取评价内容
			goodsevaluate.setGoodsevaluate_content(goodsevaluate_content);//设置评价内容
			
			//获取当前系统时间
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String goodsevaluate_addtime = formatter.format(date);
			goodsevaluate.setGoodsevaluate_addtime(goodsevaluate_addtime);//设置评价时间
			
			int a = goodsevaluateDao.addGoodsevaluate(goodsevaluate);//添加评价记录
			if (a > 0) {
				//评价成功，修改订单状态
				buyDao.updateBuyByIdToYpj(buy_id);
			}
			
		}
		response.sendRedirect("frontuserorder");//跳转到用户订单页面
	}
	
	/**
	 * 店铺页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/frontshop")
	public String frontshop(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		int shop_id = Integer.parseInt(request.getParameter("shop_id"));//获取店铺id
		
		//根据店铺id查询店铺信息
		List<Shop> shoplist = shopDao.findShopById(shop_id);
		Shop shop = new Shop();
		if (shoplist.size() > 0) {
			shop = shoplist.get(0);
		} else {
			shop = null;
		}
		model.addAttribute("shop", shop);
		
		//根据店铺id查询该店铺的商品列表
		List<Goods> goodslist = goodsDao.findGoodsByShopId(shop_id);
		
		model.addAttribute("goodslist", goodslist);
		return "shop.jsp";
	}
	
	/**
	 * 店铺页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front/fronttype")
	public String fronttype(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		int goodstype_id = Integer.parseInt(request.getParameter("goodstype_id"));//获取店铺id
		
		List<Goodstype> goodstypelist = goodstypeDao.findGoodstypeById(goodstype_id);
		Goodstype goodstype = goodstypelist.get(0);
		model.addAttribute("goodstype", goodstype);
		
		//根据店铺id查询该店铺的商品列表
		List<Goods> goodslist = goodsDao.findGoodsByGoodsTypeId(goodstype_id);
		
		model.addAttribute("goodslist", goodslist);
		return "classtype.jsp";
	}

/**
 * 搜索商品页面
 * @return
 * @throws IOException 
 * @throws Exception
 */
@RequestMapping(value = "/front/search")
public String search(String page, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
	//分页查询房屋列表
	if (StringUtil.isEmpty(page)) {
		page = "1";
	}
	PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
	List<Goods> goodslist = null;
	int total = 0;
	String type = request.getParameter("type");
	if (StringUtil.isNotEmpty(type)) {//为搜索
		if (type.equals("search")) {
			String searchvalue = request.getParameter("searchvalue");//获取查询内容

			goodslist = GoodsDao.findGoodsBySearchPageValue(searchvalue, pageBean);
			total = GoodsDao.GoodsCountBySearchValue(searchvalue);
			model.addAttribute("type", type);
		}
		if (goodslist.size() > 0) {
			model.addAttribute("searchresult", 1);
		} else {
			model.addAttribute("searchresult", 0);
		}
	} else {
		model.addAttribute("searchresult", 0);
	}
	String pageCode = PageUtil.genPaginationphone(request.getContextPath()
			+ "/front/search?1=1", total, Integer.parseInt(page), 10);
	model.addAttribute("pageCode", pageCode);
	model.addAttribute("total", total);
	model.addAttribute("goodslist", goodslist);

	return "search.jsp";
}
}




