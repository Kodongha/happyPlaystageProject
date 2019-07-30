package com.kh.hp.modifyRentInfo.model.service;

import static com.kh.hp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kh.hp.modifyRentInfo.model.dao.ModifyDao;
import com.kh.hp.rent.model.vo.AttachmentVO;
import com.kh.hp.rent.model.vo.CautionsVO;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RentBasicVO;
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
		//FAC_INFO 테이블
		ArrayList<FacInfoVO> facInfoVOList = modifyDao.selectFacInfo(con, rentSeq);
		//CAUTIONS 테이블
		ArrayList<CautionsVO> cautionsVOList = modifyDao.selectCaution(con, rentSeq);
		//RENT_DET 테이블
		ArrayList<RentDetVO> rentDetVOList = modifyDao.selectRentDet(con, rentSeq);
		//ATTACHMENT 테이블
		ArrayList<AttachmentVO> attachmentVOList = modifyDao.selectAttachment(con, rentSeq);
		//RENT_IMG 테이블
		ArrayList<RentImgVO> rentImgVOList = modifyDao.selectRentImg(con, rentSeq);


		// 리스트 추가
		rentBasicInfoMap.put("rentBasicVO", rentBasicVO);
		rentBasicInfoMap.put("facInfoVOList", facInfoVOList);
		rentBasicInfoMap.put("cautionsVOList", cautionsVOList);
		rentBasicInfoMap.put("rentDetVOList", rentDetVOList);
		rentBasicInfoMap.put("attachmentVOList", attachmentVOList);
		rentBasicInfoMap.put("rentImgVOList", rentImgVOList);

		for(AttachmentVO attachmentVO : attachmentVOList) {
			System.out.println(attachmentVO);
		}

		return rentBasicInfoMap;
	}



}
