package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.admin.model.dao.UpdateOneUserDao;
import com.kh.hp.admin.model.vo.AttachmentVO;
import com.kh.hp.admin.model.vo.UpdateUserVO;

public class UpdateOneUserService {

	
	
	//회원정보 수정용 메소드
	public int updateOneUser(UpdateUserVO updateUser) {
	 Connection con = getConnection();
	 
	 int result = new UpdateOneUserDao().updateOneUser(con,updateUser);
		
			 if(result > 0) {
					commit(con);
				}else {
					rollback(con);
				}
				close(con);

				return result;
	
	}




}
