package com.aalarcon.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * CurrencyNotFoundException.
 * Excepcion personalizada para Currencies no encontradas
 *
 * @author Anthony Alarcon
 * @version 1.0
 */
@Slf4j
public class CurrencyNotFoundException extends RuntimeException {

  public CurrencyNotFoundException(Long id) {
    super("Could not find currency ".concat(id.toString()));
    log.error(String.format("Currency with id %s not found", id));
  }
}
