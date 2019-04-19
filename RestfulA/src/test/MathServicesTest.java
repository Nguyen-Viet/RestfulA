package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.MyNumber;
import services.MathServices;

/**
 * 
 * @author Viet Nguyen
 *
 */
class MathServicesTest extends JerseyClient{

	private int n1, n2, value;
	private String uri;
	private MyNumber number;

	
	
	@BeforeEach
	void setUp() throws Exception {
		n1 = 1;
		n2 = 2;
		uri = "http://localhost:8080/RestfulA/math/add";
		value = n1 + n2;
		number = new MyNumber(value);
	}


	@Test
	void testAddNumberGET_ValidCreation_Pass() {
		String response = target(uri+"?n1=1&n2=2")
							.request()
							.get(String.class);
		
		int num = number.getValue();
		JSONObject expected = new JSONObject();
		expected.put("value", num);
		
		assertTrue(expected.toJSONString().equalsIgnoreCase(response));
	}
	

	@Test
	void testAddNumberPOST() {
	    Response response = target(uri)
	    					.request()
	    					.post(Entity.entity(number.toString(), "application/x-www-form-urlencoded"));
	    
	    
	    assertEquals("Http Response is 200 ", 200, response.getStatus());
	    
	}

}//end Class
