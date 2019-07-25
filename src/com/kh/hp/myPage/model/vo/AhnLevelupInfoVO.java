package com.kh.hp.myPage.model.vo;

import java.sql.Date;

public class AhnLevelupInfoVO implements java.io.Serializable {
	private int userGradeUpSeq;
	private int userSeq;
	private String userGradeStatus;
	private Date gradeReqDt;
	private Date gradeUpDt;
	
	public AhnLevelupInfoVO() {}

	public AhnLevelupInfoVO(int userGradeUpSeq, int userSeq, String userGradeStatus, Date gradeReqDt, Date gradeUpDt) {
		super();
		this.userGradeUpSeq = userGradeUpSeq;
		this.userSeq = userSeq;
		this.userGradeStatus = userGradeStatus;
		this.gradeReqDt = gradeReqDt;
		this.gradeUpDt = gradeUpDt;
	}

	public int getUserGradeUpSeq() {
		return userGradeUpSeq;
	}

	public void setUserGradeUpSeq(int userGradeUpSeq) {
		this.userGradeUpSeq = userGradeUpSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserGradeStatus() {
		return userGradeStatus;
	}

	public void setUserGradeStatus(String userGradeStatus) {
		this.userGradeStatus = userGradeStatus;
	}

	public Date getGradeReqDt() {
		return gradeReqDt;
	}

	public void setGradeReqDt(Date gradeReqDt) {
		this.gradeReqDt = gradeReqDt;
	}

	public Date getGradeUpDt() {
		return gradeUpDt;
	}

	public void setGradeUpDt(Date gradeUpDt) {
		this.gradeUpDt = gradeUpDt;
	}

	@Override
	public String toString() {
		return "AhnLevelupInfoVO [userGradeUpSeq=" + userGradeUpSeq + ", userSeq=" + userSeq + ", userGradeStatus="
				+ userGradeStatus + ", gradeReqDt=" + gradeReqDt + ", gradeUpDt=" + gradeUpDt + "]";
	}

	
	
}
