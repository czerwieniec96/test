package pl.test.rest;


import pl.test.model.Mesproduct;

import pl.test.repo.ProductRepo;

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

@Path("/p")
public class ProductEndpoint {

    @Inject
    ProductRepo productRepo;

    @GET
    @Path("/{id : \\d+}")
    @Produces(APPLICATION_JSON)
    public Response getProduct(@PathParam("id")  Integer id) {
        Mesproduct mesproduct = productRepo.findById(id);

        if (mesproduct == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(mesproduct).build();
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        List<Mesproduct> products = productRepo.findAll();

        if (products.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(products).build();
    }


    @POST
    @Path("/{id : \\d+}")
    @Consumes(APPLICATION_JSON)
    public Response createProduct1(@PathParam("id") Integer id, Mesproduct mesproduct, @Context UriInfo uriInfo) {
        mesproduct = productRepo.createWithId(mesproduct,id);
        URI createdURI = uriInfo.getBaseUriBuilder().path(mesproduct.getIdProduct().toString()).build();
        return Response.created(createdURI).build();
    }
    @POST
    @Consumes(APPLICATION_JSON)
    public Response createProduct(Mesproduct mesproduct, @Context UriInfo uriInfo) {
        mesproduct = productRepo.create(mesproduct);
        URI createdURI = uriInfo.getBaseUriBuilder().path(mesproduct.getIdProduct().toString()).build();
        return Response.created(createdURI).build();
    }

    @DELETE
    @Path("/{id : \\d+}")
    public Response deleteTechno(@PathParam("id") @Min(1) Integer id) {
        productRepo.delete(id);
        return Response.noContent().build();
    }


}
