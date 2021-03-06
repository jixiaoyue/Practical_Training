package com.www.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class GetInputServlet
 */
@WebServlet("/GetInputServlet")
public class GetInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetInputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String getInter = null;
		if (request.getAttribute("method").equals("get")) {
			System.out.println("选择了get方法");
			doGet(request, response);
		} else if (request.getAttribute("method").equals("post")) {
			System.out.println("选择了post方法");
			if (request.getAttribute("content") == "") {
				getInter = "该post请求未带参数,请重新输入参数";
				System.out.println(getInter);
				request.setAttribute("res_result", getInter);
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			} else {
				doPost(request, response);
			}
		} else {
			response.getWriter().println("请先选择请求方法！");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
//		1，返回 参数成功
		JSONObject info = new JSONObject();
		info.put("code", "200");
		info.put("message", "success");
		String result = info.toString();

//		2，返回 参数失败
		JSONObject info2 = new JSONObject();
		info2.put("code", "404");
		info2.put("message", "fail");
		String result2 = info2.toString();
		
//		String r_id = request.getAttribute("r_id").toString();
//		System.out.println("getuinputServletid是" + r_id);

//		获取url
		String get_url0 = (String) request.getAttribute("url");
//		获取body参数
		String content = request.getAttribute("content").toString();
		System.out.println("验证Content内容：" + content);
		// 获取输入的参数，转化为json格式
		String[] paramm = content.split("\\r\\n");

		JSONObject para = new JSONObject();
		for (int i = 0; i < paramm.length; i++) {
			System.out.println(i + "：" + paramm[i]);
			String[] item = paramm[i].split("=");
			String key = item[0];
			String value = item[1];
			para.put(key, value);
		}
//		输入参数para_toString
		String para_toString = para.toString();
		System.out.println("para_toString" + para_toString);
		// 对请求参数进行断言判断
		String para_name = para.getString("name");
		String para_pwd = para.getString("password");
		if (para_name.equals("admin") && para_pwd.equals("123456")) {
//			匹配成功
			request.setAttribute("url_params", get_url0);
			request.setAttribute("input_text", para_toString);
			request.setAttribute("res_result", result);

			if (request.getAttribute("r_id") != null) {
				request.setAttribute("state", "success");
				request.getRequestDispatcher("/MessageAdd").forward(request, response);
			} else {
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			}

		} else {
//			匹配失败
			request.setAttribute("url_params", get_url0);
			request.setAttribute("input_text", para_toString);
			request.setAttribute("res_result", result2);
			if (request.getAttribute("r_id") != null) {
				request.setAttribute("state", "fail");
				request.getRequestDispatcher("/MessageAdd").forward(request, response);
			} else {
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			}
//			System.out.println("请求参数有误！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
