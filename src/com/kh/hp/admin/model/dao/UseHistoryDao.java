package com.kh.hp.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.admin.model.vo.UseHistoryVO;
import com.kh.hp.admin.model.vo.User;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;
import static com.kh.hp.common.JDBCTemplate.*;

public class UseHistoryDao {
	private Properties prop = new Properties(); 
	
	public UseHistoryDao() {
		
		String fileName = UserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}



	//페이징처리후 회원관리상세내역 - 사용내역 조회 
	public ArrayList<UseHistoryVO> UseHistoryVOlist(Connection con, int userSeq, int currentPage, int limit) {
		System.out.println("사용내역 DAO까지 왔나요 ?");

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UseHistoryVO> UseHistoryVOlist = null;

		String query = prop.getProperty("useHistoryList");

		try {
			pstmt = con.prepareStatement(query);
			

		
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, userSeq);

			
			rset = pstmt.executeQuery();
			
			
			UseHistoryVOlist = new ArrayList<UseHistoryVO>();

			while(rset.next()) {

				UseHistoryVO  useHistoryVO = new  UseHistoryVO();

				useHistoryVO.setRentSeq(rset.getInt("RENT_SEQ"));
				useHistoryVO.setUserSeq(rset.getInt("USER_SEQ"));
				useHistoryVO.setHallNm(rset.getString("HALL_NM"));
				useHistoryVO.setGetpropStatus(rset.getString("PROP_STATUS"));
				useHistoryVO.setCompNm(rset.getString("COMP_NM"));
				useHistoryVO.setUseStartDt(rset.getDate("USE_START_DT"));
				useHistoryVO.setUseEndDt(rset.getDate("USE_END_DT"));




				UseHistoryVOlist.add(useHistoryVO);
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return UseHistoryVOlist;
	}

}





