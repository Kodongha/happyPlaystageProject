package com.kh.hp.admin.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.admin.model.vo.DetailInspectionVO;
import com.kh.hp.admin.model.vo.InspectionListVO;

public class DetailInspectionDao {

	private Properties prop = new Properties(); 

	public DetailInspectionDao() {

		String fileName = UserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<DetailInspectionVO> DetailInspection(Connection con,int rentSeq) {
	

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DetailInspectionVO> DetailInspectionVOList = null;
	

		String query = prop.getProperty("DetailInspection");

		try {
			pstmt = con.prepareStatement(query);
			
			
			pstmt.setInt(1, rentSeq);
			
			

			rset = pstmt.executeQuery();

			DetailInspectionVOList = new ArrayList<DetailInspectionVO> ();

		

			while(rset.next()) {
				

				
				DetailInspectionVO detailInspectionVO  = new DetailInspectionVO();
				
				detailInspectionVO.setRentSeq(rset.getInt("RENT_SEQ"));
				detailInspectionVO.setHallNm(rset.getString("HALL_NM"));
				detailInspectionVO.setAddress(rset.getString("ADDRESS"));
				detailInspectionVO.setHallDetIntro(rset.getString("HALL_DET_INTRO"));
				detailInspectionVO.setCautionContent(rset.getString("CAUTION_CONTENT"));
				detailInspectionVO.setWebsite(rset.getString("WEBSITE"));
				detailInspectionVO.setInspTf(rset.getString("INSP_TF"));
				
	
				
				DetailInspectionVOList.add(detailInspectionVO);

			

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


		return DetailInspectionVOList;
	}
}
