package com.binance.api.examples.testnet;

import com.binance.api.client.api.async.BinanceApiAsyncFuturesRestClient;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Examples on how to place orders, cancel them, and query account information.
 *
 * @author Mahdi Sheikh Hosseini
 */
public class TestnetOrdersAsyncExample {

    private static final String SYMBOL = "LTCUSDT";
    private static final String API_KEY = "";
    private static final String SECRET_KEY = "";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory factory = BinanceAbstractFactory.createTestnetFactory(API_KEY, SECRET_KEY);
        BinanceApiAsyncFuturesRestClient client = factory.newAsyncRestClient();


        // Placing a real LIMIT order
//        client.newOrder(limitLong(SYMBOL, TimeInForce.GTC, WorkingType.CONTRACT_PRICE, "13", "27", false), System.out::println);

        // Getting list of open orders
        client.getOpenOrders(new OrderRequest(SYMBOL), System.out::println);

        // Get status of a particular order
//        client.getOrderStatus(new OrderStatusRequest(SYMBOL, 751698L), System.out::println);

        // Canceling an order
//        client.cancelOrder(new CancelOrderRequest(SYMBOL, 756762l), System.out::println);

    }

}
