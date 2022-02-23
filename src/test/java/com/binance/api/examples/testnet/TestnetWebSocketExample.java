package com.binance.api.examples.testnet;

import com.binance.api.client.api.BinanceApiWebSocketClient;
import com.binance.api.client.api.sync.BinanceApiFuturesRestClient;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Example binance futures websocket connection
 *
 * @author Mahdi Sheikh Hosseini
 */
public class TestnetWebSocketExample {
    private static final String SYMBOL = "BTCUSDT";
    private static final String API_KEY = "";
    private static final String SECRET_KEY = "";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory factory = BinanceAbstractFactory.createTestnetFactory(API_KEY, SECRET_KEY);
        BinanceApiFuturesRestClient client = factory.newRestClient();
        BinanceApiWebSocketClient streamClient = factory.newWebSocketClient();


        String listenKey = client.startUserDataStream();
        streamClient.onUserDataUpdateEvent(listenKey, System.out::println);
    }

}
