package model;

public class Producto {

    private int codigo;
    private String nombre;
    private double pvp;
    private int stock;
    private int categoria;

    public Producto() {
    }

    public Producto(int codigo, String nombre, double pvp, int stock, int categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pvp = pvp;
        this.stock = stock;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", pvp=" + pvp +
                ", stock=" + stock +
                ", categoria=" + categoria +
                '}';
    }
}
