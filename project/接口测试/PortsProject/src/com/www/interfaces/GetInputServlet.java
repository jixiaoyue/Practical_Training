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
		response.setContentType("text/html;charset=utf-8");
//		1������ �����ɹ�
		JSONObject info = new JSONObject();
		info.put("code", "200");
		info.put("message", "success");
		String result = info.toString();

//		2������ ����ʧ��
		JSONObject info2 = new JSONObject();
		info2.put("code", "404");
		info2.put("message", "fail");
		String result2 = info2.toString();
		
//		String r_id = request.getAttribute("r_id").toString();
//		System.out.println("getuinputServletid��" + r_id);

//		��ȡurl
		String get_url0 = (String) request.getAttribute("url");
//		��ȡbody����
		String content = request.getAttribute("content").toString();
		System.out.println("��֤Content���ݣ�" + content);
		// ��ȡ����Ĳ�����ת��Ϊjson��ʽ
		String[] paramm = content.split("\\r\\n");

		JSONObject para = new JSONObject();
		for (int i = 0; i < paramm.length; i++) {
			System.out.println(i + "��" + paramm[i]);
			String[] item = paramm[i].split("=");
			String key = item[0];
			String value = item[1];
			para.put(key, value);
		}
//		�������para_toString
		String para_toString = para.toString();
		System.out.println("para_toString" + para_toString);
		// ������������ж����ж�
		String para_name = para.getString("name");
		String para_pwd = para.getString("password");
		if (para_name.equals("admin") && para_pwd.equals("123456")) {
//			ƥ��ɹ�
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
//			ƥ��ʧ��
			request.setAttribute("url_params", get_url0);
			request.setAttribute("input_text", para_toString);
			request.setAttribute("res_result", result2);
			if (request.getAttribute("r_id") != null) {
				request.setAttribute("state", "fail");
				request.getRequestDispatcher("/MessageAdd").forward(request, response);
			} else {
				request.getRequestDispatcher("/resInfo.jsp").forward(request, response);
			}
//			System.out.println("�����������");
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
