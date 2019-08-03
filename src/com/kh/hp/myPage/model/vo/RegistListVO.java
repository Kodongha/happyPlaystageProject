package com.kh.hp.myPage.model.vo;

import java.util.Date;

public class RegistListVO implements java.io.Serializable{
	private int rentSeq;
	private int userSeq;
	private String hallNm;
	private int imgType;
	private String filePath;
	private Date rentEnrollDt;

	public RegistListVO(){}

	public RegistListVO(int rentSeq, int userSeq, String hallNm, int imgType, String filePath, Date rentEnrollDt) {
		super();
		this.rentSeq = rentSeq;
		this.userSeq = userSeq;
		this.hallNm = hallNm;
		this.imgType = imgType;
		this.filePath = filePath;
		this.rentEnrollDt = rentEnrollDt;
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

	public int getImgType() {
		return imgType;
	}

	public void setImgType(int imgType) {
		this.imgType = imgType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getRentEnrollDt() {
		return rentEnrollDt;
	}

	public void setRentEnrollDt(Date rentEnrollDt) {
		this.rentEnrollDt = rentEnrollDt;
	}

	@Override
	public String toString() {
		return "RegistListVO [rentSeq=" + rentSeq + ", userSeq=" + userSeq + ", hallNm=" + hallNm + ", imgType="
				+ imgType + ", filePath=" + filePath + ", rentEnrollDt=" + rentEnrollDt + "]";
	}


}