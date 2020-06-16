package com.example.pokedemo.exception;

import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class ApiFailureException extends RuntimeException {
    public ApiFailureException(ClientHttpResponse clientHttpResponse) throws IOException {
        super(clientHttpResponse.getStatusText());
    }
}
