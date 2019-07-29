package com.kh.hp.modifyRentInfo.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.myPage.model.dao.MyPageDao_mh;
import com.kh.hp.rent.model.vo.AttachmentVO;
import com.kh.hp.rent.model.vo.CautionsVO;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RentBasicVO;
import com.kh.hp.rent.model.vo.RentDetVO;
import com.kh.hp.rent.model.vo.RentImgVO;

public class ModifyDao {

	private Properties prop = new Properties();

	public ModifyDao() {
		// TODO Auto-generated constructor stub
		String fileName = MyPageDao_mh.class.getResource("/sql/modifyRentInfo/modifyRentInfo-query.properties")
				.getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * rentBasic 테이블 정보 가져오기
	 *
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public RentBasicVO selectRentBasic(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RentBasicVO rentBasicVO = null;

		String query = prop.getProperty("selectRentBasic");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				rentBasicVO = new RentBasicVO();
				rentBasicVO.setRentSeq(rset.getInt("RENT_SEQ"));
				rentBasicVO.setHallNm(rset.getString("HALL_NM"));
				rentBasicVO.setHallSimIntro(rset.getString("HALL_SIM_INTRO"));
				rentBasicVO.setHallDetIntro(rset.getString("HALL_DET_INTRO"));
				rentBasicVO.setWebsite(rset.getString("WEBSITE"));
				rentBasicVO.setAddress(rset.getString("ADDRESS"));
				rentBasicVO.setAvailStartTm(rset.getString("AVAIL_START_TM"));
				rentBasicVO.setAvailEndTm(rset.getString("AVAIL_END_TM"));
				rentBasicVO.setCompNm(rset.getString("COMP_NM"));
				rentBasicVO.setCeoNm(rset.getString("CEO_NM"));
				rentBasicVO.setCorpNo(rset.getString("CORP_NO"));
				rentBasicVO.setCorpAddress(rset.getString("CORP_ADDRESS"));
				rentBasicVO.setRentEnrollDt(rset.getDate("RENT_ENROLL_DT"));
				rentBasicVO.setRentMainTel(rset.getString("RENT_MAIN_TEL"));
				rentBasicVO.setUseTimeUnit(rset.getString("USE_TIME_UNIT"));
				rentBasicVO.setMinRsvTm(rset.getInt("MIN_RSV_TM"));
				rentBasicVO.setPerfPlanTf(rset.getString("PERF_PLAN_TF").charAt(0));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return rentBasicVO;
	}

	/**
	 * facInfo 테이블 정보 가져오기
	 *
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<FacInfoVO> selectFacInfo(Connection con, int rentSeq) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FacInfoVO> facInfoVOList = null;

		String query = prop.getProperty("selectFaInfo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			facInfoVOList = new ArrayList<FacInfoVO>();

			rset = pstmt.executeQuery();

			while (rset.next()) {
				FacInfoVO facInfoVO = new FacInfoVO();
				facInfoVO.setRentSeq(rset.getInt("RENT_SEQ"));
				facInfoVO.setFacSeq(rset.getInt("FAC_SEQ"));
				facInfoVO.setFacInfoNo(rset.getInt("FAC_INFO_NO"));
				facInfoVO.setFacInfoContent(rset.getString("FAC_INFO_CONTENT"));

				facInfoVOList.add(facInfoVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return facInfoVOList;
	}

	/**
	 * caution 테이블 정보 가져오기
	 *
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<CautionsVO> selectCaution(Connection con, int rentSeq) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CautionsVO> cautionsVOList = null;

		String query = prop.getProperty("selectCaution");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			cautionsVOList = new ArrayList<CautionsVO>();

			rset = pstmt.executeQuery();

			while (rset.next()) {
				CautionsVO cautionsVO = new CautionsVO();
				cautionsVO.setRentSeq(rset.getInt("RENT_SEQ"));
				cautionsVO.setCautionSeq(rset.getInt("CAUTION_SEQ"));
				cautionsVO.setCautionNo(rset.getInt("CAUTION_NO"));
				cautionsVO.setCautionContent(rset.getString("CAUTION_CONTENT"));

				cautionsVOList.add(cautionsVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return cautionsVOList;
	}

	/**
	 * rent-det 테이블 정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<RentDetVO> selectRentDet(Connection con, int rentSeq) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentDetVO> rentDetVOList = null;

		String query = prop.getProperty("selectRentDet");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rentDetVOList = new ArrayList<RentDetVO>();

			rset = pstmt.executeQuery();

			while (rset.next()) {
				RentDetVO rentDetVO = new RentDetVO();
				rentDetVO.setRentSeq(rset.getInt("RENT_SEQ"));
				rentDetVO.setRentDetSeq(rset.getInt("RENT_DET_SEQ"));
				rentDetVO.setDetAddress(rset.getString("DET_ADDRESS"));
				rentDetVO.setMaxHeadCount(rset.getInt("MAX_HEAD_COUNT"));
				rentDetVO.setRentPrice(rset.getInt("RENT_PRICE"));

				rentDetVOList.add(rentDetVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return rentDetVOList;
	}

	/**
	 * Attachment 테이블 정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<AttachmentVO> selectAttachment(Connection con, int rentSeq) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AttachmentVO> attachmentVOList = null;

		String query = prop.getProperty("selectAttachment");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			attachmentVOList = new ArrayList<AttachmentVO>();

			rset = pstmt.executeQuery();

			while (rset.next()) {
				AttachmentVO attachmentVO = new AttachmentVO();
				attachmentVO.setRentSeq(rset.getInt("RENT_SEQ"));
				attachmentVO.setAttchSeq(rset.getInt("ATTCH_SEQ"));
				attachmentVO.setOriginNm(rset.getString("ORIGIN_NM"));
				attachmentVO.setChangeNm(rset.getString("CHANGE_NM"));
				attachmentVO.setFilePath(rset.getString("FILE_PATH"));
				attachmentVO.setUploadDt(rset.getDate("UPLOAD_DT"));
				attachmentVO.setFileType(rset.getInt("FILE_TYPE"));
				attachmentVO.setPropSeq(rset.getInt("PROP_SEQ"));
				attachmentVO.setUserSeq(rset.getInt("USER_SEQ"));
				attachmentVO.setSubType(rset.getInt("SUB_TYPE"));

				attachmentVOList.add(attachmentVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return attachmentVOList;

	}

	/**
	 * RENT_IMG 테이블 정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<RentImgVO> selectRentImg(Connection con, int rentSeq) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentImgVO> rentImgVOList = null;

		String query = prop.getProperty("selectRentImg");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rentImgVOList = new ArrayList<RentImgVO>();

			rset = pstmt.executeQuery();

			while (rset.next()) {
				RentImgVO rentImgVO = new RentImgVO();
				rentImgVO.setRentSeq(rset.getInt("RENT_SEQ"));
				rentImgVO.setImgType(rset.getInt("IMG_TYPE"));
				rentImgVO.setFilePath(rset.getString("FILE_PATH"));
				rentImgVO.setImgSeq(rset.getInt("IMG_SEQ"));
				rentImgVO.setOriginNm(rset.getString("ORIGIN_NM"));
				rentImgVO.setChangeNm(rset.getString("CHANGE_NM"));
				rentImgVO.setUploadDt(rset.getDate("UPLOAD_DT"));

				rentImgVOList.add(rentImgVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return rentImgVOList;

	}

}
