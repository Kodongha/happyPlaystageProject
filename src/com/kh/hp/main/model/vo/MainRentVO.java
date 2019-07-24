package com.kh.hp.main.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class MainRentVO implements Serializable {

	private int seq;
	private int rentSeq;
	private String hallNm;
	private String address;
	private Date rentEnrollDt;
	private int rentPrice;
	private String originNm;
	private String changeNm;
	private String filePath;

	public MainRentVO() {
		// TODO Auto-generated constructor stub
	}

	public MainRentVO(int seq, int rentSeq, String hallNm, String address, Date rentEnrollDt, int rentPrice,
			String originNm, String changeNm, String filePath) {
		super();
		this.seq = seq;
		this.rentSeq = rentSeq;
		this.hallNm = hallNm;
		this.address = address;
		this.rentEnrollDt = rentEnrollDt;
		this.rentPrice = rentPrice;
		this.originNm = originNm;
		this.changeNm = changeNm;
		this.filePath = filePath;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public String getHallNm() {
		return hallNm;
	}

	public void setHallNm(String hallNm) {
		this.hallNm = hallNm;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRentEnrollDt() {
		return rentEnrollDt;
	}

	public void setRentEnrollDt(Date rentEnrollDt) {
		this.rentEnrollDt = rentEnrollDt;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getOriginNm() {
		return originNm;
	}

	public void setOriginNm(String originNm) {
		this.originNm = originNm;
	}

	public String getChangeNm() {
		return changeNm;
	}

	public void setChangeNm(String changeNm) {
		this.changeNm = changeNm;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "MainRentVO [seq=" + seq + ", rentSeq=" + rentSeq + ", hallNm=" + hallNm + ", address=" + address
				+ ", rentEnrollDt=" + rentEnrollDt + ", rentPrice=" + rentPrice + ", originNm=" + originNm
				+ ", changeNm=" + changeNm + ", filePath=" + filePath + "]";
	}

}
