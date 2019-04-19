package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.MyNumber;

@Path("/math")
public class MathServices {

	
	@GET
	@Path("/add")
	@Produces({MediaType.APPLICATION_JSON})
	public MyNumber addNumberGET( @QueryParam("n1") int n1, 
							   	  @QueryParam("n2") int n2 ) 
	{	
		int value = n1 + n2;
		
		MyNumber number = new MyNumber( value );
		System.out.println("VNNN");
		
		return number;
	}
	
	
	@POST
	@Path("/add")
	@Consumes({"application/x-www-form-urlencoded", "application/form-data"})
	@Produces(MediaType.APPLICATION_JSON)
	public MyNumber addNumberPOST( @FormParam("n1") int n1,
						  		   @FormParam("n2") int n2 ) 
	{
		int value = n1 + n2;
		
		MyNumber number = new MyNumber( value );
		
		System.out.println(value);
		return number;
	}
}
