package com.kh.hp.myPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.myPage.model.service.MyPageService_mh;
import com.kh.hp.myPage.model.vo.MyPageUserVO;

/**
 * Servlet implementation class RevisePwdServlet
 */
@WebServlet("/reviseaPwd.mp")
public class RevisePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevisePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("비밀번호 수정하기 들어옴");

		int userSeq = ((com.kh.hp.account.model.vo.UserVO) request.getSession().getAttribute("user")).getUserSeq();
		System.out.println("비밀번호 수정:::" + userSeq);

		MyPageUserVO myPageInfo = new MyPageService_mh().selectMyPageInfo(userSeq);

		System.out.println("비밀번호 수정===" + myPageInfo);

		String page = "";
		if(myPageInfo != null) {
			page = "views/myPage/revisePassword.jsp";
			request.setAttribute("myPageInfo", myPageInfo);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "비밀번호 수정하기 호출 실패!");
		}

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
