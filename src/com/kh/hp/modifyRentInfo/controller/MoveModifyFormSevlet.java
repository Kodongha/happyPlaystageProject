package com.kh.hp.modifyRentInfo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.modifyRentInfo.model.service.ModifyService;

/**
 * Servlet implementation class MoveModifyFormSevlet
 */
@WebServlet("/moveModifyRentForm.up")
public class MoveModifyFormSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveModifyFormSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in!!!");

		// 수정하기 버튼 클릭시 해당 공연장 고유번호 전달받기
		int rentSeq = 1; // 임시

		ModifyService modifyService = new ModifyService();

		ArrayList<Object> rentInfo = modifyService.getrentInfo(rentSeq);

		String page = "";
		if(rentInfo != null) {
			page="views/modifyRentInfo/rentBasicModify.jsp";
			request.setAttribute("rentInfo", rentInfo);
		} else {

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
