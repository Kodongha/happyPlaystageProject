package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.admin.model.dao.UserDao;
import com.kh.hp.admin.model.vo.User;
import com.kh.hp.myPage.model.dao.AhnMyPageDao;
import com.kh.hp.myPage.model.vo.AhnApplyInfoVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;

public class SearchUserService {

	
	public int getListCount() {
		Connection con = getConnection();

		int listCount = new UserDao().getListCount(con);

		return listCount;

	}

	
	//회원검색용 메소드
	public ArrayList<User> searchUserList(int userSeq, String userNm, String serGradeCd, String leaveTf,
			int currentPage, int limit) {
		Connection con = getConnection();
		System.out.println(" 회원검색용 서비스로 들어왔나요?");
		
		ArrayList<User> searchUserList = null;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}

	
}
