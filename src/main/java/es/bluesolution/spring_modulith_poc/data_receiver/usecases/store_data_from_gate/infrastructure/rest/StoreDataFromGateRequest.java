package es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.infrastructure.rest;

import es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.infrastructure.rest.spec.StoreDataFromGateRequestSpec;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDataFromGateRequest implements StoreDataFromGateRequestSpec {

    private UUID gateId;
    private Long startTime;
    private Long endTime;
    private String result;
    private String userData;

}
