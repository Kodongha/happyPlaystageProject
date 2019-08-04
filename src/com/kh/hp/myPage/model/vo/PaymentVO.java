package com.kh.hp.myPage.model.vo;

import java.io.Serializable;

public class PaymentVO implements Serializable {

	private int propSeq;
	private String receiptId;
	private String status;
	private String amount;

	public PaymentVO() {
		// TODO Auto-generated constructor stub
	}

	public PaymentVO(int propSeq, String receiptId, String status, String amount) {
		super();
		this.propSeq = propSeq;
		this.receiptId = receiptId;
		this.status = status;
		this.amount = amount;
	}

	public int getPropSeq() {
		return propSeq;
	}

	public void setPropSeq(int propSeq) {
		this.propSeq = propSeq;
	}

	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentVO [propSeq=" + propSeq + ", receiptId=" + receiptId + ", status=" + status + ", amount="
				+ amount + "]";
	}

}
