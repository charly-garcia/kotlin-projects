package com.example.beans;

public class MessageService {
	
	private String sender;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public void sendMessage(String message)
	{
		System.out.println("Sending Message: " + message);
	}

}
