package cn.biga.util;



import com.alibaba.fastjson.JSON;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 */
public class HttpUtil {
	public static String XMLHTTPREQUEST = "XMLHttpRequest";
	public static String POST = "POST";
	public static String X_Requested_With = "X-Requested-With";
	/**
	 *  判断是否是ajax请求
	 */
	public static boolean isAjax(ServletRequest request) {
		// 不是ajax请求
		if (XMLHTTPREQUEST.equalsIgnoreCase(((HttpServletRequest) request).getHeader(X_Requested_With))) {
			return true;
		}
		return false;
	}



	/**
	 * 判断请求类型
	 * @param servletRequest
	 * @return
	 */
	public static boolean isPost(ServletRequest servletRequest) {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		if (POST.equalsIgnoreCase(request.getMethod())) {
			return true;
		}
		return false;
	}

	/**
	 * @param response
	 * @param result
	 *            将对象转成json 返回给页面
	 */
	public static void writeResponse(HttpServletResponse response, Object result) {

		// 设置response
		// HTTP 1.1
		response.setHeader("Cache-Control", "no-cache");
		// prevents caching at the proxy
		response.setDateHeader("Expires", 0);
		// 火狐浏览器必须加上这句
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		try {
			response.getWriter().write(JSON.toJSONString(result));
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
