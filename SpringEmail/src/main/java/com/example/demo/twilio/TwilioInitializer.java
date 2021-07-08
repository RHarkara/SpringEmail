package com.example.demo.twilio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {
	
	
	private TwilioConfiguration twilioConfiguration;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

	public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
		Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());
		LOGGER.info("Twilio Initialized with sid "+ twilioConfiguration.getAccountSid());
	}
	

}
