package com.kh.hp.main.model.dao;

import static com.kh.hp.common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.account.model.vo.ReviewMainVO;
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
				mainRentVO.setSeq(rset.getInt("RANKING"));
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

	public ArrayList<ReviewMainVO> ReviewList(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReviewMainVO> reviewMainVOList = null;

		String query = prop.getProperty("ReviewList");

		try {
			pstmt = con.prepareStatement(query);



			rset = pstmt.executeQuery();

			reviewMainVOList = new ArrayList<ReviewMainVO>();
			while(rset.next()) {
				ReviewMainVO reviewMainVO = new ReviewMainVO();

				reviewMainVO.setAddress(rset.getString("ADDRESS"));
				reviewMainVO.setChangeNm(rset.getString("CHANGE_NM"));
				reviewMainVO.setHallNm(rset.getString("HALL_NM"));
				reviewMainVO.setRating(rset.getInt("RATING"));
				reviewMainVO.setReviewContent(rset.getString("REVIEW_CONTENT"));

				reviewMainVOList.add(reviewMainVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}



		return reviewMainVOList;
	}

}
