package com.kh.hp.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.admin.model.service.UseHistoryService;
import com.kh.hp.admin.model.service.UserService;
import com.kh.hp.admin.model.vo.PageInfo;
import com.kh.hp.admin.model.vo.UseHistoryVO;
import com.kh.hp.admin.model.vo.User;
import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;

/**
 * Servlet implementation class SelectOneUserServlet
 */
@WebServlet("/selectOneUser.ad")
public class SelectOneUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectOneUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("selectOne으로 들어왔나요??");


		int userSeq  = Integer.parseInt(request.getParameter("userSeq"));

		System.out.println(userSeq);

		//회원조회용 서비스
		User oneUser = new UserService().selectOne(userSeq);

		System.out.println("oneUser:::" + oneUser);
s

		//request.getRequestDispatcher(page).forward(request, response);





		System.out.println("사용내역서블릿진행할차례");
		
		//페이징처리 후
				int currentPage;		//현재 페이지를 표시할 변수
				int limit;				//한 페이지에 보여질 게시물 수
				int maxPage;			//전체 페이지에서 가장 마지막 페이지
				int startPage;			//한 번에 표시될 페이징 버튼이 시작할 번호
				int endPage;			//한 번에 표시될 페이징 버튼이 끝나는 번호

				//게시판은 1페이지부터 시작함
				currentPage = 1;

				if(request.getParameter("currentPage") != null) {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}

				//한 페이지에 보여질 목록 갯수
				limit = 10;

				//전체 목록 갯수를 리턴받음
				int listCount = new UserService().getListCount();

				System.out.println("listCount : " + listCount);

				//총 페이지 수 계산
				//예를 들면, 목록 수가 124개이면 페이지 수는 13페이지이다.
				maxPage = (int)((double)listCount / limit + 0.9);

				//현재 페이지에서 보여줄 시작 페이지 숫자
				//아래쪽에 페이지 수가 10개씩 보여지게 한다면
				//1, 11, 21, 31, ....
				startPage = (((int)((double) currentPage / limit + 0.9)) - 1) * 10 + 1;

				//목록 아래 쪽에 보여질 마지막 페이지 수
				//10, 20, 30,...
				endPage = startPage + 10 - 1;

				if(maxPage < endPage) {
					endPage = maxPage;
				}

				PageInfo pi = 
						new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

				//대관사용내역리스트 
				ArrayList<UseHistoryVO> UseHistoryVOlist = new UseHistoryService().UseHistoryVOlist(currentPage, limit);

	
				
				String page = "";

				if(UseHistoryVOlist != null) {
					request.setAttribute("oneUser", oneUser);
					request.setAttribute("UseHistoryVOlist", UseHistoryVOlist);
					request.setAttribute("pi", pi);
					page = "views/admin/02_userDetailPage.jsp";

				} else {
					page = "views/main/main.jsp";

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
