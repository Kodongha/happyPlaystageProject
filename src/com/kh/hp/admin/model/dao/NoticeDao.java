package com.kh.hp.admin.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.admin.model.vo.NoticeVO;
import com.kh.hp.admin.model.vo.User;

public class NoticeDao {

	Properties prop = new Properties();

	public NoticeDao() {

		String fileName = NoticeDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//공지사항 전체 select 
	public ArrayList<NoticeVO> selectNotice(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<NoticeVO> NoticeList = null;

		String query  = prop.getProperty("selectNotice");

		try {
			pstmt = con.prepareStatement(query);


			rset = pstmt.executeQuery();

			NoticeList = new ArrayList<NoticeVO>();

			while(rset.next()) {
				NoticeVO noticeVO = new NoticeVO();

				noticeVO.setNoticeSeq(rset.getInt("NOTICE_SEQ"));
				noticeVO.setNoticeCate(rset.getString("NOTICE_CATE"));
				noticeVO.setNoticeTitile(rset.getString("NOTICE_TITLE"));
				noticeVO.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				noticeVO.setUserSeq(rset.getInt("USER_SEQ"));
				noticeVO.setNoticeWrDt(rset.getDate("NOTICE_WR_DT"));
				noticeVO.setNoticeRemoveTf(rset.getString("NOTICE_REMOVE_TF"));


				NoticeList.add(noticeVO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


		return NoticeList;
	}

	//공지내역 상세조회
	public NoticeVO selectOne(Connection con, int noticeSeq) {


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		NoticeVO NoticeOne = null;


		String query = prop.getProperty("selectOneNotice");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, noticeSeq);


			rset = pstmt.executeQuery();


			if(rset.next()) {
				NoticeOne = new NoticeVO();

				NoticeOne.setNoticeSeq(rset.getInt("NOTICE_SEQ"));
				NoticeOne.setNoticeCate(rset.getString("NOTICE_CATE"));
				NoticeOne.setNoticeTitile(rset.getString("NOTICE_TITLE"));
				NoticeOne.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				NoticeOne.setUserSeq(rset.getInt("USER_SEQ"));
				NoticeOne.setNoticeWrDt(rset.getDate("NOTICE_WR_DT"));
				NoticeOne.setNoticeRemoveTf(rset.getString("NOTICE_REMOVE_TF"));



			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}



		return NoticeOne;
	}

	//공지사항등록메소드
	public int insertnoticeWirte(Connection con, NoticeVO noticeWirte) {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertnoticeWirte");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, noticeWirte.getNoticeCate());
			pstmt.setString(2, noticeWirte.getNoticeTitile());
			pstmt.setString(3, noticeWirte.getNoticeContent());



			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

	



		return result;
	}


	

}












