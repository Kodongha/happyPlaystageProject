package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.commit;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.hp.admin.model.dao.UpdateInpectionDao;
public class UpdateInpectionService {

	
	//대관 등록 검수 리스트 상세 검수완료 업데이트
	public int updateInpection(int rentSeq) {
	
		

		Connection con = getConnection();
		
		int result = 0;
		
		int reusult2 = 0;
		
		
		result = new UpdateInpectionDao().UpdateInpection(con,rentSeq);
		
		
		if(result > 0) {
			
			reusult2 = new UpdateInpectionDao().UpdateInpection1(con,rentSeq);
		}

		if(reusult2 > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		
		close(con);
	

		return reusult2;
	}
}