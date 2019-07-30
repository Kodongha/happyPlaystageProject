package com.kh.hp.modifyRentInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.hp.modifyRentInfo.model.service.ModifyService;
import com.kh.hp.rent.model.vo.CautionsVO;
import com.kh.hp.rent.model.vo.RentImgVO;

/**
 * Servlet implementation class RentImgServlet
 */
@WebServlet("/rentImg.md")
public class RentImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModifyService modifyService = new ModifyService();

		int rentSeq = Integer.parseInt(request.getParameter("rentSeq"));
		List<RentImgVO> rentImgVOList = (List<RentImgVO>) modifyService.getrentInfo(rentSeq).get("rentImgVOList");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(rentImgVOList, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
