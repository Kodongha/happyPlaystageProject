package com.kh.hp.rent.controller;

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
import com.kh.hp.rent.model.vo.AttachmentVO;
import com.kh.hp.rent.model.vo.CautionsVO;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RentBasicVO;
import com.kh.hp.rent.model.vo.RentDetVO;
import com.kh.hp.rent.model.vo.RentImgVO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class moveRentBasicInfoServlet
 */
@WebServlet("/moveRentBasicInfo.rent")
public class RentBasicInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentBasicInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if(ServletFileUpload.isMultipartContent(request)) {

			/*#################################### S T E P - 1 ####################################*/
			int userSeq = ((UserVO)request.getSession().getAttribute("user")).getUserSeq(); // 작성자 회원번호
			int maxSize = 1024 * 1024 * 10; // 제한 MB

			String rootPath = request.getSession().getServletContext().getRealPath("/");

			String profileSavePath = rootPath + "/images/profilePhotos/";
			String attachSavePath = rootPath + "/attachment/hallRegisCer/";

			MultipartRequest multipartRequest = new MultipartRequest(request, profileSavePath, maxSize, "UTF-8", new MyFileRenamePolicy(userSeq));

			String hallNm = multipartRequest.getParameter("hallNm");				// 공연장 명
			String hallSimIntro = multipartRequest.getParameter("hallSimIntro"); 	// 한줄 소개
			String hallDetIntro = multipartRequest.getParameter("hallDetIntro"); 	// 상세 소개

			String [] facInfoContentArray = multipartRequest.getParameterValues("facInfoContentReq");	// 시설 안내
			String [] cautionContentArray = multipartRequest.getParameterValues("cautionContentReq");	// 주의사항
			String [] detAddressArray = multipartRequest.getParameterValues("detAddressReq");			// 주의사항


			String website = multipartRequest.getParameter("website");	// 웹사이트
			String address = multipartRequest.getParameter("address");	// 주소
			char perfPlanTf = 'Y';
			if(multipartRequest.getParameter("perfPlanTf") == null) {
				perfPlanTf = 'N';
			}


			/*RentBasicVO 세팅*/
			RentBasicVO requestRentBasicVO = new RentBasicVO();
			requestRentBasicVO.setUserSeq(userSeq);
			requestRentBasicVO.setHallNm(hallNm);
			requestRentBasicVO.setHallSimIntro(hallSimIntro);
			requestRentBasicVO.setHallDetIntro(hallDetIntro);
			requestRentBasicVO.setWebsite(website);
			requestRentBasicVO.setAddress(address);
			requestRentBasicVO.setPerfPlanTf(perfPlanTf);

			/*FacInfoVO 세팅*/
			ArrayList<FacInfoVO> facInfoVOList = new ArrayList<FacInfoVO>();
			for(int i=0; i<facInfoContentArray.length; i++){
				FacInfoVO facInfoVO = new FacInfoVO();
				facInfoVO.setFacInfoContent(facInfoContentArray[i]);
				facInfoVOList.add(facInfoVO);
			}

			/*CautionsVO 세팅*/
			ArrayList<CautionsVO> cautionsVOList = new ArrayList<CautionsVO>();
			for(int i=0; i<cautionContentArray.length; i++){
				CautionsVO cautionsVO = new CautionsVO();
				cautionsVO.setCautionContent(cautionContentArray[i]);
				cautionsVOList.add(cautionsVO);
			}

			/*RentDetVO 세팅*/
			ArrayList<RentDetVO> rentDetVOList = new ArrayList<RentDetVO>();
			for(int i=0; i<detAddressArray.length; i++) {
				RentDetVO rentDetVO = new RentDetVO();
				rentDetVO.setDetAddress(detAddressArray[i]);
				rentDetVOList.add(rentDetVO);
			}


			/*##########이미지/첨부 파일 관련##########*/
			ArrayList<String> imgSaveFiles = new ArrayList<String>();
			ArrayList<String> imgOriginFiles = new ArrayList<String>();
			Enumeration<String> imgFiles = multipartRequest.getFileNames();

