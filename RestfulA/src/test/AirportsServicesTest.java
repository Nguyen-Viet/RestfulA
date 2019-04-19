package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClient;


class AirportsServicesTest extends JerseyClient{

	private String uri;
	
	@BeforeEach
	void setUp() throws Exception {
		uri = "https://api.flightstats.com/flex/airports/rest/v1/json/active?appId=471db800&appKey=bfa5995d2f76bc9d7bd9417c16deef7e";
	}



	@Test
	void testGetActiveAirports() {
		  Response response = target(uri).request().get();
		  assertEquals("should return status 200", 200, response.getStatus());
	
	}

}
