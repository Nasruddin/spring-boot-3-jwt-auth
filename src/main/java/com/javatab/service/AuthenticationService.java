package com.javatab.service;

import com.javatab.domain.entity.User;
import com.javatab.dto.request.AuthenticationRequest;
import com.javatab.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
    AuthenticationResponse refreshToken(String token);
    User registerUser(AuthenticationRequest authenticationRequest);
}
