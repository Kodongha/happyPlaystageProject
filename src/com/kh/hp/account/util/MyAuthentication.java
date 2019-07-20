package com.kh.hp.account.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthentication extends Authenticator {

	PasswordAuthentication pa;
	
	public MyAuthentication() {
		String id = "inwoo226@gmail.com";
		String pw = "qnfkd1178";
		
		pa = new PasswordAuthentication(id, pw);
		
		
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		
		return pa;
		
	}
	
}
