package com.kh.hp.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.admin.model.vo.User;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;

import static com.kh.hp.common.JDBCTemplate.*;
public class UserDao {

	Properties prop = new Properties();

	public UserDao() {

		String fileName = UserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*public ArrayList<User> selectAll(Connection con) {
		ArrayList<User> list = null;
		Statement stmt = null;
		ResultSet rset = null;


		String query = prop.getProperty("selectAll");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<User>();

			while(rset.next()) {
				User u = new User();

				u.setUserSeq(rset.getInt("USER_SEQ"));
				u.setUserEmail(rset.getString("USER_EMAIL"));
				u.setUserPwd(rset.getString("USER_PWD"));
				u.setUserNm(rset.getString("USER_NICK"));
				u.setUserNick(rset.getString("USER_NICK"));
				u.setUserPhone(rset.getString("USER_PHONE"));
				u.setUserGradeCd(rset.getInt("USER_GRADE_CO"));				
				u.setEnrollDt(rset.getDate("ENROLL_DT"));
				u.setSnsCd(rset.getInt("SNS_CD"));
				u.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				u.setLeaveDt(rset.getDate("LEAVE_DT"));


				list.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}


		return list;
	}*/

	//회원수 전체 조회용 메소드

	public int getListCount(Connection con) {
		System.out.println(" listCount!!!!");
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query  = prop.getProperty("selectListCount");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		return listCount;
	}

	//페이징 처리후 전체 회원 조회용 메소드
	public ArrayList<User> selectList(Connection con, int currentPage, int limit) {
		System.out.println(" selectListWithPaging!!!!");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> list = null;

		String query = prop.getProperty("selectListWithPaging");

		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<User>();

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
				
			
				
				

				list.add(user);
				System.out.println("리스트를 보여죵");
				
				System.out.println(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	
	//회원 조회용 메소드
	public User selectOne(Connection con, int userSeq) {
		
	System.err.println("selectone dao까지 왔나요????");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User oneUser = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				oneUser = new User();
				
				oneUser.setUserSeq(rset.getInt("USER_SEQ"));
				oneUser.setUserEmail(rset.getString("USER_EMAIL"));
				oneUser.setUserNm(rset.getString("USER_NM"));
				oneUser.setUserNick(rset.getString("USER_NICK"));
				oneUser.setUserPhone(rset.getString("USER_PHONE"));
				oneUser.setEnrollDt(rset.getDate("ENROLL_DT"));
				oneUser.setSnsCd(rset.getInt("SNS_CD"));
				oneUser.setLeaveTf(rset.getString("LEAVE_TF").charAt(0));
				oneUser.setLeaveDt(rset.getDate("LEAVE_DT"));
				oneUser.setUserGradeCd(rset.getInt("USER_GRADE_CD"));	
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return oneUser;
	}

	
	
	

	
	
	
	

}
















