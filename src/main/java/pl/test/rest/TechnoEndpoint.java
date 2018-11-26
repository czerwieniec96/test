package pl.test.rest;


import io.swagger.annotations.Api;
import pl.test.model.Mesattachmenttechnology;
import pl.test.model.Mestechnology;
import pl.test.repo.TechnoAttachmentRepo;
import pl.test.repo.TechnoRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
@Api("technology")
@Path("/t")
public class TechnoEndpoint {

    @Inject
    private TechnoRepo technoRepo;

    @Inject
    private TechnoAttachmentRepo technoAttachmentRepo;


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
    @Path("/a/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getTehnoAttachment(@PathParam("id")  Integer id) {
        Mesattachmenttechnology attachemnt = technoAttachmentRepo.findAllbyID(id);

        if (attachemnt == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(attachemnt).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTechnos() {
        List<Mestechnology> technologies = technoRepo.findAll();

        if (technologies.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(technologies).build();
    }

}
