package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.*;


import java.sql.Connection;

import java.util.ArrayList;


import com.kh.hp.admin.model.dao.SearchUserDao;
import com.kh.hp.admin.model.dao.UserDao;
import com.kh.hp.admin.model.vo.User;


public class SearchUserService {


	public int getListCount() {
		Connection con = getConnection();

		int listCount = new UserDao().getListCount(con);

		return listCount;

	}


	//회원검색용 메소드
	public ArrayList<User> searchUserList(String userSeq1, String userSeq2, String userNm, String userGradeCd, String leaveTf,
			int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<User> searchUserList = null;

		boolean userSeq1Tf = false;
		boolean userSeq2Tf = false;
		boolean userNmTf = false;
		boolean userGradeCdTf = false;
		boolean leaveTfTf = false;

		// 입력값 확인
		if(userSeq1 != null && !userSeq1.equals("")) {
			userSeq1Tf = true;
		}
		if(userSeq2 != null && !userSeq2.equals("")) {
			userSeq2Tf = true;
		}
		if(userNm != null && !userNm.equals("")) {
			userNmTf = true;
		}
		if(!leaveTf.equals("선택")) {
			leaveTfTf = true;
		}
		if(!userGradeCd.equals("선택")) {
			userGradeCdTf = true;
		}




		//전체검색시
		if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && !leaveTfTf ) {
			System.out.println("전체검색");
			searchUserList = new  UserDao().selectList(con, currentPage, limit);

			//이름만검색시
		}else if(!(userSeq1Tf && userSeq2Tf) && userNmTf && !userGradeCdTf && !leaveTfTf) {
			System.out.println("이름검색");
			searchUserList = new  SearchUserDao().SearchUserNm(con, userNm, currentPage, limit);

			//회원번호로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && !leaveTfTf ) {
			System.out.println("회원번호 검색");
			searchUserList = new  SearchUserDao().SearchUserSeq(con, userSeq1, userSeq2, currentPage, limit);

			//대관등록승인으로만 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && userGradeCdTf && !leaveTfTf ) {
			System.out.println("대관등록승인 검색");
			searchUserList = new  SearchUserDao().SearchUserCd(con, userGradeCd, currentPage, limit);

			//탈퇴로만 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && leaveTfTf ) {
			System.out.println("탈퇴 검색");
			searchUserList = new  SearchUserDao().SearchUserleave(con, leaveTf, currentPage, limit);

			//회원번호,회원명으로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && userNmTf && !userGradeCdTf && !leaveTfTf ) {
			System.out.println("회원번호 회원명 검색");
			searchUserList = new  SearchUserDao().SearchUserSeqNm(con, userSeq1, userSeq2,userNm, currentPage, limit);

			//회원번호,대관등록승인으로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && !userNmTf && userGradeCdTf && !leaveTfTf ) {
			System.out.println("회원번호 대관등록승인으로만 검색");
			searchUserList = new  SearchUserDao().SearchUserSeqCd(con, userSeq1, userSeq2,userGradeCd, currentPage, limit);

			//회원번호,탈퇴여부로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && leaveTfTf ) {
			System.out.println("회원번호, 탈퇴여부로만 검색");
			searchUserList = new  SearchUserDao().SearchUserSeqleave(con, userSeq1, userSeq2,leaveTf, currentPage, limit);

			//회원명, 대관등록승인으로 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && userNmTf && userGradeCdTf && !leaveTfTf ) {
			System.out.println("회원명, 대관등록승인으로 ㄱ검색");
			searchUserList = new  SearchUserDao().SearchUserNmCd(con, userNm,userGradeCd, currentPage, limit);

			//회원명, 탈퇴여부로 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && userNmTf && !userGradeCdTf && leaveTfTf ) {
			System.out.println("회원명, 탈퇴여부로 검색");
			searchUserList = new  SearchUserDao().SearchUserNmleave(con, userNm,leaveTf, currentPage, limit);


			//대관등록승인, 탈퇴여부로 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && userGradeCdTf && leaveTfTf ) {
			System.out.println("대관등록승인 탈퇴여부로 검색");
			searchUserList = new  SearchUserDao().SearchUserCdleave(con,  userGradeCd,leaveTf, currentPage, limit);

		}

		return searchUserList;
	}


	//회원명으로만 검색 카운트
	public int getListCountforName(String userNm) {
		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforName(con, userNm);


		close(con);

		return result;
	}

	//회원명으로만 검색 카운트
	public int getListCountforSeq(String userSeq1, String userSeq2) {

		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforSeq(con, userSeq1,userSeq2);


		close(con);

		return result;
	}

	//대관승인등록으로만 검색 카운트
	public int getListCountforCd(String userGradeCd) {
		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforCd(con, userGradeCd);


		close(con);

		return result;
	}


	//탈퇴여부로만 카운트
	public int getListCountforleave(String leaveTf) {

		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforleave(con, leaveTf);


		close(con);

		return result;
	}

	//회원번호, 회원명 카운팅
	public int getListCountforSeqNm(String userSeq1, String userSeq2, String userNm) {

		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforSeqNm(con, userSeq1,userSeq2,userNm );


		close(con);

		return result;
	}

	//회원번호,승인등록으로 카운팅
	public int getListCountforSeqCd(String userSeq1, String userSeq2, String userGradeCd) {
		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforSeqCd(con, userSeq1,userSeq2,userGradeCd );


		close(con);

		return result;
	}

	//회원번호,탈퇴여부로만 카운팅
	public int getListCountforSeqleave(String userSeq1, String userSeq2, String leaveTf) {
		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforSeqleave(con, userSeq1,userSeq2,leaveTf );


		close(con);

		return result;
	}


	//회원명, 승인여부로 카운팅
	public int getListCountforNmCd(String userNm, String userGradeCd) {

		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforNmCd(con,userNm, userGradeCd );


		close(con);

		return result;
	}

	//회원명, 탈퇴여부로 카운팅
	public int getListCountforNmleave(String userNm, String leaveTf) {

		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforNmleave(con,userNm, leaveTf );


		close(con);

		return result;
	}

	//승인여부,탈퇴여부로 카운팅
	public int getListCountforCdleave(String userGradeCd, String leaveTf) {

		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforCdleave(con,userGradeCd, leaveTf );


		close(con);

		return result;
	}


	//전체검색시 카운팅
	public int getListCountforAll() {

		Connection con = getConnection();
		int result = 0;

		result = new SearchUserDao().getListCountforAll(con);


		close(con);

		return result;
	}




}