package com.binance.api.client.api;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.*;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.event.ListenKey;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.ServerTime;
import com.binance.api.client.domain.market.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Binance's REST API URL mappings and endpoint security configuration.
 * Implemented according to : https://binance-docs.github.io/apidocs/futures/en/#change-log
 *
 * @author Mahdi Sheikh Hosseini
 */
public interface BinanceFuturesApiService {

    // General endpoints

    @GET("/fapi/v1/ping")
    Call<Void> ping();

    @GET("/fapi/v1/time")
    Call<ServerTime> getServerTime();

    @GET("/fapi/v1/exchangeInfo")
    Call<ExchangeInfo> getExchangeInfo();

    // Market data endpoints

    @GET("/fapi/v1/depth")
    Call<OrderBook> getOrderBook(@Query("symbol") String symbol, @Query("limit") Integer limit);

    @GET("/fapi/v1/trades")
    Call<List<TradeHistoryItem>> getTrades(@Query("symbol") String symbol, @Query("limit") Integer limit);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/fapi/v1/historicalTrades")
    Call<List<TradeHistoryItem>> getHistoricalTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId);

    @GET("/fapi/v1/aggTrades")
    Call<List<AggTrade>> getAggTrades(@Query("symbol") String symbol, @Query("fromId") String fromId, @Query("limit") Integer limit,
                                      @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    @GET("/fapi/v1/klines")
    Call<List<Candlestick>> getCandlestickBars(@Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                               @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    @GET("/fapi/v1/ticker/24hr")
    Call<TickerStatistics> get24HrPriceStatistics(@Query("symbol") String symbol);

    @GET("/fapi/v1/ticker/24hr")
    Call<List<TickerStatistics>> getAll24HrPriceStatistics();

    @GET("/fapi/v1/ticker/price")
    Call<TickerPrice> getLatestPrice(@Query("symbol") String symbol);

    // Account endpoints

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/fapi/v1/order")
    Call<FuturesNewOrderResponse> newOrder(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("positionSide") PositionSide positionSide,
                                           @Query("type") OrderType type, @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity,
                                           @Query("price") String price, @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                           @Query("closePosition") boolean closePosition, @Query("activationPrice") String activationPrice,
                                           @Query("workingType") WorkingType workingType, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                           @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/fapi/v1/order")
    Call<Order> getOrderStatus(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                               @Query("origClientOrderId") String origClientOrderId, @Query("recvWindow") Long recvWindow,
                               @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/fapi/v1/order")
    Call<CancelOrderResponse> cancelOrder(@Query("symbol") String symbol,
                                          @Query("orderId") Long orderId,
                                          @Query("origClientOrderId") String origClientOrderId,
                                          @Query("newClientOrderId") String newClientOrderId,
                                          @Query("recvWindow") Long recvWindow,
                                          @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/fapi/v1/openOrders")
    Call<List<Order>> getOpenOrders(@Query("symbol") String symbol,
                                    @Query("recvWindow") Long recvWindow,
                                    @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/fapi/v1/allOrders")
    Call<List<Order>> getAllOrders(@Query("symbol") String symbol,
                                   @Query("orderId") Long orderId,
                                   @Query("limit") Integer limit,
                                   @Query("recvWindow") Long recvWindow,
                                   @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/fapi/v2/account")
    Call<FuturesAccount> getAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    // User stream endpoints

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/fapi/v1/listenKey")
    Call<ListenKey> startUserDataStream();

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/fapi/v1/listenKey")
    Call<Void> keepAliveUserDataStream(@Query("listenKey") String listenKey);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @DELETE("/fapi/v1/listenKey")
    Call<Void> closeAliveUserDataStream(@Query("listenKey") String listenKey);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/fapi/v1/leverage")
    Call<LeverageResponse> changeInitialLeverage(@Query("symbol") String symbol,
                                                 @Query("leverage") Integer leverage,
                                                 @Query("recvWindow") Long recvWindow,
                                                 @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/fapi/v1/marginType")
    Call<Void> changeMarginType(@Query("symbol") String symbol,
                                @Query("marginType") MarginType marginType,
                                @Query("recvWindow") Long recvWindow,
                                @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/fapi/v1/positionSide/dual")
    Call<Void> changePositionSideMode(@Query("dualSidePosition") boolean dualSidePosition,
                                      @Query("recvWindow") Long recvWindow,
                                      @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/fapi/v2/positionRisk")
    Call<List<PositionInformation>> getPositionInformation(@Query("symbol") String symbol,
                                                           @Query("recvWindow") Long recvWindow,
                                                           @Query("timestamp") Long timestamp);
}
