package com.kh.hp.rent.model.vo;

public class DetFacVO {

	private int detFacSeq;
	private String DetFacNm;
	private String DetFacImgPath;

	public DetFacVO() {
		// TODO Auto-generated constructor stub
	}

	public DetFacVO(int detFacSeq, String detFacNm, String detFacImgPath) {
		super();
		this.detFacSeq = detFacSeq;
		DetFacNm = detFacNm;
		DetFacImgPath = detFacImgPath;
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

	@Override
	public String toString() {
		return "DetFacVO [detFacSeq=" + detFacSeq + ", DetFacNm=" + DetFacNm + ", DetFacImgPath=" + DetFacImgPath + "]";
	}

}
