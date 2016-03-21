package edu.uta.cse.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import edu.uta.cse.lambda.data.OwnerInfo;
import edu.uta.cse.lambda.requests.RequestVehicleInfo;
import edu.uta.cse.lambda.response.RequestVehicleInfoResponse;

public class VehicleLookupHandler implements RequestHandler<RequestVehicleInfo, RequestVehicleInfoResponse> {
	@Override
	public RequestVehicleInfoResponse handleRequest(RequestVehicleInfo request, Context context) {
	    LambdaLogger logger = context.getLogger();
	    logger.log("Getting request for: " + request.toString());

	    RequestVehicleInfoResponse response = new RequestVehicleInfoResponse();
	    
	    OwnerInfo owner = new OwnerInfo();
	    owner.setAddress("1800 N 107th St, Seattle, WA 98133");
	    owner.setEmail("chethan123@gmail.com");
	    owner.setPhoneNum("+1-614-586-3250");
	    owner.setRegNum("AJY3486");
	    response.setOwner(owner);
	    response.setRegNum(request.getRegNum());
		return response;
	}
	
	
	public static void main(String[] args) {
	    Client client = new Client();
	    WebResource resource = client.resource("https://a95xcw89l1.execute-api.us-east-1.amazonaws.com/prod/RequestVehicleInfo");
	    System.out.println(System.nanoTime());
	    ClientResponse response = resource.type("application/json").post(ClientResponse.class, "{\"regNum\":\"PoliceCar\"}");
	    System.out.println(System.nanoTime());
	    if(response.getStatus() != 200) {
	        System.out.println("Oops! : " + response.getStatus());
	    } else {
	        String resp = response.getEntity(String.class);
	        System.out.println("Yes: " + resp.toString());
	    }
	    System.out.println(System.nanoTime());
    }
}
