package org.knowm.xchange.valr.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class ValrMarketSummary {

    private String currencyPair;
    private BigDecimal askPrice;
    private BigDecimal bidPrice;
    private BigDecimal lastTradedPrice;
    private BigDecimal previousClosePrice;
    private BigDecimal baseVolume;
    private BigDecimal highPrice;
    private BigDecimal lowPrice;
    private String created;
    private BigDecimal changeFromPrevious;

    public ValrMarketSummary(
            @JsonProperty("currencyPair") String currencyPair,
            @JsonProperty("askPrice") BigDecimal askPrice,
            @JsonProperty("bidPrice") BigDecimal bidPrice,
            @JsonProperty("lastTradedPrice") BigDecimal lastTradedPrice,
            @JsonProperty("previousClosePrice") BigDecimal previousClosePrice,
            @JsonProperty("baseVolume") BigDecimal baseVolume,
            @JsonProperty("highPrice") BigDecimal highPrice,
            @JsonProperty("lowPrice") BigDecimal lowPrice,
            @JsonProperty("created") String created,
            @JsonProperty("changeFromPrevious") BigDecimal changeFromPrevious) {

        this.currencyPair = currencyPair;
        this.askPrice = askPrice;
        this.bidPrice = bidPrice;
        this.created = created;
        this.lastTradedPrice = lastTradedPrice;
        this.previousClosePrice = previousClosePrice;
        this.baseVolume = baseVolume;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.created = created;
        this.changeFromPrevious = changeFromPrevious;
    }

    public String getCurrencyPair() {

        return this.currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {

        this.currencyPair = currencyPair;
    }

    public BigDecimal getAskPrice() {

        return this.askPrice;
    }

    public void setAskPrice(BigDecimal askPrice) {

        this.askPrice = askPrice;
    }

    public BigDecimal getBidPrice() {

        return this.bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {

        this.bidPrice = bidPrice;
    }

    public BigDecimal getLastTradedPrice() {

        return this.lastTradedPrice;
    }

    public void setLastTradedPrice(BigDecimal lastTradedPrice) {

        this.lastTradedPrice = lastTradedPrice;
    }

    public BigDecimal getPreviousClosePrice() {

        return this.previousClosePrice;
    }

    public void setPreviousClosePrice(BigDecimal previousClosePrice) {

        this.previousClosePrice = previousClosePrice;
    }

    public BigDecimal getBaseVolume() {

        return this.baseVolume;
    }

    public void setBaseVolume(BigDecimal baseVolume) {

        this.baseVolume = baseVolume;
    }

    public BigDecimal getHighPrice() {

        return this.highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {

        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {

        return this.lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {

        this.lowPrice = lowPrice;
    }

    public String getCreated() {

        return this.created;
    }

    public void setCreated(String created) {

        this.created = created;
    }

    public BigDecimal getChangeFromPrevious() {

        return this.changeFromPrevious;
    }

    public void setChangeFromPrevious(BigDecimal changeFromPrevious) {

        this.changeFromPrevious = changeFromPrevious;
    }

    @Override
    public String toString() {
        return "ValrMarketSummary [currencyPair="
                + currencyPair
                + ", askPrice="
                + askPrice
                + ", bidPrice="
                + bidPrice
                + ", lastTradedPrice="
                + lastTradedPrice
                + ", previousClosePrice="
                + previousClosePrice
                + ", baseVolume="
                + baseVolume
                + ", highPrice="
                + highPrice
                + ", lowPrice="
                + lowPrice
                + ", created="
                + created
                + ", changeFromPrevious="
                + changeFromPrevious
                + "]";
        }
    }
