package com.diegolirio.votenolivro.mail;

public interface Mail {

	public void sendMail(String from, String to, String subject, String msg);
	
}
