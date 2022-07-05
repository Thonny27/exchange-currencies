package com.aalarcon.exchangerate.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * JwtResponse.
 * Objeto de respuesta para jwt
 *
 * @author Anthony Alarcon
 * @version 1.0
 */
@RequiredArgsConstructor
@Getter
public class JwtResponse {
  private final String jwttoken;
}
