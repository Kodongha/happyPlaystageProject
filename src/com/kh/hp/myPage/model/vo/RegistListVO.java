package com.kh.hp.myPage.model.vo;

import java.util.Date;

public class RegistListVO implements java.io.Serializable{
	private int rentSeq;
	private int userSeq;
	private int userGradeCode;
	private String hallNm;
	private String rentEnrollStatus;
	private String inspTf;
	private Date rentEnrollDt;

	public RegistListVO() {}

	public RegistListVO(int rentSeq, int userSeq, int userGradeCode, String hallNm, String rentEnrollStatus,
			String inspTf, Date rentEnrollDt) {
		super();
		this.rentSeq = rentSeq;
		this.userSeq = userSeq;
		this.userGradeCode = userGradeCode;
		this.hallNm = hallNm;
		this.rentEnrollStatus = rentEnrollStatus;
		this.inspTf = inspTf;
		this.rentEnrollDt = rentEnrollDt;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getUserGradeCode() {
		return userGradeCode;
	}

	public void setUserGradeCode(int userGradeCode) {
		this.userGradeCode = userGradeCode;
	}

	public String getHallNm() {
		return hallNm;
	}

	public void setHallNm(String hallNm) {
		this.hallNm = hallNm;
	}

	public String getRentEnrollStatus() {
		return rentEnrollStatus;
	}

	public void setRentEnrollStatus(String rentEnrollStatus) {
		this.rentEnrollStatus = rentEnrollStatus;
	}

	public String getInspTf() {
		return inspTf;
	}

	public void setInspTf(String inspTf) {
		this.inspTf = inspTf;
	}

	public Date getRentEnrollDt() {
		return rentEnrollDt;
	}

	public void setRentEnrollDt(Date rentEnrollDt) {
		this.rentEnrollDt = rentEnrollDt;
	}

	@Override
	public String toString() {
		return "RegistListVO [rentSeq=" + rentSeq + ", userSeq=" + userSeq + ", userGradeCode=" + userGradeCode
				+ ", hallNm=" + hallNm + ", rentEnrollStatus=" + rentEnrollStatus + ", inspTf=" + inspTf
				+ ", rentEnrollDt=" + rentEnrollDt + "]";
	}



}