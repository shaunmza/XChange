package org.knowm.xchange.valr.service;

import org.knowm.xchange.client.ExchangeRestProxyBuilder;
import org.knowm.xchange.valr.Valr;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;
import org.knowm.xchange.valr.ValrAuthenticated;
import si.mazi.rescu.ParamsDigest;

public class ValrBaseService extends BaseExchangeService implements BaseService {

    protected final String apiKey;
    protected final ValrAuthenticated valrAuthenticated;
    protected final Valr valr;
    protected final ParamsDigest signatureCreator;

    /**
     * Constructor
     *
     * @param exchange
     */
    public ValrBaseService(Exchange exchange) {

        super(exchange);

        this.valrAuthenticated =
            ExchangeRestProxyBuilder.forInterface(
                ValrAuthenticated.class, exchange.getExchangeSpecification())
                .build();
        this.valr =
            ExchangeRestProxyBuilder.forInterface(
                Valr.class, exchange.getExchangeSpecification())
                .build();
        this.apiKey = exchange.getExchangeSpecification().getApiKey();

        this.signatureCreator =
                ValrDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
    }
}
