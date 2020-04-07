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
import com.freshmall.model.PageBean;
import com.freshmall.util.GetIPUtil;
import com.freshmall.util.PageUtil;
import com.freshmall.util.ResponseUtil;
import com.freshmall.util.StringUtil;
import com.freshmall.dao.AdminUserDao;

import net.sf.json.JSONObject;

/**
 * 管理员控制类
 * @author gongwei
 *
 */
@Controller
public class AdminUserAction {
	@Resource
	private AdminUserDao adminuserDao;
	
	/**
	 * 登录页
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/login")
	public String login(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "login.html";
	}
	
	/**
	 * 后台管理员登陆
	 */
	@RequestMapping(value = "/admin/loginAdmin")
	public String loginAdmin(Model model, HttpServletRequest request, HttpServletResponse response) {
		JSONObject resultJson = new JSONObject();
		
		String adminuser_username = request.getParameter("adminuser_username");
		String adminuser_password = request.getParameter("adminuser_password");
		String imageCode = request.getParameter("imageCode");
		
		HttpSession session = request.getSession();
		String sesstionCode = (String) session.getAttribute("imageCode");
		
		if (StringUtil.isNotEmpty(sesstionCode)) {
			if (sesstionCode.equals(imageCode)) {
				AdminUser adminUser = adminuserDao.adminLogin(adminuser_username, adminuser_password);
				if (adminUser.getAdminuser_username() == null || adminUser.getAdminuser_username() == "") {
					resultJson.put("message", "用户名或密码错误");
					resultJson.put("result", "failthree");//用户名或密码错误
				} else if (adminUser.getAdminuser_status() == 2) {//用户被锁定了
					resultJson.put("message", "该用户已被锁定");
					resultJson.put("result", "failfour");//该用户已被锁定
				} else {
					//获取当前系统时间
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String adminuser_lastertime = formatter.format(date);
					
					String adminuser_lasterip = GetIPUtil.getIp(request);
					
					//根据管理员id修改该管理员的登陆时间和登陆IP
					adminuserDao.updateAdminUserLasterTimeAndLasterIp(adminUser.getAdminuser_id(), adminuser_lastertime,adminuser_lasterip);
					
					session.setAttribute("currentAdminUser", adminUser);
					//setMaxInactiveInterval设置的是当前会话的失效时间，不是整个web的时间，单位为以秒计算。如果设置的值为零或负数，则表示会话将永远不会超时。
					session.setMaxInactiveInterval(0);
					resultJson.put("message", "登录成功");
					resultJson.put("result", "success");//登录成功
				}
			} else {
				resultJson.put("message", "验证码错误");
				resultJson.put("result", "failtwo");//验证码错误
			}
		} else {
			resultJson.put("message", "系统繁忙，请稍后再试");
			resultJson.put("result", "failone");//系统繁忙，请稍后再试
		}
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 后台主界面
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/main")
	public String main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "main.jsp";
	}
	
