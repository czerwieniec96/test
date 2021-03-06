package pl.test.rest;


import pl.test.model.Mesattachmenttechnology;
import pl.test.model.Mestechnology;
import pl.test.repo.TechnoRepo;

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

@Path("/t")
public class TechnoEndpoint {

    @Inject
    private TechnoRepo technoRepo;


    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getTehno(@PathParam("id")  Integer id) {
        Mestechnology technology = technoRepo.findById(id);

        if (technology == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(technology).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTechnos() {
        List<Mestechnology> technologies = technoRepo.findAll();

        if (technologies.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(technologies).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response createTechno( Mestechnology technology, @Context UriInfo uriInfo) {
        technology = technoRepo.create(technology);
        URI createdURI = uriInfo.getBaseUriBuilder().path(technology.getIdTechnology().toString()).build();
        return Response.created(createdURI).build();
    }

    @DELETE
    @Path("/{id : \\d+}")
    public Response deleteTechno(@PathParam("id") @Min(1) Integer id) {
        technoRepo.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/ats/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getAttachments(@PathParam("id")  Integer id) {
        List<Mesattachmenttechnology> attachments = technoRepo.findAttachmentsByTechnology(id);

        if (attachments.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();
        return Response.ok(attachments).build();
    }
    @GET
    @Path("/at/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getAttachmentById(@PathParam("id")  Integer id) {
        Mesattachmenttechnology attachment = technoRepo.findAttachemntById(id);

        if (attachment == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(attachment).build();
    }

    @POST
    @Path("/at")
    @Consumes(APPLICATION_JSON)
    public Response createAttachment (Mesattachmenttechnology attachment, @Context UriInfo uriInfo) {
        attachment = technoRepo.createAttachment(attachment);
        URI createdURI = uriInfo.getBaseUriBuilder().path(attachment.getIdAttachmentTechnology().toString()).build();
        return Response.created(createdURI).build();
    }

    @DELETE
    @Path("/at/{id : \\d+}")
    public Response deleteAttachment(@PathParam("id") @Min(1) Integer id) {
        technoRepo.deleteAttachment(id);
        return Response.noContent().build();
    }
}
