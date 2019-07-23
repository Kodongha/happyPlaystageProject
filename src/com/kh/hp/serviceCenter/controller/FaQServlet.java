package com.kh.hp.serviceCenter.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.serviceCenter.model.service.ServiceCenterService;
import com.kh.hp.serviceCenter.model.vo.FaQVO;

/**
 * Servlet implementation class FaQServlet
 */
@WebServlet("/faq.sc")
public class FaQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaQServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String content = request.getParameter("content");

		ArrayList<FaQVO> list = new ServiceCenterService().selectFaQ();

		String page = "";
		if(list != null) {
			page="views/serviceCenter/fAQ.jsp";
			request.setAttribute("list", list);
			System.out.println(list);
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
