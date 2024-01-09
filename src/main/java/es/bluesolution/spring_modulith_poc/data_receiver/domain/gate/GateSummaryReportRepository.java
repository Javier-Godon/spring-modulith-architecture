package es.bluesolution.spring_modulith_poc.data_receiver.domain.gate;

import reactor.core.publisher.Mono;

public interface GateSummaryReportRepository {

  Mono<GateSummaryReport> save(GateSummaryReport gateSummaryReport);
}
