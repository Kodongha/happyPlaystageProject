package com.kh.hp.account.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class KakaoTokenMngVO implements Serializable {

	private int userSeq;
	private String accessToken;
	private String refreshToken;
	private String kakaoUnqId;
	private String mailTf;
	private Date tokenUpdateDt;

	private String userEmail;
	private String userPwd;
	private String userNm;
	private String userNick;
	private String userPhone;
	private int userGradeCd;
	private Date enrollDt;
	private int snsCd;
	private char leaveTf;
	private Date leaveDt;

	public KakaoTokenMngVO() {
		// TODO Auto-generated constructor stub
	}

	public KakaoTokenMngVO(int userSeq, String accessToken, String refreshToken, String kakaoUnqId, String mailTf,
			Date tokenUpdateDt, String userEmail, String userPwd, String userNm, String userNick, String userPhone,
			int userGradeCd, Date enrollDt, int snsCd, char leaveTf, Date leaveDt) {
		super();
		this.userSeq = userSeq;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.kakaoUnqId = kakaoUnqId;
		this.mailTf = mailTf;
		this.tokenUpdateDt = tokenUpdateDt;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userNm = userNm;
		this.userNick = userNick;
		this.userPhone = userPhone;
		this.userGradeCd = userGradeCd;
		this.enrollDt = enrollDt;
		this.snsCd = snsCd;
		this.leaveTf = leaveTf;
		this.leaveDt = leaveDt;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getKakaoUnqId() {
		return kakaoUnqId;
	}

	public void setKakaoUnqId(String kakaoUnqId) {
		this.kakaoUnqId = kakaoUnqId;
	}

	public String getMailTf() {
		return mailTf;
	}

	public void setMailTf(String mailTf) {
		this.mailTf = mailTf;
	}

	public Date getTokenUpdateDt() {
		return tokenUpdateDt;
	}

	public void setTokenUpdateDt(Date tokenUpdateDt) {
		this.tokenUpdateDt = tokenUpdateDt;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserGradeCd() {
		return userGradeCd;
	}

	public void setUserGradeCd(int userGradeCd) {
		this.userGradeCd = userGradeCd;
	}

	public Date getEnrollDt() {
		return enrollDt;
	}

	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}

	public int getSnsCd() {
		return snsCd;
	}

	public void setSnsCd(int snsCd) {
		this.snsCd = snsCd;
	}

	public char getLeaveTf() {
		return leaveTf;
	}

	public void setLeaveTf(char leaveTf) {
		this.leaveTf = leaveTf;
	}

	public Date getLeaveDt() {
		return leaveDt;
	}

	public void setLeaveDt(Date leaveDt) {
		this.leaveDt = leaveDt;
	}

	@Override
	public String toString() {
		return "KakaoTokenMngVO [userSeq=" + userSeq + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken
				+ ", kakaoUnqId=" + kakaoUnqId + ", mailTf=" + mailTf + ", tokenUpdateDt=" + tokenUpdateDt
				+ ", userEmail=" + userEmail + ", userPwd=" + userPwd + ", userNm=" + userNm + ", userNick=" + userNick
				+ ", userPhone=" + userPhone + ", userGradeCd=" + userGradeCd + ", enrollDt=" + enrollDt + ", snsCd="
				+ snsCd + ", leaveTf=" + leaveTf + ", leaveDt=" + leaveDt + "]";
	}

}
