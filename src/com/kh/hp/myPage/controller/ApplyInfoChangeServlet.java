package com.kh.hp.myPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.AhnMyPageService;

/**
 * Servlet implementation class ApplyInfoChangeServlet
 */
@WebServlet("/applyInfoChange")
public class ApplyInfoChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyInfoChangeServlet() {
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
		
		System.out.println("userInfo : " + userInfo);
		System.out.println("propSeq : " + propSeq);
		
		int result = new AhnMyPageService().applyInfoChangeInsert(userInfo, propSeq);
		
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
