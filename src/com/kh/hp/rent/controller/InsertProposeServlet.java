package com.kh.hp.rent.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.hp.common.MyFileRenamePolicy;
import com.kh.hp.rent.model.vo.AttachmentVO;
import com.kh.hp.rent.model.vo.RentPropVO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertProposeServlet
 */
@WebServlet("/insertPropose.rt")
public class InsertProposeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProposeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if(ServletFileUpload.isMultipartContent(request)) {

			int userSeq = 2;
			int maxSize = 1024 * 1024 * 10; // 제한 MB
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			String profileSavePath = rootPath + "/perfPlanCer/";
			MultipartRequest multipartRequest = new MultipartRequest(request, profileSavePath, maxSize, "UTF-8", new MyFileRenamePolicy());

			String propNm = multipartRequest.getParameter("propNm");
			String propPhone1 = multipartRequest.getParameter("propPhone1");
			String propPhone2 = multipartRequest.getParameter("propPhone2");
			String propPhone3 = multipartRequest.getParameter("propPhone3");
			String propPhone = propPhone1 + "-" + propPhone2 + "-" + propPhone3;
			String propEmail = multipartRequest.getParameter("propEmail");
			String propReqContent = multipartRequest.getParameter("propReqContent");
			String useStartDt = multipartRequest.getParameter("useStartDt");
			String useEndDt = multipartRequest.getParameter("useEndDt");
			int propHeadCount = Integer.parseInt(multipartRequest.getParameter("propHeadCount"));

			RentPropVO rentPropVO = new RentPropVO();
			rentPropVO.setPropNm(propPhone);
			rentPropVO.setPropEmail(propEmail);
			rentPropVO.setPropReqContent(propReqContent);
			rentPropVO.setPropHeadCount(propHeadCount);
			rentPropVO.setUseStartDt(Date.valueOf(useStartDt));
			rentPropVO.setUseEndDt(Date.valueOf(useEndDt));

			System.out.println(rentPropVO);


			Enumeration<String> imgFiles = multipartRequest.getFileNames();
			String attSaveFile = "";
			String attOriginFile = "";

			if(imgFiles.hasMoreElements()) {
				System.out.println("이미지 있다!");
				String name = imgFiles.nextElement();
				attSaveFile = multipartRequest.getFilesystemName(name);
				attOriginFile = multipartRequest.getOriginalFileName(name);
			}

			AttachmentVO attachmentVO = new AttachmentVO();
			attachmentVO.setOriginNm(attOriginFile);
			attachmentVO.setChangeNm(attSaveFile);

			System.out.println(attachmentVO);
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
