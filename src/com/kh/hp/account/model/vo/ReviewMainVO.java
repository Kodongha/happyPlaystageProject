package com.kh.hp.account.model.vo;

import java.io.Serializable;

public class ReviewMainVO implements Serializable {

	private String hallNm;
	private String address;
	private int rating;
	private String reviewContent;
	private String changeNm;
	
	public ReviewMainVO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewMainVO(String hallNm, String address, int rating, String reviewContent, String changeNm) {
		super();
		this.hallNm = hallNm;
		this.address = address;
		this.rating = rating;
		this.reviewContent = reviewContent;
		this.changeNm = changeNm;
	}

	public String getHallNm() {
		return hallNm;
	}

	public void setHallNm(String hallNm) {
		this.hallNm = hallNm;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getChangeNm() {
		return changeNm;
	}

	public void setChangeNm(String changeNm) {
		this.changeNm = changeNm;
	}

	@Override
	public String toString() {
		return "ReviewMainVO [hallNm=" + hallNm + ", address=" + address + ", rating=" + rating + ", reviewContent="
				+ reviewContent + ", changeNm=" + changeNm + "]";
	}
	
}
