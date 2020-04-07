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

import com.freshmall.dao.BuyDao;
import com.freshmall.model.Buy;
import com.freshmall.model.PageBean;
import com.freshmall.util.PageUtil;
import com.freshmall.util.ResponseUtil;
import com.freshmall.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * 订单控制类
 * @author gongwei
 *
 */
@Controller
public class BuyAction {
	@Resource
	private BuyDao buyDao;
	
	/**
	 * 订单列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/buylist")
	public String buylist(String page, String type, String searchType, String searchvalue, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		int total = 0;
		List<Buy> buylist = null;
		if (type != null) {
			if (type.equals("search")) {
				buylist = buyDao.findBuyBySearchPage(searchType, searchvalue, pageBean);
				total = buyDao.BuyCountBySearch(searchType, searchvalue);
			}
		} else {
			buylist = buyDao.findBuyByPage(null, pageBean);
			total = buyDao.BuyCount(null);
		}
		String pageCode = PageUtil.genPagination(request.getContextPath()
				+ "/admin/buylist?1=1", total, Integer.parseInt(page), 10);
		model.addAttribute("buylist", buylist);
		model.addAttribute("pageCode", pageCode);
		return "buy/buy_list.jsp";
	}
	
	/**
	 * 添加修改订单信息管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/buypreSave")
	public String buypreSave(Buy buy, String buyId, Model model, HttpServletRequest request, HttpServletResponse response) {
		String title;
		if (StringUtil.isNotEmpty(buyId)) {
			buy = buyDao.getBuyById(Integer.valueOf(buyId));
			model.addAttribute("buyId", buyId);
			model.addAttribute("buy", buy);
			title = "修改订单信息";
		} else {
			title = "新增订单信息";
		}
		model.addAttribute("title", title);
		return "buy/buy_add.jsp";
	}
	
	/**
	 * 订单添加修改操作实现
	 * @return
	 */
	/**
	 * 类型添加修改操作实现
	 * @return
	 */
	@RequestMapping(value = "/admin/buysave")
	public void buysave(String buyId, Buy buy, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		buy.setAdminuser_id(buy.getAdminuser_id());//设置用户id
		buy.setBuy_sn(buy.getBuy_sn());//设置订单编号
		buy.setBuy_price(buy.getBuy_price());//设置订单价格
		
		if(StringUtil.isNotEmpty(buyId)){
			buy.setBuy_id(Integer.parseInt(buyId));
			buyDao.updateBuy(buy);
		}else{
			buy.setBuy_status(1);//设置订单状态 1、未支付 2、已支付（处理中） 3、已完成
			if (buy.getAdminuser_username() != null) {
				buy.setAdminuser_username(buy.getAdminuser_username());//设置用户名称
			}
			if (buy.getAdminuser_iphone() != null) {
				buy.setAdminuser_iphone(buy.getAdminuser_iphone());//设置手机号码
			}
			if (buy.getBuy_content() != null) {
				buy.setBuy_content(buy.getBuy_content());//设置订单内容
			}
			if (buy.getBuy_message() != null) {
				buy.setBuy_message(buy.getBuy_message());//设置订单留言
			}
			if (buy.getBuy_address() != null) {
				buy.setBuy_address(buy.getBuy_address());//设置订单地址
			}
			
			//获取当前系统时间
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String buy_addtime = formatter.format(date);
			buy.setBuy_addtime(buy_addtime);//设置下单时间
			

			buyDao.addBuy(buy);
		}
		response.sendRedirect("buylist");//重定向到类型列表页面
	}
	
	/**
	 * 订单删除操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/buydelete")
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
	 * 商品发货操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/buysend")
	public String buysend(String buyId, HttpServletRequest request, HttpServletResponse response) {
		buyDao.updateBuyByIdToYfh(Integer.parseInt(buyId));
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
