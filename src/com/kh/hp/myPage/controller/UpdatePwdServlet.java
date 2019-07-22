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
		String changePwd1 = request.getParameter("changePwd1");
		String changePwd2 = request.getParameter("changePwd2");
		String page="";

		System.out.println(originPwd);
		System.out.println(changePwd1);
		System.out.println(changePwd2);

		UserVO userVO = ((UserVO) request.getSession().getAttribute("user"));
		int userSeq = userVO.getUserSeq();
		String userPwd = userVO.getUserPwd();

		System.out.println("??????현재비밀번호???????"+userPwd);

		MyPageUserVO myPageUserVO = new MyPageUserVO();

		if(changePwd1.equals(changePwd2) && userPwd.equals(originPwd)) {
			myPageUserVO.setUserSeq(userSeq);
			myPageUserVO.setUserPwd(changePwd1);
			userVO.setUserPwd(myPageUserVO.getUserPwd());
			MyPageUserVO UserInfo = new MyPageService_mh().updateUserPwd(myPageUserVO);
		}
		if(!changePwd1.equals(changePwd2)) {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "비밀번호 확인이 일치하지 않습니다.");
			System.out.println("비밀번호 확인이 일치하지 않습니다.");
		}
		if(!userPwd.equals(originPwd)) {
			page=request.getContextPath() + "/views/common/errorPage.jsp";
			request.setAttribute("msg", "현재 비밀번호가 일치하지 않습니다.");
			System.out.println("현재 비밀번호가 일치하지 않습니다.");
		}
/*
		myPageUserVO.setUserSeq(userSeq);
		myPageUserVO.setUserPwd(changePwd1);
		userVO.setUserPwd(myPageUserVO.getUserPwd());
		MyPageUserVO userPwd = new MyPageService_mh().updateUserPwd(myPageUserVO);

*/
		if(myPageUserVO != null) {
			page = request.getContextPath() + "/myPage.mp";
			request.getSession().removeAttribute("user");
			request.getSession().setAttribute("user", userVO);
			response.sendRedirect(page);
		} else {
			page=request.getContextPath() + "/views/common/errorPage.jsp";
			request.setAttribute("msg", "비밀번호 수정 실패");
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
