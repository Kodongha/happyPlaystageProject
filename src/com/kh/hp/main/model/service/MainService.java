package com.kh.hp.main.model.service;

import static com.kh.hp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.account.model.dao.ReviewDao;
import com.kh.hp.account.model.vo.ReviewMainVO;
import com.kh.hp.main.model.dao.MainDao;
import com.kh.hp.main.model.vo.MainRentVO;

public class MainService {

	/**
	 * 메인 - 대관 정보 가져오기
	 * @return
	 */
	public ArrayList<MainRentVO> selectMainData() {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		ArrayList<MainRentVO> responseMainRentVOList = new MainDao().selectMainData(con);

		close(con);

		return responseMainRentVOList;
	}

	public ArrayList<ReviewMainVO> ReviewList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		ArrayList<ReviewMainVO> reviewMainVOList = new MainDao().ReviewList(con);

		close(con);

		return reviewMainVOList;
	}

}
