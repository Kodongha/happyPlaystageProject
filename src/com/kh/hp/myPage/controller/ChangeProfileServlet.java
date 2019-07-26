package com.kh.hp.myPage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.hp.common.MyFileRenamePolicy;
import com.kh.hp.myPage.model.service.MyPageService_mh;
import com.kh.hp.myPage.model.vo.UserImgVO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ChangeProfileServlet
 */
@WebServlet("/changeProfile.mp")
public class ChangeProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("프로필 사진 변경 버튼 클릭!!");

			if (ServletFileUpload.isMultipartContent(request)) {
				System.out.println("파일업로드 in!");

				int maxSize = 1024 * 1024 * 10;

				String root = request.getSession().getServletContext().getRealPath("/");
				System.out.println(root);
				String savePath = root + "images/myPage/profile/";
				System.out.println("savaPath :::::!!!!! "+savePath);

				int userSeq = ((com.kh.hp.account.model.vo.UserVO) request.getSession().getAttribute("user")).getUserSeq();

				MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
						new MyFileRenamePolicy(userSeq));

				ArrayList<String> saveFiles = new ArrayList<String>();

				ArrayList<String> originFiles = new ArrayList<String>();

				Enumeration<String> files = multiRequest.getFileNames();

				while (files.hasMoreElements()) {
					String name = files.nextElement();

					saveFiles.add(multiRequest.getFilesystemName(name));

					originFiles.add(multiRequest.getOriginalFileName(name));

					System.out.println("fileSystem name : " + multiRequest.getFilesystemName(name));
					System.out.println("originFile name : " + multiRequest.getOriginalFileName(name));
				}

				UserImgVO us = new UserImgVO();
				us.setUserSeq(userSeq);

				ArrayList<UserImgVO> fileList = new ArrayList<UserImgVO>();
				for (int i = originFiles.size() - 1; i >= 0; i--) {
					UserImgVO ui = new UserImgVO();
					ui.setFilePath(savePath);
					ui.setOriginNm(originFiles.get(0));
					ui.setChangeNm(saveFiles.get(0));

					fileList.add(ui);
				}
				System.out.println("userImgVO ==== "+us);

				//int result = new MyPageService_mh().insertProfile(userSeq, fileList);
			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
