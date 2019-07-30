package com.kh.hp.account.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.SignUpService;
import com.kh.hp.account.model.vo.UserVO;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signUp.acc")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("signUp.acc in");

		String userEmail = request.getParameter("userEmail");
		String userPwd = request.getParameter("userPwd");
		String userNm = request.getParameter("userNm");
		String userNick = request.getParameter("userNick");
		String userPhone = request.getParameter("userPhone");



		UserVO u = new UserVO();

		u.setUserEmail(userEmail);
		u.setUserPwd(userPwd);
		u.setUserNm(userNm);
		u.setUserNick(userNick);
		u.setUserPhone(userPhone);

		System.out.println("servlet ::: "+u);

		SignUpService ss = new SignUpService();
		int result = ss.joinMember(u);

		String page = "";
		if(result > 0) {
			page = "views/account/login.jsp";
			response.sendRedirect(page);
		} else {
			page = "views/common/errorPage.jsp";
			request.getRequestDispatcher(page).forward(request, response);
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
