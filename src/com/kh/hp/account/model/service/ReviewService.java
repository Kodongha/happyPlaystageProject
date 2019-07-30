package com.kh.hp.account.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.commit;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.account.model.dao.ReviewDao;
import com.kh.hp.account.model.vo.ReviewMainVO;
import com.kh.hp.account.model.vo.ReviewVO;
public class ReviewService {

	public int insertReview(ReviewVO rv) {
		Connection con = getConnection();

		int result = new ReviewDao().insertBoard(con, rv);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		close(con);

		return result;
	}

	public ArrayList<ReviewMainVO> ReviewList() {
		Connection con = getConnection();

		ArrayList<ReviewMainVO> reviewMainVOList = new ReviewDao().ReviewList(con);

		close(con);

		return reviewMainVOList;
	}

	public ArrayList<ReviewVO> selectReviewList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		ArrayList<ReviewVO> reviewVOList = new ReviewDao().selectReviewList(con);

		return null;
	}

}
