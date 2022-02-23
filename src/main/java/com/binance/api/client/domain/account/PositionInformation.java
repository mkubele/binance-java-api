package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.MarginType;
import com.binance.api.client.domain.PositionSide;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An asset balance in an Account.
 *
 * @see Account
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionInformation {
    private String entryPrice;
    private String marginType;
    private boolean isAutoAddMargin;
    private String isolatedMargin;
    private int leverage;
    private String liquidationPrice;
    private String markPrice;
    private String maxNotionalValue;
    private String positionAmt;
    private String symbol;
    private String unRealizedProfit;
    private PositionSide positionSide;

    public String getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
    }

    public String getMarginType() {
        return marginType;
    }

    public void setMarginType(String marginType) {
        this.marginType = marginType;
    }

    public boolean isAutoAddMargin() {
        return isAutoAddMargin;
    }

    public void setAutoAddMargin(boolean autoAddMargin) {
        isAutoAddMargin = autoAddMargin;
    }

    public String getIsolatedMargin() {
        return isolatedMargin;
    }

    public void setIsolatedMargin(String isolatedMargin) {
        this.isolatedMargin = isolatedMargin;
    }

    public int getLeverage() {
        return leverage;
    }

    public void setLeverage(int leverage) {
        this.leverage = leverage;
    }

    public String getLiquidationPrice() {
        return liquidationPrice;
    }

    public void setLiquidationPrice(String liquidationPrice) {
        this.liquidationPrice = liquidationPrice;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public String getMaxNotionalValue() {
        return maxNotionalValue;
    }

    public void setMaxNotionalValue(String maxNotionalValue) {
        this.maxNotionalValue = maxNotionalValue;
    }

    public String getPositionAmt() {
        return positionAmt;
    }

    public void setPositionAmt(String positionAmt) {
        this.positionAmt = positionAmt;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUnRealizedProfit() {
        return unRealizedProfit;
    }

    public void setUnRealizedProfit(String unRealizedProfit) {
        this.unRealizedProfit = unRealizedProfit;
    }

    public PositionSide getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(PositionSide positionSide) {
        this.positionSide = positionSide;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("entryPrice", entryPrice)
                .append("marginType", marginType)
                .append("isAutoAddMargin", isAutoAddMargin)
                .append("isolatedMargin", isolatedMargin)
                .append("leverage", leverage)
                .append("liquidationPrice", liquidationPrice)
                .append("markPrice", markPrice)
                .append("maxNotionalValue", maxNotionalValue)
                .append("positionAmt", positionAmt)
                .append("symbol", symbol)
                .append("unRealizedProfit", unRealizedProfit)
                .append("positionSide", positionSide)
                .toString();
    }
}
