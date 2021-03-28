package org.knowm.xchange.valr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import si.mazi.rescu.HttpStatusExceptionSupport;

public class ValrException extends HttpStatusExceptionSupport {

  @JsonProperty("message")
  private String message;

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
