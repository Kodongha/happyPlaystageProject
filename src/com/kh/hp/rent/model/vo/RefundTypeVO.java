package com.kh.hp.rent.model.vo;

import java.io.Serializable;

public class RefundTypeVO implements Serializable {

	private int refundSeq;
	private int refundType;
	private int dtCd;
	private int refundDeductPer;

	public RefundTypeVO() {
		// TODO Auto-generated constructor stub
	}

	public RefundTypeVO(int refundSeq, int refundType, int dtCd, int refundDeductPer) {
		super();
		this.refundSeq = refundSeq;
		this.refundType = refundType;
		this.dtCd = dtCd;
		this.refundDeductPer = refundDeductPer;
	}

	public int getRefundSeq() {
		return refundSeq;
	}

	public void setRefundSeq(int refundSeq) {
		this.refundSeq = refundSeq;
	}

	public int getRefundType() {
		return refundType;
	}

	public void setRefundType(int refundType) {
		this.refundType = refundType;
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
		return "RefundType [refundSeq=" + refundSeq + ", refundType=" + refundType + ", dtCd=" + dtCd
				+ ", refundDeductPer=" + refundDeductPer + "]";
	}

}
