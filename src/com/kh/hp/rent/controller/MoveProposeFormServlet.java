package com.kh.hp.rent.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.rent.model.service.RentService;
import com.kh.hp.rent.model.vo.RentPropVO;

/**
 * Servlet implementation class MoveProposeFormServlet
 */
@WebServlet("/movePropose.rt")
public class MoveProposeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveProposeFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String requestProposeDate = request.getParameter("schedule");
		int requestHeadCount = Integer.parseInt(request.getParameter("headCount"));
		int requestRentSeq = Integer.parseInt(request.getParameter("rentSeq"));

		String [] temp = requestProposeDate.split(" to ");

		RentPropVO rentPropVO = new RentPropVO();
		rentPropVO.setUseStartDt(Date.valueOf(temp[0]));
		rentPropVO.setUseEndDt(Date.valueOf(temp[1]));
		rentPropVO.setPropHeadCount(requestHeadCount);

		ArrayList<Object> rentInfoList = new RentService().getRentInfoList(requestRentSeq, rentPropVO);

		String page = "";
		if(rentInfoList != null) {
			page = "views/rent/rentPropse.jsp";
			request.setAttribute("rentInfoList", rentInfoList);
		} else {
			page = "views/common/error.jsp";
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
