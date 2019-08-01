package com.kh.hp.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.admin.model.vo.EnrollHistoryVO;
import com.kh.hp.admin.model.vo.UseHistoryVO;

public class EnrollHistoryDao {

	private Properties prop = new Properties(); 

	public EnrollHistoryDao() {

		String fileName = UserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}



	}

	//페이징처리후 회원관리상세내역 - 등록내역조회
	public ArrayList<EnrollHistoryVO> EnrollHistoryVOList(Connection con, int userSeq, int currentPage1, int limit1) {

		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<EnrollHistoryVO> enrollHistoryVOList = null;

		String query = prop.getProperty("enrollHistoryList");

		try {
			pstmt = con.prepareStatement(query);


			int startRow = (currentPage1 - 1) * limit1 + 1;
			int endRow = startRow + limit1 - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, userSeq);
		
			System.out.println(userSeq);
			rset = pstmt.executeQuery();
		
		
			
			enrollHistoryVOList = new ArrayList<EnrollHistoryVO>();
			
			
			
			while(rset.next()) {

				EnrollHistoryVO enrollHistoryVO = new EnrollHistoryVO();
			
				enrollHistoryVO.setUserSeq(rset.getInt("USER_SEQ"));
				enrollHistoryVO.setRentSeq(rset.getInt("RENT_SEQ"));
				enrollHistoryVO.setHallNm(rset.getString("HALL_NM"));
				enrollHistoryVO.setCompNm(rset.getString("COMP_NM"));
				enrollHistoryVO.setAddress(rset.getString("ADDRESS"));
				enrollHistoryVO.setRentEnrollDt(rset.getDate("RENT_ENROLL_DT"));
				enrollHistoryVO.setRentEnrollStatus(rset.getString("RENT_ENROLL_STATUS"));
				enrollHistoryVO.setUserNm(rset.getString("USER_NM"));
			
				
				enrollHistoryVOList.add(enrollHistoryVO);
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enrollHistoryVOList;
	}

}
