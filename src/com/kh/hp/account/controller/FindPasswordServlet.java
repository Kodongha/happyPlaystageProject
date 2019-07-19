package com.kh.hp.account.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hp.account.util.MyAuthentication;

/**
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/findPassword.acc")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		Properties props = System.getProperties();
		props.put("mail.smtp.user", "inwoo226@gmail.com");
		
		props.put("mail.smtp.host", "smtp.gomail.com");
		
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "ture");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback","false");

		Authenticator auth = new MyAuthentication();
		
		Session session = Session.getDefaultInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setSentDate(new Date());
			
			InternetAddress from = new InternetAddress("inwoo226@gmail.com");
			
			msg.setFrom(from);
			
			String email = request.getParameter("receiver");

			InternetAddress to = new InternetAddress("inwoo226@gmail.com");
			
			msg.setRecipient(Message.RecipientType.TO, to);
			
			msg.setSubject("비밀번호 인증번호", "UTF-8");
			
			String code = request.getParameter("success");
			
			request.setAttribute("code", code);
			msg.setText(code,"UTF-8");
			
			msg.setHeader("content-Type", "text/html");
			System.out.println(msg);
			javax.mail.Transport.send(msg);
			System.out.println("보냄");
			
			
		} catch(AddressException addr_e) {
			addr_e.printStackTrace();

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
