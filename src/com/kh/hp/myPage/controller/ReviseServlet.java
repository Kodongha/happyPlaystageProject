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
 * Servlet implementation class ReviseServlet
 */
@WebServlet("/revise.mp")
public class ReviseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("수정하기 페이지 들어옴!!!");

		int userSeq = ((com.kh.hp.account.model.vo.UserVO) request.getSession().getAttribute("user")).getUserSeq();
		//System.out.println(userSeq);
		MyPageUserVO mypageInfo = new MyPageService_mh().selectMyPageInfo(userSeq);

		String page = "";
		if(mypageInfo != null) {
			page = "views/myPage/revise.jsp";
			request.setAttribute("mypageInfo", mypageInfo);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "마이페이지 수정하기 호출 실패!");
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
