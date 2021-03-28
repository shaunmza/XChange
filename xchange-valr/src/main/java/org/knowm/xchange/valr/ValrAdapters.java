package org.knowm.xchange.valr;

import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.valr.dto.marketdata.*;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public final class ValrAdapters {

    public static final Logger log = LoggerFactory.getLogger(ValrAdapters.class);

    private ValrAdapters() {}

    public static Ticker adaptTicker(ValrMarketSummary marketSummary, CurrencyPair currencyPair) {

        BigDecimal last = marketSummary.getLastTradedPrice();
        BigDecimal bid = marketSummary.getBidPrice();
        BigDecimal ask = marketSummary.getAskPrice();
        BigDecimal high = marketSummary.getHighPrice();
        BigDecimal low = marketSummary.getLowPrice();
        BigDecimal volume = marketSummary.getBaseVolume();

        Date timestamp = ValrUtils.toDate(marketSummary.getCreated());

        return new Ticker.Builder()
                .currencyPair(currencyPair)
                .last(last)
                .bid(bid)
                .ask(ask)
                .high(high)
                .low(low)
                .volume(volume)
                .timestamp(timestamp)
                .build();
    }

    public static ExchangeMetaData adaptMetaData(
            List<ValrPair> rawPairs, ExchangeMetaData metaData) {

        List<CurrencyPair> currencyPairs = ValrAdapters.adaptCurrencyPairs(rawPairs);

        Map<CurrencyPair, CurrencyPairMetaData> pairsMap = metaData.getCurrencyPairs();
        Map<Currency, CurrencyMetaData> currenciesMap = metaData.getCurrencies();
        for (CurrencyPair c : currencyPairs) {
            if (!pairsMap.containsKey(c)) {
                pairsMap.put(c, null);
            }
            if (!currenciesMap.containsKey(c.base)) {
                currenciesMap.put(c.base, null);
            }
            if (!currenciesMap.containsKey(c.counter)) {
                currenciesMap.put(c.counter, null);
            }
        }

        return metaData;
    }

    public static List<CurrencyPair> adaptCurrencyPairs(Collection<ValrPair> valrPair) {

        List<CurrencyPair> currencyPairs = new ArrayList<>();
        for (ValrPair pair : valrPair) {
            currencyPairs.add(adaptCurrencyPair(pair));
        }
        return currencyPairs;
    }

    public static CurrencyPair adaptCurrencyPair(ValrPair valrPair) {

        String baseSymbol = valrPair.getQuoteCurrency();
        String counterSymbol = valrPair.getBaseCurrency();
        return new CurrencyPair(baseSymbol, counterSymbol);
    }

    public static List<LimitOrder> adaptOrders(
            List<ValrOpenOrderBase> orders, CurrencyPair currencyPair, String orderType, String id) {

        if (orders == null) {
            return new ArrayList<>();
        }

        List<LimitOrder> limitOrders = new ArrayList<>(orders.size());

        for (ValrOpenOrderBase order : orders) {
            limitOrders.add(adaptOrder(order.getQuantity(), order.getPrice(), currencyPair, orderType, null));
        }

        return limitOrders;
    }

    public static LimitOrder adaptOrder(
            BigDecimal amount,
            BigDecimal price,
            CurrencyPair currencyPair,
            String orderTypeString,
            String id) {

        Order.OrderType orderType = orderTypeString.equalsIgnoreCase("bid") ? Order.OrderType.BID : Order.OrderType.ASK;

        return new LimitOrder(orderType, amount, currencyPair, id, null, price);
    }

}