			String attSaveFile = "";
			String attOriginFile = "";
			while(imgFiles.hasMoreElements()) {
				String name = imgFiles.nextElement();

				if(!name.equals("hallRegisCerPathInput")) {
					// 이미지 파일 관련
					imgSaveFiles.add(multipartRequest.getFilesystemName(name));
					imgOriginFiles.add(multipartRequest.getOriginalFileName(name));
				} else {
					// 그 외 첨부파일 관련
					attSaveFile = multipartRequest.getFilesystemName(name);
					attOriginFile = multipartRequest.getOriginalFileName(name);
				}
			}

			/*RentImgVO 세팅*/
			ArrayList<RentImgVO> rentImgVOList = new ArrayList<RentImgVO>();
			for(int i = imgOriginFiles.size() - 1; i >= 0; i--) {
				RentImgVO rentImgVO = new RentImgVO();
				rentImgVO.setOriginNm(imgOriginFiles.get(i));
				rentImgVO.setChangeNm(imgSaveFiles.get(i));
				rentImgVO.setFilePath(profileSavePath);
				rentImgVOList.add(rentImgVO);
			}

			/*AttachmentVO 세팅*/
			AttachmentVO attachmentVO = new AttachmentVO();
			attachmentVO.setOriginNm(attOriginFile);
			attachmentVO.setChangeNm(attSaveFile);
			attachmentVO.setFilePath(profileSavePath);


			/*##########출력 구문 관련##########*/
			System.out.println("공연장 명 :::" + requestRentBasicVO.getHallNm());
			System.out.println("공연장 한 줄 소개 :::" + requestRentBasicVO.getHallSimIntro());
			System.out.println("공연장 상세 소개 :::" + requestRentBasicVO.getHallDetIntro());

			for(FacInfoVO facInfoVO : facInfoVOList) {
				System.out.println("시설안내 :::" + facInfoVO);
			}

			for(CautionsVO cautionsVO : cautionsVOList) {
				System.out.println("주의사항 :::" + cautionsVO);
			}

			System.out.println("웹사이트 :::" + requestRentBasicVO.getWebsite());

			for(RentImgVO rentImgVO : rentImgVOList) {
				System.out.println("사진 :::" + rentImgVO);
			}

			System.out.println("주소 ::: " + requestRentBasicVO.getAddress());

			for(RentDetVO rentDetVO : rentDetVOList) {
				System.out.println("상세주소:::" + rentDetVO);
			}

			System.out.println("공연장 등록증 첨부 ::: " + attachmentVO);

			System.out.println("공연 계획서 첨부 여부 ::: " + requestRentBasicVO.getPerfPlanTf());


			/*#################################### S T E P - 2 ####################################*/
/*
			String rentEmail = multipartRequest.getParameter("rentEmail");
			System.out.println(rentEmail);

			String rentPhone1 = multipartRequest.getParameter("rentPhone1");
			String rentPhone2 = multipartRequest.getParameter("rentPhone2");
			String rentPhone3 = multipartRequest.getParameter("rentPhone3");
			String rentPhone = rentPhone1 + "-" + rentPhone2 + "-" + rentPhone3;
			System.out.println(rentPhone);

			String rentMainTel1 = multipartRequest.getParameter("rentMainTel1");
			String rentMainTel2 = multipartRequest.getParameter("rentMainTel2");
			String rentMainTel3 = multipartRequest.getParameter("rentMainTel3");
			String rentMainTel = rentMainTel1 + "-" + rentMainTel2 + "-" + rentMainTel3;
			System.out.println(rentMainTel);

			requestRentBasicVO.setRentEmail(rentEmail);
			requestRentBasicVO.setRentPhone(rentPhone);
			requestRentBasicVO.setRentMainTel(rentMainTel);
*/

			/*#################################### S T E P - 3 ####################################*/
			String availStartTm = multipartRequest.getParameter("availStartTm");
			String availEndTm = multipartRequest.getParameter("availEndTm");
			String minRsvTm = multipartRequest.getParameter("minRsvTm");
			String maxHeadCount = multipartRequest.getParameter("maxHeadCount");
			String regCloseCd = multipartRequest.getParameter("regCloseCd");

			System.out.println("availStartTm::" + availStartTm);
			System.out.println("availEndTm::" + availEndTm);
			System.out.println("minRsvTm::" + minRsvTm);
			System.out.println("maxHeadCount::" + maxHeadCount);
			System.out.println("regCloseCd::" + regCloseCd);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post in!");
		doGet(request, response);
	}

}
