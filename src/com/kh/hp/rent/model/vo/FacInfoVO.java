package com.kh.hp.rent.model.vo;

import java.io.Serializable;

public class FacInfoVO implements Serializable {

	private int facSeq;
	private int rentSeq;
	private int facInfoNo;
	private String facInfoContent;

	public FacInfoVO() {
		// TODO Auto-generated constructor stub
	}

	public FacInfoVO(int facSeq, int rentSeq, int facInfoNo, String facInfoContent) {
		super();
		this.facSeq = facSeq;
		this.rentSeq = rentSeq;
		this.facInfoNo = facInfoNo;
		this.facInfoContent = facInfoContent;
	}

	public int getFacSeq() {
		return facSeq;
	}

	public void setFacSeq(int facSeq) {
		this.facSeq = facSeq;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public int getFacInfoNo() {
		return facInfoNo;
	}

	public void setFacInfoNo(int facInfoNo) {
		this.facInfoNo = facInfoNo;
	}

	public String getFacInfoContent() {
		return facInfoContent;
	}

	public void setFacInfoContent(String facInfoContent) {
		this.facInfoContent = facInfoContent;
	}

	@Override
	public String toString() {
		return "FacInfoVO [facSeq=" + facSeq + ", rentSeq=" + rentSeq + ", facInfoNo=" + facInfoNo + ", facInfoContent="
				+ facInfoContent + "]";
	}

}
