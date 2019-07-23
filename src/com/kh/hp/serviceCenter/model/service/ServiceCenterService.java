package com.kh.hp.serviceCenter.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.hp.common.JDBCTemplate.*;

import com.kh.hp.serviceCenter.model.dao.ServiceCenterDao;
import com.kh.hp.serviceCenter.model.vo.FaQVO;

public class ServiceCenterService {

	public ArrayList<FaQVO> selectFaQ() {
		Connection con = getConnection();

		ArrayList<FaQVO> faq = new ServiceCenterDao().selectFaQ(con);


		return faq;
	}

}
