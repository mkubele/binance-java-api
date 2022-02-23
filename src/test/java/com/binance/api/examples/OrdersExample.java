package com.binance.api.examples;

import com.binance.api.client.api.sync.BinanceApiSpotRestClient;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.NewOrderResponseType;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.request.*;
import com.binance.api.client.exception.BinanceApiException;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

import java.util.List;

import static com.binance.api.client.domain.account.NewOrder.limitBuy;
import static com.binance.api.client.domain.account.NewOrder.marketBuy;

/**
 * Examples on how to place orders, cancel them, and query account information.
 */
public class OrdersExample {

    private static final String SYMBOL = "LINKUSDT";

    public static void main(String[] args) {
        BinanceSpotApiClientFactory factory = BinanceAbstractFactory.createSpotFactory("MWzDJFwWf4jaCkqEv6NFYZyv2fDhdY3c1FMNN0E639wAlKvvD6oH2QxMlg5Be8jP", "ioIv2eCzPCtKeD6DcN5YYHiOA2X6Wn5Ao5kPbQ184wPZkn9Z7bv2F1apafh2f3Mm");
        BinanceApiSpotRestClient client = factory.newRestClient();

        // Getting list of open orders
        List<Order> openOrders = client.getOpenOrders(new OrderRequest(SYMBOL));
        System.out.println(openOrders);

        // Getting list of all orders with a limit of 10
        List<Order> allOrders = client.getAllOrders(new AllOrdersRequest(SYMBOL).limit(10));
        System.out.println(allOrders);

        // Get status of a particular order
        Order order = client.getOrderStatus(new OrderStatusRequest(SYMBOL, 751698L));
        System.out.println(order);

        // Canceling an order
        try {
            CancelOrderResponse cancelOrderResponse = client.cancelOrder(new CancelOrderRequest(SYMBOL, 756762L));
            System.out.println(cancelOrderResponse);
        } catch (BinanceApiException e) {
            System.out.println(e.getError().getMsg());
        }

        // Placing a test LIMIT order
        client.newOrderTest(limitBuy("LINKETH", TimeInForce.GTC, "1000", "0.0001"));

        // Placing a test MARKET order
        client.newOrderTest(marketBuy("LINKETH", "1000"));

        // Placing a real LIMIT order
        NewOrderResponse newOrderResponse = client.newOrder(limitBuy("LINKETH", TimeInForce.GTC, "1000", "0.0001").newOrderRespType(NewOrderResponseType.FULL));
        System.out.println(newOrderResponse);
    }

}
