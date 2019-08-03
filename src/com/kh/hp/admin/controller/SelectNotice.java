package com.kh.hp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class SelectNotice
 */
@WebServlet("/SelectNotice")
public class SelectNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNotice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("공지사항셀렉에 들어왔나요?");
		
		
		ArrayList<NoticeVO> Noticelist = new NoticeService().selectNotice();
		
		
		String page = "";

		if(Noticelist != null) {
			request.setAttribute("Noticelist", Noticelist);
			page = "views/admin/ManagerNotice.jsp";

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
