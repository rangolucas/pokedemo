package com.example.pokedemo.exception;

import org.springframework.http.client.ClientHttpResponse;

public class ApiFailureException extends Throwable {
    public ApiFailureException(ClientHttpResponse clientHttpResponse) {
    }
}
