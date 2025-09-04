package com.OnkarPanchakshariTask.Task.Controller;

import com.OnkarPanchakshariTask.Task.Service.AuthenticationService;
import com.OnkarPanchakshariTask.Task.dto.JwtAuthenticationResponse;
import com.OnkarPanchakshariTask.Task.dto.SignUpRequest;
import com.OnkarPanchakshariTask.Task.dto.SigninRequest;
import com.OnkarPanchakshariTask.Task.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }



}
