package com.kh.hp.myPage.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.myPage.model.vo.AhnLevelupVO;
import com.kh.hp.myPage.model.vo.AhnMyPageVO;

import static com.kh.hp.common.JDBCTemplate.*;

public class AhnMyPageDao {
	private Properties prop = new Properties();
	
	public AhnMyPageDao() {
		String fileName = AhnMyPageDao.class.getResource("/sql/myPage/myPage-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public AhnMyPageVO selectOne(Connection con, int userSeq) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AhnMyPageVO responseUserVO = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				responseUserVO = new AhnMyPageVO();
				
				responseUserVO.setUserEmail(rset.getString("USER_SEQ"));
				responseUserVO.setUserEmail(rset.getString("USER_EMAIL"));
				responseUserVO.setUserNm(rset.getString("USER_NM"));
				responseUserVO.setUserNick(rset.getString("USER_NICK"));
				responseUserVO.setUserPhone(rset.getString("USER_PHONE"));
				responseUserVO.setEnrollDt(rset.getDate("ENROLL_DT"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return responseUserVO;
	}
	public AhnLevelupVO updateLevelOne(Connection con, int levelUpInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AhnLevelupVO responseUserVO = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, levelUpInfo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				responseUserVO = new AhnLevelupVO();
				
				responseUserVO.setUserEmail(rset.getString("USER_EMAIL"));
				responseUserVO.setUserPwd(rset.getString("USER_PWD"));
				responseUserVO.setUserNm(rset.getString("USER_NM"));
				responseUserVO.setUserNick(rset.getString("USER_NICK"));
				responseUserVO.setUserPhone(rset.getString("USER_PHONE"));
				responseUserVO.setEnrollDt(rset.getDate("ENROLL_DT"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("responseUserVO : " + responseUserVO);
		
		return responseUserVO;
	}
	

}
