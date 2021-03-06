package com.aalarcon.exchangerate.controller;

import com.aalarcon.config.JwtTokenUtil;
import com.aalarcon.exchangerate.dto.JwtDto;
import com.aalarcon.exchangerate.response.JwtResponse;
import com.aalarcon.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * JwtAuthenticationController.
 * Controlador de Authorization
 *
 * @author Anthony Alarcon
 * @version 1.0
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private JwtTokenUtil jwtTokenUtil;
  @Autowired
  private JwtUserDetailsService userDetailsService;

  /**
   * Metodo createAuthenticationToken.
   * generar token
   *
   * @return ResponseEntity
   */
  @PostMapping(value = "/authenticate")
  public ResponseEntity<Object> createAuthenticationToken(
      @RequestBody JwtDto authenticationRequest) throws IllegalArgumentException {
    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    final UserDetails userDetails = userDetailsService
        .loadUserByUsername(authenticationRequest.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);
    return ResponseEntity.ok(new JwtResponse(token));
  }

  private void authenticate(String username, String password)
      throws DisabledException, BadCredentialsException {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new DisabledException("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new BadCredentialsException("INVALID_CREDENTIALS", e);
    }
  }
}
