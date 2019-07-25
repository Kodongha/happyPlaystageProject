package com.kh.hp.account.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.account.model.dao.ReviewSearchDao;
import com.kh.hp.serviceCenter.model.vo.Notice;

public class ReviewSearchService {

	public ArrayList<Notice> selectList() {

		Connection con = getConnection();

		ArrayList<Notice> list = new ReviewSearchDao().selectList(con);

		close(con);

		return list;
	}
}


