package com.kh.hp.admin.model.vo;

public class InspectionListVO {
	
	private int userSeq;
	private int  rentSeq;
	private String hallNm;
	private String userEmail;
	private String userPhone;
	private String originNm;
	private char  inspTf;
	private String rentEnrollStatus;

	public InspectionListVO () {}

	public InspectionListVO(int userSeq, int rentSeq, String hallNm, String userEmail, String userPhone,
			String originNm, char inspTf, String rentEnrollStatus) {
		super();
		this.userSeq = userSeq;
		this.rentSeq = rentSeq;
		this.hallNm = hallNm;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.originNm = originNm;
		this.inspTf = inspTf;
		this.rentEnrollStatus = rentEnrollStatus;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getOriginNm() {
		return originNm;
	}

	public void setOriginNm(String originNm) {
		this.originNm = originNm;
	}

	public char getInspTf() {
		return inspTf;
	}

	public void setInspTf(char inspTf) {
		this.inspTf = inspTf;
	}

	public String getRentEnrollStatus() {
		return rentEnrollStatus;
	}

	public void setRentEnrollStatus(String rentEnrollStatus) {
		this.rentEnrollStatus = rentEnrollStatus;
	}

	@Override
	public String toString() {
		return "InspectionListVO [userSeq=" + userSeq + ", rentSeq=" + rentSeq + ", hallNm=" + hallNm + ", userEmail="
				+ userEmail + ", userPhone=" + userPhone + ", originNm=" + originNm + ", inspTf=" + inspTf
				+ ", rentEnrollStatus=" + rentEnrollStatus + "]";
	}
	
	

}
