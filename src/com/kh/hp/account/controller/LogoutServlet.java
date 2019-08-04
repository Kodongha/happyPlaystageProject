package com.kh.hp.account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.KakaoService;
import com.kh.hp.account.model.vo.UserVO;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.acc")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userSeq = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();
		int snsCd = ((UserVO) request.getSession().getAttribute("user")).getSnsCd();

		// 카카오 계정 로그인이라면,
		if(snsCd == 1) {
			String logoutKakaoUnqId = new KakaoService().logoutKakaoAccount(userSeq);
			System.out.println("카카오 로그아웃 아이디 : " + logoutKakaoUnqId);
		}

		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/moveMain.main");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
