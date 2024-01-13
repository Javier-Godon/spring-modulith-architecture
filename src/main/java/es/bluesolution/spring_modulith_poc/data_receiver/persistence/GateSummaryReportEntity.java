package es.bluesolution.spring_modulith_poc.data_receiver.persistence;

import es.bluesolution.spring_modulith_poc.data_receiver.domain.gate.GateSummaryReport;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "gate_summary", schema = "analytics")
public class GateSummaryReportEntity implements Persistable<Long> {

  @Getter
  private final UUID gateId;
  @Getter
  private final Long startTime;
  @Getter
  private final Long endTime;
  @Getter
  private final String result;
  @Getter
  private final String userData;
  @Id
  private Long ts;

  @Transient
  private boolean isNew;

  @Override
  public Long getId() {
    return ts;
  }

  @Override
  public boolean isNew() {
    return this.isNew;
  }


  private GateSummaryReportEntity(UUID gateId, Long startTime, Long endTime, String result,
      String userData) {
    ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
    this.gateId = gateId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.result = result;
    this.userData = userData;
    this.ts = zdt.toInstant().toEpochMilli() * 1_000_000;
  }

  public static GateSummaryReportEntity of(GateSummaryReport gateSummaryReport) {
    return new GateSummaryReportEntity(
        gateSummaryReport.getGateId().getValue(),
        gateSummaryReport.getStartTime().getValue(),
        gateSummaryReport.getEndTime().getValue(),
        gateSummaryReport.getResult().getValue(),
        gateSummaryReport.getUserData().getValue()
    );
  }
}
