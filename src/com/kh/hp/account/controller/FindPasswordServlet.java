package com.kh.hp.account.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/findPassword.acc")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String AUTH_ID = "happyPlaystage@gmail.com";
	private final String AUTH_PASSWORD = "1q2w3e4r@";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String receiver = request.getParameter("receiver");
		System.out.println("receiver::::"+receiver);

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

			// 시간 설정
			mimeMessage.setSentDate(new Date());

			// 발신자 설정
			mimeMessage.setFrom(new InternetAddress(AUTH_ID));

			// 수신자 설정
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

			// 제목 입력 <<< 여기에 재목 입력하면 돼!!!
			mimeMessage.setSubject("제목입니다!!!!", "UTF-8");

			// 내용 입력 <<< 여기에 내용 입력하면 돼!
			mimeMessage.setText("안녕하세요. 테스트 메일입니다.", "UTF-8");

			// 메일 전송
			Transport.send(mimeMessage);


		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("views/account/findPassword2.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
