package com.kh.hp.rent.model.vo;

import java.sql.Date;

public class RentImgVO {

	private int imgSeq;
	private int rentSeq;
	private int imgType;
	private String originNm;
	private String changeNm;
	private String filePath;
	private Date uploadDt;

	public RentImgVO() {
		// TODO Auto-generated constructor stub
	}

	public RentImgVO(int imgSeq, int rentSeq, int imgType, String originNm, String changeNm, String filePath,
			Date uploadDt) {
		super();
		this.imgSeq = imgSeq;
		this.rentSeq = rentSeq;
		this.imgType = imgType;
		this.originNm = originNm;
		this.changeNm = changeNm;
		this.filePath = filePath;
		this.uploadDt = uploadDt;
	}

	public int getImgSeq() {
		return imgSeq;
	}

	public void setImgSeq(int imgSeq) {
		this.imgSeq = imgSeq;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public int getImgType() {
		return imgType;
	}

	public void setImgType(int imgType) {
		this.imgType = imgType;
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

	public Date getUploadDt() {
		return uploadDt;
	}

	public void setUploadDt(Date uploadDt) {
		this.uploadDt = uploadDt;
	}

	@Override
	public String toString() {
		return "RentImgVO [imgSeq=" + imgSeq + ", rentSeq=" + rentSeq + ", imgType=" + imgType + ", originNm="
				+ originNm + ", changeNm=" + changeNm + ", filePath=" + filePath + ", uploadDt=" + uploadDt + "]";
	}

}
