package com.aalarcon.service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * JwtUserDetailsService.
 * Servicio para validar usuario
 *
 * @author Anthony Alarcon
 * @version 1.0
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if ("aalarcon".equals(username)) {
      return new User("aalarcon", "$2a$12$h1JD1pkFYfAz1yfSXhQxle7D3LclmN2to.5RNyZ5LvBhM3gkQlv.O",
          new ArrayList<>());
    } else {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
  }
}
