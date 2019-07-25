package com.kh.hp.account.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.hp.account.model.vo.ReviewVO;

public class ReviewDao {
	private Properties prop = new Properties();

	public int insertBoard(Connection con, ReviewVO rv) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("reivewInsert");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rv.getReviewContent());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return 0;
	}

}
