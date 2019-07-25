package com.kh.hp.serviceCenter.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.hp.common.JDBCTemplate.*;

import com.kh.hp.serviceCenter.model.dao.ServiceCenterDao;
import com.kh.hp.serviceCenter.model.vo.FaQVO;
import com.kh.hp.serviceCenter.model.vo.Notice;

public class ServiceCenterService {

	/** 자주묻는질문 전체 조회
	 * @return
	 */
	public ArrayList<FaQVO> selectAllFaQ() {
		Connection con = getConnection();

		ArrayList<FaQVO> faq = new ServiceCenterDao().selectAllFaQ(con);

		close(con);

		return faq;
	}

	/** 공지사항 전체 조회
	 * @return
	 */
	public ArrayList<Notice> selectAllNotice() {
		Connection con = getConnection();

		ArrayList<Notice> list = new ServiceCenterDao().selectAllNotice(con);

		close(con);

		return list;
	}

	/** 공지사항 전체 게시물 수 조회용 메소드
	 * @return
	 */
	public int getListCount() {
		Connection con = getConnection();

		int listCount = new ServiceCenterDao().getListCount(con);

		close(con);

		return listCount;
	}


	/** 페이징 처리 후 게시물 목록 조회 메소드
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public ArrayList<Notice> selectNoticeList(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<Notice> list = new ServiceCenterDao().selectNoticeList(con, currentPage, limit);

		close(con);

		return list;
	}


	/** 공지사항 검색 메소드
	 * @param searchValue
	 * @return
	 */
	public ArrayList<Notice> searchNotice(String searchValue, int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<Notice> list = null;

		ServiceCenterDao scd = new ServiceCenterDao();

		list = scd.searchNotice(con, searchValue, currentPage, limit);

		close(con);

		return list;
	}

	/** 검색된 게시물 리스트 카운트
	 * @param searchValue
	 * @return
	 */
	public int SearchListCount(String searchValue) {
		Connection con = getConnection();

		int listCount = new ServiceCenterDao().SearchListCount(con, searchValue);

		close(con);

		return listCount;
	}

}
