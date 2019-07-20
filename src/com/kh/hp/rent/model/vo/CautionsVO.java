package com.kh.hp.rent.model.vo;

import java.io.Serializable;

public class CautionsVO implements Serializable {

	private int cautionSeq;
	private int rentSeq;
	private int cautionNo;
	private String cautionContent;

	public CautionsVO() {
		// TODO Auto-generated constructor stub
	}

	public CautionsVO(int cautionSeq, int rentSeq, int cautionNo, String cautionContent) {
		super();
		this.cautionSeq = cautionSeq;
		this.rentSeq = rentSeq;
		this.cautionNo = cautionNo;
		this.cautionContent = cautionContent;
	}

	public int getCautionSeq() {
		return cautionSeq;
	}

	public void setCautionSeq(int cautionSeq) {
		this.cautionSeq = cautionSeq;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public int getCautionNo() {
		return cautionNo;
	}

	public void setCautionNo(int cautionNo) {
		this.cautionNo = cautionNo;
	}

	public String getCautionContent() {
		return cautionContent;
	}

	public void setCautionContent(String cautionContent) {
		this.cautionContent = cautionContent;
	}

	@Override
	public String toString() {
		return "CautionsVO [cautionSeq=" + cautionSeq + ", rentSeq=" + rentSeq + ", cautionNo=" + cautionNo
				+ ", cautionContent=" + cautionContent + "]";
	}

}
