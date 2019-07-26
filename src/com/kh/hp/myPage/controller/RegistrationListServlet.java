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
/*
		RegistListVO registListVO = new RegistListVO();
		registListVO.setUserSeq(userSeq);
		registListVO.setUserGradeCode(userGrade);

		System.out.println(registListVO);
*/
		ArrayList<RegistListVO> list = new MyPageService_mh().selectRegistList(userSeq);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
