package es.bluesolution.spring_modulith_poc.framework.cqrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.CorePublisher;

import java.util.Map;

public class CommandQueryMediator implements Mediator<CommandQuery> {

    private static final Logger log = LoggerFactory.getLogger(CommandQueryMediator.class);

    private final Map<String, ? extends Handler> dispatcher;

    public CommandQueryMediator(Map<String, ? extends Handler> dispatcher) {
        this.dispatcher = dispatcher;
    }

    public CorePublisher<Object> execute(CommandQuery commandQuery) {
        String concreteCommandQuery = commandQuery.getClass().getSimpleName();
        if (log.isInfoEnabled()) {
            log.trace(String.format("executed: %s", concreteCommandQuery));
        }
        return dispatcher.get(concreteCommandQuery).handle(commandQuery);
    }


}
