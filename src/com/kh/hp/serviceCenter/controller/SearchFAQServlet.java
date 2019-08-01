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
 * Servlet implementation class SearchFAQServlet
 */
@WebServlet("/searchFAQ.sc")
public class SearchFAQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFAQServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("%%% FAQ 서블릿 호출 &&&");

		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");

/*		System.out.println("%%%"+category);
		System.out.println("%%%%"+keyword);*/

		ArrayList<FaQVO> list = new ServiceCenterService().searchFAQ(category, keyword);

		System.out.println(list);
		String page="";

		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("category", category);

			page="views/serviceCenter/fAQ.jsp";
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
