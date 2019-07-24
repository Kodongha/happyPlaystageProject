package com.kh.hp.main.model.dao;

import static com.kh.hp.common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.main.model.vo.MainRentVO;
import com.kh.hp.myPage.model.dao.MyPageDao_mh;

public class MainDao {

	private Properties prop = new Properties();

	public MainDao() {
		String fileName = MyPageDao_mh.class.getResource("/sql/main/main-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 메인 - 대관 정보 가져오기
	 * @param con
	 * @return
	 */
	public ArrayList<MainRentVO> selectMainData(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<MainRentVO> responseMainRentVOList = null;

		String query = prop.getProperty("selectMainData");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			responseMainRentVOList = new ArrayList<MainRentVO>();

			while(rset.next()) {
				MainRentVO mainRentVO = new MainRentVO();
				mainRentVO.setSeq(rset.getInt("SEQ"));
				mainRentVO.setRentSeq(rset.getInt("RENT_SEQ"));
				mainRentVO.setHallNm(rset.getString("HALL_NM"));
				mainRentVO.setAddress(rset.getString("ADDRESS"));
				mainRentVO.setRentEnrollDt(rset.getDate("RENT_ENROLL_DT"));
				mainRentVO.setRentPrice(rset.getInt("RENT_PRICE"));
				mainRentVO.setOriginNm(rset.getString("ORIGIN_NM"));
				mainRentVO.setChangeNm(rset.getString("CHANGE_NM"));
				mainRentVO.setFilePath(rset.getString("FILE_PATH"));

				responseMainRentVOList.add(mainRentVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return responseMainRentVOList;
	}

}
