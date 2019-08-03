package com.kh.hp.myPage.model.vo;

import java.sql.Date;

public class AhnPayRefundVO implements java.io.Serializable{
	private int paySeq;
	private String payReqStatus;
	private int payAmount;
	private int userSeq;
	private Date payReqDt;
	private int propSeq;
	private Date payTrxDt;
	
	public AhnPayRefundVO() {}

	public AhnPayRefundVO(int paySeq, String payReqStatus, int payAmount, int userSeq, Date payReqDt, int propSeq,
			Date payTrxDt) {
		super();
		this.paySeq = paySeq;
		this.payReqStatus = payReqStatus;
		this.payAmount = payAmount;
		this.userSeq = userSeq;
		this.payReqDt = payReqDt;
		this.propSeq = propSeq;
		this.payTrxDt = payTrxDt;
	}

	public int getPaySeq() {
		return paySeq;
	}

	public void setPaySeq(int paySeq) {
		this.paySeq = paySeq;
	}

	public String getPayReqStatus() {
		return payReqStatus;
	}

	public void setPayReqStatus(String payReqStatus) {
		this.payReqStatus = payReqStatus;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public Date getPayReqDt() {
		return payReqDt;
	}

	public void setPayReqDt(Date payReqDt) {
		this.payReqDt = payReqDt;
	}

	public int getPropSeq() {
		return propSeq;
	}

	public void setPropSeq(int propSeq) {
		this.propSeq = propSeq;
	}

	public Date getPayTrxDt() {
		return payTrxDt;
	}

	public void setPayTrxDt(Date payTrxDt) {
		this.payTrxDt = payTrxDt;
	}

	@Override
	public String toString() {
		return "AhnPayRefundVO [paySeq=" + paySeq + ", payReqStatus=" + payReqStatus + ", payAmount=" + payAmount
				+ ", userSeq=" + userSeq + ", payReqDt=" + payReqDt + ", propSeq=" + propSeq + ", payTrxDt=" + payTrxDt
				+ "]";
	}
	
	
}
