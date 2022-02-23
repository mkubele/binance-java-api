package com.binance.api.examples;

import com.binance.api.client.api.BinanceApiWebSocketClient;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

/**
 * Market data stream endpoints examples.
 * <p>
 * It illustrates how to create a stream to obtain updates on market data such as executed trades.
 */
public class MarketDataStreamExample {

    public static void main(String[] args) {
        BinanceApiWebSocketClient client = BinanceSpotApiClientFactory.newInstance().newWebSocketClient();

        // Listen for aggregated trade events for ETH/BTC
        client.onAggTradeEvent("ethbtc", System.out::println);

        // Listen for changes in the order book in ETH/BTC
        client.onDepthEvent("ethbtc", System.out::println);

        // Obtain 1m candlesticks in real-time for ETH/BTC
        client.onCandlestickEvent("ethbtc", CandlestickInterval.ONE_MINUTE, System.out::println);
    }
}
