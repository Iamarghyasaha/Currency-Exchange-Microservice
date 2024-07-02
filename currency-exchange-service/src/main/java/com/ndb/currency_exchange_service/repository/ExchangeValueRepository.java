package com.ndb.currency_exchange_service.repository;

import com.ndb.currency_exchange_service.dao.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {
    //it isn't required, although we can use directly use with exact FieldName, just trying here native query
    // ExchangeValue findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
    @Query(value = "SELECT * FROM exchange_value WHERE from_currency = :fromCurrency AND to_currency = :toCurrency", nativeQuery = true)
    ExchangeValue findByFromAndTo(@Param("fromCurrency") String fromCurrency, @Param("toCurrency") String toCurrency);
}
