package es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.infrastructure.rest;

import es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.application.StoreDataFromGateCommand;
import es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.infrastructure.rest.spec.StoreDataFromGateSpec;
import es.bluesolution.spring_modulith_poc.framework.cqrs.CommandQueryMediator;
import java.util.function.Function;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/analytics/gate/crossing")
public class StoreDataFromGateResource implements StoreDataFromGateSpec {

  private final CommandQueryMediator mediator;

  public StoreDataFromGateResource(CommandQueryMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Object> storeDataFromGate(@RequestBody StoreDataFromGateRequest request) {
    StoreDataFromGateCommand command = fromRequestToCommand.apply(request);
    Publisher<Object> publisher = mediator.execute(command);
    return Mono.empty();
//    return Mono.from(publisher);
  }

  private final Function<StoreDataFromGateRequest, StoreDataFromGateCommand> fromRequestToCommand = request ->
      StoreDataFromGateCommand.builder()
          .gateId(request.getGateId())
          .startTime(request.getStartTime())
          .endTime(request.getEndTime())
          .result(request.getResult())
          .userData(request.getUserData())
          .build();
}
