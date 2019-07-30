package com.kh.hp.account.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.ReviewService;
import com.kh.hp.account.model.vo.ReviewVO;
import com.kh.hp.account.model.vo.UserVO;

/**
 * Servlet implementation class ReviewInsert
 */
@WebServlet("/reviewInsert.acc")
public class ReviewInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String reviewContent = request.getParameter("reviewContent");
		int propSeq = Integer.parseInt(request.getParameter("propSeq"));
		int rentSeq = Integer.parseInt(request.getParameter("rentSeq"));

		System.out.println("propSeq:::" + propSeq);
		System.out.println("rentSeq:::" + rentSeq);

		int ran = Integer.parseInt(request.getParameter("ran"));
		int userSeq = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();

		System.out.println(reviewContent);
		System.out.println(ran);
		System.out.println(userSeq);

		ReviewVO rv = new ReviewVO();

		rv.setReviewContent(reviewContent);
		rv.setRan(ran);
		rv.setUserSeq(userSeq);
		rv.setpopSeq(propSeq);
		rv.setRentSeq(rentSeq);

		int result = new ReviewService().insertReview(rv);

		// ArrayList<ReviewVO> reviewVOList = new ReviewService().selectReviewList();


		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/reviewMain.acc");
		}else {
			request.setAttribute("msg", "리뷰 작성 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
