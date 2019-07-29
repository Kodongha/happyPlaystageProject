package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.admin.model.dao.RealTimeDao;
import com.kh.hp.admin.model.vo.RealTimeVO;

public class RealTimeService {

	public ArrayList<RealTimeVO> selectRealTimeList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		ArrayList<RealTimeVO> realTimeVOs = new RealTimeDao().selectRealTimeList(con);

		for(RealTimeVO realTimeVO : realTimeVOs) {
			System.out.println(realTimeVO);
		}

		close(con);

		return realTimeVOs;
	}

}
