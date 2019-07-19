package com.kh.hp.account.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.hp.account.model.vo.UserVO;

import static com.kh.hp.common.JDBCTemplate.close;

public class SignUpDao {
	private Properties prop = new Properties();

	public SignUpDao() {
		
		String fileName = SignUpDao.class.getResource("/sql/account/account-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int insertUserInfo(Connection con, UserVO u) {
		System.out.println("in!!!");
		
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertUserVO");

		try {
			pstmt = con.prepareStatement(query);
			System.out.println(u.getUserEmail());
			pstmt.setString(1, u.getUserEmail());
			pstmt.setString(2, u.getUserPwd());
			pstmt.setString(3, u.getUserNm());
			pstmt.setString(4, u.getUserNick());
			pstmt.setString(5, u.getUserPhone());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	

	}

	
}
