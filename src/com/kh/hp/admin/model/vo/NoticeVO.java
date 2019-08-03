package com.kh.hp.admin.model.vo;

import java.sql.Date;

public class NoticeVO {
	
	private int noticeSeq;
	private String noticeCate;
	private String noticeTitile;
	private String noticeContent;
	private int userSeq;
	private Date noticeWrDt;
	private String noticeRemoveTf;
	
	public NoticeVO() {}

	public NoticeVO(int noticeSeq, String noticeCate, String noticeTitile, String noticeContent, int userSeq,
			Date noticeWrDt, String noticeRemoveTf) {
		super();
		this.noticeSeq = noticeSeq;
		this.noticeCate = noticeCate;
		this.noticeTitile = noticeTitile;
		this.noticeContent = noticeContent;
		this.userSeq = userSeq;
		this.noticeWrDt = noticeWrDt;
		this.noticeRemoveTf = noticeRemoveTf;
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

	public String getNoticeTitile() {
		return noticeTitile;
	}

	public void setNoticeTitile(String noticeTitile) {
		this.noticeTitile = noticeTitile;
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

	public String getNoticeRemoveTf() {
		return noticeRemoveTf;
	}

	public void setNoticeRemoveTf(String noticeRemoveTf) {
		this.noticeRemoveTf = noticeRemoveTf;
	}

	@Override
	public String toString() {
		return "NoticeVO [noticeSeq=" + noticeSeq + ", noticeCate=" + noticeCate + ", noticeTitile=" + noticeTitile
				+ ", noticeContent=" + noticeContent + ", userSeq=" + userSeq + ", noticeWrDt=" + noticeWrDt
				+ ", noticeRemoveTf=" + noticeRemoveTf + "]";
	}
	
	
	

}
