package com.kh.hp.serviceCenter.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.hp.common.JDBCTemplate.*;

import com.kh.hp.admin.model.dao.RealTimeDao;
import com.kh.hp.admin.model.vo.RealTimeVO;
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

	/**
	 * 1:1 문의 관련 방 만들기
	 * @param userSeq
	 * @return
	 */
	public int createQnARoom(int userSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		int result = new ServiceCenterDao().createQnARoom(con, userSeq);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result;
	}

	/**
	 * 1:1 문의 관련 방 유무 확인
	 * @param userSeq
	 * @return
	 */
	public int selectHaveRoom(int userSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		int result = new ServiceCenterDao().selectHaveRoom(con, userSeq);

		close(con);

		return result;
	}


	/**
	 *
	 * @param userSeq
	 * @param sendMsg
	 * @param userGradeCd
	 * @param roomSeq : 관리자가 사용하는 방번호
	 * @return
	 */
	public int insertConversation(String userSeq, String sendMsg, int userGradeCd, String roomSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ServiceCenterDao serviceCenterDao = new ServiceCenterDao();

		int insertQuestionResult = 0;
		int insertAnswerResult = 0;
		int updateQuestionRoomStatusResult = 0;
		int updateAnwerResult = 0;

		int roomNo = 0;
		// 관리자인지 유저인지 구분한다.
		// 관리자일 경우
		if(userGradeCd == 0) {

			// 답변 내용 DB에 INSERT
			insertAnswerResult = serviceCenterDao.insertAnswer(con, userSeq, sendMsg, roomSeq);
			System.out.println("insertAnswerResult::" + insertAnswerResult);
			// 1:1 문의 방 상태 UPDATE
			updateAnwerResult = serviceCenterDao.updateAnwer(con, roomSeq);
			System.out.println("updateAnwerResult::" + updateAnwerResult);
			if(insertAnswerResult > 0 && updateAnwerResult > 0) {
				commit(con);
			} else {
				rollback(con);
			}

		// 유저일 경우
		} else if(userGradeCd == 1 || userGradeCd == 2) {
			// 방 번호 가져오기
			roomNo = serviceCenterDao.selectRoomNo(con, userSeq);
			System.out.println("roomNo::" + roomNo);
			// 답변 내용 DB에 INSERT
			insertQuestionResult = serviceCenterDao.insertQuestion(con, userSeq, sendMsg, roomNo);
			System.out.println("insertQuestionResult::" + insertQuestionResult);
			// 1:1 문의 방 상태 UPDATE
			updateQuestionRoomStatusResult = serviceCenterDao.updateQuestionRoomStatus(con, roomNo);
			System.out.println("updateQuestionRoomStatusResult::" + updateQuestionRoomStatusResult);

			if(insertQuestionResult > 0 && updateQuestionRoomStatusResult > 0) {
				commit(con);
			} else {
				rollback(con);
			}

		// 에러
		} else {
			System.out.println("에러 발생");
		}

		close(con);

		return 0;
	}

	public ArrayList<Integer> selectAdminUserSeqList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ArrayList<Integer> adminUserSeqList = null;

		adminUserSeqList = new ServiceCenterDao().selectAdminUserSeqList(con);

		return adminUserSeqList;
	}

	/**
	 * userSeq의 회원등급  코드를 가져온다.
	 * @param userSeq
	 * @return
	 */
	public int selectUserGradeCd(String userSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		int userGradeCd = new ServiceCenterDao().selectUserGradeCd(con, userSeq);
		System.out.println("userGradeCd::" + userGradeCd);

		return userGradeCd;
	}

	public ArrayList<RealTimeVO> selectConversationList(int userSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		ArrayList<RealTimeVO> realTimeVOList = new ServiceCenterDao().selectConversationList(con, userSeq);

		close(con);

		return realTimeVOList;
	}

	/**
	 * 방번호에 존재하는 유저번호 가져오기
	 * @param roomSeq
	 * @return
	 */
	public int selectTargetUserSeq(String roomSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		int targetUserSeq = new ServiceCenterDao().selectTargetUserSeq(con, roomSeq);

		close(con);

		return targetUserSeq;
	}

	/**
	 * 자주묻는 질문 검색
	 * @param category
	 * @param keyword
	 * @return
	 */
	public ArrayList<FaQVO> searchFAQ(String category, String keyword) {
		Connection con = getConnection();

		ArrayList<FaQVO> list = null;

		ServiceCenterDao sd = new ServiceCenterDao();

		if (category != null && keyword.equals("")) {
			System.out.println("카테고리만 지정");
			if(category.equals("전체")) {
				list = sd.searchAllFAQ(con, category, keyword);
			}else {
				list = sd.searchCategory(con, category, keyword);
			}
		} else if (category != null && keyword != null) {
			System.out.println("둘다 값이 있음");

			if(category.equals("전체")) {
				list = sd.searchOnlyValue(con, category, keyword);
			} else {
				list = sd.searchTwo(con, category, keyword);
			}
		}

		return list;
	}

}
