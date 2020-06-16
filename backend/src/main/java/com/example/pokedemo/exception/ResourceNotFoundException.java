package com.example.pokedemo.exception;


public class ResourceNotFoundException extends PokedexException {

    public ResourceNotFoundException(String str) {
        super(str);
    }

    public ResourceNotFoundException(String resourcePath, ResourceNotFoundException ex) {
        super("Resource not found: " + resourcePath, ex);
    }
}
