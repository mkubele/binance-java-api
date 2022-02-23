package com.binance.api.client.factory;

import com.binance.api.client.api.async.BinanceApiSwapAsyncRestClient;
import com.binance.api.client.api.sync.BinanceApiSwapRestClient;
import com.binance.api.client.impl.async.BinanceApiSwapAsyncRestClientImpl;
import com.binance.api.client.impl.sync.BinanceApiSwapRestClientImpl;

/**
 * A factory for creating BinanceApi client objects.
 */
public class BinanceSwapApiClientFactory implements BinanceFactory<BinanceApiSwapRestClient, BinanceApiSwapAsyncRestClient> {

    /**
     * API Key
     */
    private final String apiKey;

    /**
     * Secret.
     */
    private final String secret;

    private final String apiUrl;

    /**
     * Instantiates a new binance api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BinanceSwapApiClientFactory(String apiKey, String secret, String apiUrl) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.apiUrl = apiUrl;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the binance api client factory
     */
    public static BinanceSwapApiClientFactory newInstance(String apiKey, String secret, String apiUrl) {
        return new BinanceSwapApiClientFactory(apiKey, secret, apiUrl);
    }

    /**
     * New instance without authentication.
     *
     * @return the binance api client factory
     * @see BinanceAbstractFactory
     */
    public static BinanceSwapApiClientFactory newInstance() {
        return new BinanceSwapApiClientFactory(null, null, null);
    }

    /**
     * Creates a new synchronous/blocking Swap REST client.
     */
    public BinanceApiSwapRestClient newRestClient() {
        return new BinanceApiSwapRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public BinanceApiSwapAsyncRestClient newAsyncRestClient() {
        return new BinanceApiSwapAsyncRestClientImpl(apiKey, secret, apiUrl);
    }
}
