package com.binance.api.client.factory;

/**
 * Generic binance factory used for any implementation of new engines
 *
 * @author Mahdi Shiekh Hosseini
 * @see com.binance.api.client.BinanceEngineType
 */
public interface BinanceFactory<SYNC, ASYNC> {

    /**
     * @return instance of asynchronous class
     */
    ASYNC newAsyncRestClient();

    /**
     * @return instance of synchronous class
     */
    SYNC newRestClient();
}
