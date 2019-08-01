package com.kh.hp.modifyRentInfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.modifyRentInfo.model.service.ModifyService;
import com.kh.hp.rent.model.vo.DetFacVO;
import com.kh.hp.rent.model.vo.RefundTypeVO;
import com.kh.hp.rent.model.vo.RentImgVO;

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
		int rentSeq = Integer.parseInt(request.getParameter("rentSeq")); // 임시

		System.out.println("rentSeq:::" + rentSeq);

		ModifyService modifyService = new ModifyService();

		Map<String, Object> rentInfo = modifyService.getrentInfo(rentSeq);
		ArrayList<DetFacVO> detFacVOList = modifyService.getDetFac(rentSeq);
		ArrayList<RefundTypeVO> refundTypeVOList = modifyService.getRefundType(rentSeq);

		String page = "";
		if(rentInfo != null && detFacVOList != null && refundTypeVOList != null) {
			page="views/modifyRentInfo/rentBasicModify.jsp";
			request.setAttribute("rentInfo", rentInfo);
			request.setAttribute("detFacVOList", detFacVOList);
			request.setAttribute("refundTypeVOList", refundTypeVOList);
		} else {
			System.out.println("널입니다.!!!!!!!!!!!!!!!");
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
