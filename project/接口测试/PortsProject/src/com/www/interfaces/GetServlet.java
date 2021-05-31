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
@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetServlet() {
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
		System.out.println("GetServlet��doget��������");
		response.setContentType("text/html;charset=utf-8");

		JSONObject info = new JSONObject();
		info.put("code", "200");
		info.put("message", "success");
		String result = info.toString();
//		String content = request.getAttribute("content").toString();
//		System.out.println("��֤Content���ݣ�" + content);
		System.out.println("��֤result��" + result);// /s2?methodname=get&urlname=123&textparam=123321
		// 1.����λ��URL��
		String get_url0 = (String) request.getAttribute("url");
		if (get_url0.length() == 0) {
//			response.sendError(404);
			if (request.getAttribute("r_id") != null) {
				request.setAttribute("state", "fail");
				request.getRequestDispatcher("/MessageAdd").forward(request, response);
			} else {
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			}
		} else if (!get_url0.contains("?")) {
//			request.setAttribute("input_text", request.getAttribute("content"));
//			��������
			request.setAttribute("url_params", get_url0);
			request.setAttribute("res_result", result);
//			request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			if (request.getAttribute("r_id") != null) {
				request.setAttribute("state", "success");
				request.getRequestDispatcher("/MessageAdd").forward(request, response);
			} else {
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			}
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
