package com.kh.hp.myPage.model.vo;

import java.sql.Date;

public class AhnLevelupVO implements java.io.Serializable{
	private String userEmail;
	private String userPwd;
	private String userNm;
	private String userNick;
	private String userPhone;
	private Date enrollDt;
	
	public AhnLevelupVO() {}

	public AhnLevelupVO(String userEmail, String userPwd, String userNm, String userNick, String userPhone,
			Date enrollDt) {
		super();
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userNm = userNm;
		this.userNick = userNick;
		this.userPhone = userPhone;
		this.enrollDt = enrollDt;
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

	public Date getEnrollDt() {
		return enrollDt;
	}

	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}

	@Override
	public String toString() {
		return "AhnLevelupVO [userEmail=" + userEmail + ", userPwd=" + userPwd + ", userNm=" + userNm + ", userNick="
				+ userNick + ", userPhone=" + userPhone + ", enrollDt=" + enrollDt + "]";
	}
	
	
}
