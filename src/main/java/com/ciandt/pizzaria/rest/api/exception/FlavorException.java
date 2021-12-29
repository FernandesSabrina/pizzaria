package com.ciandt.pizzaria.rest.api.exception;

public class FlavorException extends Exception{
    public FlavorException(String message, Integer idFlavor) {
    }

    public FlavorException(String message) {
        super(message);
    }

    public FlavorException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlavorException(Throwable cause) {
        super(cause);
    }

    public FlavorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
