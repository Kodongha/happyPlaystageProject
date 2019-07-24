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

}
