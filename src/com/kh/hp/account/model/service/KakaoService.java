package com.kh.hp.account.model.service;

import java.util.HashMap;

import com.kh.hp.account.model.dao.KakaoDao;

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

		HashMap<String, Object> userInfo = new KakaoDao().getUserInfo(accessToken);

		return userInfo;
	}

}
