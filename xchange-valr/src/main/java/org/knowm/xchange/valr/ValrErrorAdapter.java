package org.knowm.xchange.valr;

import org.apache.commons.lang3.StringUtils;
import org.knowm.xchange.exceptions.CurrencyPairNotValidException;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.FundsExceededException;
import org.knowm.xchange.exceptions.RateLimitExceededException;
import org.knowm.xchange.valr.dto.ValrException;

public class ValrErrorAdapter {

  public static ExchangeException adapt(ValrException e) {
    String message = e.getMessage();
    if (StringUtils.isEmpty(message)) {
      return new ExchangeException("Operation failed without any error message", e);
    }
    if (message.contains("was throttled")) {
      return new RateLimitExceededException(message, e);
    }
    switch (message) {
      case "Unsupported Currency Pair":
        return new CurrencyPairNotValidException(e);
      case "INSUFFICIENT_FUNDS":
        return new FundsExceededException(e);
      default:
        return new ExchangeException(message, e);
    }
  }
}
