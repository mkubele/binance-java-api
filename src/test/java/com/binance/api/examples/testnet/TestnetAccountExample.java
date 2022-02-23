package com.binance.api.examples.testnet;

import com.binance.api.client.api.sync.BinanceApiFuturesRestClient;
import com.binance.api.client.domain.account.FuturesAccount;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Examples binance futures account information
 */
public class TestnetAccountExample {
    private static final String API_KEY = "";
    private static final String SECRET_KEY = "";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory factory = BinanceAbstractFactory.createTestnetFactory(API_KEY, SECRET_KEY);
        BinanceApiFuturesRestClient client = factory.newRestClient();

        FuturesAccount account = client.getAccount();
        System.out.println("Available Balance: " + account.getAvailableBalance());
    }

}
