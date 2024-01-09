package es.bluesolution.spring_modulith_poc.data_receiver.domain.gate;

import es.bluesolution.spring_modulith_poc.framework.ddd.ValueObject;
import es.bluesolution.spring_modulith_poc.framework.exception.DomainException;
import es.bluesolution.spring_modulith_poc.framework.exception.ValidationExceptionDefaults;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class Result implements ValueObject {

  private final String value;

  private Result(String value) {
    if (value == null) {
      throw new NotValidResultException(ValidationExceptionDefaults.NOT_NULL);
    }
    this.value = value;
  }

  public static Result of(String value) {
    return new Result(value);
  }

  public static class NotValidResultException extends DomainException {

    protected NotValidResultException(String message) {
      super(message);
    }

    protected NotValidResultException(ValidationExceptionDefaults message) {
      super(message);
    }

  }

}
