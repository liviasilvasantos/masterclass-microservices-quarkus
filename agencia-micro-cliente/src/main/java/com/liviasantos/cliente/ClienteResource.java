package com.liviasantos.cliente;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/clientes")
public class ClienteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        final var clientes =  Cliente.listAll();
        return Response.ok(clientes).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") final long id){
        var cliente = Cliente.findById(id);
        return Response.ok(cliente).build();
    }

    @Transactional
    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") final long id){
        Cliente.deleteById(id);
        return Response.noContent().build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCliente(final Cliente cliente){
        cliente.id = null;
        cliente.persist();
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }
}
