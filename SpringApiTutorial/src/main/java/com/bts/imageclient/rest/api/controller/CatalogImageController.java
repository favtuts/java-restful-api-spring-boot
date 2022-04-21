package com.bts.imageclient.rest.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.bts.imageclient.rest.api.types.CatalogImage;
import com.bts.imageclient.rest.api.types.CatalogMetaDatum;
import com.bts.imageclient.rest.api.types.util.CatalogImageTestGenerator;

import io.swagger.annotations.Api;

@Path("/images")
@Produces("application/json")
@Api(value = "CatalogImageController Resource", produces = "application/json")
public class CatalogImageController {

    @GET
    @Path("/ping")
    public String hello() {
        return "Hello from CatalogImageController";
    }

    /* API-2: Return an image with the specified image-id. */
    @GET
    @Path("/{image-id}")
    // public CatalogImage getImage(@PathParam("image-id") String imageId) {        
    //     return CatalogImageTestGenerator.generateTestImage(imageId);
    // }
    public Response getImage(@PathParam("image-id") String imageId)
    {
        CatalogImage theImage = CatalogImageTestGenerator.generateTestImage(imageId);
        Response resp = Response.status(Response.Status.OK).entity(theImage).build();
        return resp;
    }

    /* API-4: Get all images that match the metadata provided. */
    @GET
    public List<CatalogImage> getImages(@QueryParam("meta-data") List<String> imageMetadata) {
        List<CatalogMetaDatum> metaData = imageMetadata.stream().map(c -> {
            String[] nameValue = c.split("=");
            CatalogMetaDatum item = new CatalogMetaDatum();
            item.setName(nameValue[0]);
            item.setValue(nameValue[1]);
            return item;
        }).collect(Collectors.toList());

        metaData.stream().forEach(c->System.out.println(c.toString()));

        List<CatalogImage> returnImages = CatalogImageTestGenerator.generateTestImages();

        return returnImages;        
    }

    /* API-9: Fully update (overwrite) the image with the specified image-id, body includes <image-json-data> && <binary-data>*/
    @PUT
    @Path("/{image-id}")
    public CatalogImage replaceImage(@PathParam("image-id") String imageId, CatalogImage image) {
        System.out.println(image.toString());
        image.setImagePath("http://www.nowhere.com/changed-path.jpg");
        return image;
    }

    /* API-11: Update an image with the specified image-id, body includes <image-json-data> */
    @PATCH
    @Path("/{image-id}")
    public CatalogImage updateImage(@PathParam("image-id") String imageId, CatalogImage image) {
        System.out.println(image.toString());
        image.setImageId("http://www.nowhere.com/patch-path.jpg");
        CatalogMetaDatum val = image.getMetaData().get(0);
        val.setName("patch");
        val.setValue("patch-value");
        List<CatalogMetaDatum> theList = new ArrayList<CatalogMetaDatum>();
        theList.add(val);
        image.setMetaData(theList);
        return image;
    }

    /* API-13: Delete an image with the specified image-id. */
    @DELETE
    @Path("/{image-id}")
    // public Response deleteImage(@PathParam("image-id") String imageId) {return null;}
    public Response deleteImage(@PathParam("image-id") String imageId) {
        return Response.ok().entity("{\"CatalogImage deleted successfully.\"}").build();
    }
}
