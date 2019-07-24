package com.kh.hp.account.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.commit;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.hp.account.model.dao.SignUpDao;
import com.kh.hp.account.model.vo.UserVO;


public class SignUpService {

	public int joinMember(UserVO u) {
		Connection con = getConnection();
		int result = 0;

		System.out.println(con);

		SignUpDao sd = new SignUpDao();
		result = sd.insertUserInfo(con, u);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		close(con);

		return result;
	}

	public int idCheck(String userEmail) {
		Connection con = getConnection();
		
		int result = new SignUpDao().idCheck(con,userEmail);
		
		close(con);
		
		return result;
	}

	
	
	
}
