package es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.infrastructure.rest.spec;

import es.bluesolution.spring_modulith_poc.data_receiver.usecases.store_data_from_gate.infrastructure.rest.StoreDataFromGateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

public interface StoreDataFromGateSpec {
    @Operation(summary = "Stores the summary of a pass through the gate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully created")
    })
    Mono<Object> storeDataFromGate(@RequestBody StoreDataFromGateRequest request);
}
