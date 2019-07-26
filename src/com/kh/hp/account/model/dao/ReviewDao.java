package com.kh.hp.account.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.hp.account.model.vo.ReviewVO;
import com.sun.crypto.provider.RSACipher;

public class ReviewDao {
	private Properties prop = new Properties();
	
	public ReviewDao() {
		String fileName = ReviewDao.class.getResource("/sql/account/account-query.properties").getPath();
	
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int insertBoard(Connection con, ReviewVO rv) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("reivewInsert");

		
		
		try {
			pstmt = con.prepareStatement(query);
	
			System.out.println("rv::"  + rv);
			
			
			pstmt.setString(1, rv.getReviewContent());
			pstmt.setInt(2, rv.getRan());
			pstmt.setInt(3, 1);
			pstmt.setInt(4, rv.getUserSeq());
			pstmt.setInt(5, 1);
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}

}
