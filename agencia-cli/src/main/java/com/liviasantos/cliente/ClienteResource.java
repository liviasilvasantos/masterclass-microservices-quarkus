package com.liviasantos.cliente;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cliente-cli")
public class ClienteResource {

    @Inject
    @RestClient
    private ClienteService clienteService;

    @GET
    @Path("/new-cliente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newCliente(){
        Cliente cliente = Cliente.of(99, "Remoto");
        Response response = clienteService.newCliente(cliente);
        return response;
    }

    @GET
    @Path("/find-by-id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@QueryParam("id") final long id){
        return clienteService.findById(id);
    }
}
