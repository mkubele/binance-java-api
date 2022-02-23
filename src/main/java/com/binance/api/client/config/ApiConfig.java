package com.binance.api.client.config;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Configuration used for Binance operations.
 */

@Retention(RUNTIME)
@Target(TYPE)
public @interface ApiConfig {

    /**
     * Domain of Rest URLs.
     */
    String apiUrl();

    /**
     * Domain of WebSocket.
     */
    String webSocketUrl();
}
