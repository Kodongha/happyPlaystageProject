package com.kh.hp.myPage.model.vo;

import java.sql.Date;

public class AhnLevelupVO implements java.io.Serializable{
	private int userSeq;
	private String userEmail;
	private String userNm;
	private String userNick;
	private String userPhone;
	
	public AhnLevelupVO() {}
	
	public AhnLevelupVO(int userSeq, String userEmail, String userNm, String userNick, String userPhone) {
		super();
		this.userSeq = userSeq;
		this.userEmail = userEmail;
		this.userNm = userNm;
		this.userNick = userNick;
		this.userPhone = userPhone;
		
	}
	
	public int getUserSeq() {
		return userSeq;
	}
	
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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

	@Override
	public String toString() {
		return "AhnLevelupVO [userSeq=" + userSeq + ", userEmail=" + userEmail + ", userPwd=" + ", userNm="
				+ userNm + ", userNick=" + userNick + ", userPhone=" + userPhone + "]";
	}

	
}
