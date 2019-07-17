package com.kh.hp.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;



import com.kh.hp.admin.model.dao.UserDao;
import com.kh.hp.admin.model.vo.User;

import static com.kh.hp.common.JDBCTemplate.*;

public class UserService {

	public ArrayList<User> selectAll() {
		Connection con = getConnection();
	
		ArrayList<User> list = new UserDao().selectAll(con);
		
		close(con);
		
		
		
		
		
		return list;
	}

}
