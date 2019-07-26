package com.kh.hp.myPage.model.vo;

import java.sql.Date;

public class AhnAttachmentVO implements java.io.Serializable{
	
	private String originNm;
	private String changeNm;
	private String filePath;
	private Date uploadDt;
	private int fileType;
	private int rentSeq;
	private int propSeq;
	private int userSeq;
	private int subType;
	
	public AhnAttachmentVO() {}

	public AhnAttachmentVO(String originNm, String changeNm, String filePath, Date uploadDt, int fileType, int rentSeq,
			int propSeq, int userSeq, int subType) {
		super();
		this.originNm = originNm;
		this.changeNm = changeNm;
		this.filePath = filePath;
		this.uploadDt = uploadDt;
		this.fileType = fileType;
		this.rentSeq = rentSeq;
		this.propSeq = propSeq;
		this.userSeq = userSeq;
		this.subType = subType;
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

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public int getRentSeq() {
		return rentSeq;
	}

	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}

	public int getPropSeq() {
		return propSeq;
	}

	public void setPropSeq(int propSeq) {
		this.propSeq = propSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getSubType() {
		return subType;
	}

	public void setSubType(int subType) {
		this.subType = subType;
	}

	@Override
	public String toString() {
		return "AhnAttachmentVO [originNm=" + originNm + ", changeNm=" + changeNm + ", filePath=" + filePath
				+ ", uploadDt=" + uploadDt + ", fileType=" + fileType + ", rentSeq=" + rentSeq + ", propSeq=" + propSeq
				+ ", userSeq=" + userSeq + ", subType=" + subType + "]";
	}
	
	
}
