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

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.common.MyFileRenamePolicy;
import com.kh.hp.rent.model.service.RentService;
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

			int maxSize = 1024 * 1024 * 10;
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			String profileSavePath = rootPath + "/perfPlanCer/";
			MultipartRequest multipartRequest = new MultipartRequest(request, profileSavePath, maxSize, "UTF-8", new MyFileRenamePolicy());

			// VO Setting
			int userSeq = ((UserVO)request.getSession().getAttribute("user")).getUserSeq(); // 작성자 회원번호

			int rentSeq = Integer.parseInt(multipartRequest.getParameter("rentSeq"));
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
			int payAmount = Integer.parseInt(multipartRequest.getParameter("payAmount"));

			RentPropVO rentPropVO = new RentPropVO();
			rentPropVO.setRentSeq(rentSeq);
			rentPropVO.setPropNm(propNm);
			rentPropVO.setUserSeq(userSeq);
			rentPropVO.setPropPhone(propPhone);
			rentPropVO.setPropEmail(propEmail);
			rentPropVO.setPropReqContent(propReqContent);
			rentPropVO.setPropHeadCount(propHeadCount);
			rentPropVO.setUseStartDt(Date.valueOf(useStartDt));
			rentPropVO.setUseEndDt(Date.valueOf(useEndDt));
			rentPropVO.setPayAmount(payAmount);

			System.out.println(rentPropVO);

			// 첨부파일 처리
			Enumeration<String> imgFiles = multipartRequest.getFileNames();
			String attSaveFile = "";
			String attOriginFile = "";

			if(imgFiles.hasMoreElements()) {
				String name = imgFiles.nextElement();
				attSaveFile = multipartRequest.getFilesystemName(name);
				attOriginFile = multipartRequest.getOriginalFileName(name);
			}

			AttachmentVO attachmentVO = new AttachmentVO();
			attachmentVO.setOriginNm(attOriginFile);
			attachmentVO.setChangeNm(attSaveFile);
			attachmentVO.setFilePath(profileSavePath);

			System.out.println(attachmentVO);

			int result = new RentService().insertPorp(rentPropVO, attachmentVO);

			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/applyInfo1");
			} else {
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}

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
