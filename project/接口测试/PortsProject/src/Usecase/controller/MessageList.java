package Usecase.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Usecase.service.MessageServiceImpl;

/**
 * Servlet implementation class MessageList
 */
@WebServlet("/MessageList")
public class MessageList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageList() {
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
		System.out.println("*****************************************");
		System.out.println("MessageList+doGet");
		List<Map<String, Object>> messageList = new MessageServiceImpl().listMessages();
		System.out.println(messageList.isEmpty());

		for (Map<String, Object> map : messageList) {
			System.out.println(map);
		}
		System.out.println("messagelist");
		request.setAttribute("messages", messageList);
		request.getRequestDispatcher("/showmessage.jsp").forward(request, response);
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
