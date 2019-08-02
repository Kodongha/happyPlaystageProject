package com.kh.hp.account.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.hp.account.model.vo.KakaoTokenMngVO;

public class KakaoDao {

	private Properties prop = new Properties();

	public KakaoDao() {
		String fileName = ReviewDao.class.getResource("/sql/account/kakao-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 메소드
	private final String METHOD_GET = "GET";
	private final String METHOD_POST = "POST";

	// 기타 정보
	private final String REST_API_KEY = "ea861fadd8d5b486bbcd4ae127c3404d";
	private final String REDIRECT_URL = "http://localhost:8001/happyPlaystage/kakaoLogin.acc";



	/**
	 * 카카오 access, refresh 토큰 받아오기
	 * @param code
	 * @return
	 */
	public HashMap<String, String> getTokenInfo(String code) {
		// TODO Auto-generated method stub

		final String REQUEST_URL = "https://kauth.kakao.com/oauth/token";
		final String PARAM_1 = "grant_type=authorization_code";
		final String PARAM_2 = "client_id=";
		final String PARAM_3 = "redirect_uri=";
		final String PARAM_4 = "code=";

		//url 연결을 위한 Connection 생성
		URL url;

		HashMap<String, String> tokenMap = new HashMap<String, String>();

		try {
			url = new URL(REQUEST_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			//API 요청 방식에 따라 메소드 변경
			conn.setRequestMethod(METHOD_POST);
			//POST요청을 위해 기본값이 false인 setDoOutput을 true로 변경
			conn.setDoOutput(true);

			//POST요청에 필요로 하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append(PARAM_1);
			sb.append("&" + PARAM_2 + REST_API_KEY);
			sb.append("&" + PARAM_3 + REDIRECT_URL);
			sb.append("&" + PARAM_4 + code);
			bw.write(sb.toString());
			bw.flush();

			//요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			System.out.println("response body : " + result);

			//Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			String accessToken = element.getAsJsonObject().get("access_token").getAsString();
			String tokenType = element.getAsJsonObject().get("token_type").getAsString();
			String refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
			String expiresIn = element.getAsJsonObject().get("expires_in").getAsString();
			String scope = element.getAsJsonObject().get("scope").getAsString();

			System.out.println("access_token : " + accessToken);
			System.out.println("refresh_token : " + refreshToken);

			br.close();
			bw.close();

			tokenMap.put("accessToken", accessToken);
			tokenMap.put("tokenType", tokenType);
			tokenMap.put("refreshToken", refreshToken);
			tokenMap.put("expiresIn", expiresIn);
			tokenMap.put("scope", scope);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tokenMap;
	}


	/**
	 * 토큰의 기간 만료 확인한 후 만료 경우, 업데이트 처리
	 * @param accessToken
	 * @return
	 */
	public HashMap<String, String> validationToken(String accessToken) {
		// TODO Auto-generated method stub
		URL url;

		final String REQUEST_URL = "https://kapi.kakao.com/v1/user/access_token_info";

		try {
			url = new URL(REQUEST_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			//API 요청 방식에 따라 메소드 변경
			conn.setRequestMethod(METHOD_GET);
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setDoOutput(true);
			int responseCode = conn.getResponseCode();

			System.out.println("responseCode:::" + responseCode);

			//요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			System.out.println("response body : " + result);

			//Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			String id = element.getAsJsonObject().get("id").getAsString();
			String expiresInMillis = element.getAsJsonObject().get("expiresInMillis").getAsString();
			String appId = element.getAsJsonObject().get("appId").getAsString();

			System.out.println("id:::" + id);
			System.out.println("expiresInMillis:::" + expiresInMillis);
			System.out.println("appId:::" + appId);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}


	/**
	 * 사용자 정보 가져오기
	 * @param accessToken
	 * @return
	 */
	public HashMap<String, Object> getUserInfo(String accessToken) {
		// TODO Auto-generated method stub

		HashMap<String, Object> userInfo = new HashMap<>();
		final String REQUEST_URL = "https://kapi.kakao.com/v2/user/me";

		URL url;
		try {
			url = new URL(REQUEST_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(METHOD_POST);

			conn.setRequestProperty("Authorization", "Bearer " + accessToken);

			int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : " + responseCode);

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	        String line = "";
	        String result = "";

	        while ((line = br.readLine()) != null) {
	            result += line;
	        }
	        System.out.println("response body : " + result);

	        JsonParser parser = new JsonParser();
	        JsonElement element = parser.parse(result);

	        String id = element.getAsJsonObject().get("id").getAsString();
	        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
	        JsonObject kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

	        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
	        String email = "";
	        String hasEmail = "";

	        if(kakaoAccount.getAsJsonObject().get("email") != null) {
	        	email = kakaoAccount.getAsJsonObject().get("email").getAsString();
	        	hasEmail = kakaoAccount.getAsJsonObject().get("has_email").getAsString();
	        }

	        userInfo.put("id", id);
	        userInfo.put("nickname", nickname);
	        userInfo.put("hasEmail", hasEmail);
	        userInfo.put("email", email);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userInfo;
	}


	/**
	 * 토큰의 기간 만료 확인한 후 만료 경우, 업데이트 처리
	 * @param con
	 * @param userInfo
	 * @return
	 */
	public KakaoTokenMngVO selectStoredAccessToken(Connection con, HashMap<String, Object> userInfo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		KakaoTokenMngVO kakaoTokenMngVO = null;

		String query = prop.getProperty("selectStoredAccessToken");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, (String) userInfo.get("id"));

			rset = pstmt.executeQuery();
			if(rset.next()) {
				kakaoTokenMngVO = new KakaoTokenMngVO();
				kakaoTokenMngVO.setUserSeq(rset.getInt("USER_SEQ"));
				kakaoTokenMngVO.setAccessToken(rset.getString("ACCESS_TOKEN"));
				kakaoTokenMngVO.setRefreshToken(rset.getString("REFRESH_TOKEN"));
				kakaoTokenMngVO.setKakaoUnqId(rset.getString("KAKAO_UNQ_ID"));
				kakaoTokenMngVO.setMailTf(rset.getString("MAIL_TF"));
				kakaoTokenMngVO.setTokenUpdateDt(rset.getDate("TOKEN_UPDATE_DT"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return kakaoTokenMngVO;
	}


	public int updateKaKaoUserInfo(Connection con, HashMap<String, Object> userInfo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateKaKaoUserInfo");

		try {

			pstmt = con.prepareStatement(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}


	public int insertUserInfo(Connection con, KakaoTokenMngVO kakaoTokenMngVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertUserInfo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, kakaoTokenMngVO.getUserEmail());
			pstmt.setString(2, kakaoTokenMngVO.getUserNm());
			pstmt.setString(3, kakaoTokenMngVO.getUserNick());
			pstmt.setString(4, kakaoTokenMngVO.getUserPhone());
			pstmt.setInt(5, kakaoTokenMngVO.getUserGradeCd());
			pstmt.setInt(6, kakaoTokenMngVO.getSnsCd());
			pstmt.setInt(7, kakaoTokenMngVO.getLeaveTf());

			result = pstmt.executeUpdate();
			/*
			USER_SEQ
			USER_EMAIL
			USER_PWD
			USER_NM
			USER_NICK
			USER_PHONE
			USER_GRADE_CD
			ENROLL_DT
			SNS_CD
			LEAVE_TF
			LEAVE_DT
			*/

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
}
