package com.example.demo.appuser;

import java.time.LocalDateTime; 
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.appuser.registration.token.ConfirmationToken;
import com.example.demo.appuser.registration.token.ConformationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

	private final static String USER_NOT_FOUND = "user with email %s not found ";

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private ConformationTokenService conformationtokenservice;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		return appUserRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
	}

	public int enableAppUser(String email) {
		return appUserRepository.enableAppUser(email);
	}

	public String signUpUser(AppUser appUser) {
		boolean isUserExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
		if (isUserExists) {
			throw new IllegalStateException("Email Already Existed");
		}

		String encodedPassword = passwordEncoder.encode(appUser.getPassword());
		appUser.setPassword(encodedPassword);
		appUserRepository.save(appUser);

		String token = UUID.randomUUID().toString();

		ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15), appUser);
		conformationtokenservice.saveConformationTOken(confirmationToken);

		return token;
	}

}
