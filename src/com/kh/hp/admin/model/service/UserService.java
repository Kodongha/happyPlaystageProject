package com.kh.hp.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;



import com.kh.hp.admin.model.dao.UserDao;
import com.kh.hp.admin.model.vo.User;

import static com.kh.hp.common.JDBCTemplate.*;

public class UserService {

/*	public ArrayList<User> selectAll() {
		Connection con = getConnection();
	
		ArrayList<User> list = new UserDao().selectAll(con);
		
		close(con);
		
		
		
		
		
		return list;
	}
 */
	
	
	//전체 회원수 조회용 메소드
	public int getListCount() {
		Connection con = getConnection();
		
	int listCount = new UserDao().getListCount(con);

	return listCount;

	}

	//페이징 처리후 전체회원수 조회용 메소드
	public ArrayList<User> selectList(int currentPage, int limit) {
		Connection con = getConnection();
	
		ArrayList<User> list = new UserDao().selectList(con, currentPage, limit);
		
		close(con);
		
		return list;
	}

	//회원조회용 메소드
	public User selectOne(int userSeq) {
		
		System.out.println("selectone 서비스까지는 들어왔나요/");
		Connection con = getConnection();
		User oneUser = null;
		
		oneUser = new UserDao().selectOne(con, userSeq);
		
		
		
		return oneUser;
	}



	
}

























