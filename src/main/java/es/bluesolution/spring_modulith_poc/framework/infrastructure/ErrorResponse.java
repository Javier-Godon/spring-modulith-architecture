package es.bluesolution.spring_modulith_poc.framework.infrastructure;

import lombok.Getter;

@Getter
public class ErrorResponse {

  private final String message;
  private final String cause;

  public ErrorResponse(String message, String cause) {
    this.message = message;
    this.cause = cause;
  }
}
