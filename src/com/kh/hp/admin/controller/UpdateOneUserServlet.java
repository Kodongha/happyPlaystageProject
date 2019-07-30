package com.kh.hp.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.admin.model.service.UpdateOneUserService;
import com.kh.hp.admin.model.service.UserService;
import com.kh.hp.admin.model.vo.AttachmentVO;
import com.kh.hp.admin.model.vo.UpdateUserVO;
import com.kh.hp.admin.model.vo.User;
import com.kh.hp.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

import oracle.sql.Mutable;


/**
 * Servlet implementation class UpdateOneUserServlet
 */
@WebServlet("/updateOneUser.ad")
public class UpdateOneUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateOneUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("updateOneUser서블릿접속::::");

		//이미지 업데이트용
		if(ServletFileUpload.isMultipartContent(request)) {

			//전송 파일 용량 제한 : 10Mbyte로 제한
			int maxSize = 1024 * 1024 * 10;

			//웹서버 컨테이너 경로 추출
			String root = request.getSession().getServletContext().getRealPath("/");

			System.out.println(root);


			//파일 저장 경로(web/thumbnail_uploadFiles)
			String savePath = root + "myPage_uploadFiles/";

			//FileRenamePolicy 상속 후 오버라이딩
			MultipartRequest multiRequest =
					new MultipartRequest(request, savePath, maxSize,
							"UTF-8", new MyFileRenamePolicy());


			//다중파일을 묶어서 업로드를 하기 위해 컬렉션 이용
			//저장한 파일(변경된 파일의) 이름을 저장할 ArrayList 객체 생성
			ArrayList<String> saveFiles = new ArrayList<String>();
			//원본 파일의 이름을 저장할 ArrayList 생성
			ArrayList<String> originFiles = new ArrayList<String>();


			//파일이 전송된 이름을 반환한다
			Enumeration<String> files = multiRequest.getFileNames();

			while(files.hasMoreElements()) {
				String name = files.nextElement();

				System.out.println(name);

				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));


				System.out.println("fileSystem name : " + multiRequest.getFilesystemName(name));
				System.out.println("originFile name : " + multiRequest.getOriginalFileName(name));
			}

			//MultipartRequest 객체를 이용하여 파일 외의 값들도 꺼낼 수 있다.

			int multiuserseq = Integer.parseInt(multiRequest.getParameter("userseq"));
			String multiuserEmail =  multiRequest.getParameter("userEmail");
			String multiuserNm  =multiRequest.getParameter("userNm");
			String multiuserNick = multiRequest.getParameter("userNick");
			String multiuserPhone = multiRequest.getParameter("userPhone");

			int multiuserGradeCd = 0;
			if(multiRequest.getParameter("userGradeCd").equals("Y")) {
				multiuserGradeCd = 2;
			} else {
				multiuserGradeCd = 1;
			}

			Date multienrollDt =  Date.valueOf(multiRequest.getParameter("enrollDt"));
			int multisnsCd = Integer.parseInt(multiRequest.getParameter("snsCd"));
			char multileaveTf = multiRequest.getParameter("leaveTf").charAt(0);
			String leavDt = multiRequest.getParameter("leaveDt");
			Date multileaveDt = null;
			if(leavDt != null && !leavDt.equals("")) {
				multileaveDt =  Date.valueOf(leavDt);
			}



			UpdateUserVO updateUser = new UpdateUserVO ();

			updateUser.setUserSeq(multiuserseq);
			updateUser.setUserEmail(multiuserEmail);
			updateUser.setUserNm(multiuserNm);
			updateUser.setUserNick(multiuserNick);
			updateUser.setUserPhone(multiuserPhone);
			updateUser.setUserGradeCd(multiuserGradeCd);
			updateUser.setEnrollDt(multienrollDt);
			updateUser.setSnsCd(multisnsCd);
			updateUser.setLeaveTf(multileaveTf);
			updateUser.setLeaveDt(multileaveDt);


			System.out.println("updateUser::::::" +updateUser);

			int result = new UpdateOneUserService().updateOneUser(updateUser);

			System.out.println("result::::" +result);

			String page = "";
			if(result > 0) {
				page = request.getContextPath() + "/selectAllUser.ad";
				response.sendRedirect(page);
			} else {
				page = "view/common/errorPage.jsp";
				request.getRequestDispatcher(page).forward(request, response);
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
