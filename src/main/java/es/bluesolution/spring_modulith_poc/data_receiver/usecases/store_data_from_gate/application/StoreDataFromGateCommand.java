package es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.application;

import es.bluesolution.spring_modulith_poc.framework.cqrs.CommandQuery;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreDataFromGateCommand implements CommandQuery {

  private final UUID gateId;
  private final Long startTime;
  private final Long endTime;
  private final String result;
  private final String userData;

  public StoreDataFromGateCommand(UUID gateId, Long startTime, Long endTime, String result,
      String userData) {
    this.gateId = gateId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.result = result;
    this.userData = userData;
  }
}
