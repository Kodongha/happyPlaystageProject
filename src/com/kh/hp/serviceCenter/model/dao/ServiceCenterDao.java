package com.kh.hp.serviceCenter.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.admin.model.vo.RealTimeVO;
import com.kh.hp.serviceCenter.model.vo.FaQVO;
import com.kh.hp.serviceCenter.model.vo.Notice;

public class ServiceCenterDao {
	private Properties prop = new Properties();

	public ServiceCenterDao() {
		String fileName = ServiceCenterDao.class.getResource("/sql/serviceCenter/serviceCenter-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** 자주묻는질문 전체 조회
	 * @param con
	 * @return
	 */
	public ArrayList<FaQVO> selectAllFaQ(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<FaQVO> list= null;

		String query = prop.getProperty("selectAllFaQ");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<FaQVO>();

			while(rset.next()) {
				FaQVO faq = new FaQVO();

				faq.setFnqCate(rset.getString("FNQ_CATE"));
				faq.setFnqQuestion(rset.getString("FNQ_QUESTION"));
				faq.setFnqAnswer(rset.getString("FNQ_ANSWER"));

				list.add(faq);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	/** 공지사항 전체 조회
	 * @param con
	 * @return
	 */
	public ArrayList<Notice> selectAllNotice(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = null;

		String query = prop.getProperty("selectAllNotice");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<Notice>();

			while(rset.next()) {
				Notice noticeVO = new Notice();

				noticeVO.setNoticeCate(rset.getString("NOTICE_CATE"));
				noticeVO.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				noticeVO.setNoticeContent(rset.getString("NOTICE_CONTENT"));

				list.add(noticeVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}


	/** 공지사항 전체 게시물 수 조회
	 * @param con
	 * @return
	 */
	public int getListCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectListCount");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}

		return listCount;
	}

	/** 페이징 처리 후 게시물 조회용 메소드
	 * @param con
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public ArrayList<Notice> selectNoticeList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = null;

		String query = prop.getProperty("selectNoticeWithPaging");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<Notice>();

			while(rset.next()) {
				Notice n = new Notice();

				n.setNoticeCate(rset.getString("NOTICE_CATE"));
				n.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				n.setNoticeContent(rset.getString("NOTICE_CONTENT"));

				list.add(n);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}


	/** 공지사항 검색 메소드
	 * @param con
	 * @param searchValue
	 * @return
	 */
	public ArrayList<Notice> searchNotice(Connection con, String searchValue, int currentPage, int limit) {
		ArrayList<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("searchNoticeWithPaging");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setString(1, searchValue);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<Notice>();

			while(rset.next()) {
				Notice n = new Notice();

				n.setNoticeCate(rset.getString("NOTICE_CATE"));
				n.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				n.setNoticeContent(rset.getString("NOTICE_CONTENT"));

				list.add(n);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		System.out.println("dao ::: " + list);

		return list;
	}

	/** 검색된 게시물 리스트 카운트
	 * @param con
	 * @param searchValue
	 * @return
	 */
	public int SearchListCount(Connection con, String searchValue) {
		System.out.println("dao 들어옴!!");
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("searchNoticeList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchValue);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
				System.out.println("들어옴");
			}else {
				System.out.println("안들어옴");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return listCount;
	}

	/**1:1 문의 관련 방 만들기
	 * @param con
	 * @param userSeq
	 * @return
	 */
	public int createQnARoom(Connection con, int userSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("createQnARoom");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 1:1 문의 관련 방 유무 확인
	 * @param con
	 * @param userSeq
	 * @return
	 */
	public int selectHaveRoom(Connection con, int userSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("selectHaveRoom");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);
			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	/**
	 * 1:1 문의 방 번호 확인
	 * @param con
	 * @param userSeq
	 * @return
	 */
	public int selectRoomNo(Connection con, String userSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int roomNo = 0;

		String query = prop.getProperty("selectRoomNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(userSeq));

			rset = pstmt.executeQuery();

			if(rset.next()) {
				roomNo = rset.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return roomNo;
	}

	/**
	 * 1:1 문의 관련 회원 등급 가져오기
	 * @param con
	 * @param userSeq
	 * @return
	 */
	public int selectUserGradeCd(Connection con, String userSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int userGradeCd = 999;

		String query = prop.getProperty("selectUserGradeCd");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(userSeq));

			rset = pstmt.executeQuery();

			if(rset.next()) {
				userGradeCd = rset.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userGradeCd;
	}

	/**
	 * 1:1 문의 관련관리자일 경우 답변 저장
	 * @param con
	 * @param userSeq
	 * @param sendMsg
	 * @param roomSeq
	 * @return
	 */
	public int insertAnswer(Connection con, String userSeq, String sendMsg, String roomSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertAnswer");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(roomSeq));
			pstmt.setString(2, sendMsg);
			pstmt.setString(3, userSeq);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 1:1 문의 관련 일반 유저일 경우 질문 저장
	 * @param con
	 * @param userSeq
	 * @param sendMsg
	 * @param roomNo
	 * @return
	 */
	public int insertQuestion(Connection con, String userSeq, String sendMsg, int roomNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertQuestion");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, roomNo);
			pstmt.setString(2, sendMsg);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 1:1 문의 관련 방 상태 변경
	 * @param con
	 * @param roomNo
	 * @return
	 */
	public int updateQuestionRoomStatus(Connection con, int roomNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateQuestionRoomStatus");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, roomNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 1:1 문의 관련 관리자 번호 확인
	 * @param con
	 * @return
	 */
	public ArrayList<Integer> selectAdminUserSeqList(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Integer> adminUserSeqList = null;

		String query = prop.getProperty("selectAdminUserSeqList");
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			adminUserSeqList = new ArrayList<Integer>();
			while(rset.next()) {
				int adminUserSeq = rset.getInt(1);
				adminUserSeqList.add(adminUserSeq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return adminUserSeqList;
	}

	public ArrayList<RealTimeVO> selectConversationList(Connection con, int userSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RealTimeVO> realTimeVOList = null;

		String query = prop.getProperty("selectConversationList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);

			rset = pstmt.executeQuery();

			realTimeVOList = new ArrayList<RealTimeVO>();
			while(rset.next()) {
				RealTimeVO realTimeVO = new RealTimeVO();
				realTimeVO.setChatSeq(rset.getInt("CHAT_SEQ"));
				realTimeVO.setRoomSeq(rset.getInt("ROOM_SEQ"));
				realTimeVO.setRcvMsg(rset.getString("RCV_MSG"));
				realTimeVO.setSendMsg(rset.getString("SEND_MSG"));
				realTimeVO.setAdminNo(rset.getInt("ADMIN_NO"));
				realTimeVO.setCharDate(rset.getDate("CHAR_DATE"));
				realTimeVO.setUserNick(rset.getString("USER_NICK"));
				realTimeVOList.add(realTimeVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return realTimeVOList;
	}

	public int selectTargetUserSeq(Connection con, String roomSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int targetUserSeq = 0;

		String query = prop.getProperty("selectTargetUserSeq");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(roomSeq));

			rset = pstmt.executeQuery();

			if(rset.next()) {
				targetUserSeq = rset.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return targetUserSeq;
	}

	public int updateAnwer(Connection con, String roomSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateAnwer");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(roomSeq));

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 *
	 * 검색조건 주고 자주묻는 질문 조회
	 * @param con
	 * @param category
	 * @param keyword
	 * @return
	 */
	public ArrayList<FaQVO> searchAllFAQ(Connection con, String category, String keyword) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<FaQVO> list= null;

		String query = prop.getProperty("selectAllFaQ");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<FaQVO>();

			while(rset.next()) {
				FaQVO faq = new FaQVO();

				faq.setFnqCate(rset.getString("FNQ_CATE"));
				faq.setFnqQuestion(rset.getString("FNQ_QUESTION"));
				faq.setFnqAnswer(rset.getString("FNQ_ANSWER"));

				list.add(faq);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	/**
	 *
	 * 카테고리만 값이 있는 검색
	 * @param con
	 * @param category
	 * @param keyword
	 * @return
	 */
	public ArrayList<FaQVO> searchCategory(Connection con, String category, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FaQVO> list= null;

		String query = prop.getProperty("selectCategory");

		System.out.println("&%^&^&%^& : " + category);

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, category);

			rset = pstmt.executeQuery();

			list = new ArrayList<FaQVO>();

			while(rset.next()) {
				FaQVO faq = new FaQVO();

				faq.setFnqCate(rset.getString("FNQ_CATE"));
				faq.setFnqQuestion(rset.getString("FNQ_QUESTION"));
				faq.setFnqAnswer(rset.getString("FNQ_ANSWER"));

				list.add(faq);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<FaQVO> searchTwo(Connection con, String category, String keyword) {
		System.out.println("SEARCH TWO 호출됨!!!!");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FaQVO> list= null;

		String query = prop.getProperty("selectCateKey");

		System.out.println("&%^&^&%^& : " + category);
		System.out.println("&%^&^&%^& : " + keyword);

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setString(2, keyword);

			rset = pstmt.executeQuery();

			list = new ArrayList<FaQVO>();

			while(rset.next()) {
				FaQVO faq = new FaQVO();

				faq.setFnqCate(rset.getString("FNQ_CATE"));
				faq.setFnqQuestion(rset.getString("FNQ_QUESTION"));
				faq.setFnqAnswer(rset.getString("FNQ_ANSWER"));

				list.add(faq);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<FaQVO> searchOnlyValue(Connection con, String category, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FaQVO> list= null;

		String query = prop.getProperty("searchOnlyValue");

		System.out.println("&%^&^&%^& : " + category);
		System.out.println("&%^&^&%^& : " + keyword);

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, keyword);

			rset = pstmt.executeQuery();

			list = new ArrayList<FaQVO>();

			while(rset.next()) {
				FaQVO faq = new FaQVO();

				faq.setFnqCate(rset.getString("FNQ_CATE"));
				faq.setFnqQuestion(rset.getString("FNQ_QUESTION"));
				faq.setFnqAnswer(rset.getString("FNQ_ANSWER"));

				list.add(faq);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}



}
