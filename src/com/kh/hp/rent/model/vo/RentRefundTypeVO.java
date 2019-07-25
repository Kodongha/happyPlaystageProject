package com.kh.hp.rent.model.vo;

import java.io.Serializable;

public class RentRefundTypeVO implements Serializable {

	private int rentRefundTypeSeq;
	private int refundSeq;
	private int rentSeq;
	private int dtCd;
	private int refundDeductPer;

	public RentRefundTypeVO() {
		// TODO Auto-generated constructor stub
	}

	public RentRefundTypeVO(int rentRefundTypeSeq, int refundSeq, int rentSeq, int dtCd, int refundDeductPer) {
		super();
		this.rentRefundTypeSeq = rentRefundTypeSeq;
		this.refundSeq = refundSeq;
		this.rentSeq = rentSeq;
		this.dtCd = dtCd;
		this.refundDeductPer = refundDeductPer;
	}

	public int getRentRefundTypeSeq() {
		return rentRefundTypeSeq;
	}

	public void setRentRefundTypeSeq(int rentRefundTypeSeq) {
		this.rentRefundTypeSeq = rentRefundTypeSeq;
	}

	public int getRefundSeq() {
		return refundSeq;
	}

	public void setRefundSeq(int refundSeq) {
		this.refundSeq = refundSeq;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public int getDtCd() {
		return dtCd;
	}

	public void setDtCd(int dtCd) {
		this.dtCd = dtCd;
	}

	public int getRefundDeductPer() {
		return refundDeductPer;
	}

	public void setRefundDeductPer(int refundDeductPer) {
		this.refundDeductPer = refundDeductPer;
	}

	@Override
	public String toString() {
		return "RentRefundTypeVO [rentRefundTypeSeq=" + rentRefundTypeSeq + ", refundSeq=" + refundSeq + ", rentSeq="
				+ rentSeq + ", dtCd=" + dtCd + ", refundDeductPer=" + refundDeductPer + "]";
	}

}
