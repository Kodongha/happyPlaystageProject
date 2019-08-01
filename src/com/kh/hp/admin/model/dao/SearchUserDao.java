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

import com.kh.hp.admin.model.vo.AttachmentVO;
import com.kh.hp.admin.model.vo.InspectionListVO;
import com.kh.hp.admin.model.vo.User;

public class SearchUserDao {

	private Properties prop = new Properties();

	public SearchUserDao() {
		String fileName = 
				RegisCerDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//이름만 검색시 
	public ArrayList<User> SearchUserNm(Connection con, String userNm, int currentPage, int limit) {


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> SearchUserNm = null;


		String query = prop.getProperty("SearchUserNm");

		try {
			pstmt = con.prepareStatement(query);


			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setString(1, userNm);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);		

			rset = pstmt.executeQuery();

			SearchUserNm = new ArrayList<User>();

			while(rset.next()) {

				User user = new User();

				user.setUserSeq(rset.getInt("USER_SEQ"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserNm(rset.getString("USER_NM"));
				user.setUserNick(rset.getString("USER_NICK"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setEnrollDt(rset.getDate("ENROLL_DT"));
				user.setSnsCd(rset.getInt("SNS_CD"));
				user.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				user.setLeaveDt(rset.getDate("LEAVE_DT"));
				user.setUserGradeCd(rset.getInt("USER_GRADE_CD"));

				SearchUserNm.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return SearchUserNm;
	}

	//회원번호로만 조회용 메소드
	public ArrayList<User> SearchUserSeq(Connection con, String userSeq1, String userSeq2, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> SearchUserSeq = null;


		String query = prop.getProperty("SearchUserSeq");
		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			int userSeqStart = Integer.parseInt(userSeq1);
			int userSeqEnd = Integer.parseInt(userSeq2);




			pstmt.setInt(1, userSeqStart);	
			pstmt.setInt(2, userSeqEnd);		
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);

			rset = pstmt.executeQuery();


			SearchUserSeq = new ArrayList<User>();



			while(rset.next()) {

				User user = new User();

				user.setUserSeq(rset.getInt("USER_SEQ"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserNm(rset.getString("USER_NM"));
				user.setUserNick(rset.getString("USER_NICK"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setEnrollDt(rset.getDate("ENROLL_DT"));
				user.setSnsCd(rset.getInt("SNS_CD"));
				user.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				user.setLeaveDt(rset.getDate("LEAVE_DT"));
				user.setUserGradeCd(rset.getInt("USER_GRADE_CD"));	
				SearchUserSeq.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return SearchUserSeq;
	}

	//대관승인등록으로만 검색
	public ArrayList<User> SearchUserCd(Connection con, String userGradeCd, int currentPage, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> SearchUserCd = null;


		String query = prop.getProperty("SearchUserCd");
		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			int userGradeCd1;

			if(userGradeCd.equals("Y")) {
				userGradeCd1 = 2;
			}else {
				userGradeCd1 = 1;


			}

			System.out.println("userGradeCd1::::" +userGradeCd1);


			pstmt.setInt(1, userGradeCd1);		
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();


			SearchUserCd = new ArrayList<User>();



			while(rset.next()) {

				User user = new User();

				user.setUserSeq(rset.getInt("USER_SEQ"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserNm(rset.getString("USER_NM"));
				user.setUserNick(rset.getString("USER_NICK"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setEnrollDt(rset.getDate("ENROLL_DT"));
				user.setSnsCd(rset.getInt("SNS_CD"));
				user.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				user.setLeaveDt(rset.getDate("LEAVE_DT"));
				user.setUserGradeCd(rset.getInt("USER_GRADE_CD"));	



				SearchUserCd.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return SearchUserCd;
	}


	//탈퇴로만 검색
	public ArrayList<User> SearchUserleave(Connection con, String leaveTf, int currentPage, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> SearchUserleave = null;


		String query = prop.getProperty("SearchUserleave");
		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setString(1, leaveTf);		
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();


			SearchUserleave = new ArrayList<User>();

			while(rset.next()) {

				User user = new User();

				user.setUserSeq(rset.getInt("USER_SEQ"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserNm(rset.getString("USER_NM"));
				user.setUserNick(rset.getString("USER_NICK"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setEnrollDt(rset.getDate("ENROLL_DT"));
				user.setSnsCd(rset.getInt("SNS_CD"));
				user.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				user.setLeaveDt(rset.getDate("LEAVE_DT"));
				user.setUserGradeCd(rset.getInt("USER_GRADE_CD"));	


		


				SearchUserleave.add(user);




			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println(" 회원만탈퇴:::::" + SearchUserleave);
		return SearchUserleave;
	}

	//회원번호, 회원명으로 검색
	public ArrayList<User> SearchUserSeqNm(Connection con, String userSeq1, String userSeq2, String userNm,
			int currentPage, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> SearchUserSeqNm = null;


		String query = prop.getProperty("SearchUserSeqNm");
		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			int userSeqStart = Integer.parseInt(userSeq1);
			int userSeqEnd = Integer.parseInt(userSeq2);




			pstmt.setInt(1, userSeqStart);	
			pstmt.setInt(2, userSeqEnd);	
			pstmt.setString(3, userNm);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);

			rset = pstmt.executeQuery();


			SearchUserSeqNm = new ArrayList<User>();



			while(rset.next()) {

				User user = new User();

				user.setUserSeq(rset.getInt("USER_SEQ"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserNm(rset.getString("USER_NM"));
				user.setUserNick(rset.getString("USER_NICK"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setEnrollDt(rset.getDate("ENROLL_DT"));
				user.setSnsCd(rset.getInt("SNS_CD"));
				user.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				user.setLeaveDt(rset.getDate("LEAVE_DT"));
				user.setUserGradeCd(rset.getInt("USER_GRADE_CD"));	
				SearchUserSeqNm.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


		return SearchUserSeqNm;
	}

	//회원번호,대관등록승인으로만 검색
	public ArrayList<User> SearchUserSeqCd(Connection con, String userSeq1, String userSeq2, String userGradeCd,
			int currentPage, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> SearchUserSeqCd = null;


		String query = prop.getProperty("SearchUserSeqCd");
		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			int userSeqStart = Integer.parseInt(userSeq1);
			int userSeqEnd = Integer.parseInt(userSeq2);
			int userGradeCd1;

			if(userGradeCd.equals("Y")) {
				userGradeCd1 = 2;
			}else {
				userGradeCd1 = 1;

			}



			pstmt.setInt(1, userSeqStart);	
			pstmt.setInt(2, userSeqEnd);	
			pstmt.setInt(3, userGradeCd1);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);

			rset = pstmt.executeQuery();


			SearchUserSeqCd = new ArrayList<User>();



			while(rset.next()) {

				User user = new User();

				user.setUserSeq(rset.getInt("USER_SEQ"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserNm(rset.getString("USER_NM"));
				user.setUserNick(rset.getString("USER_NICK"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setEnrollDt(rset.getDate("ENROLL_DT"));
				user.setSnsCd(rset.getInt("SNS_CD"));
				user.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				user.setLeaveDt(rset.getDate("LEAVE_DT"));
				user.setUserGradeCd(rset.getInt("USER_GRADE_CD"));	
				SearchUserSeqCd.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


		return SearchUserSeqCd;
	}

	//회원번호, 탈퇴여부로 조회 
	public ArrayList<User> SearchUserSeqleave(Connection con, String userSeq1, String userSeq2, String leaveTf,
			int currentPage, int limit) {


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> SearchUserSeqleave = null;


		String query = prop.getProperty("SearchUserSeqleave");
		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			int userSeqStart = Integer.parseInt(userSeq1);
			int userSeqEnd = Integer.parseInt(userSeq2);




			pstmt.setInt(1, userSeqStart);	
			pstmt.setInt(2, userSeqEnd);	
			pstmt.setString(3, leaveTf);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);

			rset = pstmt.executeQuery();


			SearchUserSeqleave = new ArrayList<User>();



			while(rset.next()) {

				User user = new User();

				user.setUserSeq(rset.getInt("USER_SEQ"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserNm(rset.getString("USER_NM"));
				user.setUserNick(rset.getString("USER_NICK"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setEnrollDt(rset.getDate("ENROLL_DT"));
				user.setSnsCd(rset.getInt("SNS_CD"));
				user.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				user.setLeaveDt(rset.getDate("LEAVE_DT"));
				user.setUserGradeCd(rset.getInt("USER_GRADE_CD"));	
				SearchUserSeqleave.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


	
		return SearchUserSeqleave;
	}

	//회원명, 대관승인으로 검색
	public ArrayList<User> SearchUserNmCd(Connection con, String userNm, String userGradeCd, int currentPage,
			int limit) {


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> SearchUserNmCd = null;


		String query = prop.getProperty("SearchUserNmCd");

		try {
			pstmt = con.prepareStatement(query);


			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			int userGradeCd1;

			if(userGradeCd.equals("Y")) {
				userGradeCd1 = 2;
			}else {
				userGradeCd1 = 1;

			}


			pstmt.setString(1, userNm);
			pstmt.setInt(2, userGradeCd1);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);		

			rset = pstmt.executeQuery();

			SearchUserNmCd = new ArrayList<User>();

			while(rset.next()) {

				User user = new User();

				user.setUserSeq(rset.getInt("USER_SEQ"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserNm(rset.getString("USER_NM"));
				user.setUserNick(rset.getString("USER_NICK"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setEnrollDt(rset.getDate("ENROLL_DT"));
				user.setSnsCd(rset.getInt("SNS_CD"));
				user.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				user.setLeaveDt(rset.getDate("LEAVE_DT"));
				user.setUserGradeCd(rset.getInt("USER_GRADE_CD"));

				SearchUserNmCd.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return SearchUserNmCd;
	}

	//회원명, 탈퇴여부로 검색
	public ArrayList<User> SearchUserNmleave(Connection con, String userNm, String leaveTf, int currentPage,
			int limit) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> SearchUserNmleave = null;


		String query = prop.getProperty("SearchUserNmleave");

		try {
			pstmt = con.prepareStatement(query);


			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			


			pstmt.setString(1, userNm);
			pstmt.setString(2, leaveTf);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);		

			rset = pstmt.executeQuery();

			SearchUserNmleave = new ArrayList<User>();

			while(rset.next()) {

				User user = new User();

				user.setUserSeq(rset.getInt("USER_SEQ"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserNm(rset.getString("USER_NM"));
				user.setUserNick(rset.getString("USER_NICK"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setEnrollDt(rset.getDate("ENROLL_DT"));
				user.setSnsCd(rset.getInt("SNS_CD"));
				user.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				user.setLeaveDt(rset.getDate("LEAVE_DT"));
				user.setUserGradeCd(rset.getInt("USER_GRADE_CD"));

				SearchUserNmleave.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return SearchUserNmleave;
	}

	//대관등록승인 ,탈퇴여부로 검색
	public ArrayList<User> SearchUserCdleave(Connection con, String userGradeCd, String leaveTf, int currentPage,
			int limit) {
		

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> SearchUserCdleave = null;


		String query = prop.getProperty("SearchUserCdleave");

		try {
			pstmt = con.prepareStatement(query);


			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			int userGradeCd1;

			if(userGradeCd.equals("Y")) {
				userGradeCd1 = 2;
			}else {
				userGradeCd1 = 1;

			}



			pstmt.setInt(1, userGradeCd1);
			pstmt.setString(2, leaveTf);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);		

			rset = pstmt.executeQuery();

			SearchUserCdleave = new ArrayList<User>();

			while(rset.next()) {

				User user = new User();

				user.setUserSeq(rset.getInt("USER_SEQ"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserNm(rset.getString("USER_NM"));
				user.setUserNick(rset.getString("USER_NICK"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setEnrollDt(rset.getDate("ENROLL_DT"));
				user.setSnsCd(rset.getInt("SNS_CD"));
				user.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				user.setLeaveDt(rset.getDate("LEAVE_DT"));
				user.setUserGradeCd(rset.getInt("USER_GRADE_CD"));

				SearchUserCdleave.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return SearchUserCdleave;
	}

	//이름으로만 조회시 카운트
	public int getListCountforName(Connection con, String userNm) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListCountforName");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userNm);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount= rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listCount;
	}

	//회원번호로만 조회시 카운트
	public int getListCountforSeq(Connection con, String userSeq1, String userSeq2) {
		
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListCountforSeq");
		
		try {
			pstmt = con.prepareStatement(query);
			//pstmt.setString(1, userNm);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount= rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listCount;
	}
}