package com.example.beans;

public class SMSService extends MessageService {
	
	private String gateway;

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	@Override
	public void sendMessage(String message)
	{
		System.out.println("Sending SMS via: " + gateway + " : " + message);
	}
}
