package com.kh.hp.myPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.AhnLevelupInfoVO;
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
		/*int levelUpInfo = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();
		AhnLevelupVO responseUserVO = new AhnMyPageService().insertLevelOne(levelUpInfo);
		
		String page = "";
		if(responseUserVO != null) {
			request.setAttribute("msg", "신청이 완료되었습니다.");
			page = "views/common/errorPage.jsp";
			
		}else {
			request.setAttribute("msg", "신청이 불가합니다.");
			page = "views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);*/
		
		int levelUpInfo = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();
		
		//String filePath = request.getParameter("filePath");
		//System.out.println("filePath : " + filePath);
		
		
		
		AhnLevelupInfoVO l = new AhnLevelupInfoVO();
		l.setUserSeq(levelUpInfo);
		
		System.out.println("insert levelup : " + l);
		
		int result = new AhnMyPageService().insertLevelOne(l, levelUpInfo);
		
		String page = "";
		
		if(result > 0) {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "등업 신청이 완료되었습니다");
			request.getRequestDispatcher(page).forward(request, response);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "등업 신청 실패했습니다");
			request.getRequestDispatcher(page).forward(request, response);
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
