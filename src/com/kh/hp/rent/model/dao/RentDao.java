package com.kh.hp.rent.model.dao;

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

import com.kh.hp.myPage.model.dao.MyPageDao_mh;
import com.kh.hp.rent.model.vo.AttachmentVO;
import com.kh.hp.rent.model.vo.CautionsVO;
import com.kh.hp.rent.model.vo.DetFacAndRentDetFacVO;
import com.kh.hp.rent.model.vo.DetFacVO;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RefundTypeVO;
import com.kh.hp.rent.model.vo.RentBasicVO;
import com.kh.hp.rent.model.vo.RentCloseVO;
import com.kh.hp.rent.model.vo.RentDetFacVO;
import com.kh.hp.rent.model.vo.RentDetVO;
import com.kh.hp.rent.model.vo.RentImgVO;
import com.kh.hp.rent.model.vo.RentListVO;
import com.kh.hp.rent.model.vo.RentPropVO;
import com.kh.hp.rent.model.vo.RentRefundTypeVO;

public class RentDao {

	private Properties prop = new Properties();

	public RentDao() {
		String fileName = MyPageDao_mh.class.getResource("/sql/rent/rent-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 세부 시설 정보 가져오기
	 * @param con
	 * @return
	 */
	public ArrayList<DetFacVO> selectDetFacAll(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<DetFacVO> detFacVOList = null;

		String query = prop.getProperty("selectDetFacAll");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			detFacVOList = new ArrayList<DetFacVO>();

			while(rset.next()) {
				DetFacVO detFacVO = new DetFacVO();

				detFacVO.setDetFacSeq(rset.getInt("DET_FAC_SEQ"));
				detFacVO.setDetFacNm(rset.getString("DET_FAC_NM"));
				detFacVO.setDetFacImgPath(rset.getString("DET_FAC_IMG_PATH"));

				detFacVOList.add(detFacVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return detFacVOList;
	}

	public ArrayList<RefundTypeVO> selectRefunctTypeAll(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<RefundTypeVO> refundTypeVOList = null;

		String query = prop.getProperty("selectRefunctTypeAll");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			refundTypeVOList = new ArrayList<RefundTypeVO>();

			while(rset.next()) {
				RefundTypeVO refundTypeVO = new RefundTypeVO();
				refundTypeVO.setRefundSeq(rset.getInt("REFUND_SEQ"));
				refundTypeVO.setRefundType(rset.getInt("REFUND_TYPE"));
				refundTypeVO.setDtCd(rset.getInt("DT_CD"));
				refundTypeVO.setRefundDeductPer(rset.getInt("REFUND_DEDUCT_PER"));
				refundTypeVOList.add(refundTypeVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return refundTypeVOList;
	}

	/**
	 * 대관 등록 basic 삽입
	 * @param requestRentBasicVO
	 * @return
	 */
	public int insertRentBasic(Connection con, RentBasicVO requestRentBasicVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertRentBasic");
//		insertRentBasic=INSERT INTO RENT_BASIC VALUES(?, ?, ?, ?, ?, ?, ?, DEFAULT, DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT)
//		INSERT INTO RENT_BASIC VALUES('02-521-1111', '010-1111-1111', '010-1111-1112', '00:00:00', '23:59:59', '1', '시간', '검수', DEFAULT, '회사이름1', 'CEO 이름1', '111-11-11111', '서울시 서초구 방배3동 아파트 1동 1001호', '정산용이메일1@email.com', '010-1112-1111', '국민', '1234-1234-1234', '예금주1', DEFAULT);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestRentBasicVO.getUserSeq());
			pstmt.setString(2, requestRentBasicVO.getHallNm());
			pstmt.setString(3, requestRentBasicVO.getHallSimIntro());
			pstmt.setString(4, requestRentBasicVO.getHallDetIntro());
			pstmt.setString(5, requestRentBasicVO.getWebsite());
			pstmt.setString(6, requestRentBasicVO.getAddress());
			pstmt.setString(7, "HALL_REGIS_CER_PATH"); // 공연장 등록증 경로
			pstmt.setString(8, requestRentBasicVO.getPerfPlanTf()+"");
			pstmt.setString(9, requestRentBasicVO.getRentEmail());
			pstmt.setString(10, requestRentBasicVO.getRentMainTel());
			pstmt.setString(11, requestRentBasicVO.getRentPhone());
			pstmt.setString(12, requestRentBasicVO.getRentPhoneSub());
			pstmt.setString(13, requestRentBasicVO.getAvailStartTm());
			pstmt.setString(14, requestRentBasicVO.getAvailEndTm());
			pstmt.setInt(15, requestRentBasicVO.getMinRsvTm());
			pstmt.setString(16, "시간");	// 사용 시간 단위
			pstmt.setString(17, requestRentBasicVO.getCompNm());
			pstmt.setString(18, requestRentBasicVO.getCeoNm());
			pstmt.setString(19, requestRentBasicVO.getCorpNo());
			pstmt.setString(20, requestRentBasicVO.getCorpAddress());
			pstmt.setString(21, requestRentBasicVO.getSettleEmail());
			pstmt.setString(22, requestRentBasicVO.getSettlePhone());
			pstmt.setString(23, requestRentBasicVO.getBankNm());
			pstmt.setString(24, requestRentBasicVO.getAccNo());
			pstmt.setString(25, requestRentBasicVO.getAccHolder());

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
	 * RendSeq 의 CURRVAL 가져오기
	 * @param con
	 * @return
	 */
	public int selectRendSeq(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		int currval = 0;

		String query = prop.getProperty("selectRentSeqCurrval");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				currval = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currval;
	}

	/**
	 * FAC_INFO 테이블 정보 삽입
	 * @param con
	 * @param facInfoVO
	 * @param rentSeq
	 * @return
	 */
	public int insertfacInfo(Connection con, FacInfoVO facInfoVO, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertfacInfo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);
			pstmt.setInt(2, facInfoVO.getFacInfoNo());
			pstmt.setString(3, facInfoVO.getFacInfoContent());

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
	 * RENT_DET 테이블 정보 삽입
	 * @param con
	 * @param rentDetVO
	 * @param rentSeq
	 * @return
	 */
	public int insertRentDet(Connection con, RentDetVO rentDetVO, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertRentDet");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);
			pstmt.setString(2, rentDetVO.getDetAddress());
			pstmt.setInt(3, rentDetVO.getMaxHeadCount());
			pstmt.setInt(4, 500000);
			/*pstmt.setInt(4, rentDetVO.getRentPrice());*/

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
	 * CAUTIONS 테이블 정보 삽입
	 * @param con
	 * @param cautionsVO
	 * @param rentSeq
	 * @return
	 */
	public int insertCautions(Connection con, CautionsVO cautionsVO, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertCautions");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);
			pstmt.setInt(2, cautionsVO.getCautionNo());
			pstmt.setString(3, cautionsVO.getCautionContent());

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
	 * RENT_DET_FAC 테이블 정보 삽입
	 * @param con
	 * @param rentDetFacVO
	 * @param rentSeq
	 * @return
	 */
	public int insertRentDetFac(Connection con, RentDetFacVO rentDetFacVO, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertRentDetFac");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);
			pstmt.setInt(2, rentDetFacVO.getDetFacSeq());

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
	 * RENT_IMG 테이블 정보 삽입
	 * @param con
	 * @param rentDetFacVO
	 * @param rentSeq
	 * @return
	 */
	public int insertrentImg(Connection con, RentImgVO rentDetFacVO, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertrentImg");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);
			pstmt.setInt(2, rentDetFacVO.getImgType());
			pstmt.setString(3, rentDetFacVO.getOriginNm());
			pstmt.setString(4, rentDetFacVO.getChangeNm());
			pstmt.setString(5, rentDetFacVO.getFilePath());
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
	 * ATTACHMENT 테이블 정보 삽입
	 * @param con
	 * @param attachmentVO
	 * @param rentSeq
	 * @return
	 */
	public int insertAttachment(Connection con, AttachmentVO attachmentVO, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertAttachment");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, attachmentVO.getOriginNm());
			pstmt.setString(2, attachmentVO.getChangeNm());
			pstmt.setString(3, attachmentVO.getFilePath());
			pstmt.setInt(4, attachmentVO.getFileType());
			pstmt.setInt(5, rentSeq);
			pstmt.setInt(6, attachmentVO.getSubType());

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
	 * RENT_CLOSE 테이블 정보 삽입
	 * @param con
	 * @param requestRentCloseVO
	 * @param rentSeq
	 * @return
	 */
	public int insertRentClose(Connection con, RentCloseVO requestRentCloseVO, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertRentClose");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestRentCloseVO.getRegCloseCd());
			pstmt.setString(2, requestRentCloseVO.getCusCloseNm());
			pstmt.setDate(3, requestRentCloseVO.getCusCloseStart());
			pstmt.setDate(4, requestRentCloseVO.getCusCloseEnd());
			pstmt.setString(5, "");
			pstmt.setString(6, "");
			pstmt.setString(7, "");
			pstmt.setInt(8, rentSeq);

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
	 * RENT_REFUND_TYPE 테이블 정보 삽입
	 * @param con
	 * @param requestRentRefundTypeVO
	 * @param rentSeq
	 * @return
	 */
	public int insertRentRefundType(Connection con, RentRefundTypeVO requestRentRefundTypeVO, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertRentRefundType");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestRentRefundTypeVO.getRefundSeq());
			pstmt.setInt(2, rentSeq);

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
	 * 대관 정보 리스트를 위한 개수 가져오기
	 * @param con
	 * @return
	 */
	public int selectCountRentList(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("selectCountRentList");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}

	/**
	 * 대관 정보 리스트 가져오기
	 * @param con
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public ArrayList<RentListVO> selectRentList(Connection con, int currentPage, int limit) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentListVO> RentListVOList = null;

		String query = prop.getProperty("selectRentList");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			System.out.println("Start : " + startRow + "//// End : " + endRow);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);


			rset = pstmt.executeQuery();

			RentListVOList = new ArrayList<RentListVO>();
			while(rset.next()) {
				RentListVO rentListVO = new RentListVO();
				rentListVO.setSeq(rset.getInt("RANKING"));
				rentListVO.setRentSeq(rset.getInt("RENT_SEQ"));
				rentListVO.setHallNm(rset.getString("HALL_NM"));
				rentListVO.setAddress(rset.getString("ADDRESS"));
				rentListVO.setRentEnrollDt(rset.getDate("RENT_ENROLL_DT"));
				rentListVO.setRentPrice(rset.getInt("RENT_PRICE"));
				rentListVO.setOriginNm(rset.getString("ORIGIN_NM"));
				rentListVO.setChangeNm(rset.getString("CHANGE_NM"));
				rentListVO.setFilePath(rset.getString("FILE_PATH"));

				RentListVOList.add(rentListVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return RentListVOList;
	}

	/**
	 * rentBasic 정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public RentBasicVO selectRentBasicOne(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RentBasicVO rentBasicVO = null;

		String query = prop.getProperty("selectRentBasicOne");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();
			if(rset.next()) {
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
	 * 주의사항 정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<CautionsVO> selectRentCautionsList(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CautionsVO> CautionsVOList = null;

		String query = prop.getProperty("selectRentCautionsList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();

			CautionsVOList = new ArrayList<CautionsVO>();
			while(rset.next()) {
				CautionsVO cautionsVO = new CautionsVO();
				cautionsVO.setCautionSeq(rset.getInt("CAUTION_SEQ"));
				cautionsVO.setCautionNo(rset.getInt("CAUTION_NO"));
				cautionsVO.setCautionContent(rset.getString("CAUTION_CONTENT"));
				cautionsVO.setRentSeq(rentSeq);
				CautionsVOList.add(cautionsVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return CautionsVOList;
	}

	/**
	 * 시설안내 정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<FacInfoVO> selectRentFacInfoList(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FacInfoVO> facInfoVOList = null;

		String query = prop.getProperty("selectRentFacInfoList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();

			facInfoVOList = new ArrayList<FacInfoVO>();
			while(rset.next()) {
				FacInfoVO facInfoVO = new FacInfoVO();

				facInfoVO.setFacSeq(rset.getInt("FAC_SEQ"));
				facInfoVO.setFacInfoNo(rset.getInt("FAC_INFO_NO"));
				facInfoVO.setFacInfoContent(rset.getString("FAC_INFO_CONTENT"));
				facInfoVO.setRentSeq(rset.getInt("RENT_SEQ"));

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
	 * 이미지 정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<RentImgVO> selectRentImg(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentImgVO> rentImgVOList = null;

		String query = prop.getProperty("selectRentImg");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();

			rentImgVOList = new ArrayList<RentImgVO>();
			while(rset.next()) {
				RentImgVO rentImgVO = new RentImgVO();
				rentImgVO.setImgSeq(rset.getInt("IMG_SEQ"));
				rentImgVO.setRentSeq(rset.getInt("RENT_SEQ"));
				rentImgVO.setImgType(rset.getInt("IMG_TYPE"));
				rentImgVO.setOriginNm(rset.getString("ORIGIN_NM"));
				rentImgVO.setChangeNm(rset.getString("CHANGE_NM"));
				rentImgVO.setFilePath(rset.getString("FILE_PATH"));
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

	/**
	 * 대관 상세정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<RentDetVO> selectRentDet(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentDetVO> rentDetVOList = null;

		String query = prop.getProperty("selectRentDet");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();

			rentDetVOList = new ArrayList<RentDetVO>();
			while(rset.next()) {
				RentDetVO rentDetVO = new RentDetVO();
				rentDetVO.setRentDetSeq(rset.getInt("RENT_DET_SEQ"));
				rentDetVO.setRentSeq(rset.getInt("RENT_SEQ"));
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
	 * 휴무관련 정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<RentCloseVO> selectRentCloseList(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentCloseVO> rentCloseList = null;

		String query = prop.getProperty("selectRentCloseList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();

			rentCloseList = new ArrayList<RentCloseVO>();
			while(rset.next()) {
				RentCloseVO rentCloseVO = new RentCloseVO();
				rentCloseVO.setRentCloseSeq(rset.getInt("RENT_CLOSE_SEQ"));
				rentCloseVO.setRegCloseCd(rset.getInt("REG_CLOSE_CD"));
				rentCloseVO.setCusCloseNm(rset.getString("CUS_CLOSE_NM"));
				rentCloseVO.setCusCloseStart(rset.getDate("CUS_CLOSE_START"));
				rentCloseVO.setCusCloseEnd(rset.getDate("CUS_CLOSE_END"));
				rentCloseVO.setCusCloseWeekOkDay(rset.getString("CUS_CLOSE_WEEK_OK_DAY"));
				rentCloseVO.setRegCloseWeekOfDay(rset.getString("REG_CLOSE_WEEK_OF_DAY"));
				rentCloseVO.setRegCloseDt(rset.getString("REG_CLOSE_DT"));
				rentCloseVO.setRentSeq(rset.getInt("RENT_SEQ"));
				rentCloseVO.setRegCloseNm(rset.getString("REG_CLOSE_NM"));

				rentCloseList.add(rentCloseVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return rentCloseList;

	}

	/**
	 * 환불타입 관련 정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<RentRefundTypeVO> selectRentRefundType(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentRefundTypeVO> rentRefundTypeVOList = null;

		String query = prop.getProperty("selectRentRefundType");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();

			rentRefundTypeVOList = new ArrayList<RentRefundTypeVO>();
			while(rset.next()) {
				RentRefundTypeVO rentRefundTypeVO = new RentRefundTypeVO();
				rentRefundTypeVO.setRefundSeq(rset.getInt("REFUND_SEQ"));
				rentRefundTypeVO.setRentRefundTypeSeq(rset.getInt("RENT_REFUND_TYPE_SEQ"));
				rentRefundTypeVO.setRentSeq(rset.getInt("RENT_SEQ"));
				rentRefundTypeVO.setDtCd(rset.getInt("DT_CD"));
				rentRefundTypeVO.setRefundDeductPer(rset.getInt("REFUND_DEDUCT_PER"));

				rentRefundTypeVOList.add(rentRefundTypeVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return rentRefundTypeVOList;
	}

	/**
	 * 예약 관련 정보 가져오기
	 * @param con
	 * @param rentSeq
	 * @return
	 */
	public ArrayList<RentPropVO> selectRentProp(Connection con, int rentSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentPropVO> rentPropVOList = null;

		String query = prop.getProperty("selectRentProp");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();
			rentPropVOList = new ArrayList<RentPropVO>();

			while(rset.next()) {
				RentPropVO rentPropVO = new RentPropVO();
				rentPropVO.setUseStartDt(rset.getDate("USE_START_DT"));
				rentPropVO.setUseEndDt(rset.getDate("USE_END_DT"));
				rentPropVO.setUseStartTm(rset.getInt("USE_START_TM"));
				rentPropVO.setUseEndTm(rset.getInt("USE_END_TM"));
				rentPropVO.setDiffDate(rset.getInt("DIFF_DATE"));
				System.out.println("rentPropVO:::" + rentPropVO);
				rentPropVOList.add(rentPropVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return rentPropVOList;
	}

	public ArrayList<DetFacAndRentDetFacVO> selectRentDetFacList(Connection con, int requestRentSeq) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DetFacAndRentDetFacVO> rentDetFacVOList = null;

		String query = prop.getProperty("selectRentDetFacList");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestRentSeq);

			rset = pstmt.executeQuery();
			rentDetFacVOList = new ArrayList<DetFacAndRentDetFacVO>();

			while(rset.next()) {

				DetFacAndRentDetFacVO rentDetFacVO = new DetFacAndRentDetFacVO();
				rentDetFacVO.setRentDetFacSeq(rset.getInt("RENT_DET_FAC_SEQ"));
				rentDetFacVO.setRentSeq(rset.getInt("RENT_SEQ"));
				rentDetFacVO.setDetFacSeq(rset.getInt("DET_FAC_SEQ"));
				rentDetFacVO.setDetFacNm(rset.getString("DET_FAC_NM"));
				rentDetFacVO.setDetFacImgPath(rset.getString("DET_FAC_IMG_PATH"));

				rentDetFacVOList.add(rentDetFacVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return rentDetFacVOList;
	}

}
