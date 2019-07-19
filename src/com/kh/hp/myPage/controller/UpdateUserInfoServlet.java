package com.kh.hp.myPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.MyPageService_mh;
import com.kh.hp.myPage.model.vo.MyPageUserVO;

/**
 * Servlet implementation class UpdateUserInfoServlet
 */
@WebServlet("/updateUser.mp")
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("변경하기 버튼 클릭!!!!!!!!!!!!!!!!!");
		String userNick = request.getParameter("userNick");
		String userNm = request.getParameter("userNm");
		String userPhone = request.getParameter("userPhone");

		System.out.println(userNick);
		System.out.println(userNm);
		System.out.println(userPhone);

		UserVO userVO = ((UserVO) request.getSession().getAttribute("user"));
		int userSeq = userVO.getUserSeq();

		MyPageUserVO myPageUserVO = new MyPageUserVO();
		myPageUserVO.setUserSeq(userSeq);
		myPageUserVO.setUserNick(userNick);
		myPageUserVO.setUserNm(userNm);
		myPageUserVO.setUserPhone(userPhone);

		userVO.setUserNick(myPageUserVO.getUserNick());
		userVO.setUserNm(myPageUserVO.getUserNm());
		userVO.setUserPhone(myPageUserVO.getUserPhone());

		System.out.println(myPageUserVO);

		MyPageUserVO mypageInfo = new MyPageService_mh().updateMyPageInfo(myPageUserVO);

		String page = "";
		if(mypageInfo != null) {
			page = request.getContextPath() + "/myPage.mp";
			request.getSession().removeAttribute("user");
			request.getSession().setAttribute("user", userVO);
			response.sendRedirect(page);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "마이페이지 수정하기 호출 실패!");
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
