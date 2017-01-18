package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.demo.client.FedexTrackerClient;
import com.demo.domain.WriteEventLog;
import com.demo.domain.WriteEventLogResponse;
import com.demo.domain.WriteEventLogReturn;
import com.demo.fedex.domain.TrackReply;

@Endpoint
@Component
public class TrackerEndpoint {
	private static final String NAMESPACE_URI = "http://demo.com/ws/track/v12";

	@Autowired
	private FedexTrackerClient fedexTrackerClient;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "writeEventLog")
	@ResponsePayload
	public WriteEventLogResponse trackFedEx(@RequestPayload WriteEventLog request) {
		WriteEventLogResponse response = new WriteEventLogResponse();
		WriteEventLogReturn eventLogReturn = new WriteEventLogReturn();

		TrackReply reply = fedexTrackerClient.trackFedEx(fedexTrackerClient.createRequest(request));
		
		
		// eventLogReturn.setHighestSeverity(reply.getHighestSeverity());

		response.setResponse(eventLogReturn);
		response.setResponse(TrackerMapper.INSTANCE.map(reply));
		// response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}

	

}
