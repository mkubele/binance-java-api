package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.PositionSide;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An asset balance in an Account.
 *
 * @see Account
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesPosition {
    private String symbol;
    private String initialMargin;
    private String maintMargin;
    private String unrealizedProfit;
    private String positionInitialMargin;
    private String openOrderInitialMargin;
    private String leverage;
    private boolean isolated;
    private String entryPrice;
    private String maxNotional;
    private PositionSide positionSide;
    private String positionAmt;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(String initialMargin) {
        this.initialMargin = initialMargin;
    }

    public String getMaintMargin() {
        return maintMargin;
    }

    public void setMaintMargin(String maintMargin) {
        this.maintMargin = maintMargin;
    }

    public String getUnrealizedProfit() {
        return unrealizedProfit;
    }

    public void setUnrealizedProfit(String unrealizedProfit) {
        this.unrealizedProfit = unrealizedProfit;
    }

    public String getPositionInitialMargin() {
        return positionInitialMargin;
    }

    public void setPositionInitialMargin(String positionInitialMargin) {
        this.positionInitialMargin = positionInitialMargin;
    }

    public String getOpenOrderInitialMargin() {
        return openOrderInitialMargin;
    }

    public void setOpenOrderInitialMargin(String openOrderInitialMargin) {
        this.openOrderInitialMargin = openOrderInitialMargin;
    }

    public String getLeverage() {
        return leverage;
    }

    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    public boolean isIsolated() {
        return isolated;
    }

    public void setIsolated(boolean isolated) {
        this.isolated = isolated;
    }

    public String getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
    }

    public String getMaxNotional() {
        return maxNotional;
    }

    public void setMaxNotional(String maxNotional) {
        this.maxNotional = maxNotional;
    }

    public PositionSide getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(PositionSide positionSide) {
        this.positionSide = positionSide;
    }

    public String getPositionAmt() {
        return positionAmt;
    }

    public void setPositionAmt(String positionAmt) {
        this.positionAmt = positionAmt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("initialMargin", initialMargin)
                .append("maintMargin", maintMargin)
                .append("unrealizedProfit", unrealizedProfit)
                .append("positionInitialMargin", positionInitialMargin)
                .append("openOrderInitialMargin", openOrderInitialMargin)
                .append("leverage", leverage)
                .append("isolated", isolated)
                .append("entryPrice", entryPrice)
                .append("maxNotional", maxNotional)
                .append("positionSide", positionSide)
                .append("positionAmt", positionAmt)
                .toString();
    }
}
