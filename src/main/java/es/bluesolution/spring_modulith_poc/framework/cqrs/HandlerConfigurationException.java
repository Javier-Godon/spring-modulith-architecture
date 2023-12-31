package es.bluesolution.spring_modulith_poc.framework.cqrs;


import es.bluesolution.spring_modulith_poc.framework.exception.DomainException;

public class HandlerConfigurationException extends DomainException {

    protected HandlerConfigurationException(String message) {
        super(message);
    }

    public static HandlerConfigurationException commandQueryNotExpected(String expectedClassName,
                                                                        String givenClassName) {
        return new HandlerConfigurationException(String.format(
                "This handler sould not receive this command/query. Expected instance %s given %s",
                expectedClassName, givenClassName));
    }
}
