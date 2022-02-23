package com.binance.api.examples;

import com.binance.api.client.api.async.BinanceApiAsyncMarginRestClient;
import com.binance.api.client.api.async.BinanceApiSpotAsyncRestClient;
import com.binance.api.client.domain.TransferType;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceMarginApiClientFactory;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

/**
 * Examples on how to get margin account information asynchronously.
 */
public class MarginAccountEndpointsExampleAsync {

    public static void main(String[] args) {
        BinanceMarginApiClientFactory marginFactory = BinanceAbstractFactory.createMarginFactory("YOUR_API_KEY", "YOUR_SECRET");
        BinanceSpotApiClientFactory spotFactory = BinanceAbstractFactory.createSpotFactory("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiAsyncMarginRestClient marginClient = marginFactory.newAsyncRestClient();
        BinanceApiSpotAsyncRestClient spotClient = spotFactory.newAsyncRestClient();

        // Get account balances
        marginClient.getAccount(marginAccount -> {
            System.out.println(marginAccount.getUserAssets());
            System.out.println(marginAccount.getAssetBalance("ETH"));
            System.out.println(marginAccount.getMarginLevel());
        });

        // Get list of trades
        spotClient.getMyTrades("NEOETH", System.out::println);

        // Transfer, borrow, repay
        marginClient.transfer("USDT", "1", TransferType.SPOT_TO_MARGIN, transaction -> System.out.println(transaction.getTranId()));
        marginClient.borrow("USDT", "1", transaction -> System.out.println(transaction.getTranId()));
        marginClient.repay("USDT", "1", transaction -> System.out.println(transaction.getTranId()));
        marginClient.transfer("USDT", "1", TransferType.MARGIN_TO_SPOT, transaction -> System.out.println(transaction.getTranId()));
    }
}
