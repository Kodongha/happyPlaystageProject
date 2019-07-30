package com.kh.hp.admin.model.service;

import java.sql.Connection;

import com.kh.hp.admin.model.dao.RegisCerDao;
import com.kh.hp.admin.model.vo.AttachmentVO;

import static com.kh.hp.common.JDBCTemplate.*;

public class RegisCerService {

	//공연등록증
	public AttachmentVO regisCer(int rentSeq) {
		Connection con = getConnection();

		AttachmentVO file = new RegisCerDao().regisCer(con, rentSeq);

		close(con);

		return file;

	}

}
