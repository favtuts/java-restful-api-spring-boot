package com.bts.imageclient.SpringApiTutorial;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import com.bts.imageclient.config.CatalogImageDoesNotExistExceptionMapper;
import com.bts.imageclient.rest.api.controller.CatalogClientController;
import com.bts.imageclient.rest.api.controller.CatalogImageController;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
@ApplicationPath("/imageclient")
public class JerseyConfig extends ResourceConfig {
    
    @PostConstruct
    public void init() {
        register(CatalogImageDoesNotExistExceptionMapper.class);
        configSwagger();
        configEndPoints();
    }

    private void configEndPoints() {
        register(CatalogClientController.class);
        register(CatalogImageController.class);
    }

    private void configSwagger() {
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
        register(WadlResource.class);
        BeanConfig config = new BeanConfig();
        config.setTitle("ImageClient Tutorial API");
        config.setHost("localhost:8080");
        config.setVersion("v1");
        config.setContact("FavTuts.com");
        config.setSchemes(new String[] { "http", "https"});
        config.setBasePath("/imageclient");
        config.setResourcePackage("com.bts.imageclient.rest.api.controller");
        config.setPrettyPrint(true);
        config.setScan(true);        
    }
}
