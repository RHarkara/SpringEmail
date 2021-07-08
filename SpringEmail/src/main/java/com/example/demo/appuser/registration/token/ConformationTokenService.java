package com.example.demo.appuser.registration.token;

import java.time.LocalDateTime; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConformationTokenService {

	@Autowired
	private ConformationTokenRepository conformationTokenRepository;

	public void saveConformationTOken(ConfirmationToken confirmationToken) {
		conformationTokenRepository.save(confirmationToken);
	}

	public Optional<ConfirmationToken> getToken(String token) {
		return conformationTokenRepository.findByToken(token);
	}

	public int setConfirmedAt(String token) {
		return conformationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
	}
}
