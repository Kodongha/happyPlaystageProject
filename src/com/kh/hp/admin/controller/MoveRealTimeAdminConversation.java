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
 * Servlet implementation class MoveRealTimeAdminConversation
 */
@WebServlet("/moveRealTimeAdminConversation.ad")
public class MoveRealTimeAdminConversation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveRealTimeAdminConversation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String roomSeq = request.getParameter("roomSeq");

		// 대화 내용 가져오기
		ArrayList<RealTimeVO> realTimeVOs = new RealTimeService().selectConversationList(roomSeq);

		for(RealTimeVO realTimeVO : realTimeVOs) {
			System.out.println("moveRealTimeAdminConversation ::" + realTimeVO);
		}

		String page = "views/admin/12_1vs1answer.jsp";
		request.setAttribute("realTimeVOs", realTimeVOs);
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
