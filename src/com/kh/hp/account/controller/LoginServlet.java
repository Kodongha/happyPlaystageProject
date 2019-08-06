package com.kh.hp.account.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.hp.account.model.service.AccountService;
import com.kh.hp.account.model.vo.UserVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/checkLogin.acc")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get in!!");

		String userEmail = request.getParameter("userEmail");
		String userPwd = request.getParameter("userPwd");

		System.out.println("userEmail::"+userEmail);
		System.out.println("userPwd::"+userPwd);

		UserVO requestUserVO = new UserVO();
		requestUserVO.setUserEmail(userEmail);
		requestUserVO.setUserPwd(userPwd);
		System.out.println("requestUserVO:::" + requestUserVO);

		UserVO responseUserVO = AccountService.CheckLogin(requestUserVO);
		System.out.println("responseUserVO:::" + responseUserVO);

		HttpSession session = request.getSession();
		session.setAttribute("user", responseUserVO);
		String tempPassword = "";
		if(session.getAttribute("tempPasswordFlag") != null) {
			tempPassword = (String) session.getAttribute("tempPasswordFlag");
		}

		System.out.println("tempPassword::::::::" + tempPassword);
		String page = "";


		if(responseUserVO != null) {
			if(tempPassword.equals("Y")) {
				page = request.getContextPath() + "/reviseaPwd.mp";
			} else {
				page = request.getContextPath() + "/moveMain.main";
			}
			response.sendRedirect(page);
		} else {
			page = "views/account/login.jsp";
			request.setAttribute("loginFlag", false);
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post in!!");
		doGet(request, response);
	}

}
