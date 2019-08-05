package com.kh.hp.myPage.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.commit;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.kh.hp.myPage.model.dao.AhnMyPageDao;
import com.kh.hp.myPage.model.vo.AhnApplyInfoVO;
import com.kh.hp.myPage.model.vo.AhnAttachmentVO;
import com.kh.hp.myPage.model.vo.AhnLevelupInfoVO;
import com.kh.hp.myPage.model.vo.AhnLevelupVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;
import com.kh.hp.myPage.model.vo.PaymentVO;
import com.kh.hp.rent.model.dao.RentDao;
import com.kh.hp.rent.model.vo.CautionsVO;
import com.kh.hp.rent.model.vo.FacInfoVO;
import com.kh.hp.rent.model.vo.RentBasicVO;
import com.kh.hp.rent.model.vo.RentCloseVO;
import com.kh.hp.rent.model.vo.RentDetVO;
import com.kh.hp.rent.model.vo.RentImgVO;
import com.kh.hp.rent.model.vo.RentPropVO;
import com.kh.hp.rent.model.vo.RentRefundTypeVO;

public class AhnMyPageService {
	//로그인된 유저의 등업신청정보 가져오는 서비스 메소드
	public AhnLevelupVO selectOne(int userSeq) {
		Connection con = getConnection();
		AhnLevelupVO responseUserVO = new AhnMyPageDao().selectOne(con, userSeq);
		close(con);

		System.out.println("service responseUserVO : " + responseUserVO);
		return responseUserVO;
	}

	//검색 전 신청내역 페이징카운트에 대한 서비스메소드
	public int getListCount(int usingInfo) {
		Connection con = getConnection();

		int listCount = new AhnMyPageDao().getListCount(con, usingInfo);

		close(con);

		return listCount;
	}

	//검색 전 전체신청내역에 대한 서비스메소드
	public ArrayList<AhnApplyInfoVO> selectList(int usingInfo, int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<AhnApplyInfoVO> list = new AhnMyPageDao().selectList(con, usingInfo, currentPage, limit);

		close(con);

		return list;
	}

	//검색 전 사용내역 페이징카운트에 대한 서비스메소드
	public int getListCount1(int usingInfo) {
		Connection con = getConnection();

		int listCount = new AhnMyPageDao().getListCount1(con, usingInfo);

		close(con);

		return listCount;
	}

	//검색 전 전체사용내역에 대한 서비스메소드
	public ArrayList<AhnUsingInfoVO> selectList1(int usingInfo, int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<AhnUsingInfoVO> list = new AhnMyPageDao().selectList1(con, usingInfo, currentPage, limit);

		close(con);

		return list;
	}

	//검색후 신청내역 페이징카운트에 대한 서비스메소드
	public int getListCount2(int userInfo, int rentSeq2) {
		Connection con = getConnection();

		int listCount = new AhnMyPageDao().getListCount2(con, userInfo, rentSeq2);

		System.out.println("Service listCount : " + listCount);

		close(con);

		return listCount;
	}

	//검색후 사용내역 페이징카운트에 대한 서비스메소드
	public int getListCount3(int userInfo, int rentSeq2) {
		Connection con = getConnection();

		int listCount = new AhnMyPageDao().getListCount3(con, userInfo, rentSeq2);

		System.out.println("Service listCount : " + listCount);

		close(con);

		return listCount;
	}


	public int insertImage(AhnLevelupInfoVO l, ArrayList<AhnAttachmentVO> fileList) {
		Connection con = getConnection();
		System.out.println("insertImage in!!!");
		int result = 0;

		int result1 = new AhnMyPageDao().insertImage(con, l);

		/*if(result1 > 0) {
			int userSeq = new AhnMyPageDao().selectCurrval(con);

			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setUserSeq(userSeq);
			}
		}*/

		int result2 = new AhnMyPageDao().insertAttachment(con, fileList);

		if(result2 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}

		return result;
	}

