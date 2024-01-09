package es.bluesolution.spring_modulith_poc.data_receiver.exceptions;

import es.bluesolution.spring_modulith_poc.framework.exception.EntityNotFoundException;

public class MonitoredElementNotFoundException extends EntityNotFoundException {

    public MonitoredElementNotFoundException(String message) {
        super(message);
    }
}
