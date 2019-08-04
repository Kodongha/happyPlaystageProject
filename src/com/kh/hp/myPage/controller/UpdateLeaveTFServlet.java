package com.kh.hp.myPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.KakaoService;
import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.MyPageService_mh;
import com.kh.hp.myPage.model.vo.MyPageUserVO;

/**
 * Servlet implementation class UpdateLeaveTFServlet
 */
@WebServlet("/updateLeaveTF.mp")
public class UpdateLeaveTFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateLeaveTFServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("탈퇴하기 버튼 클릭됨~!!");

		int snsCd = ((UserVO) request.getSession().getAttribute("user")).getSnsCd();
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");

		System.out.println(pwd1);
		System.out.println(pwd2);

		UserVO userVO = ((UserVO) request.getSession().getAttribute("user"));
		int userSeq = userVO.getUserSeq();

		int result = 0;
		boolean checkTf = true;
		// 패스워드 일치 여부
		if(snsCd != 1) {
			checkTf = new MyPageService_mh().checkPassword(userSeq, pwd1);
		}

		// 삭제 업데이트
		if(checkTf) {
			result = new MyPageService_mh().updateLeaveTF(userSeq, pwd1);
		}


		String page = "";
		if(result > 0) {
			System.out.println("탈퇴완료 처리 result > 0!!!");

			if(snsCd == 1) {
				String retireKakaoUnqId = new KakaoService().retireKakaoAccount(userSeq);
				System.out.println("retireKakaoUnqId 탈퇴됨");
			}

			page = request.getContextPath() + "/moveMain.main";
			request.getSession().invalidate();
			response.sendRedirect(page);
		} else {
			System.out.println("else in!!");
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "서비스 탈퇴하기 실패!");
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
