package com.kh.hp.serviceCenter.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable{
	private int noticeSeq;
	private String noticeCate;
	private String noticeTitle;
	private String noticeContent;
	private int userSeq;
	private Date noticeWrDt;

	public Notice() {}

	public Notice(int noticeSeq, String noticeCate, String noticeTitle, String noticeContent, int userSeq,
			Date noticeWrDt) {
		super();
		this.noticeSeq = noticeSeq;
		this.noticeCate = noticeCate;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.userSeq = userSeq;
		this.noticeWrDt = noticeWrDt;
	}

	public int getNoticeSeq() {
		return noticeSeq;
	}

	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}

	public String getNoticeCate() {
		return noticeCate;
	}

	public void setNoticeCate(String noticeCate) {
		this.noticeCate = noticeCate;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public Date getNoticeWrDt() {
		return noticeWrDt;
	}

	public void setNoticeWrDt(Date noticeWrDt) {
		this.noticeWrDt = noticeWrDt;
	}

	@Override
	public String toString() {
		return "Notice [noticeSeq=" + noticeSeq + ", noticeCate=" + noticeCate + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", userSeq=" + userSeq + ", noticeWrDt=" + noticeWrDt + "]";
	}



}
