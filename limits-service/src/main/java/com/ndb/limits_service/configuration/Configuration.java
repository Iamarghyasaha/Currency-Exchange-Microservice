package com.ndb.limits_service.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//binds external configuration properties prefixed with "limits-service" from bootstrap.properties
@ConfigurationProperties("limits-service")
@Data
public class Configuration {
    private  int minimum;
    private int maximum;
}
