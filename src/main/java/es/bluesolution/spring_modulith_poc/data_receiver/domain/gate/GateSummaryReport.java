package es.bluesolution.spring_modulith_poc.data_receiver.domain.gate;

import es.bluesolution.spring_modulith_poc.framework.ddd.AggregateRoot;
import es.bluesolution.spring_modulith_poc.framework.ddd.UUIDIdentifier;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import reactor.core.publisher.Mono;

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
public class GateSummaryReport extends AggregateRoot<UUIDIdentifier> {

  private UUIDIdentifier id;
  private final GateId gateId;
  private final StartTime startTime;
  private final EndTime endTime;
  private final Result result;
  private final UserData userData;

  public GateSummaryReport(UUIDIdentifier id, GateId gateId, StartTime startTime, EndTime endTime,
      Result result, UserData userData) {
    super(id);
    this.gateId = gateId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.result = result;
    this.userData = userData;
  }


  public static GateSummaryReport of(UUIDIdentifier id, GateId gateId, StartTime startTime,
      EndTime endTime, Result result,
      UserData userData) {
    return new GateSummaryReport(id, gateId, startTime, endTime, result, userData);
  }

  public Mono<GateSummaryReport> save(GateSummaryReportRepository repository) {
    return repository.save(this);
  }
}
