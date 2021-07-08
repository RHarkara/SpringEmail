package com.example.demo.appuser.registration;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistratioController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("data")
	public String register(@Valid @RequestBody RegistrationRequest request) {
		return registrationService.register(request);
	}

	@GetMapping("confirm")
	public String confirm(@RequestParam("token") String token) {
		return registrationService.confirmToken(token);
	}

}
