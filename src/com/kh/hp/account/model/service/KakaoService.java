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

	public HashMap<String, String> validationToken(String accessToken) {
		// TODO Auto-generated method stub

		HashMap<String, String> tokenValidation = new KakaoDao().validationToken(accessToken);

		return null;
	}

}
