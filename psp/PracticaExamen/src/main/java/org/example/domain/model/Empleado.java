package org.example.domain.model;

import java.util.List;

public class Empleado {

    private int id;
    private String nombre;
    private String password;
    private String fechaNacimiento;
    private List<Movil> moviles;

    public Empleado() {
    }

    public Empleado(int id, String nombre, String password, String fechaNacimiento, List<Movil> moviles) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.moviles = moviles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Movil> getMoviles() {
        return moviles;
    }

    public void setMoviles(List<Movil> moviles) {
        this.moviles = moviles;
    }
}
