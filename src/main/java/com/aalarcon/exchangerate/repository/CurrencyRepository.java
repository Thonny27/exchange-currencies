package com.aalarcon.exchangerate.repository;

import com.aalarcon.exchangerate.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CurrencyRepository.
 * Repository de la entidad Currency
 *
 * @author Giancarlo Manzano
 * @version 1.0
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
