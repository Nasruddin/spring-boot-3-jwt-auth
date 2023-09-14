package com.javatab.controller.v1;

import com.javatab.controller.BaseController;
import com.javatab.controller.IAuthenticationController;
import com.javatab.domain.entity.User;
import com.javatab.dto.request.AuthenticationRequest;
import com.javatab.dto.response.AuthenticationResponse;
import com.javatab.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class AuthenticationControllerV1 extends BaseController implements IAuthenticationController {


  @Value("${javatab.token.header}")
  private String tokenHeader;

  private final AuthenticationService authenticationService;

  public ResponseEntity<AuthenticationResponse> authenticationRequest(AuthenticationRequest authenticationRequest) {
    return ResponseEntity.ok(this.authenticationService.authenticate(authenticationRequest));
  }

  public ResponseEntity<AuthenticationResponse> authenticationRequest(HttpServletRequest request) {
    return ResponseEntity.ok(this.authenticationService.refreshToken(request.getHeader(tokenHeader)));
  }

  public ResponseEntity<User> registerUser(AuthenticationRequest authenticationRequest) {
    return new ResponseEntity<>(this.authenticationService.registerUser(authenticationRequest), HttpStatus.CREATED);
  }

}
