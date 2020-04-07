package com.freshmall.util;

/**
 * 底部分页模板
 * 
 * @author gongwei
 * 
 */
public class PageUtil {
	/**
	 * 底部分页模板的公共方法
	 * 
	 * @param targetUrl 查询的路径
	 *            
	 * @param totalNum 总记录数
	 *           
	 * @param currentPage 当前页
	 *            
	 * @param pageSize  每页大小
	 *           
	 * @return
	 */
	public static String genPagination(String targetUrl, int totalNum,
			int currentPage, int pageSize) {
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize
				: totalNum / pageSize + 1;
		StringBuffer pageCode = new StringBuffer();
		pageCode.append("<li><span>总共有<font style='color:#3bbfb4'>"+totalPage+"</font>页&nbsp;&nbsp;有<font style='color:#3bbfb4'>"+totalNum+"</font>条记录</span><a target='_self' href='" + targetUrl + "&page=1'>首页</a></li>");
		if (currentPage == 1) {
			pageCode.append("<li class='disabled'><a target='_self' href='#'>上一页</a></li>");
		} else {
			pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
					+ (currentPage - 1) + "'>上一页</a></li>");
		}
		for (int i = currentPage - 10; i <= currentPage + 10; i++) {
			if (i < 1 || i > totalPage) {
				continue;
			}
			if (i == currentPage) {
				pageCode.append("<li class='actives'><a target='_self' href='#'>" + i
						+ "</a></li>");
			} else {
				pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + i
						+ "'>" + i + "</a></li>");
			}
		}
		if (currentPage == totalPage) {
			pageCode.append("<li class='disabled'><a target='_self' href='#'>下一页</a></li>");
		} else {
			pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
					+ (currentPage + 1) + "'>下一页</a></li>");
		}
		if (totalPage == 0) {
			totalPage = 1;
		}
		pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + totalPage
				+ "'>尾页</a></li>");
		return pageCode.toString();
	}
	
	/**
	 * PC前端底部分页模板的公共方法
	 * 
	 * @param targetUrl 查询的路径
	 *            
	 * @param totalNum 总记录数
	 *           
	 * @param currentPage 当前页
	 *            
	 * @param pageSize  每页大小
	 *           
	 * @return
	 */
	public static String genPaginationphone(String targetUrl, int totalNum,
			int currentPage, int pageSize) {
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize
				: totalNum / pageSize + 1;
		StringBuffer pageCode = new StringBuffer();
		pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=1'>首页</a></li>");
		if (currentPage == 1) {
			pageCode.append("<li class='disabled'><a target='_self' href='#'>上一页</a></li>");
		} else {
			pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
					+ (currentPage - 1) + "'>上一页</a></li>");
		}
		for (int i = currentPage - 10; i <= currentPage + 10; i++) {
			if (i < 1 || i > totalPage) {
				continue;
			}
			if (i == currentPage) {
				pageCode.append("<li class='active'><a target='_self' href='#'>" + i
						+ "</a></li>");
			} else {
				pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + i
						+ "'>" + i + "</a></li>");
			}
		}
		if (currentPage == totalPage) {
			pageCode.append("<li class='disabled'><a target='_self' href='#'>下一页</a></li>");
		} else {
			pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
					+ (currentPage + 1) + "'>下一页</a></li>");
		}
		if (totalPage == 0) {
			totalPage = 1;
		}
		pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + totalPage
				+ "'>尾页</a></li>");
		return pageCode.toString();
	}

	/**
	 * PC前端底部分页模板的公共方法
	 * 
	 * @param targetUrl 查询的路径
	 *            
	 * @param totalNum 总记录数
	 *           
	 * @param currentPage 当前页
	 *            
	 * @param pageSize  每页大小
	 *           
	 * @return
	 */
	//	public static String genPaginationfront(String targetUrl, int totalNum,
	//			int currentPage, int pageSize) {
	//		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize
	//				: totalNum / pageSize + 1;
	//		StringBuffer pageCode = new StringBuffer();
	//		pageCode.append("<li><span>总共有<font style='color:#f83131'>"+totalPage+"</font>页&nbsp;&nbsp;有<font style='color:#f83131'>"+totalNum+"</font>条记录</span><a target='_self' href='" + targetUrl + "&page=1'>首页</a></li>");
	//		if (currentPage == 1) {
	//			pageCode.append("<li class='disabled'><a target='_self' href='#'>上一页</a></li>");
	//		} else {
	//			pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
	//					+ (currentPage - 1) + "'>上一页</a></li>");
	//		}
	//		for (int i = currentPage - 10; i <= currentPage + 10; i++) {
	//			if (i < 1 || i > totalPage) {
	//				continue;
	//			}
	//			if (i == currentPage) {
	//				pageCode.append("<li class='actives'><a target='_self' href='#'>" + i
	//						+ "</a></li>");
	//			} else {
	//				pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + i
	//						+ "'>" + i + "</a></li>");
	//			}
	//		}
	//		if (currentPage == totalPage) {
	//			pageCode.append("<li class='disabled'><a target='_self' href='#'>下一页</a></li>");
	//		} else {
	//			pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
	//					+ (currentPage + 1) + "'>下一页</a></li>");
	//		}
	//		if (totalPage == 0) {
	//			totalPage = 1;
	//		}
	//		pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + totalPage
	//				+ "'>尾页</a></li>");
	//		return pageCode.toString();
	//	}

	/**
	 * PC前端底部分页模板的公共方法
	 * 
	 * @param targetUrl 查询的路径
	 *            
	 * @param totalNum 总记录数
	 *           
	 * @param currentPage 当前页
	 *            
	 * @param pageSize  每页大小
	 *           
	 * @return
	 */
	 public static String genPaginationfront(String targetUrl, int totalNum,
			 int currentPage, int pageSize) {
		 int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize
				 : totalNum / pageSize + 1;
		 StringBuffer pageCode = new StringBuffer();
		 pageCode.append("<li><span>总共有<font style='color:#979a9a'>"+totalPage+"</font>页&nbsp;&nbsp;有<font style='color:#979a9a'>"+totalNum+"</font>条记录</span><a target='_self' href='" + targetUrl + "&page=1'>首页</a></li>");
		 if (currentPage == 1) {
			 pageCode.append("<li class='disabled'><a target='_self' href='#'>上一页</a></li>");
		 } else {
			 pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
					 + (currentPage - 1) + "'>上一页</a></li>");
		 }
		 for (int i = currentPage - 10; i <= currentPage + 10; i++) {
			 if (i < 1 || i > totalPage) {
				 continue;
			 }
			 if (i == currentPage) {
				 pageCode.append("<li class='actives'><a target='_self' href='#'>" + i
						 + "</a></li>");
			 } else {
				 pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + i
						 + "'>" + i + "</a></li>");
			 }
		 }
		 if (currentPage == totalPage) {
			 pageCode.append("<li class='disabled'><a target='_self' href='#'>下一页</a></li>");
		 } else {
			 pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
					 + (currentPage + 1) + "'>下一页</a></li>");
		 }
		 if (totalPage == 0) {
			 totalPage = 1;
		 }
		 pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + totalPage
				 + "'>尾页</a></li>");
		 return pageCode.toString();
	 }

	 /**
	  * PC前端底部分页模板的公共方法
	  * 
	  * @param targetUrl 查询的路径
	  *            
	  * @param totalNum 总记录数
	  *           
	  * @param currentPage 当前页
	  *            
	  * @param pageSize  每页大小
	  *           
	  * @return
	  */
	  public static String genPaginationfrontuser(String targetUrl, int totalNum,
			  int currentPage, int pageSize) {
		  int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize
				  : totalNum / pageSize + 1;
		  StringBuffer pageCode = new StringBuffer();
		  pageCode.append("<li><span>总共有<font style='color:#2daadd'>"+totalPage+"</font>页&nbsp;&nbsp;有<font style='color:#2daadd'>"+totalNum+"</font>条记录</span><a target='_self' href='" + targetUrl + "&page=1'>首页</a></li>");
		  if (currentPage == 1) {
			  pageCode.append("<li class='disabled'><a target='_self' href='#'>上一页</a></li>");
		  } else {
			  pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
					  + (currentPage - 1) + "'>上一页</a></li>");
		  }
		  for (int i = currentPage - 10; i <= currentPage + 10; i++) {
			  if (i < 1 || i > totalPage) {
				  continue;
			  }
			  if (i == currentPage) {
				  pageCode.append("<li class='actives'><a target='_self' href='#'>" + i
						  + "</a></li>");
			  } else {
				  pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + i
						  + "'>" + i + "</a></li>");
			  }
		  }
		  if (currentPage == totalPage) {
			  pageCode.append("<li class='disabled'><a target='_self' href='#'>下一页</a></li>");
		  } else {
			  pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
					  + (currentPage + 1) + "'>下一页</a></li>");
		  }
		  if (totalPage == 0) {
			  totalPage = 1;
		  }
		  pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + totalPage
				  + "'>尾页</a></li>");
		  return pageCode.toString();
	  }

	  /**
	   * 底部分页模板的公共方法
	   * 
	   * @param targetUrl 查询的路径
	   *            
	   * @param totalNum 总记录数
	   *           
	   * @param currentPage 当前页
	   *            
	   * @param pageSize  每页大小
	   *           
	   * @return
	   */
	  public static String genPaginations(String targetUrl, int totalNum,
			  int currentPage, int pageSize) {
		  int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize
				  : totalNum / pageSize + 1;
		  StringBuffer pageCode = new StringBuffer();
		  pageCode.append("<li><span>总共有<font style='color:#3bbfb4'>"+totalPage+"</font>页&nbsp;&nbsp;有<font style='color:#3bbfb4'>"+totalNum+"</font>条记录</span><a target='_self'  href='" + targetUrl + "&page=1'>首页</a></li>");
		  if (currentPage == 1) {
			  pageCode.append("<li class='disabled'><a target='_self' onclick='return false;' href='javascript:void(0);'>上一页</a></li>");
		  } else {
			  pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
					  + (currentPage - 1) + "'>上一页</a></li>");
		  }
		  for (int i = currentPage - 2; i <= currentPage + 2; i++) {
			  if (i < 1 || i > totalPage) {
				  continue;
			  }
			  if (i == currentPage) {
				  pageCode.append("<li class='actives'><a target='_self' onclick='return false;' href='javascript:void(0);'>" + i
						  + "</a></li>");
			  } else {
				  pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + i
						  + "'>" + i + "</a></li>");
			  }
		  }
		  if (currentPage == totalPage) {
			  pageCode.append("<li class='disabled'><a target='_self'  onclick='return false;' href='javascript:void(0);'>下一页</a></li>");
		  } else {
			  pageCode.append("<li><a target='_self' href='" + targetUrl + "&page="
					  + (currentPage + 1) + "'>下一页</a></li>");
		  }
		  if (totalPage == 0) {
			  totalPage = 1;
		  }
		  pageCode.append("<li><a target='_self' href='" + targetUrl + "&page=" + totalPage
				  + "'>尾页</a></li>");
		  return pageCode.toString();
	  }

	  /**
	   * 底部分页模板的公共方法（ajax）
	   * 
	   * @param targetUrl 查询的方法
	   *            
	   * @param totalNum 总记录数
	   *           
	   * @param currentPage 当前页
	   *            
	   * @param pageSize  每页大小
	   *           
	   * @return
	   */
	  public static String genPagination2(String targetUrl, int totalNum,
			  int currentPage, int pageSize) {
		  int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize
				  : totalNum / pageSize + 1;
		  StringBuffer pageCode = new StringBuffer();
		  pageCode.append("<li><span>总共有<font style='color:#3bbfb4'>"+totalPage+"</font>页&nbsp;&nbsp;有<font style='color:#3bbfb4'>"+totalNum+"</font>条记录</span><a href='javascript:void(0)' onclick='" + targetUrl + "(1);return false'>首页</a></li>");
		  if (currentPage == 1) {
			  pageCode.append("<li class='disabled'><a onclick='return false;'  href='javascript:void(0)'>上一页</a></li>");
		  } else {
			  pageCode.append("<li><a href='" + targetUrl + "("
					  + (currentPage - 1) + ")'>上一页</a></li>");
		  }
		  for (int i = currentPage - 2; i <= currentPage + 2; i++) {
			  if (i < 1 || i > totalPage) {
				  continue;
			  }
			  if (i == currentPage) {
				  pageCode.append("<li class='actives'><a onclick='return false;' href='javascript:void(0)'>" + i
						  + "</a></li>");
			  } else {
				  pageCode.append("<li><a href='javascript:void(0)' onclick='" + targetUrl + "(" + i
						  + ");return false'>" + i + "</a></li>");
			  }
		  }
		  if (currentPage == totalPage) {
			  pageCode.append("<li class='disabled'><a onclick='return false;'  href='javascript:void(0)'>下一页</a></li>");
		  } else {
			  pageCode.append("<li><a href='javascript:void(0)' onclick='" + targetUrl + "("
					  + (currentPage + 1) + ");return false'>下一页</a></li>");
		  }
		  if (totalPage == 0) {
			  totalPage = 1;
		  }
		  pageCode.append("<li><a href='javascript:void(0)' onclick='" + targetUrl + "(" + totalPage
				  + ");return false'>尾页</a></li>");
		  return pageCode.toString();
	  }
}