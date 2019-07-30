package com.kh.hp.account.model.vo;

import java.sql.Date;

public class ReviewSearchVO  {
	private int propSeq;
	private int rentSeq;
	private int userSeq;
	private String propNm;
	private String propPhone;
	private String propEmail;
	private String propReqContent;
	private Date propDt;
	private String propStatus;
	private Date userStartDt;
	private Date userEndDt;
	private int useStartTm;
	private int useEndTm;
	private int payAmount;
	private String hallNm;

	public ReviewSearchVO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewSearchVO(int propSeq, int rentSeq, int userSeq, String propNm, String propPhone, String propEmail,
			String propReqContent, Date propDt, String propStatus, Date userStartDt, Date userEndDt, int useStartTm,
			int useEndTm, int payAmount, String hallNm) {
		super();
		this.propSeq = propSeq;
		this.rentSeq = rentSeq;
		this.userSeq = userSeq;
		this.propNm = propNm;
		this.propPhone = propPhone;
		this.propEmail = propEmail;
		this.propReqContent = propReqContent;
		this.propDt = propDt;
		this.propStatus = propStatus;
		this.userStartDt = userStartDt;
		this.userEndDt = userEndDt;
		this.useStartTm = useStartTm;
		this.useEndTm = useEndTm;
		this.payAmount = payAmount;
		this.hallNm = hallNm;
	}





	public String getHallNm() {
		return hallNm;
	}

	public void setHallNm(String hallNm) {
		this.hallNm = hallNm;
	}

	public int getPropSeq() {
		return propSeq;
	}

	public void setPropSeq(int propSeq) {
		this.propSeq = propSeq;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getPropNm() {
		return propNm;
	}

	public void setPropNm(String propNm) {
		this.propNm = propNm;
	}

	public String getPropPhone() {
		return propPhone;
	}

	public void setPropPhone(String propPhone) {
		this.propPhone = propPhone;
	}

	public String getPropEmail() {
		return propEmail;
	}

	public void setPropEmail(String propEmail) {
		this.propEmail = propEmail;
	}

	public String getPropReqContent() {
		return propReqContent;
	}

	public void setPropReqContent(String propReqContent) {
		this.propReqContent = propReqContent;
	}

	public Date getPropDt() {
		return propDt;
	}

	public void setPropDt(Date propDt) {
		this.propDt = propDt;
	}

	public String getPropStatus() {
		return propStatus;
	}

	public void setPropStatus(String propStatus) {
		this.propStatus = propStatus;
	}

	public Date getUserStartDt() {
		return userStartDt;
	}

	public void setUserStartDt(Date userStartDt) {
		this.userStartDt = userStartDt;
	}

	public Date getUserEndDt() {
		return userEndDt;
	}

	public void setUserEndDt(Date userEndDt) {
		this.userEndDt = userEndDt;
	}

	public int getUseStartTm() {
		return useStartTm;
	}

	public void setUseStartTm(int useStartTm) {
		this.useStartTm = useStartTm;
	}

	public int getUseEndTm() {
		return useEndTm;
	}

	public void setUseEndTm(int useEndTm) {
		this.useEndTm = useEndTm;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}

	@Override
	public String toString() {
		return "ReviewSearchVO [propSeq=" + propSeq + ", rentSeq=" + rentSeq + ", userSeq=" + userSeq + ", propNm="
				+ propNm + ", propPhone=" + propPhone + ", propEmail=" + propEmail + ", propReqContent="
				+ propReqContent + ", propDt=" + propDt + ", propStatus=" + propStatus + ", userStartDt=" + userStartDt
				+ ", userEndDt=" + userEndDt + ", useStartTm=" + useStartTm + ", useEndTm=" + useEndTm + ", payAmount="
				+ payAmount + ", hallNm=" + hallNm + "]";
	}






}
