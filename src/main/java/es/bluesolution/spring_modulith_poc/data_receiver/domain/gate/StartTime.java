package es.bluesolution.spring_modulith_poc.data_receiver.domain.gate;

import es.bluesolution.spring_modulith_poc.framework.ddd.ValueObject;
import es.bluesolution.spring_modulith_poc.framework.exception.DomainException;
import es.bluesolution.spring_modulith_poc.framework.exception.ValidationExceptionDefaults;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class StartTime implements ValueObject {

  private final Long value;

  private StartTime(Long value) {
    if (value == null) {
      throw new NotValidStartTimeException(ValidationExceptionDefaults.NOT_NULL);
    }
    this.value = value;
  }

  public static StartTime of(Long value) {
    return new StartTime(value);
  }

  public static class NotValidStartTimeException extends DomainException {

    protected NotValidStartTimeException(String message) {
      super(message);
    }

    protected NotValidStartTimeException(ValidationExceptionDefaults message) {
      super(message);
    }

  }

}
