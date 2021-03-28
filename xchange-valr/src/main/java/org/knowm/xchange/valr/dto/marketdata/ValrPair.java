package org.knowm.xchange.valr.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValrPair {

    private String symbol;
    private String baseCurrency;
    private String quoteCurrency;
    private String shortName;
    private boolean active;
    private Number minBaseAmount;
    private Number maxBaseAmount;
    private Number minQuoteAmount;
    private Number maxQuoteAmount;

    public ValrPair(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("baseCurrency") String baseCurrency,
            @JsonProperty("quoteCurrency") String quoteCurrency,
            @JsonProperty("shortName") String shortName,
            @JsonProperty("active") boolean active,
            @JsonProperty("minBaseAmount") Number minBaseAmount,
            @JsonProperty("maxBaseAmount") Number maxBaseAmount,
            @JsonProperty("minQuoteAmount") Number minQuoteAmount,
            @JsonProperty("maxQuoteAmount") Number maxQuoteAmount) {

        this.symbol = symbol;
        this.baseCurrency = baseCurrency;
        this.quoteCurrency = quoteCurrency;
        this.shortName = shortName;
        this.active = active;
        this.minBaseAmount = minBaseAmount;
        this.maxBaseAmount = maxBaseAmount;
        this.minQuoteAmount = minQuoteAmount;
        this.maxQuoteAmount = maxQuoteAmount;
    }

    public String getSymbol() {

        return this.symbol;
    }

    public void setSymbol(String symbol) {

        this.symbol = symbol;
    }

    public String getBaseCurrency() {

        return this.baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {

        this.baseCurrency = baseCurrency;
    }

    public String getQuoteCurrency() {

        return this.quoteCurrency;
    }

    public void setQuoteCurrency(String quoteCurrency) {

        this.quoteCurrency = quoteCurrency;
    }

    public String getShortName() {

        return this.shortName;
    }

    public void setShortName(String shortName) {

        this.shortName = shortName;
    }

    public boolean getActive() {

        return this.active;
    }

    public void setActive(boolean active) {

        this.active = active;
    }

    public Number getMinBaseAmount() {

        return this.minBaseAmount;
    }

    public void setMinBaseAmount(Number minBaseAmount) {

        this.minBaseAmount = minBaseAmount;
    }

    public Number getMaxBaseAmount() {

        return this.maxBaseAmount;
    }

    public void setMaxBaseAmount(Number maxBaseAmount) {

        this.maxBaseAmount = maxBaseAmount;
    }

    public Number getMinQuoteAmount() {

        return this.minQuoteAmount;
    }

    public void setMinQuoteAmount(Number minQuoteAmount) {

        this.minQuoteAmount = minQuoteAmount;
    }
    public Number getMaxQuoteAmount() {

        return this.maxQuoteAmount;
    }

    public void setMaxQuoteAmount(Number maxQuoteAmount) {

        this.maxQuoteAmount = maxQuoteAmount;
    }

    /*
    "symbol": "BTCZAR",
"baseCurrency": "BTC",
"quoteCurrency": "ZAR",
"shortName": "BTC/ZAR",
"active": true,
"minBaseAmount": "0.0001",
"maxBaseAmount": "2",
"minQuoteAmount": "10",
"maxQuoteAmount": "100000"

 */
    @Override
    public String toString() {

        return "ValrSymbol [symbol="
                + symbol
                + ", baseCurrency="
                + baseCurrency
                + ", quoteCurrency="
                + quoteCurrency
                + ", shortName="
                + shortName
                + ", active="
                + active
                + ", minBaseAmount="
                + minBaseAmount
                + ", maxBaseAmount="
                + maxBaseAmount
                + ", minQuoteAmount="
                + minQuoteAmount
                + ", maxQuoteAmount="
                + maxQuoteAmount
                + "]";
    }
}
