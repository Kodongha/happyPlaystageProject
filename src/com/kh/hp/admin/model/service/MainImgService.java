package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.admin.model.dao.DetailInspectionDao;
import com.kh.hp.admin.model.dao.MainImgDao;
import com.kh.hp.admin.model.vo.DetailInspectionVO;

public class MainImgService {

	
	
	//대표이미지
	public String mainImg(int rentSeq) {
		Connection con = getConnection();
		
		String mainImg = new MainImgDao().mainImg(con,rentSeq);
		
		

		close(con);

		return mainImg;

		
	
	
	}



	

}
