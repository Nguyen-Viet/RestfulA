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

/** 
 * This class is a service class that handles HTTP operations like
 * GET, POST, DELETE, PUT.
 * 
 * Currently the only operation available is GET.
 * 
 * @author Viet Nguyen
 *
 */
@Path("/airports")
public class AirportsServices {

	private static final String REST_URI = "https://api.flightstats.com/flex/airports/rest/v1/json/active?appId=471db800&appKey=bfa5995d2f76bc9d7bd9417c16deef7e";
	
	
	/**
	 * When the user navigates to http://<server_url>/airports 
	 * this method will reach out to the location stored in REST_URI 
	 * by a GET request. The GET request fetches all active airports.
	 * 
	 * More information can be found at https://developer.flightstats.com/api-docs/airports/v1
	 * 
	 * @return a JSON representation of all active airports
	 * @throws ParseException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getActiveAirports() throws ParseException 
	{		
		Client client = ClientBuilder.newClient();
		String jsonString = client.target(REST_URI).request(MediaType.APPLICATION_JSON).get(String.class);
		
		String activeAirports = parseJSON(jsonString);
		
		return activeAirports;
	}
	
	
	/**
	 * A helper method used to parse JSON data representing active airports.
	 * The parse removes unnecessary meta-data about the active airports and
	 * reconstruct to a new JSON String containing active airports with field
	 * 'name', 'city', 'active'.
	 * 
	 * @param jsonString - the JSON String to be parse.
	 * @return a JSON String with new keys: name, city, active. 
	 * @throws ParseException
	 */
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
		}
		
		JSONObject airportsJSON = new JSONObject();
		airportsJSON.put("airports", activeAirports);
		
		return airportsJSON.toJSONString();
		
	}//end parseJSON
	
}//end Class
