package com.kh.hp.rent.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.hp.rent.model.service.RentService;
import com.kh.hp.rent.model.vo.PageInfo;
import com.kh.hp.rent.model.vo.RentListVO;

/**
 * Servlet implementation class MoveRentList
 */
@WebServlet("/moveRentList.rt")
public class MoveRentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveRentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String searchString = request.getParameter("searchString");
		System.out.println("searchString::" + searchString);


		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;

		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		limit = 9;

		int listCount = new RentService().selectCountRentList(searchString);
		System.out.println("@@ list count : " + listCount);

		maxPage = (int)((double)listCount / limit + 0.9);

		startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * 10 + 1;

		endPage = startPage + 10 - 1;

		if(maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

		ArrayList<RentListVO> list = new RentService().selectRentList(currentPage, limit, searchString);

		System.out.println("list.size():::" + list.size());

		String page = "";

		if(list != null) {
			System.out.println("list not null!!!");
			page = "views/rent/rentalList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
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
