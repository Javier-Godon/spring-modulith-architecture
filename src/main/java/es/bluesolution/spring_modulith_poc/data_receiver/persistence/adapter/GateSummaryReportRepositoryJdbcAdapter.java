package es.bluesolution.spring_modulith_poc.data_receiver.persistence.adapter;

import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateSummaryReport;
import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateSummaryReportRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository("jdbcRepository")
public class GateSummaryReportRepositoryJdbcAdapter implements GateSummaryReportRepository {

  @Override
  public Mono<GateSummaryReport> save(GateSummaryReport report) {
    return null;
  }
}
