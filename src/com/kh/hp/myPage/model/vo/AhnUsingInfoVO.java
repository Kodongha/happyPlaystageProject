package com.kh.hp.myPage.model.vo;

import java.sql.Date;

public class AhnUsingInfoVO implements java.io.Serializable{
	private int rentSeq;
	private String propNm;
	private String propEmail;
	private Date useStartDt;
	
	public AhnUsingInfoVO() {}

	public AhnUsingInfoVO(int rentSeq, String propNm, String propEmail, Date useStartDt) {
		super();
		this.rentSeq = rentSeq;
		this.propNm = propNm;
		this.propEmail = propEmail;
		this.useStartDt = useStartDt;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public String getPropNm() {
		return propNm;
	}

	public void setPropNm(String propNm) {
		this.propNm = propNm;
	}

	public String getPropEmail() {
		return propEmail;
	}

	public void setPropEmail(String propEmail) {
		this.propEmail = propEmail;
	}

	public Date getUseStartDt() {
		return useStartDt;
	}

	public void setUseStartDt(Date useStartDt) {
		this.useStartDt = useStartDt;
	}

	@Override
	public String toString() {
		return "AhnUsingInfoVO [rentSeq=" + rentSeq + ", propNm=" + propNm + ", propEmail=" + propEmail
				+ ", useStartDt=" + useStartDt + "]";
	}
	
	
}
