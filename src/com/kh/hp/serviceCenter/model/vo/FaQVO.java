package com.kh.hp.serviceCenter.model.vo;

public class FaQVO implements java.io.Serializable{
	private int fnqSeq;
	private String fnqCate;
	private String fnqQuestion;
	private String fnqAnswer;

	public FaQVO() {}

	public FaQVO(int fnqSeq, String fnqCate, String fnqQuestion, String fnqAnswer) {
		super();
		this.fnqSeq = fnqSeq;
		this.fnqCate = fnqCate;
		this.fnqQuestion = fnqQuestion;
		this.fnqAnswer = fnqAnswer;
	}

	public int getFnqSeq() {
		return fnqSeq;
	}

	public void setFnqSeq(int fnqSeq) {
		this.fnqSeq = fnqSeq;
	}

	public String getFnqCate() {
		return fnqCate;
	}

	public void setFnqCate(String fnqCate) {
		this.fnqCate = fnqCate;
	}

	public String getFnqQuestion() {
		return fnqQuestion;
	}

	public void setFnqQuestion(String fnqQuestion) {
		this.fnqQuestion = fnqQuestion;
	}

	public String getFnqAnswer() {
		return fnqAnswer;
	}

	public void setFnqAnswer(String fnqAnswer) {
		this.fnqAnswer = fnqAnswer;
	}

	@Override
	public String toString() {
		return "FaQVO [fnqSeq=" + fnqSeq + ", fnqCate=" + fnqCate + ", fnqQuestion=" + fnqQuestion + ", fnqAnswer="
				+ fnqAnswer + "]";
	}


}
