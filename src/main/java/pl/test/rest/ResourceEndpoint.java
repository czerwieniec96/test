package pl.test.rest;


import pl.test.model.Mesresource;
import pl.test.repo.ResourceRepo;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.*;

@Path("/r")
public class ResourceEndpoint {

    @Inject
    ResourceRepo resourceRepo;

    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getResource(@PathParam("id")  Integer id) {
        Mesresource resurce = resourceRepo.findById(id);

        if (resurce == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(resurce).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResources() {
        List<Mesresource> mesresources=resourceRepo.findAll();

        if (mesresources.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(mesresources).build();
    }


    @GET
    @Path("/count")
    @Produces(TEXT_PLAIN)
    public Response countResources() {
        Long nbOfResources = resourceRepo.countAll();

        if (nbOfResources == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(nbOfResources).build();
    }

    @DELETE
    @Path("/{id : \\d+}")
    public Response deleteResource(@PathParam("id") @Min(1) Integer id) {
        resourceRepo.delete(id);
        return Response.noContent().build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response createResource( Mesresource mesresource, @Context UriInfo uriInfo) {
        mesresource = resourceRepo.create(mesresource);
        URI createdURI = uriInfo.getBaseUriBuilder().path(mesresource.getIdResource().toString()).build();
        return Response.created(createdURI).build();
    }

}
