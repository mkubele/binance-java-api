package com.binance.api.examples;

import com.binance.api.client.api.BinanceApiWebSocketClient;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

/**
 * All market tickers channel examples.
 * <p>
 * It illustrates how to create a stream to obtain all market tickers.
 */
public class AllMarketTickersExample {

    public static void main(String[] args) {
        BinanceSpotApiClientFactory factory = BinanceSpotApiClientFactory.newInstance();
        BinanceApiWebSocketClient client = factory.newWebSocketClient();

        client.onAllMarketTickersEvent(System.out::println);
    }
}
