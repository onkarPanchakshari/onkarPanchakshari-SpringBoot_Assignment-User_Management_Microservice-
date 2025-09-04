package com.OnkarPanchakshariTask.Task.Service;

import com.OnkarPanchakshariTask.Task.dto.JwtAuthenticationResponse;
import com.OnkarPanchakshariTask.Task.dto.SignUpRequest;
import com.OnkarPanchakshariTask.Task.dto.SigninRequest;
import com.OnkarPanchakshariTask.Task.entities.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);

    public JwtAuthenticationResponse signin(SigninRequest signinRequest);
}
