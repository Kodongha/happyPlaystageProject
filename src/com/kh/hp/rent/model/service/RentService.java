package com.kh.hp.rent.model.service;

import static com.kh.hp.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.rent.model.dao.RentDao;
import com.kh.hp.rent.model.vo.DetFacVO;

public class RentService {

	public ArrayList<DetFacVO> selectDetFacAll() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ArrayList<DetFacVO> detFacVOList = new RentDao().selectDetFacAll(con);

		return detFacVOList;
	}



}
