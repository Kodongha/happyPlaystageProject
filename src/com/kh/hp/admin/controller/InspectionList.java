package com.kh.hp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.admin.model.service.InspectionListService;
import com.kh.hp.admin.model.service.SetRegPermissionsService;
import com.kh.hp.admin.model.service.UserService;
import com.kh.hp.admin.model.vo.InspectionListVO;
import com.kh.hp.admin.model.vo.PageInfo;
import com.kh.hp.admin.model.vo.SetRegPermissionsVO;

/**
 * Servlet implementation class InspectionList
 */
@WebServlet("/inspectionList.ad")
public class InspectionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InspectionList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("등록검수리스트에 들어왔나요?");
		
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
				ArrayList<InspectionListVO> InspectionListVOList = new InspectionListService().InspectionList(currentPage, limit);
			
				String page = "";

				if(InspectionListVOList != null) {
					
					request.setAttribute("InspectionListVOList", InspectionListVOList);
					request.setAttribute("pi", pi);

					page = "views/admin/04_checkList.jsp";

//				} else {
//					page = "views/main/main.jsp";

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
