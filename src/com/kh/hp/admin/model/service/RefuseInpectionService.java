package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.commit;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.rollback;

import java.sql.Connection;



import com.kh.hp.admin.model.dao.RefuseInpectionDao;


public class RefuseInpectionService {

	
	
	//대관등록검수 거절인경우
	public int RefuseInpection(int rentSeq) {
	
		Connection con = getConnection();
		
		int result = 0;
		
		int reusult2 = 0;
		
		result = new RefuseInpectionDao().RefuseInpection(con,rentSeq);
		
		
		if(result > 0) {
	
			reusult2 = new RefuseInpectionDao().RefuseInpection1(con,rentSeq);
	
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