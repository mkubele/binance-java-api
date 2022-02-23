package com.binance.api.client.domain.market;

import com.binance.api.client.exception.BinanceApiException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Kline/Candlestick intervals.
 * m -> minutes; h -> hours; d -> days; w -> weeks; M -> months
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum CandlestickInterval {
    ONE_MINUTE("1m"),
    THREE_MINUTES("3m"),
    FIVE_MINUTES("5m"),
    FIFTEEN_MINUTES("15m"),
    HALF_HOURLY("30m"),
    HOURLY("1h"),
    TWO_HOURLY("2h"),
    FOUR_HOURLY("4h"),
    SIX_HOURLY("6h"),
    EIGHT_HOURLY("8h"),
    TWELVE_HOURLY("12h"),
    DAILY("1d"),
    THREE_DAILY("3d"),
    WEEKLY("1w"),
    MONTHLY("1M");

    private final String intervalId;

    CandlestickInterval(String intervalId) {
        this.intervalId = intervalId;
    }

    public String getIntervalId() {
        return intervalId;
    }

    public static CandlestickInterval getEnum(String intervalId) {
        switch (intervalId) {
            case "1m":
                return CandlestickInterval.ONE_MINUTE;
            case "3m":
                return CandlestickInterval.THREE_MINUTES;
            case "5m":
                return CandlestickInterval.FIVE_MINUTES;
            case "15m":
                return CandlestickInterval.FIFTEEN_MINUTES;
            case "30m":
                return CandlestickInterval.HALF_HOURLY;
            case "1h":
                return CandlestickInterval.HOURLY;
            case "2h":
                return CandlestickInterval.TWO_HOURLY;
            case "4h":
                return CandlestickInterval.FOUR_HOURLY;
            case "6h":
                return CandlestickInterval.SIX_HOURLY;
            case "8h":
                return CandlestickInterval.EIGHT_HOURLY;
            case "12h":
                return CandlestickInterval.TWELVE_HOURLY;
            case "1d":
                return CandlestickInterval.DAILY;
            case "3d":
                return CandlestickInterval.THREE_DAILY;
            case "1w":
                return CandlestickInterval.WEEKLY;
            case "1M":
                return CandlestickInterval.MONTHLY;
            default:
                throw new BinanceApiException("Time interval not defined");
        }
    }


}
