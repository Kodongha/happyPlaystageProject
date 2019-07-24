package com.kh.hp.main.model.service;

import static com.kh.hp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

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

}
