package com.ndb.currency_conversion_service.proxy;

import com.ndb.currency_conversion_service.dao.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// if we're using ribbon, we don't need the url of the running currency-exchange-service
//@FeignClient(name = "currency-exchange-service")
//@RibbonClient(name = "currency-exchange-service")---> now Ribbon not used

@FeignClient(name = "currency-exchange-service",url = "localhost:8000")

public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyConversion retriveExchangeValue
            // exact pathvariable name from currencyExchangeController
            (@PathVariable("fromCurrency") String from, @PathVariable ("toCurrency") String to);
}
