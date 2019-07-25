package com.kh.hp.account.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.commit;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.hp.account.model.dao.ReviewDao;
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

}
