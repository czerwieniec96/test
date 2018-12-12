package pl.test.rest;

import io.swagger.annotations.Api;
import pl.test.model.Mesoperation;
import pl.test.model.Mesproductxoperation;
import pl.test.model.Mesresourcexoperation;
import pl.test.repo.OperationAttachmentRepo;
import pl.test.repo.OperationRepo;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.net.URI;
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
        Mesoperation operation = operationRepo.findById(id);

        if (operation == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(operation).build();
    }
    @GET
    @Path("/rxo/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getRXO(@PathParam("id")  Integer id) {
        Mesresourcexoperation rxo = operationRepo.findResourceXoOperationsById(id);

        if (rxo == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(rxo).build();
    }
    @GET
    @Path("/pxo/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getPXO(@PathParam("id")  Integer id) {
        Mesproductxoperation pxo = operationRepo.findProductsXOpeartionsById(id);

        if (pxo == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(pxo).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOperations() {
        List<Mesoperation> operations=operationRepo.findAll();

        if (operations.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(operations).build();
    }

    @GET
    @Path("/rxo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResourcesxOperations() {
        List<Mesresourcexoperation> rxos=operationRepo.findRXOAall();

        if (rxos.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(rxos).build();
    }

    @GET
    @Path("/pxo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsXoperations() {
        List<Mesproductxoperation> pxos=operationRepo.findPXOAll();

        if (pxos.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(pxos).build();
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
    @GET
    @Path("/t/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getOperationsBytech(@PathParam("id")  Integer id) {
        List<Mesoperation> operations = operationRepo.getOperationByTechno(id);

        if (operations == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(operations).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response createOperation( Mesoperation operation, @Context UriInfo uriInfo) {
        operation = operationRepo.create(operation);
        URI createdURI = uriInfo.getBaseUriBuilder().path(operation.getIdOperation().toString()).build();
        return Response.created(createdURI).build();
    }

    @DELETE
    @Path("/{id : \\d+}")
    public Response deleteTechno(@PathParam("id") @Min(1) Integer id) {
        operationRepo.delete(id);
        return Response.noContent().build();
    }

    @POST
    @Path("/rxo")
    @Consumes(APPLICATION_JSON)
    public Response createResourceXOperation( Mesoperation operation, @Context UriInfo uriInfo) {
        operation = operationRepo.create(operation);
        URI createdURI = uriInfo.getBaseUriBuilder().path(operation.getIdOperation().toString()).build();
        return Response.created(createdURI).build();
    }

    @DELETE
    @Path("/rxo/{id : \\d+}")
    public Response deleteResourceXOperation(@PathParam("id") @Min(1) Integer id) {
        operationRepo.delete(id);
        return Response.noContent().build();
    }


    @POST
    @Path("/pxo")
    @Consumes(APPLICATION_JSON)
    public Response createProductXOperation( Mesoperation operation, @Context UriInfo uriInfo) {
        operation = operationRepo.create(operation);
        URI createdURI = uriInfo.getBaseUriBuilder().path(operation.getIdOperation().toString()).build();
        return Response.created(createdURI).build();
    }

    @DELETE
    @Path("/pxo/{id : \\d+}")
    public Response deleteProductXOperation(@PathParam("id") @Min(1) Integer id) {
        operationRepo.delete(id);
        return Response.noContent().build();
    }


}
