package com.kh.hp.serviceCenter.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.serviceCenter.model.service.ServiceCenterService;
import com.kh.hp.serviceCenter.model.vo.Notice;
import com.kh.hp.serviceCenter.model.vo.PageInfo;

/**
 * Servlet implementation class SearchNoticeServlet
 */
@WebServlet("/searchNotice.sc")
public class SearchNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***공지사항 검색 서블릿 호출***");
		String searchValue = "";

		searchValue = request.getParameter("searchValue");

		System.out.println("searchValue ===" + searchValue);

		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;

		currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		limit = 10;

		int listCount = new ServiceCenterService().SearchListCount(searchValue);

		System.out.println("### list count : " + listCount);

		maxPage = (int)((double)listCount / limit + 0.9);

		startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * 10 + 1;

		endPage = startPage + 10 -1;

		if(maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

		ArrayList<Notice> list = new ServiceCenterService().searchNotice(searchValue, currentPage, limit);

		System.out.println("@@@ list : " + list);

		String page="";

		if(list != null) {
			System.out.println("널이 아님!");
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			page = "views/serviceCenter/searchNoticeResult.jsp";
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "검색 실패!");
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
