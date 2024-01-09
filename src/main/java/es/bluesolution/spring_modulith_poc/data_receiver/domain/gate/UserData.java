package es.bluesolution.spring_modulith_poc.data_receiver.domain.gate;

import es.bluesolution.spring_modulith_poc.framework.ddd.ValueObject;
import es.bluesolution.spring_modulith_poc.framework.exception.DomainException;
import es.bluesolution.spring_modulith_poc.framework.exception.ValidationExceptionDefaults;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class UserData implements ValueObject {

  private final String value;

  private UserData(String value) {
    if (value == null) {
      throw new NotValidResultUserDataException(ValidationExceptionDefaults.NOT_NULL);
    }
    this.value = value;
  }

  public static UserData of(String value) {
    return new UserData(value);
  }

  public static class NotValidResultUserDataException extends DomainException {

    protected NotValidResultUserDataException(String message) {
      super(message);
    }

    protected NotValidResultUserDataException(ValidationExceptionDefaults message) {
      super(message);
    }

  }

}
