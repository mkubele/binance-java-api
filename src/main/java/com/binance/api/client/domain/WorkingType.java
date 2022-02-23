package com.binance.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * price type
 *
 * @author Mahdi Sheikh Hosseini
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum WorkingType {
    CONTRACT_PRICE,
    MARK_PRICE
}
