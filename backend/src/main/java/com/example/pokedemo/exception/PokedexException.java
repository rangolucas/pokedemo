package com.example.pokedemo.exception;

public class PokedexException extends RuntimeException {

    public PokedexException() {
        super();
    }

    public PokedexException(String msg) {
        super(msg);
    }

    public PokedexException(String msg, Exception ex) {
        super(msg, ex);
    }
}
