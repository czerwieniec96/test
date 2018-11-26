package pl.test.rest;

import io.swagger.annotations.Api;
import pl.test.repo.OperationAttachmentRepo;
import pl.test.repo.OperationRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
@Api("Operation")
@Path("/O")
public class OperationEndpoint {

    @Inject
    private OperationRepo operationRepo;
    @Inject
    private OperationAttachmentRepo operationAttachmentRepo;


    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getOperation(@PathParam("id")  Integer id) {
        Object[] operation = operationRepo.findById(id).toArray();

        if (operation == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(operation).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOperations() {
        List<Object[]> operations=operationRepo.findAll();

        if (operations.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(operations).build();
    }

    @GET
    @Path("/at/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getAttachment(@PathParam("id")  Integer id) {
        Object[] attachment = operationAttachmentRepo.onefindById(id).toArray();

        if (attachment == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(attachment).build();
    }
}
