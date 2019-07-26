package com.kh.hp.admin.model.service;
import static com.kh.hp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.admin.model.dao.UseHistoryDao;
import com.kh.hp.admin.model.dao.UserDao;
import com.kh.hp.admin.model.vo.UseHistoryVO;
import com.kh.hp.admin.model.vo.User;
import com.kh.hp.myPage.model.dao.AhnMyPageDao;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;
public class UseHistoryService  {


	//대관사용내역 카운트
	public int getListCount() {
		Connection con = getConnection();

		int listCount = new UserDao().getListCount(con);


		return listCount;
	}

	
	//회원관리상세페이지 - 대관사용리스트조회
	public ArrayList<UseHistoryVO> UseHistoryVOlist(int userSeq, int currentPage, int limit) {
		
		System.out.println("사용내역조회서비스까지 왔나요 ");
		Connection con = getConnection();

		ArrayList<UseHistoryVO> UseHistoryVOlist = new UseHistoryDao().UseHistoryVOlist(con, userSeq, currentPage, limit);

		close(con);

		return UseHistoryVOlist;
		
		
		
		
	}


}


















