package com.kh.hp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.SearchUserService;
import com.kh.hp.admin.model.service.UserService;
import com.kh.hp.admin.model.vo.PageInfo;
import com.kh.hp.admin.model.vo.User;

/**
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/searchUser.ad")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원검색서블릿으로 들어왔나요 ?");

		String userSeq1 = request.getParameter("userSeq1");
		String userSeq2 = request.getParameter("userSeq2");
		String userNm = request.getParameter("userNm");
		String userGradeCd = request.getParameter("userGradeCd");
		String leaveTf = request.getParameter("leaveTf");

		if(userGradeCd.equals("??")) {
			userGradeCd = "선택";
		}

		if(leaveTf.equals("??")) {
			leaveTf = "선택";
		}

		System.out.println("userSeq1::" + userSeq1);
		System.out.println("userSeq2::" + userSeq2);
		System.out.println("userNm::" + userNm);
		System.out.println("userGradeCd::" + userGradeCd);
		System.out.println("leaveTf::" + leaveTf);

		//페이징처리 전
		//ArrayList<User> list = new UserService().selectAll();

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


		boolean userSeq1Tf = false;
		boolean userSeq2Tf = false;
		boolean userNmTf = false;
		boolean userGradeCdTf = false;
		boolean leaveTfTf = false;

		// 입력값 확인
		if(userSeq1 != null && !userSeq1.equals("")) {
			userSeq1Tf = true;
		}
		if(userSeq2 != null && !userSeq2.equals("")) {
			userSeq2Tf = true;
		}
		if(userNm != null && !userNm.equals("")) {
			userNmTf = true;
		}
		if(!leaveTf.equals("선택") && !leaveTf.equals("")) {
			leaveTfTf = true;
		}
		if(!userGradeCd.equals("선택") && !userGradeCd.equals("")) {
			userGradeCdTf = true;
		}


		int listCount = 0;

		//전체검색시
		if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && !leaveTfTf ) {
			System.out.println("전체 검색 in");
			listCount = new SearchUserService().getListCountforAll();


			//이름만검색시
		}else if(!(userSeq1Tf && userSeq2Tf) && userNmTf && !userGradeCdTf && !leaveTfTf) {
			System.out.println("이름 검색 in");
			listCount = new SearchUserService().getListCountforName(userNm);


			//회원번호로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && !leaveTfTf ) {
			System.out.println("회원번호 검색 in");
			listCount = new SearchUserService().getListCountforSeq(userSeq1, userSeq2);


			//대관등록승인으로만 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && userGradeCdTf && !leaveTfTf ) {
			System.out.println("대관등록승인 검색 in");
			listCount = new SearchUserService().getListCountforCd(userGradeCd);


			//탈퇴로만 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && leaveTfTf ) {
			System.out.println("탈퇴로만 검색 in");
			listCount = new SearchUserService().getListCountforleave(leaveTf);


			//회원번호,회원명으로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && userNmTf && !userGradeCdTf && !leaveTfTf ) {
			System.out.println("회원번호, 회원명으로 검색 in");
			listCount = new SearchUserService().getListCountforSeqNm(userSeq1, userSeq2, userNm);


			//회원번호,대관등록승인으로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && !userNmTf && userGradeCdTf && !leaveTfTf ) {
			System.out.println("회원번호, 대관등록승인 검색 in");
			listCount = new SearchUserService().getListCountforSeqCd(userSeq1, userSeq2, userGradeCd);

			//회원번호,탈퇴여부로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && leaveTfTf ) {
			System.out.println("회원번호, 탈퇴여부 검색 in");
			listCount = new SearchUserService().getListCountforSeqleave(userSeq1, userSeq2, leaveTf);

			//회원명, 대관등록승인으로 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && userNmTf && userGradeCdTf && !leaveTfTf ) {
			System.out.println("회원명, 대관등록승인 검색 in");
			listCount = new SearchUserService().getListCountforNmCd(userNm, userGradeCd);

			//회원명, 탈퇴여부로 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && userNmTf && !userGradeCdTf && leaveTfTf ) {
			System.out.println("회원명, 탈퇴여부 검색 in");
			listCount = new SearchUserService().getListCountforNmleave(userNm,  leaveTf);


			//대관등록승인, 탈퇴여부로 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && userGradeCdTf && leaveTfTf ) {
			System.out.println("대관등록승인, 탈퇴여부 검색 in");
			listCount = new SearchUserService().getListCountforCdleave(userGradeCd,  leaveTf);

		}





		//전체 목록 갯수를 리턴받음
		/*listCount = new UserService().getListCount();
		System.out.println("갯수 : " + listCount);
*/
		System.out.println("listCount : " + listCount);

		//총 페이지 수 계산
		//예를 들면, 목록 수가 124개이면 페이지 수는 13페이지이다.
		maxPage = (int)((double)listCount / limit + 0.9);

		//현재 페이지에서 보여줄 시작 페이지 숫자
		//아래쪽에 페이지 수가 10개씩 보여지게 한다면
		//1, 11, 21, 31, ....
		startPage = (((int)((double) currentPage / limit + 0.9)) - 1) * 10+ 1;

		//목록 아래 쪽에 보여질 마지막 페이지 수
		//10, 20, 30,...
		endPage = startPage + 10 - 1;

		if(maxPage < endPage) {
			endPage = maxPage;
		}

		PageInfo pi =
				new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);



		ArrayList<User> searchUserList = new SearchUserService().searchUserList(userSeq1 ,userSeq2, userNm ,userGradeCd, leaveTf,currentPage, limit);

		System.out.println("searchUserList:::::" + searchUserList);






		String page = "";

		if(searchUserList != null) {

			request.setAttribute("list", searchUserList);
			request.setAttribute("pi", pi);
			page = "views/admin/01_userManagement.jsp";

			request.getRequestDispatcher(page).forward(request, response);

		} else {
			System.out.println("에러!!!!!!!!!!!!!!");
			page = request.getContextPath() + "/searchUser.ad?userSeq1=&userSeq2=&userNm=&userGradeCd=선택&leaveTf=선택";
			response.sendRedirect(page);
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
