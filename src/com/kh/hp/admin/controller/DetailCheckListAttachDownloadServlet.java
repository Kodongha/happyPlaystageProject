package com.kh.hp.admin.controller;

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

import com.kh.hp.admin.model.service.RegisCerService;
import com.kh.hp.admin.model.vo.AttachmentVO;

/**
 * Servlet implementation class DetailCheckListAttachDownloadServlet
 */
@WebServlet("/download.tn")
public class DetailCheckListAttachDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailCheckListAttachDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("download in!!");

		int rentSeq = Integer.parseInt(request.getParameter("rentSeq"));

		AttachmentVO file = new RegisCerService().regisCer(rentSeq);
		System.out.println("등록증서블릿파일::::"+file);

		//폴더에서 파일을 읽어들일 스트림 생성
		BufferedInputStream buf = null;

		//클라이언트로 내보낼 스트림 생성
		ServletOutputStream downOut = response.getOutputStream();

		//스트림으로 전송할 파일 객체 생성
		File downFile = new File(file.getFilePath() + file.getChangeNm());

		//한글이나 특수문자 때문에 파일명 인코딩 처리
		//강제적으로 다운로드 처리
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ new String(file.getOriginNm().getBytes("UTF-8"), "ISO-8859-1")
				+ "\"");
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
