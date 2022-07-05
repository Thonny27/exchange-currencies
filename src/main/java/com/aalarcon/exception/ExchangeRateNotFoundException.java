package com.aalarcon.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * ExchangeRateNotFoundException.
 * Excepcion personalizada para ExchangeRates no encontradas
 *
 * @author Anthony Alarcon
 * @version 1.0
 */
@Slf4j
public class ExchangeRateNotFoundException extends RuntimeException {

  public ExchangeRateNotFoundException(Long id) {
    super("Could not find exchange rate ".concat(id.toString()));
    log.error(String.format("ExchangeRate with id %s not found", id));
  }

}
