
package org.knowm.xchange.valr.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "side",
    "quantity",
    "price",
    "currencyPair",
    "orderCount"
})
public class ValrOpenOrderBase {

    @JsonProperty("side")
    private String side;
    @JsonProperty("quantity")
    private BigDecimal quantity;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("currencyPair")
    private String currencyPair;
    @JsonProperty("orderCount")
    private Integer orderCount;

    @JsonProperty("side")
    public String getSide() {
        return side;
    }

    @JsonProperty("side")
    public void setSide(String side) {
        this.side = side;
    }

    @JsonProperty("quantity")
    public BigDecimal getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("price")
    public BigDecimal getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @JsonProperty("currencyPair")
    public String getCurrencyPair() {
        return currencyPair;
    }

    @JsonProperty("currencyPair")
    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    @JsonProperty("orderCount")
    public Integer getOrderCount() {
        return orderCount;
    }

    @JsonProperty("orderCount")
    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

}
