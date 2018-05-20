package com.jaxrs.queryparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/customers")
public class RestServiceQueryParam {
	
	@GET
    @Produces("text/html")
	public Response getResultByPassingValue(
			@QueryParam("nameKey") String name,
            @QueryParam("countryKey") String country) {
			String output = "Customer name - "+name+", Country - "+country+"";
			return Response.status(200).entity(output).build();
	}
}
