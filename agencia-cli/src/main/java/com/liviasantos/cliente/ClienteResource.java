package com.liviasantos.cliente;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/cliente-cli")
public class ClienteResource {

    @Inject
    @RestClient
    private ClienteService clienteService;

    @GET
    @Path("/new-cliente")
    public Response newCliente(){
        Cliente cliente = Cliente.of(99, "Remoto");
        Response response = clienteService.newCliente(cliente);
        return response;
    }
}
