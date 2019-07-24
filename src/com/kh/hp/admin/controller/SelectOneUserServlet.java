package com.kh.hp.admin.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.UserService;

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
		
		//simpleDateFormat format = new  simpleDateFormat format("yyyy-MM-dd");

		int userSeq = Integer.parseInt(request.getParameter("userSeq"));
		String userEmail = request.getParameter("userEmail");
		String userPwd = request.getParameter("userPwd");
		String userNm = request.getParameter("userNm");
		String userNick = request.getParameter("userNick");
		String userPhone = request.getParameter("userPhone");
		int userGradeCd = Integer.parseInt(request.getParameter("userGradeCd"));
		//Date enrollDt = request.getParameter("enrollDt");	
		int snsCd = Integer.parseInt(request.getParameter("snsCd"));
		//char leaveTf = request.getParameter("leaveTf");
		//Date leaveDt


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
