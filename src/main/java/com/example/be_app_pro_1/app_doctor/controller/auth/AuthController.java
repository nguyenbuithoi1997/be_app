package com.example.be_app_pro_1.app_doctor.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.be_app_pro_1.app_doctor.constant.AppDoctorConstant.ApiPath;
import com.example.be_app_pro_1.app_doctor.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = ApiPath.API + ApiPath.AUTH)
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationService service;

//	@GetMapping(ApiPath.TEST)
//	public String test1() {
//		return "Test111111111";
//	}

	@RequestMapping(value = ApiPath.TEST, method = RequestMethod.POST)
	public String test() {
		return "Test";
	}

//	@PostMapping(ApiPath.REGISTER)
//	public String register(@RequestBody AuthenticationRequest request) {
//		return "44444"; //ResponseEntity.ok(service.register(request));
//	}
//
//	@GetMapping(ApiPath.REGISTER)
//	public String getRegister() {
//		return "444445"; //ResponseEntity.ok(service.register(request));
//	}

//	@PostMapping(ApiPath.REGISTER)
//	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
//		return ResponseEntity.ok(service.register(request));
//	}

	@PostMapping(ApiPath.LOGIN)
	public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(service.authenticate(request));
	}

}
