package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.admin.model.dao.InspectionListVOListDao;
import com.kh.hp.admin.model.dao.SetRegPermissionsDao;
import com.kh.hp.admin.model.dao.UserDao;
import com.kh.hp.admin.model.vo.InspectionListVO;
import com.kh.hp.admin.model.vo.SetRegPermissionsVO;

public class InspectionListService {




	//대관등록검수
	public ArrayList<InspectionListVO> InspectionList(int currentPage, int limit) {

		System.out.println("대관등록검수 서비스까지 왔나요?");


		Connection con = getConnection();

		ArrayList<InspectionListVO> InspectionListVOList = new InspectionListVOListDao().InspectionList(con,currentPage, limit);

		close(con);

		return InspectionListVOList;








	}

}
