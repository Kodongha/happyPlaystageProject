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
import com.kh.hp.rent.model.vo.RefundTypeVO;

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

		RentService rentService = new RentService();

		/*세부 시설 정보 가져오기*/
		ArrayList<DetFacVO> detFacVOList = rentService.selectDetFacAll();
		System.out.println("detFacVOList:::" + detFacVOList);

		/*환불 유형 정보 가져오기*/
		ArrayList<RefundTypeVO> refundTypeVOList = rentService.selectRefunctTypeAll();
		System.out.println("refundTypeVOList:::" + refundTypeVOList);

		String page = "";
		if(detFacVOList != null && refundTypeVOList != null) {
			page = "views/rent/rentBasicEnroll.jsp";
			request.setAttribute("detFacVOList", detFacVOList);
			request.setAttribute("refundTypeVOList", refundTypeVOList);
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
