package com.kh.hp.rent.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class RentBasicVO implements Serializable {

	private int rentSeq;				// 대관등록번호
	private int userSeq;				// 회원번호(작성자)
	private String hallNm;				// 공연장명
	private String hallSimIntro;		// 공연장 한 줄 소개
	private String hallDetIntro;		// 공연장 상세 소개
	private String website;				// 웹사이트 주소
	private String address;				// 주소
	private String hallRegisCerPath;	// 공연장 등록증 경로
	private char perfPlanTf;			// 공연계획서 등록 여부(1page end)
	private String rentEmail;			// 이메일
	private String rentMainTel;			// 대표번호
	private String rentPhone;			// 휴대전화1
	private String rentPhoneSub;		// 휴대전화2
	private String availStartTm;		// 이용가능시작시간
	private String availEndTm;			// 이용가능종료시간
	private int minRsvTm;				// 최소예약시간
	private String useTimeUnit;			// 사용 시간 단위
	private String rentEnrollStatus;	// 대관 등록 진행 상태
	private char inspTf;				// 검수 유무
	private String compNm;				// 상호명
	private String ceoNm;				// 대표자명
	private String corpNo;				// 사업자 등록 번호
	private String corpAddress;			// 사업장 주소
	private String settleEmail;			// 정산용 이메일
	private String settlePhone;			// 정산용 연락처
	private String bankNm;				// 은행명
	private String accNo;				// 계좌번호
	private String accHolder;			// 예금주
	private Date rentEnrollDt;			// 대관등록 날짜

	public RentBasicVO() {
		// TODO Auto-generated constructor stub
	}

	public RentBasicVO(int rentSeq, int userSeq, String hallNm, String hallSimIntro, String hallDetIntro,
			String website, String address, String hallRegisCerPath, char perfPlanTf, String rentEmail,
			String rentMainTel, String rentPhone, String rentPhoneSub, String availStartTm, String availEndTm,
			int minRsvTm, String useTimeUnit, String rentEnrollStatus, char inspTf, String compNm, String ceoNm,
			String corpNo, String corpAddress, String settleEmail, String settlePhone, String bankNm, String accNo,
			String accHolder, Date rentEnrollDt) {
		super();
		this.rentSeq = rentSeq;
		this.userSeq = userSeq;
		this.hallNm = hallNm;
		this.hallSimIntro = hallSimIntro;
		this.hallDetIntro = hallDetIntro;
		this.website = website;
		this.address = address;
		this.hallRegisCerPath = hallRegisCerPath;
		this.perfPlanTf = perfPlanTf;
		this.rentEmail = rentEmail;
		this.rentMainTel = rentMainTel;
		this.rentPhone = rentPhone;
		this.rentPhoneSub = rentPhoneSub;
		this.availStartTm = availStartTm;
		this.availEndTm = availEndTm;
		this.minRsvTm = minRsvTm;
		this.useTimeUnit = useTimeUnit;
		this.rentEnrollStatus = rentEnrollStatus;
		this.inspTf = inspTf;
		this.compNm = compNm;
		this.ceoNm = ceoNm;
		this.corpNo = corpNo;
		this.corpAddress = corpAddress;
		this.settleEmail = settleEmail;
		this.settlePhone = settlePhone;
		this.bankNm = bankNm;
		this.accNo = accNo;
		this.accHolder = accHolder;
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

	public String getHallSimIntro() {
		return hallSimIntro;
	}

	public void setHallSimIntro(String hallSimIntro) {
		this.hallSimIntro = hallSimIntro;
	}

	public String getHallDetIntro() {
		return hallDetIntro;
	}

	public void setHallDetIntro(String hallDetIntro) {
		this.hallDetIntro = hallDetIntro;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHallRegisCerPath() {
		return hallRegisCerPath;
	}

	public void setHallRegisCerPath(String hallRegisCerPath) {
		this.hallRegisCerPath = hallRegisCerPath;
	}

	public char getPerfPlanTf() {
		return perfPlanTf;
	}

	public void setPerfPlanTf(char perfPlanTf) {
		this.perfPlanTf = perfPlanTf;
	}

	public String getRentEmail() {
		return rentEmail;
	}

	public void setRentEmail(String rentEmail) {
		this.rentEmail = rentEmail;
	}

	public String getRentMainTel() {
		return rentMainTel;
	}

	public void setRentMainTel(String rentMainTel) {
		this.rentMainTel = rentMainTel;
	}

	public String getRentPhone() {
		return rentPhone;
	}

	public void setRentPhone(String rentPhone) {
		this.rentPhone = rentPhone;
	}

	public String getRentPhoneSub() {
		return rentPhoneSub;
	}

	public void setRentPhoneSub(String rentPhoneSub) {
		this.rentPhoneSub = rentPhoneSub;
	}

	public String getAvailStartTm() {
		return availStartTm;
	}

	public void setAvailStartTm(String availStartTm) {
		this.availStartTm = availStartTm;
	}

	public String getAvailEndTm() {
		return availEndTm;
	}

	public void setAvailEndTm(String availEndTm) {
		this.availEndTm = availEndTm;
	}

	public int getMinRsvTm() {
		return minRsvTm;
	}

	public void setMinRsvTm(int minRsvTm) {
		this.minRsvTm = minRsvTm;
	}

	public String getUseTimeUnit() {
		return useTimeUnit;
	}

	public void setUseTimeUnit(String useTimeUnit) {
		this.useTimeUnit = useTimeUnit;
	}

	public String getRentEnrollStatus() {
		return rentEnrollStatus;
	}

	public void setRentEnrollStatus(String rentEnrollStatus) {
		this.rentEnrollStatus = rentEnrollStatus;
	}

	public char getInspTf() {
		return inspTf;
	}

	public void setInspTf(char inspTf) {
		this.inspTf = inspTf;
	}

	public String getCompNm() {
		return compNm;
	}

	public void setCompNm(String compNm) {
		this.compNm = compNm;
	}

	public String getCeoNm() {
		return ceoNm;
	}

	public void setCeoNm(String ceoNm) {
		this.ceoNm = ceoNm;
	}

	public String getCorpNo() {
		return corpNo;
	}

	public void setCorpNo(String corpNo) {
		this.corpNo = corpNo;
	}

	public String getCorpAddress() {
		return corpAddress;
	}

	public void setCorpAddress(String corpAddress) {
		this.corpAddress = corpAddress;
	}

	public String getSettleEmail() {
		return settleEmail;
	}

	public void setSettleEmail(String settleEmail) {
		this.settleEmail = settleEmail;
	}

	public String getSettlePhone() {
		return settlePhone;
	}

	public void setSettlePhone(String settlePhone) {
		this.settlePhone = settlePhone;
	}

	public String getBankNm() {
		return bankNm;
	}

	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	public Date getRentEnrollDt() {
		return rentEnrollDt;
	}

	public void setRentEnrollDt(Date rentEnrollDt) {
		this.rentEnrollDt = rentEnrollDt;
	}

	@Override
	public String toString() {
		return "RentBasicVO [rentSeq=" + rentSeq + ", userSeq=" + userSeq + ", hallNm=" + hallNm + ", hallSimIntro="
				+ hallSimIntro + ", hallDetIntro=" + hallDetIntro + ", website=" + website + ", address=" + address
				+ ", hallRegisCerPath=" + hallRegisCerPath + ", perfPlanTf=" + perfPlanTf + ", rentEmail=" + rentEmail
				+ ", rentMainTel=" + rentMainTel + ", rentPhone=" + rentPhone + ", rentPhoneSub=" + rentPhoneSub
				+ ", availStartTm=" + availStartTm + ", availEndTm=" + availEndTm + ", minRsvTm=" + minRsvTm
				+ ", useTimeUnit=" + useTimeUnit + ", rentEnrollStatus=" + rentEnrollStatus + ", inspTf=" + inspTf
				+ ", compNm=" + compNm + ", ceoNm=" + ceoNm + ", corpNo=" + corpNo + ", corpAddress=" + corpAddress
				+ ", settleEmail=" + settleEmail + ", settlePhone=" + settlePhone + ", bankNm=" + bankNm + ", accNo="
				+ accNo + ", accHolder=" + accHolder + ", rentEnrollDt=" + rentEnrollDt + "]";
	}

}
