package com.binance.api.client.api.async;

import com.binance.api.client.api.BinanceApiCallback;
import com.binance.api.client.domain.SwapRemoveType;
import com.binance.api.client.domain.account.*;

import java.util.List;

/**
 * Binance API facade, supporting asynchronous/non-blocking access Binance's REST API.
 */
public interface BinanceApiSwapAsyncRestClient {

    /**
     * Get metadata about all swap pools.
     *
     * @return
     */
    void listAllSwapPools(BinanceApiCallback<List<Pool>> callback);

    /**
     * Get liquidity information and user share of a pool.
     *
     * @param poolId
     * @return
     */
    void getPoolLiquidityInfo(String poolId, BinanceApiCallback<Liquidity> callback);

    /**
     * Add liquidity to a pool.
     *
     * @param poolId
     * @param asset
     * @param quantity
     * @return
     */
    void addLiquidity(String poolId,
                      String asset,
                      String quantity,
                      BinanceApiCallback<LiquidityOperationRecord> callback);

    /**
     * Remove liquidity from a pool, type include SINGLE and COMBINATION, asset is mandatory for single asset removal
     *
     * @param poolId
     * @param type
     * @param asset
     * @param shareAmount
     * @return
     */
    void removeLiquidity(String poolId,
                         SwapRemoveType type,
                         List<String> asset,
                         String shareAmount,
                         BinanceApiCallback<LiquidityOperationRecord> callback);

    /**
     * Get liquidity operation (add/remove) records of a pool
     *
     * @param poolId
     * @param limit
     * @return
     */
    void getPoolLiquidityOperationRecords(String poolId,
                                          Integer limit,
                                          BinanceApiCallback<List<LiquidityOperationRecord>> callback);

    /**
     * Get liquidity operation (add/remove) record.
     *
     * @param operationId
     * @return
     */
    void getLiquidityOperationRecord(String operationId, BinanceApiCallback<LiquidityOperationRecord> callback);

    /**
     * Request a quote for swap quote asset (selling asset) for base asset (buying asset), essentially price/exchange rates.
     *
     * @param quoteAsset
     * @param baseAsset
     * @param quoteQty
     * @return
     */
    void requestQuote(String quoteAsset,
                      String baseAsset,
                      String quoteQty, BinanceApiCallback<SwapQuote> callback);

    /**
     * Swap quoteAsset for baseAsset
     *
     * @param quoteAsset
     * @param baseAsset
     * @param quoteQty
     * @return
     */
    void swap(String quoteAsset,
              String baseAsset,
              String quoteQty, BinanceApiCallback<SwapRecord> callback);

    void getSwapHistory(String swapId, BinanceApiCallback<SwapHistory> callback);
}