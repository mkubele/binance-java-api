package com.binance.api.examples;

import com.binance.api.client.api.async.BinanceApiSpotAsyncRestClient;
import com.binance.api.client.domain.general.FilterType;
import com.binance.api.client.domain.general.SymbolFilter;
import com.binance.api.client.domain.general.SymbolInfo;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

/**
 * Examples on how to use the general endpoints.
 */
public class GeneralEndpointsExampleAsync {

    public static void main(String[] args) throws InterruptedException {
        BinanceSpotApiClientFactory factory = BinanceSpotApiClientFactory.newInstance();
        BinanceApiSpotAsyncRestClient client = factory.newAsyncRestClient();

        // Test connectivity
        client.ping(response -> System.out.println("Ping succeeded."));

        // Check server time
        client.getServerTime(response -> System.out.println(response.getServerTime()));

        // Exchange info
        client.getExchangeInfo(exchangeInfo -> {
            System.out.println(exchangeInfo.getTimezone());
            System.out.println(exchangeInfo.getSymbols());

            // Obtain symbol information
            SymbolInfo symbolInfo = exchangeInfo.getSymbolInfo("ETHBTC");
            System.out.println(symbolInfo.getStatus());

            SymbolFilter priceFilter = symbolInfo.getSymbolFilter(FilterType.PRICE_FILTER);
            System.out.println(priceFilter.getMinPrice());
            System.out.println(priceFilter.getTickSize());
        });
    }
}
