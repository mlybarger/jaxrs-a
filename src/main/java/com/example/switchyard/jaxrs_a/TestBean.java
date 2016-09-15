package com.example.switchyard.jaxrs_a;

import java.util.Random;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
//import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(Test.class)
public class TestBean implements Test {

	Logger LOG = Logger.getLogger(TestBean.class);
	
	Random random = new Random();
	
	@Inject
	@Reference
	Route route;
	
	@Override
	public Foo execute(String parameter) {
		LOG.info("execute() - start");
		if (random.nextInt(2) == 1)
			throw new WebApplicationException( Response.status(Response.Status.NOT_FOUND).entity("could not find item").build());
		String resp = route.process(parameter);
		LOG.info("execute() - done");
		return new Foo();
	}

}
