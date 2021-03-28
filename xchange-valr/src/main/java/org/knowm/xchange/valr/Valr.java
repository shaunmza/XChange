package org.knowm.xchange.valr;

import org.knowm.xchange.valr.dto.ValrException;
import org.knowm.xchange.valr.dto.marketdata.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("v1")
@Produces(MediaType.APPLICATION_JSON)
public interface Valr {

    @GET
    @Path("/public/{currencyPair}/marketsummary")
    ValrTicker getTicker(@PathParam("currencyPair") String market)
            throws ValrException, IOException;

    @GET
    @Path("/public/{currencyPair}/marketsummary")
    ValrMarketSummary getMarketSummary(
            @PathParam("currencyPair") String market) throws ValrException, IOException;

    @GET
    @Path("/public/currencies")
    List<ValrSymbol> getSymbols() throws ValrException, IOException;

    @GET
    @Path("/public/pairs")
    List<ValrPair> getPairs() throws ValrException, IOException;

    @GET
    @Path("/public/{currencyPair}/orderbook")
    ValrOpenOrder getBook(
            @PathParam("currencyPair") String market) throws ValrException, IOException;
}
