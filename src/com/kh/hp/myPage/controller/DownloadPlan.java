package com.kh.hp.myPage.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.RentPropAndAttachmentVO;

/**
 * Servlet implementation class DownloadPlan
 */
@WebServlet("/downloadPlan.my")
public class DownloadPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadPlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String propSeq = request.getParameter("propSeq");

		RentPropAndAttachmentVO rentPropAndAttachmentVO = new AhnMyPageService().selectRentPropAndAttachment(propSeq);

		System.out.println(rentPropAndAttachmentVO);

		BufferedInputStream buf = null;

		ServletOutputStream downOut = response.getOutputStream();

		File downFile = new File(rentPropAndAttachmentVO.getFilePath() + rentPropAndAttachmentVO.getChangeNm());

		response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(rentPropAndAttachmentVO.getOriginNm().getBytes("UTF-8"), "ISO-8859-1") + "\""); // 공백문자를 공백문자로 인식하기 위해 ISO-8859-1 방식의 인코딩 사용
		response.setContentLength((int) downFile.length());

		buf = new BufferedInputStream(new FileInputStream(downFile));

		int readBytes = 0;
		while((readBytes = buf.read()) != -1) {
		   downOut.write(readBytes);
		}
		downOut.close();
		buf.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
