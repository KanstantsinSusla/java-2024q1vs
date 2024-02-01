package com.epam.javaadvanced.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class CustomStatusActuatorEndpoint {

    @ReadOperation
    public Object getStatus() {
        return new StatusResponse(222, "Success");
    }

    private record StatusResponse (int status, String message){}
}
