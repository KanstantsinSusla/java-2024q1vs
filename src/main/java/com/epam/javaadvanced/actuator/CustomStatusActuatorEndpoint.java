package com.epam.javaadvanced.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class CustomStatusActuatorEndpoint {
    @Autowired
    Environment environment;

    @ReadOperation
    public Object getStatus() {
        return new StatusResponse(
                200,
                environment.getActiveProfiles(),
                environment.getProperty("spring.datasource.url", "No active data source."));
    }

    private record StatusResponse (int status, String[] activeProfiles, String dbUrl){}
}
