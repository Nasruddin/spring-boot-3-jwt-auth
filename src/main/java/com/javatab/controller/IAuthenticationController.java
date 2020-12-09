package com.javatab.controller;

import com.javatab.domain.entity.User;
import com.javatab.dto.request.AuthenticationRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping("/auth")
public interface IAuthenticationController {

    @SecurityRequirements
    @PostMapping()
    ResponseEntity<?> authenticationRequest(@RequestBody @Valid AuthenticationRequest authenticationRequest);
    @GetMapping("/refresh")
    ResponseEntity<?> authenticationRequest(HttpServletRequest request);
    @SecurityRequirements
    @PostMapping("/register")
    ResponseEntity<?> registerUser(@RequestBody @Valid AuthenticationRequest authenticationRequest);
}
