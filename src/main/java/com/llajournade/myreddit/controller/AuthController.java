package com.llajournade.myreddit.controller;

import com.llajournade.myreddit.dto.AuthenticationResponse;
import com.llajournade.myreddit.dto.LogingRequest;
import com.llajournade.myreddit.dto.RegisterRequest;
import com.llajournade.myreddit.repository.UserRepository;
import com.llajournade.myreddit.repository.VerificationTokenRepository;
import com.llajournade.myreddit.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successfull", HttpStatus.OK);
    }

    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<String> accountVerification(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", HttpStatus.OK);
    }


    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LogingRequest loginRequest) {
        return authService.login(loginRequest);
    }

}
