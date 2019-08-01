package com.kh.hp.admin.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UpdateInpectionDao {

	private Properties prop = new Properties();

	public UpdateInpectionDao() {
		String fileName =
				UpdateOneUserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	// insp_log insert
	public int UpdateInpection(Connection con, int rentSeq) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("UpdateInpection");
		
		try {
			pstmt = con.prepareStatement(query);
		
			pstmt.setInt(1, rentSeq);
			pstmt.setString(2, "승인");
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}



	//rent_basic update 
 	public int UpdateInpection1(Connection con, int rentSeq) {
	
 		
 		PreparedStatement pstmt = null;
		int result2 = 0;
		String query = prop.getProperty("UpdateInpection1");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "등록완료");
			pstmt.setInt(2,rentSeq);
			result2 = pstmt.executeUpdate();
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result2;
	}
}










