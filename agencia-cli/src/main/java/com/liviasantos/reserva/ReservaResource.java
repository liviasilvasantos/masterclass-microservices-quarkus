package com.liviasantos.reserva;

import com.liviasantos.cliente.Cliente;
import com.liviasantos.cliente.ClienteService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("reserva-cli")
public class ReservaResource {

    @Inject
    @RestClient
    private ReservaService reservaService;

    @Inject
    @RestClient
    private ClienteService clienteService;

    @GET
    @Path("/new-reserva")
    public Response newReserva(){
        Cliente cliente = clienteService.findById(2).readEntity(Cliente.class);
        Response response = reservaService.newReserva(Reserva.of(cliente.getId()));
        return response;
    }

}
