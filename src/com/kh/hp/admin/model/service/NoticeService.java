package com.kh.hp.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.admin.model.dao.NoticeDao;
import com.kh.hp.admin.model.dao.UpdateOneUserDao;
import com.kh.hp.admin.model.vo.NoticeVO;


import static com.kh.hp.common.JDBCTemplate.*;



public class NoticeService {


	//공지사항 전체 select 
	public ArrayList<NoticeVO> selectNotice() {
		Connection con = getConnection();


		ArrayList<NoticeVO> Noticelist = new NoticeDao().selectNotice(con);

		close(con);

		return Noticelist;
	}

	//공지사항 상세내역조회
	public NoticeVO selectOne(int noticeSeq) {

		Connection con = getConnection();
		NoticeVO NoticeOne = null;

		NoticeOne = new NoticeDao().selectOne(con, noticeSeq);



		return NoticeOne;
	}


	//공지사항 등록 메소드
	public int insertnoticeWirte(NoticeVO noticeWirte) {


		Connection con =  getConnection();

		int result = new NoticeDao().insertnoticeWirte(con ,noticeWirte);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		close(con);




		return result;
	}


}

