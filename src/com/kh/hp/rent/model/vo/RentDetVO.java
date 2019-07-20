package com.kh.hp.rent.model.vo;

import java.io.Serializable;

public class RentDetVO implements Serializable {

	private int rentDetSeq;
	private int rentSeq;
	private String detAddress;
	private int maxHeadCount;
	private int rentPrice;

	public RentDetVO() {
		// TODO Auto-generated constructor stub
	}

	public RentDetVO(int rentDetSeq, int rentSeq, String detAddress, int maxHeadCount, int rentPrice) {
		super();
		this.rentDetSeq = rentDetSeq;
		this.rentSeq = rentSeq;
		this.detAddress = detAddress;
		this.maxHeadCount = maxHeadCount;
		this.rentPrice = rentPrice;
	}

	public int getRentDetSeq() {
		return rentDetSeq;
	}

	public void setRentDetSeq(int rentDetSeq) {
		this.rentDetSeq = rentDetSeq;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public String getDetAddress() {
		return detAddress;
	}

	public void setDetAddress(String detAddress) {
		this.detAddress = detAddress;
	}

	public int getMaxHeadCount() {
		return maxHeadCount;
	}

	public void setMaxHeadCount(int maxHeadCount) {
		this.maxHeadCount = maxHeadCount;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	@Override
	public String toString() {
		return "RentDetVO [rentDetSeq=" + rentDetSeq + ", rentSeq=" + rentSeq + ", detAddress=" + detAddress
				+ ", maxHeadCount=" + maxHeadCount + ", rentPrice=" + rentPrice + "]";
	}
}
