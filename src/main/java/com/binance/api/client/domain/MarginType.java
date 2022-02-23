package com.binance.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Binance futures margin types
 *
 * @author Mahdi Sheikh Hosseini
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarginType {
    ISOLATED, CROSSED;
}
