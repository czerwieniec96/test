package pl.test.rest;

import io.swagger.annotations.Api;
import pl.test.model.Mesattachmentoperation;
import pl.test.model.Mesoperation;
import pl.test.model.Mesproductxoperation;
import pl.test.model.Mesresourcexoperation;
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


    @GET
    @Path("/n/{number : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getOperationByNumber(@PathParam("number")  Integer number) {
        Mesoperation operation = operationRepo.findByNumber(number);

        if (operation == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(operation).build();
    }
    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getOperationbyId(@PathParam("id")  Integer id) {
        Mesoperation operation = operationRepo.findById(id);

        if (operation == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(operation).build();
    }


    @GET
    @Path("/rxo/{idoper: \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getRXO(@PathParam("idoper")  Integer idoper) {
       List<Mesresourcexoperation> rxo = operationRepo.findResourcesByOperation(idoper);

        if (rxo == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(rxo).build();
    }

    @GET
    @Path("/pxo/{idoper: \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getPXO(@PathParam("idoper")  Integer idoper) {
       List<Mesproductxoperation> pxo = operationRepo.findProductsByOperation(idoper);

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
    public Response createOperation( Mesoperation mesoperation, @Context UriInfo uriInfo) {
        mesoperation = operationRepo.create(mesoperation);
        URI createdURI = uriInfo.getBaseUriBuilder().path(mesoperation.getIdOperation().toString()).build();
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
    public Response createResourceXOperation( Mesresourcexoperation rxo, @Context UriInfo uriInfo) {
        rxo = operationRepo.createOperationXResource(rxo);
        URI createdURI = uriInfo.getBaseUriBuilder().path(rxo.getMesresourceByIdResource().toString()).build();
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
    public Response createProductXOperation( Mesproductxoperation pxo, @Context UriInfo uriInfo) {
        pxo = operationRepo.createOperationXProduct(pxo);
        URI createdURI = uriInfo.getBaseUriBuilder().path(pxo.getIdProductXOperation().toString()).build();
        return Response.created(createdURI).build();
    }

    @DELETE
    @Path("/pxo/{id : \\d+}")
    public Response deleteProductXOperation(@PathParam("id") @Min(1) Integer id) {
        operationRepo.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/ats/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getAttachments(@PathParam("id")  Integer id) {
        List<Mesattachmentoperation> attachments = operationRepo.findAttachmentsByOperation(id);

        if (attachments.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();
        return Response.ok(attachments).build();
    }

    @GET
    @Path("/at/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getAttachmentById(@PathParam("id")  Integer id) {
        Mesattachmentoperation attachment = operationRepo.findAttachemntById(id);

        if (attachment == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(attachment).build();
    }


    @POST
    @Path("/at")
    @Consumes(APPLICATION_JSON)
    public Response createAttachment (Mesattachmentoperation attachment, @Context UriInfo uriInfo) {
        attachment = operationRepo.createAttachment(attachment);
        URI createdURI = uriInfo.getBaseUriBuilder().path(attachment.getIdAttachmentOperation().toString()).build();
        return Response.created(createdURI).build();
    }

    @DELETE
    @Path("/at/{id : \\d+}")
    public Response deleteAttachment(@PathParam("id") @Min(1) Integer id) {
        operationRepo.deleteAttachment(id);
        return Response.noContent().build();
    }
}
