package com.OnkarPanchakshariTask.Task.Service.Impl;

import com.OnkarPanchakshariTask.Task.Service.AuthenticationService;
import com.OnkarPanchakshariTask.Task.Service.JWTService;
import com.OnkarPanchakshariTask.Task.dto.JwtAuthenticationResponse;
import com.OnkarPanchakshariTask.Task.dto.SignUpRequest;
import com.OnkarPanchakshariTask.Task.dto.SigninRequest;
import com.OnkarPanchakshariTask.Task.entities.Role;
import com.OnkarPanchakshariTask.Task.entities.User;
import com.OnkarPanchakshariTask.Task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    public User signup(SignUpRequest signUpRequest){

        User user = new User();

        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signin(SigninRequest signinRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),
                signinRequest.getPassword()));

        var user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);


        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);

        return jwtAuthenticationResponse;

    }


}
