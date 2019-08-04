package com.kh.hp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.NoticeService;
import com.kh.hp.admin.model.service.SearchUserService;
import com.kh.hp.admin.model.vo.NoticeVO;
import com.kh.hp.admin.model.vo.User;

/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/noticeSearch.ad")
public class NoticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("공지사항 검색영역으로 들어왔니?");

		String search = request.getParameter("search");
		String cate  = request.getParameter("cate");

		System.out.println("noticeSearch:::" + search);
		System.out.println("noticeCate:::" + cate);
		
		
		ArrayList<NoticeVO> noticeSearch = new NoticeService().noticeSearch(search,cate);

		System.out.println("noticeSearch:::::::::::" + noticeSearch);
		String page = " ";
		
		if(noticeSearch !=null) {
			
			request.setAttribute("Noticelist", noticeSearch);
			request.setAttribute("search", search);
			request.setAttribute("cate", cate);
			
			page = "views/admin/ManagerNotice.jsp";
			
			
			request.getRequestDispatcher(page).forward(request, response);
		}else {
			
			
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
