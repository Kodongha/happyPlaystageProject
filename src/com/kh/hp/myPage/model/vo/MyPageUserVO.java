package com.kh.hp.myPage.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class MyPageUserVO implements Serializable {

	private int userSeq;
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

	private String originNm;
	private String changeNm;
	private String filePath;
	private Date uploadDt;

	public MyPageUserVO() {
		// TODO Auto-generated constructor stub
	}

	public MyPageUserVO(int userSeq, String userEmail, String userPwd, String userNm, String userNick, String userPhone,
			int userGradeCd, Date enrollDt, int snsCd, char leaveTf, Date leaveDt, String originNm, String changeNm,
			String filePath, Date uploadDt) {
		super();
		this.userSeq = userSeq;
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
		this.originNm = originNm;
		this.changeNm = changeNm;
		this.filePath = filePath;
		this.uploadDt = uploadDt;
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

	public String getOriginNm() {
		return originNm;
	}

	public void setOriginNm(String originNm) {
		this.originNm = originNm;
	}

	public String getChangeNm() {
		return changeNm;
	}

	public void setChangeNm(String changeNm) {
		this.changeNm = changeNm;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDt() {
		return uploadDt;
	}

	public void setUploadDt(Date uploadDt) {
		this.uploadDt = uploadDt;
	}

	@Override
	public String toString() {
		return "MyPageUserVO [userSeq=" + userSeq + ", userEmail=" + userEmail + ", userPwd=" + userPwd + ", userNm="
				+ userNm + ", userNick=" + userNick + ", userPhone=" + userPhone + ", userGradeCd=" + userGradeCd
				+ ", enrollDt=" + enrollDt + ", snsCd=" + snsCd + ", leaveTf=" + leaveTf + ", leaveDt=" + leaveDt
				+ ", originNm=" + originNm + ", changeNm=" + changeNm + ", filePath=" + filePath + ", uploadDt="
				+ uploadDt + "]";
	}

}
