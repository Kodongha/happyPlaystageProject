package com.kh.hp.account.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.KakaoService;

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
		System.out.println(code);

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

		userInfoMap.put("accessToken", accessToken);
		userInfoMap.put("refreshToken", refreshToken);

		// 회원가입을 하지 않은 유저라면 추가 회원가입 폼으로 이동
		if(userInfoMap.get("kakaoTokenMngVO") == null) {
			request.setAttribute("userInfoMap", userInfoMap);
			request.getRequestDispatcher("views/account/kakaoSignup.jsp").forward(request, response);
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
