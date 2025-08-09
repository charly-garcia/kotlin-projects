package com.example.beans;

public class EmailService extends MessageService {
	
	private String smtpServer;

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}
	
	public void sendMessage(String message)
	{
		System.out.println("Sending Email via: " + smtpServer + " : " + message);
	}

}
