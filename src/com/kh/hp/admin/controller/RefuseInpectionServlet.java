package com.kh.hp.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.RefuseInpectionService;
import com.kh.hp.admin.model.service.UpdateInpectionService;

/**
 * Servlet implementation class RefuseInpectionServlet
 */
@WebServlet("/refuseInpection.ad")
public class RefuseInpectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RefuseInpectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("대관 등록 검수 리스트 상세 거절로 들어왔나요?");


		int rentSeq = Integer.parseInt(request.getParameter("rentSeq"));



		int result = new RefuseInpectionService().RefuseInpection(rentSeq);

		System.out.println("거절버튼의 결과:::" + result);

		String page = "";

		if(result > 0) {
			page = request.getContextPath() + "/inspectionList.ad";
			response.sendRedirect(page);
		} else {
			page = "view/common/errorPage.jsp";
			request.getRequestDispatcher(page).forward(request, response);
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
