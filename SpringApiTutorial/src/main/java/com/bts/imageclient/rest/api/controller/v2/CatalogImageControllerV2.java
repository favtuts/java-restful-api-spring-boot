package com.bts.imageclient.rest.api.controller.v2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import com.bts.imageclient.rest.api.controller.CatalogImageController;
import io.swagger.annotations.Api;

@Component
@Path("/v2/images")
@Produces("application/json")
@Api(value = "CatalogImageControllerV2 Resource", produces = "application/json")
public class CatalogImageControllerV2 extends CatalogImageController {
  
    @GET
    @Path("/{image-id}") 
    public Response getImage(@PathParam("image-id") String imageId)
    {
        return Response.ok().entity("{\"This is version Two.\"}").build();
    }
}