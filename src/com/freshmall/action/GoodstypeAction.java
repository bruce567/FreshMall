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

import com.freshmall.dao.GoodstypeDao;
import com.freshmall.model.PageBean;
import com.freshmall.model.Goodstype;
import com.freshmall.util.PageUtil;
import com.freshmall.util.ResponseUtil;
import com.freshmall.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * 商品类型控制类
 * @author gongwei
 *
 */
@Controller
public class GoodstypeAction {
	@Resource
	private GoodstypeDao goodstypeDao;
	
	/**
	 * 商品类型列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/goodstypelist")
	public String goodstypelist(String page, String type, String searchType, String searchvalue, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		int total = 0;
		List<Goodstype> goodstypelist = null;
		goodstypelist = goodstypeDao.findGoodstypeByPage(null, pageBean);
		total = goodstypeDao.GoodstypeCount(null);
		String pageCode = PageUtil.genPagination(request.getContextPath()
				+ "/admin/goodstypelist?1=1", total, Integer.parseInt(page), 10);
		model.addAttribute("goodstypelist", goodstypelist);
		model.addAttribute("pageCode", pageCode);
		return "goodstype/goodstype_list.jsp";
	}
	
	/**
	 * 添加修改商品类型信息管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/goodstypepreSave")
	public String goodstypepreSave(Goodstype goodstype, String goodstypeId, Model model, HttpServletRequest request, HttpServletResponse response) {
		String title;
		if (StringUtil.isNotEmpty(goodstypeId)) {
			goodstype = goodstypeDao.getGoodstypeById(Integer.valueOf(goodstypeId));
			model.addAttribute("goodstypeId", goodstypeId);
			title = "修改商品类型";
		} else {
			title = "新增商品类型";
		}
		model.addAttribute("title", title);
		model.addAttribute("goodstype", goodstype);
		return "goodstype/goodstype_add.jsp";
	}
	
	/**
	 * 商品类型添加修改操作实现
	 * @return
	 */
	@RequestMapping(value = "/admin/goodstypesave")
	public void goodstypesave(String goodstypeId, Goodstype goodstype, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(StringUtil.isNotEmpty(goodstypeId)){
			goodstype.setGoodstype_id(Integer.parseInt(goodstypeId));
			goodstypeDao.updateGoodstype(goodstype);
		}else{
			if (goodstype.getGoodstype_name() != null) {
				goodstype.setGoodstype_name(goodstype.getGoodstype_name());//设置商品类型名称
			}
			goodstypeDao.addGoodstype(goodstype);
		}
		response.sendRedirect("goodstypelist");//重定向到商品类型列表页面
	}

	/**
	 * 商品类型删除操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/goodstypedelete")
	public String goodstypedelete(String goodstypeId, HttpServletRequest request, HttpServletResponse response) {
		goodstypeDao.deleteGoodstype(Integer.parseInt(goodstypeId));
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
