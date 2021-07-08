package com.example.demo.twilio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.appuser.registration.RegistrationRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);
	
	@Autowired
	private TwilioConfiguration twilioConfiguration;
	
	public boolean isPhoneNumberValid(String phoneNUmber) {
		// TODO: Implement phone Number validator
		return true;
	}

	@Override
	public void sendSms(String phoneNumber, String message) {
		if(isPhoneNumberValid(phoneNumber)) {
			PhoneNumber to = new PhoneNumber(phoneNumber);
			PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrailNumber());
			String smsMessage = message;
			MessageCreator creator = Message.creator(to,from,message);
			creator.create();	
			LOGGER.info("SMS Sent TO the Concerned Person");
		}
		else {
			throw new IllegalStateException("Phone number is not valid");
		}
		
				
		
	}

}
