package com.techdispatch.resource;

import com.techdispatch.model.Intervention;
import com.techdispatch.service.InterventionService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/interventions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InterventionResource {

    @Inject
    InterventionService service;

    @GET
    public List<Intervention> list(@QueryParam("statut") String statut) {
        return service.findAll(statut);
    }

    @GET @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return service.findById(id)
                .map(i -> Response.ok(i).build())
                .orElse(Response.status(404).build());
    }

    @POST
    public Response create(@Valid Intervention i) {
        Intervention created = service.create(i);
        return Response.status(201).entity(created).build();
    }

    @DELETE @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return service.delete(id) ? Response.noContent().build() : Response.status(404).build();
    }
}
