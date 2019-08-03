package com.kh.hp.myPage.model.vo;

import java.sql.Date;

public class AhnApplyChangeVO implements java.io.Serializable{
	private Date propUpdateDt;
	private int propUpdateSeq;
	private String propUpdateStatus;
	private String cancleReason;
	private int propSeq;
	
	public AhnApplyChangeVO() {}

	public AhnApplyChangeVO(Date propUpdateDt, int propUpdateSeq, String propUpdateStatus, String cancleReason,
			int propSeq) {
		super();
		this.propUpdateDt = propUpdateDt;
		this.propUpdateSeq = propUpdateSeq;
		this.propUpdateStatus = propUpdateStatus;
		this.cancleReason = cancleReason;
		this.propSeq = propSeq;
	}

	public Date getPropUpdateDt() {
		return propUpdateDt;
	}

	public void setPropUpdateDt(Date propUpdateDt) {
		this.propUpdateDt = propUpdateDt;
	}

	public int getPropUpdateSeq() {
		return propUpdateSeq;
	}

	public void setPropUpdateSeq(int propUpdateSeq) {
		this.propUpdateSeq = propUpdateSeq;
	}

	public String getPropUpdateStatus() {
		return propUpdateStatus;
	}

	public void setPropUpdateStatus(String propUpdateStatus) {
		this.propUpdateStatus = propUpdateStatus;
	}

	public String getCancleReason() {
		return cancleReason;
	}

	public void setCancleReason(String cancleReason) {
		this.cancleReason = cancleReason;
	}

	public int getPropSeq() {
		return propSeq;
	}

	public void setPropSeq(int propSeq) {
		this.propSeq = propSeq;
	}

	@Override
	public String toString() {
		return "AhnApplyChangeVO [propUpdateDt=" + propUpdateDt + ", propUpdateSeq=" + propUpdateSeq
				+ ", propUpdateStatus=" + propUpdateStatus + ", cancleReason=" + cancleReason + ", propSeq=" + propSeq
				+ "]";
	}
	
	
	
}
