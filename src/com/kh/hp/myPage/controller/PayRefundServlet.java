package com.kh.hp.myPage.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.AhnPayRefundVO;

/**
 * Servlet implementation class PayRefundServlet
 */
@WebServlet("/payRefund")
public class PayRefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayRefundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("payRefund 들어옴");
		int userInfo = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();
		int propSeq = Integer.parseInt(request.getParameter("propSeq"));
		int payAmount = Integer.parseInt(request.getParameter("payAmount"));
		
		System.out.println("userInfo : " + userInfo);
		System.out.println("propSeq : " + propSeq);
		System.out.println("payAmount : " + payAmount);
		
		int result = new AhnMyPageService().payRefundInsert(userInfo, propSeq, payAmount);
		
		System.out.println("result : " + result);
		
		if(result > 0) {
			System.out.println("완성");
			response.sendRedirect("moveMain.main");
		}else {
			response.sendRedirect("moveMain.main");
			
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
