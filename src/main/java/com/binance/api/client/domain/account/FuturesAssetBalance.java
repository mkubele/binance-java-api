package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An asset balance in an Account.
 *
 * @see Account
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesAssetBalance {
    private String asset;
    private String walletBalance;
    private String unrealizedProfit;
    private String marginBalance;
    private String maintMargin;
    private String initialMargin;
    private String positionInitialMargin;
    private String openOrderInitialMargin;
    private String crossWalletBalance;
    private String crossUnPnl;
    private String availableBalance;
    private String maxWithdrawAmount;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(String walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getUnrealizedProfit() {
        return unrealizedProfit;
    }

    public void setUnrealizedProfit(String unrealizedProfit) {
        this.unrealizedProfit = unrealizedProfit;
    }

    public String getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(String marginBalance) {
        this.marginBalance = marginBalance;
    }

    public String getMaintMargin() {
        return maintMargin;
    }

    public void setMaintMargin(String maintMargin) {
        this.maintMargin = maintMargin;
    }

    public String getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(String initialMargin) {
        this.initialMargin = initialMargin;
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

    public String getCrossWalletBalance() {
        return crossWalletBalance;
    }

    public void setCrossWalletBalance(String crossWalletBalance) {
        this.crossWalletBalance = crossWalletBalance;
    }

    public String getCrossUnPnl() {
        return crossUnPnl;
    }

    public void setCrossUnPnl(String crossUnPnl) {
        this.crossUnPnl = crossUnPnl;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getMaxWithdrawAmount() {
        return maxWithdrawAmount;
    }

    public void setMaxWithdrawAmount(String maxWithdrawAmount) {
        this.maxWithdrawAmount = maxWithdrawAmount;
    }

    public static FuturesAssetBalance of(final String asset) {
        final FuturesAssetBalance assetBalance = new FuturesAssetBalance();
        assetBalance.setAsset(asset);
        return assetBalance;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asset", asset)
                .append("walletBalance", walletBalance)
                .append("unrealizedProfit", unrealizedProfit)
                .append("marginBalance", marginBalance)
                .append("maintMargin", maintMargin)
                .append("initialMargin", initialMargin)
                .append("positionInitialMargin", positionInitialMargin)
                .append("openOrderInitialMargin", openOrderInitialMargin)
                .append("crossWalletBalance", crossWalletBalance)
                .append("crossUnPnl", crossUnPnl)
                .append("availableBalance", availableBalance)
                .append("maxWithdrawAmount", maxWithdrawAmount)
                .toString();
    }
}
