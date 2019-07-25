package com.kh.hp.account.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.ReviewSearchService;
import com.kh.hp.serviceCenter.model.vo.Notice;

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
		ArrayList<Notice> list = new ReviewSearchService().selectList();
		System.out.println(list);
		
		String page = "";

		if(list != null) {
			page = "views/account/reviewRegister.jsp";
			request.setAttribute("list", list);
		}else {
			page = "views/account/reviewSearch.jsp";
			request.setAttribute("msg", "조회 실패");
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
