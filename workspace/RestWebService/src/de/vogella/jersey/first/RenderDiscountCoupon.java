package de.vogella.jersey.first;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//POJO, no interface no extends
//Sets the path to base URL + /hello
@Path ("/renderDiscountCoupon")		
public class RenderDiscountCoupon {
	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String sendDiscountCoupon () {
		System.out.println("Hello");
		return "D663807";
	}
}