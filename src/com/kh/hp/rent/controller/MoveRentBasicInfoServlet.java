package com.kh.hp.rent.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.rent.model.service.RentService;
import com.kh.hp.rent.model.vo.DetFacVO;

/**
 * Servlet implementation class MoveRentBasicInfoServlet
 */
@WebServlet("/MoveRentEnroll.rt")
public class MoveRentBasicInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveRentBasicInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in!!!");
		ArrayList<DetFacVO> detFacVOList = new RentService().selectDetFacAll();
		System.out.println("detFacVOList:::" + detFacVOList);

		String page = "";
		if(detFacVOList != null) {
			page = "views/rent/rentBasicEnroll.jsp";
			request.setAttribute("detFacVOList", detFacVOList);
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
