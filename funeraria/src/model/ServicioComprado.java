package model;

import java.time.LocalDateTime;

public class ServicioComprado {
    private int idServicio;
    private int idCliente;
    private LocalDateTime fechaCompra;

    public ServicioComprado(int idServicio, int idCliente, LocalDateTime fechaCompra) {
        this.idServicio = idServicio;
        this.idCliente = idCliente;
        this.fechaCompra = fechaCompra;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return "ServicioComprado{" +
                "idServicio=" + idServicio +
                ", idCliente=" + idCliente +
                ", fechaCompra=" + fechaCompra +
                '}';
    }
}
