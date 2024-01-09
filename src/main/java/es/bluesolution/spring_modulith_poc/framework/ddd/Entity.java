package es.bluesolution.spring_modulith_poc.framework.ddd;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@Getter
@EqualsAndHashCode
public abstract class Entity<T extends Identifier> {

  private final T id;

  protected Entity(T id) {
    this.id = Objects.requireNonNull(id);
  }

}
