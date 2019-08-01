package com.kh.hp.rent.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.hp.rent.model.service.RentService;
import com.kh.hp.rent.model.vo.RefundTypeVO;

/**
 * Servlet implementation class GetrentRefundTypeInfoServlet
 */
@WebServlet("/getrentRefundTypeInfo.rt")
public class GetrentRefundTypeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetrentRefundTypeInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int rentRefundTypeSeq = Integer.parseInt(request.getParameter("rentRefundTypeSeq"));

		ArrayList<RefundTypeVO> refundTypeVOList = new RentService().getrentRefundTypeInfo(rentRefundTypeSeq);

		for(RefundTypeVO refundTypeVO : refundTypeVOList) {
			System.out.println("refundTypeVO::" + refundTypeVO);
		}

		if(refundTypeVOList != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(refundTypeVOList, response.getWriter());
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
