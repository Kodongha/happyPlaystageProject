package com.kh.hp.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.NoticeService;
import com.kh.hp.admin.model.vo.NoticeVO;


/**
 * Servlet implementation class NoticeWirteServlet
 */
@WebServlet("/noticeWirte.ad")
public class NoticeWirteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeWirteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("공시자항등록 서블릿에 접속했나요?");

		String noticeCate = request.getParameter("noticeCate");
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
	

		System.out.println("noticeCate:::" + noticeCate);
		System.out.println("noticeTitle:::" + noticeTitle);
		System.out.println("noticeContent:::" + noticeContent);
		
		NoticeVO  NoticeWirte = new NoticeVO();
		
		NoticeWirte.setNoticeCate(noticeCate);
		NoticeWirte.setNoticeTitile(noticeTitle);
		NoticeWirte.setNoticeContent(noticeContent);
		
		
		int result = new NoticeService().insertnoticeWirte(NoticeWirte);
		
		String page = "";
		
		
		if(result > 0) {
			
			request.getRequestDispatcher("/SelectNotice").forward(request, response);
		
		}else {
		
			page = "views/main/main.jsp";

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
