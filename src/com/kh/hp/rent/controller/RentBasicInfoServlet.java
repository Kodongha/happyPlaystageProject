package com.kh.hp.rent.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
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
import com.kh.hp.common.MyFileRenamePolicy;
import com.kh.hp.rent.model.service.RentService;
import com.kh.hp.rent.model.vo.AttachmentVO;
import com.kh.hp.rent.model.vo.CautionsVO;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RentBasicVO;
import com.kh.hp.rent.model.vo.RentCloseVO;
import com.kh.hp.rent.model.vo.RentDetFacVO;
import com.kh.hp.rent.model.vo.RentDetVO;
import com.kh.hp.rent.model.vo.RentImgVO;
import com.kh.hp.rent.model.vo.RentRefundTypeVO;
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
//			int userSeq = ((UserVO)request.getSession().getAttribute("user")).getUserSeq(); // 작성자 회원번호
			int userSeq = 2;
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

			/*##########이미지/첨부 파일 관련##########*/
			ArrayList<String> imgSaveFiles = new ArrayList<String>();
			ArrayList<String> imgOriginFiles = new ArrayList<String>();
			Enumeration<String> imgFiles = multipartRequest.getFileNames();

			String attSaveFile = "";
			String attOriginFile = "";
			String corpRegisCerSaveFile = "";
			String corpRegisCerOriginFile = "";
			while(imgFiles.hasMoreElements()) {
				String name = imgFiles.nextElement();

				if(name.equals("hallRegisCerPathInput")) {
					// 이미지 파일 관련
					attSaveFile = multipartRequest.getFilesystemName(name);
					attOriginFile = multipartRequest.getOriginalFileName(name);


				} else if(name.equals("corpRegisCerPathInput")){
					// 그 외 첨부파일 관련
					corpRegisCerSaveFile = multipartRequest.getFilesystemName(name);
					corpRegisCerOriginFile = multipartRequest.getOriginalFileName(name);

				} else {
					imgSaveFiles.add(multipartRequest.getFilesystemName(name));
					imgOriginFiles.add(multipartRequest.getOriginalFileName(name));
				}

			}

			/*#################################### S T E P - 2 ####################################*/
			String rentEmail = multipartRequest.getParameter("rentEmail");

			/*핸드폰*/
			String rentPhone1 = multipartRequest.getParameter("rentPhone1");
			String rentPhone2 = multipartRequest.getParameter("rentPhone2");
			String rentPhone3 = multipartRequest.getParameter("rentPhone3");
			String rentPhone = rentPhone1 + "-" + rentPhone2 + "-" + rentPhone3;

			/*추가 핸드폰*/

			/*대표번호*/
			String rentMainTel1 = multipartRequest.getParameter("rentMainTel1");
			String rentMainTel2 = multipartRequest.getParameter("rentMainTel2");
			String rentMainTel3 = multipartRequest.getParameter("rentMainTel3");
			String rentMainTel = rentMainTel1 + "-" + rentMainTel2 + "-" + rentMainTel3;

			/*#################################### S T E P - 3 ####################################*/

			String availStartTm = multipartRequest.getParameter("availStartTm");
			String availEndTm = multipartRequest.getParameter("availEndTm");
			String useTimeUnit = multipartRequest.getParameter("useTimeUnit");
			int minRsvTm = Integer.parseInt(multipartRequest.getParameter("minRsvTm"));
			int maxHeadCount = Integer.parseInt(multipartRequest.getParameter("maxHeadCount"));
			int regCloseCd = Integer.parseInt(multipartRequest.getParameter("regCloseCd"));
			String selectedDetFacIcon = multipartRequest.getParameter("selectedDetFacIcon");
			String cusCloseNm = multipartRequest.getParameter("cusCloseNm");
			int rentPrice = Integer.parseInt(multipartRequest.getParameter("rentPrice"));

			String cusClosedate = multipartRequest.getParameter("cusClosedate");
			Date cusCloseStart = null;
			Date cusCloseEnd = null;


			/*캘린더 설정*/
			if(cusClosedate != null && !cusClosedate.equals("")) {
				String[] temp = cusClosedate.split(" to ");
				cusCloseStart = Date.valueOf(temp[0]);
				cusCloseEnd = Date.valueOf(temp[1]);
			}

			/*#################################### S T E P - 4 ####################################*/


			String compNm = multipartRequest.getParameter("compNm");	// 상호명
			String ceoNm = multipartRequest.getParameter("ceoNm");	// 대표명

			/*사업자 번호*/
			String corpNo1 = multipartRequest.getParameter("corpNo1");
			String corpNo2 = multipartRequest.getParameter("corpNo2");
			String corpNo3 = multipartRequest.getParameter("corpNo3");
			String corpNo = corpNo1 + "-" + corpNo2 + "-" + corpNo3;

			/*사업장 주소*/
			String corpAddress1 = multipartRequest.getParameter("corpAddress1");
			String corpAddress2 = multipartRequest.getParameter("corpAddress2");
			String corpAddress = corpAddress1 + "§§" + corpAddress2;

			String settleEmail = multipartRequest.getParameter("settleEmail"); // 정산용 이메일

			/*정산용 연락처*/
			String settlePhone1 = multipartRequest.getParameter("settlePhone1");
			String settlePhone2 = multipartRequest.getParameter("settlePhone2");
			String settlePhone3 = multipartRequest.getParameter("settlePhone3");
			String settlePhone = settlePhone1 + "-" + settlePhone2 + "-" + settlePhone3;

			String bankNm = multipartRequest.getParameter("bankNm");	// 은행명
			String accNo = multipartRequest.getParameter("accNo");	// 계좌번호
			String accHolder = multipartRequest.getParameter("accHolder");	// 예금주

			int rentRefundTypeSeq = Integer.parseInt(multipartRequest.getParameter("rentRefundTypeSeq"));	// 환불유형
			System.out.println("rentRefundTypeSeq::::::" + rentRefundTypeSeq);

			/*#################################### V O - Setting ####################################*/


			RentBasicVO requestRentBasicVO = new RentBasicVO(); // 대관 기본 정보 테이블
			ArrayList<FacInfoVO> facInfoVOList = new ArrayList<FacInfoVO>(); 	// 시설안내 테이블
			ArrayList<RentDetVO> rentDetVOList = new ArrayList<RentDetVO>();	// 대관 상세정보 테이블
			ArrayList<CautionsVO> cautionsVOList = new ArrayList<CautionsVO>();	// 주의사항 테이블
			ArrayList<RentDetFacVO> requestRentDetFacVOList = new ArrayList<RentDetFacVO>();	// 대관세부시설 테이블
			ArrayList<RentImgVO> rentImgVOList = new ArrayList<RentImgVO>();	// 대관이미지 파일 테이블
			ArrayList<AttachmentVO> attachmentVOList = new ArrayList<AttachmentVO>();	// 첨부파일 테이블
			RentCloseVO requestRentCloseVO = new RentCloseVO();	// 대관별 휴무일 테이블
			RentRefundTypeVO requestRentRefundTypeVO = new RentRefundTypeVO();	// 대관별 환불유형


			/*requestRentBasicVO 세팅*/
			// step1
			requestRentBasicVO.setUserSeq(userSeq);
			requestRentBasicVO.setHallNm(hallNm);
			requestRentBasicVO.setHallSimIntro(hallSimIntro);
			requestRentBasicVO.setHallDetIntro(hallDetIntro);
			requestRentBasicVO.setWebsite(website);
			requestRentBasicVO.setAddress(address);
			requestRentBasicVO.setPerfPlanTf(perfPlanTf);
			// step2
			requestRentBasicVO.setRentEmail(rentEmail);
			requestRentBasicVO.setRentPhone(rentPhone);
			requestRentBasicVO.setRentMainTel(rentMainTel);
			// step3
			requestRentBasicVO.setAvailStartTm(availStartTm);
			requestRentBasicVO.setUseTimeUnit(useTimeUnit);
			requestRentBasicVO.setAvailEndTm(availEndTm);
			requestRentBasicVO.setMinRsvTm(minRsvTm);
			// step4
			requestRentBasicVO.setCompNm(compNm);
			requestRentBasicVO.setCeoNm(ceoNm);
			requestRentBasicVO.setCorpNo(corpNo);
			requestRentBasicVO.setCorpAddress(corpAddress);
			requestRentBasicVO.setSettleEmail(settleEmail);
			requestRentBasicVO.setSettlePhone(settlePhone);
			requestRentBasicVO.setBankNm(bankNm);
			requestRentBasicVO.setAccNo(accNo);
			requestRentBasicVO.setAccHolder(accHolder);

			requestRentBasicVO.setRentEnrollStatus("검수");

			/*FacInfoVO 세팅*/
			// step1
			for(int i=0; i<facInfoContentArray.length; i++){
				FacInfoVO facInfoVO = new FacInfoVO();
				facInfoVO.setFacInfoContent(facInfoContentArray[i]);
				facInfoVO.setFacInfoNo(i + 1);
				facInfoVOList.add(facInfoVO);
			}

			/*CautionsVO 세팅*/
			// step1
			for(int i=0; i<cautionContentArray.length; i++){
				CautionsVO cautionsVO = new CautionsVO();
				cautionsVO.setCautionContent(cautionContentArray[i]);
				cautionsVO.setCautionNo(i + 1);
				cautionsVOList.add(cautionsVO);
			}

			/*RentDetVO 세팅*/
			// step1
			for(int i=0; i<detAddressArray.length; i++) {
				RentDetVO rentDetVO = new RentDetVO();
				rentDetVO.setDetAddress(detAddressArray[i]);
				rentDetVO.setRentPrice(rentPrice);
				rentDetVO.setMaxHeadCount(maxHeadCount);
				rentDetVOList.add(rentDetVO);
			}

			/*RentImgVO세팅*/
			// step1
			for(int i = imgOriginFiles.size() - 1; i >= 0; i--) {
				RentImgVO rentImgVO = new RentImgVO();
				rentImgVO.setOriginNm(imgOriginFiles.get(i));
				rentImgVO.setChangeNm(imgSaveFiles.get(i));
				rentImgVO.setFilePath(profileSavePath);
				rentImgVOList.add(rentImgVO);
			}

			/*AttachmentVO 세팅*/
			// step1
			// 공연장 등록증
			AttachmentVO hallRegisCerPathVO = new AttachmentVO();
			hallRegisCerPathVO.setOriginNm(attOriginFile);
			hallRegisCerPathVO.setChangeNm(attSaveFile);
			hallRegisCerPathVO.setFilePath(profileSavePath);
			hallRegisCerPathVO.setSubType(2);
			hallRegisCerPathVO.setFileType(2);

			// 사업자 등록증
			AttachmentVO corpRegisCerPathVO = new AttachmentVO();
			corpRegisCerPathVO.setOriginNm(attOriginFile);
			corpRegisCerPathVO.setChangeNm(attSaveFile);
			corpRegisCerPathVO.setFilePath(profileSavePath);
			corpRegisCerPathVO.setSubType(1);
			corpRegisCerPathVO.setFileType(2);

			attachmentVOList.add(hallRegisCerPathVO);
			attachmentVOList.add(corpRegisCerPathVO);

			/*세부 시설 세팅*/
			if(selectedDetFacIcon != null && !selectedDetFacIcon.equals("")) {
				selectedDetFacIcon= selectedDetFacIcon.replace("detFacIcon_", "");
				String[] detFacSeqArray = selectedDetFacIcon.split(",");
				for(String rentDetFacSeq : detFacSeqArray) {
					RentDetFacVO requestRentDetFacVO = new RentDetFacVO();
					requestRentDetFacVO.setDetFacSeq(Integer.parseInt(rentDetFacSeq));

					requestRentDetFacVOList.add(requestRentDetFacVO);
				}
			}

			/*requestRentCloseVO 세팅*/
			// step3
			requestRentCloseVO.setRegCloseCd(regCloseCd);		// 정기 휴무
			requestRentCloseVO.setCusCloseStart(cusCloseStart);	// 지정 휴무 시작날짜
			requestRentCloseVO.setCusCloseEnd(cusCloseEnd);		// 지정 휴무 종료날짜
			requestRentCloseVO.setCusCloseNm(cusCloseNm);		// 지정 휴무 종료날짜


			/*requestRentRefundTypeVO 세팅*/
			// step4
			requestRentRefundTypeVO.setRefundSeq(rentRefundTypeSeq);


			/*수정 사항*/
			requestRentBasicVO.setHallRegisCerPath("");



			/*print*/
			System.out.println("+++++++++++++++++++++++");
			System.out.println(requestRentBasicVO);
			System.out.println("+++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++");

			for(int i=0; i<facInfoVOList.size(); i++) {
				System.out.println(facInfoVOList.get(i));
			}
			System.out.println("+++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++");

			for(int i=0; i<rentDetVOList.size(); i++) {
				System.out.println(rentDetVOList.get(i));
			}

			System.out.println("+++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++");

			for(int i=0; i<cautionsVOList.size(); i++) {
				System.out.println(cautionsVOList.get(i));
			}

			System.out.println("+++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++");

			for(int i=0; i<requestRentDetFacVOList.size(); i++) {
				System.out.println(requestRentDetFacVOList.get(i));
			}

			System.out.println("+++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++");

			for(int i=0; i<rentImgVOList.size(); i++) {
				System.out.println(rentImgVOList.get(i));
			}

			System.out.println("+++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++");

			for(int i=0; i<attachmentVOList.size(); i++) {
				System.out.println(attachmentVOList.get(i));
			}

			System.out.println(requestRentCloseVO);
			System.out.println(requestRentRefundTypeVO);

			int result = new RentService().insertRentInfo(requestRentBasicVO, facInfoVOList, rentDetVOList, cautionsVOList, requestRentDetFacVOList, rentImgVOList, attachmentVOList, requestRentCloseVO, requestRentRefundTypeVO);

			System.out.println("result:::::::" + result);

			String page = "";
			/*
			if(result == 1) {
				page = request.getContextPath() + "/moveMain.main";
				response.sendRedirect(page);
			}
*/
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
