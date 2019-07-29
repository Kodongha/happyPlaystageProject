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

	/**
	 * 이메일 인증
	 * @param con
	 * @param sessionId
	 * @param authNumber
	 * @return
	 */
	public int selectAuth(Connection con, String sessionId, String authNumber) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("selectAuth");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sessionId);
			pstmt.setString(2, authNumber);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 아이디 확인
	 * @param con
	 * @param receiver
	 * @return
	 */
	public int checkId(Connection con, String receiver) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("checkId");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, receiver);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 패스워드 업데이트
	 * @param con
	 * @param email
	 * @param newPwd
	 * @return
	 */
	public int updateUserPwd(Connection con, int userSeq, String newPwd) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateUserPwd");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setInt(2, userSeq);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertLog(Connection con, int userSeq, String newPwd) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertLog");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);
			pstmt.setString(2, newPwd);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}


		return result;
	}

}
