package com.kh.hp.account.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.hp.account.model.vo.UserVO;
import static com.kh.hp.common.JDBCTemplate.*;

public class FindIdDao {
	private Properties prop = new Properties();
	
	public FindIdDao() {
		String fileName = SignUpDao.class.getResource("/sql/account/account-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public UserVO FindId(Connection con, String userName, String userPhone) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserVO uv = null;

		String query = prop.getProperty("findId");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPhone);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				uv = new UserVO();

				uv.setUserEmail(rset.getString("USER_EMAIL"));
				uv.setUserNm(rset.getString("USER_NM"));
				uv.setUserPhone(rset.getString("USER_PHONE"));
			
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return uv;
	}

}
