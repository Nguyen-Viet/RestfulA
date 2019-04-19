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


/**
 * This class is a service class that handles HTTP operations like
 * GET, POST, DELETE, PUT.
 * 
 * Currently the only operation available is GET and POST.
 * 
 * @author VietN
 *
 */
@Path("/math")
public class MathServices {

	
	/**
	 * When navigated to  http://<server_url>/math/add?n1=<numeric param 1>&n2=<numeric param 2> 
	 * this method is executed to add the two numeric parameter.
	 * 
	 * @param n1 - the 1st number from the query parameter
	 * @param n2 - the 2nd number from the query parameter
	 * @return a numeric object represented by MyNumber class
	 */
	@GET
	@Path("/add")
	@Produces({MediaType.APPLICATION_JSON})
	public MyNumber addNumberGET( @QueryParam("n1") int n1, 
							   	  @QueryParam("n2") int n2 ) 
	{	
		int value = n1 + n2;
		MyNumber number = new MyNumber( value );
		
		return number;
	}
	
	
	/**
	 * When a form is submitted to http://<server_url>/math/add 
	 * this method is executed which add two form parameters together
	 * from a POST body.
	 * 
	 * @param n1 - 1st form parameter
	 * @param n2 - 2nd form parameter
	 * @return a numeric object represented by MyNumber class
	 */
	@POST
	@Path("/add")
	@Consumes({"application/x-www-form-urlencoded", "application/form-data"})
	@Produces(MediaType.APPLICATION_JSON)
	public MyNumber addNumberPOST( @FormParam("n1") int n1,
						  		   @FormParam("n2") int n2 ) 
	{
		int value = n1 + n2;
		MyNumber number = new MyNumber( value );

		return number;
	}
	
}//end Class
