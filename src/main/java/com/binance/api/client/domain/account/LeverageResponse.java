package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeverageResponse {

    private String symbol;
    private int leverage;
    private String maxNotionalValue;

    public int getLeverage() {
        return leverage;
    }

    public void setLeverage(int leverage) {
        this.leverage = leverage;
    }

    public String getMaxNotionalValue() {
        return maxNotionalValue;
    }

    public void setMaxNotionalValue(String maxNotionalValue) {
        this.maxNotionalValue = maxNotionalValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("leverage", leverage)
                .append("maxNotionalValue", maxNotionalValue)
                .toString();
    }
}
