package com.kh.hp.admin.model.vo;

public class DetailInspectionVO {
	
	private int userSeq;
	private int rentSeq;
	private String hallNm;
	private String hallDetIntro;
	private String cautionContent ;
	private String website;
	private String rentEnrollStatus;
	private String address;
	private String inspTf;
	
	public DetailInspectionVO () {}

	public DetailInspectionVO(int userSeq, int rentSeq, String hallNm, String hallDetIntro, String cautionContent,
			String website, String rentEnrollStatus, String address, String inspTf) {
		super();
		this.userSeq = userSeq;
		this.rentSeq = rentSeq;
		this.hallNm = hallNm;
		this.hallDetIntro = hallDetIntro;
		this.cautionContent = cautionContent;
		this.website = website;
		this.rentEnrollStatus = rentEnrollStatus;
		this.address = address;
		this.inspTf = inspTf;
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

	public String getHallDetIntro() {
		return hallDetIntro;
	}

	public void setHallDetIntro(String hallDetIntro) {
		this.hallDetIntro = hallDetIntro;
	}

	public String getCautionContent() {
		return cautionContent;
	}

	public void setCautionContent(String cautionContent) {
		this.cautionContent = cautionContent;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getRentEnrollStatus() {
		return rentEnrollStatus;
	}

	public void setRentEnrollStatus(String rentEnrollStatus) {
		this.rentEnrollStatus = rentEnrollStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInspTf() {
		return inspTf;
	}

	public void setInspTf(String inspTf) {
		this.inspTf = inspTf;
	}

	@Override
	public String toString() {
		return "DetailInspectionVO [userSeq=" + userSeq + ", rentSeq=" + rentSeq + ", hallNm=" + hallNm
				+ ", hallDetIntro=" + hallDetIntro + ", cautionContent=" + cautionContent + ", website=" + website
				+ ", rentEnrollStatus=" + rentEnrollStatus + ", address=" + address + ", inspTf=" + inspTf + "]";
	}

	
	
}