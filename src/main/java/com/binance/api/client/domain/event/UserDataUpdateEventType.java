package com.binance.api.client.domain.event;

public enum UserDataUpdateEventType {
    ACCOUNT_POSITION_UPDATE("outboundAccountPosition"),
    BALANCE_UPDATE("balanceUpdate"),
    EXECUTION_REPORT("executionReport"),
    ACCOUNT_UPDATE("ACCOUNT_UPDATE"), //Binance futures & testnet
    ACCOUNT_CONFIG_UPDATE("ACCOUNT_CONFIG_UPDATE"), //Binance futures & testnet //TODO: Implement this type.
    ORDER_TRADE_UPDATE("ORDER_TRADE_UPDATE"); //Binance futures & testnet

    private final String eventTypeId;

    UserDataUpdateEventType(String eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventTypeId() {
        return eventTypeId;
    }

    public static UserDataUpdateEventType fromEventTypeId(String eventTypeId) {
        UserDataUpdateEventType et = null;
        switch (eventTypeId) {
            case "outboundAccountPosition":
                et = UserDataUpdateEventType.ACCOUNT_POSITION_UPDATE;
                break;
            case "balanceUpdate":
                et = UserDataUpdateEventType.BALANCE_UPDATE;
                break;
            case "executionReport":
                et = UserDataUpdateEventType.EXECUTION_REPORT;
                break;
            case "ACCOUNT_UPDATE":
                et = UserDataUpdateEventType.ACCOUNT_UPDATE;
                break;
            case "ACCOUNT_CONFIG_UPDATE":
                et = UserDataUpdateEventType.ACCOUNT_CONFIG_UPDATE;
                break;
            case "ORDER_TRADE_UPDATE":
                et = UserDataUpdateEventType.ORDER_TRADE_UPDATE;
                break;
        }
        return et;
    }
}