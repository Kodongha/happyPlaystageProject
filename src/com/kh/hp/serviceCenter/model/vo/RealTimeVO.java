package com.kh.hp.serviceCenter.model.vo;

import java.io.Serializable;
import java.util.Date;

public class RealTimeVO implements Serializable {

	// REALTIME_QNA
	private int chatSeq;
	private String rcvMsg;
	private String sendMsg;
	private int adminNo;
	private Date charDate;

	// REALTIME_QNA_ROOM
	private int roomSeq;
	private int userSeq;
	private int status;
	private Date lastRcvDate;

	public RealTimeVO() {
		// TODO Auto-generated constructor stub
	}

	public RealTimeVO(int chatSeq, String rcvMsg, String sendMsg, int adminNo, Date charDate, int roomSeq, int userSeq,
			int status, Date lastRcvDate) {
		super();
		this.chatSeq = chatSeq;
		this.rcvMsg = rcvMsg;
		this.sendMsg = sendMsg;
		this.adminNo = adminNo;
		this.charDate = charDate;
		this.roomSeq = roomSeq;
		this.userSeq = userSeq;
		this.status = status;
		this.lastRcvDate = lastRcvDate;
	}

	public int getChatSeq() {
		return chatSeq;
	}

	public void setChatSeq(int chatSeq) {
		this.chatSeq = chatSeq;
	}

	public String getRcvMsg() {
		return rcvMsg;
	}

	public void setRcvMsg(String rcvMsg) {
		this.rcvMsg = rcvMsg;
	}

	public String getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(String sendMsg) {
		this.sendMsg = sendMsg;
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public Date getCharDate() {
		return charDate;
	}

	public void setCharDate(Date charDate) {
		this.charDate = charDate;
	}

	public int getRoomSeq() {
		return roomSeq;
	}

	public void setRoomSeq(int roomSeq) {
		this.roomSeq = roomSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getLastRcvDate() {
		return lastRcvDate;
	}

	public void setLastRcvDate(Date lastRcvDate) {
		this.lastRcvDate = lastRcvDate;
	}

	@Override
	public String toString() {
		return "RealTimeVO [chatSeq=" + chatSeq + ", rcvMsg=" + rcvMsg + ", sendMsg=" + sendMsg + ", adminNo=" + adminNo
				+ ", charDate=" + charDate + ", roomSeq=" + roomSeq + ", userSeq=" + userSeq + ", status=" + status
				+ ", lastRcvDate=" + lastRcvDate + "]";
	}

}
