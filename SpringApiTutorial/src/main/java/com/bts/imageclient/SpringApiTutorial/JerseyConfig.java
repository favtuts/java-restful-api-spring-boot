package com.bts.imageclient.SpringApiTutorial;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import com.bts.imageclient.rest.api.controller.CatalogImageController;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/imageclient")
public class JerseyConfig extends ResourceConfig {
    
    @PostConstruct
    public void init() {
        configEndPoints();
    }

    private void configEndPoints() {
        register(CatalogImageController.class);
    }
}
