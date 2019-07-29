package com.kh.hp.admin.model.vo;

public class DetailInspectionVO {
	
	private int userSeq;
	private int rentSeq;
	private String rentNm;
	private String hallDetIntro;
	private String cautionContent ;
	private String website;
	private String rentEnrollStatus;
	private String address;
	private char inspTf;
	
	public DetailInspectionVO () {}

	public DetailInspectionVO(int userSeq, int rentSeq, String rentNm, String hallDetIntro, String cautionContent,
			String website, String rentEnrollStatus, String address, char inspTf) {
		super();
		this.userSeq = userSeq;
		this.rentSeq = rentSeq;
		this.rentNm = rentNm;
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

	public String getRentNm() {
		return rentNm;
	}

	public void setRentNm(String rentNm) {
		this.rentNm = rentNm;
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

	public char getInspTf() {
		return inspTf;
	}

	public void setInspTf(char inspTf) {
		this.inspTf = inspTf;
	}

	@Override
	public String toString() {
		return "DetailInspectionVO [userSeq=" + userSeq + ", rentSeq=" + rentSeq + ", rentNm=" + rentNm
				+ ", hallDetIntro=" + hallDetIntro + ", cautionContent=" + cautionContent + ", website=" + website
				+ ", rentEnrollStatus=" + rentEnrollStatus + ", address=" + address + ", inspTf=" + inspTf + "]";
	}

	
}