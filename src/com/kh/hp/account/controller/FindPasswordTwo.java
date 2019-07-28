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
@WebServlet("/fp.acc")
public class FindPasswordTwo extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPasswordTwo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sessionId = request.getSession().getId();
		String authNumber = request.getParameter("authNumber");
		String receiver = request.getParameter("receiver");


		// 인증번호 확인
		int authResult = new AccountService().checkAuth(sessionId, authNumber);
		System.out.println("인증 여부 유저번호:::::" + authResult);

		if(authResult > 0) {
			request.setAttribute("flag", "Y");
			int userSeq = new AccountService().checkId(receiver);
			String newPwd = new AccountService().updatePassword(userSeq);
			new EmailUtils().sendEmail(sessionId, receiver, newPwd);
		} else {
			request.setAttribute("flag", "N");
		}

		String page = "views/account/findPassword2.jsp?email="+receiver;
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
