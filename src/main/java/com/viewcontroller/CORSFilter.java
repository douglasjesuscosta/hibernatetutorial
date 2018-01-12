package com.viewcontroller;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ContainerResponse;





public class CORSFilter implements ContainerResponseFilter {

//    public ContainerResponse filter(ContainerRequest containerRequest,
//	    ContainerResponse containerResponse) {
//    	
//	ResponseBuilder responseBuilder = Response.fromResponse(containerResponse.getResponse());
//
//		responseBuilder.header("Access-Control-Allow-Origin", "*");
//		responseBuilder.header("Access-Control-Allow-Methods", 
//                "POST, GET, OPTIONS");
//		responseBuilder.header("Access-Control-Allow-Headers", 
//                "Foo-Header");
//        responseBuilder.header("Access-Control-Max-Age",
//                "86400");
//
//	containerResponse.setResponse(responseBuilder.build());
//
//	return containerResponse;
//    }

	@Override
	public void filter(ContainerRequestContext crequest, ContainerResponseContext cresponse) throws IOException {
			MultivaluedMap<String, Object> headers = cresponse.getHeaders();

	        headers.add("Access-Control-Allow-Origin", "*");    
	        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");         
	        headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type,");
	}


}