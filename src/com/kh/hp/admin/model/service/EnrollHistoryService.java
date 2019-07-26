package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.admin.model.dao.EnrollHistoryDao;
import com.kh.hp.admin.model.dao.UserDao;
import com.kh.hp.admin.model.vo.EnrollHistoryVO;

public class EnrollHistoryService {

	//대관등록내역 카운트
	public int getListCount() {
		Connection con = getConnection();

		int listCount = new UserDao().getListCount(con);


		return listCount;
	}
	
	//회원관리상세페이지 - 대관등록리스트조회
	public ArrayList<EnrollHistoryVO> EnrollHistoryVOlist(int userSeq,int currentPage1, int limit1) {
	
		System.out.println("등록내역리스트조회서비스까지 왔니??");
		
		Connection con = getConnection();
		
		ArrayList<EnrollHistoryVO> EnrollHistoryVOList = new EnrollHistoryDao().EnrollHistoryVOList(con,userSeq,currentPage1, limit1);
		
		close(con);
		
		return EnrollHistoryVOList;
	}


}
