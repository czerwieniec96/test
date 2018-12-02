package pl.test.rest;

import pl.test.model.Mesoperationdictionary;
import pl.test.repo.OperationDictonaryRepo;

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

@Path("/op")
public class OperationDictonaryEndpoint {

    @Inject
    OperationDictonaryRepo operationDictonaryRepo;

    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getOperation(@PathParam("id")  Integer id) {
        Mesoperationdictionary operation = operationDictonaryRepo.findById(id);

        if (operation == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(operation).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOperations() {
        List<Mesoperationdictionary> mestechnologygroups=operationDictonaryRepo.findAll();

        if (mestechnologygroups.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(mestechnologygroups).build();
    }


    @GET
    @Path("/count")
    @Produces(TEXT_PLAIN)
    public Response countOperations() {
        Long nbOfOperations = operationDictonaryRepo.countAll();

        if (nbOfOperations == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(nbOfOperations).build();
    }

    @DELETE
    @Path("/{id : \\d+}")
    public Response deleteOperations(@PathParam("id") @Min(1) Integer id) {
        operationDictonaryRepo.delete(id);
        return Response.noContent().build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response createOperation( Mesoperationdictionary mesoperationdictionary, @Context UriInfo uriInfo) {
        mesoperationdictionary = operationDictonaryRepo.create(mesoperationdictionary);
        URI createdURI = uriInfo.getBaseUriBuilder().path(mesoperationdictionary.getIdOperationDictionary().toString()).build();
        return Response.created(createdURI).build();
    }


}
