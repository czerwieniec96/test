package pl.test.rest;


import pl.test.model.Mestechnologygroup;
import pl.test.model.Mesusers;
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
@Path("/tg")
public class TechnologyGroupEndpoint{

    @Inject
    private TechnologyGroupRepo technologyGroupRepo;


    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getTechnologyGroup(@PathParam("id")  Integer id) {
        Object[] mestechnologygroup = technologyGroupRepo.findById(id).toArray();

        if (mestechnologygroup == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(mestechnologygroup).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTechnologyGroups() {
        List<Object[]> mestechnologygroups=technologyGroupRepo.findAll();

        if (mestechnologygroups.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(mestechnologygroups).build();
    }


}
