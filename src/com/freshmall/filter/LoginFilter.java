package com.freshmall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.freshmall.model.AdminUser;

public class LoginFilter implements Filter {
	private FilterConfig config;

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)arg0;

		HttpServletResponse response=(HttpServletResponse)arg1;
		
		HttpSession session = request.getSession();
		
		// 从session里用户信息
		AdminUser currentAdminUser = (AdminUser) session.getAttribute("currentAdminUser");

		//获取初始化参数
		String para=config.getInitParameter("nofilterpath");

		if(request.getRequestURI().indexOf(".css")!=-1 
				|| request.getRequestURI().indexOf(".js")!=-1 
				|| request.getRequestURI().indexOf(".jpg")!=-1 
				|| request.getRequestURI().indexOf(".png")!=-1 
				|| request.getRequestURI().indexOf(".gif")!=-1 
				|| request.getRequestURI().indexOf("admin/login")!=-1 
				|| request.getRequestURI().indexOf("admin/login.html")!=-1 
				|| request.getRequestURI().indexOf("admin/image.jsp")!=-1 
				|| request.getRequestURI().indexOf("admin/loginAdmin")!=-1 
				|| request.getRequestURI().indexOf("admin/loginstudentAdmin")!=-1 
				|| request.getRequestURI().indexOf("admin/loginteacherAdmin")!=-1 
				|| request.getRequestURI().indexOf(".txt")!=-1 
				|| request.getRequestURI().indexOf(".eot")!=-1 
				|| request.getRequestURI().indexOf(".woff")!=-1 
				|| request.getRequestURI().indexOf(".woff2")!=-1 
				|| request.getRequestURI().indexOf(".ttf")!=-1 
				|| request.getRequestURI().indexOf(".svg")!=-1 
				|| request.getRequestURI().indexOf(".otf")!=-1 
			)
		{
			arg2.doFilter(arg0, arg1);
			return;
		}

		if(currentAdminUser == null || "".equals(currentAdminUser))
		{
			response.sendRedirect(request.getContextPath()+"/admin/login.html");
		}
		else
		{
			arg2.doFilter(arg0, arg1);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		config=arg0;
	}
}