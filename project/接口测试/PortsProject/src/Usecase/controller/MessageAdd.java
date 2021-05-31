package Usecase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Usecase.service.MessageServiceImpl;
import entity.Message;

/**
 * Servlet implementation class MessageAdd
 */
@WebServlet("/MessageAdd")
public class MessageAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><meta charset='utf-8' /></head><body>");
		out.print(request.getAttribute("msg"));
		out.print("</body></html>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

//		new MessageServiceImpl().dropMessage();

		String r_id = request.getAttribute("r_id").toString();
		System.out.println("MessageAdd是id:" + r_id);
		String state = request.getAttribute("state").toString();
		System.out.println("MessageAdd是state" + state);
		String information = request.getAttribute("res_result").toString();
		System.out.println("MessageAdd是state" + information);

		Message message = new Message();
		message.setR_id(Integer.parseInt(r_id));
		message.setState(state);
		message.setInformation(information);

		System.out.println(r_id + state + information);

		String lengt = request.getAttribute("length").toString();
		System.out.println("MessageAdd length是" + lengt);
		boolean isSaved = new MessageServiceImpl().addMessage(message);

		System.out.println(Integer.parseInt(lengt));

		if (Integer.parseInt(lengt) <= 0 && isSaved) {
			System.out.println("跳转MessageList");
			System.out.println(request.getRequestURL());
			response.sendRedirect("MessageList");
		} else {
			System.out.println("跳转run2");
			System.out.println(request.getRequestURL());
			request.getRequestDispatcher("/run2").forward(request, response);
		}

	}

}
