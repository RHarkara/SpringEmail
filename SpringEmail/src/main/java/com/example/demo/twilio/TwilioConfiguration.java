package com.example.demo.twilio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Configuration
@NoArgsConstructor
@AllArgsConstructor
public class TwilioConfiguration {
	@Value("${my.twilio.account_Sid}")
	private String accountSid;
	@Value("${my.twilio.auth_token}")
	private String authToken;
	@Value("${my.twilio.trail_number}")
	private String trailNumber;
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getTrailNumber() {
		return trailNumber;
	}
	public void setTrailNumber(String trailNumber) {
		this.trailNumber = trailNumber;
	}
	
	
	

}
