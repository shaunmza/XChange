package org.knowm.xchange.valr.service;

import org.knowm.xchange.service.trade.params.orders.OpenOrdersParamCurrencyPair;
import org.knowm.xchange.service.trade.params.orders.OpenOrdersParams;
import org.knowm.xchange.valr.ValrUtils;
import org.knowm.xchange.valr.dto.ValrException;
import org.knowm.xchange.valr.dto.marketdata.*;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;
import java.util.List;

public class ValrMarketDataServiceRaw extends ValrBaseService {

    /**
     * Constructor
     *
     * @param exchange
     */
    public ValrMarketDataServiceRaw(Exchange exchange) {

        super(exchange);
    }

    public ValrTicker getValrTicker(CurrencyPair currencyPair) throws ValrException, IOException {
        return valr.getTicker(ValrUtils.toPairString(currencyPair));
    }

    public ValrMarketSummary getValrMarketSummary(String pair) throws ValrException, IOException {

        ValrMarketSummary result = valr.getMarketSummary(pair);
        if (result == null) {
            return null;
        }
        return result;
    }

    public List<ValrSymbol> getValrSymbols() throws IOException {

        List<ValrSymbol> result = valr.getSymbols();
        return result;
    }

    public List<ValrPair> getValrPairs() throws IOException {

        List<ValrPair> result = valr.getPairs();
        return result;
    }

    public ValrOpenOrder getValrOrderBook(String pair) throws IOException {

        return valr.getBook(pair);
    }
}



