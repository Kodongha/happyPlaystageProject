package com.kh.hp.myPage.model.vo;

import java.util.Date;

public class AttachmentMH {
	private int userSeq;
	private String originNm;
	private String changeNm;
	private String filePath;
	private Date uploadDt;

	public AttachmentMH() {}

	public AttachmentMH(int userSeq, String originNm, String changeNm, String filePath, Date uploadDt) {
		super();
		this.userSeq = userSeq;
		this.originNm = originNm;
		this.changeNm = changeNm;
		this.filePath = filePath;
		this.uploadDt = uploadDt;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
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
		return "AttachmentMH [userSeq=" + userSeq + ", originNm=" + originNm + ", changeNm=" + changeNm + ", filePath="
				+ filePath + ", uploadDt=" + uploadDt + "]";
	}




}
