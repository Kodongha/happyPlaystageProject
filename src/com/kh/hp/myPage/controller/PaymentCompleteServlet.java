package com.kh.hp.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.PaymentVO;

/**
 * Servlet implementation class paymentCompleteServlet
 */
@WebServlet("/payComplete.my")
public class PaymentCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("payComplete in");

		int propSeq = Integer.parseInt(request.getParameter("propSeq"));
		String receiptId = request.getParameter("receipt_id");
		String status = request.getParameter("status");
		String amount = request.getParameter("amount");

		/* 검증 */
		System.out.println("--------------------------------------------");
		System.out.println("propSeq:::" + propSeq);
		System.out.println("receiptId:::" + receiptId);
		System.out.println("status:::" + status);
		System.out.println("amount:::" + amount);

		PaymentVO paymentVO = new PaymentVO(propSeq, receiptId, status, amount);

		AhnMyPageService ahnMyPageService = new AhnMyPageService();
		// boolean paymentResult = ahnMyPageService.validatePayment(paymentVO);
		int result = ahnMyPageService.changeStatus(paymentVO);

		if(result > 0) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(result, response.getWriter());
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
