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
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/notice.sc")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(":::공지사항 서블릿 호출:::");

		//페이징 처리 전
		//ArrayList<Notice> list = new ServiceCenterService().selectAllNotice();

		//페이징 처리
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

		int listCount = new ServiceCenterService().getListCount();

		System.out.println("@@ list count : " + listCount);

		maxPage = (int)((double)listCount / limit + 0.9);

		startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * 10 + 1;

		endPage = startPage + 10 -1;

		if(maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

		ArrayList<Notice> list = new ServiceCenterService().selectNoticeList(currentPage, limit);


		String page="";
		if(list != null) {
			page="views/serviceCenter/notice.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
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
