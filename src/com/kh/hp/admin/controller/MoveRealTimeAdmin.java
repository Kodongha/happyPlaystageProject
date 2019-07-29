package com.kh.hp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.RealTimeService;
import com.kh.hp.admin.model.vo.RealTimeVO;

/**
 * Servlet implementation class MoveRealTimeAdmin
 */
@WebServlet("/moveRealTimeAdmin.ad")
public class MoveRealTimeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveRealTimeAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("moveRealTimeAdmin in");

		// 대화방 리스트 가져오기
		ArrayList<RealTimeVO> realTimeVOs = new RealTimeService().selectRealTimeList();

		String page = "";
		if(realTimeVOs != null) {
			request.setAttribute("realTimeVOs", realTimeVOs);
			page = "views/admin/11_1vs1.jsp";
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
