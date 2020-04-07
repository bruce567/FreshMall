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

import com.freshmall.dao.GoodsDao;
import com.freshmall.dao.GoodstypeDao;
import com.freshmall.dao.ShopDao;
import com.freshmall.model.Goods;
import com.freshmall.model.Goodstype;
import com.freshmall.model.PageBean;
import com.freshmall.model.Shop;
import com.freshmall.util.PageUtil;
import com.freshmall.util.ResponseUtil;
import com.freshmall.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * 商品控制类
 * @author gongwei
 *
 */
@Controller
public class GoodsAction {
	@Resource
	private GoodsDao goodsDao;
	@Resource
	private GoodstypeDao goodstypeDao;
	@Resource
	private ShopDao shopDao;
	
	/**
	 * 商品列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/goodslist")
	public String goodslist(String page, String type, String searchType, String searchvalue, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		int total = 0;
		List<Goods> goodslist = null;
		if (type != null) {
			if (type.equals("search")) {
				goodslist = goodsDao.findGoodsBySearchPage(searchType, searchvalue, pageBean);
				total = goodsDao.GoodsCountBySearch(searchType, searchvalue);
			}
		} else {
			goodslist = goodsDao.findGoodsByPage(null, pageBean);
			total = goodsDao.GoodsCount(null);
		}
		String pageCode = PageUtil.genPagination(request.getContextPath()
				+ "/admin/goodslist?1=1", total, Integer.parseInt(page), 10);
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("pageCode", pageCode);
		return "goods/goods_list.jsp";
	}
	
	/**
	 * 添加修改商品信息管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/goodspreSave")
	public String goodspreSave(Goods goods, String goodsId, Model model, HttpServletRequest request, HttpServletResponse response) {
		String title;
		if (StringUtil.isNotEmpty(goodsId)) {
			goods = goodsDao.getGoodsById(Integer.valueOf(goodsId));
			model.addAttribute("goodsId", goodsId);
			model.addAttribute("goods", goods);
			title = "修改商品信息";
		} else {
			title = "新增商品信息";
		}
		List<Goodstype> goodstypelist = goodstypeDao.findGoodstype(null);
		model.addAttribute("goodstypelist", goodstypelist);
		List<Shop> shoplist = shopDao.findShop(null);
		model.addAttribute("shoplist", shoplist);
		model.addAttribute("title", title);
		return "goods/goods_add.jsp";
	}
	
	/**
	 * 商品添加修改操作实现
	 * @return
	 */
	/**
	 * 类型添加修改操作实现
	 * @return
	 */
	@RequestMapping(value = "/admin/goodssave")
	public void goodssave(String goodsId, Goods goods, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		goods.setGoodstype_id(goods.getGoodstype_id());//设置类型id
		goods.setGoods_promote(goods.getGoods_promote());//设置促销类型
		if(StringUtil.isNotEmpty(goodsId)){
			goods.setGoods_id(Integer.parseInt(goodsId));
			goodsDao.updateGoods(goods);
		}else{
			if (goods.getGoods_name() != null) {
				goods.setGoods_name(goods.getGoods_name());//设置类型名称
			}
			if (goods.getGoods_images() != null) {
				goods.setGoods_images(goods.getGoods_images());//设置商品图片
			}
			if (goods.getGoods_price() != null) {
				goods.setGoods_price(goods.getGoods_price());//设置商品价格
			}
			if (goods.getGoods_content() != null) {
				goods.setGoods_content(goods.getGoods_content());//设置商品介绍
			}

			goodsDao.addGoods(goods);
		}
		response.sendRedirect("goodslist");//重定向到类型列表页面
	}
	
	/**
	 * 商品删除操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/goodsdelete")
	public String goodsdelete(String goodsId, HttpServletRequest request, HttpServletResponse response) {
		goodsDao.deleteGoods(Integer.parseInt(goodsId));
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
	 * 现时抢购商品列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/goodslimittimelist")
	public String goodslimittimelist(String page, String type, String searchType, String searchvalue, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		int total = 0;
		List<Goods> goodslist = null;
		if (type != null) {
			if (type.equals("search")) {
				goodslist = goodsDao.findGoodsLimittimeBySearchPage(searchType, searchvalue, pageBean);
				total = goodsDao.GoodsCountLimittimeBySearch(searchType, searchvalue);
			}
		} else {
			goodslist = goodsDao.findGoodsLimittimeByPage(null, pageBean);
			total = goodsDao.GoodsCountLimittime(null);
		}
		String pageCode = PageUtil.genPagination(request.getContextPath()
				+ "/admin/goodslimittimelist?1=1", total, Integer.parseInt(page), 10);
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("pageCode", pageCode);
		return "goods/goodslimittime_list.jsp";
	}
	
	/**
	 * 添加修改限时抢购商品信息管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/goodslimittimepreSave")
	public String goodslimittimepreSave(Goods goods, String goodsId, Model model, HttpServletRequest request, HttpServletResponse response) {
		String title;
		if (StringUtil.isNotEmpty(goodsId)) {
			goods = goodsDao.getGoodsById(Integer.valueOf(goodsId));
			model.addAttribute("goodsId", goodsId);
			model.addAttribute("goods", goods);
			title = "修改限时抢购商品信息";
		} else {
			title = "新增限时抢购商品信息";
		}
		List<Goodstype> goodstypelist = goodstypeDao.findGoodstype(null);
		model.addAttribute("goodstypelist", goodstypelist);
		List<Shop> shoplist = shopDao.findShop(null);
		model.addAttribute("shoplist", shoplist);
		model.addAttribute("title", title);
		return "goods/goodslimittime_add.jsp";
	}
	
	/**
	 * 限时抢购商品添加修改操作实现
	 * @return
	 */
	/**
	 * 类型添加修改操作实现
	 * @return
	 */
	@RequestMapping(value = "/admin/goodslimittimesave")
	public void goodslimittimesave(String goodsId, Goods goods, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		goods.setGoodstype_id(goods.getGoodstype_id());//设置类型id
		goods.setGoods_promote(goods.getGoods_promote());//设置促销类型
		if(StringUtil.isNotEmpty(goodsId)){
			goods.setGoods_id(Integer.parseInt(goodsId));
			goodsDao.updateGoods(goods);
		}else{
			if (goods.getGoods_name() != null) {
				goods.setGoods_name(goods.getGoods_name());//设置类型名称
			}
			if (goods.getGoods_images() != null) {
				goods.setGoods_images(goods.getGoods_images());//设置商品图片
			}
			if (goods.getGoods_price() != null) {
				goods.setGoods_price(goods.getGoods_price());//设置商品价格
			}
			if (goods.getGoods_content() != null) {
				goods.setGoods_content(goods.getGoods_content());//设置商品介绍
			}
			if (goods.getGoods_starttime() != null) {
				goods.setGoods_starttime(goods.getGoods_starttime());//设置开始时间
			}
			if (goods.getGoods_endtime() != null) {
				goods.setGoods_endtime(goods.getGoods_endtime());//设置结束时间
			}
			
			goodsDao.addGoods(goods);
		}
		response.sendRedirect("goodslimittimelist");//重定向到类型列表页面
	}
}
