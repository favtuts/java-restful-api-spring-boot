package com.bts.imageclient.rest.api.controller;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import com.bts.imageclient.rest.api.types.CatalogClient;
import com.bts.imageclient.rest.api.types.CatalogImage;

@Component
@Path("/clients")
@Produces("application/json")
public class CatalogClientController {

    /* API-1: Return a client with the specified client-id. */
	@GET
	@Path("/{client-id}")
	public CatalogClient getClient(@PathParam("client-id") String clientId) {
		return null;
	}

    /* API-3: Respond with all clients who match the supplied metadata. */
	@GET
	public List<CatalogClient> getClients(@QueryParam("client-metadata") List<String> clientMetadata) {
		return null;
	}

    /* API-5: Return images that match the provided image metadata for the client with the specified client-id. */
	@GET
	@Path("/{client-id}/images")
	public List<CatalogImage> getImages(@PathParam("client-id") String clientId,
			@QueryParam("image-metadata") List<String> imageMetadata) {
		return null;
	}

    /* API-6: Create a new client, body includes <client-json-data> */
	@POST
	public CatalogClient createClient(CatalogClient client) {
		return null;
	}

    /* API-7: Create a new image for the client with the specified client-id, body includes  <image-json-data> && <binary-data> */
    @POST
	@Path("/clients/{client-id}/images")
	public CatalogImage createImage(@PathParam("client-id") String clientId) {
		return null;
	}

    /* API-8: Fully update (overwrite) the client with the specified client-id, body includes <client-json-data> */
	@PUT
	@Path("/{client-id}")
	public CatalogClient replaceClient(@PathParam("client-id") String clientId, CatalogClient client) {
		return null;
	}

    /* API-10: Update a client with the specified client-id, body includes <client-json-data> */
	@PATCH
	@Path("/{client-id}")
	public CatalogClient updateClient(@PathParam("client-id") String clientId, CatalogClient client) {
		return null;
	}

    /* API-12: Delete a client with the specified client-id. */
	@DELETE
	@Path("/{client-id}")
	public Response delete(@PathParam("client-id") String clientId) {
		return null;
    }
}