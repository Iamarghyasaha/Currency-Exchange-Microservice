package com.ndb.currency_conversion_service.dao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionMultiple;
    private  BigDecimal quantity;
    private  BigDecimal totalCalculatedAmount;
    private  int port;

}
