package com.kh.hp.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.admin.model.vo.User;

import static com.kh.hp.common.JDBCTemplate.*;

public class UserDao {

	Properties prop = new Properties();

	public UserDao() {

		String fileName = UserDao.class.getResource("/sql/account/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<User> selectAll(Connection con) {
		ArrayList<User> list = null;
		Statement stmt = null;
		ResultSet rset = null;


		String query = prop.getProperty("selectAll");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<User>();

			while(rset.next()) {
				User u = new User();

				u.setUserSeq(rset.getInt("USER_SEQ"));
				u.setUserEmail(rset.getString("USER_EMAIL"));
				u.setUserPwd(rset.getString("USER_PWD"));
				u.setUserNm(rset.getString("USER_NICK"));
				u.setUserNick(rset.getString("USER_NICK"));
				u.setUserPhone(rset.getString("USER_PHONE"));
				u.setUserGradeCd(rset.getInt("USER_GRADE_CO"));				
				u.setEnrollDt(rset.getDate("ENROLL_DT"));
				u.setSnsCd(rset.getInt("SNS_CD"));
				u.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				u.setLeaveDt(rset.getDate("LEAVE_DT"));
				
			
				list.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}


		return list;
	}


}
















