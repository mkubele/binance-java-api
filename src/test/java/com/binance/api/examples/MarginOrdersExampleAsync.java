package com.binance.api.examples;

import com.binance.api.client.api.async.BinanceApiAsyncMarginRestClient;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceMarginApiClientFactory;

import static com.binance.api.client.domain.account.MarginNewOrder.limitBuy;

/**
 * Examples on how to place orders, cancel them, and query account information.
 */
public class MarginOrdersExampleAsync {

    public static void main(String[] args) {
        BinanceMarginApiClientFactory factory = BinanceAbstractFactory.createMarginFactory("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiAsyncMarginRestClient client = factory.newAsyncRestClient();

        // Getting list of open orders
        client.getOpenOrders(new OrderRequest("LINKETH"), System.out::println);

        // Get status of a particular order
        client.getOrderStatus(new OrderStatusRequest("LINKETH", 745262L), System.out::println);

        // Canceling an order
        client.cancelOrder(new CancelOrderRequest("LINKETH", 756703L), System.out::println);

        // Placing a real LIMIT order
        client.newOrder(limitBuy("LINKETH", TimeInForce.GTC, "1000", "0.0001"), System.out::println);
    }
}
