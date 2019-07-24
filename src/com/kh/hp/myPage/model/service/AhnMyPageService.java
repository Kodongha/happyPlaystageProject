package com.kh.hp.myPage.model.service;


import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.myPage.model.dao.AhnMyPageDao;
import com.kh.hp.myPage.model.vo.AhnApplyInfoVO;
import com.kh.hp.myPage.model.vo.AhnAttachmentVO;
import com.kh.hp.myPage.model.vo.AhnLevelupVO;
import com.kh.hp.myPage.model.vo.AhnMyPageVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;

import static com.kh.hp.common.JDBCTemplate.*;

public class AhnMyPageService {

	public AhnMyPageVO selectOne(int userSeq) {
		Connection con = getConnection();
		AhnMyPageVO responseUserVO = new AhnMyPageDao().selectOne(con, userSeq);
		close(con);
		
		return responseUserVO;
	}

	/*public AhnLevelupVO insertLevelOne(int levelUpInfo) {
		Connection con = getConnection();
		AhnLevelupVO responseUserVO = new AhnMyPageDao().insertLevelOne(con, levelUpInfo);
		close(con);
		
		return responseUserVO;
	}*/
	
	public AhnAttachmentVO insertLevelOne(int levelUpInfo, AhnAttachmentVO reqAhnAttachmentVO) {
		Connection con = getConnection();
		AhnAttachmentVO responseUserVO = new AhnMyPageDao().insertLevelOne(con, levelUpInfo, reqAhnAttachmentVO);
		close(con);
		
		return responseUserVO;
	}
	
	
	
	
	
	
	
	
	
	
	
	

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
	
}
