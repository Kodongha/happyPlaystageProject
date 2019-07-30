package com.kh.hp.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.kh.hp.admin.model.vo.UpdateUserVO;

import static com.kh.hp.common.JDBCTemplate.*;

public class UpdateOneUserDao {
	private Properties prop = new Properties();

	public UpdateOneUserDao() {
		String fileName =
				UpdateOneUserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//회원정보 수정용 메소드
	public int updateOneUser(Connection con, UpdateUserVO updateUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateOneUser");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,updateUser.getUserEmail());
			pstmt.setString(2, updateUser.getUserNm());
			pstmt.setString(3, updateUser.getUserNick());
			pstmt.setString(4, updateUser.getUserPhone());
			pstmt.setInt(5, updateUser.getUserGradeCd());
			if(updateUser.getSnsCd() == 0) {
				pstmt.setString(6, null);
			} else {
				pstmt.setInt(6, updateUser.getSnsCd());
			}

			pstmt.setInt(7, updateUser.getUserSeq());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}


		return result;
	}

}
















