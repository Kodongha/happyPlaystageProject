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
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;

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
	
	/*public ArrayList<AhnUsingInfoVO> searchCheck(Connection con, int usingInfo) {
		ArrayList<AhnUsingInfoVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("searchCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, usingInfo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			if(rset.next()) {
				AhnUsingInfoVO u = new AhnUsingInfoVO();
				
				u.setPropSeq(rset.getInt("PROP_SEQ"));
				u.setRentSeq(rset.getInt("RENT_SEQ"));
				u.setUserSeq(rset.getInt("USER_SEQ"));
				u.setPropNm(rset.getString("PROP_NM"));
				u.setPropPhone(rset.getString("PROP_PHONE"));
				u.setPropEmail(rset.getString("PROP_EMAIL"));
				u.setPropReqContent(rset.getString("PROP_REQ_CONTENT"));
				u.setPropDt(rset.getDate("PROP_DT"));
				u.setPropStatus(rset.getString("PROP_STATUS"));
				u.setUseStartDt(rset.getDate("USE_START_DT"));
				u.setUseEndDt(rset.getDate("USE_END_DT"));
				u.setUseStartTm(rset.getInt("USE_START_TM"));
				u.setUseEndTm(rset.getInt("USE_END_TM"));
				u.setPayAmount(rset.getInt("PAY_AMOUNT"));
				
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}*/
	
	
	
	public AhnUsingInfoVO searchCheck(Connection con, int usingInfo) {
		AhnUsingInfoVO responseUserVO = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("searchCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, usingInfo);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				
				responseUserVO = new AhnUsingInfoVO();
				
				responseUserVO.setPropSeq(rset.getInt("PROP_SEQ"));
				responseUserVO.setRentSeq(rset.getInt("RENT_SEQ"));
				responseUserVO.setUserSeq(rset.getInt("USER_SEQ"));
				responseUserVO.setPropNm(rset.getString("PROP_NM"));
				responseUserVO.setPropPhone(rset.getString("PROP_PHONE"));
				responseUserVO.setPropEmail(rset.getString("PROP_EMAIL"));
				responseUserVO.setPropReqContent(rset.getString("PROP_REQ_CONTENT"));
				responseUserVO.setPropDt(rset.getDate("PROP_DT"));
				responseUserVO.setPropStatus(rset.getString("PROP_STATUS"));
				responseUserVO.setUseStartDt(rset.getDate("USE_START_DT"));
				responseUserVO.setUseEndDt(rset.getDate("USE_END_DT"));
				responseUserVO.setUseStartTm(rset.getInt("USE_START_TM"));
				responseUserVO.setUseEndTm(rset.getInt("USE_END_TM"));
				responseUserVO.setPayAmount(rset.getInt("PAY_AMOUNT"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return responseUserVO;
	}
	
	
	
	
	/*public AhnUsingInfoVO searchCheck(Connection con, AhnUsingInfoVO reqAhnUsingInfoVO) {
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("searchCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqAhnUsingInfoVO.getPropNm());
			
			rset = pstmt.executeQuery();
			
			int rentSeq;
			String propNm;
			String propEmail;
			String useStartDt;
			
			if(rset.next()) {
				propNm = rset.getString("PROP_NM");
				propEmail = rset.getString("PROP_EMAIL");
				useStartDt = rset.getString("USE_START_DT");
			}
			
			if(reqAhnUsingInfoVO.getPropNm().equals(propNm) && reqAhnUsingInfoVO.getPropEmail().equals(propEmail)
						&& reqAhnUsingInfoVO.getPropNm().equals(useStartDt)) {
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	

}
