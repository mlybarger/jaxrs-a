package com.example.switchyard.jaxrs_a;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public interface TestResource {

	@GET
	public Foo execute(String parameter);
}
