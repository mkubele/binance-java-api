package com.binance.api.client.factory;

import com.binance.api.client.api.BinanceApiWebSocketClient;
import com.binance.api.client.api.async.BinanceApiSpotAsyncRestClient;
import com.binance.api.client.api.sync.BinanceApiSpotRestClient;
import com.binance.api.client.impl.async.BinanceApiSpotAsyncRestClientImpl;
import com.binance.api.client.impl.sync.BinanceApiSpotRestClientImpl;
import com.binance.api.client.impl.ws.BinanceApiWebSocketClientImpl;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.getSharedClient;

/**
 * A factory for creating BinanceApi client objects.
 */
public class BinanceSpotApiClientFactory implements BinanceFactory<BinanceApiSpotRestClient, BinanceApiSpotAsyncRestClient> {

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
    private BinanceSpotApiClientFactory(String apiKey, String secret, String apiUrl, String websocketUrl) {
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
    public static BinanceSpotApiClientFactory newInstance(String apiKey, String secret, String apiUrl, String websocketUrl) {
        return new BinanceSpotApiClientFactory(apiKey, secret, apiUrl, websocketUrl);
    }

    /**
     * New instance without authentication.
     *
     * @return the binance api client factory
     * @see BinanceAbstractFactory
     */
    public static BinanceSpotApiClientFactory newInstance() {
        return new BinanceSpotApiClientFactory(null, null, null, null);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BinanceApiSpotRestClient newRestClient() {
        return new BinanceApiSpotRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public BinanceApiSpotAsyncRestClient newAsyncRestClient() {
        return new BinanceApiSpotAsyncRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    public BinanceApiWebSocketClient newWebSocketClient() {
        return new BinanceApiWebSocketClientImpl(getSharedClient(), websocketUrl);
    }
}
