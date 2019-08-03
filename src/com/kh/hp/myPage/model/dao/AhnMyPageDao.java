package com.kh.hp.myPage.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.myPage.model.vo.AhnApplyInfoVO;
import com.kh.hp.myPage.model.vo.AhnAttachmentVO;
import com.kh.hp.myPage.model.vo.AhnLevelupInfoVO;
import com.kh.hp.myPage.model.vo.AhnLevelupVO;
import com.kh.hp.myPage.model.vo.AhnMyPageVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;

import static com.kh.hp.common.JDBCTemplate.*;

public class AhnMyPageDao {
	private Properties prop = new Properties();
	
	public AhnMyPageDao() {
		String fileName = AhnMyPageDao.class.getResource("/sql/myPage/myPage-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//로그인된 유저의 등업신청 정보 가져오는 Dao메소드
	public AhnLevelupVO selectOne(Connection con, int userSeq) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AhnLevelupVO responseUserVO = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				responseUserVO = new AhnLevelupVO();
				
				responseUserVO.setUserSeq(rset.getInt("USER_SEQ"));
				responseUserVO.setUserEmail(rset.getString("USER_EMAIL"));
				responseUserVO.setUserNm(rset.getString("USER_NM"));
				responseUserVO.setUserNick(rset.getString("USER_NICK"));
				responseUserVO.setUserPhone(rset.getString("USER_PHONE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO responseUserVO : " + responseUserVO);
		
		return responseUserVO;
	}
	
	//검색 전 신청내역 페이징카운트에 대한 DAO메소드
	public int getListCount(Connection con, int usingInfo) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectListCount");
		System.out.println("usingInfoDAO:::"+usingInfo);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, String.valueOf(usingInfo));
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println("결과 있음");
				listCount = rset.getInt(1);
			}else {
				System.out.println("결과 없음");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return listCount;
	}
	
	//검색 전 전체신청내역에 대한 DAO메소드
	public ArrayList<AhnApplyInfoVO> selectList(Connection con, int usingInfo, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnApplyInfoVO> list = null;
		
		
		String query = prop.getProperty("selectListWithPaging");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			
			pstmt.setInt(1, usingInfo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnApplyInfoVO>();
			
			while(rset.next()) {
				AhnApplyInfoVO b = new AhnApplyInfoVO();
		
				b.setHallNm(rset.getString("HALL_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				
				list.add(b);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
		
	}
	
	//검색 전 사용내역 페이징카운트에 대한 DAO메소드
	public int getListCount1(Connection con, int usingInfo) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectListCount1");
		System.out.println("usingInfoDAO:::"+usingInfo);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, String.valueOf(usingInfo));
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return listCount;
		
	}
	
	//검색 전 전체사용내역에 대한 DAO메소드
	public ArrayList<AhnUsingInfoVO> selectList1(Connection con, int usingInfo, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;
		
		String query = prop.getProperty("selectListWithPaging1");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, usingInfo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setCompNm(rset.getString("COMP_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
		
	}
	
	//검색후 신청내역 페이징카운트에 대한 DAO메소드
	public int getListCount2(Connection con, int userInfo, int rentSeq) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectListCount2");
		System.out.println("userInfo : " + userInfo);
		System.out.println("rentSeq : " + rentSeq);
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, rentSeq);
			pstmt.setInt(2, userInfo);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				System.out.println("결과 있음");
				listCount = rset.getInt(1);
			} else {
				System.out.println("결과 없음");
			}
			
			System.out.println("DAO listCount : " + listCount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return listCount;
		
	}
	
	//검색후 사용내역 페이징카운트에 대한 DAO메소드
	public int getListCount3(Connection con, int userInfo, int rentSeq) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectListCount3");
		System.out.println("userInfo : " + userInfo);
		System.out.println("rentSeq : " + rentSeq);
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, rentSeq);
			pstmt.setInt(2, userInfo);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				System.out.println("결과 있음");
				listCount = rset.getInt(1);
			} else {
				System.out.println("결과 없음");
			}
			
			System.out.println("DAO listCount : " + listCount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return listCount;
	}
	
