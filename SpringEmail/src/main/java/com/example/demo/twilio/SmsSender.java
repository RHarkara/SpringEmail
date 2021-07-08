package com.example.demo.twilio;

public interface SmsSender {
	void sendSms(String phoneNumber, String message);
}
