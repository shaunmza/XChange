package org.knowm.xchange.valr.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValrSymbol {

    private String symbol;
    private boolean isActive;
    private String shortName;
    private String longName;


    public ValrSymbol(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("isActive") boolean isActive,
            @JsonProperty("shortName") String shortName,
            @JsonProperty("longName") String longName) {

        this.symbol = symbol;
        this.isActive = isActive;
        this.shortName = shortName;
        this.longName = longName;
    }

    public String getSymbol() {

        return this.symbol;
    }

    public void setSymbol(String symbol) {

        this.symbol = symbol;
    }

    public boolean getIsActive() {

        return this.isActive;
    }

    public void setIsActive(boolean isActive) {

        this.isActive = isActive;
    }

    public String getShortName() {

        return this.shortName;
    }

    public void setShortName(String shortName) {

        this.shortName = shortName;
    }

    public String getLongName() {

        return this.longName;
    }

    public void setLongName(String longName) {

        this.longName = longName;
    }

    @Override
    public String toString() {

        return "ValrSymbol [symbol="
                + symbol
                + ", isActive="
                + isActive
                + ", shortName="
                + shortName
                + ", longName="
                + longName
                + "]";
    }
}