	//검색후 사용내역에 대한 DAO메소드
	public ArrayList<AhnUsingInfoVO> searchCheck1(Connection con, int userInfo, int rentSeq, String hallNm, Date useStart, Date useEnd, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;
		
		String query = prop.getProperty("searchCheck1");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setString(3, hallNm);
			pstmt.setDate(4, useStart);
			pstmt.setDate(5, useEnd);
			pstmt.setInt(6, startRow);
			pstmt.setInt(7, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setCompNm(rset.getString("COMP_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
	}

	public int insertImage(Connection con, AhnLevelupInfoVO l) {
		System.out.println("들어옴1");
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertLevelOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, l.getUserSeq());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertAttachment(Connection con, ArrayList<AhnAttachmentVO> fileList) {
		System.out.println("들어옴2");
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
			try {
				for(int i = 0; i < fileList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, fileList.get(i).getOriginNm());
				pstmt.setString(2, fileList.get(i).getChangeNm());
				pstmt.setString(3, fileList.get(i).getFilePath());
				pstmt.setInt(4, fileList.get(i).getUserSeq());
				/*int level = 0;
				if(i == 0) {
					level = 0;
				}else {
					level = 1;
				}
				
				pstmt.setInt(5, level);*/
				
				result += pstmt.executeUpdate();
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		return result;
		
	}

	public ArrayList<AhnUsingInfoVO> searchCheck2(Connection con, int userInfo, String hallNm, Date useStart,
			Date useEnd, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;
		
		String query = prop.getProperty("searchCheck2");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setString(2, hallNm);
			pstmt.setDate(3, useStart);
			pstmt.setDate(4, useEnd);
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setCompNm(rset.getString("COMP_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
	}

	public ArrayList<AhnUsingInfoVO> searchCheck3(Connection con, int userInfo, int rentSeq, Date useStart, Date useEnd,
			int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;
		
		String query = prop.getProperty("searchCheck3");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setDate(3, useStart);
			pstmt.setDate(4, useEnd);
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setCompNm(rset.getString("COMP_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
	}

	public ArrayList<AhnUsingInfoVO> searchCheck4(Connection con, int userInfo, int rentSeq, String hallNm,
			int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;
		
		String query = prop.getProperty("searchCheck4");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setString(3, hallNm);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setCompNm(rset.getString("COMP_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
	}

	public ArrayList<AhnUsingInfoVO> searchCheck5(Connection con, int userInfo, int rentSeq, int currentPage,
			int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;
		
		String query = prop.getProperty("searchCheck5");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setCompNm(rset.getString("COMP_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
	}

	public ArrayList<AhnUsingInfoVO> searchCheck6(Connection con, int userInfo, String hallNm, int currentPage,
			int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;
		
		String query = prop.getProperty("searchCheck6");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setString(2, hallNm);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setCompNm(rset.getString("COMP_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
	}

	public ArrayList<AhnUsingInfoVO> searchCheck7(Connection con, int userInfo, Date useStart, Date useEnd,
			int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;
		
		String query = prop.getProperty("searchCheck7");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setDate(2, useStart);
			pstmt.setDate(3, useEnd);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setCompNm(rset.getString("COMP_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
	}

	public ArrayList<AhnUsingInfoVO> searchCheck8(Connection con, int userInfo, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;
		
		String query = prop.getProperty("searchCheck8");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setCompNm(rset.getString("COMP_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
	}
	
	
	//검색후 신청내역에 대한 DAO메소드
		public ArrayList<AhnApplyInfoVO> searchApplyCheck1(Connection con, int userInfo, int rentSeq, String hallNm, Date useStart, Date useEnd, int currentPage, int limit) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<AhnApplyInfoVO> list = null;
			
			String query = prop.getProperty("searchApplyCheck1");
			
			try {
				pstmt = con.prepareStatement(query);

				//조회를 시작할 행 번호와 마지막 행 번호 계산
				int startRow = (currentPage - 1) * limit + 1;
				int endRow = startRow + limit - 1;
				
				pstmt.setInt(1, userInfo);
				pstmt.setInt(2, rentSeq);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				
				rset = pstmt.executeQuery();
				
				list = new ArrayList<AhnApplyInfoVO>();
				
				while(rset.next()) {
					AhnApplyInfoVO b = new AhnApplyInfoVO();
					
					b.setHallNm(rset.getString("HALL_NM"));
					b.setPropSeq(rset.getInt("PROP_SEQ"));
					b.setRentSeq(rset.getInt("RENT_SEQ"));
					b.setUserSeq(rset.getInt("USER_SEQ"));
					b.setPropNm(rset.getString("PROP_NM"));
					b.setPropDt(rset.getDate("PROP_DT"));
					b.setPropStatus(rset.getString("PROP_STATUS"));
					b.setUseStartDt(rset.getDate("USE_START_DT"));
					b.setUseEndDt(rset.getDate("USE_END_DT"));
					
					list.add(b);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rset);
			}
			
			return list;
			
		}
		
	public ArrayList<AhnApplyInfoVO> searchApplyCheck2(Connection con, int userInfo, String hallNm, Date useStart,
			Date useEnd, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnApplyInfoVO> list = null;
		
		String query = prop.getProperty("searchApplyCheck2");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setString(2, hallNm);
			pstmt.setDate(3, useStart);
			pstmt.setDate(4, useEnd);
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnApplyInfoVO>();
			
			while(rset.next()) {
				AhnApplyInfoVO b = new AhnApplyInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
		
	}

	public ArrayList<AhnApplyInfoVO> searchApplyCheck3(Connection con, int userInfo, int rentSeq, Date useStart, Date useEnd,
			int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnApplyInfoVO> list = null;
		
		String query = prop.getProperty("searchApplyCheck3");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setDate(3, useStart);
			pstmt.setDate(4, useEnd);
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnApplyInfoVO>();
			
			while(rset.next()) {
				AhnApplyInfoVO b = new AhnApplyInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
		
	}

	public ArrayList<AhnApplyInfoVO> searchApplyCheck4(Connection con, int userInfo, int rentSeq, String hallNm,
			int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnApplyInfoVO> list = null;
		
		String query = prop.getProperty("searchApplyCheck4");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setString(3, hallNm);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnApplyInfoVO>();
			
			while(rset.next()) {
				AhnApplyInfoVO b = new AhnApplyInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
		
	}

	public ArrayList<AhnApplyInfoVO> searchApplyCheck5(Connection con, int userInfo, int rentSeq, int currentPage,
			int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnApplyInfoVO> list = null;
		
		String query = prop.getProperty("searchApplyCheck5");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnApplyInfoVO>();
			
			while(rset.next()) {
				AhnApplyInfoVO b = new AhnApplyInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
		
	}

	public ArrayList<AhnApplyInfoVO> searchApplyCheck6(Connection con, int userInfo, String hallNm, int currentPage,
			int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnApplyInfoVO> list = null;
		
		String query = prop.getProperty("searchApplyCheck6");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setString(2, hallNm);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnApplyInfoVO>();
			
			while(rset.next()) {
				AhnApplyInfoVO b = new AhnApplyInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
		
	}

	public ArrayList<AhnApplyInfoVO> searchApplyCheck7(Connection con, int userInfo, Date useStart, Date useEnd,
			int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnApplyInfoVO> list = null;
		
		String query = prop.getProperty("searchApplyCheck7");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setDate(2, useStart);
			pstmt.setDate(3, useEnd);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnApplyInfoVO>();
			
			while(rset.next()) {
				AhnApplyInfoVO b = new AhnApplyInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
	}

	public ArrayList<AhnApplyInfoVO> searchApplyCheck8(Connection con, int userInfo, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnApplyInfoVO> list = null;
		
		String query = prop.getProperty("searchApplyCheck8");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnApplyInfoVO>();
			
			while(rset.next()) {
				AhnApplyInfoVO b = new AhnApplyInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("DAO LIST : " + list);
		
		return list;
	}

	public ArrayList<AhnUsingInfoVO> searchUsingDetail(Connection con, int userInfo, int rentSeq, String hallNm,
			Date useStart, Date useEnd) {
		System.out.println("dao까지는 잘 들어오는데 왜 안될까..");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;
		
		String query = prop.getProperty("searchUsingDetail1");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setString(3, hallNm);
			pstmt.setDate(4, useStart);
			pstmt.setDate(5, useEnd);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnUsingInfoVO>();
			
			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				b.setPropHeadCount(rset.getInt("PROP_HEAD_COUNT"));
				b.setPropReqContent(rset.getString("PROP_REQ_CONTENT"));
				b.setPropPhone(rset.getString("PROP_PHONE"));
				b.setPropEmail(rset.getString("PROP_EMAIL"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	public ArrayList<AhnApplyInfoVO> searchApplyDetail(Connection con, int userInfo, int rentSeq, String hallNm,
			Date useStart, Date useEnd, String propStatus) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnApplyInfoVO> list = null;
		
		String query = prop.getProperty("searchApplyDetail1");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setString(3, hallNm);
			pstmt.setDate(4, useStart);
			pstmt.setDate(5, useEnd);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AhnApplyInfoVO>();
			
			while(rset.next()) {
				AhnApplyInfoVO b = new AhnApplyInfoVO();
				
				b.setHallNm(rset.getString("HALL_NM"));
				b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				b.setPropHeadCount(rset.getInt("PROP_HEAD_COUNT"));
				b.setPropReqContent(rset.getString("PROP_REQ_CONTENT"));
				b.setPropPhone(rset.getString("PROP_PHONE"));
				b.setPropEmail(rset.getString("PROP_EMAIL"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	public int payRefundInsert(Connection con, int userInfo, int propSeq) {
		System.out.println("들어옴1");
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPayRefund");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, propSeq);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int applyChange(Connection con, int userInfo, int propSeq) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertApplyChange");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, propSeq);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
