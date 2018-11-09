package pl.test.rest;


import pl.test.model.Mestechnology;
import pl.test.model.Mestechnologygroup;
import pl.test.model.Mesusers;
import pl.test.repo.TechnoAttachmentRepo;
import pl.test.repo.TechnoRepo;
import pl.test.repo.TechnologyGroupRepo;
import pl.test.repo.UserRepo;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
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
        Object[] technology = technoRepo.findById(id).toArray();

        if (technology == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(technology).build();
    }

    @GET
    @Path("/a/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getTehnoAttachment(@PathParam("id")  Integer id) {
        Object[] attachemnt = technoAttachmentRepo.onefindById(id).toArray();

        if (attachemnt == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(attachemnt).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTehnos() {
        List<Object[]> mestechnologies=technoRepo.findAll();

        if (mestechnologies.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(mestechnologies).build();
    }

}