	/**
	 * 管理员退出后台
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		String url = "login";
		response.sendRedirect(url);
	}

	/**
	 * 管理员列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/adminuserlist")
	public String adminuserlist(String page, String type, String searchType, String searchvalue, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		int total = 0;
		List<AdminUser> adminuserList = null;
		if (type != null) {
			if (type.equals("search")) {
				adminuserList = adminuserDao.findAdminUserBySearchPage(searchType, searchvalue, pageBean);
				total = adminuserDao.AdminUserCountBySearch(searchType, searchvalue);
			}
		} else {
			adminuserList = adminuserDao.findAdminUserByPage(null, pageBean);
			total = adminuserDao.AdminUserCount(null);
		}
		String pageCode = PageUtil.genPagination(request.getContextPath()
				+ "/admin/adminuserlist?1=1", total, Integer.parseInt(page), 10);
		model.addAttribute("adminuserList", adminuserList);
		model.addAttribute("pageCode", pageCode);
		return "adminuser/adminuser_list.jsp";
	}
	
	/**
	 * 添加修改管理员信息管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/adminuserpreSave")
	public String adminuserpreSave(AdminUser adminuser, String adminuserId, Model model, HttpServletRequest request, HttpServletResponse response) {
		String title;
		if (StringUtil.isNotEmpty(adminuserId)) {
			adminuser = adminuserDao.getAdminUserById(Integer.valueOf(adminuserId));
			model.addAttribute("adminuserId", adminuserId);
			model.addAttribute("adminuser", adminuser);
			title = "修改管理员信息";
		} else {
			title = "新增管理员信息";
		}
		int adminuser_sn_max = adminuserDao.getAdminUserSnToMax()+1;//获取最大的管理员编号，再加1赋值到管理员添加页面和修改页面
		model.addAttribute("adminuser_sn_max", adminuser_sn_max);
		model.addAttribute("title", title);
		return "adminuser/adminuser_add.jsp";
	}
	
	/**
	 * 管理员添加修改操作实现
	 * @return
	 */
	@RequestMapping(value = "/admin/adminusersave")
	public void adminusersave(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject resultJson = new JSONObject();
		AdminUser adminuser = new AdminUser();
		String adminuser_sn = request.getParameter("adminuser_sn");//获取用户编号
		adminuser.setAdminuser_sn(adminuser_sn);//设置用户编号
		
		String adminuser_username = request.getParameter("adminuser_username");//获取用户名姓名
		
		adminuser.setAdminuser_username(adminuser_username);//设置管理员姓名
		
		String adminuser_password = request.getParameter("adminuser_password");//获取管理员密码
		adminuser.setAdminuser_password(adminuser_password);//设置用户密码
		
		String adminuser_iphone = request.getParameter("adminuser_iphone");//获取管理员手机号码
		adminuser.setAdminuser_iphone(adminuser_iphone);//设置管理员手机号码
		
		String adminuser_email = request.getParameter("adminuser_email");//获取管理员电子邮箱
		adminuser.setAdminuser_email(adminuser_email);//设置管理员电子邮箱
		
		//获取当前系统时间
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String adminuser_registertime = formatter.format(date);
		adminuser.setAdminuser_registertime(adminuser_registertime);//设置管理员添加时间
		
		adminuser.setAdminuser_status(1);//设置管理员的状态为正常
		
		adminuser.setRole_id(1);//设置用户角色 1、管理员 2、用户
		
		String adminuserId = request.getParameter("adminuserId");//获取管理员id
		if (StringUtil.isNotEmpty(adminuserId)) {//不为空，则是修改管理员信息
			adminuser.setAdminuser_id(Integer.parseInt(adminuserId));//设置管理员id
			int a = adminuserDao.updateAdminUser(adminuser);
			if (a > 0) {
				resultJson.put("result", "successone");//修改管理员信息成功
			} else {
				resultJson.put("result", "failtwo");//修改管理员信息失败
			}
		} else {
			//根据用户名查询用户是否存在
			List<AdminUser> adminuserlist = adminuserDao.findAdminUserByAdminusername(adminuser_username);
			if (adminuserlist.size() > 0) {
				resultJson.put("result", "failone");//用户名已存在
			} else {
				int a = adminuserDao.addAdminUser(adminuser);
				if (a > 0) {
					resultJson.put("result", "successtwo");//添加管理员信息成功
				} else {
					resultJson.put("result", "failthree");//添加管理员信息失败
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
	 * 用户删除操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/adminuserdelete")
	public String adminuserdelete(String adminuserId, HttpServletRequest request, HttpServletResponse response) {
		adminuserDao.deleteAdminUser(Integer.parseInt(adminuserId));
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
	 * 设置用户为锁定状态
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/updateadminusertoclose")
	public String updateadminusertoclose(Model model,String adminuser_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject resultJson = new JSONObject();

		int a = adminuserDao.updateadminusertoclose(Integer.parseInt(adminuser_id));

		if (a > 0) {
			resultJson.put("result", "success");
		} else {
			resultJson.put("result", "fail");
		}

		ResponseUtil.write(resultJson, response);
		return null;
	}
	
	/**
	 * 设置用户为解锁状态
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/updateadminusertoopen")
	public String updateadminusertoopen(Model model,String adminuser_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject resultJson = new JSONObject();

		int a = adminuserDao.updateadminusertoopen(Integer.parseInt(adminuser_id));

		if (a > 0) {
			resultJson.put("result", "success");
		} else {
			resultJson.put("result", "fail");
		}

		ResponseUtil.write(resultJson, response);
		return null;
	}
	
	/**
	 * 修改管理员密码页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/adminuserupdatepassword")
	public String adminuserupdatepassword(String adminuserId, Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		AdminUser adminUser = (AdminUser) session.getAttribute("currentAdminUser");
		AdminUser adminuser = adminuserDao.getAdminUserById(adminUser.getAdminuser_id());//获取管理员对象
		model.addAttribute("adminuser", adminuser);
		return "adminuser/update_password.jsp";
	}
	
	/**
	 * 修改管理员密码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/updateadminuserpassowrd")
	public String updateadminuserpassowrd(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject resultJson = new JSONObject();
		String adminuser_id = request.getParameter("adminuser_id");
		
		String older_password = request.getParameter("older_password");
		
		String new_password = request.getParameter("new_password");

		//根据管理员id和原密码查询该管理员原密码是否正确
		List<AdminUser> adminuserlist = adminuserDao.findOlderPasswordByAdminuserId(Integer.parseInt(adminuser_id), older_password);
		if (adminuserlist.size() > 0) {//原密码正确
			int a = adminuserDao.updateadminuserpassword(Integer.parseInt(adminuser_id),new_password);
			if (a > 0) {
				resultJson.put("result", "success");
			} else {
				resultJson.put("result", "updatefalse");
			}
		} else {
			resultJson.put("result", "false");
		}
		ResponseUtil.write(resultJson, response);
		return null;
	}
	
	/**
	 * 用户列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/userlist")
	public String userlist(String page, String type, String searchType, String searchvalue, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		int total = 0;
		List<AdminUser> adminuserList = null;
		if (type != null) {
			if (type.equals("search")) {
				adminuserList = adminuserDao.findUserBySearchPage(searchType, searchvalue, pageBean);
				total = adminuserDao.UserCountBySearch(searchType, searchvalue);
			}
		} else {
			adminuserList = adminuserDao.findUserByPage(null, pageBean);
			total = adminuserDao.UserCount(null);
		}
		String pageCode = PageUtil.genPagination(request.getContextPath()
				+ "/admin/userlist?1=1", total, Integer.parseInt(page), 10);
		model.addAttribute("adminuserList", adminuserList);
		model.addAttribute("pageCode", pageCode);
		return "adminuser/user_list.jsp";
	}
	
	/**
	 * 添加修改用户信息管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/userpreSave")
	public String userpreSave(AdminUser adminuser, String adminuserId, Model model, HttpServletRequest request, HttpServletResponse response) {
		String title;
		if (StringUtil.isNotEmpty(adminuserId)) {
			adminuser = adminuserDao.getAdminUserById(Integer.valueOf(adminuserId));
			model.addAttribute("adminuserId", adminuserId);
			model.addAttribute("adminuser", adminuser);
			title = "修改用户信息";
		} else {
			title = "新增用户信息";
		}
		int adminuser_sn_max = adminuserDao.getAdminUserSnToMax()+1;//获取最大的管理员编号，再加1赋值到管理员添加页面和修改页面
		model.addAttribute("adminuser_sn_max", adminuser_sn_max);
		model.addAttribute("title", title);
		return "adminuser/user_add.jsp";
	}
	
	/**
	 * 用户添加修改操作实现
	 * @return
	 */
	@RequestMapping(value = "/admin/usersave")
	public void usersave(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject resultJson = new JSONObject();
		AdminUser adminuser = new AdminUser();
		String adminuser_sn = request.getParameter("adminuser_sn");//获取用户编号
		adminuser.setAdminuser_sn(adminuser_sn);//设置用户编号
		
		String adminuser_username = request.getParameter("adminuser_username");//获取用户名姓名
		
		adminuser.setAdminuser_username(adminuser_username);//设置管理员姓名
		
		String adminuser_password = request.getParameter("adminuser_password");//获取管理员密码
		adminuser.setAdminuser_password(adminuser_password);//设置用户密码
		
		String adminuser_iphone = request.getParameter("adminuser_iphone");//获取管理员手机号码
		adminuser.setAdminuser_iphone(adminuser_iphone);//设置管理员手机号码
		
		String adminuser_email = request.getParameter("adminuser_email");//获取管理员电子邮箱
		adminuser.setAdminuser_email(adminuser_email);//设置管理员电子邮箱
		
		//获取当前系统时间
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String adminuser_registertime = formatter.format(date);
		adminuser.setAdminuser_registertime(adminuser_registertime);//设置管理员添加时间
		
		adminuser.setAdminuser_status(1);//设置管理员的状态为正常
		
		adminuser.setRole_id(2);//设置用户角色 1、管理员 2、用户
		
		String adminuserId = request.getParameter("adminuserId");//获取管理员id
		if (StringUtil.isNotEmpty(adminuserId)) {//不为空，则是修改管理员信息
			adminuser.setAdminuser_id(Integer.parseInt(adminuserId));//设置管理员id
			int a = adminuserDao.updateAdminUser(adminuser);
			if (a > 0) {
				resultJson.put("result", "successone");//修改管理员信息成功
			} else {
				resultJson.put("result", "failtwo");//修改管理员信息失败
			}
		} else {
			//根据用户名查询用户是否存在
			List<AdminUser> adminuserlist = adminuserDao.findAdminUserByAdminusername(adminuser_username);
			if (adminuserlist.size() > 0) {
				resultJson.put("result", "failone");//用户名已存在
			} else {
				int a = adminuserDao.addAdminUser(adminuser);
				if (a > 0) {
					resultJson.put("result", "successtwo");//添加管理员信息成功
				} else {
					resultJson.put("result", "failthree");//添加管理员信息失败
				}	
			}
		}
		try {
			ResponseUtil.write(resultJson, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
