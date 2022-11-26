package com.liviasantos.reserva;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/reservas")
public class ReservaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        final var reservas = Reserva.listAll();
        return Response.ok(reservas).build();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newReserva(final Reserva reserva) {
        reserva.id = null;
        reserva.persist();
        return Response.status(Response.Status.CREATED).entity(reserva).build();
    }
}
