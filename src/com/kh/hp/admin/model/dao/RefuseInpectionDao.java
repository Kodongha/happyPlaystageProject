package com.kh.hp.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class RefuseInpectionDao {
	
	
	private Properties prop = new Properties();

	public RefuseInpectionDao() {
		String fileName =
				UpdateOneUserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	// insp_log 거절  insert
	public int RefuseInpection(Connection con, int rentSeq) {

		System.out.println("대관등록검수 거절 디에이오로 왔나요?");

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("RefuseInpection");

		try {
			pstmt = con.prepareStatement(query);
			
			
			pstmt.setInt(1, rentSeq);
			pstmt.setString(2, "거절");

			result = pstmt.executeUpdate();



		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	//rent_basic update  -> 거절을 했으나 검수는 했으므로 검수유무는 y가 되야함
	public int RefuseInpection1(Connection con, int rentSeq) {
		System.out.println("거절이고 F?");
		PreparedStatement pstmt = null;
		int result2 = 0;

		String query = prop.getProperty("RefuseInpection1");
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, rentSeq);


			result2 = pstmt.executeUpdate();



		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result2;
	}
}