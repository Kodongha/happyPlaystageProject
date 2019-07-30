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
	/*public AhnLevelupVO insertLevelOne(Connection con, int levelUpInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AhnLevelupVO responseUserVO = null;

		String query = prop.getProperty("insertLevelOne");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, levelUpInfo);
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

		System.out.println("responseUserVO : " + responseUserVO);

		return responseUserVO;
	}*/

	/*public int insertLevelOne(Connection con, AhnLevelupInfoVO l, int levelUpInfo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertLevelOne");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, levelUpInfo);
			//pstmt.setString(2, reqAhnAttachmentVO.getFilePath());


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}*/

	/*public ArrayList<AhnApplyInfoVO> searchCheck(Connection con, int usingInfo) {
		ArrayList<AhnApplyInfoVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("searchCheck");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, usingInfo);

			rset = pstmt.executeQuery();

			list = new ArrayList<AhnApplyInfoVO>();

			System.out.println("controller list : " + list);

			while(rset.next()) {
				AhnApplyInfoVO u = new AhnApplyInfoVO();

				u.setPropSeq(rset.getInt("PROP_SEQ"));
				u.setRentSeq(rset.getInt("RENT_SEQ"));
				u.setUserSeq(rset.getInt("USER_SEQ"));
				u.setPropNm(rset.getString("PROP_NM"));
				u.setPropPhone(rset.getString("PROP_PHONE"));
				u.setPropEmail(rset.getString("PROP_EMAIL"));
				u.setPropReqContent(rset.getString("PROP_REQ_CONTENT"));
				u.setPropDt(rset.getDate("PROP_DT"));
				u.setPropStatus(rset.getString("PROP_STATUS"));
				u.setUseStartDt(rset.getDate("USE_START_DT"));
				u.setUseEndDt(rset.getDate("USE_END_DT"));
				u.setUseStartTm(rset.getInt("USE_START_TM"));
				u.setUseEndTm(rset.getInt("USE_END_TM"));
				u.setPayAmount(rset.getInt("PAY_AMOUNT"));

				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}*/

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

				/*b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setHallNm(rset.getString("HALL_NM"));
				b.setHallSimIntro(rset.getString("HALL_SIM_INTRO"));
				b.setHallDetIntro(rset.getString("HALL_DET_INTRO"));
				b.setWebsite(rset.getString("WEBSITE"));
				b.setAddress(rset.getString("ADDRESS"));
				b.setHallRegisCerPath(rset.getString("HALL_REGIS_CER_PATH"));
				b.setPrefPlanTf(rset.getString("PERF_PLAN_TF").charAt(0));
				b.setRentEmail(rset.getString("RENT_EMAIL"));
				b.setRentMainTel(rset.getString("RENT_MAIN_TEL"));
				b.setRentPhone(rset.getString("RENT_PHONE"));
				b.setRentPhoneSub(rset.getString("RENT_PHONE_SUB"));
				b.setAvailStartTm(rset.getString("AVAIL_START_TM"));
				b.setAvailEndTm(rset.getString("AVAIL_END_TM"));
				b.setMinRsvTm(rset.getInt("MIN_RSV_TM"));
				b.setUseTimeUnit(rset.getString("USE_TIME_UNIT"));
				b.setRentEnrollStatus(rset.getString("RENT_ENROLL_STATUS"));
				b.setInspTf(rset.getString("INSP_TF").charAt(0));
				b.setCompNm(rset.getString("COMP_NM"));
				b.setCeoNm(rset.getString("CEO_NM"));
				b.setCorpNo(rset.getString("CORP_NO"));
				b.setCorpAddress(rset.getString("CORP_ADDRESS"));
				b.setSettleEmail(rset.getString("SETTLE_EMAIL"));
				b.setSettlePhone(rset.getString("SETTLE_PHONE"));
				b.setBankNm(rset.getString("BANK_NM"));
				b.setAccNo(rset.getString("ACC_NO"));
				b.setAccHolder(rset.getString("ACC_HOLDER"));
				b.setRentEnrollDt(rset.getDate("RENT_ENROLL_DT"));*/

				/*b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropPhone(rset.getString("PROP_PHONE"));
				b.setPropEmail(rset.getString("PROP_EMAIL"));
				b.setPropReqContent(rset.getString("PROP_REQ_CONTENT"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				b.setUseStartTm(rset.getInt("USE_START_TM"));
				b.setUseEndTm(rset.getInt("USE_END_TM"));
				b.setPayAmount(rset.getInt("PAY_AMOUNT"));*/

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


			/*pstmt.setInt(1, usingInfo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);*/

			pstmt.setInt(1, usingInfo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<AhnUsingInfoVO>();

			while(rset.next()) {
				AhnUsingInfoVO b = new AhnUsingInfoVO();

				/*b.setPropSeq(rset.getInt("PROP_SEQ"));
				b.setRentSeq(rset.getInt("RENT_SEQ"));
				b.setUserSeq(rset.getInt("USER_SEQ"));
				b.setPropNm(rset.getString("PROP_NM"));
				b.setPropPhone(rset.getString("PROP_PHONE"));
				b.setPropEmail(rset.getString("PROP_EMAIL"));
				b.setPropReqContent(rset.getString("PROP_REQ_CONTENT"));
				b.setPropDt(rset.getDate("PROP_DT"));
				b.setPropStatus(rset.getString("PROP_STATUS"));
				b.setUseStartDt(rset.getDate("USE_START_DT"));
				b.setUseEndDt(rset.getDate("USE_END_DT"));
				b.setUseStartTm(rset.getInt("USE_START_TM"));
				b.setUseEndTm(rset.getInt("USE_END_TM"));
				b.setPayAmount(rset.getInt("PAY_AMOUNT"));*/

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

	/*public int selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int userSeq = 0;

		String query = prop.getProperty("selectCurrval");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()) {
				userSeq = rset.getInt("currval");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}


		return userSeq;
	}*/

	public int insertAttachment(Connection con, ArrayList<AhnAttachmentVO> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertAttachment");



			try {
				for(int i = 0; i < fileList.size(); i++) {
				System.out.println("fileList.get(i):::"+fileList.get(i));
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, fileList.get(i).getChangeNm());
					pstmt.setString(2, fileList.get(i).getFilePath());
					pstmt.setString(3, fileList.get(i).getOriginNm());
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

					/*b.setPropSeq(rset.getInt("PROP_SEQ"));
					b.setRentSeq(rset.getInt("RENT_SEQ"));
					b.setUserSeq(rset.getInt("USER_SEQ"));
					b.setPropNm(rset.getString("PROP_NM"));
					b.setPropPhone(rset.getString("PROP_PHONE"));
					b.setPropEmail(rset.getString("PROP_EMAIL"));
					b.setPropReqContent(rset.getString("PROP_REQ_CONTENT"));
					b.setPropDt(rset.getDate("PROP_DT"));
					b.setPropStatus(rset.getString("PROP_STATUS"));
					b.setUseStartDt(rset.getDate("USE_START_DT"));
					b.setUseEndDt(rset.getDate("USE_END_DT"));
					b.setUseStartTm(rset.getInt("USE_START_TM"));
					b.setUseEndTm(rset.getInt("USE_END_TM"));
					b.setPayAmount(rset.getInt("PAY_AMOUNT"));*/

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

	public ArrayList<AhnUsingInfoVO> searchUsingDetail1(Connection con, int userInfo, int rentSeq, String hallNm,
			Date useStart, Date useEnd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;

		String query = prop.getProperty("searchUsingDetail1");

		try {
			pstmt = con.prepareStatement(query);


			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);

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

	public ArrayList<AhnUsingInfoVO> searchUsingDetail2(Connection con, int userInfo, String hallNm, Date useStart,
			Date useEnd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;

		String query = prop.getProperty("searchUsingDetail2");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, userInfo);
			pstmt.setString(2, hallNm);
			pstmt.setDate(3, useStart);
			pstmt.setDate(4, useEnd);

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

	public ArrayList<AhnUsingInfoVO> searchUsingDetail3(Connection con, int userInfo, int rentSeq, Date useStart,
			Date useEnd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;

		String query = prop.getProperty("searchUsingDetail3");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setDate(3, useStart);
			pstmt.setDate(4, useEnd);

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

	public ArrayList<AhnUsingInfoVO> searchUsingDetail4(Connection con, int userInfo, int rentSeq, String hallNm) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;

		String query = prop.getProperty("searchUsingDetail4");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);
			pstmt.setString(3, hallNm);

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

	public ArrayList<AhnUsingInfoVO> searchUsingDetail5(Connection con, int userInfo, int rentSeq) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;

		String query = prop.getProperty("searchUsingDetail5");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, userInfo);
			pstmt.setInt(2, rentSeq);

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

	public ArrayList<AhnUsingInfoVO> searchUsingDetail6(Connection con, int userInfo, String hallNm) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;

		String query = prop.getProperty("searchUsingDetail6");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, userInfo);
			pstmt.setString(2, hallNm);

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

	public ArrayList<AhnUsingInfoVO> searchUsingDetail7(Connection con, int userInfo, Date useStart, Date useEnd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;

		String query = prop.getProperty("searchUsingDetail7");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, userInfo);
			pstmt.setDate(2, useStart);
			pstmt.setDate(3, useEnd);

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

	public ArrayList<AhnUsingInfoVO> searchUsingDetail8(Connection con, int userInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AhnUsingInfoVO> list = null;

		String query = prop.getProperty("searchUsingDetail8");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, userInfo);

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
	}













	/*public AhnUsingInfoVO searchCheck(Connection con, int usingInfo) {
		AhnUsingInfoVO responseUserVO = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("searchCheck");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, usingInfo);

			rset = pstmt.executeQuery();


			if(rset.next()) {

				responseUserVO = new AhnUsingInfoVO();

				responseUserVO.setPropSeq(rset.getInt("PROP_SEQ"));
				responseUserVO.setRentSeq(rset.getInt("RENT_SEQ"));
				responseUserVO.setUserSeq(rset.getInt("USER_SEQ"));
				responseUserVO.setPropNm(rset.getString("PROP_NM"));
				responseUserVO.setPropPhone(rset.getString("PROP_PHONE"));
				responseUserVO.setPropEmail(rset.getString("PROP_EMAIL"));
				responseUserVO.setPropReqContent(rset.getString("PROP_REQ_CONTENT"));
				responseUserVO.setPropDt(rset.getDate("PROP_DT"));
				responseUserVO.setPropStatus(rset.getString("PROP_STATUS"));
				responseUserVO.setUseStartDt(rset.getDate("USE_START_DT"));
				responseUserVO.setUseEndDt(rset.getDate("USE_END_DT"));
				responseUserVO.setUseStartTm(rset.getInt("USE_START_TM"));
				responseUserVO.setUseEndTm(rset.getInt("USE_END_TM"));
				responseUserVO.setPayAmount(rset.getInt("PAY_AMOUNT"));


			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return responseUserVO;
	}*/




	/*public AhnUsingInfoVO searchCheck(Connection con, AhnUsingInfoVO reqAhnUsingInfoVO) {
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;

		String query = prop.getProperty("searchCheck");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqAhnUsingInfoVO.getPropNm());

			rset = pstmt.executeQuery();

			int rentSeq;
			String propNm;
			String propEmail;
			String useStartDt;

			if(rset.next()) {
				propNm = rset.getString("PROP_NM");
				propEmail = rset.getString("PROP_EMAIL");
				useStartDt = rset.getString("USE_START_DT");
			}

			if(reqAhnUsingInfoVO.getPropNm().equals(propNm) && reqAhnUsingInfoVO.getPropEmail().equals(propEmail)
						&& reqAhnUsingInfoVO.getPropNm().equals(useStartDt)) {


			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/



