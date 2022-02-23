package com.binance.api.examples;

import com.binance.api.client.api.sync.BinanceApiSpotRestClient;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.FilterType;
import com.binance.api.client.domain.general.SymbolFilter;
import com.binance.api.client.domain.general.SymbolInfo;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

/**
 * Examples on how to use the general endpoints.
 */
public class GeneralEndpointsExample {

    public static void main(String[] args) {
        BinanceSpotApiClientFactory factory = BinanceSpotApiClientFactory.newInstance();
        BinanceApiSpotRestClient client = factory.newRestClient();

        // Test connectivity
        client.ping();

        // Check server time
        long serverTime = client.getServerTime();
        System.out.println(serverTime);

        // Exchange info
        ExchangeInfo exchangeInfo = client.getExchangeInfo();
        System.out.println(exchangeInfo.getTimezone());
        System.out.println(exchangeInfo.getSymbols());

        // Obtain symbol information
        SymbolInfo symbolInfo = exchangeInfo.getSymbolInfo("ETHBTC");
        System.out.println(symbolInfo.getStatus());

        SymbolFilter priceFilter = symbolInfo.getSymbolFilter(FilterType.PRICE_FILTER);
        System.out.println(priceFilter.getMinPrice());
        System.out.println(priceFilter.getTickSize());
    }
}
