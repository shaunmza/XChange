package org.knowm.xchange.valr.service;

import java.math.BigInteger;
import javax.crypto.Mac;
import org.knowm.xchange.service.BaseParamsDigest;
import si.mazi.rescu.RestInvocation;

public class ValrDigest extends BaseParamsDigest {

  /**
   * Constructor
   *
   * @param secretKeyBase64
   * @throws IllegalArgumentException if key is invalid (cannot be base-64-decoded or the decoded
   *     key is invalid).
   */
  private ValrDigest(String secretKeyBase64) {

    super(secretKeyBase64, HMAC_SHA_512);
  }

  public static ValrDigest createInstance(String secretKeyBase64) {

    return secretKeyBase64 == null ? null : new ValrDigest(secretKeyBase64);
  }

  @Override
  public String digestParams(RestInvocation restInvocation) {

    String invocationUrl = restInvocation.getInvocationUrl();
    Mac mac = getMac();
    mac.update(invocationUrl.getBytes());

    return String.format("%0128x", new BigInteger(1, mac.doFinal()));
  }
}
