package com.binance.api.client.factory;

import com.binance.api.client.api.async.BinanceApiAsyncMarginRestClient;
import com.binance.api.client.api.sync.BinanceApiMarginRestClient;
import com.binance.api.client.impl.async.BinanceApiAsyncMarginRestClientImpl;
import com.binance.api.client.impl.sync.BinanceApiMarginRestClientImpl;

/**
 * A factory for creating BinanceApi client objects.
 */
public class BinanceMarginApiClientFactory implements BinanceFactory<BinanceApiMarginRestClient, BinanceApiAsyncMarginRestClient> {

    /**
     * API Key
     */
    private final String apiKey;

    /**
     * Secret.
     */
    private final String secret;

    private final String apiUrl;
    private final String websocketUrl;

    /**
     * Instantiates a new binance api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BinanceMarginApiClientFactory(String apiKey, String secret, String apiUrl, String websocketUrl) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.apiUrl = apiUrl;
        this.websocketUrl = websocketUrl;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the binance api client factory
     */
    public static BinanceMarginApiClientFactory newInstance(String apiKey, String secret, String apiUrl, String websocketUrl) {
        return new BinanceMarginApiClientFactory(apiKey, secret, apiUrl, websocketUrl);
    }

    /**
     * New instance without authentication.
     *
     * @return the binance api client factory
     * @see BinanceAbstractFactory
     */
    public static BinanceMarginApiClientFactory newInstance() {
        return new BinanceMarginApiClientFactory(null, null, null, null);
    }

    /**
     * Creates a new asynchronous/non-blocking Margin REST client.
     */
    public BinanceApiAsyncMarginRestClient newAsyncRestClient() {
        return new BinanceApiAsyncMarginRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new synchronous/blocking Margin REST client.
     */
    public BinanceApiMarginRestClient newRestClient() {
        return new BinanceApiMarginRestClientImpl(apiKey, secret, apiUrl);
    }
}
