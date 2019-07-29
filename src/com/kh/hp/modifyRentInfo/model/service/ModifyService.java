package com.kh.hp.modifyRentInfo.model.service;

import static com.kh.hp.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kh.hp.modifyRentInfo.model.dao.ModifyDao;
import com.kh.hp.rent.model.vo.CautionsVO;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RentBasicVO;

public class ModifyService {

	/**
	 * 수정 데이터 값 가져오기
	 * @param rentSeq
	 * @return
	 */
	public Map<String, Object> getrentInfo(int rentSeq) {
		Connection con = getConnection();

		ModifyDao modifyDao = new ModifyDao();
		Map<String, Object> rentBasicInfoMap = new HashMap();

		// RENT_BAISC 테이블
		RentBasicVO rentBasicVO = modifyDao.selectRentBasic(con, rentSeq);
		System.out.println("!!!!!!!"+rentBasicVO);
		//FAC_INFO 테이블
		ArrayList<FacInfoVO> facInfoVOList = modifyDao.selectFacInfo(con, rentSeq);
		System.out.println("!!!!!!!"+facInfoVOList);
		//CAUTIONS 테이블
/*		ArrayList<CautionsVO> cautionsVOList = (ArrayList<CautionsVO>) rentInfos.get(1);*/

		// 리스트 추가
		rentBasicInfoMap.put("rentBasicVO", rentBasicVO);
		rentBasicInfoMap.put("facInfoVOList", facInfoVOList);



		return rentBasicInfoMap;
	}



}
