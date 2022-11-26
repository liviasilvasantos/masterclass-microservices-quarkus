package com.liviasantos.reserva;

import com.liviasantos.cliente.Cliente;
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

    @GET
    @Path("/new-reserva")
    public Response newReserva(){
        Cliente cliente = Cliente.of(2, "Maria");
        Response response = reservaService.newReserva(Reserva.of(cliente));
        return response;
    }

}
