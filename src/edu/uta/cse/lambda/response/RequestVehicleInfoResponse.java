package edu.uta.cse.lambda.response;

import edu.uta.cse.lambda.data.OwnerInfo;
import lombok.Data;

@Data
public class RequestVehicleInfoResponse {
    private String regNum;
    private OwnerInfo owner;
}
