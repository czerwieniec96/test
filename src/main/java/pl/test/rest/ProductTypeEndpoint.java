package pl.test.rest;

import pl.test.model.Mesproducttype;
import pl.test.repo.ProducTypeRepo;

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

@Path("/pt")
public class ProductTypeEndpoint {

    @Inject
    ProducTypeRepo producTypeRepo;

    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getProductypeById(@PathParam("id")  Integer id) {
        Mesproducttype type = producTypeRepo.findById(id);

        if (type == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(type).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTypes() {
        List<Mesproducttype> types=producTypeRepo.findAll();

        if (types.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(types).build();
    }
    @GET
    @Path("/n")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTypes2() {
        List<Mesproducttype> types=producTypeRepo.findAll();

        if (types.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(types).build();
    }


    @DELETE
    @Path("/{id : \\d+}")
    public Response deleteType(@PathParam("id") @Min(1) Integer id) {
        producTypeRepo.delete(id);
        return Response.noContent().build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response createType( Mesproducttype type, @Context UriInfo uriInfo) {
        type = producTypeRepo.create(type);
        URI createdURI = uriInfo.getBaseUriBuilder().path(type.getIdProductType().toString()).build();
        return Response.created(createdURI).build();
    }

}
