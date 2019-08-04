package com.kh.hp.modifyRentInfo.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kh.hp.modifyRentInfo.model.dao.ModifyDao;
import com.kh.hp.rent.model.dao.RentDao;
import com.kh.hp.rent.model.vo.AttachmentVO;
import com.kh.hp.rent.model.vo.CautionsVO;
import com.kh.hp.rent.model.vo.DetFacAndRentDetFacVO;
import com.kh.hp.rent.model.vo.DetFacVO;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RefundTypeVO;
import com.kh.hp.rent.model.vo.RentBasicVO;
import com.kh.hp.rent.model.vo.RentCloseVO;
import com.kh.hp.rent.model.vo.RentDetVO;
import com.kh.hp.rent.model.vo.RentImgVO;

public class ModifyService {

	/**
	 * 수정 데이터 값 가져오기
	 * @param rentSeq
	 * @return
	 */
	public Map<String, Object> getrentInfo(int rentSeq) {
		Connection con = getConnection();

		ModifyDao modifyDao = new ModifyDao();
		Map<String, Object> rentBasicInfoMap = new HashMap<String, Object>();

		// RENT_BAISC 테이블
		RentBasicVO rentBasicVO = modifyDao.selectRentBasic(con, rentSeq);
		System.out.println("modifyService ::::::" + rentBasicVO);
		//FAC_INFO 테이블
		ArrayList<FacInfoVO> facInfoVOList = modifyDao.selectFacInfo(con, rentSeq);
		//CAUTIONS 테이블
		ArrayList<CautionsVO> cautionsVOList = modifyDao.selectCaution(con, rentSeq);
		//RENT_DET 테이블
		ArrayList<RentDetVO> rentDetVOList = modifyDao.selectRentDet(con, rentSeq);
		//ATTACHMENT 테이블
		ArrayList<AttachmentVO> attachmentVOList = modifyDao.selectAttachment(con, rentSeq);
/*		//RENT_IMG 테이블
		ArrayList<RentImgVO> rentImgVOList = modifyDao.selectRentImg(con, rentSeq);*/
		//DET_FAC 테이블
		ArrayList<DetFacVO> detFacVOList = modifyDao.selectDetFac(con, rentSeq);
		//RENT_DET_FAC 테이블
		ArrayList<DetFacAndRentDetFacVO>  rentDetFacVOList = modifyDao.selectRentDetFacList(con, rentSeq);
		//RENT_CLOSE 테이블
		ArrayList<RentCloseVO> rentCloseVOList = modifyDao.selectRentCloseList(con, rentSeq);

		System.out.println("rentCloseVOList:::::::::::::::::" + rentCloseVOList);

		// 리스트 추가
		rentBasicInfoMap.put("rentBasicVO", rentBasicVO);
		rentBasicInfoMap.put("facInfoVOList", facInfoVOList);
		rentBasicInfoMap.put("cautionsVOList", cautionsVOList);
		rentBasicInfoMap.put("rentDetVOList", rentDetVOList);
		rentBasicInfoMap.put("attachmentVOList", attachmentVOList);
/*		rentBasicInfoMap.put("rentImgVOList", rentImgVOList);*/
		rentBasicInfoMap.put("detFacVOList", detFacVOList);
		rentBasicInfoMap.put("rentDetFacVOList", rentDetFacVOList);
		rentBasicInfoMap.put("rentCloseVOList", rentCloseVOList);


		for(AttachmentVO attachmentVO : attachmentVOList) {
			//System.out.println(attachmentVO);
		}

		return rentBasicInfoMap;
	}

	/**
	 * 세부시설 가져오기
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<DetFacVO> getDetFac(int rentSeq) {
		Connection con = getConnection();

		ModifyDao modifyDao = new ModifyDao();

		ArrayList<DetFacVO> detFacVOList = modifyDao.selectDetFac(con, rentSeq);

		return detFacVOList;
	}

	/**
	 * 환불유형 가져오기
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<RefundTypeVO> getRefundType(int rentSeq) {
		Connection con = getConnection();

		ModifyDao modifyDao = new ModifyDao();

		ArrayList<RefundTypeVO> refundTypeVOList = modifyDao.selectRefunctTypeAll(con);

		close(con);

		return refundTypeVOList;
	}



}
