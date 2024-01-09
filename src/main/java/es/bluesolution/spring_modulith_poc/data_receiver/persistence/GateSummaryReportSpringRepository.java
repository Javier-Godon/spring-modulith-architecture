package es.bluesolution.spring_modulith_poc.data_receiver.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.util.UUID;

public interface GateSummaryReportSpringRepository extends R2dbcRepository<GateSummaryReportEntity, UUID> {
}
