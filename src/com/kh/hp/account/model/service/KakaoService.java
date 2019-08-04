package com.kh.hp.account.model.service;

import static com.kh.hp.common.JDBCTemplate.close;
import static com.kh.hp.common.JDBCTemplate.commit;
import static com.kh.hp.common.JDBCTemplate.getConnection;
import static com.kh.hp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.HashMap;

import com.kh.hp.account.model.dao.KakaoDao;
import com.kh.hp.account.model.vo.KakaoTokenMngVO;
import com.kh.hp.account.model.vo.UserVO;

public class KakaoService {

	/**
	 * 카카오 access, refresh 토큰 받아오기
	 * @param code
	 * @return
	 */
	public HashMap<String, String> getTokenInfo(String code) {
		// TODO Auto-generated method stub

		HashMap<String, String> tokenMap = new KakaoDao().getTokenInfo(code);

		return tokenMap;
	}

	/**
	 * 토큰의 기간 만료 확인한 후 만료 경우, 업데이트 처리
	 * @param accessToken
	 * @return
	 */
	public HashMap<String, String> validationToken(String accessToken) {
		// TODO Auto-generated method stub

		HashMap<String, String> tokenValidation = new KakaoDao().validationToken(accessToken);

		return tokenValidation;
	}

	/**
	 * 사용자 정보 가져오기
	 * @param accessToken
	 * @return
	 */
	public HashMap<String, Object> getUserInfo(String accessToken) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		// 사용자 정보 가져오기
		HashMap<String, Object> userInfoMap = new KakaoDao().getUserInfo(accessToken);

		// 사용자가 가입자인지 아닌지 구분
		KakaoTokenMngVO kakaoTokenMngVO = new KakaoDao().selectStoredAccessToken(con, userInfoMap);

		userInfoMap.put("kakaoTokenMngVO", kakaoTokenMngVO);

		close(con);

		return userInfoMap;
	}

	/**
	 * 신규 카카오 계정 INSERT
	 * @param kakaoTokenMngVO
	 * @return
	 */
	public int insertKakaoUser(KakaoTokenMngVO kakaoTokenMngVO) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		int insertRentBasicResult = new KakaoDao().insertUserInfo(con, kakaoTokenMngVO);
		System.out.println("insertRentBasicResult:::" + insertRentBasicResult);

		int insertKakaoTokenResult = 0;
		int userSeq = 0;
		if(insertRentBasicResult > 0) {
			// get userSeq
			userSeq = new KakaoDao().selectUserSeq(con);

			System.out.println("kakaoTokenMngVO.getUserSeq():::" + kakaoTokenMngVO.getUserSeq());
			System.out.println("userSeq:::" + userSeq);
			kakaoTokenMngVO.setUserSeq(userSeq);
			insertKakaoTokenResult = new KakaoDao().inserkakaoTokenMng(con, kakaoTokenMngVO);
		}

		if(insertKakaoTokenResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return userSeq;
	}

	/**
	 * 토큰 갱신
	 * @param userInfoMap
	 * @return
	 */
	public int updateToken(HashMap<String, Object> userInfoMap) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		HashMap<String, String> newTokenMap = new KakaoDao().getUpdateToken(con, userInfoMap);
		int result = new KakaoDao().updateToken(con, userInfoMap, newTokenMap);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result;
	}

	/**
	 * 토큰 비교를 위한 DB 토큰 조회
	 * @param userInfoMap
	 * @return
	 */
	public String getAccessTokenFromDB(HashMap<String, Object> userInfoMap) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		int userSeq = ((KakaoTokenMngVO) userInfoMap.get("kakaoTokenMngVO")).getUserSeq();

		String accessTokenFromDB = new KakaoDao().getAccessTokenFromDB(con, userSeq);


		return accessTokenFromDB;
	}

	/**
	 * 세션에 담을 UserVO 가져오기
	 * @param userSeq
	 * @return
	 */
	public UserVO getUserInfoForKakao(int userSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		UserVO responseUserVO = new KakaoDao().getUserInfoForKakao(con, userSeq);


		return responseUserVO;
	}

	/**
	 * 카카오 계정 로그아웃
	 * @param userSeq
	 * @return
	 */
	public String logoutKakaoAccount(int userSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		String accessToken = new KakaoDao().getAccessTokenFromDB(con, userSeq);
		String logoutKakaoUnqId = new KakaoDao().logoutKakaoAccount(accessToken);


		return logoutKakaoUnqId;
	}

	/**
	 * 카카오 계정 탈퇴
	 * @param userSeq
	 * @return
	 */
	public String retireKakaoAccount(int userSeq) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		String accessToken = new KakaoDao().getAccessTokenFromDB(con, userSeq);
		String retireKakaoUnqId = new KakaoDao().retireKakaoAccount(accessToken);

		if(retireKakaoUnqId != null || !retireKakaoUnqId.equals("")) {
			int result = new KakaoDao().deleteKakaoUser(con, userSeq);

			if(result > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		}


		return retireKakaoUnqId;
	}

}
