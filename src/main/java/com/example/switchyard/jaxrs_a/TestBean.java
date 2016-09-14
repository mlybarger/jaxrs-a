package com.example.switchyard.jaxrs_a;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.switchyard.component.bean.Service;

@Service(Test.class)
public class TestBean implements Test {

	Logger LOG = Logger.getLogger(TestBean.class);
	
	@Override
	public Foo execute(String parameter) {
		LOG.info("execute()");
		if (true)
			throw new WebApplicationException( Response.status(Response.Status.NOT_FOUND).entity("could not find item").build());
		return new Foo();
	}

}
