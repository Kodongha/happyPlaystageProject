package com.kh.hp.admin.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.kh.hp.account.model.vo.UserVO;
import com.kh.hp.admin.model.dao.SearchUserDao;
import com.kh.hp.admin.model.dao.UserDao;
import com.kh.hp.admin.model.vo.User;
import com.kh.hp.myPage.model.dao.AhnMyPageDao;
import com.kh.hp.myPage.model.vo.AhnApplyInfoVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;

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
		if((userSeq1Tf && userSeq2Tf) && userNmTf && userGradeCdTf && !leaveTfTf ) {
			return null;

			//이름만검색시
		}else if(!(userSeq1Tf && userSeq2Tf) && userNmTf && !userGradeCdTf && !leaveTfTf) {
			searchUserList = new  SearchUserDao().SearchUserNm(con, userNm, currentPage, limit);

			//회원번호로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && !leaveTfTf ) {
			searchUserList = new  SearchUserDao().SearchUserSeq(con, userSeq1, userSeq2, currentPage, limit);

			//대관등록승인으로만 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && userGradeCdTf && !leaveTfTf ) {
			searchUserList = new  SearchUserDao().SearchUserCd(con, userGradeCd, currentPage, limit);

			//탈퇴로만 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && leaveTfTf ) {
			searchUserList = new  SearchUserDao().SearchUserleave(con, leaveTf, currentPage, limit);

			//회원번호,회원명으로만 검색 
		}else if((userSeq1Tf && userSeq2Tf) && userNmTf && !userGradeCdTf && !leaveTfTf ) {
			searchUserList = new  SearchUserDao().SearchUserSeqNm(con, userSeq1, userSeq2,userNm, currentPage, limit);

			//회원번호,대관등록승인으로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && !userNmTf && userGradeCdTf && !leaveTfTf ) {
			searchUserList = new  SearchUserDao().SearchUserSeqCd(con, userSeq1, userSeq2,userGradeCd, currentPage, limit);

			//회원번호,탈퇴여부로만 검색
		}else if((userSeq1Tf && userSeq2Tf) && !userNmTf && !userGradeCdTf && leaveTfTf ) {
			searchUserList = new  SearchUserDao().SearchUserSeqleave(con, userSeq1, userSeq2,leaveTf, currentPage, limit);

			//회원명, 대관등록승인으로 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && userNmTf && userGradeCdTf && !leaveTfTf ) {
			searchUserList = new  SearchUserDao().SearchUserNmCd(con, userNm,userGradeCd, currentPage, limit);

			//회원명, 탈퇴여부로 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && userNmTf && !userGradeCdTf && leaveTfTf ) {
			searchUserList = new  SearchUserDao().SearchUserNmleave(con, userNm,leaveTf, currentPage, limit);


			//대관등록승인, 탈퇴여부로 검색
		}else if(!(userSeq1Tf && userSeq2Tf) && !userNmTf && userGradeCdTf && leaveTfTf ) {
			searchUserList = new  SearchUserDao().SearchUserCdleave(con,  userGradeCd,leaveTf, currentPage, limit);
			

			/* }else if((userSeq1Tf && userSeq2Tf) && userNmTf && userGradeCdTf && !leaveTfTf ) {

		 }else if((userSeq1Tf && userSeq2Tf) && userNmTf && userGradeCdTf && !leaveTfTf ) {

		 }else if((userSeq1Tf && userSeq2Tf) && userNmTf && userGradeCdTf && !leaveTfTf ) {

		 }else if((userSeq1Tf && userSeq2Tf) && userNmTf && userGradeCdTf && !leaveTfTf ) {

		 }else if((userSeq1Tf && userSeq2Tf) && userNmTf && userGradeCdTf && !leaveTfTf ) {*/



		}












		return searchUserList;


	}
}
