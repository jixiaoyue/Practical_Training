package Usecase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Usecase.service.CaseServiceImpl;
import entity.Usecase;

/**
 * Servlet implementation class CaseRun
 */
@WebServlet("/run2")
public class CaseRun2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CaseRun2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("**************************8");
		System.out.println("run2+doPost");
		System.out.println(request.getRequestURL());
		String[] choose = request.getParameterValues("choose");
		System.out.println("run2的长度" + choose.length);
		int i = 0;
		int t = 0;
		String lengths = request.getAttribute("length").toString();
		System.out.println("CaseRun2");
		System.out.println("数组还剩长度length" + lengths);
		if (lengths != null) {
			t = Integer.parseInt(lengths);
			System.out.println("t" + t);
		}
		i = choose.length - t;
		System.out.println("i是" + i);

		System.out.println(choose[i]);
		Usecase usecase = new CaseServiceImpl().getUsecase(Integer.parseInt(choose[i]));
		System.out.println(usecase.getUrl());
		System.out.println(usecase.getBody());
		System.out.println(usecase.getMethod());
		String input_method = usecase.getMethod();
		// 获得输入参数
		String textContent = usecase.getBody();
		// 获得url，并切割
		String input_Url = usecase.getUrl();
		String[] urlname = input_Url.split("/");
		String name = null;

		for (int ii = 4; ii < urlname.length; ii++) {
			// 获得接口连接(name)
			if (urlname.length == 5) {

				name = urlname[ii];
			} else if (name == null) {
				name = urlname[ii] + "/";
			} else if (i == (urlname.length - 1)) {
				name = name + urlname[ii];
			} else {
				name = name + urlname[ii] + "/";
			}
		}

		System.out.println(name);
		// 接口name
		request.setAttribute("url_path", name);
		// url
		request.setAttribute("url", input_Url);
		// 方法
		request.setAttribute("method", input_method);
		// 参数
		request.setAttribute("content", textContent);
		// id
		String r_id = choose[i];

		System.out.println(choose[i]);
		System.out.println("r_id是传递前的id" + r_id);

		request.setAttribute("r_id", r_id);

		int length = Integer.parseInt(lengths) - 1;
		request.setAttribute("length", length);
		// 跳转
		name = "/" + name;

		request.getRequestDispatcher(name).forward(request, response);

	}

}
