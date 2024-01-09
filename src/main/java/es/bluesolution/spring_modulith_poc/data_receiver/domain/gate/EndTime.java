package es.bluesolution.spring_modulith_poc.data_receiver.domain.gate;

import es.bluesolution.spring_modulith_poc.framework.ddd.ValueObject;
import es.bluesolution.spring_modulith_poc.framework.exception.DomainException;
import es.bluesolution.spring_modulith_poc.framework.exception.ValidationExceptionDefaults;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class EndTime implements ValueObject {

  private final Long value;

  private EndTime(Long value) {
    if (value == null) {
      throw new NotValidEndTimeException(ValidationExceptionDefaults.NOT_NULL);
    }
    this.value = value;
  }

  public static EndTime of(Long value) {
    return new EndTime(value);
  }

  public static class NotValidEndTimeException extends DomainException {

    protected NotValidEndTimeException(String message) {
      super(message);
    }

    protected NotValidEndTimeException(ValidationExceptionDefaults message) {
      super(message);
    }

  }

}