	//검색후 사용내역에 대한 서비스메소드
	public ArrayList<AhnUsingInfoVO> searchCheck(int userInfo, int rentSeq2, String hallNm, Date useStart, Date useEnd, int currentPage, int limit) {
		Connection con = getConnection();
		System.out.println("service in!!");
		ArrayList<AhnUsingInfoVO> list = null;

		String rentSeq1 = String.valueOf(rentSeq2);

		if(rentSeq1 != null && hallNm != null && useStart != null && useEnd != null) {
			System.out.println("ooooin1");
			list = new AhnMyPageDao().searchCheck1(con, userInfo, rentSeq2, hallNm, useStart, useEnd, currentPage, limit);

		}else if(rentSeq1 == null && hallNm != null && useStart != null && useEnd != null) {
			System.out.println("ooooin2");
			list = new AhnMyPageDao().searchCheck2(con, userInfo, hallNm, useStart, useEnd, currentPage, limit);

		}else if(rentSeq1 != null && hallNm == null && useStart != null && useEnd != null) {
			System.out.println("ooooin3");
			list = new AhnMyPageDao().searchCheck3(con, userInfo, rentSeq2, useStart, useEnd, currentPage, limit);

		}else if(rentSeq1 != null && hallNm != null && useStart == null && useEnd == null) {
			System.out.println("ooooin4");
			list = new AhnMyPageDao().searchCheck4(con, userInfo, rentSeq2, hallNm, currentPage, limit);

		}else if(rentSeq1 != null && hallNm == null && useStart == null && useEnd == null) {
			System.out.println("ooooin5");
			list = new AhnMyPageDao().searchCheck5(con, userInfo, rentSeq2, currentPage, limit);

		}else if(rentSeq1 == null && hallNm != null && useStart == null && useEnd == null) {
			System.out.println("ooooin6");
			list = new AhnMyPageDao().searchCheck6(con, userInfo, hallNm, currentPage, limit);

		}else if(rentSeq1 == null && hallNm == null && useStart != null && useEnd != null) {
			System.out.println("ooooin7");
			list = new AhnMyPageDao().searchCheck7(con, userInfo, useStart, useEnd, currentPage, limit);

		}else if(rentSeq1 == null && hallNm == null && useStart == null && useEnd == null) {
			System.out.println("ooooin8");
			list = new AhnMyPageDao().searchCheck8(con, userInfo, currentPage, limit);

		}

		close(con);

		System.out.println("service list : " + list);

		return list;
	}

	//검색후 신청내역에 대한 서비스메소드
	public ArrayList<AhnApplyInfoVO> searchApplyCheck(int userInfo, int rentSeq2, String hallNm, Date useStart,
			Date useEnd, int currentPage, int limit) {
		Connection con = getConnection();
		System.out.println("service in!!");
		ArrayList<AhnApplyInfoVO> list = null;

		String rentSeq1 = String.valueOf(rentSeq2);

		if(rentSeq1 != null && hallNm != null && useStart != null && useEnd != null) {
			System.out.println("ooooin1");
			list = new AhnMyPageDao().searchApplyCheck1(con, userInfo, rentSeq2, hallNm, useStart, useEnd, currentPage, limit);

		}else if(rentSeq1 == null && hallNm != null && useStart != null && useEnd != null) {
			System.out.println("ooooin2");
			list = new AhnMyPageDao().searchApplyCheck2(con, userInfo, hallNm, useStart, useEnd, currentPage, limit);

		}else if(rentSeq1 != null && hallNm == null && useStart != null && useEnd != null) {
			System.out.println("ooooin3");
			list = new AhnMyPageDao().searchApplyCheck3(con, userInfo, rentSeq2, useStart, useEnd, currentPage, limit);

		}else if(rentSeq1 != null && hallNm != null && useStart == null && useEnd == null) {
			System.out.println("ooooin4");
			list = new AhnMyPageDao().searchApplyCheck4(con, userInfo, rentSeq2, hallNm, currentPage, limit);

		}else if(rentSeq1 != null && hallNm == null && useStart == null && useEnd == null) {
			System.out.println("ooooin5");
			list = new AhnMyPageDao().searchApplyCheck5(con, userInfo, rentSeq2, currentPage, limit);

		}else if(rentSeq1 == null && hallNm != null && useStart == null && useEnd == null) {
			System.out.println("ooooin6");
			list = new AhnMyPageDao().searchApplyCheck6(con, userInfo, hallNm, currentPage, limit);

		}else if(rentSeq1 == null && hallNm == null && useStart != null && useEnd != null) {
			System.out.println("ooooin7");
			list = new AhnMyPageDao().searchApplyCheck7(con, userInfo, useStart, useEnd, currentPage, limit);

		}else if(rentSeq1 == null && hallNm == null && useStart == null && useEnd == null) {
			System.out.println("ooooin8");
			list = new AhnMyPageDao().searchApplyCheck8(con, userInfo, currentPage, limit);

		}

		close(con);

		System.out.println("service list : " + list);

		return list;
	}

