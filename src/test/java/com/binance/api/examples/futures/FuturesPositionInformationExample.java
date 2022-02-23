package com.binance.api.examples.futures;

import com.binance.api.client.api.sync.BinanceApiFuturesRestClient;
import com.binance.api.client.domain.MarginType;
import com.binance.api.client.domain.account.PositionInformation;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

import java.util.List;

/**
 * Examples on how to place orders, cancel them.
 *
 * @author Mahdi Sheikh Hosseini
 */
public class FuturesPositionInformationExample {
    private static final String SYMBOL = "TOMOUSDT";
    private static final String API_KEY = "";
    private static final String SECRET_KEY = "";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory futuresApiClientFactory = BinanceAbstractFactory.createFuturesFactory(API_KEY, SECRET_KEY);
        BinanceApiFuturesRestClient client = futuresApiClientFactory.newRestClient();

        List<PositionInformation> positionList = client.getPositionInformation(SYMBOL);

        for (PositionInformation positionInformation : positionList) {
            System.out.println(positionInformation.getSymbol());
            System.out.println(positionInformation.getEntryPrice());
            System.out.println(positionInformation.getLeverage());
            System.out.println(positionInformation.getPositionSide());
            System.out.println(positionInformation.isAutoAddMargin());
            System.out.println("-----------------------------------");
        }

        System.out.println("FINISHED");

//        System.out.println(MarginType.valueOf("isolated"));
    }

}
