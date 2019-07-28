package com.kh.hp.account.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.AccountService;
import com.kh.hp.common.EmailUtils;

/**
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/findPassword.acc")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sessionId = request.getSession().getId();
		String receiver = request.getParameter("receiver");
		System.out.println("receiver::::"+receiver);

		int result = new AccountService().checkId(receiver);

		if(result > 0) {
			new EmailUtils().sendEmail(sessionId, receiver, null);
			response.sendRedirect("views/account/findPassword2.jsp?email="+receiver);
		} else {
			response.sendRedirect("views/account/findPassword.jsp?flag=N");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
