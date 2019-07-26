package com.kh.hp.rent.model.vo;

public class DetFacAndRentDetFacVO {

	private int detFacSeq;
	private String DetFacNm;
	private String DetFacImgPath;

	private int rentDetFacSeq;
	private int rentSeq;

	public DetFacAndRentDetFacVO() {
		// TODO Auto-generated constructor stub
	}

	public DetFacAndRentDetFacVO(int detFacSeq, String detFacNm, String detFacImgPath, int rentDetFacSeq, int rentSeq) {
		super();
		this.detFacSeq = detFacSeq;
		DetFacNm = detFacNm;
		DetFacImgPath = detFacImgPath;
		this.rentDetFacSeq = rentDetFacSeq;
		this.rentSeq = rentSeq;
	}

	public int getDetFacSeq() {
		return detFacSeq;
	}

	public void setDetFacSeq(int detFacSeq) {
		this.detFacSeq = detFacSeq;
	}

	public String getDetFacNm() {
		return DetFacNm;
	}

	public void setDetFacNm(String detFacNm) {
		DetFacNm = detFacNm;
	}

	public String getDetFacImgPath() {
		return DetFacImgPath;
	}

	public void setDetFacImgPath(String detFacImgPath) {
		DetFacImgPath = detFacImgPath;
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

	@Override
	public String toString() {
		return "DetFacAndRentDetFacVO [detFacSeq=" + detFacSeq + ", DetFacNm=" + DetFacNm + ", DetFacImgPath="
				+ DetFacImgPath + ", rentDetFacSeq=" + rentDetFacSeq + ", rentSeq=" + rentSeq + "]";
	}

}
