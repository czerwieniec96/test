package pl.test.rest;


import io.swagger.annotations.Api;
import pl.test.model.Mestechnologygroup;
import pl.test.repo.TechnologyGroupRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
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


}
