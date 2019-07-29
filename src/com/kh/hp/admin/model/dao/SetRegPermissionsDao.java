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

import com.kh.hp.admin.model.vo.SetRegPermissionsVO;
import com.kh.hp.admin.model.vo.UseHistoryVO;

public class SetRegPermissionsDao {

	private Properties prop = new Properties(); 

	public SetRegPermissionsDao() {

		String fileName = UserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}



	}

	//대관등록권한설정
	public ArrayList<SetRegPermissionsVO> SetRegPermissionsList(Connection con, int currentPage, int limit) {
		System.out.println("대관등록권한설정 DAO까지 왔나요???");

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SetRegPermissionsVO> SetRegPermissionsVOList = null;

		String query = prop.getProperty("SetRegPermissionsList");

		try {

			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;


			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			SetRegPermissionsVOList = new ArrayList<SetRegPermissionsVO> ();


			while(rset.next()) {
				
				SetRegPermissionsVO setRegPermissionsVO  = new SetRegPermissionsVO();
				
				setRegPermissionsVO.setUserSeq(rset.getInt("USER_SEQ"));
				setRegPermissionsVO.setUserNm(rset.getString("USER_NM"));
				setRegPermissionsVO.setUserPhone(rset.getString("USER_PHONE"));
				setRegPermissionsVO.setOriginNm(rset.getString("ORIGIN_NM"));
				setRegPermissionsVO.setUserGradeStatus(rset.getInt("USER_GRADE_STATUS"));
				
				SetRegPermissionsVOList.add(setRegPermissionsVO);
				
				System.out.println("등록권한설정리스트:::::" + setRegPermissionsVO);
				
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return SetRegPermissionsVOList;
	}

}










