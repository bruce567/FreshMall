package com.freshmall.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshmall.dao.CartDao;
import com.freshmall.model.Cart;
import com.freshmall.model.PageBean;
import com.freshmall.util.PageUtil;
import com.freshmall.util.ResponseUtil;
import com.freshmall.util.StringUtil;

import net.sf.json.JSONObject;
/**
 * 购物车控制类
 * @author gongwei
 *
 */
@Controller
public class CartAction {
	@Resource
	private CartDao cartDao;
	
	/**
	 * 购物车列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/cartlist")
	public String cartlist(String page, String type, String searchType, String searchvalue, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		int total = 0;
		List<Cart> cartlist = null;
		if (type != null) {
			if (type.equals("search")) {
				cartlist = cartDao.findCartBySearchPage(searchType, searchvalue, pageBean);
				total = cartDao.CartCountBySearch(searchType, searchvalue);
			}
		} else {
			cartlist = cartDao.findCartByPage(null, pageBean);
			total = cartDao.CartCount(null);
		}
		String pageCode = PageUtil.genPagination(request.getContextPath()
				+ "/admin/cartlist?1=1", total, Integer.parseInt(page), 10);
		model.addAttribute("cartlist", cartlist);
		model.addAttribute("pageCode", pageCode);
		return "cart/cart_list.jsp";
	}
	
	/**
	 * 添加修改购物车信息管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/cartpreSave")
	public String cartpreSave(Cart cart, String cartId, Model model, HttpServletRequest request, HttpServletResponse response) {
		String title;
		if (StringUtil.isNotEmpty(cartId)) {
			cart = cartDao.getCartById(Integer.valueOf(cartId));
			model.addAttribute("cartId", cartId);
			model.addAttribute("cart", cart);
			title = "修改购物车信息";
		} else {
			title = "新增购物车信息";
		}
		model.addAttribute("title", title);
		return "cart/cart_add.jsp";
	}
	
	/**
	 * 购物车添加修改操作实现
	 * @return
	 */
	/**
	 * 类型添加修改操作实现
	 * @return
	 */
	@RequestMapping(value = "/admin/cartsave")
	public void cartsave(String cartId, Cart cart, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		cart.setAdminuser_id(cart.getAdminuser_id());//设置用户id
		cart.setGoods_id(cart.getGoods_id());//设置商品id
		if(StringUtil.isNotEmpty(cartId)){
			cart.setCart_id(Integer.parseInt(cartId));
			cartDao.updateCart(cart);
		}else{
			cart.setCart_addnum(cart.getCart_addnum());//设置添加数量
			
			//获取当前系统时间
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String cart_addtime = formatter.format(date);
			
			cart.setCart_addtime(cart_addtime);//设置添加时间

			cartDao.addCart(cart);
		}
		response.sendRedirect("cartlist");//重定向到类型列表页面
	}
	
	/**
	 * 购物车删除操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/cartdelete")
	public String cartdelete(String cartId, HttpServletRequest request, HttpServletResponse response) {
		cartDao.deleteCart(Integer.parseInt(cartId));
		JSONObject resultJson = new JSONObject();
		resultJson.put("success", true);
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
