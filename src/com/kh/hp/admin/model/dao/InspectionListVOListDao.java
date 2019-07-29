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

import com.kh.hp.admin.model.vo.InspectionListVO;
import com.kh.hp.admin.model.vo.SetRegPermissionsVO;

public class InspectionListVOListDao {

	private Properties prop = new Properties(); 

	public InspectionListVOListDao() {

		String fileName = UserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}



	}


	//대관등록검수
	public ArrayList<InspectionListVO> InspectionList(Connection con, int currentPage, int limit) {

		System.out.println("대관등록검수 DAO까지 왔나요???");

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<InspectionListVO> InspectionListVOList = null;

		String query = prop.getProperty("InspectionList");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;


			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			InspectionListVOList = new ArrayList<InspectionListVO> ();


			while(rset.next()) {

				InspectionListVO inspectionListVO  = new InspectionListVO();

				inspectionListVO.setRentSeq(rset.getInt("RENT_SEQ"));
				inspectionListVO.setUserEmail(rset.getString("USER_EMAIL"));
				inspectionListVO.setUserPhone(rset.getString("USER_PHONE"));
				inspectionListVO.setOriginNm(rset.getString("ORIGIN_NM"));
				inspectionListVO.setInspTf(rset.getString("INSP_TF").charAt(0));
				inspectionListVO.setRentEnrollStatus(rset.getString("RENT_ENROLL_STATUS"));
		

				InspectionListVOList.add(inspectionListVO);

				System.out.println("대관등록검수:::::" + inspectionListVO);


			}

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


		return InspectionListVOList;
	}
}
