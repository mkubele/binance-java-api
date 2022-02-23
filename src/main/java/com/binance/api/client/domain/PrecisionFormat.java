package com.binance.api.client.domain;

public enum PrecisionFormat {
    ONE(1, "#.#"),
    TWO(2, "#.##"),
    THREE(3, "#.###"),
    FOUR(4, "#.####"),
    FIVE(5, "#.#####"),
    SIX(6, "#.######"),
    SEVEN(7, "#.#######"),
    EIGHT(8, "#.########");

    private final int len;
    private final String format;

    PrecisionFormat(int len, String format) {
        this.len = len;
        this.format = format;
    }

    public static String getPrecisionFormat(int len) {
        switch (len) {
            case 1:
                return PrecisionFormat.ONE.format;
            case 2:
                return PrecisionFormat.TWO.format;
            case 3:
                return PrecisionFormat.THREE.format;
            case 4:
                return PrecisionFormat.FOUR.format;
            case 5:
                return PrecisionFormat.FIVE.format;
            case 6:
                return PrecisionFormat.SIX.format;
            case 7:
                return PrecisionFormat.SEVEN.format;
            default:
                return PrecisionFormat.EIGHT.format;
        }
    }
}
