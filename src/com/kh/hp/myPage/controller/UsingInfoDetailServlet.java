package com.kh.hp.myPage.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;
import com.kh.hp.myPage.model.vo.PageInfo;
import com.kh.hp.rent.model.service.RentService;

/**
 * Servlet implementation class UsingInfoDetailServlet
 */
@WebServlet("/usingInfoDetail")
public class UsingInfoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsingInfoDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("들어왔수");
		int userInfo = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();
		int rentSeq = Integer.parseInt(request.getParameter("rentSeq"));
		String hallNm = request.getParameter("hallNm");
		Date useStart = null;
		Date useEnd = null;
		
		System.out.println("useSeq : " + userInfo);
		System.out.println("rentSeq ::: " + rentSeq);
		System.out.println("hallNm : " + hallNm);
		System.out.println("useStart : " + useStart);
		System.out.println("useEnd : " + useEnd);
		RentService rentService = new RentService();
		ArrayList<Object> rentInfos = AhnMyPageService.selectRentOne(rentSeq);
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageService().searchUsingDetail( userInfo, rentSeq, hallNm, useStart, useEnd);
		
		String page = "";
		if(rentInfos != null) {
			request.setAttribute("rentInfos", rentInfos);
			page = "views/myPage/usingInfoDetail.jsp";
		} else {
			page = "views/common/errorPage.jsp";
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
