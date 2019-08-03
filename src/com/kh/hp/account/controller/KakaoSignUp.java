package com.kh.hp.account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.model.service.KakaoService;
import com.kh.hp.account.model.vo.KakaoTokenMngVO;

/**
 * Servlet implementation class KakaoSignUp
 */
@WebServlet("/kakaoSignUp.acc")
public class KakaoSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userEmail = request.getParameter("userEmail");
		String userNm = request.getParameter("userNm");
		String userPhone = request.getParameter("userPhone");
		String userNick = request.getParameter("userNick");
		String accessToken = request.getParameter("accessToken");
		String refreshToken = request.getParameter("refreshToken");
		String kakaoUnqId = request.getParameter("kakaoUnqId");
		String mailTf = request.getParameter("mailTf");

		System.out.println("userEmail :: " + userEmail);
		System.out.println("userNm :: " + userNm);
		System.out.println("userPhone :: " + userPhone);
		System.out.println("userNick :: " + userNick);
		System.out.println("accessToken :: " + accessToken);
		System.out.println("refreshToken :: " + refreshToken);
		System.out.println("kakaoUnqId :: " + kakaoUnqId);
		System.out.println("mailTf :: " + mailTf);

		KakaoTokenMngVO kakaoTokenMngVO = new KakaoTokenMngVO();
		kakaoTokenMngVO.setUserEmail(userEmail);
		kakaoTokenMngVO.setUserNm(userNm);
		kakaoTokenMngVO.setUserPhone(userPhone);
		kakaoTokenMngVO.setUserNick(userNick);
		kakaoTokenMngVO.setAccessToken(accessToken);
		kakaoTokenMngVO.setRefreshToken(refreshToken);
		kakaoTokenMngVO.setKakaoUnqId(kakaoUnqId);
		kakaoTokenMngVO.setMailTf(mailTf);
		kakaoTokenMngVO.setUserGradeCd(1);
		kakaoTokenMngVO.setSnsCd(1);
		kakaoTokenMngVO.setLeaveTf('N');

		int result = new KakaoService().insertKakaoUser(kakaoTokenMngVO);
		System.out.println("result::::" + result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
