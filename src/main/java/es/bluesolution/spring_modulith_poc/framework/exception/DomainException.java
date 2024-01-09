package es.bluesolution.spring_modulith_poc.framework.exception;

import lombok.Getter;

@Getter
public abstract class DomainException extends RuntimeException {

  private final String message;

  protected DomainException(String message) {
    this.message = message;
  }
  protected DomainException(ValidationExceptionDefaults exceptionDefaults) {
    this.message = exceptionDefaults.getValue();
  }

}
