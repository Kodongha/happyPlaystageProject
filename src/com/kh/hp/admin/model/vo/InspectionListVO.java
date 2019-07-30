package com.kh.hp.admin.model.vo;

public class InspectionListVO {
	
	private int rentSeq;
	private String hallNm;
	private String rentEmail;
	private String rentMainTel;
	private String originNm;
	private String  inspTf;
	
	public InspectionListVO () {}

	public InspectionListVO(int rentSeq, String hallNm, String rentEmail, String rentMainTel, String originNm,
			String inspTf) {
		super();
		this.rentSeq = rentSeq;
		this.hallNm = hallNm;
		this.rentEmail = rentEmail;
		this.rentMainTel = rentMainTel;
		this.originNm = originNm;
		this.inspTf = inspTf;
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

	public String getRentEmail() {
		return rentEmail;
	}

	public void setRentEmail(String rentEmail) {
		this.rentEmail = rentEmail;
	}

	public String getRentMainTel() {
		return rentMainTel;
	}

	public void setRentMainTel(String rentMainTel) {
		this.rentMainTel = rentMainTel;
	}

	public String getOriginNm() {
		return originNm;
	}

	public void setOriginNm(String originNm) {
		this.originNm = originNm;
	}

	public String getInspTf() {
		return inspTf;
	}

	public void setInspTf(String inspTf) {
		this.inspTf = inspTf;
	}

	@Override
	public String toString() {
		return "InspectionListVO [rentSeq=" + rentSeq + ", hallNm=" + hallNm + ", rentEmail=" + rentEmail
				+ ", rentMainTel=" + rentMainTel + ", originNm=" + originNm + ", inspTf=" + inspTf + "]";
	} 
	
	
	
}
