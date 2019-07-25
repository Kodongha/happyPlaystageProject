package com.kh.hp.account.model.vo;

import java.sql.Date;

public class ReviewVO {

	
	private int reviewSeq;
	private String reviewContent;
	private int ran;
	private Date reviewWrDt;
	private int ropSeq;
	private int userSeq;
	private int rentSeq;
	
	
	public ReviewVO() {}


	public ReviewVO(int reviewSeq, String reviewContent, int ran, Date reviewWrDt, int ropSeq, int userSeq,
			int rentSeq) {
		super();
		this.reviewSeq = reviewSeq;
		this.reviewContent = reviewContent;
		this.ran = ran;
		this.reviewWrDt = reviewWrDt;
		this.ropSeq = ropSeq;
		this.userSeq = userSeq;
		this.rentSeq = rentSeq;
	}


	public int getReviewSeq() {
		return reviewSeq;
	}


	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
	}


	public String getReviewContent() {
		return reviewContent;
	}


	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}


	public int getRan() {
		return ran;
	}


	public void setRan(int ran) {
		this.ran = ran;
	}


	public Date getReviewWrDt() {
		return reviewWrDt;
	}


	public void setReviewWrDt(Date reviewWrDt) {
		this.reviewWrDt = reviewWrDt;
	}


	public int getRopSeq() {
		return ropSeq;
	}


	public void setRopSeq(int ropSeq) {
		this.ropSeq = ropSeq;
	}


	public int getUserSeq() {
		return userSeq;
	}


	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}


	public int getRentSeq() {
		return rentSeq;
	}


	public void setRentSeq(int rentSeq) {
		this.rentSeq = rentSeq;
	}


	@Override
	public String toString() {
		return "ReviewVO [reviewSeq=" + reviewSeq + ", reviewContent=" + reviewContent + ", ran=" + ran
				+ ", reviewWrDt=" + reviewWrDt + ", ropSeq=" + ropSeq + ", userSeq=" + userSeq + ", rentSeq=" + rentSeq
				+ "]";
	}
	
	
	
}
