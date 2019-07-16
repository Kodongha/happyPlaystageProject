package com.kh.hp.rent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.rent.model.vo.RentBasicVO;

/**
 * Servlet implementation class moveContactEnroll
 */
@WebServlet("/moveContact.rent")
public class moveContactEnroll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public moveContactEnroll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get in!!");

		RentBasicVO requestRentBasicVO = (RentBasicVO) request.getAttribute("requestRentBasicVO1");

		String rentEmail = request.getParameter("rentEmail");
		String rentPhone1 = request.getParameter("rentPhone1");
		String rentPhone2 = request.getParameter("rentPhone2");
		String rentPhone3 = request.getParameter("rentPhone3");
		String rentPhone = rentPhone1 + rentPhone2 + rentPhone3;

		String rentMainTel1 = request.getParameter("rentMainTel1");
		String rentMainTel2 = request.getParameter("rentMainTel2");
		String rentMainTel3 = request.getParameter("rentMainTel3");
		String rentMainTel = rentMainTel1 + rentMainTel2 + rentMainTel3;

		System.out.println(requestRentBasicVO);



		System.out.println("rentEmail::"+rentEmail);
		System.out.println("rentPhone::"+rentPhone);
		System.out.println("rentMainTel::"+rentMainTel);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post in!!");
		doGet(request, response);
	}

}
