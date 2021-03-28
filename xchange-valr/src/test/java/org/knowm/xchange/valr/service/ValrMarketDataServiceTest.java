package org.knowm.xchange.valr.service;

import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.exceptions.CurrencyPairNotValidException;
import org.knowm.xchange.valr.ValrExchange;
import org.junit.BeforeClass;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.valr.ValrUtils;
import org.knowm.xchange.valr.dto.ValrException;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValrMarketDataServiceTest {

    private static ValrMarketDataService marketDataService;

    @BeforeClass
    public static void setUp() {
        Exchange exchange = ExchangeFactory.INSTANCE.createExchange(ValrExchange.class.getName());
        marketDataService = (ValrMarketDataService) exchange.getMarketDataService();
    }

    @Test
    public void tickerSuccessTest() throws Exception {
        Ticker ticker = marketDataService.getTicker(new CurrencyPair("ZAR", "BTC"));
        assertThat(ticker).isNotNull();
        assertThat(ticker.getLast()).isNotNull().isPositive();
        assertThat(ticker.getHigh()).isNotNull().isPositive();
    }

    @Test
    public void tickerFailPairTest() throws Exception {
        Throwable exception =
                catchThrowable(
                        () -> marketDataService.getTicker(new CurrencyPair("ZAR", "DOGE")));
        assertThat(exception).isExactlyInstanceOf(CurrencyPairNotValidException.class);
    }

    /*@Test
    public void invalidCurrencyPairForTradesTest() throws Exception {
        Throwable excepton =
                catchThrowable(
                        () -> marketDataService.getTrades(new CurrencyPair("NOT_EXISTING_CODE", "USD")));
        assertThat(excepton).isExactlyInstanceOf(CurrencyPairNotValidException.class);
    }*/

    @Test
    public void orderBooksSuccessTest() throws Exception {
        OrderBook orderBook = marketDataService.getOrderBook(new CurrencyPair("ZAR", "BTC"));
        List<LimitOrder> asks = orderBook.getAsks();
        assertThat(asks).isNotEmpty();
        LimitOrder firstAsk = asks.get(0);
        assertThat(firstAsk.getLimitPrice()).isNotNull().isPositive();
        assertThat(firstAsk.getRemainingAmount()).isNotNull().isPositive();
    }
}
