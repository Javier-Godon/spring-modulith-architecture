package es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.mediator;

import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateSummaryReportRepository;
import es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.application.StoreDataFromGateCommand;
import es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.application.StoreDataFromGateHandler;
import es.bluesolution.spring_modulith_poc.framework.cqrs.CommandQueryMediator;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreDataFromGateMediator {

  private final GateSummaryReportRepository gateSummaryReportRepository;

  public StoreDataFromGateMediator(
      @Qualifier("springDataRepository") GateSummaryReportRepository gateSummaryReportRepository) {
    this.gateSummaryReportRepository = gateSummaryReportRepository;
  }

  @Bean("storeDataFromGateRegister")
  public CommandQueryMediator updatePokemonStatusRegister() {
    final Map<String, StoreDataFromGateHandler> dispatcher;
    dispatcher = new HashMap<>();
    dispatcher.put(StoreDataFromGateCommand.class.getSimpleName(),
        new StoreDataFromGateHandler(gateSummaryReportRepository));
    return new CommandQueryMediator(dispatcher);
  }
}
