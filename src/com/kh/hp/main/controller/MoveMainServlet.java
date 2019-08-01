package com.kh.hp.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.ReviewService;
import com.kh.hp.account.model.vo.ReviewMainVO;
import com.kh.hp.main.model.service.MainService;
import com.kh.hp.main.model.vo.MainRentVO;

/**
 * Servlet implementation class MoveMainServlet
 */
@WebServlet("/moveMain.main")
public class MoveMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("moveMain.main in!!");

		MainService mainService = new MainService();

		// 대관 데이터 가져오기
		ArrayList<MainRentVO> responseMainRentVOList = mainService.selectMainData();

		for(MainRentVO mainRentVO : responseMainRentVOList) {
			System.out.println(mainRentVO);
			System.out.println(mainRentVO.getFilePath() + mainRentVO.getChangeNm());
		}

		// 리뷰 데이터 가져오기
		ArrayList<ReviewMainVO> reviewMainVOList = mainService.ReviewList();
		System.out.println("reviewMainVOList:::::::"+reviewMainVOList);

		String page = "";
		if(responseMainRentVOList != null) {
			page = "views/main/main.jsp";
			request.setAttribute("responseMainRentVOList", responseMainRentVOList);
			request.setAttribute("reviewMainVOList", reviewMainVOList);
			request.getRequestDispatcher(page).forward(request, response);
		} else {

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
