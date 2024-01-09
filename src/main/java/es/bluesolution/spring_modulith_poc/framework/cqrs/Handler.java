package es.bluesolution.spring_modulith_poc.framework.cqrs;

import reactor.core.CorePublisher;

public interface Handler<T> {

    CorePublisher<T> handle(CommandQuery commandQuery);

}
