package com.binance.api.client.factory;

import com.binance.api.client.api.BinanceApiWebSocketClient;
import com.binance.api.client.api.async.BinanceApiAsyncFuturesRestClient;
import com.binance.api.client.api.sync.BinanceApiFuturesRestClient;
import com.binance.api.client.impl.async.BinanceApiAsyncFuturesRestClientImpl;
import com.binance.api.client.impl.sync.BinanceApiFuturesRestClientImpl;
import com.binance.api.client.impl.ws.BinanceApiWebSocketClientImpl;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.getSharedClient;

/**
 * A factory for creating BinanceApi client objects.
 */
public class BinanceFuturesApiClientFactory implements BinanceFactory<BinanceApiFuturesRestClient, BinanceApiAsyncFuturesRestClient> {

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
    private BinanceFuturesApiClientFactory(String apiKey, String secret, String apiUrl, String websocketUrl) {
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
    public static BinanceFuturesApiClientFactory newInstance(String apiKey, String secret, String apiUrl, String websocketUrl) {
        return new BinanceFuturesApiClientFactory(apiKey, secret, apiUrl, websocketUrl);
    }

    /**
     * New instance without authentication.
     *
     * @return the binance api client factory
     */
    public static BinanceFuturesApiClientFactory newInstance() {
        return new BinanceFuturesApiClientFactory(null, null, null, null);
    }

    /**
     * Creates a new synchronous/blocking Futures REST client.
     */
    public BinanceApiFuturesRestClient newRestClient() {
        return new BinanceApiFuturesRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new asynchronous/non-blocking Futures REST client.
     */
    public BinanceApiAsyncFuturesRestClient newAsyncRestClient() {
        return new BinanceApiAsyncFuturesRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    public BinanceApiWebSocketClient newWebSocketClient() {
        return new BinanceApiWebSocketClientImpl(getSharedClient(), websocketUrl);
    }
}
