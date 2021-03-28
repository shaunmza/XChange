package org.knowm.xchange.valr;

import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.valr.dto.ValrException;
import org.knowm.xchange.valr.dto.marketdata.ValrPair;
import org.knowm.xchange.valr.dto.marketdata.ValrSymbol;
import org.knowm.xchange.valr.service.ValrMarketDataService;
import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.utils.nonce.AtomicLongIncrementalTime2013NonceFactory;
import org.knowm.xchange.valr.service.ValrMarketDataServiceRaw;
import si.mazi.rescu.SynchronizedValueFactory;

import java.io.IOException;
import java.util.List;

public class ValrExchange extends BaseExchange implements Exchange {

    private SynchronizedValueFactory<Long> nonceFactory =
            new AtomicLongIncrementalTime2013NonceFactory();

    @Override
    protected void initServices() {

        this.marketDataService = new ValrMarketDataService(this);
        //this.accountService = new ValrAccountService(this);
        //this.tradeService = new ValrTradeService(this);
    }

    @Override
    public ExchangeSpecification getDefaultExchangeSpecification() {

        ExchangeSpecification exchangeSpecification =
                new ExchangeSpecification(this.getClass().getCanonicalName());
        exchangeSpecification.setSslUri("https://api.valr.com/");
        exchangeSpecification.setHost("api.valr.com");
        exchangeSpecification.setPort(80);
        exchangeSpecification.setExchangeName("Valr");
        exchangeSpecification.setExchangeDescription("Valr is a digital asset platform that allows customers to buy,"
                + "sell, store and transfer cryptocurrencies.");

        return exchangeSpecification;
    }

    @Override
    public SynchronizedValueFactory<Long> getNonceFactory() {

        return nonceFactory;
    }

    @Override
    public void remoteInit() throws IOException, ExchangeException {
        try {
            ValrMarketDataServiceRaw dataService =
                    (ValrMarketDataServiceRaw) this.marketDataService;
            List<ValrPair> valrPairs = dataService.getValrPairs();
            exchangeMetaData = ValrAdapters.adaptMetaData(valrPairs, exchangeMetaData);
        } catch (ValrException e) {
            throw ValrErrorAdapter.adapt(e);
        }
    }

}
