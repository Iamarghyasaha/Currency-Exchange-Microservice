package com.ndb.currency_exchange_service.controller;


import com.ndb.currency_exchange_service.dao.ExchangeValue;
import com.ndb.currency_exchange_service.service.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;
    @Autowired
    private ExchangeValueService exchangeValueService;

    @GetMapping("/from/{fromCurrency}/to/{toCurrency}")
    public ExchangeValue retriveExchangeValue
            (@PathVariable String fromCurrency, @PathVariable String toCurrency){
//ExchangeValue exchangeValue = new  ExchangeValue(1000L,fromCurrency,toCurrency, BigDecimal.valueOf(65));
       ExchangeValue exchangeValue = exchangeValueService.getExchangeValue(fromCurrency,toCurrency);
       if(exchangeValue==null){
           throw  new RuntimeException("Exchange value not found for " + fromCurrency + " to " + toCurrency);
       }
       exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
       return  exchangeValue;
    }
}
