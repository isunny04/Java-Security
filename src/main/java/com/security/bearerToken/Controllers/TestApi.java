package com.security.bearerToken.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.bearerToken.Config.SecurityConfig;
import com.security.bearerToken.Repo.registrationRepo;
import com.security.bearerToken.model.userRegistration;

@RestController
@RequestMapping("BT/")
@CrossOrigin(origins = "*")
public class TestApi {

	@Autowired
	private registrationRepo repo;

	@Autowired
	private SecurityConfig securityConfig;

	@Autowired
	private PasswordEncoder passwordEncoder; // Password Encoder

	@Autowired

	@GetMapping("TestSecurity")
	public String TestApi() {
		return "Access To API";
	}

	@PostMapping("Register")
	public userRegistration register(@RequestBody userRegistration userRegistration) {

		System.out.println("IN Registration API");

		// Encoding the password
		userRegistration.setPassword(passwordEncoder.encode(userRegistration.getPassword()));

		System.out.println(userRegistration);
		return repo.save(userRegistration);

	}

	@PostMapping("Login")
	public String login(@RequestParam String userId, @RequestParam String password) {
		Optional<userRegistration> userOptional = repo.findById(userId);

		if (userOptional.isPresent()) {
			userRegistration user = userOptional.get();

			// Check password
			if (passwordEncoder.matches(password, user.getPassword())) {
				return "Login Successful!";
			} else {
				return "Invalid Credentials!";
			}
		} else {
			return "User not found!";
		}
	}

	@GetMapping("secure")
	public String Secure() {
		return "secured data";
	}

}
