package com.kh.hp.account.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.FindIdService;
import com.kh.hp.account.model.vo.UserVO;

/**
 * Servlet implementation class FindIdServlet
 */
@WebServlet("/findId.acc")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");

		UserVO uv = new FindIdService().findId(userName, userPhone);
		
		System.out.println("인증!");
	
		String page = "";
		

		if(uv != null) {
			page = "views/common/findIdSc.jsp";
			request.setAttribute("uv", uv);
			System.out.println("");
		} else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "아이디 찾기 실패");
			System.out.println("");
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
