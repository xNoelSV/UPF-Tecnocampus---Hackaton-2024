package com.backend.hackathon.hackathon_grup6.security.auth;

import com.backend.hackathon.hackathon_grup6.security.configuration.JwtService;
import com.backend.hackathon.hackathon_grup6.security.configuration.UserSecurityService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UserSecurityService userLabDetailsService;

  public AuthenticationService(JwtService jwtService, AuthenticationManager authenticationManager, UserSecurityService userLabDetailsService) {
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
    this.userLabDetailsService = userLabDetailsService;
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );
    UserDetails userDetails = this.userLabDetailsService.loadUserByUsername(request.getUsername());
    var jwtToken = jwtService.generateToken(userDetails);
    AuthenticationResponse response = new AuthenticationResponse();
    response.setAccessToken(jwtToken);

    return response;
  }
}
