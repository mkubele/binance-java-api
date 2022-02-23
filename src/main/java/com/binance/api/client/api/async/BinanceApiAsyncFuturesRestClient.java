package com.binance.api.client.api.async;

import com.binance.api.client.api.BinanceApiCallback;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;

import java.util.List;

/**
 * Binance API façade, supporting asynchronous/non-blocking access Binance's Futures REST API.
 *
 * @author Mahdi Shiekh Hosseini
 */
public interface BinanceApiAsyncFuturesRestClient {

    void getAccount(Long recvWindow, Long timestamp, BinanceApiCallback<FuturesAccount> callback);

    void getAccount(BinanceApiCallback<FuturesAccount> callback);

    void getOpenOrders(OrderRequest orderRequest, BinanceApiCallback<List<Order>> callback);

    void newOrder(FuturesNewOrder order, BinanceApiCallback<FuturesNewOrderResponse> callback);

    void cancelOrder(CancelOrderRequest cancelOrderRequest, BinanceApiCallback<CancelOrderResponse> callback);

    void getOrderStatus(OrderStatusRequest orderStatusRequest, BinanceApiCallback<Order> callback);

    void getPositionInformation(String symbol, BinanceApiCallback<List<PositionInformation>> callback);

}