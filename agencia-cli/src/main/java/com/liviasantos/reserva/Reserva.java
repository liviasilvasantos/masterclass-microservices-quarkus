package com.liviasantos.reserva;

public class Reserva {

    private long idCliente;

    private Reserva(final long idCliente) {
        this.idCliente = idCliente;
    }

    public static Reserva of(final long idCliente) {
        return new Reserva(idCliente);
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
}
