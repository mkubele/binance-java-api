package com.binance.api.client.impl.async;

import com.binance.api.client.api.BinanceApiCallback;
import com.binance.api.client.api.async.BinanceApiSwapAsyncRestClient;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.SwapRemoveType;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.impl.BinanceApiCallbackAdapter;
import com.binance.api.client.api.BinanceApiService;
import com.binance.api.client.impl.BinanceApiServiceGenerator;

import java.util.List;


/**
 * Implementation of Binance's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BinanceApiSwapAsyncRestClientImpl implements BinanceApiSwapAsyncRestClient {

    private final BinanceApiService binanceApiService;

    public BinanceApiSwapAsyncRestClientImpl(String apiKey, String secret, String apiUrl) {
        binanceApiService = BinanceApiServiceGenerator.createService(BinanceApiService.class, apiKey, secret, apiUrl);
    }


    @Override
    public void listAllSwapPools(BinanceApiCallback<List<Pool>> callback) {
        binanceApiService.listAllSwapPools().enqueue(new BinanceApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPoolLiquidityInfo(String poolId, BinanceApiCallback<Liquidity> callback) {
        //TODO: not implemented yet ...
    }

    @Override
    public void addLiquidity(String poolId, String asset, String quantity, BinanceApiCallback<LiquidityOperationRecord> callback) {
        long timestamp = System.currentTimeMillis();
        binanceApiService.addLiquidity(poolId,
                asset,
                quantity,
                BinanceApiConstants.DEFAULT_RECEIVING_WINDOW,
                timestamp).enqueue(new BinanceApiCallbackAdapter<>(callback));
    }

    @Override
    public void removeLiquidity(String poolId, SwapRemoveType type, List<String> assetList, String shareAmount, BinanceApiCallback<LiquidityOperationRecord> callback) {
        long timestamp = System.currentTimeMillis();
        binanceApiService.removeLiquidity(poolId,
                type,
                assetList,
                shareAmount,
                BinanceApiConstants.DEFAULT_RECEIVING_WINDOW,
                timestamp).enqueue(new BinanceApiCallbackAdapter<>(callback));

    }

    @Override
    public void getPoolLiquidityOperationRecords(String poolId, Integer limit, BinanceApiCallback<List<LiquidityOperationRecord>> callback) {
        long timestamp = System.currentTimeMillis();
        binanceApiService.getPoolLiquidityOperationRecords(poolId, limit, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp)
                .enqueue(new BinanceApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLiquidityOperationRecord(String operationId, BinanceApiCallback<LiquidityOperationRecord> callback) {
        long timestamp = System.currentTimeMillis();
        binanceApiService.getLiquidityOperationRecord(operationId, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp);
    }

    @Override
    public void requestQuote(String quoteAsset, String baseAsset, String quoteQty, BinanceApiCallback<SwapQuote> callback) {
        long timestamp = System.currentTimeMillis();
        binanceApiService.requestQuote(quoteAsset, baseAsset, quoteQty, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp);
    }

    @Override
    public void swap(String quoteAsset, String baseAsset, String quoteQty, BinanceApiCallback<SwapRecord> callback) {
        long timestamp = System.currentTimeMillis();
        binanceApiService.swap(quoteAsset, baseAsset, quoteQty, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp);
    }

    @Override
    public void getSwapHistory(String swapId, BinanceApiCallback<SwapHistory> callback) {
        long timestamp = System.currentTimeMillis();
        binanceApiService.getSwapHistory(swapId, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp);
    }
}
