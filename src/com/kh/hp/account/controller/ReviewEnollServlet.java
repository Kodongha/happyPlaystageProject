package com.kh.hp.account.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.ReviewService;
import com.kh.hp.account.model.vo.ReviewSearchVO;

/**
 * Servlet implementation class ReviewEnollServlet
 */
@WebServlet("/reviewEnoll.acc")
public class ReviewEnollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewEnollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("호출 ");
		
		int userSeq = ((com.kh.hp.account.model.vo.UserVO) request.getSession().getAttribute("user")).getUserSeq();
		ArrayList<ReviewSearchVO> ReviewSearchVO = new ReviewService().selectUsedList(userSeq);
		
		//System.out.println("ReviewSearchVO : " + ReviewSearchVO);
		
		String page ="";
		
		if(ReviewSearchVO !=null) {
			page = "views/review/beforeriveiw.jsp";
			request.setAttribute("ReviewSearchVO", ReviewSearchVO);
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
