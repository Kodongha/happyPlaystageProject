package com.kh.hp.account.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.UserService_mh;
import com.kh.hp.account.model.vo.UserVO;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateUser.mp")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPwd = request.getParameter("userPwd");
		String userPwd2 = request.getParameter("userPwd2");
		String userNm = request.getParameter("userNm");
		String userNick = request.getParameter("userNick");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");

		System.out.println(userPwd);
		System.out.println(userPwd2);
		System.out.println(userNm);
		System.out.println(userNick);
		System.out.println(userPhone);

		UserVO uv = new UserVO();
		uv.setUserNm(userNm);
		uv.setUserNick(userNick);
		uv.setUserPhone(userPhone);

		int result = new UserService_mh().updateUser(uv);

		String page="";

		if(result > 0) {
			page="views/myPage/myPage.jsp";
			response.sendRedirect(page);
		} else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "정보 수정 실패");
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
