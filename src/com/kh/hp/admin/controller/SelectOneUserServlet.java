package com.kh.hp.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.UserService;
import com.kh.hp.admin.model.vo.User;

/**
 * Servlet implementation class SelectOneUserServlet
 */
@WebServlet("/selectOneUser.ad")
public class SelectOneUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectOneUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("selectOne으로 들어왔나요??");
	

		int userSeq  = Integer.parseInt(request.getParameter("userSeq"));
		
		System.out.println(userSeq);
		
		
		User oneUser = new UserService().selectOne(userSeq);
		
		System.out.println("oneUser:::" + oneUser);
	
		String page = "";
		
		if(oneUser != null) {
			request.setAttribute("oneUser", oneUser);
			page = "views/admin/02_userDetailPage.jsp";
		}else {
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
