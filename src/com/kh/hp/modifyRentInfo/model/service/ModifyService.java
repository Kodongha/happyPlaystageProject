package com.kh.hp.modifyRentInfo.model.service;

import static com.kh.hp.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.modifyRentInfo.model.dao.ModifyDao;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RentBasicVO;

public class ModifyService {

	/**
	 * 수정 데이터 값 가져오기
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<Object> getrentInfo(int rentSeq) {
		Connection con = getConnection();

		ModifyDao modifyDao = new ModifyDao();
		ArrayList<Object> rentBasicInfoList = new ArrayList<Object>();

		// RENT_BAISC 테이블
		RentBasicVO rentBasicVO = modifyDao.selectRentBasic(con, rentSeq);
		System.out.println(rentBasicVO);
		FacInfoVO facInfoVO = modifyDao.selectFaInfo(con, rentSeq);
		System.out.println(facInfoVO);

		// 리스트 추가
		rentBasicInfoList.add(rentBasicVO);
		rentBasicInfoList.add(facInfoVO);



		return rentBasicInfoList;
	}



}
