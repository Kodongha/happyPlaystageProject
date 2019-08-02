package com.kh.hp.account.model.service;

import static com.kh.hp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;

import com.kh.hp.account.model.dao.KakaoDao;
import com.kh.hp.account.model.vo.KakaoTokenMngVO;

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

		return userInfoMap;
	}

	public int insertKakaoUser(KakaoTokenMngVO kakaoTokenMngVO) {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		int insertRentBasicResult = new KakaoDao().insertUserInfo(con, kakaoTokenMngVO);



		return 0;
	}

}
