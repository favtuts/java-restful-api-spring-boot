package com.bts.imageclient.rest.api.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/images")
@Produces("application/json")
public class CatalogImageController {

    @GET
    @Path("/ping")
    public String hello() {
        return "Hello from CatalogImageController";
    }    
}
