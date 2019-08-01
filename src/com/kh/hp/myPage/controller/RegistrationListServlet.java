package com.kh.hp.myPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.MyPageService_mh;
import com.kh.hp.myPage.model.vo.RegistListVO;
import com.kh.hp.rent.model.vo.RentImgVO;

/**
 * Servlet implementation class RegistrationListServlet
 */
@WebServlet("/registList.mp")
public class RegistrationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("대관 등록 내역 들어옴!");

		UserVO userVO = ((UserVO) request.getSession().getAttribute("user"));
		int userSeq = userVO.getUserSeq();



		System.out.println(userSeq);

		MyPageService_mh myPageService_mh = new MyPageService_mh();
		ArrayList<RegistListVO> list = myPageService_mh.selectRegistList(userSeq);

		String page= "";
		if (list != null) {
			System.out.println("list가 널이 아님!");
			System.out.println(list);
			page="views/myPage/registrationList.jsp";
			request.setAttribute("list", list);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회 실패");
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
