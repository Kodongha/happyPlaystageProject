package com.kh.hp.rent.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.rent.model.service.RentService;

/**
 * Servlet implementation class MoveRentDetailServlet
 */
@WebServlet("/MoveRentDetail.rt")
public class MoveRentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveRentDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rentSeq = Integer.parseInt(request.getParameter("rentSeq"));

		System.out.println("rentSeq ::: " + rentSeq);
		RentService rentService = new RentService();
		ArrayList<Object> rentInfos = rentService.selectRentOne(rentSeq);

		String page = "";
		if(rentInfos != null) {
			request.setAttribute("rentInfos", rentInfos);
			page = "views/rent/rentDetail.jsp";
		} else {
			page = "views/common/errorPage.jsp";
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
