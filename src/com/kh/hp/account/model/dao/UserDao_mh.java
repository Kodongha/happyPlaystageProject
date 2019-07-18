package com.kh.hp.account.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.hp.account.model.vo.UserVO;
import static com.kh.hp.common.JDBCTemplate.*;

public class UserDao_mh {
	private Properties prop = new Properties();

	public UserDao_mh() {
		String fileName = UserDao_mh.class.getResource("/sql/account/account-query.properties").getPath();

		System.out.println(fileName);

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int updateUser(Connection con, UserVO uv) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("upDateUser");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, uv.getUserNm());
			pstmt.setString(2, uv.getUserNick());
			pstmt.setString(3, uv.getUserPhone());
			pstmt.setString(4, uv.getUserEmail());
			pstmt.setString(5, uv.getUserPwd());

			System.out.println(uv.getUserNm());
			System.out.println(uv.getUserEmail());
			System.out.println(uv.getUserPwd());

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
