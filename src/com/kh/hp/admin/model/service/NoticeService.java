package com.kh.hp.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.admin.model.dao.NoticeDao;
import com.kh.hp.admin.model.dao.SearchUserDao;
import com.kh.hp.admin.model.dao.UpdateOneUserDao;
import com.kh.hp.admin.model.vo.NoticeVO;
import com.kh.hp.admin.model.vo.User;
import com.kh.hp.serviceCenter.model.dao.ServiceCenterDao;
import com.kh.hp.serviceCenter.model.vo.FaQVO;

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

	//공지사항 수정
	public int updateNotice(NoticeVO updateNotice) {

		Connection con = getConnection();

		int result = new NoticeDao().updateNotice(con, updateNotice);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return result;
	}


	//공지사항 검색 (전체검색만)
	public ArrayList<NoticeVO> noticeSearch(String search, String cate) {
		System.out.println("전체검색공지사항 들어왔나요");

		Connection con = getConnection();
		ArrayList<NoticeVO> noticeSearch  = null; 

		if (cate != null && search.equals("")) {	

			if(cate.equals("선택")) {
				noticeSearch = new  NoticeDao().searchAllNotice(con, cate, search);
				//카테고리만 검색
			}else {
				noticeSearch = new NoticeDao().searchCate(con, cate, search);
			}


		}else if (cate != null && search != null) {
			//내용으로만검
			if(cate.equals("선택")) {

				noticeSearch = new NoticeDao().searchValue(con, cate, search);


				//검색과, 공지유무 둘다
			} else {
				noticeSearch = new NoticeDao().searchTwo(con, cate, search);
				
			}


		}

		return noticeSearch;
	}	
}

