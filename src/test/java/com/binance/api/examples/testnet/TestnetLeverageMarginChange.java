package com.binance.api.examples.testnet;

import com.binance.api.client.api.sync.BinanceApiFuturesRestClient;
import com.binance.api.client.domain.account.LeverageRequest;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Examples binance futures account information
 */
public class TestnetLeverageMarginChange {
    private static final String SYMBOL = "BTCUSDT";
    private static final String API_KEY = "";
    private static final String SECRET_KEY = "";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory factory = BinanceAbstractFactory.createTestnetFactory(API_KEY, SECRET_KEY);
        BinanceApiFuturesRestClient client = factory.newRestClient();

        System.out.println("Current leverage : " + client.getAccount().getPosition(SYMBOL).getLeverage());

        client.changeInitialLeverage(new LeverageRequest(SYMBOL, 25));

        System.out.println("New leverage : " + client.getAccount().getPosition(SYMBOL).getLeverage());
    }

}
