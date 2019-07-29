package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.admin.model.dao.DetailInspectionDao;
import com.kh.hp.admin.model.dao.InspectionListVOListDao;
import com.kh.hp.admin.model.dao.UserDao;
import com.kh.hp.admin.model.vo.DetailInspectionVO;
import com.kh.hp.admin.model.vo.InspectionListVO;

public class DetailInspectionService {
	
	public int getListCount() {
		Connection con = getConnection();

	int listCount = new UserDao().getListCount(con);

	return listCount;

	}



	//대관등록검수리스트 상세
	public ArrayList<DetailInspectionVO> DetailInspection(int rentSeq ,int currentPage, int limit) {

		System.out.println("대관등록검수리스트상세 서비스까지 왔나요?");

		Connection con = getConnection();

		ArrayList<DetailInspectionVO> DetailInspectionVOList = new DetailInspectionDao().DetailInspection(con , rentSeq,currentPage, limit);

		close(con);

		return DetailInspectionVOList;




	}

}
