package com.binance.api.examples;

import com.binance.api.client.api.BinanceApiWebSocketClient;
import com.binance.api.client.api.sync.BinanceApiSpotRestClient;
import com.binance.api.client.domain.event.AccountUpdateEvent;
import com.binance.api.client.domain.event.ExecutionReport;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

import static com.binance.api.client.domain.event.UserDataUpdateEventType.ACCOUNT_UPDATE;

/**
 * User data stream endpoints examples.
 * <p>
 * It illustrates how to create a stream to obtain updates on a user account,
 * as well as update on trades/orders on a user account.
 */
public class MarginUserDataStreamExample {
    private static final String API_KEY = "";
    private static final String SECRET_KEY = "";

    public static void main(String[] args) {
        BinanceSpotApiClientFactory factory = BinanceAbstractFactory.createSpotFactory(API_KEY, SECRET_KEY);
        BinanceApiSpotRestClient client = factory.newRestClient();

        // First, we obtain a listenKey which is required to interact with the user data stream
        String listenKey = client.startUserDataStream();

        // Then, we open a new web socket client, and provide a callback that is called on every update
        BinanceApiWebSocketClient webSocketClient = factory.newWebSocketClient();

        // Listen for changes in the account
        webSocketClient.onUserDataUpdateEvent(listenKey, response -> {
            if (response.getEventType() == ACCOUNT_UPDATE) {
                AccountUpdateEvent accountUpdateEvent = response.getAccountUpdateEvent();
                // Print new balances of every available asset
                System.out.println(accountUpdateEvent.getBalances());
            } else {
                ExecutionReport executionReport = response.getExecutionReport();
                // Print details about an order/trade
                System.out.println(executionReport);

                // Print original quantity
                System.out.println(executionReport.getOriginalQuantity());

                // Or price
                System.out.println(executionReport.getPrice());
            }
        });
        System.out.println("Waiting for events...");

        // We can keep alive the user data stream
        // client.keepAliveUserDataStream(listenKey);

        // Or we can invalidate it, whenever it is no longer needed
        // client.closeUserDataStream(listenKey);
    }
}
