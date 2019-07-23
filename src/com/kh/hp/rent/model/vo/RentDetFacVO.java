package com.kh.hp.rent.model.vo;

import java.io.Serializable;

public class RentDetFacVO implements Serializable{

	private int rentDetFacSeq;
	private int rentSeq;
	private int detFacSeq;

	public RentDetFacVO() {
		// TODO Auto-generated constructor stub
	}

	public RentDetFacVO(int rentDetFacSeq, int rentSeq, int detFacSeq) {
		super();
		this.rentDetFacSeq = rentDetFacSeq;
		this.rentSeq = rentSeq;
		this.detFacSeq = detFacSeq;
	}

	public int getRentDetFacSeq() {
		return rentDetFacSeq;
	}

	public void setRentDetFacSeq(int rentDetFacSeq) {
		this.rentDetFacSeq = rentDetFacSeq;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public int getDetFacSeq() {
		return detFacSeq;
	}

	public void setDetFacSeq(int detFacSeq) {
		this.detFacSeq = detFacSeq;
	}

	@Override
	public String toString() {
		return "RentDetFac [rentDetFacSeq=" + rentDetFacSeq + ", rentSeq=" + rentSeq + ", detFacSeq=" + detFacSeq + "]";
	}

}
