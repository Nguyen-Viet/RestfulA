package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.SyncInvoker;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@Path("/airports")
public class AirportsServices {

	private static final String REST_URI = "https://api.flightstats.com/flex/airports/rest/v1/json/active?appId=471db800&appKey=bfa5995d2f76bc9d7bd9417c16deef7e";
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getActiveAirports() throws ParseException 
	{		
		Client client = ClientBuilder.newClient();
		String jsonString = client.target(REST_URI).request(MediaType.APPLICATION_JSON).get(String.class);
		
		String activeAirports = parseJSON(jsonString);
		
		return activeAirports;
	}
	
	@SuppressWarnings("unchecked")
	private String parseJSON(String jsonString) throws ParseException 
	{
		JSONParser parse = new JSONParser();
		JSONObject jobj = (JSONObject) parse.parse(jsonString);
		JSONArray jsonArray = (JSONArray) jobj.get("airports");
		JSONArray activeAirports = new JSONArray();
		
		for(int i=0; i < jsonArray.size(); i++) 
		{
			JSONObject jsonObject = (JSONObject)jsonArray.get(i);
			
			String name = (String) jsonObject.get("name");
			String city = (String) jsonObject.get("city");
			boolean active = (boolean) jsonObject.get("active");
	
			
			JSONObject myJSONObject = new JSONObject();
			myJSONObject.put("name", name);
			myJSONObject.put("city", city);
			myJSONObject.put("active", active);
			
			activeAirports.add(myJSONObject);
			
			
			if(i>10) {
				break;
			}
		}
		
		JSONObject airportsJSON = new JSONObject();
		airportsJSON.put("airports", activeAirports);
		
		return airportsJSON.toJSONString();
		
	}
	
}
