package com.binance.api.examples.testnet;

import com.binance.api.client.api.sync.BinanceApiFuturesRestClient;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Examples on how to place orders, cancel them.
 *
 * @author Mahdi Sheikh Hosseini
 */
public class TestnetGeneralExample {
    private static final String SYMBOL = "BTCUSDT";
    private static final String API_KEY = "";
    private static final String SECRET_KEY = "";


    public static void main(String[] args) throws InterruptedException {
        BinanceFuturesApiClientFactory testnetFactory = BinanceAbstractFactory.createTestnetFactory(API_KEY, SECRET_KEY);
        BinanceApiFuturesRestClient futureClient = testnetFactory.newRestClient();

        // Get account information
        System.out.println(futureClient.getAccount());

        // Test ping
        futureClient.ping();

        // Get 24h price statistics
        System.out.println(futureClient.get24HrPriceStatistics(SYMBOL));

        // Get Exchange Info
        System.out.println(futureClient.getExchangeInfo());

        // Get symbol aggregate trades
        System.out.println("aggTrade size : " + futureClient.getAggTrades(SYMBOL).size());

        // Get symbol candle bars
        System.out.println("Candles bars size : " + futureClient.getCandlestickBars(SYMBOL, CandlestickInterval.ONE_MINUTE).size());

        // Get listen key
        System.out.println(futureClient.startUserDataStream());

        // Get price
        System.out.println("Price " + futureClient.getPrice(SYMBOL));
    }
}
