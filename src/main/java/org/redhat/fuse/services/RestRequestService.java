package org.redhat.fuse.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/orders/")
@Consumes(value="application/json")
@Produces(value="application/json")
public interface RestRequestService {

	@POST
	Response processRequest(@QueryParam("id") Integer requestId);
}
