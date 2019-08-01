package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.commit;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.hp.admin.model.dao.CanselSetRegDao;


public class CanseleSetRegService {

	
	//대관 등록 권한 설정 승인유무 취소
	public int CanselSetReg(int userSeq) {
		
		

		Connection con = getConnection();
		
		int result = 0;
		
		int reusult2 = 0;
		
		
		result = new CanselSetRegDao().CanselSetReg(con,userSeq);
		
		
		if(result > 0) {
			
			reusult2 = new CanselSetRegDao().CanselSetReg1(con,userSeq);
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