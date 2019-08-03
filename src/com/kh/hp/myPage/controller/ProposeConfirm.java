package com.kh.hp.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.hp.myPage.model.service.MyPageService_mh;

/**
 * Servlet implementation class ProposeConfirm
 */
@WebServlet("/proposeConfirm.mp")
public class ProposeConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProposeConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int propSeq = Integer.parseInt(request.getParameter("propSeq"));
		System.out.println("propSeq :: " + propSeq);

		int result = new MyPageService_mh().changePropStatusConfirm(propSeq);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if(result > 0) {
			new Gson().toJson(1, response.getWriter());
		} else {
			new Gson().toJson(0, response.getWriter());
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
