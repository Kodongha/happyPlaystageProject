package com.kh.hp.admin.model.vo;

import java.sql.Date;

public class EnrollHistoryVO  implements java.io.Serializable{
	
	private int userSeq; // 회원번호 
	private int rentSeq; // 공연장고유번호
	private String hallNm; //공연장명
	private String compNm; //상호명 
	private String address; //주소
	private Date rentEnrollDt; //등록일
	private String rentEnrollStatus; //대관등록진행상태
	private String userNm; //작성자
	
	public EnrollHistoryVO () {}

	public EnrollHistoryVO(int userSeq, int rentSeq, String hallNm, String compNm, String address, Date rentEnrollDt,
			String rentEnrollStatus, String userNm) {
		super();
		this.userSeq = userSeq;
		this.rentSeq = rentSeq;
		this.hallNm = hallNm;
		this.compNm = compNm;
		this.address = address;
		this.rentEnrollDt = rentEnrollDt;
		this.rentEnrollStatus = rentEnrollStatus;
		this.userNm = userNm;
	}

	@Override
	public String toString() {
		return "EnrollHistoryVO [userSeq=" + userSeq + ", rentSeq=" + rentSeq + ", hallNm=" + hallNm + ", compNm="
				+ compNm + ", address=" + address + ", rentEnrollDt=" + rentEnrollDt + ", rentEnrollStatus="
				+ rentEnrollStatus + ", userNm=" + userNm + "]";
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public String getHallNm() {
		return hallNm;
	}

	public void setHallNm(String hallNm) {
		this.hallNm = hallNm;
	}

	public String getCompNm() {
		return compNm;
	}

	public void setCompNm(String compNm) {
		this.compNm = compNm;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRentEnrollDt() {
		return rentEnrollDt;
	}

	public void setRentEnrollDt(Date rentEnrollDt) {
		this.rentEnrollDt = rentEnrollDt;
	}

	public String getRentEnrollStatus() {
		return rentEnrollStatus;
	}

	public void setRentEnrollStatus(String rentEnrollStatus) {
		this.rentEnrollStatus = rentEnrollStatus;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}






}