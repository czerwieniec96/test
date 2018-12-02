package pl.test.rest;


import io.swagger.annotations.Api;
import pl.test.model.Mestechnologygroup;
import pl.test.repo.TechnologyGroupRepo;

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
@Api("technologygorup")
@Path("/tg")
public class TechnologyGroupEndpoint{

    @Inject
    private TechnologyGroupRepo technologyGroupRepo;


    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getTechnologyGroup(@PathParam("id")  Integer id) {
        Mestechnologygroup mestechnologygroup = technologyGroupRepo.findById(id);

        if (mestechnologygroup == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(mestechnologygroup).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTechnologyGroups() {
        List<Mestechnologygroup> mestechnologygroups=technologyGroupRepo.findAll();

        if (mestechnologygroups.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(mestechnologygroups).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response createTechno( Mestechnologygroup mestechnologygroup, @Context UriInfo uriInfo) {
        mestechnologygroup = technologyGroupRepo.create(mestechnologygroup);
        URI createdURI = uriInfo.getBaseUriBuilder().path(mestechnologygroup.getIdTechnologyGroup().toString()).build();
        return Response.created(createdURI).build();
    }

    @GET
    @Path("/count")
    @Produces(TEXT_PLAIN)
    public Response countGroups() {
        Long nbOfGroups = technologyGroupRepo.countAll();

        if (nbOfGroups == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(nbOfGroups).build();
    }

    @DELETE
    @Path("/{id : \\d+}")
    public Response deleteTechnoGroup(@PathParam("id") @Min(1) Integer id) {
        technologyGroupRepo.delete(id);
        return Response.noContent().build();
    }
}
