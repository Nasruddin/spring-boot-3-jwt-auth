package com.javatab.springboot3authjwt.controllers;

import com.javatab.springboot3authjwt.model.ApplicationUser;
import com.javatab.springboot3authjwt.model.LoginResponseDto;
import com.javatab.springboot3authjwt.model.RegistrationDto;
import com.javatab.springboot3authjwt.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDto registrationDto) {
        return authenticationService.registerUser(registrationDto.getUsername(), registrationDto.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody RegistrationDto registrationDto) {
        return authenticationService.login(registrationDto.getUsername(), registrationDto.getPassword());
    }

    @GetMapping("/authorities")
    public Map<String,Object> getPrincipalInfo(JwtAuthenticationToken principal) {

        Collection<String> authorities = principal.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        Map<String,Object> info = new HashMap<>();
        info.put("name", principal.getName());
        info.put("authorities", authorities);
        info.put("tokenAttributes", principal.getTokenAttributes());

        return info;
    }
}
