package com.binance.api.client.domain.event;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Order or trade report update event.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdateEvent
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTradeUpdate {

    @JsonProperty("e")
    private String eventType;

    /**
     * Order/trade time.
     */
    @JsonProperty("T")
    private Long orderTradeTime;

    @JsonProperty("E")
    private Long eventTime;

    @JsonProperty("s")
    private String symbol;

    @JsonProperty("c")
    private String newClientOrderId;

    /**
     * Buy/Sell order side.
     */
    @JsonProperty("S")
    private OrderSide side;

    /**
     * Type of order.
     */
    @JsonProperty("o")
    private OrderType type;

    /**
     * Time in force to indicate how long will the order remain active.
     */
    @JsonProperty("f")
    private TimeInForce timeInForce;

    /**
     * Original quantity in the order.
     */
    @JsonProperty("q")
    private String originalQuantity;

    /**
     * Price.
     */
    @JsonProperty("p")
    private String price;

    @JsonProperty("ap")
    private String averagePrice;

    @JsonProperty("sp")
    private String stopPrice;

    /**
     * Type of execution.
     */
    @JsonProperty("x")
    private ExecutionType executionType;

    /**
     * Status of the order.
     */
    @JsonProperty("X")
    private OrderStatus orderStatus;

    /**
     * Order id.
     */
    @JsonProperty("i")
    private Long orderId;

    /**
     * Quantity of the last filled trade.
     */
    @JsonProperty("l")
    private String quantityLastFilledTrade;

    /**
     * Accumulated quantity of filled trades on this order.
     */
    @JsonProperty("z")
    private String accumulatedQuantity;

    /**
     * Price of last filled trade.
     */
    @JsonProperty("L")
    private String priceOfLastFilledTrade;

    /**
     * Trade id.
     */
    @JsonProperty("t")
    private Long tradeId;

    @JsonProperty("b")
    private Long bidsNational;

    @JsonProperty("a")
    private Long askNational;

    @JsonProperty("m")
    private Boolean tradeMaker;

    @JsonProperty("R")
    private Boolean reduceOnly;

    @JsonProperty("wt")
    private WorkingType workingType;

    @JsonProperty("ot")
    private OrderType orderType;

    @JsonProperty("ps")
    private PositionSide positionSide;

    @JsonProperty("cp")
    private Boolean closedAllPositions;

    @JsonProperty("rp")
    private String realizedProfit;

    @JsonProperty("pP")
    private Boolean protectedOrder;

    //fixme: Unknown field name
    @JsonProperty("si")
    private Long si;

    //fixme: Unknown field name
    @JsonProperty("ss")
    private Long ss;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getOrderTradeTime() {
        return orderTradeTime;
    }

    public void setOrderTradeTime(Long orderTradeTime) {
        this.orderTradeTime = orderTradeTime;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getNewClientOrderId() {
        return newClientOrderId;
    }

    public void setNewClientOrderId(String newClientOrderId) {
        this.newClientOrderId = newClientOrderId;
    }

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(TimeInForce timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getOriginalQuantity() {
        return originalQuantity;
    }

    public void setOriginalQuantity(String originalQuantity) {
        this.originalQuantity = originalQuantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
        this.stopPrice = stopPrice;
    }

    public ExecutionType getExecutionType() {
        return executionType;
    }

    public void setExecutionType(ExecutionType executionType) {
        this.executionType = executionType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getQuantityLastFilledTrade() {
        return quantityLastFilledTrade;
    }

    public void setQuantityLastFilledTrade(String quantityLastFilledTrade) {
        this.quantityLastFilledTrade = quantityLastFilledTrade;
    }

    public String getAccumulatedQuantity() {
        return accumulatedQuantity;
    }

    public void setAccumulatedQuantity(String accumulatedQuantity) {
        this.accumulatedQuantity = accumulatedQuantity;
    }

    public String getPriceOfLastFilledTrade() {
        return priceOfLastFilledTrade;
    }

    public void setPriceOfLastFilledTrade(String priceOfLastFilledTrade) {
        this.priceOfLastFilledTrade = priceOfLastFilledTrade;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getBidsNational() {
        return bidsNational;
    }

    public void setBidsNational(Long bidsNational) {
        this.bidsNational = bidsNational;
    }

    public Long getAskNational() {
        return askNational;
    }

    public void setAskNational(Long askNational) {
        this.askNational = askNational;
    }

    public Boolean getTradeMaker() {
        return tradeMaker;
    }

    public void setTradeMaker(Boolean tradeMaker) {
        this.tradeMaker = tradeMaker;
    }

    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(Boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public WorkingType getWorkingType() {
        return workingType;
    }

    public void setWorkingType(WorkingType workingType) {
        this.workingType = workingType;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public PositionSide getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(PositionSide positionSide) {
        this.positionSide = positionSide;
    }

    public Boolean getClosedAllPositions() {
        return closedAllPositions;
    }

    public void setClosedAllPositions(Boolean closedAllPositions) {
        this.closedAllPositions = closedAllPositions;
    }

    public String getRealizedProfit() {
        return realizedProfit;
    }

    public void setRealizedProfit(String realizedProfit) {
        this.realizedProfit = realizedProfit;
    }

    public Boolean getProtectedOrder() {
        return protectedOrder;
    }

    public void setProtectedOrder(Boolean protectedOrder) {
        this.protectedOrder = protectedOrder;
    }

    public Long getSi() {
        return si;
    }

    public void setSi(Long si) {
        this.si = si;
    }

    public Long getSs() {
        return ss;
    }

    public void setSs(Long ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("eventType", eventType)
                .append("orderTradeTime", orderTradeTime)
                .append("eventTime", eventTime)
                .append("symbol", symbol)
                .append("newClientOrderId", newClientOrderId)
                .append("side", side)
                .append("type", type)
                .append("timeInForce", timeInForce)
                .append("originalQuantity", originalQuantity)
                .append("price", price)
                .append("averagePrice", averagePrice)
                .append("stopPrice", stopPrice)
                .append("executionType", executionType)
                .append("orderStatus", orderStatus)
                .append("orderId", orderId)
                .append("quantityLastFilledTrade", quantityLastFilledTrade)
                .append("accumulatedQuantity", accumulatedQuantity)
                .append("priceOfLastFilledTrade", priceOfLastFilledTrade)
                .append("tradeId", tradeId)
                .append("bidsNational", bidsNational)
                .append("askNational", askNational)
                .append("tradeMaker", tradeMaker)
                .append("reduceOnly", reduceOnly)
                .append("workingType", workingType)
                .append("orderType", orderType)
                .append("positionSide", positionSide)
                .append("closedAllPositions", closedAllPositions)
                .append("realizedProfit", realizedProfit)
                .append("protectedOrder", protectedOrder)
                .append("si", si)
                .append("ss", ss)
                .toString();
    }
}
