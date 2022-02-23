package com.binance.api.examples;

import com.binance.api.client.api.async.BinanceApiSpotAsyncRestClient;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.exception.BinanceApiException;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

/**
 * Examples on how to get market data information such as the latest price of a symbol, etc., in an async way.
 */
public class MarketDataEndpointsExampleAsync {

    public static void main(String[] args) {
        BinanceSpotApiClientFactory factory = BinanceSpotApiClientFactory.newInstance();
        BinanceApiSpotAsyncRestClient client = factory.newAsyncRestClient();

        // Getting depth of a symbol (async)
        client.getOrderBook("NEOETH", 10, (OrderBook response) -> {
            System.out.println(response.getBids());
        });

        // Getting latest price of a symbol (async)
        client.get24HrPriceStatistics("NEOETH", System.out::println);

        // Getting all latest prices (async)
        client.getAllPrices(System.out::println);

        // Getting agg trades (async)
        client.getAggTrades("NEOETH", System.out::println);

        // Weekly candlestick bars for a symbol
        client.getCandlestickBars("NEOETH", CandlestickInterval.WEEKLY, System.out::println);

        // Book tickers (async)
        client.getBookTickers(System.out::println);

        // Exception handling
        try {
            client.getOrderBook("UNKNOWN", 10, System.out::println);
        } catch (BinanceApiException e) {
            System.out.println(e.getError().getCode()); // -1121
            System.out.println(e.getError().getMsg());  // Invalid symbol
        }
    }
}