	public static ArrayList<Object> selectRentOne(int rentSeq) {
		Connection con = getConnection();

		ArrayList<Object> rentInfos = new ArrayList<Object>();
		RentDao rentDao = new RentDao();

		// 대관 기본 정보
		RentBasicVO rentBasicVO = rentDao.selectRentBasicOne(con, rentSeq);
		System.out.println("rentBasicVO::" + rentBasicVO);

		// 주의사항 정보
		ArrayList<CautionsVO> cautionsVOList = rentDao.selectRentCautionsList(con, rentSeq);
		System.out.println(cautionsVOList);

		// 시설 안내 정보
		ArrayList<FacInfoVO> facInfoVOList = rentDao.selectRentFacInfoList(con, rentSeq);
		System.out.println(facInfoVOList);

		// 이미지 정보
		ArrayList<RentImgVO> rentImgVOList = rentDao.selectRentImg(con, rentSeq);
		System.out.println(rentImgVOList);

		// 상세 대관 정보
		ArrayList<RentDetVO> rentDetVOList = rentDao.selectRentDet(con, rentSeq);
		System.out.println(rentDetVOList);

		// 휴무 정보
		ArrayList<RentCloseVO> rentCloseVOList = rentDao.selectRentCloseList(con, rentSeq);
		System.out.println(rentCloseVOList);

		// 환불 정보
		ArrayList<RentRefundTypeVO> rentRefundTypeVOList = rentDao.selectRentRefundType(con, rentSeq);
		System.out.println(rentRefundTypeVOList);

		// 예약 정보
		ArrayList<RentPropVO> rentPropVOList = rentDao.selectRentProp(con, rentSeq);
		System.out.println(rentPropVOList);

		rentInfos.add(rentBasicVO);
		rentInfos.add(cautionsVOList);
		rentInfos.add(facInfoVOList);
		rentInfos.add(rentImgVOList);
		rentInfos.add(rentDetVOList);
		rentInfos.add(rentCloseVOList);
		rentInfos.add(rentRefundTypeVOList);
		rentInfos.add(rentPropVOList);

		close(con);

		return rentInfos;
	}

	public ArrayList<AhnUsingInfoVO> searchUsingDetail(int userInfo, int rentSeq, String hallNm, Date useStart,
			Date useEnd) {
		Connection con = getConnection();
		System.out.println("service in!!");
		ArrayList<AhnUsingInfoVO> list = null;

		String rentSeq1 = String.valueOf(rentSeq);

		list = new AhnMyPageDao().searchUsingDetail(con, userInfo, rentSeq, hallNm, useStart, useEnd);

		close(con);

		System.out.println("service list : " + list);

		return list;
	}

	public ArrayList<AhnApplyInfoVO> searchApplyDetail(int userInfo, int rentSeq, String hallNm, Date useStart,
			Date useEnd, String propStatus) {
		Connection con = getConnection();
		System.out.println("service in!!");
		ArrayList<AhnApplyInfoVO> list = null;

		String rentSeq1 = String.valueOf(rentSeq);

		list = new AhnMyPageDao().searchApplyDetail(con, userInfo, rentSeq, hallNm, useStart, useEnd, propStatus);

		return list;
	}

	public int payRefundInsert(int userInfo, int propSeq, int payAmount) {
		Connection con = getConnection();
		System.out.println("insertImage in!!!");
		int result = 0;

		int result1 = new AhnMyPageDao().payRefundInsert(con, userInfo, propSeq, payAmount);

		if(result1 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}

		return result;

	}

	public int applyInfoChangeInsert(int userInfo, int propSeq) {
		Connection con = getConnection();
		System.out.println("insertImage in!!!");
		int result = 0;

		int result1 = new AhnMyPageDao().applyChange(con, userInfo, propSeq);

		if(result1 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}

		return result;
	}

	/**
	 * 결제 검증
	 * @param paymentVO
	 */
	public boolean validatePayment(PaymentVO paymentVO) {
		// TODO Auto-generated method stub

		// access token 받아오기
		String accessToken = new AhnMyPageDao().getAccessToken();
		System.out.println("accessToken::::" + accessToken);


		boolean paymentResult = new AhnMyPageDao().validatePayment(paymentVO, accessToken);



		return paymentResult;
	}

	/**
	 * DB 상태값 변경
	 * @param propSeq
	 * @return
	 */
	public int changeStatus(PaymentVO paymentVO) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		int updateResult = new AhnMyPageDao().updateStatus(con, paymentVO.getPropSeq());
		int insertResult = 0;
		if(updateResult > 0) {
			insertResult = new AhnMyPageDao().insertStatus(con, paymentVO);
		}

		if(insertResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return insertResult;
	}



}