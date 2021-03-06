package com.aalarcon.exchangerate.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.aalarcon.exchangerate.entity.ExchangeRate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * ErrorResponse.
 * Objeto de respuesta para errores
 *
 * @author Anthony Alarcon
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalculateAmountResponse {
  private BigDecimal amount;
  private String calculatedAmount;
  private ExchangeRate exchangeRate;
}
