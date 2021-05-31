package Usecase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Usecase.service.CaseServiceImpl;
import Usecase.service.MessageServiceImpl;
import entity.Usecase;

/**
 * Servlet implementation class CaseRun
 */
@WebServlet("/run")
public class CaseRun extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CaseRun() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("�������е�id��"+id);
		Usecase usecase = null;
		if (id != null && !id.equals("")) {
			try {
				usecase = new CaseServiceImpl().getUsecase(Integer.parseInt(id));
				System.out.println("��������");
				System.out.println(usecase.getUrl());
				System.out.println(usecase.getBody());
				System.out.println("*************************8");
				System.out.println(usecase.getMethod());
				String input_method = usecase.getMethod();
				// ����������
				String textContent = usecase.getBody();
				// ���url�����и�
				String input_Url = usecase.getUrl();
				String[] urlname = input_Url.split("/");
				String name = null;

				for (int i = 4; i < urlname.length; i++) {
					// ��ýӿ�����(name)
					if (urlname.length == 5) {

						name = urlname[i];
					} else if (name == null) {
						name = urlname[i] + "/";
					} else if (i == (urlname.length - 1)) {
						name = name + urlname[i];
					} else {
						name = name + urlname[i] + "/";
					}
				}
				//�ӿ�����
				System.out.println(name);
				// �ӿ�name
				request.setAttribute("url_path", name);
				// url
				request.setAttribute("url", input_Url);
				// ����
				request.setAttribute("method", input_method);
				// ����
				request.setAttribute("content", textContent);
				// id
				request.setAttribute("id", id);
				// ��ת
				name = "/" + name;

				request.getRequestDispatcher(name).forward(request, response);

			} catch (NumberFormatException e) {
				e.printStackTrace();
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
		System.out.println("CaseRun+doPost");
		new MessageServiceImpl().dropMessage();
		System.out.println("��ɾ��");
		String[] choose = request.getParameterValues("choose");
		int i = 0;

		System.out.println(choose[i]);
		Usecase usecase = new CaseServiceImpl().getUsecase(Integer.parseInt(choose[i]));
		System.out.println(usecase.getUrl());
		System.out.println(usecase.getBody());
		System.out.println(usecase.getMethod());
		String input_method = usecase.getMethod();
		// ����������
		String textContent = usecase.getBody();
		// ���url�����и�
		String input_Url = usecase.getUrl();
		String[] urlname = input_Url.split("/");
		String name = null;

		for (int ii = 4; ii < urlname.length; ii++) {
			// ��ýӿ�����(name)
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
		// �ӿ�name
		request.setAttribute("url_path", name);
		// url
		request.setAttribute("url", input_Url);
		// ����
		request.setAttribute("method", input_method);
		// ����
		request.setAttribute("content", textContent);
		// id
		String r_id = choose[i];
		System.out.println(choose[i]);

		System.out.println("r_id�Ǵ���ǰ��id" + r_id);
		request.setAttribute("r_id", r_id);

		int length = choose.length;
		length = length - 1;
		request.setAttribute("length", length);
		// ��ת
		name = "/" + name;
		System.out.println(request.getRequestURL());
		System.out.println("name" + name);
		request.getRequestDispatcher(name).forward(request, response);

	}

}
