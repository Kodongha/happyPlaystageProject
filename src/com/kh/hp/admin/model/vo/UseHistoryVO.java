package com.kh.hp.admin.model.vo;

import java.sql.Date;

public class UseHistoryVO  implements java.io.Serializable{

	private int rentSeq;
	private int userSeq;
	private String hallNm;
	private String compNm;
	private String getpropStatus;
	private Date useStartDt;
	private Date useEndDt;
	
	public UseHistoryVO () {}

	public UseHistoryVO(int rentSeq, int userSeq, String hallNm, String compNm, String getpropStatus, Date useStartDt,
			Date useEndDt) {
		super();
		this.rentSeq = rentSeq;
		this.userSeq = userSeq;
		this.hallNm = hallNm;
		this.compNm = compNm;
		this.getpropStatus = getpropStatus;
		this.useStartDt = useStartDt;
		this.useEndDt = useEndDt;
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

	public String getHallNm() {
		return hallNm;
	}

	public void setHallNm(String hallNm) {
		this.hallNm = hallNm;
	}

	public String getCompNm() {
		return compNm;
	}

	public void setCompNm(String compNm) {
		this.compNm = compNm;
	}

	public String getGetpropStatus() {
		return getpropStatus;
	}

	public void setGetpropStatus(String getpropStatus) {
		this.getpropStatus = getpropStatus;
	}

	public Date getUseStartDt() {
		return useStartDt;
	}

	public void setUseStartDt(Date useStartDt) {
		this.useStartDt = useStartDt;
	}

	public Date getUseEndDt() {
		return useEndDt;
	}

	public void setUseEndDt(Date useEndDt) {
		this.useEndDt = useEndDt;
	}

	@Override
	public String toString() {
		return "UseHistoryVO [rentSeq=" + rentSeq + ", userSeq=" + userSeq + ", hallNm=" + hallNm + ", compNm=" + compNm
				+ ", getpropStatus=" + getpropStatus + ", useStartDt=" + useStartDt + ", useEndDt=" + useEndDt + "]";
	}


	
	
	
}

