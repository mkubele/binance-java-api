package com.binance.api.examples.futures;

import com.binance.api.client.api.BinanceApiWebSocketClient;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Example binance futures websocket connection
 *
 * @author Mahdi Sheikh Hosseini
 */
public class FuturesWebSocketExample {
    private static final String SYMBOL = "LINKUSDT";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory factory = BinanceAbstractFactory.createFuturesFactory();
        BinanceApiWebSocketClient webSocketClient = factory.newWebSocketClient();

//        webSocketClient.onTickerEvent(SYMBOL, System.out::println);
        webSocketClient.onCandlestickEvent(SYMBOL, CandlestickInterval.FIFTEEN_MINUTES, System.out::println);
    }

}
