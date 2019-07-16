package com.kh.hp.account.model.service;

import static com.kh.hp.common.JDBCTemplate.*;
import java.sql.Connection;

import com.kh.hp.account.model.dao.AccountDao;
import com.kh.hp.account.model.vo.UserVO;

public class AccountService {

	public static UserVO CheckLogin(UserVO requestUserVO) {
		// TODO Auto-generated method stub

		Connection con = getConnection();

		UserVO responseUserVO = new AccountDao().selectLoginUser(con, requestUserVO);

		close(con);

		return responseUserVO;
	}

}
