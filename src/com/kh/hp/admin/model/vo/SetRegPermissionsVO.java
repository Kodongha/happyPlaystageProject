package com.kh.hp.admin.model.vo;

public class SetRegPermissionsVO   implements java.io.Serializable{
	private int userSeq;
	private String userNm;
	private String userPhone;
	private int userGradeStatus;
	private String originNm ;
	
	
	public SetRegPermissionsVO () {}


	public SetRegPermissionsVO(int userSeq, String userNm, String userPhone, int userGradeStatus, String originNm) {
		super();
		this.userSeq = userSeq;
		this.userNm = userNm;
		this.userPhone = userPhone;
		this.userGradeStatus = userGradeStatus;
		this.originNm = originNm;
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


	public int getUserGradeStatus() {
		return userGradeStatus;
	}


	public void setUserGradeStatus(int userGradeStatus) {
		this.userGradeStatus = userGradeStatus;
	}


	public String getOriginNm() {
		return originNm;
	}


	public void setOriginNm(String originNm) {
		this.originNm = originNm;
	}


	@Override
	public String toString() {
		return "SetRegPermissionsVO [userSeq=" + userSeq + ", userNm=" + userNm + ", userPhone=" + userPhone
				+ ", userGradeStatus=" + userGradeStatus + ", originNm=" + originNm + "]";
	}

	
	
}
