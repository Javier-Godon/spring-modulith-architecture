package es.bluesolution.spring_modulith_poc.framework.cqrs;

public interface Mediator<T> {
  Object execute(T commandQuery);
}
