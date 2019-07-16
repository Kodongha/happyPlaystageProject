package com.kh.hp.rent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.rent.model.vo.RentBasicVO;

/**
 * Servlet implementation class moveRentBasicInfoServlet
 */
@WebServlet("/moveRentBasicInfo.rent")
public class moveRentBasicInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public moveRentBasicInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get in!!");

		int userSeq = ((UserVO)request.getSession().getAttribute("user")).getUserSeq();
		String hallNm = request.getParameter("hallNm");
		String hallSimIntro = request.getParameter("hallSimIntro");
		String hallDetIntro = request.getParameter("hallDetIntro");
		String website = request.getParameter("website");
		String address = request.getParameter("address");
		char perfPlanTf = 'Y';
		if(request.getParameter("perfPlanTf") == null) {
			perfPlanTf = 'N';
		}

		RentBasicVO requestRentBasicVO = new RentBasicVO();
		requestRentBasicVO.setUserSeq(userSeq);
		requestRentBasicVO.setHallNm(hallNm);
		requestRentBasicVO.setHallSimIntro(hallSimIntro);
		requestRentBasicVO.setHallDetIntro(hallDetIntro);
		requestRentBasicVO.setWebsite(website);
		requestRentBasicVO.setAddress(address);
		requestRentBasicVO.setPerfPlanTf(perfPlanTf);

		System.out.println("request::"+requestRentBasicVO);

		request.setAttribute("requestRentBasicVO", requestRentBasicVO);
		request.getRequestDispatcher("views/rent/contactEnroll.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post in!");
		doGet(request, response);
	}

}
