package es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.application;

import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.EndTime;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateId;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateSummaryReport;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateSummaryReportRepository;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.Result;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.StartTime;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.UserData;
import es.bluesolution.spring_modulith_poc.framework.cqrs.CommandQuery;
import es.bluesolution.spring_modulith_poc.framework.cqrs.Handler;
import es.bluesolution.spring_modulith_poc.framework.cqrs.HandlerConfigurationException;
import es.bluesolution.spring_modulith_poc.framework.ddd.UUIDIdentifier;
import java.util.UUID;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Qualifier;
import reactor.core.CorePublisher;

public class StoreDataFromGateHandler implements Handler<GateSummaryReport> {

  private final GateSummaryReportRepository gateSummaryReportRepository;

  public StoreDataFromGateHandler(@Qualifier("springDataRepository") GateSummaryReportRepository gateSummaryReportRepository) {
    this.gateSummaryReportRepository = gateSummaryReportRepository;
  }

  @Override
  public CorePublisher<GateSummaryReport> handle(CommandQuery commandQuery) {

    if (!(commandQuery instanceof StoreDataFromGateCommand command)) {
      throw HandlerConfigurationException.commandQueryNotExpected(
          StoreDataFromGateCommand.class.getSimpleName(),
          commandQuery.getClass().getSimpleName());
    }
    return gateSummaryReportRepository.save(fromCommandToDomain.apply(command));


  }

  private final Function<StoreDataFromGateCommand, GateSummaryReport> fromCommandToDomain = command ->
      GateSummaryReport.builder()
          .id(UUIDIdentifier.of(UUID.randomUUID()))
          .gateId(GateId.of(command.getGateId()))
          .startTime(StartTime.of(command.getStartTime()))
          .endTime(EndTime.of(command.getEndTime()))
          .result(Result.of(command.getResult()))
          .userData(UserData.of(command.getUserData()))
          .build();


}
