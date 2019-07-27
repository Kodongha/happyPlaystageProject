package com.kh.hp.myPage.model.service;


import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.kh.hp.myPage.model.dao.AhnMyPageDao;
import com.kh.hp.myPage.model.vo.AhnApplyInfoVO;
import com.kh.hp.myPage.model.vo.AhnAttachmentVO;
import com.kh.hp.myPage.model.vo.AhnLevelupInfoVO;
import com.kh.hp.myPage.model.vo.AhnLevelupVO;
import com.kh.hp.myPage.model.vo.AhnMyPageVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;

import static com.kh.hp.common.JDBCTemplate.*;

public class AhnMyPageService {
	//로그인된 유저의 등업신청정보 가져오는 서비스 메소드
	public AhnLevelupVO selectOne(int userSeq) {
		Connection con = getConnection();
		AhnLevelupVO responseUserVO = new AhnMyPageDao().selectOne(con, userSeq);
		close(con);
		
		System.out.println("service responseUserVO : " + responseUserVO);
		return responseUserVO;
	}

	/*public AhnLevelupVO insertLevelOne(int levelUpInfo) {
		Connection con = getConnection();
		AhnLevelupVO responseUserVO = new AhnMyPageDao().insertLevelOne(con, levelUpInfo);
		close(con);
		
		return responseUserVO;
	}*/
	
	/*public int insertLevelOne(AhnLevelupInfoVO l, int levelUpInfo) {
		Connection con = getConnection();
		
		int result = new AhnMyPageDao().insertLevelOne(con, l, levelUpInfo);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}*/
	
	
	
	
	
	
	
	
	
	
	
	

/*	public ArrayList<AhnApplyInfoVO> searchCheck(int usingInfo) {

		Connection con = getConnection();
		
		ArrayList<AhnApplyInfoVO> list = new AhnMyPageDao().searchCheck(con, usingInfo);
		
		close(con);
		
		return list;
	}*/
	
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
	public int getListCount2(int userInfo, int rentSeq) {
		Connection con = getConnection();
		
		int listCount = new AhnMyPageDao().getListCount2(con, userInfo, rentSeq);
		
		System.out.println("Service listCount : " + listCount);
		
		close(con);
		
		return listCount;
	}
	
	//검색후 신청내역에 대한 서비스메소드
	public ArrayList<AhnApplyInfoVO> searchCheck(int userInfo, int rentSeq, int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<AhnApplyInfoVO> list = new AhnMyPageDao().searchCheck(con, userInfo, rentSeq, currentPage, limit);
		
		close(con);
		
		return list;
	}
	
	//검색후 사용내역 페이징카운트에 대한 서비스메소드
	public int getListCount3(int userInfo, int rentSeq) {
		Connection con = getConnection();
		
		int listCount = new AhnMyPageDao().getListCount3(con, userInfo, rentSeq);
		
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
		
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		
		return result;
	}
	
	//검색후 사용내역에 대한 서비스메소드
	public ArrayList<AhnUsingInfoVO> searchCheck(int userInfo, int rentSeq, String hallNm, Date useStart, Date useEnd, int currentPage, int limit) {
		Connection con = getConnection();
		System.out.println("service in!!");
		ArrayList<AhnUsingInfoVO> list = null;
		
		String rentSeq1 = String.valueOf(rentSeq);
		
		if(rentSeq1 != null && hallNm != null && useStart != null && useEnd != null) {
			System.out.println("ooooin1");
			list = new AhnMyPageDao().searchCheck1(con, userInfo, rentSeq, hallNm, useStart, useEnd, currentPage, limit);
		
		}else if(rentSeq1 == null && hallNm != null && useStart != null && useEnd != null) {
			System.out.println("ooooin2");
			list = new AhnMyPageDao().searchCheck2(con, userInfo, hallNm, useStart, useEnd, currentPage, limit);
			
		}else if(rentSeq1 != null && hallNm == null && useStart != null && useEnd != null) {
			System.out.println("ooooin3");
			list = new AhnMyPageDao().searchCheck3(con, userInfo, rentSeq, useStart, useEnd, currentPage, limit);
			
		}else if(rentSeq1 != null && hallNm != null && useStart == null && useEnd == null) {
			System.out.println("ooooin4");
			list = new AhnMyPageDao().searchCheck4(con, userInfo, rentSeq, hallNm, currentPage, limit);
			
		}else if(rentSeq1 != null && hallNm == null && useStart == null && useEnd == null) {
			System.out.println("ooooin5");
			list = new AhnMyPageDao().searchCheck5(con, userInfo, rentSeq, currentPage, limit);
			
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
		
	/*public ArrayList<AhnUsingInfoVO> searchCheck2(int userInfo, String hallNm, Date useStart, Date useEnd,
			int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageDao().searchCheck2(con, userInfo, hallNm, useStart, useEnd, currentPage, limit);
		
		close(con);
		
		return list;
	}*/
	
	/*public ArrayList<AhnUsingInfoVO> searchCheck3(int userInfo, int rentSeq, Date useStart, Date useEnd,
			int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageDao().searchCheck3(con, userInfo, rentSeq, useStart, useEnd, currentPage, limit);
		
		close(con);
		
		return list;
	}*/

	/*public ArrayList<AhnUsingInfoVO> searchCheck4(int userInfo, int rentSeq, String hallNm, int currentPage,
			int limit) {
		Connection con = getConnection();
		
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageDao().searchCheck4(con, userInfo, rentSeq, hallNm, currentPage, limit);
		
		close(con);
		
		return list;
	}*/

	/*public ArrayList<AhnUsingInfoVO> searchCheck5(int userInfo, int rentSeq, int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageDao().searchCheck5(con, userInfo, rentSeq, currentPage, limit);
		
		close(con);
		
		return list;
	}*/

	/*public ArrayList<AhnUsingInfoVO> searchCheck6(int userInfo, String hallNm, int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageDao().searchCheck6(con, userInfo, hallNm, currentPage, limit);
		
		close(con);
		
		return list;
	}*/

	/*public ArrayList<AhnUsingInfoVO> searchCheck7(int userInfo, Date useStart, Date useEnd, int currentPage,
			int limit) {
		Connection con = getConnection();
		
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageDao().searchCheck7(con, userInfo, useStart, useEnd, currentPage, limit);
		
		close(con);
		
		return list;
	}*/

	/*public ArrayList<AhnUsingInfoVO> searchCheck8(int userInfo, int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageDao().searchCheck8(con, userInfo, currentPage, limit);
		
		close(con);
		
		return list;
	}*/

	
	}

	
	/*public AhnUsingInfoVO searchCheck(int usingInfo) {
		Connection con = getConnection();
		AhnUsingInfoVO responseUserVO = new AhnMyPageDao().searchCheck(con, usingInfo);
		close(con);
		
		return responseUserVO;
	}*/

	/*public AhnUsingInfoVO updateUsingOne(int usingInfo) {
		Connection con = getConnection();
		AhnUsingInfoVO responseUserVO = new AhnMyPageDao().updateUsingOne(con, usingInfo);
		close(con);
		
		return responseUserVO;
	}*/

	/*public AhnUsingInfoVO searchCheck(AhnUsingInfoVO reqAhnUsingInfoVO) {
		Connection con = getConnection();
		AhnUsingInfoVO responseUserVO = new AhnMyPageDao().searchCheck(con, reqAhnUsingInfoVO);
		close(con);
		
		return responseUserVO;
	}*/
	

