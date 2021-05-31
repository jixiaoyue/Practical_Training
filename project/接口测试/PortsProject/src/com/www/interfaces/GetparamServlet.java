package com.www.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class GetparamServlet
 */
@WebServlet("/GetparamServlet")
public class GetparamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetparamServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String getInter = null;
		if (request.getAttribute("method").equals("get")) {
			System.out.println("ѡ����get����");
			doGet(request, response);
		} else if (request.getAttribute("method").equals("post")) {
			System.out.println("ѡ����post����");
			if (request.getAttribute("content") == "") {
				getInter = "��post����δ������,�������������";
				System.out.println(getInter);
				request.setAttribute("res_result", getInter);
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			} else {
				doPost(request, response);
			}
		} else {
			response.getWriter().println("����ѡ�����󷽷���");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
//		1������ �����ɹ�
		JSONObject info = new JSONObject();
		info.put("code", "200");
		info.put("message", "success");
		info.put("identity", "admin");
		info.put("jurisdiction", "first");

		String result = info.toString();

//		2������ ����ʧ��
		JSONObject info2 = new JSONObject();
		info2.put("code", "404");
		info2.put("message", "fail");
		info2.put("text", "request is wrong!");
		String result2 = info2.toString();

		String get_url0 = (String) request.getAttribute("url");
		String[] url_parts = get_url0.split("[?]");
		String get_url = url_parts[1];
		System.out.println("get_url��" + get_url);
		// params[i] : textparam = 123321
		String[] params = get_url.split("&");
		JSONObject obj = new JSONObject();
		for (int i = 0; i < params.length; i++) {
			// param : textparam,12321
			String[] param = params[i].split("=");
			if (param.length >= 2) {
				String key = param[0];
				String value = param[1];
				for (int j = 2; param.length > j; j++) {
					value += "=" + param[j];
				}
				obj.put(key, value);
			}
		}
		String url_param = obj.toString();
		// ���Խ��в������ж�
		String in_name = obj.getString("name");
		String in_pwd = obj.getString("password");
		System.out.println(in_name);
		System.out.println(in_pwd);
		if (in_name.equals("admin") && in_pwd.equals("123456")) {
//			ƥ��ɹ�
			request.setAttribute("url_params", get_url0);
			request.setAttribute("input_text", url_param);
			request.setAttribute("res_result", result);

			if (request.getAttribute("r_id") != null) {
				request.setAttribute("state", "success");
				request.getRequestDispatcher("/MessageAdd").forward(request, response);
			} else {
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			}

		} else {
//			ƥ��ʧ��
			request.setAttribute("url_params", get_url0);
			request.setAttribute("input_text", url_param);
			request.setAttribute("res_result", result2);

			if (request.getAttribute("r_id") != null) {
				request.setAttribute("state", "fail");
				request.getRequestDispatcher("/MessageAdd").forward(request, response);
			} else {
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			}

			System.out.println("�����������");
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
