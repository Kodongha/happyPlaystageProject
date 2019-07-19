package com.kh.hp.myPage.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.AhnMyPageVO;
import com.oreilly.servlet.MultipartRequest;


/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/levelUp")
public class LevelUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LevelUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int userSeq = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();
		AhnMyPageVO responseUserVO = new AhnMyPageService().selectOne(userSeq);
		 
		 
		 String page = "";
		 if(responseUserVO != null) {
			 request.setAttribute("responseUserVO", responseUserVO);
			 page = "views/myPage/levelUp.jsp";
		 }else {
			 request.setAttribute("msg", "조회된 정보가 없습니다.");
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