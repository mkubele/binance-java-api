package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderStatus;
import com.binance.api.client.domain.PositionSide;
import com.binance.api.client.domain.WorkingType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Response returned when placing a new order on the system.
 *
 * @see NewOrder for the request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesNewOrderResponse {

    private String clientOrderId;
    private String cumQty;
    private String cumQuote;
    private String executedQty;
    private long orderId;
    private String avgPrice;
    private String origQty;
    private String price;
    private boolean reduceOnly;
    private OrderSide side;
    private PositionSide positionSide;
    private OrderStatus status;
    private String stopPrice;
    private boolean closePosition;
    private String symbol;
    private String timeInForce;
    private String type;
    private String origType;
    private String activatePrice;
    private String priceRate;
    private long updateTime;
    private WorkingType workingType;
    private boolean priceProtect;

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getCumQty() {
        return cumQty;
    }

    public void setCumQty(String cumQty) {
        this.cumQty = cumQty;
    }

    public String getCumQuote() {
        return cumQuote;
    }

    public void setCumQuote(String cumQuote) {
        this.cumQuote = cumQuote;
    }

    public String getExecutedQty() {
        return executedQty;
    }

    public void setExecutedQty(String executedQty) {
        this.executedQty = executedQty;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getOrigQty() {
        return origQty;
    }

    public void setOrigQty(String origQty) {
        this.origQty = origQty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public PositionSide getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(PositionSide positionSide) {
        this.positionSide = positionSide;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
        this.stopPrice = stopPrice;
    }

    public boolean isClosePosition() {
        return closePosition;
    }

    public void setClosePosition(boolean closePosition) {
        this.closePosition = closePosition;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigType() {
        return origType;
    }

    public void setOrigType(String origType) {
        this.origType = origType;
    }

    public String getActivatePrice() {
        return activatePrice;
    }

    public void setActivatePrice(String activatePrice) {
        this.activatePrice = activatePrice;
    }

    public String getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public WorkingType getWorkingType() {
        return workingType;
    }

    public void setWorkingType(WorkingType workingType) {
        this.workingType = workingType;
    }

    public boolean isPriceProtect() {
        return priceProtect;
    }

    public void setPriceProtect(boolean priceProtect) {
        this.priceProtect = priceProtect;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("clientOrderId", clientOrderId)
                .append("cumQty", cumQty)
                .append("cumQuote", cumQuote)
                .append("executedQty", executedQty)
                .append("orderId", orderId)
                .append("avgPrice", avgPrice)
                .append("origQty", origQty)
                .append("price", price)
                .append("reduceOnly", reduceOnly)
                .append("side", side)
                .append("positionSide", positionSide)
                .append("status", status)
                .append("stopPrice", stopPrice)
                .append("closePosition", closePosition)
                .append("symbol", symbol)
                .append("timeInForce", timeInForce)
                .append("type", type)
                .append("origType", origType)
                .append("activatePrice", activatePrice)
                .append("priceRate", priceRate)
                .append("updateTime", updateTime)
                .append("workingType", workingType)
                .append("priceProtect", priceProtect)
                .toString();
    }
}
