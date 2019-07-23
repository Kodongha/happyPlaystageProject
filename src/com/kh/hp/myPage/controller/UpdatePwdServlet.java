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
 * Servlet implementation class UpdatePwdServlet
 */
@WebServlet("/updatePwd.mp")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("비밀번호 변경하기 버튼 클릭!!!");
		String originPwd = request.getParameter("originPwd");
		String newPwd = request.getParameter("newPwd1");
		String page="";

		System.out.println(originPwd);
		System.out.println(newPwd);

		UserVO userVO = ((UserVO) request.getSession().getAttribute("user"));
		int userSeq = userVO.getUserSeq();

		MyPageUserVO myPageUserVO = new MyPageUserVO();
		myPageUserVO.setUserSeq(userSeq);
		myPageUserVO.setUserPwd(originPwd);  //새로 입력한 originPwd를 새로운 vo에 넣음

		int result = new MyPageService_mh().updateUserPwd(myPageUserVO, newPwd);

		if(result == 2) {
			page = request.getContextPath() + "/myPage.mp";
			request.getSession().removeAttribute("user");
			request.getSession().setAttribute("user", userVO);
			response.sendRedirect(page);
		} else {
			System.out.println("else in!!");
			page = request.getContextPath() + "/reviseaPwd.mp?flag=N";
			response.sendRedirect(page);
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
