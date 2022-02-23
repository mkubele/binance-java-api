package com.binance.api.client.exception;

public class BinanceIllegalException extends RuntimeException {
    public BinanceIllegalException() {
    }

    public BinanceIllegalException(String message) {
        super(message);
    }
}
