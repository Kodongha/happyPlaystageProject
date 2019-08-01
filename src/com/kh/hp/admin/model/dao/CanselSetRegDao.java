package com.kh.hp.admin.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CanselSetRegDao {

	private Properties prop = new Properties();

	public CanselSetRegDao() {
		String fileName =
				UpdateOneUserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//user_info grade_cd update cancel
	public int CanselSetReg(Connection con, int userSeq) {
		
		
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("CanselSetReg");
		try {
			pstmt = con.prepareStatement(query);
			
			
			pstmt.setInt(1,userSeq);
		
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}


		return result;
	}

	////user_gradeup 의 grade_status, grade_up_dt update cancel
	public int CanselSetReg1(Connection con, int userSeq) {
		
		PreparedStatement pstmt = null;
		int result2 = 0;
		String query = prop.getProperty("CanselSetReg1");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,userSeq);
			result2 = pstmt.executeUpdate();
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result2;
	}
}

















