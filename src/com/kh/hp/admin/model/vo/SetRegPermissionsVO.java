package com.kh.hp.admin.model.vo;

import java.sql.Date;

public class SetRegPermissionsVO   implements java.io.Serializable{
	private int userSeq;
	private String userNm;
	private String userPhone;
	private int userGradeCd;
	private String originNm ;
	private Date gradeUpDt;
	private String userGradeStatus;
	
	
	public SetRegPermissionsVO () {}


	public SetRegPermissionsVO(int userSeq, String userNm, String userPhone, int userGradeCd, String originNm,
			Date gradeUpDt, String userGradeStatus) {
		super();
		this.userSeq = userSeq;
		this.userNm = userNm;
		this.userPhone = userPhone;
		this.userGradeCd = userGradeCd;
		this.originNm = originNm;
		this.gradeUpDt = gradeUpDt;
		this.userGradeStatus = userGradeStatus;
	}


	public int getUserSeq() {
		return userSeq;
	}


	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}


	public String getUserNm() {
		return userNm;
	}


	public void setUserNm(String userNm) {
		this.userNm = userNm;
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


	public String getOriginNm() {
		return originNm;
	}


	public void setOriginNm(String originNm) {
		this.originNm = originNm;
	}


	public Date getGradeUpDt() {
		return gradeUpDt;
	}


	public void setGradeUpDt(Date gradeUpDt) {
		this.gradeUpDt = gradeUpDt;
	}


	public String getUserGradeStatus() {
		return userGradeStatus;
	}


	public void setUserGradeStatus(String userGradeStatus) {
		this.userGradeStatus = userGradeStatus;
	}


	@Override
	public String toString() {
		return "SetRegPermissionsVO [userSeq=" + userSeq + ", userNm=" + userNm + ", userPhone=" + userPhone
				+ ", userGradeCd=" + userGradeCd + ", originNm=" + originNm + ", gradeUpDt=" + gradeUpDt
				+ ", userGradeStatus=" + userGradeStatus + "]";
	}


	
}
