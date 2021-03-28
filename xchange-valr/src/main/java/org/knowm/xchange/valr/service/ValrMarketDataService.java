package org.knowm.xchange.valr.service;

import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.service.trade.params.orders.DefaultOpenOrdersParamCurrencyPair;
import org.knowm.xchange.service.trade.params.orders.OpenOrdersParams;
import org.knowm.xchange.valr.ValrAdapters;
import org.knowm.xchange.valr.ValrErrorAdapter;
import org.knowm.xchange.valr.ValrUtils;
import org.knowm.xchange.valr.dto.ValrException;
import org.knowm.xchange.valr.dto.marketdata.ValrMarketSummary;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.valr.dto.marketdata.ValrOpenOrder;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.List;

public class ValrMarketDataService extends ValrMarketDataServiceRaw
        implements MarketDataService {
    /**
     * Constructor
     *
     * @param exchange
     */
    public ValrMarketDataService(Exchange exchange) {

        super(exchange);
    }

    @Override
    public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {
        try {
            ValrMarketSummary summary =
                    getValrMarketSummary(ValrUtils.toPairString(currencyPair));
            if (summary == null) {
                throw new ExportException("Valr didn't return any summary nor an error");
            }
            return ValrAdapters.adaptTicker(summary, currencyPair);
        } catch (ValrException e) {
            throw ValrErrorAdapter.adapt(e);
        }
    }

    @Override
    public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws IOException {
        try {

            ValrOpenOrder valrOpenOrder =
                    getValrOrderBook(ValrUtils.toPairString(currencyPair));

            List<LimitOrder> asks =
                    ValrAdapters.adaptOrders(valrOpenOrder.getAsks(), currencyPair, "ask", "");
            List<LimitOrder> bids =
                    ValrAdapters.adaptOrders(valrOpenOrder.getBids(), currencyPair, "bid", "");

            return new OrderBook(null, asks, bids);
        } catch (ValrException e) {
            throw ValrErrorAdapter.adapt(e);
        }
    }
}
