package com.kh.hp.myPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.AhnLevelupVO;
import com.kh.hp.myPage.model.vo.AhnMyPageVO;

/**
 * Servlet implementation class LevelUpInfoServlet
 */
@WebServlet("/levelUpInfo")
public class LevelUpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LevelUpInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int levelUpInfo = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();
		AhnLevelupVO responseUserVO = new AhnMyPageService().updateLevelOne(levelUpInfo);
		
		String page = "";
		if(responseUserVO != null) {
			request.setAttribute("msg", "신청이 완료되었습니다.");
			page = "views/common/errorPage.jsp";
			
		}else {
			request.setAttribute("msg", "신청이 불가합니다.");
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
