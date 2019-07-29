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

	public ArrayList<DetailInspectionVO> DetailInspection(Connection con, int currentPage, int limit,int rentSeq) {
		System.out.println("대관등록검수 DAO까지 왔나요?");


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DetailInspectionVO> DetailInspectionVOList = null;
	

		String query = prop.getProperty("DetailInspection");

		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			pstmt.setInt(3, rentSeq);
			
			System.out.println(rentSeq);

			rset = pstmt.executeQuery();

			DetailInspectionVOList = new ArrayList<DetailInspectionVO> ();

		

			while(rset.next()) {
				

				System.out.println(rentSeq);
				DetailInspectionVO detailInspectionVO  = new DetailInspectionVO();

				detailInspectionVO.setRentSeq(rset.getInt("RENT_SEQ"));
				detailInspectionVO.setRentNm(rset.getString("HALL_NM"));
				detailInspectionVO.setAddress(rset.getString("ADDRESS"));
				detailInspectionVO.setHallDetIntro(rset.getString("HALL_DET_INTRO"));
				detailInspectionVO.setCautionContent(rset.getString("CAUTION_CONTENT"));
				detailInspectionVO.setWebsite(rset.getString("WEBSITE"));	
				detailInspectionVO.setInspTf(rset.getString("INSP_TF").charAt(0));
	
				
				DetailInspectionVOList.add(detailInspectionVO);

				System.out.println("대관등록검수상세:::::" + detailInspectionVO);

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
