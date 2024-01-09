package es.bluesolution.spring_modulith_poc.data_receiver.domain.gate;

import es.bluesolution.spring_modulith_poc.framework.ddd.ValueObject;
import es.bluesolution.spring_modulith_poc.framework.exception.DomainException;
import es.bluesolution.spring_modulith_poc.framework.exception.ValidationExceptionDefaults;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class GateId implements ValueObject {

  private final UUID value;

  private GateId(UUID value) {
    if (value == null) {
      throw new NotValidGateIdException(ValidationExceptionDefaults.NOT_NULL);
    }
    this.value = value;
  }

  public static GateId of(UUID value) {
    return new GateId(value);
  }

  public static class NotValidGateIdException extends DomainException {

    protected NotValidGateIdException(String message) {
      super(message);
    }

    protected NotValidGateIdException(ValidationExceptionDefaults message) {
      super(message);
    }

  }

}
