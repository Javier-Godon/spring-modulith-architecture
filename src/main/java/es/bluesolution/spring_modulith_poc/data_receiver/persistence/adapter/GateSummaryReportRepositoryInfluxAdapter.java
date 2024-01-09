package es.bluesolution.spring_modulith_poc.data_receiver.persistence.adapter;

import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateSummaryReport;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateSummaryReportRepository;
import es.bluesolution.spring_modulith_poc.data_receiver.persistence.GateSummaryReportEntity;
import io.questdb.client.Sender;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository("influxRepository")
public class GateSummaryReportRepositoryInfluxAdapter implements GateSummaryReportRepository {

  @Value("${spring.r2dbc.url}")
  private String questdbAddress;

  @Override
  public Mono<GateSummaryReport> save(GateSummaryReport report) {
    GateSummaryReportEntity entity = GateSummaryReportEntity.of(report);
    try (Sender sender = Sender.builder()
        .address("192.168.13.69:30309")
        .build()) {
      sender.table("gate_summary_report")
          .stringColumn("gate_id", entity.getGateId().toString())
          .longColumn("start_time", entity.getStartTime())
          .longColumn("end_time", entity.getEndTime())
          .stringColumn("result", entity.getResult())
          .stringColumn("user_data", entity.getUserData())
          .at(System.nanoTime(), ChronoUnit.NANOS);
      sender.flush();
    }
    return Mono.empty();
  }

}
