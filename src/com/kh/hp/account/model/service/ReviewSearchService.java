package com.kh.hp.account.model.service;
import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.account.model.dao.ReviewSearchDao;
import com.kh.hp.account.model.vo.ReviewSearchVO;
import com.kh.hp.serviceCenter.model.vo.Notice;
public class ReviewSearchService {



	public ReviewSearchVO selectList(int num) {
		Connection con = getConnection();

		ReviewSearchVO rs = new ReviewSearchDao().selectList(con, num);

		close(con);

		return rs;
	}
}


