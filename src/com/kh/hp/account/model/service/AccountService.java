package com.kh.hp.account.model.service;

import static com.kh.hp.common.JDBCTemplate.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import com.kh.hp.account.model.dao.AccountDao;
import com.kh.hp.account.model.vo.UserVO;

public class AccountService {

	public static UserVO CheckLogin(UserVO requestUserVO) {
		// TODO Auto-generated method stub

		Connection con = getConnection();

		UserVO responseUserVO = new AccountDao().selectLoginUser(con, requestUserVO);

		close(con);

		return responseUserVO;
	}

	/**
	 * 이메일 인증번호 확인
	 * @param sessionId
	 * @param authNumber
	 * @return
	 */
	public int checkAuth(String sessionId, String authNumber) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		int result = new AccountDao().selectAuth(con, sessionId, authNumber);

		return result;
	}

	/**
	 * 아이디 확인
	 * @param receiver
	 * @return
	 */
	public int checkId(String receiver) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		int result = new AccountDao().checkId(con, receiver);

		return result;
	}

	/**
	 * 임시 비밀번호 설정
	 * @param email
	 * @return
	 */
	public String updatePassword(int userSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		// 임시비밀번호 생성
		String randomStr = String.valueOf((int) (Math.random() * 100000) + 999999);
		String tempStr = randomStr;
		ArrayList<Character> tempArray = new ArrayList<Character>();
		for(int i=0; i<tempStr.length(); i++) {
			tempArray.add(tempStr.charAt(i));
			tempArray.add((char)('A' + i));
		}
		Collections.shuffle(tempArray);
		String newPwd = "";
		for(char c : tempArray) {
			newPwd += c;
		}
		System.out.println("newPwd:::"+newPwd);
		int updateResult = 0;
		int insetResult = 0;

		updateResult = new AccountDao().updateUserPwd(con, userSeq, newPwd);
		if(updateResult > 0) {
			insetResult = new AccountDao().insertLog(con, userSeq, newPwd);
			if(insetResult > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		}

		return newPwd;
	}

	public UserVO getUserInfoForKakao(int userSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		return null;
	}

}
