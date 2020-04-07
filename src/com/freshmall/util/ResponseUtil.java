package com.freshmall.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


public class ResponseUtil {

	public static void write(Object o,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
	public static void write(String o,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
	public static void writeJson(HttpServletResponse respone, String result) {
		respone.setContentType("application/json;charset=utf-8");
		PrintWriter out;
		try {
			out = respone.getWriter();
			out.print(result);
			out.flush();
			out.close();
		} catch (Exception e) {
			//System.out.println("Comm_Util_writeJson---->" + e);
		}
	}
}
