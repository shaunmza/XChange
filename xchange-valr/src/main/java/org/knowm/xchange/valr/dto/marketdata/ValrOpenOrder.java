
package org.knowm.xchange.valr.dto.marketdata;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Asks",
    "Bids"
})
public class ValrOpenOrder {

    @JsonProperty("Asks")
    private List<ValrOpenOrderBase> asks = null;
    @JsonProperty("Bids")
    private List<ValrOpenOrderBase> bids = null;

    @JsonProperty("Asks")
    public List<ValrOpenOrderBase> getAsks() {
        return asks;
    }

    @JsonProperty("Asks")
    public void setAsks(List<ValrOpenOrderBase> asks) {
        this.asks = asks;
    }

    @JsonProperty("Bids")
    public List<ValrOpenOrderBase> getBids() {
        return bids;
    }

    @JsonProperty("Bids")
    public void setBids(List<ValrOpenOrderBase> bids) {
        this.bids = bids;
    }

}
