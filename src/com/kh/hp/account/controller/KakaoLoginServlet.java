package com.kh.hp.account.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.hp.account.model.service.AccountService;
import com.kh.hp.account.model.service.KakaoService;
import com.kh.hp.account.model.vo.KakaoTokenMngVO;
import com.kh.hp.account.model.vo.UserVO;

/**
 * Servlet implementation class KakaoLoginServlet
 */
@WebServlet("/kakaoLogin.acc")
public class KakaoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("kakao login in!");

		String code = request.getParameter("code");
		System.out.println("code ::::" + code);

		// 카카오 access, refresh 토큰 받아오기
		HashMap<String, String> tokenMap = new KakaoService().getTokenInfo(code);

		Iterator<String> iter = tokenMap.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ":" + tokenMap.get(key));
		}

		// 사용자 정보 가져오기
		String accessToken = tokenMap.get("accessToken");
		String refreshToken = tokenMap.get("refreshToken");
		HashMap<String, Object> userInfoMap = new KakaoService().getUserInfo(accessToken);
		/*
		kakaoTokenMngVO
		hasEmail
		nickname
		id
		accessToken
		email
		refreshToken
		expiresIn
		*/

		userInfoMap.put("accessToken", accessToken);
		userInfoMap.put("refreshToken", refreshToken);
		boolean accessTokenSameFlag = false;

		// 회원가입을 하지 않은 유저라면 추가 회원가입 폼으로 이동
		if(userInfoMap.get("kakaoTokenMngVO") == null) {
			request.setAttribute("userInfoMap", userInfoMap);
			request.getRequestDispatcher("views/account/kakaoSignup.jsp").forward(request, response);

		// 회원가입이 된 유저라면
		} else {

			String accessTokenFromDB = new KakaoService().getAccessTokenFromDB(userInfoMap);
			System.out.println("accessTokenFromDB:::" + accessTokenFromDB);

			if(accessTokenFromDB.equals(accessToken)) {
				accessTokenSameFlag = true;
			}

			Date date = ((KakaoTokenMngVO) userInfoMap.get("kakaoTokenMngVO")).getTokenUpdateDt();
			java.util.Date today = new java.util.Date();
			System.out.println("date.getTime():::" + date.getTime());
			System.out.println("today.getTime():::" + today.getTime());

			long diffHour = (today.getTime() - date.getTime()) / 1000 / 60 / 60;
			System.out.println(diffHour);

			// TOKEN UPDATE 토큰이 만료됐다면, 토큰 갱신
			if(diffHour >= 10 || (diffHour >= 10 && accessTokenSameFlag) || !accessTokenSameFlag) {
				System.out.println("토큰을 갱신합니다!!!");
				int result = new KakaoService().updateToken(userInfoMap);
			}

			System.out.println("최종 userInfoMap :: " + userInfoMap);
			int userSeq = ((KakaoTokenMngVO) userInfoMap.get("kakaoTokenMngVO")).getUserSeq();

			// responseUserVO setting
			UserVO responseUserVO = new KakaoService().getUserInfoForKakao(userSeq);

			HttpSession session = request.getSession();
			session.setAttribute("user", responseUserVO);

			if(responseUserVO != null) {
				response.sendRedirect(request.getContextPath() + "/moveMain.main");
			} else {
				request.setAttribute("loginFlag", false);
				request.getRequestDispatcher("views/account/login.jsp").forward(request, response);
			}
		}



		// 토큰의 기간 만료 확인한 후 만료 경우, 업데이트 처리
		/*
		HashMap<String, String> tokenValidation = new KakaoService().validationToken(accessToken);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
