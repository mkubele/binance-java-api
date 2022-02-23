package com.binance.api.client.api.sync;

import com.binance.api.client.domain.PositionSideType;
import com.binance.api.client.domain.account.*;

import java.util.List;

public interface BinanceApiFuturesRestClient extends BinanceApiGeneralRestClient {

    /**
     * Get current margin account information using default parameters.
     */
    FuturesAccount getAccount();

    /**
     * Send in a new margin order.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    FuturesNewOrderResponse newOrder(FuturesNewOrder order);


    /**
     * Change leverage
     *
     * @param leverageRequest
     * @return LeverageResponse
     */
    LeverageResponse changeInitialLeverage(LeverageRequest leverageRequest);

    /**
     * Change type of margin CROSSED/ISOLATED
     *
     * @param marginTypeRequest
     */
    void changeMarginType(MarginTypeRequest marginTypeRequest);

    // User stream endpoints

    /**
     * Start a new user data stream.
     *
     * @return a listen key that can be used with data streams
     */
    String startUserDataStream();

    /**
     * PING a user data stream to prevent a time out.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void keepAliveUserDataStream(String listenKey);

    /**
     * Close out a new user data stream.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void closeUserDataStream(String listenKey);

    /**
     * Change user's position mode (Hedge mode or One-Way mode)
     *
     * @param positionSideType
     */
    void changePositionSideMode(PositionSideType positionSideType);

    List<PositionInformation> getPositionInformation(String symbol);

}
