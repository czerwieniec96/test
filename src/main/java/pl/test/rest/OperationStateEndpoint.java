package pl.test.rest;

import pl.test.model.Mesoperationstate;
import pl.test.repo.OperationRepo;
import pl.test.repo.OperationStateRepo;

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

@Path("/os")
public class OperationStateEndpoint {

    @Inject
    OperationStateRepo operationStateRepo;

    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getState(@PathParam("id")  Integer id) {
        Mesoperationstate state = operationStateRepo.findById(id);

        if (state == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(state).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStates() {
        List<Mesoperationstate> states=operationStateRepo.findAll();

        if (states.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(states).build();
    }


    @DELETE
    @Path("/{id : \\d+}")
    public Response deleteState(@PathParam("id") @Min(1) Integer id) {
        operationStateRepo.delete(id);
        return Response.noContent().build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response createState( Mesoperationstate state, @Context UriInfo uriInfo) {
        state = operationStateRepo.create(state);
        URI createdURI = uriInfo.getBaseUriBuilder().path(state.getIdOperationState().toString()).build();
        return Response.created(createdURI).build();
    }
}
