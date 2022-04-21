package com.bts.imageclient.config;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bts.exceptions.CatalogImageDoesNotExistException;

@Provider
public class CatalogImageDoesNotExistExceptionMapper implements ExceptionMapper<CatalogImageDoesNotExistException> {
        
    @Override
    public Response toResponse(CatalogImageDoesNotExistException exception) {        
        return Response.status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).entity("{\"The CatalogImage does not exist.\"}").build();
    }
}
