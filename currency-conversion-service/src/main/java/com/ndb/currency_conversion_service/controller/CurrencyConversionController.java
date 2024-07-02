package com.ndb.currency_conversion_service.controller;

import com.ndb.currency_conversion_service.dao.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/currency-converter")
public class CurrencyConversionController {



    @GetMapping("/from/{fromCurrency}/to/{toCurrency}/quantity/{currencyQuantity}")
    public CurrencyConversion convertCurrency(@PathVariable String fromCurrency, @PathVariable String toCurrency,
                                              @PathVariable BigDecimal currencyQuantity){

        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("fromCurrency",fromCurrency);
        uriVariables.put("toCurrency",toCurrency);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{fromCurrency}/to/{toCurrency}"
                ,CurrencyConversion.class,uriVariables);

        CurrencyConversion response=responseEntity.getBody();

        return new CurrencyConversion(
                response.getId(),
                fromCurrency,
                toCurrency,
                response.getConversionMultiple(),
                currencyQuantity,
                currencyQuantity.multiply(response.getConversionMultiple()),
                response.getPort()
        );
    }

}
