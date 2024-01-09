package es.bluesolution.spring_modulith_poc.framework.exception;

public class EntityNotFoundException extends DomainException{

  protected EntityNotFoundException(String message) {
    super(message);
  }
}
