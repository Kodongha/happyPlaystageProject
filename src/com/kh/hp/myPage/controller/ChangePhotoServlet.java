package com.kh.hp.myPage.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.common.MyFileRenamePolicy;
import com.kh.hp.myPage.model.service.MyPageService_mh;
import com.kh.hp.myPage.model.vo.UserImgVO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ChangePhotoServlet
 */
@WebServlet("/chageProfilePhoto.my")
public class ChangePhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int userSeq = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();

		System.out.println("doGet in");
		if(ServletFileUpload.isMultipartContent(request)) {
			System.out.println("if in");
			int maxSize = 1024 * 1024 * 10; // 제한 MB
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			String profileSavePath = rootPath + "/images/myPage/myProfile/";

			MultipartRequest multipartRequest = new MultipartRequest(request, profileSavePath, maxSize, "UTF-8", new MyFileRenamePolicy(userSeq));

			Enumeration<String> imgFile = multipartRequest.getFileNames();

			String imgSvaeFile = "";
			String imgOriginFile = "";
			while(imgFile.hasMoreElements()) {
				String name = imgFile.nextElement();
				imgSvaeFile = multipartRequest.getFilesystemName(name);
				imgOriginFile = multipartRequest.getOriginalFileName(name);
			}


			UserImgVO userImgVO = new UserImgVO(userSeq, imgOriginFile, imgSvaeFile, profileSavePath, null);

			System.out.println(imgSvaeFile);
			System.out.println(imgOriginFile);

			int result = new MyPageService_mh().changeProfilePhoto(userImgVO);

			if(result > 0) {
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				new Gson().toJson(result, response.getWriter());
			}


		} // end if


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
