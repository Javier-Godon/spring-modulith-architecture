package es.bluesolution.spring_modulith_poc.data_receiver.persistence.adapter;

import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.EndTime;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateId;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateSummaryReport;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateSummaryReportRepository;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.Result;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.StartTime;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.UserData;
import es.bluesolution.spring_modulith_poc.data_receiver.persistence.GateSummaryReportEntity;
import es.bluesolution.spring_modulith_poc.data_receiver.persistence.GateSummaryReportSpringRepository;
import es.bluesolution.spring_modulith_poc.framework.ddd.UUIDIdentifier;
import java.util.UUID;
import java.util.function.Function;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository("springDataRepository")
public class GateSummaryReportRepositorySpringAdapter implements GateSummaryReportRepository {

  private final GateSummaryReportSpringRepository repository;

  public GateSummaryReportRepositorySpringAdapter(GateSummaryReportSpringRepository repository) {
    this.repository = repository;
  }

  @Override
  public Mono<GateSummaryReport> save(GateSummaryReport report) {
    GateSummaryReportEntity entity = GateSummaryReportEntity.of(report);
    return repository.save(entity).map(fromEntityToDomain);
  }

  private final Function<GateSummaryReportEntity, GateSummaryReport> fromEntityToDomain = entity ->
      GateSummaryReport.builder()
          .id(UUIDIdentifier.of(UUID.randomUUID()))
          .gateId(GateId.of(entity.getGateId()))
          .startTime(StartTime.of(entity.getStartTime()))
          .endTime(EndTime.of(entity.getEndTime()))
          .result(Result.of(entity.getResult()))
          .userData(UserData.of(entity.getUserData()))
          .build();
}
