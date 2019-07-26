package com.kh.hp.account.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.ReviewSearchService;
import com.kh.hp.account.model.vo.ReviewSearchVO;

/**
 * Servlet implementation class ReviewSearch
 */
@WebServlet("/reviewSh.acc")
public class ReviewSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("search"));
		
		System.out.println(num);
		ReviewSearchVO rs = new ReviewSearchService().selectList(num);
		System.out.println(rs);
		
		String page = "";

		if(rs !=  null) {
			page = "views/account/reviewRegister.jsp";
			request.setAttribute("rs", rs);
		}else {
			page = "views/account/reviewSearch.jsp";
	
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
