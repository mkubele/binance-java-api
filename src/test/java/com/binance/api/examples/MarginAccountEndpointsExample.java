package com.binance.api.examples;

import com.binance.api.client.api.sync.BinanceApiMarginRestClient;
import com.binance.api.client.api.sync.BinanceApiSpotRestClient;
import com.binance.api.client.domain.TransferType;
import com.binance.api.client.domain.account.MarginAccount;
import com.binance.api.client.domain.account.MarginTransaction;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceMarginApiClientFactory;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

import java.util.List;

/**
 * Examples on how to get margin account information.
 */
public class MarginAccountEndpointsExample {

    public static void main(String[] args) {
        BinanceMarginApiClientFactory marginFactory = BinanceAbstractFactory.createMarginFactory("YOUR_API_KEY", "YOUR_SECRET");
        BinanceSpotApiClientFactory spotFactory = BinanceAbstractFactory.createSpotFactory("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiMarginRestClient marginClient = marginFactory.newRestClient();
        BinanceApiSpotRestClient spotClient = spotFactory.newRestClient();

        // Get account balances
        MarginAccount marginAccount = marginClient.getAccount();
        System.out.println(marginAccount.getUserAssets());
        System.out.println(marginAccount.getAssetBalance("ETH"));
        System.out.println(marginAccount.getMarginLevel());

        // Get list of trades
        List<Trade> myTrades = spotClient.getMyTrades("NEOETH");
        System.out.println(myTrades);

        // Transfer, borrow, repay
        MarginTransaction spotToMargin = marginClient.transfer("USDT", "1", TransferType.SPOT_TO_MARGIN);
        System.out.println(spotToMargin.getTranId());
        MarginTransaction borrowed = marginClient.borrow("USDT", "1");
        System.out.println(borrowed.getTranId());
        MarginTransaction repayed = marginClient.repay("USDT", "1");
        System.out.println(repayed.getTranId());
        MarginTransaction marginToSpot = marginClient.transfer("USDT", "1", TransferType.MARGIN_TO_SPOT);
        System.out.println(marginToSpot.getTranId());
    }
}
