package com.binance.api.client.api.sync;

import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.TradeHistoryItem;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.market.*;

import java.util.List;

/**
 * Binance API facade, supporting synchronous/blocking access Binance's REST API.
 */
public interface BinanceApiGeneralRestClient {

    // General endpoints

    /**
     * Test connectivity to the Rest API.
     */
    void ping();

    /**
     * Test connectivity to the Rest API and get the current server time.
     *
     * @return current server time.
     */
    Long getServerTime();

    /**
     * @return Current exchange trading rules and symbol information
     */
    ExchangeInfo getExchangeInfo();

    // Market Data endpoints

    /**
     * Get order book of a symbol.
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     * @param limit  depth of the order book (max 100)
     */
    OrderBook getOrderBook(String symbol, Integer limit);

    /**
     * Get recent trades (up to last 500). Weight: 1
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     * @param limit  of last trades (Default 500; max 1000.)
     */
    List<TradeHistoryItem> getTrades(String symbol, Integer limit);

    /**
     * Get older trades. Weight: 5
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     * @param limit  of last trades (Default 500; max 1000.)
     * @param fromId TradeId to fetch from. Default gets most recent trades.
     */
    List<TradeHistoryItem> getHistoricalTrades(String symbol, Integer limit, Long fromId);

    /**
     * Get compressed, aggregate trades. Trades that fill at the time, from the same order, with
     * the same price will have the quantity aggregated.
     * <p>
     * If both <code>startTime</code> and <code>endTime</code> are sent, <code>limit</code>should not
     * be sent AND the distance between <code>startTime</code> and <code>endTime</code> must be less than 24 hours.
     *
     * @param symbol    symbol to aggregate (mandatory)
     * @param fromId    ID to get aggregate trades from INCLUSIVE (optional)
     * @param limit     Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get aggregate trades from INCLUSIVE (optional).
     * @param endTime   Timestamp in ms to get aggregate trades until INCLUSIVE (optional).
     * @return a list of aggregate trades for the given symbol
     */
    List<AggTrade> getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime);

    /**
     * Return the most recent aggregate trades for <code>symbol</code>
     *
     * @see #getAggTrades(String, String, Integer, Long, Long)
     */
    List<AggTrade> getAggTrades(String symbol);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @param symbol    symbol to aggregate (mandatory)
     * @param interval  candlestick interval (mandatory)
     * @param limit     Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
     * @param endTime   Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
     * @return a candlestick bar for the given symbol and interval
     */
    List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime, Long endTime);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @see #getCandlestickBars(String, CandlestickInterval, Integer, Long, Long)
     */
    List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @see #getCandlestickBars(String, CandlestickInterval, Integer, Long, Long)
     */
    List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit);

    /**
     * Get 24 hour price change statistics.
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     */
    TickerStatistics get24HrPriceStatistics(String symbol);

    /**
     * Get 24 hour price change statistics for all symbols.
     */
    List<TickerStatistics> getAll24HrPriceStatistics();

    /**
     * Get latest price for <code>symbol</code>.
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     */
    TickerPrice getPrice(String symbol);


    /**
     * Check an order's status.
     *
     * @param orderStatusRequest order status request options/filters
     * @return an order
     */
    Order getOrderStatus(OrderStatusRequest orderStatusRequest);

    /**
     * Cancel an active order.
     *
     * @param cancelOrderRequest order status request parameters
     */
    CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest);

    /**
     * Get all open orders on a symbol.
     *
     * @param orderRequest order request parameters
     * @return a list of all account open orders on a symbol.
     */
    List<Order> getOpenOrders(OrderRequest orderRequest);
}
