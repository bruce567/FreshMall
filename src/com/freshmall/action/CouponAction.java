package com.freshmall.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshmall.dao.CouponDao;
import com.freshmall.dao.ShopDao;
import com.freshmall.model.Coupon;
import com.freshmall.model.PageBean;
import com.freshmall.model.Shop;
import com.freshmall.util.PageUtil;
import com.freshmall.util.ResponseUtil;
import com.freshmall.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * 优惠券控制类
 * @author gongwei
 *
 */
@Controller
public class CouponAction {
	@Resource
	private CouponDao couponDao;
	@Resource
	private ShopDao shopDao;
	
	/**
	 * 优惠券列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/couponlist")
	public String couponlist(String page, String type, String searchType, String searchvalue, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		int total = 0;
		List<Coupon> couponlist = null;
		if (type != null) {
			if (type.equals("search")) {
				couponlist = couponDao.findCouponBySearchPage(searchType, searchvalue, pageBean);
				total = couponDao.CouponCountBySearch(searchType, searchvalue);
			}
		} else {
			couponlist = couponDao.findCouponByPage(null, pageBean);
			total = couponDao.CouponCount(null);
		}
		String pageCode = PageUtil.genPagination(request.getContextPath()
				+ "/admin/couponlist?1=1", total, Integer.parseInt(page), 10);
		model.addAttribute("couponlist", couponlist);
		model.addAttribute("pageCode", pageCode);
		return "coupon/coupon_list.jsp";
	}
	
	/**
	 * 添加修改优惠券信息管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/couponpreSave")
	public String couponpreSave(Coupon coupon, String couponId, Model model, HttpServletRequest request, HttpServletResponse response) {
		String title;
		if (StringUtil.isNotEmpty(couponId)) {
			coupon = couponDao.getCouponById(Integer.valueOf(couponId));
			model.addAttribute("couponId", couponId);
			model.addAttribute("coupon", coupon);
			title = "修改优惠券信息";
		} else {
			title = "新增优惠券信息";
		}
		List<Shop> shoplist = shopDao.findShop(null);
		model.addAttribute("shoplist", shoplist);
		model.addAttribute("title", title);
		return "coupon/coupon_add.jsp";
	}
	
	/**
	 * 优惠券添加修改操作实现
	 * @return
	 */
	/**
	 * 类型添加修改操作实现
	 * @return
	 */
	@RequestMapping(value = "/admin/couponsave")
	public void couponsave(String couponId, Coupon coupon, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		int coupon_type = coupon.getCoupon_type();//获取优惠券类型
		coupon.setCoupon_type(coupon.getCoupon_type());//设置优惠券类型
		if (coupon_type == 1) {//商家优惠券
			coupon.setShop_id(0);//设置店铺id
			coupon.setShop_name("平台");
		} else {//店铺优惠券
			int shop_id = coupon.getShop_id();
			
			coupon.setShop_id(coupon.getShop_id());//设置店铺id
			//根据店铺id查询
			List<Shop> shoplist = shopDao.findShopById(shop_id);
			Shop shop = shoplist.get(0);
			String shop_name = shop.getShop_name();//获取店铺名称
			coupon.setShop_name(shop_name);//设置店铺名称
			
		}
		
		if(StringUtil.isNotEmpty(couponId)){
			coupon.setCoupon_id(Integer.parseInt(couponId));
			couponDao.updateCoupon(coupon);
		}else{
			if (coupon.getCoupon_name() != null) {
				coupon.setCoupon_name(coupon.getCoupon_name());//设置类型名称
			}
			coupon.setCoupon_num(coupon.getCoupon_num());//设置优惠券数量
			if (coupon.getCoupon_price() != null) {
				coupon.setCoupon_price(coupon.getCoupon_price());//设置优惠券价格
			}
			if (coupon.getCoupon_endtime() != null) {
				coupon.setCoupon_endtime(coupon.getCoupon_endtime());//设置优惠券截止日期
			}

			couponDao.addCoupon(coupon);
		}
		response.sendRedirect("couponlist");//重定向到类型列表页面
	}
	
	/**
	 * 优惠券删除操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/coupondelete")
	public String coupondelete(String couponId, HttpServletRequest request, HttpServletResponse response) {
		couponDao.deleteCoupon(Integer.parseInt(couponId));
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
