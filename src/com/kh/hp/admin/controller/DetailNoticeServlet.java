package com.kh.hp.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.NoticeService;
import com.kh.hp.admin.model.service.UserService;
import com.kh.hp.admin.model.vo.NoticeVO;
import com.kh.hp.admin.model.vo.User;

/**
 * Servlet implementation class DetailNoticeServlet
 */
@WebServlet("/detailNotice.ad")
public class DetailNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("상세공지사항에들어왔니?");
		
		int noticeSeq  = Integer.parseInt(request.getParameter("noticeSeq"));
		
		NoticeVO noticeVO = new NoticeService().selectOne(noticeSeq);

		String page = "";

		if(noticeVO != null) {
			
			request.setAttribute("noticeVO", noticeVO);
			page = "views/admin/DetailNotice.jsp";

		} else {
			page = "views/main/main.jsp";

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
