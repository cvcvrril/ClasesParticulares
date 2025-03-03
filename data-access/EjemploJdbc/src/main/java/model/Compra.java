package model;

import java.time.LocalDateTime;

public class Compra {

    private int codPro;
    private String dniCliente;
    private LocalDateTime fechaHora;
    private int cantidad;
    private String tipoPago;

    public Compra() {
    }

    public Compra(int codPro, String dniCliente, int cantidad, String tipoPago) {
        this.codPro = codPro;
        this.dniCliente = dniCliente;
        this.cantidad = cantidad;
        this.tipoPago = tipoPago;
    }

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codPro=" + codPro +
                ", dniCliente='" + dniCliente + '\'' +
                ", fechaHora=" + fechaHora +
                ", cantidad=" + cantidad +
                ", tipoPago='" + tipoPago + '\'' +
                '}';
    }
}
