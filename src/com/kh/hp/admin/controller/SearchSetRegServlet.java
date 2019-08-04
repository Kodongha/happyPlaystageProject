package com.kh.hp.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchSetRegServlet
 */
@WebServlet("/searchSetReg.ad")
public class SearchSetRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSetRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("등업검색서블릿");

		String userSeq1 = request.getParameter("userSeq1");
		String userSeq2 = request.getParameter("userSeq2");
		String userNm = request.getParameter("userNm");
		String userGradeStatus = request.getParameter("userGradeStatus");
		
		System.out.println("userSeq1:::"+userSeq1);
		System.out.println("userSeq2:::"+userSeq2);
		System.out.println("userNm:::"+userNm);
		System.out.println("userGradeStatus:::"+userGradeStatus);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
