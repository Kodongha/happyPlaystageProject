package com.kh.hp.rent.model.dao;

import static com.kh.hp.common.JDBCTemplate.*;
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
import com.kh.hp.rent.model.vo.DetFacVO;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RefundTypeVO;
import com.kh.hp.rent.model.vo.RentBasicVO;
import com.kh.hp.rent.model.vo.RentCloseVO;
import com.kh.hp.rent.model.vo.RentDetFacVO;
import com.kh.hp.rent.model.vo.RentDetVO;
import com.kh.hp.rent.model.vo.RentImgVO;
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


}
