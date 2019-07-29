package com.kh.hp.common;

import static com.kh.hp.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {

	private final String AUTH_ID = "happyPlaystage@gmail.com";
	private final String AUTH_PASSWORD = "1q2w3e4r@";
	private final String MAIL_AUTH_TITLE = "[HappyPlaystage] 요청하신 인증번호를 알려드립니다.";
	private final String MAIL_PW_TITLE = "[HappyPlaystage] 요청하신 임시비밀번호 입니다.";

	/**
	 * 인증번호 생성
	 * @return
	 */
	public String make_Certification() {
		String certificationNumber = "";
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		String today = simpleDateFormat.format(date);
		String randomStr = String.valueOf((int) (Math.random() * 100));

		certificationNumber = randomStr + today;
		System.out.println("certificationNumber:::" + certificationNumber);

		return certificationNumber;
	}

	/**
	 * 세션번호, 인증번호 DB 저장
	 * @param sessionId
	 * @param certification
	 */
	public void InsertCertification(String sessionId, String certification) {
		Connection con = getConnection();
		int result = 0;
		String query = "INSERT INTO CER_MAIL_LOG VALUES(MAIL_SEQ.NEXTVAL, ?, ?, SYSDATE)";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sessionId);
			pstmt.setString(2, certification);
			result=pstmt.executeUpdate();

			System.out.println("이메일 저장 결과 : " + result);
			if(result > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
	}

	public void sendEmail(String sessionId, String receiver, String password) {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		//		Authenticator authenticator = new MailAuth();

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(AUTH_ID, AUTH_PASSWORD);
			}
		});
		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			mimeMessage.setSentDate(new Date()); // 시간 설정
			mimeMessage.setFrom(new InternetAddress(AUTH_ID)); // 발신자 설정
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver)); // 수신자 설정




			// 내용 관련
			String content = "";
			if(password == null) {
				mimeMessage.setSubject(MAIL_AUTH_TITLE, "UTF-8"); // 제목 입력
				String certification = make_Certification(); // 인증번호  생성
				content = "인증번호 : " + certification; // 메일 Body 생성
				InsertCertification(sessionId, certification); // DB 저장
			} else {
				mimeMessage.setSubject(MAIL_PW_TITLE, "UTF-8"); // 제목 입력
				content = "임시 비밀번호 : " + password;
			}

			mimeMessage.setText(content, "UTF-8"); // 내용 입력

			Transport.send(mimeMessage); // 메일 전송
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
