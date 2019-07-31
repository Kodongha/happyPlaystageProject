package com.kh.hp.account.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class KakaoDao {

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
}
