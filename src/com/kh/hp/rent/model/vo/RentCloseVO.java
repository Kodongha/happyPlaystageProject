package com.kh.hp.rent.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class RentCloseVO implements Serializable {

	private int rentCloseSeq;
	private int regCloseCd;
	private String cusCloseNm;
	private Date cusCloseStart;
	private Date cusCloseEnd;
	private String cusCloseWeekOkDay;
	private String regCloseWeekOfDay;
	private String regCloseDt;
	private int rentSeq;

	public RentCloseVO() {
		// TODO Auto-generated constructor stub
	}

	public RentCloseVO(int rentCloseSeq, int regCloseCd, String cusCloseNm, Date cusCloseStart, Date cusCloseEnd,
			String cusCloseWeekOkDay, String regCloseWeekOfDay, String regCloseDt, int rentSeq) {
		super();
		this.rentCloseSeq = rentCloseSeq;
		this.regCloseCd = regCloseCd;
		this.cusCloseNm = cusCloseNm;
		this.cusCloseStart = cusCloseStart;
		this.cusCloseEnd = cusCloseEnd;
		this.cusCloseWeekOkDay = cusCloseWeekOkDay;
		this.regCloseWeekOfDay = regCloseWeekOfDay;
		this.regCloseDt = regCloseDt;
		this.rentSeq = rentSeq;
	}

	public int getRentCloseSeq() {
		return rentCloseSeq;
	}

	public void setRentCloseSeq(int rentCloseSeq) {
		this.rentCloseSeq = rentCloseSeq;
	}

	public int getRegCloseCd() {
		return regCloseCd;
	}

	public void setRegCloseCd(int regCloseCd) {
		this.regCloseCd = regCloseCd;
	}

	public String getCusCloseNm() {
		return cusCloseNm;
	}

	public void setCusCloseNm(String cusCloseNm) {
		this.cusCloseNm = cusCloseNm;
	}

	public Date getCusCloseStart() {
		return cusCloseStart;
	}

	public void setCusCloseStart(Date cusCloseStart) {
		this.cusCloseStart = cusCloseStart;
	}

	public Date getCusCloseEnd() {
		return cusCloseEnd;
	}

	public void setCusCloseEnd(Date cusCloseEnd) {
		this.cusCloseEnd = cusCloseEnd;
	}

	public String getCusCloseWeekOkDay() {
		return cusCloseWeekOkDay;
	}

	public void setCusCloseWeekOkDay(String cusCloseWeekOkDay) {
		this.cusCloseWeekOkDay = cusCloseWeekOkDay;
	}

	public String getRegCloseWeekOfDay() {
		return regCloseWeekOfDay;
	}

	public void setRegCloseWeekOfDay(String regCloseWeekOfDay) {
		this.regCloseWeekOfDay = regCloseWeekOfDay;
	}

	public String getRegCloseDt() {
		return regCloseDt;
	}

	public void setRegCloseDt(String regCloseDt) {
		this.regCloseDt = regCloseDt;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	@Override
	public String toString() {
		return "RentCloseVO [rentCloseSeq=" + rentCloseSeq + ", regCloseCd=" + regCloseCd + ", cusCloseNm=" + cusCloseNm
				+ ", cusCloseStart=" + cusCloseStart + ", cusCloseEnd=" + cusCloseEnd + ", cusCloseWeekOkDay="
				+ cusCloseWeekOkDay + ", regCloseWeekOfDay=" + regCloseWeekOfDay + ", regCloseDt=" + regCloseDt
				+ ", rentSeq=" + rentSeq + "]";
	}

}
