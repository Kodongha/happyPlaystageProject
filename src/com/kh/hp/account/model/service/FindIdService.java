package com.kh.hp.account.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.hp.account.model.dao.FindIdDao;
import com.kh.hp.account.model.vo.UserVO;

public class FindIdService {


	public UserVO findId(String userName, String userPhone) {
		Connection con = getConnection();

		UserVO uv = new FindIdDao().FindId(con, userName, userPhone);


		close(con);

		return uv;
	}
}
