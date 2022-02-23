package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.MarginType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Mahdi Sheikh Hosseini
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginTypeRequest {

    private String symbol;
    private MarginType marginType;
    private long recvWindow;
    private long timestamp;

    public MarginTypeRequest() {
        this.timestamp = System.currentTimeMillis();
        this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
    }

    public MarginTypeRequest(String symbol, MarginType marginType) {
        this.symbol = symbol;
        this.marginType = marginType;
        this.timestamp = System.currentTimeMillis();
        this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public MarginType getMarginType() {
        return marginType;
    }

    public void setMarginType(MarginType marginType) {
        this.marginType = marginType;
    }

    public long getRecvWindow() {
        return recvWindow;
    }

    public void setRecvWindow(long recvWindow) {
        this.recvWindow = recvWindow;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("marginType", marginType)
                .append("recvWindow", recvWindow)
                .append("timestamp", timestamp)
                .toString();
    }

}
