package com.javatab.springboot3authjwt.services;

import com.javatab.springboot3authjwt.model.ApplicationUser;
import com.javatab.springboot3authjwt.model.Authority;
import com.javatab.springboot3authjwt.model.EAuthority;
import com.javatab.springboot3authjwt.model.LoginResponseDto;
import com.javatab.springboot3authjwt.repository.AuthorityRepository;
import com.javatab.springboot3authjwt.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public AuthenticationService(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public ApplicationUser registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Authority userAuthority = authorityRepository.findByAuthority(EAuthority.USER).get();
        Set<Authority> authorities = new HashSet<>();
        authorities.add(userAuthority);

        return userRepository.save(new ApplicationUser(0, username, passwordEncoder.encode(password), authorities));
    }

    public LoginResponseDto login(String username, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            String token = tokenService.generateJwt(authentication);
            return new LoginResponseDto(userRepository.findByUsername(username).get(), token);
        } catch (Exception exception) {
            return new LoginResponseDto(null, "");
        }
    }
}
