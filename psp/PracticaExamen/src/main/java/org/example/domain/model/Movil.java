package org.example.domain.model;

public class Movil {

    private String modelo;
    private int year;
    private int capacidad;

    public Movil() {
    }

    public Movil(String modelo, int year, int capacidad) {
        this.modelo = modelo;
        this.year = year;
        this.capacidad = capacidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
