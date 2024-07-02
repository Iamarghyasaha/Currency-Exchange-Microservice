package com.ndb.currency_exchange_service.service;

import com.ndb.currency_exchange_service.dao.ExchangeValue;
import com.ndb.currency_exchange_service.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueService {
    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    public ExchangeValue getExchangeValue(String fromCurrency, String toCurrency){
        return exchangeValueRepository.findByFromAndTo(fromCurrency,toCurrency);
    }
}
