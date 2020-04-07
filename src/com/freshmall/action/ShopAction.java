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

import com.freshmall.dao.ShopDao;
import com.freshmall.model.Shop;
import com.freshmall.model.PageBean;
import com.freshmall.util.PageUtil;
import com.freshmall.util.ResponseUtil;
import com.freshmall.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * 店铺控制类
 * @author gongwei
 *
 */
@Controller
public class ShopAction {
	@Resource
	private ShopDao shopDao;
	
	/**
	 * 店铺列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/shoplist")
	public String shoplist(String page, String type, String searchType, String searchvalue, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		int total = 0;
		List<Shop> shoplist = null;
		shoplist = shopDao.findShopByPage(null, pageBean);
		total = shopDao.ShopCount(null);
		String pageCode = PageUtil.genPagination(request.getContextPath()
				+ "/admin/shoplist?1=1", total, Integer.parseInt(page), 10);
		model.addAttribute("shoplist", shoplist);
		model.addAttribute("pageCode", pageCode);
		return "shop/shop_list.jsp";
	}
	
	/**
	 * 添加修改店铺信息管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/shoppreSave")
	public String shoppreSave(Shop shop, String shopId, Model model, HttpServletRequest request, HttpServletResponse response) {
		String title;
		if (StringUtil.isNotEmpty(shopId)) {
			shop = shopDao.getShopById(Integer.valueOf(shopId));
			model.addAttribute("shopId", shopId);
			title = "修改店铺";
		} else {
			title = "新增店铺";
		}
		model.addAttribute("title", title);
		model.addAttribute("shop", shop);
		return "shop/shop_add.jsp";
	}
	
	/**
	 * 店铺添加修改操作实现
	 * @return
	 */
	@RequestMapping(value = "/admin/shopsave")
	public void shopsave(String shopId, Shop shop, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(StringUtil.isNotEmpty(shopId)){
			shop.setShop_id(Integer.parseInt(shopId));
			shopDao.updateShop(shop);
		}else{
			if (shop.getShop_name() != null) {
				shop.setShop_name(shop.getShop_name());//设置店铺名称
			}
			if (shop.getShop_images() != null) {
				shop.setShop_images(shop.getShop_images());//设置店铺图片
			}
			if (shop.getShop_content() != null) {
				shop.setShop_content(shop.getShop_content());//设置店铺介绍
			}
			if (shop.getShop_opentime() != null) {
				shop.setShop_opentime(shop.getShop_opentime());//设置营业时间
			}
			if (shop.getShop_address() != null) {
				shop.setShop_address(shop.getShop_address());//设置店铺地址
			}
			if (shop.getShop_iphone() != null) {
				shop.setShop_iphone(shop.getShop_iphone());//设置联系电话
			}
			//获取当前系统时间
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String shop_addtime = formatter.format(date);
			shop.setShop_addtime(shop_addtime);//设置添加时间
			shopDao.addShop(shop);
		}
		response.sendRedirect("shoplist");//重定向到店铺列表页面
	}

	/**
	 * 店铺删除操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/shopdelete")
	public String shopdelete(String shopId, HttpServletRequest request, HttpServletResponse response) {
		shopDao.deleteShop(Integer.parseInt(shopId));
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
