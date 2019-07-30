package com.kh.hp.myPage.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.common.MyFileRenamePolicy;
import com.kh.hp.myPage.model.service.AhnMyPageService;
import com.kh.hp.myPage.model.vo.AhnAttachmentVO;
import com.kh.hp.myPage.model.vo.AhnLevelupInfoVO;
import com.kh.hp.myPage.model.vo.AhnLevelupVO;
import com.kh.hp.myPage.model.vo.AhnMyPageVO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class LevelUpInfoServlet
 */
@WebServlet("/levelUpInfo")
public class LevelUpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LevelUpInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("method in!");
		if(ServletFileUpload.isMultipartContent(request)) {
			System.out.println("in!");

			int maxSize = 1024 * 1024 * 10;

			String root = request.getSession().getServletContext().getRealPath("/");

			String savePath = root + "myPage_uploadFiles/";
			System.out.println("savePath:::" + savePath);
			int levelUpInfo = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();

			// 저장 안됨
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy(levelUpInfo));

			ArrayList<String> saveFiles = new ArrayList<String>();
			ArrayList<String> originFiles = new ArrayList<String>();

			Enumeration<String> files = multiRequest.getFileNames();

			while(files.hasMoreElements()) {
				String name = files.nextElement();

				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));

				System.out.println("fileSystem name : " + multiRequest.getFilesystemName(name));
				System.out.println("originFile name : " + multiRequest.getOriginalFileName(name));

			}


			AhnLevelupInfoVO l = new AhnLevelupInfoVO();
			l.setUserSeq(levelUpInfo);

			System.out.println("insert levelup : " + l);

			ArrayList<AhnAttachmentVO> fileList = new ArrayList<AhnAttachmentVO>();

			for(int i = originFiles.size() - 1; i >= 0; i--) {
				AhnAttachmentVO at = new AhnAttachmentVO();
				at.setFilePath(savePath);
				at.setOriginNm(originFiles.get(i));
				at.setChangeNm(saveFiles.get(i));
				at.setUserSeq(levelUpInfo);
				fileList.add(at);
			}

			System.out.println("controller board : " + levelUpInfo);
			System.out.println("controller attachment list : " + fileList);

			// int result = new AhnMyPageService().insertImage(levelUpInfo, fileList);
			int result = new AhnMyPageService().insertImage(l, fileList);

			String page = "";

			if(result > 0) {
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "등업신청이 정상적으로 처리되었습니다.");
			}else {

				for(int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(savePath + saveFiles.get(i));
					failedFile.delete();
				}
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "등업신청에 실패했습니다");
			}
			request.getRequestDispatcher(page).forward(request, response);
		}


		/*int levelUpInfo = ((UserVO) request.getSession().getAttribute("user")).getUserSeq();



		s
		AhnLevelupInfoVO l = new AhnLevelupInfoVO();
		l.setUserSeq(levelUpInfo);

		System.out.println("insert levelup : " + l);

		int result = new AhnMyPageService().insertLevelOne(l, levelUpInfo);

		String page = "";

		if(result > 0) {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "등업 신청이 완료되었습니다");
			request.getRequestDispatcher(page).forward(request, response);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "등업 신청 실패했습니다");
			request.getRequestDispatcher(page).forward(request, response);
		}*/



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
