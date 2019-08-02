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
import com.kh.hp.myPage.model.vo.AhnApplyInfoVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;
import com.kh.hp.rent.model.service.RentService;

/**
 * Servlet implementation class ApplyInfoDetailServlet
 */
@WebServlet("/applyInfoDetail")
public class ApplyInfoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyInfoDetailServlet() {
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
		Date useStart = Date.valueOf(request.getParameter("useStart"));
		Date useEnd = Date.valueOf(request.getParameter("useEnd"));
		String propStatus = request.getParameter("propStatus");
		
		System.out.println("useSeq : " + userInfo);
		System.out.println("rentSeq ::: " + rentSeq);
		System.out.println("hallNm : " + hallNm);
		System.out.println("useStart : " + useStart);
		System.out.println("useEnd : " + useEnd);
		System.out.println("propStatus : " + propStatus);
		
		RentService rentService = new RentService();
		ArrayList<Object> rentInfos = AhnMyPageService.selectRentOne(rentSeq);
		ArrayList<AhnApplyInfoVO> list = new AhnMyPageService().searchApplyDetail( userInfo, rentSeq, hallNm, useStart, useEnd, propStatus);
		
		System.out.println("rentInfos : " + rentInfos);
		
		String page = "";
		if(rentInfos != null) {
			System.out.println("list : " + list + "를 넘겨줌");
			request.setAttribute("rentInfos", rentInfos);
			request.setAttribute("list", list);
			page = "views/myPage/applyInfoDetail.jsp";
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
