package pl.test.rest;
import com.sun.istack.internal.NotNull;
import pl.test.model.Mesusers;
import pl.test.repo.UserRepo;

import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/User")
public class UserEndpoint {


    @Inject
    private UserRepo userRepo;


    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response GetUsers(@PathParam("id")  Integer id) {
        Mesusers user = userRepo.find(id);

        if (user == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id : \\d+}")
    public Response delete(@PathParam("id") @Min(1) Integer id) {
        userRepo.delete(id);
        return Response.noContent().build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<Mesusers> mesusers=userRepo.findAll();

        if (mesusers.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(mesusers).build();
    }

    @DELETE
    @Path("/d/{id : \\d+}")
    public Response deleteBook(@PathParam("id") @Min(1) Integer id) {
        userRepo.delete(id);
        return Response.noContent().build();
    }
}

