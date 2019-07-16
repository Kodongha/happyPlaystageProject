 package com.kh.hp.account.model.dao;

import static com.kh.hp.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.hp.account.model.vo.UserVO;

public class AccountDao {

	Properties prop = new Properties();

	public AccountDao() {
		// TODO Auto-generated constructor stub
		String fileName = AccountDao.class.getResource("/sql/account/account-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 로그인 요청에 대한 User 유무 확인
	 * @param con
	 * @param requestUserVO
	 * @return
	 */
	public UserVO selectLoginUser(Connection con, UserVO requestUserVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserVO responseUserVO = null;

		String query = prop.getProperty("selectLoginUser");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestUserVO.getUserEmail());
			pstmt.setString(2, requestUserVO.getUserPwd());

			rset = pstmt.executeQuery();

			if(rset.next()) {
				responseUserVO = new UserVO();
				responseUserVO.setUserSeq(rset.getInt("USER_SEQ"));
				responseUserVO.setUserEmail(rset.getString("USER_EMAIL"));
				responseUserVO.setUserNm(rset.getString("USER_NM"));
				responseUserVO.setUserNick(rset.getString("USER_NICK"));
				responseUserVO.setEnrollDt(rset.getDate("ENROLL_DT"));
				responseUserVO.setSnsCd(rset.getInt("SNS_CD"));
				responseUserVO.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				responseUserVO.setLeaveDt(rset.getDate("LEAVE_DT"));
				responseUserVO.setUserGradeCd(rset.getInt("USER_GRADE_CD"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return responseUserVO;
	}

}
