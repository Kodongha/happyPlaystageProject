package com.kh.hp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.UserService;
import com.kh.hp.admin.model.vo.User;

/**
 * Servlet implementation class UserSearchServlet
 */
@WebServlet("/userSearch.ad")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userSeqStart = request.getParameter("userSeqStart");
		String userSeqEnd = request.getParameter("userSeqEnd");
		String userNm = request.getParameter("userNm");
		String userGradeStatus = request.getParameter("userGradeStatus");
		String leaveTf = request.getParameter("leaveTf");
		
		
		User requestUser = new User();
		requestUser.setUserNm(userNm);
		if(userGradeStatus.equals("Y")) {
			requestUser.setUserGradeCd(2);
		} else {
			requestUser.setUserGradeCd(1);
		}
		requestUser.setLeaveTf(leaveTf.charAt(0));
		
		System.out.println("userSeqStart:::" + userSeqStart);
		System.out.println("userSeqEnd:::" + userSeqEnd);
		System.out.println("userNm:::" + userNm);
		System.out.println("userGradeStatus:::" + userGradeStatus);
		System.out.println("leaveTf:::" + leaveTf);
		
		ArrayList<User> searchUserList = new UserService().userSearch(userSeqStart, userSeqEnd, requestUser);
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
