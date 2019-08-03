package com.kh.hp.myPage.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.myPage.model.vo.MyPageUserVO;
import com.kh.hp.myPage.model.vo.RegistListVO;
import com.kh.hp.myPage.model.vo.RentPropAndAttachmentVO;
import com.kh.hp.myPage.model.vo.UserImgVO;

public class MyPageDao_mh {
	private Properties prop = new Properties();

	public MyPageDao_mh() {
		String fileName = MyPageDao_mh.class.getResource("/sql/myPage/myPage-query-mh.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 마이페이지 현재 접속자 정보 불러오기
	 * @param con
	 * @param userSeq
	 * @return
	 */
	public MyPageUserVO selectMyPageInfo(Connection con, int userSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MyPageUserVO myPageInfo = null;

		String query = prop.getProperty("selectOne");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				myPageInfo = new MyPageUserVO();
				myPageInfo.setUserEmail(rset.getString("USER_EMAIL"));
				myPageInfo.setUserPwd(rset.getString("USER_PWD"));
				myPageInfo.setUserNm(rset.getString("USER_NM"));
				myPageInfo.setUserNick(rset.getString("USER_NICK"));
				myPageInfo.setUserPhone(rset.getString("USER_PHONE"));
				myPageInfo.setUserGradeCd(rset.getInt("USER_GRADE_CD"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return myPageInfo;
	}


	/**
	 * 마이페이지 유저 정보 업데이트
	 * @param con
	 * @param myPageUserVO
	 * @return
	 */
	public int updateMyPageInfo(Connection con, MyPageUserVO myPageUserVO) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateMyPageInfo");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, myPageUserVO.getUserNick());
			pstmt.setString(2, myPageUserVO.getUserNm());
			pstmt.setString(3, myPageUserVO.getUserPhone());
			pstmt.setString(4, myPageUserVO.getUserPwd());
			pstmt.setInt(5, myPageUserVO.getUserSeq());

			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/** 업데이트 후 수정내역 insert
	 * @param con
	 * @param myPageUserVO
	 * @return
	 */
	public int insertUpdatedMyPageInfo(Connection con, MyPageUserVO myPageUserVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertUpdatedMyPageInfo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, myPageUserVO.getUserSeq());
/*			pstmt.setString(2, myPageUserVO.getUserPwd());*/
			pstmt.setString(2, myPageUserVO.getUserNm());
			pstmt.setString(3, myPageUserVO.getUserNick());
			pstmt.setString(4, myPageUserVO.getUserPhone());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/** 비밀번호 수정
	 * @param con
	 * @param myPageUserVO
	 * @param newPwd1
	 * @return
	 */
	public int updateUserPwd(Connection con, MyPageUserVO myPageUserVO, String newPwd1) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateUserPwd");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPwd1);
			pstmt.setInt(2, myPageUserVO.getUserSeq());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/** 비밀번호 수정내역 INSERT
	 * @param con
	 * @param myPageUserVO
	 * @param newPwd1
	 * @return
	 */
	public int insertUpdatedUserPwd(Connection con, MyPageUserVO myPageUserVO, String newPwd) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertUpdatedUserPwd");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, myPageUserVO.getUserSeq());
			pstmt.setString(2, newPwd);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}


		return result;
	}

	/** 회원탈퇴시 leaveTF 수정
	 * @param con
	 * @param userSeq
	 * @return
	 */
	public int updateLeaveTF(Connection con, int userSeq) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateLeaveTF");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 첨부파일 insert용 메소드
	 * @param con
	 * @param fileList
	 * @return
	 */
	public int insertProfile(Connection con, ArrayList<UserImgVO> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertUserImg");

			try {
				if(fileList != null) {
					pstmt = con.prepareStatement(query);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		return 0;
	}

	public ArrayList<RegistListVO> selectRegistList(Connection con, int userSeq) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RegistListVO> list = null;

		String query = prop.getProperty("selectRegistList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userSeq);

			rset = pstmt.executeQuery();
			list = new ArrayList<RegistListVO>();

			while(rset.next()) {
				RegistListVO registListVO = new RegistListVO();
				registListVO.setRentSeq(rset.getInt("RENT_SEQ"));
				registListVO.setHallNm(rset.getString("HALL_NM"));
				registListVO.setRentEnrollDt(rset.getDate("RENT_ENROLL_DT"));

				list.add(registListVO);
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

	public int delete1Rent(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		// String query = prop.getProperty("delete1Rent");

		return result;
	}

	/**
	 * 프로필 사진 유무 체크
	 * @param con
	 * @param userImgVO
	 * @return
	 */
	public int selectHaveProfile(Connection con, UserImgVO userImgVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("selectHaveProfile");

		try {

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userImgVO.getUserSeq());

			rset = pstmt.executeQuery();

			if(rset.next()){
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
	 * 프로필 사진 변경
	 * @param con
	 * @param userImgVO
	 * @return
	 */
	public int insertProfilePhoto(Connection con, UserImgVO userImgVO) {
		// TODO Auto-generated method stub



		return 0;
	}

	/**
	 * 신청자 리스트 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<RentPropAndAttachmentVO> getProposeUserList(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentPropAndAttachmentVO> proposeUserList = null;

		String query = prop.getProperty("getProposeUserList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();

			proposeUserList = new ArrayList<RentPropAndAttachmentVO>();
			while(rset.next()) {
				RentPropAndAttachmentVO rentPropAndAttachmentVO = new RentPropAndAttachmentVO();
				rentPropAndAttachmentVO.setPropSeq(rset.getInt("PROP_SEQ"));
				rentPropAndAttachmentVO.setRentSeq(rset.getInt("RENT_SEQ"));
				rentPropAndAttachmentVO.setUserSeq(rset.getInt("USER_SEQ"));
				rentPropAndAttachmentVO.setPropNm(rset.getString("PROP_NM"));
				rentPropAndAttachmentVO.setPropPhone(rset.getString("PROP_PHONE"));
				rentPropAndAttachmentVO.setPropEmail(rset.getString("PROP_EMAIL"));
				rentPropAndAttachmentVO.setPropReqContent(rset.getString("PROP_REQ_CONTENT"));
				rentPropAndAttachmentVO.setPropDt(rset.getDate("PROP_DT"));
				rentPropAndAttachmentVO.setPropStatus(rset.getString("PROP_STATUS"));
				rentPropAndAttachmentVO.setUseStartDt(rset.getDate("USE_START_DT"));
				rentPropAndAttachmentVO.setUseEndDt(rset.getDate("USE_END_DT"));
				rentPropAndAttachmentVO.setUseStartTm(rset.getInt("USE_START_TM"));
				rentPropAndAttachmentVO.setUseEndTm(rset.getInt("USE_END_TM"));
				rentPropAndAttachmentVO.setPayAmount(rset.getInt("PAY_AMOUNT"));
				rentPropAndAttachmentVO.setPropHeadCount(rset.getInt("PROP_HEAD_COUNT"));
				rentPropAndAttachmentVO.setAttchSeq(rset.getInt("ATTCH_SEQ"));
				rentPropAndAttachmentVO.setOriginNm(rset.getString("ORIGIN_NM"));
				rentPropAndAttachmentVO.setChangeNm(rset.getString("CHANGE_NM"));
				rentPropAndAttachmentVO.setFilePath(rset.getString("FILE_PATH"));

				proposeUserList.add(rentPropAndAttachmentVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return proposeUserList;
	}

	/**
	 * 신청 수락 버튼 클릭시 상태 변경
	 * @param con
	 * @param propSeq
	 * @return
	 */
	public int updatePropStatusConfirm(Connection con, int propSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updatePropStatusConfirm");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, propSeq);

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
	 * 수락버튼 클릭 시 로그 INSERT
	 * @param con
	 * @param propSeq
	 * @return
	 */
	public int insertPropStatusConfirm(Connection con, int propSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertPropStatusConfirm");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, propSeq);

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
	 * 거절버튼 클릭 시 상태 변경
	 * @param con
	 * @param propSeq
	 * @return
	 */
	public int updatePropStatusReject(Connection con, int propSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updatePropStatusReject");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, propSeq);

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
	 * 거절버튼 클릭 시 로그 INSERT
	 * @param con
	 * @param propSeq
	 * @return
	 */
	public int insertPropStatusReject(Connection con, int propSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertPropStatusReject");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, propSeq);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
}
