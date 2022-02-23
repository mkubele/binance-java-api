package com.binance.api.examples;

import com.binance.api.client.api.async.BinanceApiSpotAsyncRestClient;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

/**
 * Examples on how to get account information.
 */
public class AccountEndpointsExampleAsync {

    public static void main(String[] args) {
        BinanceSpotApiClientFactory factory = BinanceAbstractFactory.createSpotFactory("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiSpotAsyncRestClient client = factory.newAsyncRestClient();

        // Get account balances (async)
        client.getAccount((Account response) -> System.out.println(response.getAssetBalance("ETH")));

        // Get list of trades (async)
        client.getMyTrades("NEOETH", System.out::println);

        // Get withdraw history (async)
        client.getWithdrawHistory("ETH", System.out::println);

        // Get deposit history (async)
        client.getDepositHistory("ETH", System.out::println);

        // Withdraw (async)
        client.withdraw("ETH", "0x123", "0.1", null, null, response -> {
        });
    }
}
