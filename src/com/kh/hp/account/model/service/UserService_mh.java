package com.kh.hp.account.model.service;

import java.sql.Connection;

import com.kh.hp.account.model.dao.UserDao_mh;
import com.kh.hp.account.model.vo.UserVO;
import static com.kh.hp.common.JDBCTemplate.*;

public class UserService_mh {

	public int updateUser(UserVO uv) {
		Connection con = getConnection();

		int result = new UserDao_mh().updateUser(con, uv);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		return result;
	}

	/**
	 * 개인정보 수정 메소드
	 *
	 */

}
