package com.kh.hp.account.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

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
import com.kh.hp.account.model.vo.ReviewVO;

public class ReviewDao {
	private Properties prop = new Properties();

	public ReviewDao() {
		String fileName = ReviewDao.class.getResource("/sql/account/account-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public int insertBoard(Connection con, ReviewVO rv) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("reivewInsert");



		try {
			pstmt = con.prepareStatement(query);

			System.out.println("rv::"  + rv);


			pstmt.setString(1, rv.getReviewContent());
			pstmt.setInt(2, rv.getRan());
			pstmt.setInt(3, rv.getpropSeq());
			pstmt.setInt(4, rv.getUserSeq());
			pstmt.setInt(5, rv.getRentSeq());


			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return result;
	}


	public ArrayList<ReviewMainVO> ReviewList(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReviewMainVO> reviewMainVOList = null;

		String query = prop.getProperty("selectReviewMap");

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


	public ArrayList<ReviewVO> selectReviewList(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<ReviewVO> reviewVOList = null;

		String query = prop.getProperty("selectReviewList");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			while(rset.next()) {
				ReviewVO reviewVO = new ReviewVO();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
