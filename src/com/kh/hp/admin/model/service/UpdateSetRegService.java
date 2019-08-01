package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.hp.admin.model.dao.UpdateSetRegDao;

public class UpdateSetRegService {
	
	
	//대관 등록 권한 설정 승인유무 업데이트
	public int UpdateSetReg(int userSeq) {
		
		System.out.println("등업신청 서비스왔나요 ? ");
		
		
		Connection con = getConnection();
		
		int result = 0;
		
		int reusult2 = 0;
		
		
		result = new UpdateSetRegDao().UpdateSetReg(con,userSeq);
		
		
		if(result > 0) {
			
			reusult2 = new UpdateSetRegDao().UpdateSetReg1(con,userSeq);
		}

		if(reusult2 > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		
		close(con);
		
		
		System.out.println(result);
		
		System.out.println(reusult2);

		return reusult2;
	}
}